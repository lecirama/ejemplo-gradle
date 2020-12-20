pipeline {
    agent any
    stages {
        stage('stage_Incial'){
            steps {
                script{
                    stage('build & Test'){
                        sh './gradlew clean build'
                    }
                    stage('sonar'){
                        def scannerHome = tool 'sonar';
                        withSonarQubeEnv('sonar') {
                            sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
                        }

                    }
                    stage('run'){
                        sh "nohup bash gradlew bootRun &"
                        sleep(10)
                    }
                    stage('rest'){

                        sh "curl -X GET http://localhost:8086/rest/mscovid/test?msg=testing"
                         sleep(5)

                    }
                    stage('Upload Nexus'){
                               nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: '/Users/maricelrodriguez/.jenkins/workspace/ultib_gradle_feature-dir-inicial/build/libs/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '1.0.0']]]                           }
                         }
                    }
                } 
            }
         }
}  
