[![Maven Central](https://img.shields.io/maven-central/v/com.expediagroup/expediagroup-sdk-transport-okhttp.svg)](https://search.maven.org/artifact/com.expediagroup/expediagroup-sdk-transport-okhttp)

# Expedia Group JVM SDK - OkHttp Transport
The `expediagroup-sdk-transport-okhttp` module provides an implementation of the `Transport` interface using the [OkHttp](https://square.github.io/okhttp/) library. This module is designed to integrate seamlessly with the Expedia Group SDK, enabling efficient and reliable HTTP communication for SDK clients.

## Overview
This module acts as a bridge between the core SDK's `Transport` abstraction and the OkHttp library. It provides the following key features:
- Converts SDK `Request` objects into OkHttp requests.
- Executes HTTP requests using OkHttp's client.
- Converts OkHttp responses back into SDK `Response` objects.
- Handles network exceptions and maps them to SDK-specific exceptions.
- Supports custom configuration of the OkHttp client
  
## Installation
The `expediagroup-sdk-transport-okhttp` module requires **Java 8** or higher.

<details>
  <summary><strong>Maven</strong></summary>

  Add the `expediagroup-sdk-transport-okhttp` as a dependency in your `pom.xml`:

  ```xml
  <dependency>
    <groupId>com.expediagroup</groupId>
    <artifactId>expediagroup-sdk-transport-okhttp</artifactId>
    <version>{latest-version}</version>
  </dependency>
  ```
</details>


<details>
  <summary><strong>Gradle</strong></summary>

  Add the `expediagroup-sdk-core` as a dependency in your `build.gradle`:

  ```gradle
  implementation 'com.expediagroup:expediagroup-sdk-transport-okhttp:{latest-version}'
  ```
</details>

### Auto-Detection of Transport
Once the `expediagroup-sdk-transport-okhttp` dependency is added to your project, the core SDK module will automatically detect and use it as the transport implementation using the `ServiceLoader` mechanism. There is no need for explicit instantiation or configuration.

> [!Tip]
> Do **not** include `expediagroup-sdk-transport-okhttp` as a dependency in your product SDK artifact. Instead, ask end users to add it (or any other transport implementation) alongside your SDK in their application’s build. This ensures they can choose the HTTP transport they prefer.
>
> Currently, only the OkHttp transport is available; future releases may offer additional implementations.  

## Examples and Playground
For more hands-on examples, please refer to the [exemplar](../exemplar) module 🚀.


## Synchrounous & Asynchrounous Transports
The `expediagroup-sdk-transport-okhttp` module provides both synchronous and asynchronous implementations of the `Transport` interface, enabling flexibility based on your application's requirements.

#### Synchronous Transport
The `OkHttpTransport` class implements the `Transport` interface for executing synchronous HTTP requests. It converts SDK `Request` objects into OkHttp requests, executes them, and maps the responses back into SDK `Response` objects.

#### Asynchronous Transport
The `OkHttpAsyncTransport` class implements the `AsyncTransport` interface for executing asynchronous HTTP requests, returning a `CompletableFuture<Response>` for non-blocking operations. This is useful for applications requiring high concurrency or prefer non-blocking approach.

## Configuration
This transport implementation enables users to configure the underlying OkHttp instance with thier prefered settings. This can be done by providing a custom `OkHttpClientConfiguration` when creating an instance of `OkHttpTransport`.

```java
OkHttpClientConfiguration okHttpConfig = OkHttpClientConfiguration.builder()
    .callTimeout(100000)
    .connectTimeout(100000)
    .readTimeout(100000)
    .build();

OkHttpTransport transport = new OkHttpTransport(okHttpConfig);
```

