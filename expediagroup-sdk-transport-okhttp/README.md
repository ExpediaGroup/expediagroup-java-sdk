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


## Sync OkHttp Transport

## Async OkHttp Transport

## 
