pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building docker'
                sh 'whoami'
                sh 'docker-compose up -d'
                sh 'docker run -d -P --name selenium-hub selenium/hub'
                sh 'docker run -d --link selenium-hub:hub selenium/node-chrome-debug'
                sh 'docker run -d --link selenium-hub:hub selenium/node-firefox-debug'
            }
            post {
                always {
                    echo 'Docker is ready to be used'
                }
                failure {
                    echo 'Something weird happened. Need to review.'
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

