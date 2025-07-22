pipeline {
    agent any

    triggers {
        cron('H * * * *') // runs every hour at different minute per executor
    }

    stages {
        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Find Latest Report') {
            steps {
                script {
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
