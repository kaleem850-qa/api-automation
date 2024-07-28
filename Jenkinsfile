pipeline {
    agent any

    stages {
        stage('Run Tests') {
            steps {
                sh "mvn clean test"
            }
        }
        stage('Publish Report') {
            steps {
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/report', reportFiles: 'index.html', reportName: 'API Test Reports', reportTitles: '', useWrapperFileDirectly: true])
            }
        }
    }
}
