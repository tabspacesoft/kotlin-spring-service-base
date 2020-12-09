import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.0"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	id("org.jetbrains.kotlin.plugin.jpa") version "1.4.20"
	id("org.jetbrains.kotlin.plugin.noarg") version "1.4.10"
	kotlin("jvm") version "1.4.10"
	kotlin("plugin.spring") version "1.4.10"
}

group = "com.tabspace.restkt"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.security:spring-security-web:5.4.1")
	implementation("org.springframework.security:spring-security-config:5.4.1")
	implementation("org.springframework.security.oauth:spring-security-oauth2:2.4.1.RELEASE")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.hibernate:hibernate-validator:6.1.6.Final")
	implementation("org.hibernate.validator:hibernate-validator-cdi:6.1.6.Final")
	implementation("org.glassfish:jakarta.el:3.0.3")
	// JAX-B dependencies for JDK 9+
	// https://stackoverflow.com/questions/43574426/java-how-to-resolve-java-lang-noclassdeffounderror-javax-xml-bind-jaxbexceptio
	implementation("jakarta.xml.bind:jakarta.xml.bind-api:2.3.2")
	implementation("org.glassfish.jaxb:jaxb-runtime:2.3.2")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
