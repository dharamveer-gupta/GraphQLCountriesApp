// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0-beta05" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    //To configure the Hilt Gradle plugin with Gradle's new plugins DSL
    id("com.google.dagger.hilt.android") version "2.44" apply false
}

buildscript {
    repositories {
        // other repositories...
        mavenCentral()
    }
    dependencies {
        // other plugins...
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44.2")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}