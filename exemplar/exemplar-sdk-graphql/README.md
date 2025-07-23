# 🧪 Exemplar GraphQL SDK

This module is a **reference implementation** showcasing how to build a GraphQL-based SDK using the [Expedia Group SDK JVM core libraries](https://github.com/ExpediaGroup/expediagroup-java-sdk). It serves as a guide for teams building their own SDKs with consistent structure, best practices, and integration patterns.

## 🎯 Purpose

* **Showcase**: Demonstrates how to structure and implement a GraphQL SDK using EG SDK core components.
* **Reference**: Offers practical examples for interacting with GraphQL APIs—queries, mutations, error handling, and modeling.
* **Learning**: Helps new contributors understand the design and extensibility of the EG SDK ecosystem.

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
