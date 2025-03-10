plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.androidunittest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.androidunittest"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Local unit tests
    testImplementation("junit:junit:4.13.2")

    // Instrumented tests
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("org.hamcrest:hamcrest-library:2.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test:core:1.5.0")
}