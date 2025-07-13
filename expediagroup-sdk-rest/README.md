[![Maven Central](https://img.shields.io/maven-central/v/com.expediagroup/expediagroup-sdk-rest.svg)](https://search.maven.org/artifact/com.expediagroup/expediagroup-sdk-rest)

# Expedia Group JVM SDK - REST Module
The REST extension module delivers first-class support for building type-safe HTTP clients. It handles JSON deserialization out of the box, and maps HTTP status codes to domain-specific exceptions all while plugging seamlessly into the core SDK’s execution pipeline for authentication, logging, and more.

Packaged as its own artifact `com.expediagroup:expediagroup-sdk-rest`, it keeps non-REST SDKs lean: simply add the REST dependency to your build and Maven/Gradle will transitively pull in the core module for you.
