pipeline {
	agent any

    parameters {
		string(name: 'NAME', defaultValue: 'DefaultName', description: 'Name to print')
    }

    tools {
		maven 'Maven 3'
}

    stages {
		stage('Build') {
			steps {
				script {
					sh 'mvn clean package'
                }
            }
        }

        stage('Parallel Execution') {
			steps {
				script {
					def tasks = [:]

                    for (int i = 1; i <= 5; i++) { // Crea 5 procesos en paralelo
                        def instance = i
                        tasks["Task ${instance}"] = {
						sh "java -cp target/15times-1.0-SNAPSHOT.jar com.miempresa.ParallelPrinter ${params.NAME}"
                        }
                    }

                    parallel tasks
                }
            }
        }
    }
}
