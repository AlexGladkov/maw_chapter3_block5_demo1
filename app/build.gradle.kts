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

    flavorDimensions += listOf("company", "price")

    productFlavors {
        create("companyA") {
            dimension = "company"
            applicationIdSuffix = ".companyA"
            versionNameSuffix = "-companyA"

            buildConfigField("String", "BASE_URL", "\"https://companyA.com.api\"")
            buildConfigField("String", "API_KEY", "\"COMPANY_A_API_KEY\"")
            buildConfigField("String", "COMPANY", "\"COMPANY_A\"")
        }

        create("companyB") {
            dimension = "company"
            applicationIdSuffix = ".companyB"
            versionNameSuffix = "-companyB"

            buildConfigField("String", "BASE_URL", "\"https://companyB.com.api\"")
            buildConfigField("String", "API_KEY", "\"COMPANY_B_API_KEY\"")
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
//            applicationIdSuffix = ".debug"
//            versionNameSuffix = "-debug"
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

    add("companyAImplementation", projects.whitelabel.companyA)
    add("companyBImplementation", projects.whitelabel.companyB)

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