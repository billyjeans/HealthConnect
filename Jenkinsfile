pipeline {

   agent any
    options {
        buildDiscarder logRotator(
                    daysToKeepStr: '16',
                    numToKeepStr: '10'
            )
    }

    stages {

        stage('Cleanup Workspace') {
            steps {
                cleanWs()
                sh """
                echo "Cleaned Up Workspace For Project"
                """
            }
        }

        stage('Code Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://gitlab.com/billyjeans/HealthConnect']]
                ])
            }
        }
    
        stage(' Unit Testing') {
             agent {
                docker {
                        image 'maven:3.8.4' // Specify the desired Maven version or tag

                        }
                 }

           steps {
                echo "Running Unit Tests"

                        // Set up the environment
                        sh 'mvn clean install'

                        // Run JUnit tests
                        sh 'mvn test'
            }
        }

        stage('Code Analysis') {
            steps {
                sh """
                echo "Running Code Analysis"
                """
            }
        }

        stage('Build Deploy Code') {
            when {
                branch 'main'
            }
            steps {
                sh """
                echo "Building Artifact"
                """

                sh """
                echo "Deploying Code"
                """
            }
        }

    }
}
