# Expedia Group Java SDK Foundations - Complete Documentation

## Overview

The **Expedia Group Java SDK Foundations** is a comprehensive toolkit for building and maintaining Java/Kotlin SDKs that interact with Expedia Group's platform APIs. This repository provides the core infrastructure, tools, and components needed to generate, build, and publish production-ready SDKs for various Expedia Group services.

## 🏗️ Architecture

The repository is organized into several key components:

### Core Components

```
expediagroup-java-sdk/
├── core/                    # Core SDK libraries and utilities
├── generator/               # SDK generation tools
│   └── openapi/            # OpenAPI-based code generator
├── release/                # Generated SDK releases
│   ├── rapid/              # Rapid SDK implementation
│   └── fraudPreventionV2/  # Fraud Prevention V2 SDK
├── sdk-test/               # Shared testing framework
└── .github/workflows/      # Reusable CI/CD workflows
```

### 1. SDK Core (`/core`)
The foundation layer providing:
- **Base client classes** (`BaseRapidClient`, `ExpediaGroupClient`, `BaseXapClient`)
- **Authentication strategies** (Bearer token, Basic auth, Signature-based)
- **HTTP client configuration** with OkHttp integration
- **Error handling and exception mapping**
- **Logging, serialization, and plugin architecture**
- **Configuration management**

### 2. SDK Generator (`/generator`)
OpenAPI-based code generation toolkit:
- **Mustache templates** for consistent code generation
- **Custom Kotlin/Java generators** extending OpenAPI tooling
- **Model and operation generation** from OpenAPI specs
- **Documentation generation** capabilities

### 3. Release SDKs (`/release`)
Generated, production-ready SDKs:
- **Rapid SDK**: Hotel booking and management APIs
- **Fraud Prevention V2 SDK**: Fraud detection services

## 🚀 Quick Start

### Prerequisites

- **Java 8+** (JDK 8 or later)
- **Maven 3.8.0+** (or use included Maven wrapper)
- **OpenAPI 3.0+ specification** for your target API

### Building the Foundation

```bash
# Clone the repository
git clone https://github.com/ExpediaGroup/expediagroup-java-sdk.git
cd expediagroup-java-sdk

# Build core components
./mvnw clean install
```

### Generating a New SDK

```bash
# Build the generator
cd generator/openapi
mvn clean install

# Generate SDK (creates sample in target/sdk)
../../mvnw exec:java

# Build the generated SDK
cd target/sdk
../../../mvnw clean install
```

## 📚 Usage Guide

### Using Generated SDKs

#### 1. Add SDK Dependency

**Maven:**
```xml
<dependency>
    <groupId>com.expediagroup</groupId>
    <artifactId>rapid-sdk</artifactId>
    <version>5.0.1</version>
</dependency>
```

**Gradle:**
```groovy
implementation 'com.expediagroup:rapid-sdk:5.0.1'
```

#### 2. Initialize the Client

```kotlin
// Create Rapid client
val rapidClient = RapidClient.builder()
    .key("your-api-key")
    .secret("your-api-secret")
    .endpoint("https://test.ean.com/v3") // or production endpoint
    .build()
```

#### 3. Execute Operations

The SDKs use an **operation-based pattern** where each API call is represented as an operation:

```kotlin
// Search for available properties
val availabilityOperation = GetAvailabilityOperationContext.builder()
    .checkin("2024-12-01")
    .checkout("2024-12-03")
    .occupancy(listOf("2"))
    .currency("USD")
    .language("en-US")
    .countryCode("US")
    .propertyId(listOf("12345"))
    .customerIp("192.168.1.1")
    .build()

val response = rapidClient.execute(availabilityOperation)
val properties = response.data // List<Property>
```

```kotlin
// Create a booking
val bookingRequest = CreateItineraryRequest.builder()
    .affiliateReferenceId("your-ref-123")
    .hold(false)
    .email("customer@example.com")
    .phone(PhoneRequest.builder()
        .countryCode("1")
        .areaCode("555")
        .number("1234567")
        .build())
    .rooms(listOf(
        CreateItineraryRequestRoom.builder()
            .occupancy(CreateItineraryRequestRoomOccupancy.builder()
                .numberOfAdults(2)
                .build())
            .ratePlanId("rate-plan-123")
            .build()
    ))
    .build()

val itineraryOperation = PostItineraryOperation(
    PostItineraryOperationParams.builder()
        .customerIp("192.168.1.1")
        .customerSessionId("session-123")
        .build(),
    bookingRequest
)

val bookingResponse = rapidClient.execute(itineraryOperation)
val itinerary = bookingResponse.data // ItineraryCreation
```

#### 4. Retrieve Reservations

```kotlin
// Get reservation details
val reservationOperation = GetReservationByItineraryIdOperation(
    GetReservationByItineraryIdOperationParams.builder()
        .itineraryId("12345")
        .customerIp("192.168.1.1")
        .include(listOf(
            GetReservationByItineraryIdOperationParams.Include.HISTORY,
            GetReservationByItineraryIdOperationParams.Include.LINKS
        ))
        .build()
)

val reservationResponse = rapidClient.execute(reservationOperation)
val reservation = reservationResponse.data // Itinerary
```

### Asynchronous Operations

All operations support async execution:

```kotlin
val futureResponse = rapidClient.executeAsync(availabilityOperation)
futureResponse.thenAccept { response ->
    val properties = response.data
    // Process properties
}
```

### Error Handling

The SDKs use typed exceptions for different error scenarios:

```kotlin
try {
    val response = rapidClient.execute(operation)
    // Success handling
} catch (e: ExpediaGroupApiErrorException) {
    // API returned an error response
    val errorResponse = e.errorResponse
    when (errorResponse) {
        is RapidError -> {
            // Handle Rapid-specific errors
            println("Error: ${errorResponse.errors}")
        }
    }
} catch (e: ExpediaGroupServiceException) {
    // Service-level errors (network, timeout, etc.)
    println("Service error: ${e.message}")
} catch (e: ExpediaGroupConfigurationException) {
    // Configuration errors (missing keys, etc.)
    println("Configuration error: ${e.message}")
}
```

### Builder Pattern

All request objects and operations use the builder pattern:

```kotlin
val propertyContentParams = GetPropertyContentOperationParams.builder()
    .propertyId(listOf("12345", "67890"))
    .language("en-US")
    .supply_source("expedia")
    .include(listOf(
        GetPropertyContentOperationParams.Include.THEMES,
        GetPropertyContentOperationParams.Include.AMENITIES
    ))
    .build()
```

### Response Handling

Responses are wrapped in a `Response<T>` object:

```kotlin
val response = rapidClient.execute(operation)

// Access response data
val data = response.data

// Access response metadata
val headers = response.headers
val statusCode = response.statusCode
val transactionId = response.transactionId
```

### Configuration Options

#### Basic Configuration

```kotlin
val client = RapidClient.builder()
    .key("api-key")
    .secret("api-secret")
    .endpoint("https://api.ean.com/v3")
    .requestTimeout(30000)          // 30 seconds
    .connectionTimeout(10000)       // 10 seconds
    .socketTimeout(60000)          // 60 seconds
    .build()
```

#### Advanced Configuration

```kotlin
// Custom OkHttpClient
val customOkHttpClient = OkHttpClient.Builder()
    .connectionPool(ConnectionPool(10, 5, TimeUnit.MINUTES))
    .addInterceptor(customInterceptor)
    .build()

val client = RapidClient.builder()
    .key("api-key")
    .secret("api-secret")
    .httpClient(customOkHttpClient)
    .maskedLoggingHeaders(setOf("Authorization", "X-API-Key"))
    .maskedLoggingBodyFields(setOf("password", "creditCard"))
    .build()
```

### Environment Configuration

SDKs support multiple environments:

```kotlin
// Test environment
val testClient = RapidClient.builder()
    .key("test-key")
    .secret("test-secret")
    .endpoint("https://test.ean.com/v3")
    .build()

// Production environment
val prodClient = RapidClient.builder()
    .key("prod-key")
    .secret("prod-secret")
    .endpoint("https://api.ean.com/v3")
    .build()
```

## 🔧 Customization and Extension

### Custom Authentication

Implement custom authentication strategies:

```kotlin
class CustomAuthStrategy : AuthenticationStrategy {
    override fun loadAuth(auth: Auth) {
        // Custom auth logic
    }
    
    override fun getAuthorizationHeader(): String {
        // Return custom auth header
    }
}
```

### Custom HTTP Interceptors

Add custom request/response processing:

```kotlin
val customClient = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("X-Custom-Header", "value")
            .build()
        chain.proceed(request)
    }
    .build()
```

## 🔌 SDK Generation

### Generating Custom SDKs

1. **Prepare OpenAPI Specification**
   - Ensure your API has a valid OpenAPI 3.0+ specification
   - Use [Spec Transformer](https://github.com/ExpediaGroup/spec-transformer) if needed

2. **Configure Generation**
   ```bash
   cd generator/openapi
   # Modify generation configuration as needed
   ../../mvnw exec:java
   ```

3. **Customize Templates**
   - Templates are located in `generator/openapi/src/main/resources/templates/`
   - Modify Mustache templates for custom code generation

4. **Build Generated SDK**
   ```bash
   cd target/sdk
   ../../../mvnw clean install
   ```

### Publishing SDKs

Use the provided GitHub Actions workflows:

1. **Manual Release**: `.github/workflows/manual-release.yml`
2. **Automated Publishing**: Configurable for Maven Central
3. **Documentation Generation**: Integrated Dokka support

## 🧪 Testing

### Unit Testing

```kotlin
// Test with mock responses
@Test
fun testGetAvailability() {
    val mockClient = createMockRapidClient()
    val operation = GetAvailabilityOperationContext.builder()
        .checkin("2024-12-01")
        .checkout("2024-12-03")
        .build()
    
    val response = mockClient.execute(operation)
    assertThat(response.data).isNotEmpty()
}
```

### Integration Testing

```kotlin
// Test against sandbox environment
@Test
@IntegrationTest
fun testRealApiCall() {
    val client = RapidClient.builder()
        .key(System.getenv("TEST_API_KEY"))
        .secret(System.getenv("TEST_API_SECRET"))
        .endpoint("https://test.ean.com/v3")
        .build()
    
    // Perform real API calls
}
```

## 🔍 Best Practices

### 1. Resource Management
```kotlin
// Use try-with-resources for file operations
response.data.use { file ->
    // Process file content
}
```

### 2. Error Handling
```kotlin
// Always handle specific exceptions
try {
    val response = client.execute(operation)
    return response.data
} catch (e: ExpediaGroupApiErrorException) {
    logger.error("API error: ${e.errorResponse}")
    throw BusinessException("Booking failed", e)
} catch (e: ExpediaGroupServiceException) {
    logger.error("Service error: ${e.message}")
    throw ServiceUnavailableException("Service temporarily unavailable", e)
}
```

### 3. Configuration Management
```kotlin
// Use configuration objects for reusable settings
class ApiConfiguration {
    companion object {
        fun createTestClient() = RapidClient.builder()
            .key(System.getenv("TEST_API_KEY"))
            .secret(System.getenv("TEST_API_SECRET"))
            .endpoint("https://test.ean.com/v3")
            .requestTimeout(30000)
            .build()
    }
}
```

### 4. Logging
```kotlin
// Configure structured logging
val client = RapidClient.builder()
    .key("api-key")
    .secret("api-secret")
    .maskedLoggingHeaders(setOf("Authorization"))
    .maskedLoggingBodyFields(setOf("creditCard", "ssn"))
    .build()
```

## 📖 Available SDKs

| SDK | Description | Maven Central | Documentation |
|-----|-------------|---------------|---------------|
| **Rapid SDK** | Hotel booking, availability, and management | [![Maven Central](https://img.shields.io/maven-central/v/com.expediagroup/rapid-sdk)](https://central.sonatype.com/artifact/com.expediagroup/rapid-sdk) | [Rapid SDK Docs](https://developers.expediagroup.com/docs/products/rapid/sdk/java) |
| **EWS XAP SDK** | Expedia Web Services XML API | [![Maven Central](https://img.shields.io/maven-central/v/com.expediagroup/xap-sdk)](https://central.sonatype.com/artifact/com.expediagroup/xap-sdk) | [XAP SDK Docs](https://developers.expediagroup.com/xap/sdk) |
| **Fraud Prevention V2** | Fraud detection and prevention | [![Maven Central](https://img.shields.io/maven-central/v/com.expediagroup/fraudpreventionv2-sdk)](https://central.sonatype.com/artifact/com.expediagroup/fraudpreventionv2-sdk) | [Fraud Prevention Docs](https://developers.expediagroup.com/docs/products/fraud-prevention/v2) |

## 🤝 Contributing

1. **Fork the repository**
2. **Create a feature branch**: `git checkout -b feature/amazing-feature`
3. **Make changes and add tests**
4. **Commit changes**: `git commit -m 'Add amazing feature'`
5. **Push to branch**: `git push origin feature/amazing-feature`
6. **Create Pull Request**

See [CONTRIBUTING.md](CONTRIBUTING.md) for detailed guidelines.

## 📝 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

- **Repository Issues**: [GitHub Issues](https://github.com/ExpediaGroup/expediagroup-java-sdk/issues)
- **SDK-Specific Support**: Refer to individual SDK repositories
- **Developer Hub**: [Expedia Group Developer Portal](https://developers.expediagroup.com/)

## 🔄 Version History

| Version | Release Date | Key Changes |
|---------|-------------|-------------|
| 5.0.1 | Latest | Current stable release |
| 5.0.0 | 2024 | Major version with breaking changes |
| 4.x.x | 2023 | Previous stable series |

---

**Made with ❤️ by the Expedia Group Platform Team**
