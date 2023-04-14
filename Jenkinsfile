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

       stage ('MVN clean') {
         steps {
            sh 'mvn clean -e'
            echo 'Build stage done'
        }
     }

      stage("compile Project"){
           steps {
                sh 'mvn compile -X -e'
                 echo 'compile stage done'
            }
      }
      stage("unit tests"){
           steps {
                  sh 'mvn test'
                  echo 'unit tests stage done'
            }
      }
      stage("mvn Pckage") {
           steps {
                script {
                  sh "mvn package -DskipTests=true"
              }
           }
      }

        stage('Docker-compose file') {
             steps {
                  sh 'docker-compose up -d';
                   sh 'sleep 300'

           }
       }


  }
}