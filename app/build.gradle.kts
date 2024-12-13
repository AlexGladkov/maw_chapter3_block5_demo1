plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "tech.mobiledeveloper.mawc3b5d1"
    compileSdk = 35

    defaultConfig {
        applicationId = "tech.mobiledeveloper.mawc3b5d1"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions += listOf("client", "price")

    productFlavors {
        create("companyA") {
            dimension = "client"
            applicationIdSuffix = ".companyA"
            versionNameSuffix = "-companyA"

            resValue("string", "client_name", "Company A")
            buildConfigField("String", "BASE_URL", "\"https://companyA.com/api\"")
            buildConfigField("String", "API_KEY", "\"COMPANYA_API_KEY\"")
            buildConfigField("String", "COMPANY", "\"COMPANY_A\"")
        }

        create("companyB") {
            dimension = "client"
            applicationIdSuffix = ".companyB"
            versionNameSuffix = "-companyB"

            resValue("string", "client_name", "Company B")
            buildConfigField("String", "BASE_URL", "\"https://companyB.com/api\"")
            buildConfigField("String", "API_KEY", "\"COMPANYB_API_KEY\"")
            buildConfigField("String", "COMPANY", "\"COMPANY_B\"")
        }

        create("free") {
            dimension = "price"
            applicationIdSuffix = ".free"
            versionNameSuffix = "-free"
        }

        create("paid") {
            dimension = "price"
            applicationIdSuffix = ".paid"
            versionNameSuffix = "-paid"
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets {
        getByName("free") {
            java.srcDirs("src/free/java")
        }

        getByName("paid") {
            java.srcDirs("src/paid/java")
        }
    }

    signingConfigs {
        create("releaseKey") {
            storeFile = file("keystore/release.jks")
            storePassword = "password"
            keyAlias = "release"
            keyPassword = "password"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core)

    add("companyAImplementation", project(":whitelabel:companyA"))
    add("companyBImplementation", project(":whitelabel:companyB"))

    add("freeImplementation", libs.yandex.ads)
    add("paidImplementation", libs.mapbox)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

/**
sudo apt update

sudo apt install openjdk-17-jre

java -version

curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key | sudo tee \
/usr/share/keyrings/jenkins-keyring.asc > /dev/null
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
/etc/apt/sources.list.d/jenkins.list > /dev/null

sudo apt-get update

sudo apt-get install jenkins

sudo systemctl start jenkins.service

sudo systemctl status jenkins
 **/