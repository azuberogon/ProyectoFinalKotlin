

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        // tus dependencias aquí

    }
}

plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("org.jetbrains.dokka") version "1.9.10" apply true
    id("com.google.gms.google-services") version "4.4.1" apply false // esto es del calendario

}

subprojects {
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