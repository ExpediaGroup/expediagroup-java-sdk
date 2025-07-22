plugins {
    id("com.expediagroup.sdk.openapigenerator") version "3.0.0"
}

version = "0.0.1-SNAPSHOT"
group = "com.expediagroup"

dependencies {
    api("com.expediagroup:expediagroup-sdk-rest:0.0.13-alpha")

    implementation(platform("com.fasterxml.jackson:jackson-bom:2.18.2"))
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    implementation("org.slf4j:slf4j-api:2.0.17")
}

egSdkGenerator {
    namespace = "exemplar"
    basePackage = "com.expediagroup.sdk.exemplar"
    specFilePath = File("${project.layout.projectDirectory}/transformed-spec.yml")

    objectMapper = "com.expediagroup.sdk.exemplar.core.mapper.DefaultObjectMapper.INSTANCE"
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
    dependsOn(":exemplar-sdk:generateEgSdk")
    commandLine("sh", "-c", "../gradlew :exemplar-sdk:ktlintFormat")
}

// Prepare the content for sdk.properties
val sdkPropertiesContent = """
    artifactName=exemplar-sdk
    version=$version
    groupId=$group
""".trimIndent()

// Configure the processResources task to include sdk.properties
tasks.named<ProcessResources>("processResources") {
    from(project.resources.text.fromString(sdkPropertiesContent)) {
        rename { "sdk.properties" }
    }
}
