pipeline {


    agent any


    stages {

        stage("Cloning Project"){
            steps {
                git branch: 'main',
                url: 'https://github.com/saddem123/scrum-project.git'
                echo 'checkout stage'
            }
        }

        stage ('Maven Clean'){
            steps
			{
                sh 'mvn clean'
            }
        }

		stage ('Maven Compile'){
            steps
			{
                sh 'mvn compile'
            }
        }

		stage ('Maven Sonar'){
            steps
			{
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.134:9000 -Dsonar.login=admin -Dsonar.password=tn27190278mbyys'
            }
        }

        stage ('Maven Test'){
            steps
			{
                sh 'mvn test'
            }
        }

		stage('Maven Build'){
            steps
			{
                sh 'mvn package'
            }
        }

		stage ('Maven Install'){
            steps
			{
                sh 'mvn install'
            }
        }

        stage("Upload Jar  To Nexus") {
            steps {  
               nexusArtifactUploader artifacts: [ 
                 [ 
                    artifactId: 'examenScrum',  
                      classifier: '',  
                      file: 'target/examenScrum-1.0.0.jar',   
                      type: 'jar' 
                   ]  

            ],  
            credentialsId: 'nexus3', 
            groupId: 'tn.esprit', 
            nexusUrl: '192.168.1.134:8081', 
            nexusVersion: 'nexus3', 
            protocol: 'http', 
            repository: 'maven-releases',  
            version: '1.0' 


        }  

     } 


		stage('Docker Build Image'){
                steps
				{
                    script
					{
                        sh 'docker build -t examenscrum-1.0.0 .'
                        sh 'docker build -t mysql .'

                    }
                }
            }



        
        
        stage('Docker Push Image'){
                steps
				{
                    script
					{

                        sh 'docker login -u ysaddem -p tn27190278mbyys'

                        sh 'docker tag  examenscrum-1.0.0 ysaddem/examescrum-1.0.0:tag1'
                        sh 'docker push ysaddem/examescrum-1.0.0:tag1'

                        sh 'docker tag  mysql ysaddem/mysql:1'
                        sh 'docker push ysaddem/mysql:1'



                    }

                }
        }

        stage('Docker-Compose'){
                steps
				{
                    script
					{
                        sh 'docker-compose up'
                    }

                }

            }
    }
}