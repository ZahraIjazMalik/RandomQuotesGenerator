plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.randomquotesgenerator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.randomquotesgenerator"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.engage.core)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.3.1")


    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")



}