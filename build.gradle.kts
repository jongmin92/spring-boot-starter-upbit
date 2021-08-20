import com.linecorp.support.project.multi.recipe.configureByTypePrefix
import com.linecorp.support.project.multi.recipe.configureByTypeSuffix
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
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

configureByTypeSuffix("lib") {
    apply(plugin = "java-library")
}
