pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/AlexGladkov/maw_chapter3_block5_demo1'
            }
        }

        stage('Build') {
           steps {
                sh "./gradlew clean assembleCompanyAFree assembleCompanyBFree assembleCompanyAPaid assembleCompanyBPaid"
           }
        }
    }
}