[![Maven Central](https://img.shields.io/maven-central/v/com.expediagroup/expediagroup-sdk-core.svg)](https://search.maven.org/artifact/com.expediagroup/expediagroup-sdk-core)

# Expedia Group JVM SDK - Core Module
The `expediagroup-sdk-core` module serves as a reusable component that abstracts common functionalities, such as HTTP request execution, authentication, logging, and execution pipeline processing. It empowers product SDKs to focus on business-specific logic while ensuring consistency, flexibility, and maintainability.

## Usage
In most cases, you don’t need to add `expediagroup-sdk-core` directly, just include `expediagroup-sdk-rest` or `expediagroup-sdk-graphql` in your project, and the core module will be pulled in transitively.

<details>
  <summary><strong>Maven</strong></summary>

  Add the `expediagroup-sdk-core` as a dependency in your `pom.xml`:

  ```xml
  <dependency>
    <groupId>com.expediagroup</groupId>
    <artifactId>expediagroup-sdk-core</artifactId>
    <version>{latest-version}</version>
  </dependency>
  ```
</details>


<details>
  <summary><strong>Gradle</strong></summary>

  Add the `expediagroup-sdk-core` as a dependency in your `build.gradle`:

  ```gradle
  implementation 'com.expediagroup:expediagroup-sdk-core:{latest-version}'
  ```
</details>

## Architecture & Components
The SDK Core module serves as the foundational "shell" that abstracts the execution of requests and responses via an **injected** HTTP client. It acts as a toolkit, empowering product SDKs to deliver a polished and user-friendly experience by providing ready-to-use components such as request execution, logging, authentication, and exception handling. The SDK core streamlines the development of cohesive SDKs.

### Transport Package
The `Transport` interface defines the abstraction layer for making HTTP requests within the SDK. This interface allows SDK users to integrate their preferred HTTP client or transport mechanism while adhering to a standardized contract. The SDK relies on this interface to execute requests and process responses, offering flexibility and compatibility across diverse environments and libraries. To achieve complete abstraction, the SDK core module introduces standardized HTTP models customized for SDK usage (in the http package), such as `Request` and `Response`, which all `Transport` implementations are required to use. These models ensure consistency in how the SDK interacts with external systems, regardless of the underlying HTTP client or transport mechanism.

> [!TIP]
> Refer to SDK Transport Usage Guide for more information and examples

### HTTP Package
As mentioned earlier, the core module doesn’t depend on any specific HTTP client. To make this possible, the SDK defines its own generic HTTP request and response models. At runtime, those SDK models are translated into the native types required by your chosen HTTP client (for example, converting to OkHttp’s `Request` and `Response` objects).

[http package](https://github.com/ExpediaGroup/expediagroup-java-sdk/tree/main/expediagroup-sdk-core/src/main/kotlin/com/expediagroup/sdk/core/http)

### Pipeline Package
While supporting injectable HTTP clients provides significant flexibility, it is essential to ensure that all requests made by the SDK adhere to governance and observability standards. This includes logging, authentication, client identification, and other critical processes, regardless of the underlying HTTP client being used. To achieve this, the core module introduces an `ExecutionPipeline`, which every product SDK must implement to integrate with the core.

Each product SDK defines its own execution pipeline by composing "request pipeline **steps**" and "response pipeline **steps**". The core ensures that these steps are executed in the correct sequence: request steps are applied before the request is executed, and response steps are applied after the response is received.

The primary entry point for integrating a product SDK with the core is through the `AbstractRequestExecutor` for synchronous calls and the `AbstractAsyncRequestExecutor` for asynchronous calls. These abstract classes enforce a consistent integration pattern by requiring implementers (i.e., product SDKs) to define the necessary `ExecutionPipeline`. This guarantees that governance and observability processes are applied consistently across all product SDKs, irrespective of the HTTP client used.

[pipeline package](https://github.com/ExpediaGroup/expediagroup-java-sdk/tree/main/expediagroup-sdk-core/src/main/kotlin/com/expediagroup/sdk/core/pipeline)

### Authentication Package
The core module includes a suite of prebuilt components for handling common authentication schemes - such as Basic Auth & OAuth - so you don’t have to reinvent the wheel. True to the core’s “pluggable pipeline” philosophy, it provides the building blocks for each authentication workflow but leaves it up to the product SDK to decide when to invoke them.

In practice, you simply add one of the supplied pipeline steps (for example, `BasicAuthStep` or `OAuthStep`) to your request execution pipeline. If your product SDK requires a custom authentication mechanism that isn’t yet provided, you can implement the `RequestPipelineStep` interface yourself, insert your new step into the pipeline, and encapsulate all of your custom auth logic there. This approach keeps authentication concerns isolated, consistent, and easy to extend.

[auth package](https://github.com/ExpediaGroup/expediagroup-java-sdk/tree/main/expediagroup-sdk-core/src/main/kotlin/com/expediagroup/sdk/core/auth)

### Logging Package
All SDK modules rely on the `SLF4J` API for logging without shipping a concrete implementation, so you remain free to choose any `SLF4J` binding (such as Logback or Log4j2) at runtime. To turn on request and response logging, simply register the built-in `RequestLoggingStep` and `ResponseLoggingStep` in your execution pipeline; as long as you include a valid `SLF4J` binding on your classpath, those steps will automatically emit detailed logs for each outbound HTTP request and inbound HTTP response through your chosen logging framework.

_A product SDK shouldn't provide the SLF4J implementation itself. This should be up to the end-user of the product SDK._

Beyond basic request and response logging, the core module also lets you automatically redact any sensitive information - whether it lives in HTTP headers or in the body of a request or response - so that secrets never end up in your logs.

[logging package](https://github.com/ExpediaGroup/expediagroup-java-sdk/tree/main/expediagroup-sdk-core/src/main/kotlin/com/expediagroup/sdk/core/logging)

### Exception Package
The SDK has a set of exception models each for a defined purpose, categorized based on the exception nature:
- Client exception: Any exception that might be thrown or caused by the SDK itself (e.g. Configuration exception)
- Service exception: Any exception that's caused by the remote server (e.g Authentication Exception).
- All exceptions extend `ExpediaGroupException`.
- All service exceptions extend `ExpediaGroupServiceException`.
- All client exceptions extend `ExpediaGroupClientException`.

[exception packagae](https://github.com/ExpediaGroup/expediagroup-java-sdk/tree/main/expediagroup-sdk-core/src/main/kotlin/com/expediagroup/sdk/core/exception)


## Metadata Loader
The core module includes a utility for loading runtime metadata such as SDK name, JVM version, SDK version, locale, etc... from `sdk.properties` file. Each product SDK must bundle this file in its resources, and it’s typically generated automatically during the build process.

## Full Integration View - Diagram
The diagram below illustrates the architecture and interaction between a product SDK and the SDK Core, highlighting the flow of operations and the role of various components in synchronous and asynchronous request execution.

![Untitled-4](https://github.com/user-attachments/assets/65174c90-1881-4651-bef0-6554f00dab86)

#### Operations & Models
- Located at the far left, these represent the business-specific **operations** and models defined by the product SDK. These models will be typically **generated** by OpenAPI generator for REST SDKs, and from Apollo Kotlin for GraphQL SDKs.
- These are entirely decoupled from the core module and are responsible for defining the domain-specific request and response structures.
- The operations are converted into SDK requests, which are later executed via the core module.

#### Sync Client
- Represents the high-level client responsible for handling synchronous requests.
- Converts an operation into a valid SDK request and sends it for execution.
- Should encapsulate one implementation of `AbstractRequestExecutor` where this client can access the `execute` method along with the execution pipeline.
- After receiving the response, the sync client converts the SDK response back into the corresponding operation response.

#### Async Client
- Represents the high-level client handling asynchronous requests.
- Converts an operation into a valid SDK request and sends it for execution.
- Should encapsulate one implementation of `AbstractAsyncRequestExecutor` where this client can access the `execute` method along with the execution pipeline.
- Once the response is received (via a `CompletableFuture`), it is asynchronously converted into the corresponding operation response.

#### Core Module:
- SDK HTTP Models: Standardized Request and Response objects for consistent communication.
- Authentication Module: Handles various authentication mechanisms.
- Logging Module: Enables request/response logging for observability.
- Metadata Loader: Loads extra runtime information about the SDK such as artifact name, version, Java version, and host OS.

#### Execution Pipelines
- Request Pipeline: Depicted with blue blocks, this pipeline processes the SDK request through a series of defined steps (e.g., adding headers, logging) before sending it to the transport layer.
- Response Pipeline: Depicted with green blocks, this pipeline processes the SDK response through defined steps (e.g., logging) after it is received from the transport layer.

#### Transport Layer
- Sync Transport: Processes synchronous requests and returns a blocking response.
- Async Transport: Processes asynchronous requests and returns a `CompletableFuture<Response>`.
- By default, both `Transport` and `AsyncTransport` use the same HTTP client instance.






