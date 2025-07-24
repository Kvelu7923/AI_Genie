pipeline {
    agent any

    triggers {
        cron('H * * * *') // Run every hour
    }

    environment {
        REPORTS_DIR = "reports"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Kvelu7923/AI_Genie.git'
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    echo "🧪 Running Maven tests..."
                    def mvnStatus = bat(script: 'mvn clean test', returnStatus: true)
                    if (mvnStatus != 0) {
                        echo "⚠️ Tests failed, continuing to archive reports."
                    } else {
                        echo "✅ Tests passed."
                    }
                }
            }
        }

        stage('Find Latest Report Folder') {
            steps {
                script {
                    def output = bat(
                        script: '''@echo off
for /f "delims=" %%i in ('dir /b /ad /o-d reports') do (
    echo %%i
    goto done
)
:done
''',
                        returnStdout: true
                    ).trim()
                    env.LATEST_REPORT_PATH = "reports\\${output}"
                    echo "🗂️ Latest report folder: ${env.LATEST_REPORT_PATH}"
                }
            }
        }

        stage('Archive Extent Report + Images') {
            steps {
                archiveArtifacts artifacts: "${env.LATEST_REPORT_PATH}/**", allowEmptyArchive: true
            }
        }

        stage('Publish HTML Report') {
            steps {
                publishHTML(target: [
                    reportDir: "${env.LATEST_REPORT_PATH}",
                    reportFiles: 'result.html',
                    reportName: 'Extent Report',
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true
                ])
            }
        }
    }

    post {
        always {
            echo "📦 Jenkins pipeline completed. View the report in 'Extent Report' tab or under 'Archived Artifacts'."
        }
    }
}
