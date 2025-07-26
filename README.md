# Expedia Group Java SDK

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java](https://img.shields.io/badge/Java-1.8%2B-orange.svg)](https://openjdk.org/)
[![Gradle](https://img.shields.io/badge/Gradle-8.x-green.svg)](https://gradle.org/)

The **Expedia Group Java SDK Foundations** provides the core components and tools for building and maintaining our SDK libraries.
These foundations enable developers to create consistent, high-quality Java SDKs that interact with the Expedia Group platform.

> [!NOTE]
> Previous versions of the SDK core modules are available in maintenance mode in the [legacy](https://github.com/ExpediaGroup/expediagroup-java-sdk/tree/legacy) branch.

## Key Features
- **Pluggable Architecture**: Modular design with interchangeable HTTP transports and authentication mechanisms
- **Async & Sync Support**: Built-in CompletableFuture-based async transport alongside traditional synchronous APIs  
- **Auth Support**: Different authentication models (OAuth 2.0, Basic Auth) with automatic token management
- **Observability**: Logging, request/response masking, and custom pipeline steps for monitoring or custom authentication models
- **Type-Safe Code Generation**: Automatic SDK generation from OpenAPI specifications and GraphQL schemas

## Core Modules

| Module                                                                     | Purpose                           | Key Features                                                           |
|----------------------------------------------------------------------------|-----------------------------------|------------------------------------------------------------------------|
| **[expediagroup-sdk-core](expediagroup-sdk-core)**                         | SDK foundation and utilities      | HTTP abstractions, authentication, logging, pipeline architecture      |
| **[expediagroup-sdk-rest](expediagroup-sdk-rest)**                         | REST API client framework         | Request/response handling, operation patterns, REST-specific utilities |
| **[expediagroup-sdk-graphql](expediagroup-sdk-graphql)**                   | GraphQL client framework          | Apollo integration, type-safe operations                               |
| **[expediagroup-sdk-transport-okhttp](expediagroup-sdk-transport-okhttp)** | HTTP transport layer              | OkHttp-based transport, supporting both sync and async executions      |
| **[expediagroup-sdk-openapi-plugin](expediagroup-sdk-openapi-plugin)**     | Code generation plugin            | Gradle plugin for generating SDKs from OpenAPI specifications          |
| **[exemplar](exemplar)**                                                   | Complete reference implementation | Full-featured demo with server, generated SDKs, and usage examples     |

## Quick Start
This repository provides the foundational modules to build Product SDKs for REST/GraphQL APIs in EG. Once you have initiailized a new SDK project for your API, you can add dependency on these foundational modules.

All product SDKs projects have to use Gradle as the main build tool. Most of the generation tasks are built for Gradle.

### Adding Dependencies

Add the core SDK modules to your project:

```gradle
dependencies {
    implementation 'com.expediagroup:expediagroup-sdk-rest:{latest-version}' // For REST SDK
    implementation 'com.expediagroup:expediagroup-sdk-graphql:{latest-version}' // For GraphQL SDK

    // HTTP transport (OkHttp-based)
    implementation 'com.expediagroup:expediagroup-sdk-transport-okhttp:{latest-version}'
}
```

### Getting Started

1. **Choose your API type**: REST or GraphQL
2. **Review the [exemplar](exemplar)**: Complete working examples with server and client implementations
3. **Follow module guides**: Each module contains detailed setup and usage instructions
4. **Explore demos**: Check out the [playground examples](exemplar/exemplar-playground-java) for practical patterns

## Architecture Highlights

### Pluggable Transport Layer
Swap HTTP implementations without code changes - see [transport documentation](expediagroup-sdk-transport-okhttp) for details.

> [!NOTE]
> Currently, only OkHttp transport is supported. You may implement your own Transport interface using a different HTTP client. See [exemplar-playground-java](exemplar/exemplar-playground-java) for custom transport examples.

### Pipeline-Based Processing
Extensible request/response processing with custom steps - explore [pipeline examples](exemplar/exemplar-sdk-rest/src/main/kotlin/com/expediagroup/sdk/exemplar/rest/core/executor/demo).

## SDK Generation

### From OpenAPI Specification
Use the [OpenAPI plugin](expediagroup-sdk-openapi-plugin) to generate type-safe REST clients from your API specifications.

### From GraphQL Schema
Integrate with [GraphQL module](expediagroup-sdk-graphql) and [Apollo Kotlin](https://www.apollographql.com/docs/kotlin) for type-safe GraphQL operations and schema-first development.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
