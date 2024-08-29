plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlin)
}

android {
    namespace = App.namespace
    compileSdk = App.compileSdk

    defaultConfig {
        applicationId = App.applcationId
        minSdk = App.mindSdk
        targetSdk = App.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    implementation(project(Module.designSystem))

    implementation(Androidx.coreKtx)
    implementation(Androidx.appcompat)
    implementation(Androidx.constraintLayout)
    implementation(Androidx.lifecycleRuntime)
    implementation(Androidx.navigationFragment)
    implementation(Androidx.navigationUi)

    testImplementation(Test.junit)
    androidTestImplementation(Test.androidJunit)
}