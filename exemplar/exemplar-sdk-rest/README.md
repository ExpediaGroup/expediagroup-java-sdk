# Exemplar REST SDK

This module serves as an exemplary project demonstrating how to use the Expedia Group (EG) SDK foundations to craft REST-based SDKs. It is intended as a reference implementation for developers looking to build their own SDKs using the EG SDK core modules and best practices.

## Purpose

- **Showcase**: Demonstrates how to structure and implement a REST SDK using the EG SDK core libraries.
- **Reference**: Provides practical examples of integrating with REST APIs, handling authentication, error handling, and data modeling.
- **Learning**: Helps new contributors and users understand the flow and extensibility of the EG SDK ecosystem.

## Structure

- **Based on OpenAPI**: The REST SDK is generated from the OpenAPI specification, which is produced from the code in the `exemplar-server` module (code-first approach).
- **Integration**: Leverages the EG SDK core modules for HTTP transport, serialization, and error handling.

## How to Use

1. **Review the Code**: Explore the source code in this module to understand how the SDK is structured and how it interacts with the underlying REST API.
2. **OpenAPI Spec**: The `openapi.yaml` file is generated from the `exemplar-server` and used to scaffold the SDK.
3. **Customization**: Use this module as a template for building your own SDKs by adapting the code and configuration to your API's needs.

## Key Files

- `openapi.yaml`: The OpenAPI specification generated from the exemplar server.
- `src/main/`: Contains the SDK implementation code.

## Related Modules

- `exemplar-server`: The backend server that defines the API and generates the OpenAPI spec.
- `expediagroup-sdk-core`: Core utilities and abstractions for building SDKs.

## Getting Started

1. Ensure the `exemplar-server` is running and the OpenAPI spec is up to date.
2. Build the SDK:
   ```sh
   ./gradlew :exemplar:exemplar-sdk-rest:build
   ```
3. Use the generated SDK in your Java/Kotlin projects as a reference or starting point.

## Notes

- This module is for demonstration and educational purposes. For production use, adapt and extend as needed.
- For GraphQL SDK examples, see the `exemplar-sdk-graphql` module.

---

For more information, see the root `README.md` and the documentation in the core modules.
