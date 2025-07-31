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
                    echo "🔍 Finding latest folder under 'reports/'..."
                    def output = bat(
                        script: '''
@echo off
for /f "delims=" %%i in ('dir /b /ad /o-d reports') do (
    echo %%i
    goto done
)
:done
''', returnStdout: true
                    ).trim()

                    // Save to Groovy-scoped variable
                    currentBuild.displayName = "#${env.BUILD_NUMBER} - ${output}"
                    // Save full relative path to use later
                    // Use forward slashes (more reliable in Jenkins)
                    latestReportPath = "reports/${output}"
                    echo "🗂️ Latest report folder is: ${latestReportPath}"
                    
                    // Save to file so it can be accessed again in other steps
                    writeFile file: 'latest-report-path.txt', text: latestReportPath
                }
            }
        }

        stage('Archive Extent Report') {
            steps {
                script {
                    def latestReportPath = readFile('latest-report-path.txt').trim()
                    archiveArtifacts artifacts: "${latestReportPath}/**", allowEmptyArchive: true
                }
            }
        }

        stage('Publish HTML Report') {
            steps {
                script {
                    def latestReportPath = readFile('latest-report-path.txt').trim()
                    publishHTML(target: [
                        reportDir: latestReportPath,
                        reportFiles: 'result.html',
                        reportName: 'Extent Report',
                        allowMissing: true,
                        alwaysLinkToLastBuild: true,
                        keepAll: true
                    ])
                }
            }
        }
    }

    post {
        always {
            echo "✅ Jenkins pipeline completed. Report is available in the Extent tab or as an archived artifact."
        }
    }
}
