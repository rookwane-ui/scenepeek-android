plugins {
  alias(libs.plugins.divinelink.android.application)
  alias(libs.plugins.compose)

  alias(libs.plugins.firebase.appdistribution)
  alias(libs.plugins.firebase.crashlytics)
}

android {
  namespace = "com.divinelink.scenepeek"

  defaultConfig {
    applicationId = "com.divinelink.scenepeek"
    versionCode = libs.versions.version.code.get().toInt()
    versionName = libs.versions.version.name.get()

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  signingConfigs {
    create("release") {
      // ✅ الطريقة الأسهل: اسم الملف الثابت
      val keystoreFile = File(System.getenv("RUNNER_TEMP") + "/keystore/keystore.jks")
      if (keystoreFile.exists()) {
        storeFile = keystoreFile
        storePassword = System.getenv("SIGNING_STORE_PASSWORD")
        keyAlias = System.getenv("SIGNING_KEY_ALIAS")
        keyPassword = System.getenv("SIGNING_KEY_PASSWORD")
      } else {
        // للـ build المحلي
        storeFile = file("release.jks")
        storePassword = System.getenv("KEYSTORE_PASSWORD") ?: ""
        keyAlias = System.getenv("KEY_ALIAS") ?: ""
        keyPassword = System.getenv("KEY_PASSWORD") ?: ""
      }
    }
  }

  buildTypes {
    debug {
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

      applicationIdSuffix = ".debug"
      versionNameSuffix = " DEBUG"
    }
    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      signingConfig = signingConfigs.getByName("release")
      
      // 🔽 علّق Firebase App Distribution دلوقتي
      firebaseAppDistribution {
        artifactType = "APK"
        artifactPath = "android/build/outputs/apk/release/app-release.apk"
        groups = "development"
      }
    }
  }

  testOptions.unitTests.isIncludeAndroidResources = true

  lint {
    checkReleaseBuilds = false
    abortOnError = false
  }
}

dependencies {
  implementation(projects.app)
  implementation(projects.core.android)

  implementation(libs.firebase.crashlytics)

  implementation(libs.androidx.startup)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)

  implementation(libs.kotlin.test.junit)
  implementation(libs.kotlinx.datetime)
  implementation(libs.kotlinx.coroutines.core)

  implementation(libs.koin.core)
  implementation(libs.koin.compose)
  implementation(libs.koin.compose.viewmodel)
  implementation(libs.koin.start.up)

  implementation(libs.napier)

  // Testing Libs
  testImplementation(projects.core.testing)

  testImplementation(libs.androidx.compose.ui.test)
  testImplementation(libs.robolectric)
  testImplementation(libs.ui.automator)
  debugImplementation(libs.androidx.test.ktx)

  testImplementation(libs.androidx.navigation.testing)
  testImplementation(libs.kotlin.test.junit)

  screenshotTestImplementation(libs.screenshot.validation.api)
  screenshotTestImplementation(libs.compose.multiplatform.ui.tooling)
}
