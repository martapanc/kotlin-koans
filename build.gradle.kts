import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.0"
}
group = "me.martapanc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test-junit5"))
    implementation("com.ginsberg:cirkle:1.0.1")
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}