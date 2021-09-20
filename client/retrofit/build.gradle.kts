dependencies {
    api(project(":service"))
    api(project(":token"))

    // retrofit
    implementation("com.squareup.retrofit2:retrofit")
    implementation("com.squareup.retrofit2:converter-jackson")

    // jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // armeria
    implementation("com.linecorp.armeria:armeria-retrofit2")
}
