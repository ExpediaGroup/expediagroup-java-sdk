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

<br />

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
One of the features of the core module is its flexibility in supporting diverse HTTP clients by allowing end-users or product SDKs to inject their preferred implementations. This is achieved by implementing the `Transport` interface for synchronous requests or the `AsyncTransport` interface for asynchronous requests. While the core is designed to accommodate this flexibility, it is ultimately up to the product SDK to determine whether to enable such extensibility or restrict usage to a specific provided HTTP client.

> [!TIP]
> Refer to SDK Transport Usage Guide for more information and examples




