pipeline{

    agent none

    environment {
        // Set HTTP and HTTPS proxy environment variables
        HTTP_PROXY = 'http://172.27.129.1:8080'
        HTTPS_PROXY = 'http://172.27.129.1:8080'
        // Specify hosts that should bypass the proxy
        // NO_PROXY = 'localhost,*.yourdomain.com'
    }

    stages{

        stage('Checkout') {
            agent {label 'master'}
                    steps {
                        checkout scm
                    }
                }

        stage('Build'){

                agent {label 'master'}
            steps {
                echo 'Building the application...'
                // dir('NJDPB_API'){
                // Build the JAR file once
                                sh 'cd ./NJDPB_API; mvn clean package -DskipTests'
                // }

            }

        }
    }
}