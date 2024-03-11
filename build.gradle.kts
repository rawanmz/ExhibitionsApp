//// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
        classpath ("com.android.tools.build:gradle:8.0.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
        classpath ("org.jetbrains.kotlin:kotlin-allopen:1.9.22")

    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}