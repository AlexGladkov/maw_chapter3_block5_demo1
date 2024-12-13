pipeline {
    agent any
    environment {
        ANDROID_HOME = "/Users/neuradev/Library/Android/sdk"
        PATH = "$PATH:${ANDROID_HOME}/tools:${ANDROID_HOME}/tools/bin:${ANDROID_HOME}/platform-tools"

        COMPANY_A_BASE_URL = credentials("company_a_base_url")
        COMPANY_A_API_KEY = credentials("company_a_api_key")

        COMPANY_B_BASE_URL = credentials("company_b_base_url")
        COMPANY_B_API_KEY = credentials("company_b_api_key")
    }

    parameters {
        choice(name: 'FLAVOUR', choices: ['companyA', 'companyB'], description: 'Выберите flavour для сборки')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'pre-jenkins', url: 'git@github.com:AlexGladkov/maw_chapter3_block5_demo1.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    def flavour = params.FLAVOUR
                    sh "./gradlew clean assemble${flavour}Free assemble${flavour}Paid --build-cache"
                }

            }
        }
    }
}