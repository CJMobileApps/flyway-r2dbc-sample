import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.7"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.cjmobileapps"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("org.postgresql:postgresql:42.3.4")

	// flyway
	implementation("org.flywaydb:flyway-core:8.5.10")

	//jdbc
	implementation("org.springframework.boot:spring-boot-starter-jdbc:2.6.7")

//	implementation("org.springframework.data:spring-data-r2dbc")
//	implementation("io.r2dbc:r2dbc-spi:0.9.1.RELEASE")
//	implementation("org.postgresql:r2dbc-postgresql:0.9.1.RELEASE")

	// coroutine
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.1")



	testImplementation("org.springframework.boot:spring-boot-starter-test")
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
