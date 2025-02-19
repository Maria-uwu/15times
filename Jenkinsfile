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
							// Aquí va el comando que quieres ejecutar directamente en el agente 'principal'
                            sh """
                                echo "Hola, ${params.NAME1}! Este es el script 1 en el agente principal"
                            """
                        }
                    }
                }
                stage('Agent 2') {
					agent { label '2' }
                    steps {
						script {
							// Aquí va el comando que quieres ejecutar directamente en el agente '2'
                            sh """
                                echo "Hola, ${params.NAME2}! Este es el script 2 en el agente 2"
                            """
                        }
                    }
                }
                stage('Agent 3') {
					agent { label '3' }
                    steps {
						script {
							// Aquí va el comando que quieres ejecutar directamente en el agente '3'
                            sh """
                                echo "Hola, ${params.NAME3}! Este es el script 3 en el agente 3"
                            """
                        }
                    }
                }
                stage('Agent 4') {
					agent { label '4' }
                    steps {
						script {
							// Aquí va el comando que quieres ejecutar directamente en el agente '4'
                            sh """
                                echo "Hola, ${params.NAME4}! Este es el script 4 en el agente 4"
                            """
                        }
                    }
                }
                stage('Agent 5') {
					agent { label '5' }
                    steps {
						script {
							// Aquí va el comando que quieres ejecutar directamente en el agente '5'
                            sh """
                                echo "Hola, ${params.NAME5}! Este es el script 5 en el agente 5"
                            """
                        }
                    }
                }
            }
        }
    }
}
