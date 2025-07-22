pipeline {
    agent any
    triggers {
        cron('H * * * *') // Every hour at a different minute
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Kvelu7923/AI_Genie.git'
            }
        }

        stage('Build & Test') {
            steps {
                // If using Windows, use 'bat'. For Linux/macOS, use 'sh'
                bat 'mvn clean test'
            }
        }

        stage('Find Latest Report') {
            steps {
                script {
                    // Get the latest report folder name (based on timestamp)
                    def reportFolder = bat(script: '''
                        for /f "delims=" %%a in ('dir reports /b /ad /o-d') do (
                            echo %%a
                            goto done
                        )
                        :done
                    ''', returnStdout: true).trim()

                    env.REPORT_PATH = "reports\\${reportFolder}\\result.html"
                    echo "📝 Latest report: ${env.REPORT_PATH}"
                }
            }
        }

        stage('Archive Extent Report') {
            steps {
                archiveArtifacts artifacts: "${env.REPORT_PATH}", allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo "✅ Pipeline Done. View 'result.html' under Archived Artifacts."
        }
    }
}
