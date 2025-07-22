# Exemplar GraphQL SDK

This module serves as an exemplary project demonstrating how to use the Expedia Group (EG) SDK foundations to craft GraphQL-based SDKs. It is intended as a reference implementation for developers looking to build their own GraphQL SDKs using the EG SDK core modules and best practices.

## Purpose

- **Showcase**: Demonstrates how to structure and implement a GraphQL SDK using the EG SDK core libraries.
- **Reference**: Provides practical examples of integrating with GraphQL APIs, handling queries, mutations, authentication, error handling, and data modeling.
- **Learning**: Helps new contributors and users understand the flow and extensibility of the EG SDK ecosystem for GraphQL.

## Structure

- **Code-First Approach**: The GraphQL schema is defined in the `exemplar-server` module, and the SDK is built to interact with this schema.
- **Integration**: Leverages the EG SDK core modules for HTTP transport, serialization, and error handling.

## How to Use

1. **Review the Code**: Explore the source code in this module to understand how the SDK is structured and how it interacts with the underlying GraphQL API.
2. **GraphQL Schema**: The schema is defined in the `exemplar-server` and used to guide SDK development.
3. **Customization**: Use this module as a template for building your own GraphQL SDKs by adapting the code and configuration to your API's needs.

## Key Files

- `src/main/`: Contains the SDK implementation code for GraphQL operations.

## Related Modules

- `exemplar-server`: The backend server that defines the GraphQL schema and serves the API.
- `expediagroup-sdk-core`: Core utilities and abstractions for building SDKs.

## Getting Started

1. Ensure the `exemplar-server` is running and the GraphQL schema is up to date.
2. Build the SDK:
   ```sh
   ./gradlew :exemplar:exemplar-sdk-graphql:build
   ```
3. Use the generated SDK in your Java/Kotlin projects as a reference or starting point.

## Notes

- This module is for demonstration and educational purposes. For production use, adapt and extend as needed.
- For REST SDK examples, see the `exemplar-sdk-rest` module.

---

For more information, see the root `README.md` and the documentation in the core modules.

