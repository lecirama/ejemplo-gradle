pipeline {
    agent any
        parameters {
            choice(name: 'eleccion', choices: ['Gradle', 'Maven'], description: 'Herramientas de Construcción')
        }
    stages {
        stage('Pineline') {
            steps {
                script{
                   //Invocacion al archivo dependiendo del paramentro generado
                    def build=(params.eleccion == 'Gradle') ? 'gradle.groovy' : 'maven.groovy'
                    def ejecucion = load build
                    ejecucion.call()
                 }
            }
        }
    }
}
