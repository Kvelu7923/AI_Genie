pipeline {
    agent any

    environment {
        TIMESTAMP = "${new Date().format('dd-MMM-yyyy_HH-mm-ss')}" // Use _ instead of space
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
                echo "Running Tests and Generating HTML Report..."
                bat """
                    mkdir "${REPORT_DIR}"
                    echo ^<html^>^<body^>^<h1^>Sample Report^</h1^>^</body^>^</html^> > "${REPORT_DIR}\\result.html"
                """
            }
        }

        stage('Publish Report') {
            steps {
                echo "Publishing HTML Report from ${REPORT_DIR}\\result.html"
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
            echo "Pipeline completed. Report located at ${REPORT_DIR}\\result.html"
        }
    }
}
