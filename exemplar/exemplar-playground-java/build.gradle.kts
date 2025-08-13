plugins {
    id("java")
}

group = "com.expediagroup"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.expediagroup:expediagroup-sdk-transport-okhttp:1.0.0")
    implementation(project(":exemplar-sdk-rest"))
    implementation(project(":exemplar-sdk-graphql"))

    implementation("org.apache.logging.log4j:log4j-api:2.25.1")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.25.1")
}

tasks.test {
    useJUnitPlatform()
}
