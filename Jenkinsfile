pipeline {
    agent any

    environment {
        REPORTS_DIR = "reports"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                echo "🧪 Running Maven Tests..."
                script {
                    def mvnStatus = bat(script: 'mvn clean test -DsuiteXmlFile=functionalTestcase.xml', returnStatus: true)
                    if (mvnStatus != 0) {
                        echo "⚠️ Test failures occurred, continuing to archive report."
                    } else {
                        echo "✅ Tests executed successfully."
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
                    env.TIMESTAMP_NAME = output
                    echo "🗂️ Found Report: ${env.LATEST_REPORT_PATH}"

                    // Set job display name like: #163 - 31-Jul-2025 17-58-28
                    currentBuild.displayName = "#${env.BUILD_NUMBER} - ${env.TIMESTAMP_NAME.replace('_', ' ')}"
                }
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

        stage('Archive Report & Images') {
            steps {
                archiveArtifacts artifacts: "${env.LATEST_REPORT_PATH}/**", allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo "✅ Pipeline completed. Report available in 'Extent Report' tab or Artifacts."
        }
    }
}
