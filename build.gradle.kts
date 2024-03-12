buildscript {
    repositories {
        google() // Repositorio de Google para las dependencias de Android
        jcenter() // Repositorio de bibliotecas de terceros
    }

    dependencies {
        // Tus dependencias aquí. Aquí se agregarán las dependencias necesarias para compilar y construir tu proyecto.
    }
}

plugins {
    // Aplicación de plugins para este proyecto
    id("com.android.application") version "8.2.2" apply false // Plugin para aplicaciones Android
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false // Plugin para Kotlin en aplicaciones Android
    id("org.jetbrains.dokka") version "1.9.10" apply true // Plugin para generar documentación Kotlin (Dokka)
    id("com.google.gms.google-services") version "4.4.1" apply false // Plugin para servicios de Google Play (para el calendario)

}

subprojects {
    // Aplicación del plugin Dokka a todos los subproyectos
    apply(plugin = "org.jetbrains.dokka")
}


// esta parte es del calendario pero creo que es una version antigua, no estoy muy seguro
//buildscript {
//    repositories {
//        google()
//        mavenCentral()
//    }
//    dependencies {
//        classpath 'com.android.tools.build:gradle:8.2.2';
//        classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22';
//        classpath 'com.google.gms:google-services:4.4.1'
//    }
//}