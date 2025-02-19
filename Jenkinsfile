pipeline {
	agent none
    parameters {
		string(name: 'NAME1', defaultValue: 'Alice', description: 'Primer nombre')
        string(name: 'NAME2', defaultValue: 'Bob', description: 'Segundo nombre')
        string(name: 'NAME3', defaultValue: 'Charlie', description: 'Tercer nombre')
        string(name: 'NAME4', defaultValue: 'David', description: 'Cuarto nombre')
        string(name: 'NAME5', defaultValue: 'Eve', description: 'Quinto nombre')
    }

    stages {
		stage('Clean Workspace') {
			steps {
				script {
					// Elimina los archivos en el directorio actual
                    sh 'rm -rf *'
                }
            }
        }
		stage('Parallel Execution') {
			parallel {
				stage('principal') {
					agent { label 'principal' }
                    steps {
						script {
							sh "./script1.sh ${params.NAME1}"
                        }
                    }
                }
                stage('Agent 2') {
					agent { label '2' }
                    steps {
						script {
							sh "./script2.sh ${params.NAME2}"
                        }
                    }
                }
                stage('Agent 3') {
					agent { label '3' }
                    steps {
						script {
							sh "./script3.sh ${params.NAME3}"
                        }
                    }
                }
                stage('Agent 4') {
					agent { label '4' }
                    steps {
						script {
							sh "./script4.sh ${params.NAME4}"
                        }
                    }
                }
                stage('Agent 5') {
					agent { label '5' }
                    steps {
						script {
							sh "./script5.sh ${params.NAME5}"
                        }
                    }
                }
            }
        }
    }
}
