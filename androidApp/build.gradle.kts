import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

val compose_version: String = "1.0.1"



plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))

    implementation ("androidx.cardview:cardview:1.0.0")
    implementation ("androidx.recyclerview:recyclerview:1.1.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation( "androidx.core:core-ktx:1.6.0")

    // Compose
    implementation ("androidx.compose.ui:ui:$compose_version")
    implementation ("androidx.compose.material:material:$compose_version")
    implementation ("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation ("androidx.activity:activity-compose:1.3.1")

    //Life Cycle
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha03")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.3.1")

    // Coroutines
    val coroutinesVersion = "1.5.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    // Navigation
    implementation ("androidx.navigation:navigation-compose:2.4.0-alpha06")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")

    // Image loading
    implementation("io.coil-kt:coil-compose:1.3.0")
    implementation("io.coil-kt:coil:1.3.2")
    //implementation ("com.github.skydoves:landscapist-coil:1.3.3")
    // Hilt
    implementation ("com.google.dagger:dagger:2.38.1")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.38")
    api ("com.google.dagger:dagger-android:2.38.1")
    api ("com.google.dagger:dagger-android-support:2.38.1")
    annotationProcessor ("com.google.dagger:dagger-android-processor:2.38.1")
    implementation ("com.google.dagger:hilt-android:2.38.1")
    annotationProcessor ("com.google.dagger:hilt-android-compiler:2.38.1")
    annotationProcessor ( "com.google.dagger:hilt-compiler:2.37")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")


    implementation("com.google.code.gson:gson:2.8.7")

}
android {
    compileSdk = 30
    defaultConfig {
        applicationId = "com.mobile.venky.kmm.ktor.poc.android"
        minSdk = 22
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {

        getByName("debug"){
            debug {
                isDebuggable = true
            }
        }
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility  = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion  = compose_version

    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }





}