plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id ("androidx.navigation.safeargs")
}

android {
    namespace = "com.hasan.practice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hasan.practice"
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

    buildFeatures{
        viewBinding = true
    }

}

dependencies {

    val room_version = "2.5.2"
    val paging_version = "3.2.0"
    val dagger_version = "2.46.1"
    val glide_version = "4.14.2"
    val retrofit_version = "2.9.0"

    // DI -Dagger
    implementation("com.google.dagger:dagger:$dagger_version")
    ksp("com.google.dagger:dagger-compiler:$dagger_version")

    // Paging for Kotlin use paging-runtime-ktx
    implementation("androidx.paging:paging-runtime-ktx:$paging_version")

    // Room
    implementation("androidx.room:room-runtime:$room_version")
    ksp("androidx.room:room-compiler:$room_version")
    // Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")

    // Paging 3 Integration
    implementation("androidx.room:room-paging:$room_version")

    // Glide
    ksp ("com.github.bumptech.glide:ksp:$glide_version")

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}