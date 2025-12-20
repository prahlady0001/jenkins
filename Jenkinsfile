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
            emailext(
                subject: "SUCCESS: ${JOB_NAME} #${BUILD_NUMBER}",
                body: """
                <h3>Build Successful</h3>
                <p><b>Project:</b> ${JOB_NAME}</p>
                <p><b>Build Number:</b> ${BUILD_NUMBER}</p>
                <p><b>URL:</b> <a href="${BUILD_URL}">${BUILD_URL}</a></p>
                """,
                to: "yourmail@gmail.com"
            )
        }

        failure {
            emailext(
                subject: "FAILED: ${JOB_NAME} #${BUILD_NUMBER}",
                body: """
                <h3>Build Failed</h3>
                <p><b>Project:</b> ${JOB_NAME}</p>
                <p><b>Check logs:</b> <a href="${BUILD_URL}">${BUILD_URL}</a></p>
                """,
                to: "yourmail@gmail.com"
            )
        }
    }
}
