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

                agent {label 'master'}
            steps {
                echo 'Building the application...'
                // dir('NJDPB_API'){
                // Build the JAR file once
                                sh 'cd ./NJDPB_API; /home/typgang/MAVEN/apache-maven-3.9.11/bin/mvn clean package -DskipTests'
                // }

            }

        }
    }
}