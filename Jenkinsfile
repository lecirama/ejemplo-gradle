pipeline {
    agent any
    /*parameters {
        choice(name: 'eleccion', choices: ['Gradle', 'Maven'], description: 'Herramientas de Construcción')
    }*/
    stages {
        stage('Pineline') {
            steps {
                script{
                   //Invocacion al archivo dependiendo del paramentro generado
                    switch(params.eleccion){
                        case 'Gradle';
                            //llamada a gradle.grovy
                            def ejecucion = load 'gradle.groovy'
                            ejecucion.call()
                        break
                        default;
                            //llamar a maven.grovy
                            def ejecucion = load 'maven.groovy'
                            ejecucion.call()
                        break
                    }
            }
        }
    }
}
}
