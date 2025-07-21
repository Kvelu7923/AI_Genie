pipeline {
    agent any
    tools {
        maven 'Maven3'  // This name must match the name you gave above
    }
    stages {
        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}
