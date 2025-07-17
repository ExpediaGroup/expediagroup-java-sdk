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

## Mustache Lambdas
To unlock advanced code‐generation features, the plugin registers custom Mustache lambdas—small helper functions that templates can invoke during rendering. Each lambda receives its current context (for example, a `CodegenOperation` or `CodegenModel`) and returns a modified data structure or formatted string, enabling dynamic filtering, transformation, and formatting.

For instance, the `nonBodyParams` lambda filters out body parameters from an operation’s parameter list. In a template you can write:

```mustache
{{#nonBodyParams}}
  {{#params}}
  * @property {{{paramName}}} – {{{description}}}
  {{/params}}
{{/nonBodyParams}}
```

Here, `nonBodyParams` supplies a context containing only query, path, and header parameters. The inner `{{#params}}` block then iterates over that filtered list to generate documentation lines. By leveraging custom lambdas like this, your templates remain clean and your generated code becomes more intuitive and maintainable.

[Lambdas.kt](https://github.com/ExpediaGroup/expediagroup-java-sdk/blob/main/expediagroup-sdk-openapi-plugin/src/main/kotlin/com/expediagroup/sdk/openapigenerator/mustache/Lambdas.kt)

#### Internal Configuration
The `generateEgSdk` task drives the OpenAPI Generator with a predefined set of defaults, custom Mustache lambdas, and processor hooks. While some of these settings can be tailored via the `egSdkGenerator` extension, a core subset remains fixed to uphold SDK conventions.

All configuration logic is centralized in the `GenerateEgSdkTask` class, which defines:

- **Global generator settings**: package names, template directories, output paths, and other generator-wide options.  
- **SDK-specific registrations**: Mustache lambdas and operation/model processors required by our custom templates.

For a complete overview of every applied configuration and registered lambda, review the `GenerateEgSdkTask.kt` source code [here](https://github.com/ExpediaGroup/expediagroup-java-sdk/blob/main/expediagroup-sdk-openapi-plugin/src/main/kotlin/com/expediagroup/sdk/openapigenerator/task/GenerateEgSdkTask.kt).

## User-Provided Templates
By default, the plugin uses its bundled Mustache templates. You can override any of these or add new ones by pointing the `customTemplatesDir` option at your own template folder. All files in that directory will be registered and rendered.

### Overriding SDK Templates
Mirror the SDK template path and filename in your project. For example, to override `api.mustache`:

```
project-root/
└── src/
 └── main/
  └── resources/
   └── templates/
    └── api.mustache
```

Then, configure the plugin to use your directory:

```kotlin
egSdkGenerator {
  customTemplatesDir.set(layout.projectDirectory.dir("src/main/resources/templates"))
}
```

Any template in `customTemplatesDir` with a matching name and path will replace the default; additional templates will be rendered alongside the standard ones.

#### API Templates
You can also define extra API-level templates under your `customTemplatesDir` and register them via the `apiTemplates` option. Each entry specifies the source template file, its target package path, and the filename suffix:

```kotlin
egSdkGenerator {
  customTemplatesDir.set(layout.projectDirectory.dir("src/main/resources/templates"))
  apiTemplates.set(listOf(
    ApiTemplate(
      templateFile = "my-custom-api.mustache",
      destinationPath = "com/expediagroup/sdk/lodging/api",
      fileNameSuffix = "Api.kt"
    )
  ))
}
```

Templates listed in `apiTemplates` will be rendered into `com.expediagroup.sdk.lodging.api` with the `Api.kt` suffix (`{OperationName}Api.kt`).

#### Supporting Templates

You can define additional supporting‐file templates under your `customTemplatesDir` and register them via the `supportingTemplates` option. Example:

```kotlin
egSdkGenerator {
  customTemplatesDir.set(layout.projectDirectory.dir("src/main/resources/templates"))
  supportingTemplates.set(listOf(
    SupportingTemplate(
      templateFile      = "my-custom-supporting-class.mustache",
      destinationPath   = "com/expediagroup/sdk/lodging/model",
      fileName          = "Utilities.kt"
    )
  ))
}
```

This template will be copied into `com.expediagroup.sdk.lodging.model` and rendered with the filename you specify - `Utilities.kt`.

#### API Templates vs. Supporting Templates

OpenAPI Generator defines distinct template categories. Here’s how they differ:

| Aspect                     | API Templates                               | Supporting Templates                          |
|----------------------------|---------------------------------------------|-----------------------------------------------|
| Template category          | `TemplateFileType.API`                      | `TemplateFileType.SUPPORTING`                 |
| Invocation frequency       | Once per operation in the OpenAPI spec      | Once per template file                        |
| Purpose                    | Generate operation classes/methods          | Generate standalone files (helpers, extra models, resources) |
| Configuration property     | `egSdkGenerator { apiTemplates }`           | `egSdkGenerator { supportingTemplates }`      |
| File naming control        | Uses `fileNameSuffix`                       | Uses `fileName` (explicit)                    |
| Output package/directory   | Under the configured operation package      | Under the specified destination path          |

_For more details, see the OpenAPI Generator templating documentation on [Template File Types](https://openapi-generator.tech/docs/templating#template-file-types)._


## User Provided Processors & Lambdas

## Recommnedation


