pipeline{

    agent none
    stages{

        stage('Checkout') {
            agent {label 'master'}
                    steps {
                        checkout scm
                    }
                }

        stage('Build'){

            steps {
                agent {label 'master'}
                echo 'Building the application...'
                // dir('NJDPB_API'){
                // Build the JAR file once
                                sh 'cd ./NJDPB_API; mvn clean package -DskipTests'
                // }

            }

        }
    }
}