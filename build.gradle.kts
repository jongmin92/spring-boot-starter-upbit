import com.linecorp.support.project.multi.recipe.configureByTypeHaving
import com.linecorp.support.project.multi.recipe.configureByTypePrefix
import com.linecorp.support.project.multi.recipe.configureByTypeSuffix
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.linecorp.build-recipe-plugin") version "1.1.1"
    kotlin("jvm") version "1.5.30"
    kotlin("kapt") version "1.5.30"
    kotlin("plugin.spring") version "1.5.30" apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}

configureByTypePrefix("kotlin") {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    tasks {
        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "1.8"
        }

        withType<Test> {
            useJUnitPlatform()
        }
    }

    dependencies {
        api(platform("org.springframework.boot:spring-boot-dependencies:2.5.4"))
        api(platform("org.jetbrains.kotlin:kotlin-bom:1.5.30"))
        api(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.5.2"))

        api("org.jetbrains.kotlin:kotlin-reflect")
        api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        testImplementation(kotlin("test"))
        testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
        testImplementation("org.assertj:assertj-core")
    }
}

configureByTypeHaving("boot") {
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

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
