# Expedia Group SDK Exemplar

The **Expedia Group SDK Exemplar** is a comprehensive demonstration project that showcases how to build and use SDKs with the Expedia Group Java SDK Foundation modules. This exemplar provides a complete end-to-end example of building a client SDK for a REST API, including code generation, client implementation, and practical usage examples.

## 📋 Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Components](#components)
- [Getting Started](#getting-started)
- [Usage Examples](#usage-examples)
- [Building Your Own SDK](#building-your-own-sdk)
- [Development Workflow](#development-workflow)
- [Testing](#testing)

## 🎯 Overview

The exemplar demonstrates a complete SDK ecosystem for a fictional hotel booking API. It includes:

- **API Server**: A Spring Boot server that provides both REST and GraphQL endpoints for hotel booking operations
- **Generated REST SDK**: A client SDK generated from OpenAPI specifications
- **GraphQL Schema**: Code-first GraphQL schema with comprehensive type definitions
- **Usage Examples**: Java applications showing how to consume the REST SDK
- **Build Configuration**: Complete Gradle setup for multi-module SDK projects

This exemplar serves as a reference implementation for teams wanting to build their own SDKs using the Expedia Group SDK foundation, supporting both REST and GraphQL API patterns.

## 🏗 Architecture

```
exemplar/
├── exemplar-server/          # Mock API server (Spring Boot)
├── exemplar-sdk/            # Generated client SDK
├── exemplar-playground-java/ # Usage examples and demos
└── build.gradle.kts         # Multi-module build configuration
```

The architecture follows these principles:

1. **Code-First Development**: API is implemented in Spring Boot, with OpenAPI 3.1 specifications generated from the code
2. **Code Generation**: Client SDKs are automatically generated from the generated OpenAPI spec
3. **Modular Design**: Each component is a separate Gradle module with clear responsibilities
4. **Foundation Integration**: Leverages core SDK modules for common functionality

## 🧩 Components

### 1. exemplar-server

A **Spring Boot application** that provides the backend API for the exemplar:

- **Purpose**: Simulates a real API server that the SDK will interact with
- **Technology**: Spring Boot 3.x with Kotlin
- **API Types**: Supports both REST and GraphQL endpoints
- **Features**:
  - Hotel search endpoints with filtering capabilities
  - Booking management (create, read, update operations)
  - OpenAPI documentation generation
  - GraphQL schema with type-safe operations
  - Error handling with standardized problem details
- **REST Endpoints**:
  - `GET /api/v1/hotels` - Search hotels with optional filters
  - `POST /api/v1/bookings` - Create new bookings
  - `GET /api/v1/bookings` - List all bookings
  - `GET /api/v1/bookings/{confirmationNumber}` - Get specific booking
  - `PUT /api/v1/bookings/{confirmationNumber}` - Update booking
- **GraphQL Endpoints**:
  - `POST /graphql` - GraphQL endpoint for queries and mutations
  - GraphiQL interface available at `/graphiql` for interactive testing

### 2. exemplar-sdk

The **generated client SDK** that provides a Java interface to the API:

- **Purpose**: Demonstrates SDK generation and structure
- **Technology**: Generated using `com.expediagroup.sdk.openapigenerator` plugin
- **Key Dependencies**:
  - `expediagroup-sdk-rest`: Core REST SDK functionality
  - Jackson for JSON serialization
  - Generated models and operations
- **Features**:
  - Type-safe API models (Hotel, Booking, GuestInfo, etc.)
  - Operation classes for each API endpoint
  - Automatic request/response handling
  - Built-in error handling

### 3. exemplar-playground-java

**Java examples** demonstrating SDK usage patterns:

- **Purpose**: Shows practical SDK usage scenarios
- **Key Dependencies**:
  - `expediagroup-sdk-transport-okhttp`: HTTP transport implementation
  - The generated exemplar-sdk
- **Examples**:
  - `FullExemplarScenario.java`: Complete booking workflow
  - `ConfiguredOkHttpTransport.java`: Custom HTTP transport setup
  - `HandleOperationException.java`: Error handling patterns

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Gradle 8.x
- Node.js (for OpenAPI spec transformation)

### 1. Start the Server

```bash
cd exemplar/exemplar-server
./gradlew bootRun
```

The server will start on `http://localhost:8080` with:
- **Swagger UI** available at `http://localhost:8080/swagger-ui.html` for REST API testing
- **GraphiQL** available at `http://localhost:8080/graphiql` for GraphQL interactive testing

### 2. Generate the SDK

```bash
cd exemplar/exemplar-sdk
./gradlew transformSpecs generateSdk
```

This will:
- Transform the OpenAPI spec using Expedia Group conventions
- Generate Java client code from the transformed specification

### 3. Run the Examples

```bash
cd exemplar/exemplar-playground-java
./gradlew run
```

This executes the full exemplar scenario, demonstrating:
- Hotel searching
- Booking creation
- Booking updates
- Error handling

## 💡 Usage Examples

### Basic SDK Usage

```java
// Initialize the client
ExemplarClient client = new ExemplarClient();

// Search for hotels
SearchHotelOperationParams params = SearchHotelOperationParams.builder()
    .city("New York")
    .maxPrice(BigDecimal.valueOf(300.00))
    .build();

SearchHotelOperation operation = new SearchHotelOperation(params);
List<Hotel> hotels = client.execute(operation).getData();
```

### Making a Booking

```java
// Create guest information
GuestInfo guestInfo = GuestInfo.builder()
    .firstName("John")
    .lastName("Doe")
    .email("john.doe@example.com")
    .build();

// Create booking request
BookingRequest request = BookingRequest.builder()
    .hotelId(hotel.getId())
    .checkInDate(LocalDate.now())
    .checkOutDate(LocalDate.now().plusDays(3))
    .guestInfo(guestInfo)
    .guests(2)
    .build();

// Execute the booking
CreateBookingOperation operation = new CreateBookingOperation(request);
Booking booking = client.execute(operation).getData();
```

### Custom Transport Configuration

```java
// Configure custom HTTP transport
OkHttpTransport transport = OkHttpTransport.builder()
    .httpClient(customOkHttpClient)
    .build();

ExemplarClient client = new ExemplarClient(transport);
```

### GraphQL Usage Examples

The exemplar server also provides GraphQL endpoints that offer the same functionality as the REST API. Here are some example operations:

#### Hotel Search Query

```graphql
query SearchHotels($city: String, $maxPrice: BigDecimal) {
  hotels(city: $city, maxPrice: $maxPrice) {
    id
    name
    description
    location {
      city
      country
      address
    }
    pricePerNight
    amenities
    rating
  }
}
```

Variables:
```json
{
  "city": "New York",
  "maxPrice": 300.00
}
```

#### Create Booking Mutation

```graphql
mutation CreateBooking($input: BookingInput!) {
  createBooking(input: $input) {
    confirmationNumber
    status
    hotel {
      name
      location {
        city
      }
    }
    checkInDate
    checkOutDate
    guests
    totalPrice
    guestInfo {
      firstName
      lastName
      email
    }
    createdAt
  }
}
```

Variables:
```json
{
  "input": {
    "hotelId": "1",
    "checkInDate": "2025-08-15",
    "checkOutDate": "2025-08-18",
    "guests": 2,
    "guestInfo": {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "phone": "+1234567890"
    }
  }
}
```

#### Update Booking Mutation

```graphql
mutation UpdateBooking($confirmationNumber: String!, $input: BookingUpdateInput!) {
  updateBooking(confirmationNumber: $confirmationNumber, input: $input) {
    confirmationNumber
    status
    checkInDate
    checkOutDate
    guests
    totalPrice
    guestInfo {
      firstName
      lastName
      email
      phone
    }
  }
}
```

Variables:
```json
{
  "confirmationNumber": "BK12345678",
  "input": {
    "checkOutDate": "2025-08-20",
    "guests": 3
  }
}
```

## 🛠 Building Your Own SDK

The exemplar serves as a template for building your own SDKs. Here's how to adapt it:

### 1. Implement Your API Server

Create your Spring Boot controllers and models, then generate the OpenAPI spec:

```kotlin
@RestController
@RequestMapping("/api/v1")
class YourApiController {
    
    @GetMapping("/your-endpoint")
    @Operation(summary = "Your endpoint description")
    fun yourEndpoint(): ResponseEntity<YourResponse> {
        // Implementation here
    }
}
```

### 2. Generate OpenAPI Specification

Use Spring Boot's OpenAPI generation to create your spec, or manually create `openapi.yaml` if needed:

```yaml
openapi: 3.1.0
info:
  title: Your API
  version: v1
servers:
  - url: https://your-api.com
paths:
  # Define your endpoints here
```

### 3. Update Build Configuration

Modify `exemplar-sdk/build.gradle.kts`:

```kotlin
egSdkGenerator {
    namespace = "your-api"
    basePackage = "com.yourcompany.sdk.yourapi"
    specFilePath = File("${project.layout.projectDirectory}/transformed-spec.yml")
}
```

### 4. Customize Dependencies

Update dependencies in your SDK module:

```kotlin
dependencies {
    // Core SDK dependencies
    api("com.expediagroup:expediagroup-sdk-rest:latest")
    
    // Your specific dependencies
    implementation("your.custom:dependency:version")
}
```

### 5. Add Custom Logic

Extend generated classes or add utilities in `src/main/java`:

```java
public class YourApiClientBuilder {
    public static YourApiClient createClient() {
        return new YourApiClient(/* custom configuration */);
    }
}
```

## 🔄 Development Workflow

### Code Generation Pipeline

1. **Spec Transformation**: `transformSpecs` task processes your OpenAPI spec
   - Adds required headers
   - Converts operation IDs to tags
   - Applies Expedia Group conventions

2. **Code Generation**: `generateSdk` task creates Java classes
   - Model classes for request/response objects
   - Operation classes for each endpoint
   - Client classes for API interaction

3. **Compilation**: Standard Gradle build compiles generated and custom code

### Key Gradle Tasks

```bash
# Transform OpenAPI specs
./gradlew transformSpecs

# Generate SDK code
./gradlew generateSdk

# Build everything
./gradlew build

# Run the server
./gradlew :exemplar-server:bootRun

# Run playground examples
./gradlew :exemplar-playground-java:run
```

## 🧪 Testing

The exemplar includes comprehensive testing approaches:

### Server Testing

```bash
cd exemplar-server
./gradlew test
```

Tests the Spring Boot application endpoints and business logic.

### SDK Integration Testing

The playground module serves as integration tests:

```bash
cd exemplar-playground-java
./gradlew test
```

### End-to-End Testing

1. Start the server: `./gradlew :exemplar-server:bootRun`
2. Run the playground: `./gradlew :exemplar-playground-java:run`
3. Verify all operations complete successfully

## 📚 Key Learnings

This exemplar demonstrates several important patterns:

1. **Code-First Development**: Implement APIs in Spring Boot, then generate OpenAPI specs for client SDK generation
2. **Code Generation**: Automate client code generation for consistency
3. **Layered Architecture**: Separate concerns between transport, models, and operations
4. **Error Handling**: Standardized error responses using Problem Details (RFC 7807)
5. **Configuration Management**: Flexible client configuration for different environments
6. **Testing Strategy**: Multiple levels of testing from unit to integration

## 🔗 Related Modules

The exemplar integrates with these SDK foundation modules:

- **expediagroup-sdk-core**: Core utilities and interfaces
- **expediagroup-sdk-rest**: REST API client foundation
- **expediagroup-sdk-transport-okhttp**: HTTP transport implementation
- **expediagroup-sdk-openapi-plugin**: Code generation from OpenAPI specs

## 🤝 Contributing

When extending this exemplar or building your own SDK:

1. Follow the established package structure
2. Use the same build conventions
3. Include comprehensive examples
4. Document your API changes
5. Add appropriate tests

---

This exemplar provides a solid foundation for understanding and building SDKs with the Expedia Group Java SDK. Use it as a reference, starting point, or learning tool for your own SDK development projects.
