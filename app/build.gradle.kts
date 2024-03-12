plugins {
    id("com.android.application") // Plugin para aplicación Android
    id("org.jetbrains.kotlin.android") // Plugin para aplicaciones Android con Kotlin
    kotlin("kapt") // Plugin para procesamiento de anotaciones en Kotlin
}

android {
    namespace = "com.example.dallyproject" // Espacio de nombres de tu aplicación

    compileSdk = 34 // Versión del SDK de compilación

    defaultConfig {
        applicationId = "com.example.dallyproject" // ID de la aplicación
        minSdk = 24 // Versión mínima del SDK admitida
        targetSdk = 34 // SDK de destino
        versionCode = 1 // Código de versión
        versionName = "1.0" // Nombre de la versión

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner" // Runner de instrumentación de pruebas
    }

    buildTypes {
        release {
            isMinifyEnabled = false // No se realiza minificación en versión de lanzamiento
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true // Habilita el uso de View Binding
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8 // Compatibilidad de fuente
        targetCompatibility = JavaVersion.VERSION_1_8 // Compatibilidad de destino
    }

    kotlinOptions {
        jvmTarget = "1.8" // JVM Target para Kotlin
    }

    buildToolsVersion = "34.0.0" // Versión de Build Tools
}

// Configuración de la generación de documentación con Dokka
tasks.dokkaJavadoc.configure {
    outputDirectory.set(file("../documentation/Javadoc")) // Directorio de salida para la documentación Javadoc
}
tasks.dokkaHtml.configure {
    outputDirectory.set(file("../documentation/html")) // Directorio de salida para la documentación HTML
}

tasks.dokkaGfm.configure {
    outputDirectory.set(file("../documentation/Gfm")) // Directorio de salida para la documentación GFM
}

// Dependencias del proyecto
dependencies {
    // Dependencia para Google Play Services Maps
    implementation("com.google.android.gms:play-services-maps:18.2.0")

    // Dependencias de Room
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")

    // Otras dependencias de AndroidX
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation("androidx.room:room-common:2.6.1")

    // Dependencias para pruebas
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Otras dependencias
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation("org.jetbrains.dokka:android-documentation-plugin:1.9.20")
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Dependencias de Firebase
    implementation("com.google.firebase:firebase-bom:32.7.3")
    implementation("com.google.firebase:firebase-firestore:24.10.3")
    implementation("com.google.firebase:firebase-database:20.3.1")
    implementation("com.google.firebase:firebase-messaging:23.4.1")
}
