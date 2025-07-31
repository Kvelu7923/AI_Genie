pipeline {
    agent any

    environment {
        TIMESTAMP = "${new Date().format('dd-MMM-yyyy_HH-mm-ss')}"
        REPORT_DIR = "reports\\${env.TIMESTAMP}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Set Build Display Name') {
            steps {
                script {
                    currentBuild.displayName = "#${env.BUILD_NUMBER} - ${env.TIMESTAMP.replace('_', ' ')}"
                }
            }
        }

        stage('Build & Test') {
            steps {
                echo "Running Maven Tests and Generating Real HTML Report..."
                bat "mvn clean test -DsuiteXmlFile=functionalTestcase.xml"
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML(target: [
                    reportDir: "${REPORT_DIR}",
                    reportFiles: 'result.html',
                    reportName: 'Extent Report',
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true
                ])
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: "${REPORT_DIR}\\**", allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo "Pipeline completed. Report should be at ${REPORT_DIR}\\result.html"
        }
    }
}
