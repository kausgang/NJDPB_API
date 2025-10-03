pipeline{

    agent master
    stages{

        stage('Checkout') {
                    steps {
                        checkout scm
                    }
                }

        stage('Build'){

            steps {
                echo 'Building the application...'
                dir('NJDPB_API'){
                // Build the JAR file once
                                sh 'mvn clean package -DskipTests'
                }

            }

        }
    }
}