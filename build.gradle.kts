import OSS.Pom.licenseName
import OSS.Pom.licenseUrl
import OSS.Pom.scmConnection
import OSS.Pom.scmDeveloperConnection
import OSS.Pom.scmUrl
import OSS.Repository.releaseRepoUrl
import OSS.Repository.snapshotRepoUrl
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
    signing
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

subprojects {
    // Prevent the build of empty project by build-recipe-plugin
    if (!file("gradle.properties").exists()) {
        ext["type"] = null
    }
}

configureByTypePrefix("kotlin") {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    java {
        targetCompatibility = JavaVersion.VERSION_1_8
        withSourcesJar()
        withJavadocJar()
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "1.8"
        }

        withType<Test> {
            useJUnitPlatform()
        }

        withType<Javadoc> {
            source = sourceSets.main.get().allJava
            options.encoding = "UTF-8"
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
    apply(plugin = "signing")
    apply<MavenPublishPlugin>()

    tasks {
        withType<Jar> {
            archiveBaseName.set(resolvedModuleName())
        }

        publishing {
            publications {
                register<MavenPublication>("ossPublication") {
                    artifactId = resolvedModuleName()
                    afterEvaluate { from(components["java"]) }

                    pom {
                        name.set(OSS.Pom.name)
                        description.set(OSS.Pom.description)
                        url.set(OSS.Pom.url)
                        packaging = "jar"

                        licenses {
                            license {
                                name.set(licenseName)
                                url.set(licenseUrl)
                            }
                        }
                        developers {
                            OSS.Pom.developers
                        }
                        scm {
                            connection.set(scmConnection)
                            developerConnection.set(scmDeveloperConnection)
                            url.set(scmUrl)
                        }
                    }

                    repositories {
                        maven {
                            setUrl(if (version.endsWith("SNAPSHOT")) snapshotRepoUrl else releaseRepoUrl)
                            credentials {
                                username = getProperty("ossrh_username")
                                password = getProperty("ossrh_password")
                            }
                        }
                    }
                }
            }
        }

        signing {
            useInMemoryPgpKeys(getProperty("signing_secretKey"), getProperty("signing_password"))
            sign(publishing.publications["ossPublication"])
        }
    }
}
