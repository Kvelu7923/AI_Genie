pipeline {
    agent any

    triggers {
        cron('H * * * *') // every hour
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
                sh 'mvn clean test'
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
