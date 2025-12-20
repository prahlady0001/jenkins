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
                mimeType: 'text/html',
                subject: "✅ BUILD SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                <h2 style="color:green;">Build Successful 🚀</h2>
                <p><b>Project:</b> ${env.JOB_NAME}</p>
                <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>
                <p><b>Status:</b> SUCCESS</p>
                <p><b>Console Output:</b>
                <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                """,
                to: "prahlady0001@gmail.com"
            )
        }

        failure {
            emailext(
                mimeType: 'text/html',
                subject: "❌ BUILD FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                <h2 style="color:red;">Build Failed ❌</h2>
                <p><b>Project:</b> ${env.JOB_NAME}</p>
                <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>
                <p><b>Check Logs:</b>
                <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                """,
                to: "prahlady0001@gmail.com"
            )
        }
    }
}
