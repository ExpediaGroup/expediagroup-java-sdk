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

TODO: Add detailed how-to-guide

## Custom Mustache Templates
This plugin replaces the OpenAPI Generator’s default Mustache templates with custom versions that align the generated code with the SDK’s conventions. As a result, all operation and model classes produced by the generator extend and interoperate with `expediagroup-sdk-rest` components, making them ready to execute within the SDK’s REST framework.

The custom mustahce templates are located in the `src/main/resources/templates` folder in the `expediagroup-sdk-openapi-plugin` module. Some of the templates there overrides the default templates in the original OpenAPI generatator, and others are custom templates specific for the SDK use cases.

Highlighting some of the templates used by the plugin:

#### Core Templates
- `api.mustache` - Generates API operation classes with exception handling, request/response types, and parameter validation
- `api_exception.mustache` - Creates custom exception classes for API-specific errors
- `data_class.mustache` - Generates data classes for request/response models
- `enum_class.mustache` - Creates enum classes for API constants and values

#### Variable Templates
- `data_class_opt_var.mustache` - Handles optional variables in data classes
- `data_class_req_var.mustache` - Handles required variables in data classes
- `interface_opt_var.mustache` - Defines optional variables in interfaces
- `interface_req_var.mustache` - Defines required variables in interfaces
  
#### Operation Templates
- `operation_params.mustache` - Generates parameter classes for API operations
- `operations/imports.mustache` - Manages import statements for operation classes
- `operations/params/builder.mustache` - Creates builder pattern for operation parameters

#### Partial Templates
- `partials/data_class_validations.mustache` - Adds validation logic to data classes
- `partials/datatype.mustache` - Defines data type mappings
- `partials/operation_params_validations.mustache` - Adds validation for operation parameters

#### Trait Templates
- `traits/implementation.mustache` - Provides common implementation code for generated classes
- `traits/imports.mustache` - Manages imports for trait implementations
- `traits/inheritance.mustache` - Defines inheritance patterns for generated classes


## Mustache Utilities

## User Provided Templates
