pipeline {
    agent any

    environment {
        REPORTS_DIR = "reports"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Kvelu7923/AI_Genie.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Find Latest Report Folder') {
            steps {
                script {
                    def reportFolders = findFiles(glob: "${REPORTS_DIR}/*/result.html")
                    if (reportFolders.length == 0) {
                        error "❌ No report.html found!"
                    }
                    // Pick the latest by sorting based on folder names (timestamp)
                    latestReport = reportFolders.sort { a, b -> 
                        return b.name <=> a.name
                    }[0]
                    env.LATEST_REPORT_DIR = latestReport.path.replace('/result.html', '')
                    echo "✅ Found latest report folder: ${env.LATEST_REPORT_DIR}"
                }
            }
        }

        stage('Archive Extent Report + Images') {
            steps {
                archiveArtifacts artifacts: "${env.LATEST_REPORT_DIR}/**", allowEmptyArchive: true
            }
        }

        stage('Publish HTML Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: "${env.LATEST_REPORT_DIR}",
                    reportFiles: 'result.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }

    post {
        always {
            echo "✅ Jenkins pipeline completed. View 'Extent Report' tab or Archived Artifacts."
        }
    }
}
