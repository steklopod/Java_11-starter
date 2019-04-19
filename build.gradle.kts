plugins {
    java
    id ("org.springframework.boot") version "2.1.4.RELEASE"
    id ("io.spring.dependency-management") version "1.0.7.RELEASE"
    id ("com.github.ben-manes.versions") version "0.21.0"
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
    implementation("com.h2database:h2")
    implementation("org.postgresql:postgresql:42.2.2")
    implementation("org.liquibase:liquibase-core:3.6.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Tests
    testImplementation("org.springframework.boot:spring-boot-starter-test"){ exclude(module = "junit") }
    testImplementation(
            "org.junit.jupiter:junit-jupiter-api",
            "io.github.benas:random-beans:3.9.0",
            "io.github.glytching:junit-extensions:2.3.0"
    )
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // Other
    implementation("org.jetbrains:annotations:17.0.0")
}


defaultTasks("clean", "build", "bootRun")