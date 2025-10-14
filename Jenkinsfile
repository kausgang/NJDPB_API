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
                sh '''
                    cd ./NJDPB_API;
                    export JAVA_HOME=/home/typgang/Jenkins/jdk-21.0.2;
                    /home/typgang/MAVEN/apache-maven-3.9.11/bin/mvn clean package -DskipTests
                '''
            }
        }
        stage('Deploy'){

            agent { label 'master' }
            steps{

                echo "Kill the previous instance and Deploy the new change"

                
            }
        }
    }
}