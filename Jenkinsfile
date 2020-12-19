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
                        sh 'nohup bash gradlew bootRun &'
                    }
                    stage('rest'){

                        sh 'curl -x GET http://localhost:8082/rest/mscovid/test?msg=testing'
                         sleep(20)

                    }
                    stage('Upload Nexus') {
                            steps {
                                nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: '/Users/maricelrodriguez/Diplomado/Repositorio/ejemplo-gradle/build/libs/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]], tagName: 'jar'   
                            }
                         }
                    }
                } 
            }
         }
}  