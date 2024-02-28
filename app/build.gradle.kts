plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.dallyproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dallyproject"
        minSdk = 28
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
}



tasks.dokkaHtml.configure {
    outputDirectory.set(file("../documentation1/html"))
    suppressInheritedMembers.set(true)


}
tasks.dokkaJavadoc.configure {
    outputDirectory.set(file("../documentation1/Javadoc"))
    suppressInheritedMembers.set(true)


}
tasks.dokkaGfm.configure {
    outputDirectory.set(file("../documentation/Gfm"))
    suppressInheritedMembers.set(true)
}



    dependencies {

        implementation("androidx.core:core-ktx:1.9.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.11.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        //implementation("com.github.bumptech.glide:glide:4.16.0")
        //implementation("com.google.android.material:material:1.11.0")
        //dokkaPlugin("org.jetbrains.dokka:android-documentation-plugin:1.9.10")
        dokkaPlugin("org.jetbrains.dokka:android-documentation-plugin:1.9.10")
    }