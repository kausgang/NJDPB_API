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

                echo "Kill the previous instance"
                sh 'pkill -f NJDPB_API'

                echo "Deploy the new instance"
                sh '''
                    /home/typgang/Jenkins/jdk-21.0.2/bin/java -jar ${WORKSPACE}/NJDPB_API/target/NJDPB_API-0.0.1-SNAPSHOT.jar  --spring.profiles.active=PUR_dev --DB_HOST=TREVDEVSQL19.tmis.treas.state.nj.us --DB_PORT=1433 --DB_NAME=PURCHASE --DB_USERNAME=siebel_user --DB_PASSWORD=cat?52 --spring.security.user.name=sadmin --spring.security.user.password=siebdev99 &
                '''
            }
        }
    }
}