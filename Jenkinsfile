pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''cd /var/lib/jenkins/workspace/controle-usuario_master

mvn clean install'''
      }
    }

  }
}