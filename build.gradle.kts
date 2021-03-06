import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//    id("org.springframework.boot") version "2.4.3" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.spring") version "1.4.30"
    id("maven")
}

val mirai_version = "2.4.0"
val spring_version = "2.4.3"

group = "com.github.mzdluo123"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:$spring_version")
    implementation("org.springframework.boot:spring-boot-starter-validation:$spring_version")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:$spring_version")
    api("net.mamoe:mirai-core-jvm:$mirai_version")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
