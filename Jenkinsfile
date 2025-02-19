pipeline {
	agent none  // No se usará un agente globalmente

    parameters {
		string(name: 'NAME1', defaultValue: 'Alice', description: 'Primer nombre')
        string(name: 'NAME2', defaultValue: 'Bob', description: 'Segundo nombre')
        string(name: 'NAME3', defaultValue: 'Charlie', description: 'Tercer nombre')
        string(name: 'NAME4', defaultValue: 'David', description: 'Cuarto nombre')
        string(name: 'NAME5', defaultValue: 'Eve', description: 'Quinto nombre')
    }

    stages {
		stage('Clean Workspace') {
			agent any  // Utiliza cualquier agente para limpiar el workspace
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
							node('principal') {
								sh "./script1.sh ${params.NAME1}"
                            }
                        }
                    }
                }
                stage('Agent 2') {
					agent { label '2' }
                    steps {
						script {
							node('2') {
								sh "./script2.sh ${params.NAME2}"
                            }
                        }
                    }
                }
                stage('Agent 3') {
					agent { label '3' }
                    steps {
						script {
							node('3') {
								sh "./script3.sh ${params.NAME3}"
                            }
                        }
                    }
                }
                stage('Agent 4') {
					agent { label '4' }
                    steps {
						script {
							node('4') {
								sh "./script4.sh ${params.NAME4}"
                            }
                        }
                    }
                }
                stage('Agent 5') {
					agent { label '5' }
                    steps {
						script {
							node('5') {
								sh "./script5.sh ${params.NAME5}"
                            }
                        }
                    }
                }
            }
        }
    }
}
