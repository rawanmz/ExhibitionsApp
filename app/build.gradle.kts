plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.exhibitionsapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.exhibitionsapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")


    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation( "com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    // KotlinX Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    //json
    implementation ("com.google.code.gson:gson:2.10.1")

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

    implementation ("com.github.bumptech.glide:glide:4.12.0")

}