pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                sh "docker build -t='automationtesting99/selenium-grid-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'testleaf@123', usernameVariable: 'automationtesting99')]) {
                    //sh
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push automationtesting99/selenium-grid-docker:latest"
			    }                           
            }
        }
    }
}