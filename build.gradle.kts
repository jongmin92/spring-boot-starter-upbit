import com.linecorp.support.project.multi.recipe.configure
import com.linecorp.support.project.multi.recipe.configureByTypeHaving
import com.linecorp.support.project.multi.recipe.configureByTypePrefix
import com.linecorp.support.project.multi.recipe.configureByTypeSuffix
import com.linecorp.support.project.multi.recipe.matcher.ProjectMatchers.Companion.byTypeHaving
import com.linecorp.support.project.multi.recipe.matcher.ProjectMatchers.Companion.byTypeSuffix
import com.linecorp.support.project.multi.recipe.matcher.and
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    id("org.springframework.boot") version "2.5.4" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
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

dependencies {
    testImplementation(kotlin("test"))
}

configureByTypePrefix("kotlin") {
    apply(plugin = "kotlin")

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    dependencies {
        api("org.jetbrains.kotlin:kotlin-reflect")
        api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }
}

configureByTypeHaving("boot") {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "kotlin-spring")

    dependencies {
        implementation("org.springframework.boot:spring-boot")
        annotationProcessor("org.springframework.boot:spring-boot-autoconfigure-processor")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}

configureByTypeSuffix("lib") {
    apply(plugin = "java-library")
}

configure(byTypeHaving("boot") and byTypeSuffix("lib")) {
    tasks {
        withType<Jar> {
            enabled = true
        }

        withType<BootJar> {
            enabled = false
        }

        withType<BootRun> {
            enabled = false
        }
    }
}
