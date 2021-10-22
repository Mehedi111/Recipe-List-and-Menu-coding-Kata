object Version {
    //sdk version
    const val minSdkVersion: Int = 22
    const val targetSdkVersion: Int = 30
    const val compileSdkVersion: Int = 30
    const val buildToolsVersion: String = "30.0.3"

    //app version
    const val versionName: String = "1.0"
    const val versionCode: Int = 1

    //library version

    // Kotlin
    const val kotlinPluginVersion = "1.5.31"

    //gradle
    const val gradleVersion = "7.0.0"


    // Dependencies Version - Presentation
    const val appcompatVersion = "1.3.1"
    const val androidxCoreKtxVersion = "1.6.0"
    const val constraintLayoutVersion = "2.1.1"
    const val materialVersion = "1.4.0"
    const val timberVersion = "4.7.1"
    const val viewModelKtxVersion = "2.2.0"
    const val activityKTXVersion = "1.1.0"
    const val glideVersion = "4.12.0"


    //dagger hilt
    const val daggerPluginVersion = "2.38.1"
    const val daggerCompilerVersion = "2.38.1"

    const val coroutinesCoreVersion = "1.3.3"

    // Data
    const val retrofitVersion = "2.7.0"
    const val moshiConverterVersion = "2.7.0"
    const val loggingInterceptorVersion = "4.2.1"


    // Testing
    const val junitVersion = "4.13.2"

}

object Android {
    const val applicationId: String = "com.hellofresh.task2"
    const val testInstrumentationRunner: String = "androidx.test.runner.AndroidJUnitRunner"
}

object TaskOneDependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlinPluginVersion}"
}

object TestDependencies {
    const val junit = "junit:junit:${Version.junitVersion}"
}

object PresentationDependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlinPluginVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Version.androidxCoreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appcompatVersion}"
    const val material = "com.google.android.material:material:${Version.materialVersion}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.viewModelKtxVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayoutVersion}"
    const val timber = "com.jakewharton.timber:timber:${Version.timberVersion}"
    const val activityKTX= "androidx.activity:activity-ktx:${Version.activityKTXVersion}"
    const val glide= "com.github.bumptech.glide:glide:${Version.glideVersion}"

    const val daggerAndroid = "com.google.dagger:hilt-android:${Version.daggerPluginVersion}"
    const val daggerKapt = "com.google.dagger:hilt-compiler:${Version.daggerCompilerVersion}"
}

object DomainDependencies {
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutinesCoreVersion}"

}

object DataDependencies {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofitVersion}"
    const val moshiConverter =
        "com.squareup.retrofit2:converter-moshi:${Version.moshiConverterVersion}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Version.loggingInterceptorVersion}"

}
