pipeline {
    agent any

    triggers {
        cron('H * * * *') // Runs every hour (at a random minute to avoid load)
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
                    // This sets a global env var for latest report folder
                    env.LATEST_REPORT_FOLDER = bat(
                        script: 'for /f "delims=" %i in (\'dir /b /ad /o-d reports\') do @echo %i & goto :done\n:done',
                        returnStdout: true
                    ).trim()
                    echo "✅ Latest report folder found: ${env.LATEST_REPORT_FOLDER}"
                }
            }
        }

        stage('Archive Extent Report') {
            steps {
                script {
                    archiveArtifacts artifacts: "reports/${env.LATEST_REPORT_FOLDER}/**", allowEmptyArchive: false
                }
            }
        }

        stage('Publish HTML Report') {
            steps {
                script {
                    publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: "reports/${env.LATEST_REPORT_FOLDER}",
                        reportFiles: 'result.html',
                        reportName: 'Extent Report'
                    ])
                }
            }
        }
    }

    post {
        always {
            echo "✅ Jenkins pipeline completed. You can view the report in 'Extent Report' tab or Archived Artifacts."
        }
    }
}
