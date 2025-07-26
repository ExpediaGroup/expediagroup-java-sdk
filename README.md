# Expedia Group Java SDK

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Java](https://img.shields.io/badge/Java-1.8%2B-orange.svg)](https://openjdk.org/)
[![Gradle](https://img.shields.io/badge/Gradle-8.x-green.svg)](https://gradle.org/)

The **Expedia Group Java SDK Foundations** provides the core components and tools for building and maintaining our SDK libraries.
These foundations enable developers to create consistent, high-quality Java SDKs that interact with the Expedia Group platform.

## 🚀 Key Features

- **🔧 Pluggable Architecture**: Modular design with interchangeable HTTP transports and authentication mechanisms
- **⚡ Async & Sync Support**: Built-in CompletableFuture-based async clients alongside traditional synchronous APIs  
- **🛡️ Production-Ready Security**: Comprehensive authentication (OAuth 2.0, Basic Auth) with automatic token management
- **📊 Observability First**: Advanced logging, request/response masking, and custom pipeline steps for monitoring
- **🎯 Type-Safe Code Generation**: Automatic SDK generation from OpenAPI 3.1 and GraphQL schemas
- **🔍 Developer Experience**: Rich debugging capabilities, comprehensive error handling, and extensive documentation

## 📦 Core Modules

| Module | Purpose | Key Features |
|--------|---------|--------------|
| **[expediagroup-sdk-core](expediagroup-sdk-core/)** | SDK foundation and utilities | HTTP abstractions, authentication, logging, pipeline architecture |
| **[expediagroup-sdk-rest](expediagroup-sdk-rest/)** | REST API client framework | Request/response handling, operation patterns, REST-specific utilities |
| **[expediagroup-sdk-graphql](expediagroup-sdk-graphql/)** | GraphQL client framework | Apollo integration, type-safe queries, subscription support |
| **[expediagroup-sdk-transport-okhttp](expediagroup-sdk-transport-okhttp/)** | HTTP transport layer | OkHttp-based transport with connection pooling and retry logic |
| **[expediagroup-sdk-openapi-plugin](expediagroup-sdk-openapi-plugin/)** | Code generation plugin | Gradle plugin for generating SDKs from OpenAPI specifications |
| **[exemplar](exemplar/)** | Complete reference implementation | Full-featured demo with server, generated SDKs, and usage examples |

## 🎯 Quick Start

### Adding Dependencies

Add the core SDK modules to your project:

```gradle
dependencies {
    // Core SDK framework
    implementation 'com.expediagroup:expediagroup-sdk-core:latest'
    implementation 'com.expediagroup:expediagroup-sdk-rest:latest'
    
    // HTTP transport (OkHttp-based)
    implementation 'com.expediagroup:expediagroup-sdk-transport-okhttp:latest'
}
```

### Getting Started

1. **Choose your API type**: REST or GraphQL
2. **Review the [exemplar](exemplar/)**: Complete working examples with server and client implementations
3. **Follow module guides**: Each module contains detailed setup and usage instructions
4. **Explore demos**: Check out the [playground examples](exemplar/exemplar-playground-java/) for practical patterns

## 🏗️ Architecture Highlights

### Pluggable Transport Layer
Swap HTTP implementations without code changes - see [transport documentation](expediagroup-sdk-transport-okhttp/) for details.

### Pipeline-Based Processing
Extensible request/response processing with custom steps - explore [pipeline examples](exemplar/exemplar-sdk-rest/src/main/kotlin/com/expediagroup/sdk/exemplar/rest/core/executor/demo/).

### Comprehensive Error Handling
Built-in error handling for service and transport failures - see [error handling guide](exemplar/exemplar-playground-java/) for patterns.

## 🛠️ SDK Generation

### From OpenAPI Specification
Use the [OpenAPI plugin](expediagroup-sdk-openapi-plugin/) to generate type-safe REST clients from your API specifications.

### From GraphQL Schema
Integrate with [GraphQL module](expediagroup-sdk-graphql/) for type-safe GraphQL operations and schema-first development.

## 📚 Documentation & Examples

- **[Complete Examples](exemplar/)**: Full-featured reference implementation with REST and GraphQL APIs
- **[REST SDK Guide](expediagroup-sdk-rest/)**: Comprehensive REST client development guide  
- **[GraphQL SDK Guide](expediagroup-sdk-graphql/)**: GraphQL client integration patterns
- **[Custom Transport Guide](exemplar/exemplar-playground-java/)**: Building custom HTTP transport layers
- **[Authentication Patterns](exemplar/exemplar-sdk-rest/src/main/kotlin/com/expediagroup/sdk/exemplar/rest/core/executor/demo/)**: OAuth, Basic Auth, and custom authentication

## 🔧 Enterprise Features

### Security & Compliance
- **Credential Management**: Secure storage and rotation of API credentials
- **Request Signing**: Built-in support for request signing and HMAC authentication  
- **Data Masking**: Automatic masking of sensitive data in logs and debug output
- **Audit Trails**: Comprehensive request/response logging with correlation IDs

### Observability & Monitoring
- **Structured Logging**: JSON-structured logs with correlation tracking
- **Metrics Integration**: Built-in metrics collection for request timing and success rates
- **Health Checks**: Automatic endpoint health monitoring and circuit breakers
- **Distributed Tracing**: OpenTelemetry integration for request tracing

### Performance & Reliability
- **Connection Pooling**: Efficient HTTP connection management and reuse
- **Retry Logic**: Configurable retry policies with exponential backoff
- **Rate Limiting**: Built-in rate limiting and throttling capabilities
- **Caching**: Response caching with TTL and invalidation strategies

## 🤝 Contributing

We welcome contributions! Please see our [Contributing Guide](CONTRIBUTING.md) for details on:

- Code style and conventions
- Testing requirements  
- Pull request process
- Release procedures

## 📄 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

---

**Built with ❤️ by the Expedia Group Platform Team**
