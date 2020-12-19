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

                    }
                    stage('rest'){

                    }
                     stage('nexus'){

                    }
                } 

            }
         }
    }
}          