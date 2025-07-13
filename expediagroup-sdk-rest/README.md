[![Maven Central](https://img.shields.io/maven-central/v/com.expediagroup/expediagroup-sdk-rest.svg)](https://search.maven.org/artifact/com.expediagroup/expediagroup-sdk-rest)

# Expedia Group JVM SDK - REST Module
The REST extension module delivers first-class support for building type-safe HTTP clients. It handles JSON deserialization out of the box, and maps HTTP status codes to domain-specific exceptions all while plugging seamlessly into the core SDK’s execution pipeline for authentication, logging, and more.

Packaged as its own artifact `com.expediagroup:expediagroup-sdk-rest`, it keeps non-REST SDKs lean: simply add the REST dependency to your build and Maven/Gradle will transitively pull in the core module for you.

## Installation
_The `expediagroup-sdk-rest` requires Java 8 or higher._

<details>
  <summary><strong>Maven</strong></summary>

  Add the `expediagroup-sdk-rest` as a dependency in your `pom.xml`:

  ```xml
  <dependency>
    <groupId>com.expediagroup</groupId>
    <artifactId>expediagroup-sdk-rest</artifactId>
    <version>{latest-version}</version>
  </dependency>
  ```
</details>


<details>
  <summary><strong>Gradle</strong></summary>

  Add the `expediagroup-sdk-rest` as a dependency in your `build.gradle`:

  ```gradle
  implementation 'com.expediagroup:expediagroup-sdk-rest:{latest-version}'
  ```
</details>

## Architecture & Components
The REST module provides the core abstractions for defining REST operations, everything from URLs processing and payload (de)serialization to the executor classes that drive request execution. 

It’s designed to work hand-in-hand with our customized [expediagroup-sdk-openapi-plugin](https://github.com/ExpediaGroup/expediagroup-java-sdk/tree/main/expediagroup-sdk-openapi-plugin), which reads your OpenAPI spec and produces operation classes that plug directly into these executors and clients.

### Operations Traits

The REST module defines a set of trait interfaces that generated operation classes implement to support specific HTTP features. Each trait corresponds to a distinct aspect of the OpenAPI specification:

| Trait Interface                               | Description                                                          |
|-----------------------------------------------|----------------------------------------------------------------------|
| `OperationRequestTrait`                       | Base interface implemented by all operations for common behavior.    |
| `ContentTypeTrait`                            | Implemented by operations with a `Content-Type` defined in the spec. |
| `UrlQueryParamsTrait`                         | Implemented by operations that include query parameters.             |
| `UrlPathTrait`                                | Implemented by operations that include path variables.               |
| `HeadersTrait`                                | Implemented by operations that define HTTP headers.                  |
| `OperationRequestBodyTrait`                   | Implemented by operations that send a request body.                  |
| `OperationNoResponseBodyTrait`                | Implemented by operations that do not return a response body.        |
| `OperationResponseBodyTrait` (and subclasses) | Implemented by operations with a defined response body.              |


### OpenAPI Generator Integration
Most product SDKs using the REST module rely on the [expediagroup-sdk-openapi-plugin](https://github.com/ExpediaGroup/expediagroup-java-sdk/tree/main/expediagroup-sdk-openapi-plugin) to generate operation classes from your OpenAPI specification. This custom Gradle plugin is preconfigured to target the REST module’s trait interfaces and executor patterns, so the generated code plugs in seamlessly and requires virtually no manual wiring.

> [!NOTE]
> The generator is currently available only as a Gradle plugin, so you’ll need a Gradle-based project or submodule to run the code generation step.  

### REST Clients
The REST module provides a high-level abstract class, `GraphQLClient`, which serves as the integration point between your product SDK and the core SDK internals (executors, transports, etc.). 

When you instantiate a `RestClient`, you need to supply a `RestExecutor` instance — a component responsible for orchestrating request execution and mapping errors to the SDK’s exception model. Under the hood, the `RestExecutor` delegates to an `AbstractRequestExecutor` implementation from the core module, where you configure your request pipeline (authentication, logging, masking, etc.).

```mermaid
flowchart LR
  RCI[MyRestClient]
  RC[RestClient]
  RE[RestExecutor]
  ARE[AbstractRequestExecutor]

  %% relationships
  RCI --> |extends| RC
  RC --> |uses| RE
  RE --> |uses| ARE
```

### Serialization & Deserialization
The REST module uses Jackson to handle JSON serialization and deserialization of request and response bodies. Product SDKs must supply a fully configured `ObjectMapper` to the executors, which will be used for all (de)serialization operations. We recommend reusing a single `ObjectMapper` instance across all clients to ensure consistent configuration. Consequently, the SDK does not create or configure `ObjectMapper` instances internally.



















