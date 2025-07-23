pipeline {
    agent any

    environment {
        REPORT_DIR = ''
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Kvelu7923/AI_Genie.git', branch: 'main'
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
                    def reportBase = "reports"
                    def folders = new File(reportBase).listFiles().findAll { it.isDirectory() }
                    if (!folders || folders.size() == 0) {
                        error "❌ No report folders found in 'reports/'."
                    }
                    def latestFolder = folders.max { it.lastModified() }
                    env.REPORT_DIR = latestFolder.toString().replace("\\", "/")
                    echo "✅ Latest report folder found: ${env.REPORT_DIR}"
                }
            }
        }

        stage('Archive Extent Report') {
            steps {
                archiveArtifacts artifacts: "${env.REPORT_DIR}/**/*", fingerprint: true
            }
        }

        stage('Publish HTML Report') {
            steps {
                publishHTML(target: [
                    reportDir: "${env.REPORT_DIR}",
                    reportFiles: 'result.html',
                    reportName: 'Extent Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true
                ])
            }
        }
    }

    post {
        always {
            echo "✅ Jenkins pipeline completed. You can view the report in 'Extent Report' tab or Archived Artifacts."
        }
    }
}
