pipeline {
   agent any

   tools {
     maven 'Maven 3.8.6'
     jdk 'Java 17.0.4.1'
    jdk 'Java 16'
   }

    stages {

        stage('Cleanup Workspace') {

   tools {
    maven 'Maven 3.8.6'
     jdk 'Java 17.0.4.1'
   }
            steps {
                sh """
                printenv
                which java
                which java
                java --version
                which java
                mvn --version
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
           steps {
                echo "Running Unit Tests"

                        // Set up the environment
                        sh 'mvn clean install'

                        // Run JUnit tests
                        sh 'mvn test'
            }
        }
//
//         stage('Code Analysis') {
//             steps {
//                 sh """
//                 echo "Running Code Analysis"
//                 """
//             }
//         }
//
//         stage('Build Deploy Code') {
//             when {
//                 branch 'main'
//             }
//             steps {
//                 sh """
//                 echo "Building Artifact"
//                 """
//
//                 sh """
//                 echo "Deploying Code"
//                 """
//             }
//         }

    }
}
