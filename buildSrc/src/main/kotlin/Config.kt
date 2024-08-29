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

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlin = "org.jetbrains.kotlin.android"
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
}

object Test {
    private const val junitVersion = "4.13.2"
    private const val androidJunitVersion = "1.2.1"

    const val junit = "junit:junit:$junitVersion"
    const val androidJunit = "androidx.test.ext:junit:$androidJunitVersion"
}

object Compose {
    private const val composeBomVersion = "2024.08.00"
    private const val coilComposeVersion = "2.7.0"

    const val composeBom = "androidx.compose:compose-bom:$composeBomVersion"
    const val materalDesign3 = "androidx.compose.material3:material3"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeDebug = "androidx.compose.ui:ui-tooling"
    const val coilCompose = "io.coil-kt:coil-compose:$coilComposeVersion"
}