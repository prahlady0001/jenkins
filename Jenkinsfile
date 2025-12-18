pipeline {
    agent any

    tools {
        maven 'maven-3.9'
        jdk 'jdk17'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/prahlady0001/jenkins.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }
    }

    post {
        success {
            echo '✅ Build + Test + Package Successful'
        }
        failure {
            echo '❌ Pipeline Failed'
        }
    }
}
