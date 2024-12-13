pipeline {
    agent any
    environment {
        ANDROID_HOME = "/Users/neuradev/Library/Android/sdk"
        GRADLE_USER_HOME = "${JENKINS_HOME}/.gradle"
        PATH = "$PATH:${ANDROID_HOME}/tools:${ANDROID_HOME}/tools/bin:${ANDROID_HOME}/platform-tools"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'pre-jenkins', url: 'git@github.com:AlexGladkov/maw_chapter3_block5_demo1.git'
            }
        }

        stage("Build") {
            parallel {
                stage('Build-A') {
                    steps {
                        sh "./gradlew clean assembleCompanyAFree assembleCompanyAPaid --build-cache"
                    }
                }

                stage('Build-B') {
                    steps {
                        sh "./gradlew clean assembleCompanyBFree assembleCompanyBPaid --build-cache"
                    }
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'app/build/outputs/apk/**/*.apk', fingerprint: true
        }
    }
}