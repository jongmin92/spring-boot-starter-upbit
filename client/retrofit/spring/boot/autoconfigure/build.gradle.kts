import org.unbrokendome.gradle.plugins.testsets.dsl.testSets

plugins {
    id("org.unbroken-dome.test-sets").version("4.0.0")
}

testSets {
    val springBootTest by creating
    val integrationTest by creating
}

tasks {
    val test by getting

    val springBootTest by getting {
        shouldRunAfter(test)
    }
    val integrationTest by getting {
        shouldRunAfter(test)
    }

    val check by getting {
        dependsOn(springBootTest, integrationTest)
    }
}

val mockServerProject = project(":server:mock")
val mockServerProjectTestSet = mockServerProject.sourceSets["test"].output

dependencies {
    implementation(project(":client:retrofit"))

    // spring
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit")

    // jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // armeria
    implementation("com.linecorp.armeria:armeria-retrofit2")

    "integrationTestImplementation"(mockServerProject)
    "integrationTestImplementation"(mockServerProjectTestSet)
}
