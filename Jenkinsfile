pipeline {
    agent any

    environment {
        // Find the latest report folder dynamically (most recent by creation date)
        REPORT_FOLDER = ''
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
                    def reportsDir = new File("${env.WORKSPACE}/reports")
                    if (reportsDir.exists()) {
                        def folders = reportsDir.listFiles().findAll { it.isDirectory() }
                        def latestFolder = folders.max { it.lastModified() }
                        env.REPORT_FOLDER = latestFolder.path
                        echo "✅ Latest report folder: ${env.REPORT_FOLDER}"
                    } else {
                        error "❌ reports folder not found."
                    }
                }
            }
        }

        stage('Archive Extent Report') {
            steps {
                archiveArtifacts artifacts: "${env.REPORT_FOLDER}/**", allowEmptyArchive: true
            }
        }

        stage('Publish HTML Report') {
            steps {
                publishHTML([
                    reportName: 'Extent Report',
                    reportDir: "${env.REPORT_FOLDER}",
                    reportFiles: 'result.html',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
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
