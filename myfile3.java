public class myfile3 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        pipeline {
    agent any

    environment {
        registry = '4vv23ci104/test4'
        registryCredential = 'jenkin_docker_token'
        dockerimage = ''
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/SrivalliSharma27/dockerprog.git']]
                )
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerimage = docker.build(registry)
                }
            }
        }
    }
    }
}
