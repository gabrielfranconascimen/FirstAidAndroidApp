plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlin)
    id(Plugins.safeArgs)
    id(Plugins.firebase)
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
    implementation(Androidx.coreKtx)
    implementation(Androidx.appcompat)
    implementation(Androidx.constraintLayout)
    implementation(Androidx.lifecycleRuntime)
    implementation(Androidx.navigationFragment)
    implementation(Androidx.navigationUi)

    implementation(platform(Compose.composeBom))
    implementation(Compose.materalDesign3)
    implementation(Compose.composePreview)
    implementation(Compose.composeDebug)

    implementation(platform(Firebase.firebaseBoM))
    implementation(Firebase.cloudFirestore)

    implementation(Dependency.koin)

    implementation(project(Module.designSystem))

    testImplementation(Test.junit)
    testImplementation(Test.mockk)
    testImplementation(Test.junit4)
    androidTestImplementation(Test.androidJunit)
}