# Exemplar REST SDK

This module is a **reference implementation** demonstrating how to build REST-based SDKs using the [Expedia Group SDK core libraries](https://github.com/ExpediaGroup). It serves as a guide for developers looking to create their own SDKs with best practices and consistent structure.

## 🎯 Purpose
This project also serves as a starter template for building REST SDKs. It includes the minimal setup, configuration, and essential classes required to get a working SDK up and running.

Developers can use it as a foundation to bootstrap their own SDKs while following established structure and best practices from the EG SDK ecosystem. Each class in the exemplar SDK is documented to clarify its purpose and usage.

## 📦 Example Usage
All SDKs generated with EG SDK modules supports **Java 8**. 

Here's a simple example of executing a generated operation using the SDK client:

```java
public class UsageExample {
    private static final ExemplarClient exemplarClient = new ExemplarClient();

    public static void main(String[] args) {
        SearchHotelOperationParams params = SearchHotelOperationParams.builder()
            .city("New York")
            .maxPrice(BigDecimal.valueOf(400.00))
            .build();

        SearchHotelOperation operation = new SearchHotelOperation(params);

        List<? extends Hotel> hotels = exemplarClient.execute(operation).getData();
    }
}
```

Refer to the [`exemplar-playground-java`](../exemplar-playground-java) for complete usage examples. 


## 🧱 Structure

This REST Exemplar SDK mainly depends on [`expediagroup-sdk-rest`](../../expediagroup-sdk-rest) and [`expediagroup-sdk-openapi-plugin`](../../expediagroup-sdk-openapi-plugin). These modules facilitate building and generating an SDK for your API based on an OpenAPI specification.

#### 1. Build File Configurations

Refer to the [`build.gradle.kts`](./build.gradle.kts) build file for more details.

| Config              | Description                                                                                                                                                                                                                              |
|---------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Code Generation     | Applies the EG SDK OpenAPI plugin for code generation. This plugin is primarily used to generate models and operations—not the SDK clients. See the plugin's [README](../../expediagroup-sdk-openapi-plugin/README.md) for more details. |
| REST Support        | Adds [`expediagroup-sdk-rest`](../../expediagroup-sdk-rest) as an `api` dependency.                                                                                                                                                      |
| (de)Serialization   | Includes Jackson dependencies for serialization and deserialization.                                                                                                                                                                     |
| Logging             | Adds the SLF4J API, allowing users to plug in their preferred logging implementation.                                                                                                                                                    |
| Spec Transformation | Defines a Gradle task to transform the OpenAPI spec using [spec-transformer](https://github.com/ExpediaGroup/spec-transformer). This ensures the spec adheres to SDK generator standards.                                                |


#### 2. Source Code Structure
You can find more information and description with each class in these packages.

| Package                                                                       | Description                                                                                                                                                                           |
|-------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [`client`](./src/main/kotlin/com/expediagroup/sdk/exemplar/rest/client)       | Contains manually implemented SDK clients. These are the main entry points used by consumers. See the [REST module documentation](../../expediagroup-sdk-rest/README.md) for details. |
| [`core`](./src/main/kotlin/com/expediagroup/sdk/exemplar/rest/core)           | Contains integration classes for the core executors. See the [Core module documentation](../../expediagroup-sdk-core/README.md).                                                      |
| [`model`](./src/main/kotlin/com/expediagroup/sdk/exemplar/rest/model)         | Auto-generated by [`expediagroup-sdk-openapi-plugin`](../../expediagroup-sdk-openapi-plugin). Contains data model classes based on the OpenAPI spec.                                  |
| [`operation`](./src/main/kotlin/com/expediagroup/sdk/exemplar/rest/operation) | Auto-generated operations corresponding to API endpoints defined in the OpenAPI spec.                                                                                                 |

#### 3. OpenAPI Specification Files

| File                                             | Description                                                                                            |
|--------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| [`openapi.yaml`](./openapi.yaml)                 | The original OpenAPI spec file generated from the [`exemplar-server`](../exemplar-server) source code. |
| [`transformed-spec.yml`](./transformed-spec.yml) | A modified version of the original spec used as input for SDK generation.                              |

<br />

## 🚀 Getting Started

The `exemplar-sdk-rest` module contains pre-generated models and operations based on the latest version of `exemplar-server`. To update the generated code or sync with a newer API definition, follow these steps:

1. **Update the exemplar-server code**

   Make the necessary changes to the `exemplar-server` so they are reflected in the generated OpenAPI specification.

2. **Make sure to navigate to the `exemplar` module root**

   ```bash
   cd exemplar
   ```
   
3. **Regenerate the OpenAPI spec**

   After updating the exemplar-server, run the following command to regenerate the OpenAPI specification:
   
   ```bash
   ./gradlew :exemplar-server:generateOpenApiDocs
   ```

   This will generate a new `openapi.yaml` file and place it in the `exemplar-sdk-rest` root directory.

4. **Transform the Spec**

   After generating the updated `openapi.yaml` file, run the spec transformation task:
   
    ```bash
    ./gradlew :exemplar-sdk-rest:transformSpecs
    ```

    This will produce or update the `transformed-spec.yaml` file, which is used by the generator plugin.

5. **Regenerate the SDK**

   You can now regenerate or update the SDK’s generated code by running:

   ```bash
   ./gradlew :exemplar-sdk-rest:generateAndFormat
   ```

   _Note: It's recommended to manually delete the existing `model` and `operation` packages before running the generation task._

6. **Test your changes in the exemplar playground**

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
* [`expediagroup-sdk-rest`](../../expediagroup-sdk-rest): Adds REST APIs support layer to the SDK core.


## 📝 Notes

* This SDK is intended for **educational and demonstration** use.
* For GraphQL exemplar, refer to the [`exemplar-sdk-graphql`](../exemplar-sdk-graphql) module.
