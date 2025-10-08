pipeline{

    agent none



    stages{

        stage('Checkout') {
            agent {label 'ut1'}
                    steps {
                        checkout scm
                    }
                }

        stage('Build'){

                agent {label 'ut1'}
            steps {
                echo 'Building the application...'
                // dir('NJDPB_API'){
                // Build the JAR file once
                                sh 'cd ./NJDPB_API; echo ${JAVA_HOME}; mvn clean package -DskipTests'
                // }

            }

        }
    }
}