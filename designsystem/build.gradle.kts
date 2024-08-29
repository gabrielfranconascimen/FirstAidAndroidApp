plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlin)
}

android {
    namespace = "com.gabrielfranconascimen.designsystem"
    compileSdk = App.compileSdk

    defaultConfig {
        minSdk = App.mindSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

}

dependencies {

    implementation(Androidx.coreKtx)
    implementation(Androidx.constraintLayout)

    implementation(platform(Compose.composeBom))
    implementation(Compose.materalDesign3)
    implementation(Compose.composePreview)
    implementation(Compose.composeDebug)

    testImplementation(Test.junit)
    androidTestImplementation(Test.androidJunit)
}