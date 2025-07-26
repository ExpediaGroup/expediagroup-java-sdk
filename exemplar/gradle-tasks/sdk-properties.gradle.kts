/**
 * Common task used to generate the sdk.properties file for SDKs.
 * This file contains metadata about the SDK, such as its name, version, and group ID. Which used to construct the user agent header.
 */

// Prepare the content for sdk.properties
val sdkPropertiesContent =
    """
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
