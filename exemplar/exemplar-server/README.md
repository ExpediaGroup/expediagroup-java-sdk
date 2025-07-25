# Exemplar Server

This module is a **Spring Boot application** that serves as the backend API server for the [Expedia Group SDK exemplar](https://github.com/ExpediaGroup/expediagroup-java-sdk). It provides both REST and GraphQL endpoints for a fictional hotel booking system and serves as the foundation for SDK generation and testing.

## 🎯 Purpose

The exemplar-server serves multiple purposes within the SDK ecosystem:

1. **API Reference Implementation**: Demonstrates how to build APIs that are suitable for SDK generation
2. **OpenAPI Specification Source**: Generates OpenAPI 3.1 specifications from Spring Boot code for REST SDK generation
3. **GraphQL Schema Provider**: Provides a complete GraphQL schema and resolvers for GraphQL SDK examples
4. **Development Server**: Enables testing and development of generated SDKs in a controlled environment

The server implements a simple hotel booking API with search, booking management, and CRUD operations.

## 📦 API Endpoints

The server provides comprehensive REST and GraphQL APIs for hotel booking operations:

### REST Endpoints

| Endpoint | Method | Description | Operation ID |
|----------|--------|-------------|--------------|
| `/api/v1/hotels` | GET | Search hotels with optional city and price filters | `search-hotel` |
| `/api/v1/hotels/{id}` | GET | Get hotel details by ID | `get-hotel-by-id` |
| `/api/v1/bookings` | GET | Retrieve all bookings | `get-all-bookings` |
| `/api/v1/bookings` | POST | Create a new hotel booking | `create-booking` |
| `/api/v1/bookings/{confirmationNumber}` | GET | Get booking by confirmation number | `get-booking-by-confirmation-number` |
| `/api/v1/bookings/{confirmationNumber}` | PUT | Update an existing booking | `update-booking` |
| `/api/v1/bookings/{confirmationNumber}` | DELETE | Delete a booking | `delete-booking` |

### GraphQL Operations

**Queries:**
- `hotels(city: String, maxPrice: BigDecimal): [Hotel!]!` - Search hotels
- `hotel(id: ID!): Hotel` - Get hotel by ID
- `bookings: [Booking!]!` - Get all bookings
- `booking(confirmationNumber: String!): Booking` - Get booking by confirmation number

**Mutations:**
- `createBooking(input: BookingInput!): Booking!` - Create a new booking
- `updateBooking(confirmationNumber: String!, input: BookingUpdateInput!): Booking!` - Update existing booking

## 🧱 Structure

This simple Spring Boot application is built using modern Kotlin practices and follows the standard Spring boot architecture.

#### 1. Build Configuration

Refer to the [`build.gradle.kts`](./build.gradle.kts) build file for complete configuration details.

| Configuration | Description |
|---------------|-------------|
| **Spring Boot** | Uses Spring Boot 3.5.3 with Spring Web and Spring GraphQL starters |
| **OpenAPI Generation** | Integrates `springdoc-openapi` for automatic OpenAPI spec generation |
| **Kotlin Support** | Built with Kotlin 1.9.25 and Spring Kotlin plugin |
| **GraphQL** | Includes Spring GraphQL starter for schema-first GraphQL implementation |
| **Documentation** | Swagger UI available at `/swagger-ui.html` for REST API testing |
| **GraphQL Playground** | GraphiQL interface available at `/graphiql` for interactive GraphQL testing |

#### 2. Source Code Structure

| Package | Description |
|---------|-------------|
| [`controller.rest`](./src/main/kotlin/com/expediagroup/exemplarserver/controller/rest) | REST controllers implementing the hotel booking API endpoints |
| [`controller.graphql`](./src/main/kotlin/com/expediagroup/exemplarserver/controller/graphql) | GraphQL controllers with query and mutation resolvers |
| [`service`](./src/main/kotlin/com/expediagroup/exemplarserver/service) | Business logic layer for hotel and booking operations |
| [`repository`](./src/main/kotlin/com/expediagroup/exemplarserver/repository) | Data access layer with in-memory storage for demo purposes |
| [`model`](./src/main/kotlin/com/expediagroup/exemplarserver/model) | Domain models (Hotel, Booking, GuestInfo, etc.) with validation annotations |
| [`exception`](./src/main/kotlin/com/expediagroup/exemplarserver/exception) | Custom exceptions and global exception handling |
| [`graphql`](./src/main/kotlin/com/expediagroup/exemplarserver/graphql) | GraphQL-specific input types and scalar configurations |

#### 3. Configuration Files

| File | Description |
|------|-------------|
| [`application.properties`](./src/main/resources/application.properties) | Spring Boot application configuration |
| [`schema.graphqls`](./src/main/resources/graphql/schema.graphqls) | GraphQL schema definition with types, queries, and mutations |

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Gradle 8.x (included via wrapper)

### 1. Start the Server

Navigate to the exemplar module root and start the server:

```bash
cd exemplar
./gradlew :exemplar-server:bootRun
```

The server will start on `http://localhost:8080` with the following interfaces:

- **REST API Base URL**: `http://localhost:8080/api/v1`
- **Swagger UI**: `http://localhost:8080/swagger-ui.html` - Interactive REST API documentation and testing
- **GraphQL Endpoint**: `http://localhost:8080/graphql`
- **GraphiQL Interface**: `http://localhost:8080/graphiql` - Interactive GraphQL query editor

### 2. Test the API

#### Using Swagger UI (REST)
1. Open `http://localhost:8080/swagger-ui.html`
2. Explore available endpoints
3. Test hotel search: `GET /api/v1/hotels?city=New York&maxPrice=300`
4. Create a booking using the `POST /api/v1/bookings` endpoint

#### Using GraphiQL (GraphQL)
1. Open `http://localhost:8080/graphiql`
2. Try a hotel search query:
```graphql
query {
  hotels(city: "New York", maxPrice: 300.00) {
    id
    name
    location {
      city
    }
    pricePerNight
  }
}
```

### 3. Generate OpenAPI Specification

To generate or update the OpenAPI specification for SDK generation:

```bash
./gradlew :exemplar-server:generateOpenApiDocs
```

This will:
1. Start the server if not already running
2. Fetch the OpenAPI specification from `/v3/api-docs.yaml`
3. Save it as `openapi.yaml` in the [`exemplar-sdk-rest`](../exemplar-sdk-rest) directory
4. Stop the server

## 🏗 Data Model

The server implements a complete hotel booking domain with the following key entities:

### Hotel
- **Properties**: ID, name, description, location, price per night, amenities, star rating, check-in/out times
- **Features**: Search by city and maximum price filter

### Booking
- **Properties**: Confirmation number, status, hotel reference, dates, guest count, guest info, total price, timestamps
- **Status**: PENDING, CONFIRMED, CANCELLED, COMPLETED
- **Operations**: Create, read, update, delete

### Location
- **Properties**: Address, city, state, country, postal code, latitude, longitude
- **Usage**: Embedded in Hotel entities for geographic information

### GuestInfo
- **Properties**: First name, last name, email, phone number
- **Validation**: Required fields with format validation

## 🧪 Testing

### Running Tests

Execute the test suite:

```bash
./gradlew :exemplar-server:test
```

The test suite includes:
- Unit tests for services and repositories
- Integration tests for REST controllers
- GraphQL resolver tests

### Manual Testing

#### REST API Testing
```bash
# Search hotels
curl "http://localhost:8080/api/v1/hotels?city=New%20York&maxPrice=300"

# Get hotel by ID
curl "http://localhost:8080/api/v1/hotels/1"

# Create a booking
curl -X POST "http://localhost:8080/api/v1/bookings" \
  -H "Content-Type: application/json" \
  -d '{
    "hotelId": 1,
    "checkInDate": "2025-08-15",
    "checkOutDate": "2025-08-18",
    "guests": 2,
    "guestInfo": {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "phoneNumber": "+1-555-123-4567"
    }
  }'
```

#### GraphQL Testing
Use the GraphiQL interface at `http://localhost:8080/graphiql` or send POST requests to `/graphql`:

```bash
curl -X POST "http://localhost:8080/graphql" \
  -H "Content-Type: application/json" \
  -d '{
    "query": "query { hotels(city: \"New York\") { id name pricePerNight } }"
  }'
```

## 🔗 Related Modules

The exemplar-server integrates with other modules in the SDK ecosystem:

* [`exemplar-sdk-rest`](../exemplar-sdk-rest): Generated REST client SDK that consumes this server's OpenAPI specification
* [`exemplar-sdk-graphql`](../exemplar-sdk-graphql): GraphQL client SDK that uses this server's GraphQL schema
* [`exemplar-playground-java`](../exemplar-playground-java): Testing and demonstration module that exercises both generated SDKs against this server
* [`expediagroup-sdk-core`](../../expediagroup-sdk-core): Foundation module providing core SDK abstractions
* [`expediagroup-sdk-openapi-plugin`](../../expediagroup-sdk-openapi-plugin): Gradle plugin used to generate REST SDKs from this server's OpenAPI spec

## 📝 Development Notes

### Code-First Development
The server follows a **code-first approach** where:
1. API endpoints are implemented in Spring Boot controllers
2. OpenAPI specifications are automatically generated from the code
3. GraphQL schemas are manually maintained but validated against resolvers
4. Client SDKs are generated from these specifications

### Error Handling
- Standardized error responses using **Problem Details (RFC 7807)**
- Global exception handling with `@ControllerAdvice`
- Appropriate HTTP status codes for different error scenarios
- GraphQL errors handled gracefully without throwing exceptions

### Data Storage
- Uses **in-memory storage** for demonstration purposes
- Pre-populated with sample hotels in major cities
- Data persists only during server runtime
- Suitable for testing and development workflows

### Extension Points
To adapt this server for your own API:
1. Modify the domain models in the `model` package
2. Update controllers to match your API design
3. Adjust the GraphQL schema as needed
4. Implement persistent storage if required
5. Regenerate OpenAPI specs and update SDK dependencies

## 📚 Key Features

This server demonstrates several important API development patterns:

1. **Dual Protocol Support**: Both REST and GraphQL endpoints for the same domain
2. **Automatic Documentation**: OpenAPI generation from Spring Boot annotations
3. **Type Safety**: Kotlin data classes with validation annotations
4. **Error Standardization**: Consistent error handling across all endpoints
5. **Testing Strategy**: Comprehensive test coverage with multiple testing approaches
6. **Development Tooling**: Interactive API exploration with Swagger UI and GraphiQL
