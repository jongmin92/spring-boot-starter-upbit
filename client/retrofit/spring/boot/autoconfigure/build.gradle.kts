import org.unbrokendome.gradle.plugins.testsets.dsl.testSets

plugins {
    id("org.unbroken-dome.test-sets").version("4.0.0")
}

dependencies {
    implementation(project(":client:retrofit"))

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")

    // jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.4")

    // armeria
    implementation(platform("com.linecorp.armeria:armeria-bom:1.10.0"))
    implementation("com.linecorp.armeria:armeria-retrofit2")
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
