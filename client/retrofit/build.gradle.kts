dependencies {
    api(project(":service"))
    api(project(":token"))

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")

    // jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.4")

    // armeria
    implementation(platform("com.linecorp.armeria:armeria-bom:1.10.0"))
    implementation("com.linecorp.armeria:armeria-retrofit2")
}
