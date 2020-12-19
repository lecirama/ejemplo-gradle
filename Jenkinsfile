pipeline {
    agent any

    stages {
        
        stage('Compile_Code,Test_Code,Jar_Code') {
            steps {
                        
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
        
            sh 'curl -X GET http://localhost:8081/rest/mscovid/test?msg=testing'
        
            }
        }
    }
   }