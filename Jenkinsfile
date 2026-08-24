pipeline{

    // agent none
    agent any

    stages{

        stage('Checkout') {
            // agent {label 'master'}
                    steps {
                        checkout scm
                    }
        }

        stage('Build Podman Image') {
            // agent {label 'master'}
            steps {
                script 
                {
                    // def imageName = 'njdpb-purchase'
                    def IMAGE_NAME = 'njdpb-sba'
                    def buildArgs = "-f ./NJDPB_CICD/Dockerfile_NJDPB_Proxy"

                    // // Define the specific path to the directory containing your Containerfile/Dockerfile
                    def buildPath = "${WORKSPACE}/NJDPB_ADMIN_Server/"

                    sh """
                        # Ensure the script runs in the correct directory
                        cd ${buildPath}

                        # Run the podman build command within that directory
                        podman build ${buildArgs} -t ${IMAGE_NAME}:${BUILD_NUMBER} .

                        
                        # Optionally tag as latest
                        podman tag ${IMAGE_NAME}:${BUILD_NUMBER} ${IMAGE_NAME}:latest

                    """
                    echo "Image built: ${IMAGE_NAME}:${BUILD_NUMBER}"
                }
            }
        }






    }
}