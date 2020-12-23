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
                sh 'cd /home/rasteppp/jmeter/apache-jmeter-5.3'
            }
        }
        stage("Second step") {
            steps {
                sh 'bin/jmeter -n -t pacingTimerExample/pacingTimerExampleUbuntu.jmx -l /mnt/d/PT/stud_projects/tests_JMeter/pacingTimerExample/log/result3.csv  -e -o /mnt/d/PT/stud_projects/tests_JMeter/pacingTimerExample/html/report/'
            }
        }
    }
}