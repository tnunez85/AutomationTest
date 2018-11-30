pipeline {
    agent any
//    triggers{
//        cron('* * * * *')
//    }
    stages {
        stage('Build') {
            steps {
                echo 'Building docker'
                sh 'whoami'
                sh 'docker-compose up -d'
            }
            post {
                failure {
                    echo 'Something weird happened with Docker. Need to review.'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Test is being submitted'
                sh 'docker ps -a'
                            }
            post{
                failure{
                 echo 'Test exited with error'
                 sh 'docker-compose down'
                }
            }
        }
        stage('Bye Bye!') {
            steps {
                sh 'docker-compose down'
                echo 'bye-bye docker!!'
            }

        }

    }
}

