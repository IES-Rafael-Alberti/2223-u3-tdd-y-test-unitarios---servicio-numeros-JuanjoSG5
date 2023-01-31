import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "me.edu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.5.4")
    testImplementation("io.kotest:kotest-runner-junit5:5.5.4")
    testImplementation("io.kotest:kotest-assertions-core:5.5.4")
    testImplementation("io.kotest:kotest-property:5.5.4")
}