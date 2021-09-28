import com.linecorp.support.project.multi.recipe.configureByTypeHaving
import com.linecorp.support.project.multi.recipe.configureByTypePrefix
import com.linecorp.support.project.multi.recipe.configureByTypeSuffix
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("maven-publish")
    id("com.linecorp.build-recipe-plugin") version "1.1.1"
    kotlin("jvm") version "1.5.31"
    kotlin("kapt") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31" apply false
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

subprojects {
    apply<MavenPublishPlugin>()

    repositories {
        mavenLocal()
        mavenCentral()
    }
}

configureByTypePrefix("kotlin") {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    java {
        targetCompatibility = JavaVersion.VERSION_1_8
    }

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
        api(platform("com.linecorp.armeria:armeria-bom:1.11.0"))
        listOf("retrofit", "converter-jackson").forEach {
            api(platform("com.squareup.retrofit2:$it:2.9.0"))
        }

        api("org.jetbrains.kotlin:kotlin-reflect")
        api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        api("org.jetbrains.kotlinx:kotlinx-coroutines-core")
        api("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")

        testImplementation(kotlin("test"))
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
        testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
        testImplementation("org.assertj:assertj-core")
    }
}

configureByTypeHaving("boot") {
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    dependencies {
        kapt("org.springframework.boot:spring-boot-autoconfigure-processor:2.5.4")
        kapt("org.springframework.boot:spring-boot-configuration-processor:2.5.4")

        implementation("org.springframework.boot:spring-boot")
        implementation("org.springframework.boot:spring-boot-autoconfigure")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}

configureByTypeSuffix("lib") {
    apply(plugin = "java-library")

    publishing {
        publications {
            create<MavenPublication>("mavenJar") {
                groupId = resolvedGroupName(project)
                artifactId = resolvedModuleName(project)
                from(components["java"])
            }
        }
    }
}

fun resolvedGroupName(project: Project): String {
    return project.group.toString()
}

fun resolvedModuleName(project: Project): String {
    var self = project
    var name = self.name

    while (self.parent != project.rootProject) {
        self = self.parent!!
        name = "${self.name}-${name}"
    }

    return name
}
