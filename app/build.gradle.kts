import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = "com.example.networkpractice"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "CULTURE_BASE_URL", getApiKey("CULTURE_BASE_URL"))
        buildConfigField("String", "CULTURE_API_KEY", getApiKey("CULTURE_API_KEY"))

    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

fun getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}

dependencies {
    dependOnAndroidX()
    dependOnKotlin()
    dependOnTest()
    dependOnRetrofit()
    dependOnOkHttp()
    dependOnTimber()
    dependOnTikXML()
    dependOnHilt()
    dependOnCoroutines()
    dependOnGlide()
    dependOnAnimation()
    dependOnRoom()
    dependOnNaverMap()
}