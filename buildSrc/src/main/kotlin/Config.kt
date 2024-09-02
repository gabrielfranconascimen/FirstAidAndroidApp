object App {
    const val namespace = "com.gabrielfranconascimen.firstaidandroidapp"
    const val applcationId = "com.gabrielfranconascimen.firstaidandroidapp"
    const val compileSdk = 34
    const val mindSdk = 24
    const val targetSdk = 34
}

object Plugins {
    const val androidApplicationVersion = "8.5.0"
    const val kotlinVersion = "1.9.0"
    const val firebaseVersion = "4.4.2"

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlin = "org.jetbrains.kotlin.android"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"
    const val firebase = "com.google.gms.google-services"
}

object Androidx {
    private const val coreKtxVersion = "1.10.1"
    private const val appcompatVersion = "1.7.0"
    private const val constraintLayoutVersion = "2.1.4"
    private const val lifecycleVersion = "2.6.1"
    private const val navigationVersion = "2.7.7"

    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    const val appcompat = "androidx.appcompat:appcompat:$appcompatVersion"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
}

object Test {
    private const val junitVersion = "4.13.2"
    private const val androidJunitVersion = "1.2.1"
    private const val mockkVersion = "1.13.12"

    const val junit = "junit:junit:$junitVersion"
    const val junit4 = "androidx.compose.ui:ui-test-junit4"
    const val androidJunit = "androidx.test.ext:junit:$androidJunitVersion"
    const val mockk = "io.mockk:mockk:$mockkVersion"
}

object Compose {
    private const val composeBomVersion = "2024.08.00"
    private const val coilComposeVersion = "2.7.0"

    const val composeBom = "androidx.compose:compose-bom:$composeBomVersion"
    const val materalDesign3 = "androidx.compose.material3:material3"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeDebug = "androidx.compose.ui:ui-tooling"
}

object Dependency {
    private const val koinVersion = "3.5.6"

    const val koin = "io.insert-koin:koin-android:$koinVersion"
}

object Firebase {
    private const val firebaseBoMVersion = "33.2.0"

    const val firebaseBoM ="com.google.firebase:firebase-bom:$firebaseBoMVersion"
    const val cloudFirestore = "com.google.firebase:firebase-firestore"
    const val authentication = "com.google.firebase:firebase-auth"
}

object Module {
    const val designSystem = ":designsystem"
}