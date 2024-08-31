// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(Androidx.safeArgs)
    }
}
plugins {
    id(Plugins.androidApplication) version Plugins.androidApplicationVersion apply false
    id(Plugins.kotlin) version Plugins.kotlinVersion apply false
    id(Plugins.androidLibrary) version Plugins.androidApplicationVersion apply false
}