# Expedia Group Java SDK Foundations

The **Expedia Group Java SDK Foundations** provides the core components and tools for building and maintaining our SDK libraries.
These foundations enable developers to create consistent, high-quality Java SDKs that interact with the Expedia Group<sup>TM</sup> platform.

---

## Our SDKs

The following SDKs are built using the Expedia Group Java SDK Foundations, and are available for public use:

| SDK                                                                               | Maven                                                                                                                                                                                                                                                                                                            | Documentation                                                                                                               |
|-----------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| [Rapid SDK](https://github.com/ExpediaGroup/rapid-java-sdk)                       | [![Maven Central Version](https://img.shields.io/maven-central/v/com.expediagroup/rapid-sdk?style=for-the-badge&logo=expedia&logoColor=%23fddb32&label=Rapid%20SDK&labelColor=%23181e3b&color=%23fddb32)](https://central.sonatype.com/artifact/com.expediagroup/rapid-sdk)                                      | [Rapid SDK on Developer Hub](https://developers.expediagroup.com/docs/products/rapid/sdk/java)                              |
| [Fraud Prevention SDK](https://github.com/ExpediaGroup/fraud-prevention-java-sdk) | [![Maven Central Version](https://img.shields.io/maven-central/v/com.expediagroup/fraudpreventionv2-sdk?style=for-the-badge&logo=expedia&logoColor=%23fddb32&label=Fraud%20Prevention%20SDK&labelColor=%23181e3b&color=%23fddb32)](https://central.sonatype.com/artifact/com.expediagroup/fraudpreventionv2-sdk) | [Fraud Prevention SDK on Developer Hub](https://developers.expediagroup.com/docs/products/fraud-prevention/sdk/quick-start) |

---

## Components

The foundations includes the following components:

- **SDK Core**: Core libraries and utilities shared across all Java SDKs
- **SDK Generators**: Tools for generating SDK code based on OpenAPI specifications (OAS3).
- **SDK Tests**: Shared testing frameworks and utilities for validating SDK functionality.
- **GitHub Actions**: Reusable workflows for SDK repositories to automate common tasks like building, testing, releasing, and publishing SDKs.

---

## Getting Started

### Prerequisites

To generate a new SDK, ensure you have the following:

1. **OpenAPI Specification** for the API you wish to generate an SDK for.
2. Use the [Spec Transformer](https://github.com/ExpediaGroup/spec-transformer) if transformation is required. Learn more about
   the [Spec Transformation process](https://github.com/ExpediaGroup/spec-transformer).
3. **Java Development Kit (JDK)** version 8 or later.
4. **Maven** version 3.8.0 or later. It's recommended to use the embedded Maven wrapper located in [/.mvn/wrapper](.mvn/wrapper).

### Generating SDKs

Follow these steps to generate an SDK:

1. Clone this repository:
   ```bash
   git clone https://github.com/ExpediaGroup/expediagroup-java-sdk.git
   cd expediagroup-java-sdk
   ```

2. Build the SDK Generator:
   ```bash
   cd generator/openapi
   mvn clean install
   ```

3. Refer to the [SDK Generator documentation](generator/README.md) for advanced usage and customization.

---

### Using Generated SDKs

The generated SDKs will be placed in the specified output directory. You can integrate them into your Java application by adding the SDK as a dependency.

#### Maven Dependency

Add the following to your `pom.xml`:

```xml

<dependency>
    <groupId>com.expediagroup</groupId>
    <artifactId>your-sdk-name</artifactId>
    <version>x.y.z</version>
</dependency>
```

#### Gradle Dependency

Add the following to your `build.gradle` file:

```groovy
implementation 'com.expediagroup:your-sdk-name:x.y.z'
```

Replace `your-sdk-name` and `x.y.z` with the appropriate SDK name and version.

--- 

This addition ensures developers using Gradle have clear instructions for integrating the SDK.

### Publishing SDKs

Leverage the provided self-serve [GitHub Actions workflows](.github/workflows) to automate the process of generating, releasing, and publishing SDKs to:

- A GitHub repository
- Maven Central for public availability

---

## Language Support

The toolkit currently supports generating SDKs targeting **Java 8** and later versions.

---

## Getting Help

- **Toolkit Issues**: For problems specific to the SDK toolkit, please open an issue in this repository.
- **SDK-Specific Questions**: For issues related to specific SDKs, refer to the respective repository for support and documentation.

---

## Contributing

We welcome contributions to improve this toolkit!
Please review our [CONTRIBUTING guidelines](CONTRIBUTING.md) before submitting issues or pull requests.

---

## License

This project is licensed under the Apache License 2.0. For more details, see the [LICENSE](LICENSE) file.
