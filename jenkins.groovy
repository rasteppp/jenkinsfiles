#!groovy
// Check ubntnginx properties
properties([disableConcurrentBuilds()])

pipeline {
    agent {
        label 'master'
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
    }
    stages {
        stage("First step") {
            steps {
                sh 'ssh root@ubntnginx \'hostname\''
            }
        }
        stage("Second step") {
            steps {
                sh 'ssh root@ubntnginx \'uptime\''
            }
        }
    }
}