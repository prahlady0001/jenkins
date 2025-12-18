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
                bat 'mvn clean package'
            }
        }
    }

    post {
        success {
            echo ' Build Successful'
        }
        failure {
            echo ' Build Failed'
        }
    }
}
