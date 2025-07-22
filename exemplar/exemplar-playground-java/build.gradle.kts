plugins {
    id("java")
}

group = "com.expediagroup"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.expediagroup:expediagroup-sdk-transport-okhttp:0.0.6-alpha")
    implementation(project(":exemplar-sdk-rest"))
    implementation(project(":exemplar-sdk-graphql"))

    implementation("org.apache.logging.log4j:log4j-api:2.24.3")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.24.3")
}

tasks.test {
    useJUnitPlatform()
}
