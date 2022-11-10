pipeline {
agent any

tools {
maven 'maven'
}

stages {
stage('Compile') {
steps {
echo "-=- compiling project -=-"
bat "mvn clean compile"
}
}



stage('Package') {



steps {
echo "-=- packaging project -=-"
bat "mvn package"
archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
}
}



stage('Build Docker image') {
steps {
echo "-=- build Docker image -=-"
bat "docker build -t weather-service ."
}
}



stage('Run Docker image') {
steps {
echo "-=- run Docker image -=-"

bat "docker run --name=weather-service -p 8400:8400 weather-service"
}
}




}
}