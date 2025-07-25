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

This GraphQL Exemplar SDK mainly depends on [`expediagroup-sdk-graphql`](../../expediagroup-sdk-graphql) and [`apollo-gradle-plugin`](https://github.com/apollographql/apollo-kotlin/tree/main/libraries/apollo-gradle-plugin). These dependencies facilitate building and generating an SDK for your API based on a GraphQL schema and operations.

#### 1. Build File Configurations

Refer to the [`build.gradle.kts`](./build.gradle.kts) build file for more details.

| Config                  | Description                                                                                                                                                                                                                                                                                                        |
|-------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Code Generation         | Applies [Apollo Kotlin Gradle plugin](https://github.com/apollographql/apollo-kotlin/tree/main/libraries/apollo-gradle-plugin) for code generation. The [`expediagroup-sdk-graphql`](../../expediagroup-sdk-graphql) layer adapts the generated models and operations to be executed using the EG SDK core modules. |
| GraphQL Support         | Adds [`expediagroup-sdk-graphql`](../../expediagroup-sdk-graphql) as an `api` dependency.                                                                                                                                                                                                                          |
| Custom Scalars Adapters | The `apollo-adapters-core` dependency is required if you have custom scalars in your GraphQL schema, and you want to register adapters from Apollo Kotlin library.                                                                                                                                                 |
| Logging                 | Adds the SLF4J API, allowing users to plug in their preferred logging implementation.                                                                                                                                                                                                                              |


#### 2. Source Code Structure
You can find more information and description with each class in these packages.

| Package                                                                    | Description                                                                                                                                                                                 |
|----------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [`client`](./src/main/kotlin/com/expediagroup/sdk/exemplar/graphql/client) | Contains manually implemented SDK clients. These are the main entry points used by consumers. See the [GraphQL module documentation](../../expediagroup-sdk-graphql/README.md) for details. |
| [`core`](./src/main/kotlin/com/expediagroup/sdk/exemplar/graphql/core)     | Contains integration classes for the core executors. See the [Core module documentation](../../expediagroup-sdk-core/README.md).                                                            |

#### 3. GraphQL Schema and Operations Files

| File                                                    | Description                                                                                                                      |
|---------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| [`schema.graphqls`](./src/main/graphql/schema.graphqls) | A copy of the original GraphQL schema file in the [`exemplar-server`](../exemplar-server).                         |
| [`query`](./src/main/graphql/query)                     | This directory contains the GraphQL queries based on the root schema. It's configurable as a `srcDir` in the Apollo plugin block.   |
| [`mutation`](./src/main/graphql/mutation)               | This directory contains the GraphQL mutations based on the root schema. It's configurable as a `srcDir` in the Apollo plugin block. |

<br />


## 🚀 Getting Started

The `exemplar-sdk-graphql` module contains only the manually implemented classes. Models and operations are generated at build time using Apollo plugin. By default, the generated code is not written to the source directory — it resides in the `build` directory under the `packageName` specified in the plugin configuration. This behavior can be customized via the Apollo plugin settings.

To update the generated code or sync with a newer GraphQL schema (or operations), follow these steps:

1. **Update the GraphQL schema and exemplar-server code**

   Spring Boot GraphQL is schema-first. Start by updating the [`schema.graphqls`](../exemplar-server/src/main/resources/graphql/schema.graphqls) file to reflect your desired changes. Then,         update the `exemplar-server` GraphQL controllers accordingly to match the updated schema.

3. **Copy the schema file to the SDK**

   After updating the server and schema, copy the updated `schema.graphqls` file into the [`graphql`](./src/main/graphql) directory of the SDK module.

   While it's possible to reference the server’s schema file directly, maintaining a local copy ensures the SDK remains self-contained and more representative of a real-world SDK setup.

5. **Navigate to the `exemplar` module root**

   ```bash
   cd exemplar
   ```
   
6. **Build the SDK**

   Run the following command to clean and rebuild the SDK. The Apollo plugin will regenerate the models and operations based on the updated schema:
   
   ```bash
   ./gradlew :exemplar-sdk-graphql:clean :exemplar-sdk-graphql:build
   ```

   The generated classes will be placed under the `build` directory (`build/generated/source/apollo`).

7. **Test your changes in the exemplar playground**

    Use the dedicated playground module to validate your changes.

    First, start the exemplar-server:

   ```bash
   ./gradlew :exemplar-server:bootRun
   ```

   You can then write your own tests or explore the existing demonstrations. For more information, refer to the [exemplar-playground-java](../exemplar-playground-java) module.
   
## 🔗 Related Modules

* [`exemplar-server`](../exemplar-server): Backend module that defines the API and generates the OpenAPI spec.
* [`exemplar-playground-java`](../exemplar-playground-java): Dedicated module to test out the generated exemplar SDKs with the exemplar server.
* [`expediagroup-sdk-core`](../../expediagroup-sdk-core): Core SDK abstractions for HTTP handling, serialization, and error mapping.
* [`expediagroup-sdk-graphql`](../../expediagroup-sdk-graphql): Adds REST APIs support layer to the SDK core.


## 📝 Notes

* This SDK is intended for **educational and demonstration** use.
* For REST exemplar, refer to the [`exemplar-sdk-rest`](../exemplar-sdk-rest) module.
