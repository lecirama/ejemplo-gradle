pipeline {
    agent any

    stages {
        stage('stage_Incial'){
            steps {
                script{
                    stage('build & Test'){


                    }
                    stage('sonar'){
                        def scannerHome = tool 'sonar';
                        withSonarQubeEnv('sonar') {
                            sh "$(scannerHome)/bin/sonar-scanner"
                        }

                    }
                     stage('run'){

                    }
                    stage('test'){

                    }
                     stage('nexus'){

                    }
                } 

            }
         }
    }
}          