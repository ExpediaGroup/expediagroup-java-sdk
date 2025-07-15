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

See the [Gradle Plugin](#gradle-plugin) section for all available configuration options.

## Components & Architecture


### Gradle Plugin

### Custom Mustache Templates

###  Mustache Utilities

### User Provided Templates
