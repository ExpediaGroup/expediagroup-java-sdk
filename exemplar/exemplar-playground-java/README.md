# Exemplar Playground Java

The **Exemplar Playground Java** module provides practical, runnable examples demonstrating how to use the Expedia Group Java SDK for both REST and GraphQL APIs. It serves as a reference implementation, usage guide, and technical documentation for common SDK integration patterns.

## 🎯 Overview

This playground showcases the full capabilities of the Expedia Group Java SDK ecosystem through hands-on examples. It demonstrates how to build applications using the SDK's core features:

| Feature                 | Description                                                             |
| ----------------------- | ----------------------------------------------------------------------- |
| REST API Integration    | Examples using the REST-based SDK to perform booking-related operations |
| GraphQL Support         | GraphQL client usage through the generated SDK and Apollo integration   |
| Async Programming       | Demonstrates asynchronous execution with CompletableFuture              |
| Custom Transport Layers | Shows how to build and plug in your own transport implementations       |
| Error Handling          | Illustrates structured exception handling for failed operations         |


_This playground interacts with the [exemplar-server](../exemplar-server), which provides the REST and GraphQL endpoints used in the examples. Make sure it's up and running before you run the examples._


## ⚙️ Prerequisites
- **Java 17 or higher**
- **Gradle 8.x**
- **exemplar-server running** (see [server setup](../exemplar-server/README.md))


## 📦 Key Dependencies

| Dependency                          | Purpose                      | Documentation                                               |
| ----------------------------------- | ---------------------------- | ----------------------------------------------------------- |
| `expediagroup-sdk-transport-okhttp` | Default HTTP transport layer | [Transport OkHttp](../../expediagroup-sdk-transport-okhttp) |
| `exemplar-sdk-rest`                 | Generated REST client SDK    | [Exemplar REST SDK](../exemplar-sdk-rest)                   |
| `exemplar-sdk-graphql`              | Generated GraphQL client SDK | [Exemplar GraphQL SDK](../exemplar-sdk-graphql)             |
| `log4j-slf4j2-impl`                 | Logging implementation       | SLF4J-compatible logging backend                            |


## 🔮 SDK Capability Scenarios

The playground includes runnable examples to demonstrate different SDK features:

### 1. REST API Examples

| Class                       | Description                                                   |
| --------------------------- | ------------------------------------------------------------- |
| `FullExemplarScenario`      | Demonstrates a complete hotel booking flow using the REST API |
| `AsyncFullExemplarScenario` | Async version of the booking scenario                         |
| `HandleOperationException`  | Error handling for REST API operations                        |

*All classes are under the `playground.rest` package.*


### 2. GraphQL API Examples

| Class                       | Description                            |
| --------------------------- | -------------------------------------- |
| `FullExemplarScenario`      | Booking scenario using the GraphQL API |
| `AsyncFullExemplarScenario` | Async version of the booking scenario  |
| `HandleOperationException`  | Error handling for GraphQL operations  |

*All classes are under the `playground.graphql` package.*


### 3. General SDK Examples

| Class                      | Description                                            |
| -------------------------- | ------------------------------------------------------ |
| `ConfigureOkHttpTransport` | How to configure and customize OkHttp transport        |
| `CustomTransport`          | Custom **synchronous** transport layer implementation  |
| `CustomAsyncTransport`     | Custom **asynchronous** transport layer implementation |

*All classes are under the `playground.common` or root package.*


## 🔗 Related Documentation

- **[Exemplar Server](../exemplar-server/README.md)**: API server implementation
- **[Exemplar REST SDK](../exemplar-sdk-rest/README.md)**: Generated REST client
- **[Exemplar GraphQL SDK](../exemplar-sdk-graphql/README.md)**: Generated GraphQL client  
- **[SDK Core](../../expediagroup-sdk-core/README.md)**: Core SDK foundation
- **[SDK REST](../../expediagroup-sdk-rest/README.md)**: REST client framework
- **[SDK Transport OkHttp](../../expediagroup-sdk-transport-okhttp/README.md)**: Default transport layer
