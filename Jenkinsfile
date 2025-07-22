pipeline {
    agent any

    triggers {
        cron('H * * * *') // runs every hour
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-creds',
                    branch: 'main',
                    url: 'https://github.com/Kvelu7923/AI_Genie.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'   // ✅ For Windows
            }
        }

        stage('Archive Extent Report') {
            steps {
                archiveArtifacts artifacts: 'reports/**/*.html', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo "✅ Pipeline Done. Check report under 'Archived Artifacts'."
        }
    }
}
