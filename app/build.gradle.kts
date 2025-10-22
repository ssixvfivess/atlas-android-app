plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.ssixvfivess.anatomy"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.ssixvfivess.anatomy"
        minSdk = 30
        targetSdk = 36

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        resources.excludes += "DebugProbesKt.bin"
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

    dependencies {
        // ANDROID LIBS
        implementation(libs.kotlin)
        implementation(libs.appcompat)
        implementation(libs.coreKtx)

        implementation(libs.fragmentKtx)
        implementation(libs.viewModelKtx)

        // MATERIAL COMPONENTS
        implementation(libs.coreKtx)
        implementation(libs.material)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)
        testImplementation(libs.junit)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)
        implementation(libs.swipeRefreshLayout)
        implementation(libs.constraintLayout)

        // UI
        implementation(libs.adapterDelegates)

        // MEDIA
        implementation(libs.coil.compose)
        implementation(libs.glide)
        implementation(libs.lifecycle.viewmodel.savedstate.android)
        implementation(libs.protolite.well.known.types)
        implementation(libs.room.runtime.android)
        implementation(libs.runtime)
        implementation(libs.material3)
        implementation(libs.ui.tooling.preview)
        debugImplementation(libs.ui.tooling)
        ksp(libs.glideCompiler)

        // NETWORK
        implementation(libs.retrofit)
        implementation(libs.okhttp3Logging)
        implementation(libs.ktxSerializationConverter)

        // NAVIGATION
        implementation(libs.navComponentsUi)
        implementation(libs.navComponentsFragment)

        // MULTITHREADING
        implementation(libs.coroutines)

        // DI
        implementation(libs.hilt.android)
        ksp(libs.hilt.compiler)
        implementation("androidx.hilt:hilt-navigation-compose:1.3.0")

        // LOG
        implementation(libs.timber)

        // LOCAL STORAGE
        implementation(libs.room)
        ksp(libs.roomCompiler)

        // SYSTEM UTILS
        implementation(libs.jodaTime)
        implementation(libs.ktxSerializationJson)

        implementation(libs.material.v190)

        //SPLASH SCREEN API
        implementation(libs.androidx.core.splashscreen)
    }
