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

                echo "Kill the previous instance and Deploy the new change - DO IT MANUALLY"

                // sh 'ps -ef | grep NJDPB | grep -v grep | awk '{print $2}' | xargs kill -9'

                 sh '''
                    echo "Killing previous instance with PID...";
                    ps -ef | grep NJDPB | grep -v grep | awk '{print $2}' | xargs -r kill -9;echo "Moving old JAR to a new location...";
                    mv /home/typgang/SiebelExternalApi/NJDPB_API-0.0.1-SNAPSHOT.jar /home/typgang/SiebelExternalApi/NJDPB_API-0.0.1-SNAPSHOT.jar_$(date +%Y-%m-%d_%H:%M:%S);
                    echo "Copying new JAR from workspace...";
                    scp ${WORKSPACE}/NJDPB_API/target/NJDPB_API-0.0.1-SNAPSHOT.jar /home/typgang/SiebelExternalApi/;echo "Starting new instance...";
                    /home/typgang/SiebelExternalApi/runAPI.sh
                '''

                // sh '/home/typgang/SiebelExternalApi/runAPI.sh'

                // sh '''
                //     mv /home/typgang/SiebelExternalApi/NJDPB_API-0.0.1-SNAPSHOT.jar /home/typgang/SiebelExternalApi/NJDPB_API-0.0.1-SNAPSHOT.jar_$(date +%Y-%m-%d_%H:%M:%S)
                // '''
                
            }
        }
    }
}