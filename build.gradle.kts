import com.linecorp.support.project.multi.recipe.configureByTypeHaving
import com.linecorp.support.project.multi.recipe.configureByTypePrefix
import com.linecorp.support.project.multi.recipe.configureByTypeSuffix
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("kapt") version "1.5.21"
    kotlin("plugin.spring") version "1.4.21" apply false
    id("com.linecorp.build-recipe-plugin") version "1.1.1"
}

allprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

configureByTypePrefix("kotlin") {
    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.kotlin.kapt")

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    dependencies {
        api(platform("org.springframework.boot:spring-boot-dependencies:2.5.4"))

        api("org.jetbrains.kotlin:kotlin-reflect")
        api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        testImplementation(kotlin("test"))
        testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
        testImplementation("org.assertj:assertj-core")
    }
}

configureByTypeHaving("boot") {
    apply(plugin = "kotlin-spring")

    dependencies {
        kapt("org.springframework.boot:spring-boot-autoconfigure-processor:2.5.4")

        implementation("org.springframework.boot:spring-boot")
        implementation("org.springframework.boot:spring-boot-autoconfigure")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}

configureByTypeSuffix("lib") {
    apply(plugin = "java-library")
}
