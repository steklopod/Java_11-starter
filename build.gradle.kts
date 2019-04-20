plugins {
    java
    idea
    id("org.springframework.boot") version "2.1.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    id("com.github.ben-manes.versions") version "0.21.0"
}

description = " Проект для быстрого старта с Java 11 "

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    // Boot
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")

    //DataBase
    implementation("org.postgresql:postgresql:42.2.5")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.liquibase:liquibase-core:3.6.3")
//    implementation("com.h2database:h2")

    // Tests
    testImplementation("org.jeasy:easy-random:4.0.0.RC1")            // github.com/j-easy/easy-random/wiki
    testImplementation("org.springframework.boot:spring-boot-starter-test") { exclude(module = "junit") }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("io.github.glytching:junit-extensions:2.3.0") // glytching.github.io/junit-extensions/

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.6")
    annotationProcessor("org.projectlombok:lombok:1.18.6")

    // Other
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("org.jetbrains:annotations:17.0.0")
}

defaultTasks("clean", "build", "bootRun")
