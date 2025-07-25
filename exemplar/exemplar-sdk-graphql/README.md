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

* **🛠️ Code-First GraphQL**: The GraphQL schema lives in the `exemplar-server` module and drives the SDK code.
* **🔌 Integration with Core Modules**: Uses EG SDK core features for HTTP transport, serialization, logging, and error handling.
* **⚙️ Apollo Kotlin**: [Apollo Kotlin](https://www.apollographql.com/docs/kotlin) is used for generating types and operations from the schema.

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
