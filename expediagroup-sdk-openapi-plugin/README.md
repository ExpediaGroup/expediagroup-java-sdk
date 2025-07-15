# Expedia Group JVM SDK - OpenAPI Generator Plugin
A custom Gradle plugin built on the [OpenAPI Generator](https://github.com/OpenAPITools/openapi-generator), aimed to streamline the creation of SDK operations and models from your OpenAPI specifications. By applying custom Mustache templates in place of the defaults, the plugin produces fully functional, ready-to-use classes that integrate seamlessly with the EG SDK REST module.

## Usage
The plugin requires Gradle running on **Java 11** or higher. All generated source code, however, is compiled for Java 8 compatibility; allowing you to integrate it into projects running **Java 8**.

Since it's a Gradle plugin, it requires a Gradle module to properly apply the plugin.

```kts
plugins {
    id("com.expediagroup.sdk.openapigenerator") version "${latest-version}"
}
```

Ensure `mavenCentral()` and `gradlePluginPortal()` are defined in your `settings.gradle.kts`:

```kts
pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}
```

In your `build.gradle.kts`, add and configure the `egSdkGenerator` block:

```kts
egSdkGenerator {
  // Plugin Options
}
```

See the [Configuration Options](#configuration-options) section for all available options.

## Tasks & Extensions
Gradle plugins are built around two key concepts:

- **Tasks**  
  Discrete units of work that encapsulate the logic for a specific build operation (for example, generating source code or publishing an artifact).

- **Extensions**  
  Configuration objects you declare in your build script. By setting properties on an extension block, you customize how the plugin’s tasks behave.

The plugin provides a primary task, `generateEgSdk` (implemented by the `GenerateEgSdkTask` class), which collects your `egSdkGenerator` extension settings, applies default values and generation conventions, and writes the resulting source files to the configured output directory.

You customize its behavior via the `egSdkGenerator` extension in your `build.gradle.kts`. For example:

```kotlin
egSdkGenerator {
    namespace = "lodging"
    // add any other configuration options here
}
```

#### Configuration Options

| Option                 | Description                                                                                                    | Required? | Default                                                          |
|------------------------|----------------------------------------------------------------------------------------------------------------|-----------|------------------------------------------------------------------|
| `specFilePath`         | Path to the OpenAPI specification file used by the generator.                                                  | Yes       | _None_                                                           |
| `basePackage`          | Root package under which all generated code will be organized.                                                | Yes       | _None_                                                           |
| `modelPackage`         | Package name for the generated model classes.                                                                 | No        | `com.expediagroup.sdk.<namespace>.model`                         |
| `operationPackage`     | Package name for the generated operation (API) classes.                                                       | No        | `com.expediagroup.sdk.<namespace>.operation`                     |
| `objectMapper`         | Fully-qualified class name of the Jackson `ObjectMapper` to use for JSON serialization and deserialization.   | Yes       | _None_                                                           |
| `customTemplatesDir`   | Directory containing user-provided Mustache templates to override the defaults.                                | No        | _None_                                                           |
| `outputDir`            | Filesystem directory where the generated Kotlin source files will be written.                                  | No        | `src/main/kotlin`                                                |
| `namespace`            | Namespace segment appended to the base package (e.g., `com.expediagroup.sdk.{namespace}`).                     | Yes       | _None_                                                           |
| `operationProcessors`  | Functions to post-process each generated operation before template rendering.                                  | No        | _Empty list_                                                     |
| `modelProcessors`      | Functions to post-process each generated model before template rendering.                                      | No        | _Empty list_                                                     |
| `lambdas`              | Named Mustache lambdas available for use within templates.                                                     | No        | _Empty list_                                                     |
| `supportingTemplates`  | Additional supporting-file templates to copy verbatim into the output directory.                               | No        | _Empty list_                                                     |
| `apiTemplates`         | Additional API-level Mustache templates to render alongside the defaults.                                      | No        | _Empty list_                                                     |



## Custom Mustache Templates

## Mustache Utilities

## User Provided Templates
