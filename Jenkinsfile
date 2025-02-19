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

        stage('Execution') {  // Sin paralelismo aquí
			steps {
			script {
				sh "java -cp target/15times-1.0-SNAPSHOT.jar com.example.App ${params.NAME}"
                }
            }
        }
    }
}
