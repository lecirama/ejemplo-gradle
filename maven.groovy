/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/
def call(){
  		stage('Compile_Code') {
            steps {
            sh './mvnw clean compile -e'       
            }
        }   
        stage('Test_Code') {
            steps {
            sh './mvnw clean test -e'     
            }
        }
        stage('Jar_Code') {
            steps {
            sh './mvnw clean package -e'       
            }
        }
    stage('SonarQube') {
        steps {
            withSonarQubeEnv('sonar') { // You can override the credential to be used
            sh './mvnw org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
            }
        	}
    	}   
        stage('Run_Jar') {
            steps {
            sh 'nohup ./mvnw spring-boot:run &'      
            }
        } 
        stage('Testing_App') {
        	steps {
        	sleep 20
            sh 'curl -X GET http://localhost:8086/rest/mscovid/test?msg=testing'
            }
        }
        stage('Upload Nexus'){
        nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: '/Users/maricelrodriguez/.jenkins/workspace/ultib_gradle_feature-dir-inicial/build/libs/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '1.0.0']]]
    	}

 }
return this;