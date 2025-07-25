# Exemplar GraphQL SDK

This module is a **reference implementation** demonstrating how to build GraphQL-based SDKs using the [Expedia Group SDK core libraries](https://github.com/ExpediaGroup/expediagroup-java-sdk). It serves as a guide for developers looking to create their own SDKs with best practices and consistent structure.

## 🎯 Purpose
This project also serves as a starter template for building GraphQL SDKs. It includes the minimal setup, configuration, and essential classes required to get a working SDK up and running.

Developers can use it as a foundation to bootstrap their own SDKs while following established structure and best practices from the EG SDK ecosystem. Each class in the exemplar SDK is documented to clarify its purpose and usage.

## 📦 Example Usage
All SDKs generated with EG SDK modules supports **Java 8**. However, running the [Apollo Kotlin](https://www.apollographql.com/docs/kotlin#getting-started) generator as a Gradle plugin requires **Java 11+** (As a Gradle JVM)

Here's a simple example of executing a generated operation using the SDK client:

```java
public class UsageExample {
    private static final ExemplarGraphQLClient exemplarClient = new ExemplarGraphQLClient();

    public static void main(String[] args) {
        SearchHotelsQuery query = new SearchHotelsQuery.Builder()
            .city("New York")
            .maxPrice(BigDecimal.valueOf(300.00))
            .build();

        List<SearchHotelsQuery.Hotel> hotels = exemplarClient.execute(query).getData().getHotels();
    }
}
```

Refer to the [`exemplar-playground-java`](../exemplar-playground-java) for complete usage examples. 

## 🧱 Structure

This GraphQL Exemplar SDK mainly depends on [`expediagroup-sdk-graphql`](../../expediagroup-sdk-graphql) and [`apollo-gradle-plugin`](https://github.com/apollographql/apollo-kotlin/tree/main/libraries/apollo-gradle-plugin). These dependecies facilitate building and generating an SDK for your API based on a GraphQL schema and operations.

#### 1. Build File Configurations

Refer to the [`build.gradle.kts`](./build.gradle.kts) build file for more details.

| Config              | Description                                                                                                                                                                                                                              |
|---------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Code Generation     | Applies [Apollo Kotlin Gradle plugin](https://github.com/apollographql/apollo-kotlin/tree/main/libraries/apollo-gradle-plugin) for code generation. The [`expediagroup-sdk-graphql`](../../expediagroup-sdk-graphql) layer adapts the generated models and opeartions to be executed using the EG SDK core modules |
| GraphQL Support        | Adds [`expediagroup-sdk-graphql`](../../expediagroup-sdk-graphql) as an `api` dependency.                                                                                                                                                      |
| Custom Scalars Adapters   | The `apollo-adapters-core` dependency is required if you have custom scalars in your GraphQL schema, and you want to register adapters from Apollo Kotlin library                                                                                                                                                                   |
| Logging             | Adds the SLF4J API, allowing users to plug in their preferred logging implementation.                                                                                                                                                    |


#### 2. Source Code Structure
You can find more information and description with each class in these packages.

| Package                                                                       | Description                                                                                                                                                                           |
|-------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [`client`](./src/main/kotlin/com/expediagroup/sdk/exemplar/graphql/client)       | Contains manually implemented SDK clients. These are the main entry points used by consumers. See the [GraphQL module documentation](../../expediagroup-sdk-graphql/README.md) for details. |
| [`core`](./src/main/kotlin/com/expediagroup/sdk/exemplar/graphql/core)           | Contains integration classes for the core executors. See the [Core module documentation](../../expediagroup-sdk-core/README.md).                                                      |

#### 3. GraphQL Schema and Operations Files

| File                                             | Description                                                                                            |
|--------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| [`schema.graphqls`](./openapi.yaml)                 | The original OpenAPI spec file generated from the [`exemplar-server`](../exemplar-server) source code. |
| [`transformed-spec.yml`](./transformed-spec.yml) | A modified version of the original spec used as input for SDK generation.                              |

<br />


## 🚀 Getting Started

1. **Start the Server**
   Make sure the `exemplar-server` is running with the latest schema.

2. **Build the SDK**
   Run the following from the project root:

   ```bash
   cd exemplar
   ./gradlew :exemplar-sdk-graphql:build
   ```

3. **Explore and Extend**
   Use the generated SDK as a starting point for your own implementation.

## 📁 Key Components

| Path                            | Description                                                                                                                |
|---------------------------------|----------------------------------------------------------------------------------------------------------------------------|
| `src/main/kotlin`               | Contains the required classes that bridge the Exemplar SDK with the SDK internals and core modules (Manually implemented). |
| `src/main/graphql`              | Contains the GraphQL schema and operations (mirrored from `exemplar-server`).                                              |
| `build/generated/source/apollo` | Auto-generated models and operations from Apollo Kotlin.                                                                   |

## 🔗 Related Modules

* [`exemplar-server`](../exemplar-server): The GraphQL backend defining the schema and serving the API.
* [`expediagroup-sdk-core`](../../expediagroup-sdk-core): Core utilities and abstractions for building SDKs across GraphQL and REST.
* [`expediagroup-sdk-graphql`](../../expediagroup-sdk-graphql): Core libraries for building GraphQL SDKs, including transport and serialization.

## 📝 Notes

* This module is intended for **educational and demonstration** purposes.
* For REST examples, refer to the [`exemplar-sdk-rest`](../exemplar-sdk-rest) module.
* Customize this SDK to suit your own GraphQL APIs and workflows.

📄 For more context, see the root [`README.md`](../README.md) and documentation in the [`expediagroup-sdk-graphql`](../../expediagroup-sdk-graphql) module.
