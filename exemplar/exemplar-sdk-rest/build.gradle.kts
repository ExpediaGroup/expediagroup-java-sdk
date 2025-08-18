plugins {
    id("com.expediagroup.sdk.openapigenerator") version "1.0.0"
}

version = "0.0.1-SNAPSHOT"
group = "com.expediagroup"

apply("../gradle-tasks/sdk-properties.gradle.kts")

dependencies {
    // Pulling the REST SDK as an API dependency to allow users to use the SDK internals without needing to add it explicitly.
    api("com.expediagroup:expediagroup-sdk-rest:1.0.0")

    // Product SDKs have to add jackson libraries as a dependency.
    implementation(platform("com.fasterxml.jackson:jackson-bom:2.19.2"))
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    // Don't force SLF4J implementation, as it is provided by the SDK user.
    implementation("org.slf4j:slf4j-api:2.0.17")
}

/**
 * Use the Expedia Group OpenAPI Generator plugin to generate the SDK Operations & Models from your OpenAPI spec.
 *
 * See `expediagroup-sdk-openapi-plugin` documentation for more details
 */
egSdkGenerator {
    basePackage = "com.expediagroup.sdk.exemplar.rest"
    specFilePath = File("${project.layout.projectDirectory}/transformed-spec.yml")
    objectMapper = "com.expediagroup.sdk.exemplar.rest.core.mapper.DefaultObjectMapper.INSTANCE"
}

/**
 * Transforms the merged OpenAPI spec file using the Expedia Group spec transformer.
 * This transformation:
 * - Adds required headers
 * - Converts operation IDs to tags
 * - Sets default string type to single quotes
 * - Processes the merged specs.yaml and outputs transformed-specs.yaml
 */
tasks.register<Exec>("transformSpecs") {
    workingDir = project.layout.projectDirectory.asFile
    commandLine(
        "npx",
        "--yes",
        "-p",
        "@expediagroup/spec-transformer",
        "cli",
        "--headers",
        "accept,accept-encoding,key",
        "--operationIdsToTags",
        "--defaultStringType",
        "QUOTE_SINGLE",
        "--input",
        "openapi.yaml",
        "--output",
        "transformed-spec.yml"
    )
}

/**
 * Generates the operations and models from the provided spec file and formats the generated code using ktlint.
 */
tasks.register<Exec>("generateAndFormat") {
    dependsOn(":exemplar-sdk-rest:generateEgSdk")
    commandLine("sh", "-c", "../gradlew :exemplar-sdk-rest:ktlintFormat")
}
