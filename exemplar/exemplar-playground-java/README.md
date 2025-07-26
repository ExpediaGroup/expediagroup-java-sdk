# Exemplar Playground Java

The **Exemplar Playground Java** module provides comprehensive, practical examples demonstrating how to use the Expedia Group Java SDK for both REST and GraphQL APIs. This playground serves as a complete reference implementation, user guide, and technical documentation for SDK integration patterns.

## 📋 Table of Contents

- [Overview](#overview)
- [Architecture & Structure](#architecture--structure)
- [SDK Capabilities Showcase](#sdk-capabilities-showcase)
- [Getting Started](#getting-started)
- [Usage Examples](#usage-examples)
- [Advanced Features](#advanced-features)
- [Best Practices](#best-practices)
- [Troubleshooting](#troubleshooting)

## 🎯 Overview

This playground demonstrates the full capabilities of the Expedia Group Java SDK ecosystem through practical, runnable examples. It showcases how to build robust, production-ready applications using the SDK's core features including:

- **REST API Integration**: Complete CRUD operations for hotel booking scenarios
- **GraphQL Support**: Type-safe GraphQL operations with Apollo Kotlin integration
- **Async Programming**: CompletableFuture-based async clients and operation patterns
- **Custom Transport Layers**: Pluggable HTTP transport implementations
- **Error Handling**: Comprehensive error handling strategies for different failure scenarios
- **Configuration Management**: Flexible client configuration for various environments

> **Note**: This playground works with the [exemplar-server](../exemplar-server) to provide a complete end-to-end demonstration. The server provides both REST and GraphQL endpoints that these examples interact with.

## 🏗 Architecture & Structure

```
exemplar-playground-java/
├── src/main/java/com/expediagroup/sdk/exemplar/playground/
│   ├── common/                    # Shared utilities and configurations
│   │   ├── ConfigureOkHttpTransport.java    # Custom OkHttp transport setup
│   │   ├── CustomTransport.java             # Java HttpClient transport demo
│   │   └── CustomAsyncTransport.java        # Async transport implementation
│   ├── rest/                      # REST API usage examples
│   │   ├── FullExemplarScenario.java        # Complete sync REST workflow
│   │   ├── AsyncFullExemplarScenario.java   # Complete async REST workflow
│   │   └── HandleOperationException.java    # REST error handling patterns
│   └── graphql/                   # GraphQL usage examples
│       ├── FullExemplarScenario.java        # Complete sync GraphQL workflow
│       ├── AsyncFullExemplarScenario.java   # Complete async GraphQL workflow
│       └── HandleOperationException.java    # GraphQL error handling patterns
└── build.gradle.kts              # Build configuration and dependencies
```

### Key Dependencies

| Dependency | Purpose | Documentation |
|------------|---------|---------------|
| `expediagroup-sdk-transport-okhttp` | Default HTTP transport layer | [Transport OkHttp](../../expediagroup-sdk-transport-okhttp) |
| `exemplar-sdk-rest` | Generated REST client SDK | [Exemplar REST SDK](../exemplar-sdk-rest) |
| `exemplar-sdk-graphql` | Generated GraphQL client SDK | [Exemplar GraphQL SDK](../exemplar-sdk-graphql) |
| `log4j-slf4j2-impl` | Logging implementation | Standard SLF4J logging |

## 🚀 SDK Capabilities Showcase

### 1. **REST API Operations**

The playground demonstrates all CRUD operations through a hotel booking workflow:

#### Hotel Search with Filtering
```java
// Search hotels with criteria
SearchHotelOperationParams params = SearchHotelOperationParams.builder()
    .city("New York")
    .maxPrice(BigDecimal.valueOf(400.00))
    .minRating(BigDecimal.valueOf(4.0))
    .build();

SearchHotelOperation operation = new SearchHotelOperation(params);
Response<List<? extends Hotel>> response = client.execute(operation);
List<? extends Hotel> hotels = response.getData();
```

#### Booking Management Lifecycle
```java
// Create a new booking
BookingRequest bookingRequest = BookingRequest.builder()
    .hotelId(selectedHotel.getId())
    .checkInDate(LocalDate.of(2025, 8, 15))
    .checkOutDate(LocalDate.of(2025, 8, 18))
    .guests(2)
    .guestInfo(guestInfo)
    .build();

CreateBookingOperation createOp = new CreateBookingOperation(bookingRequest);
Booking booking = client.execute(createOp).getData();

// Retrieve booking details
GetBookingOperation getOp = new GetBookingOperation(booking.getConfirmationNumber());
Booking retrievedBooking = client.execute(getOp).getData();

// Update booking information
BookingUpdateRequest updateRequest = BookingUpdateRequest.builder()
    .checkOutDate(LocalDate.of(2025, 8, 20))
    .guests(3)
    .build();

UpdateBookingOperation updateOp = new UpdateBookingOperation(
    booking.getConfirmationNumber(), 
    updateRequest
);
Booking updatedBooking = client.execute(updateOp).getData();
```

### 2. **GraphQL Operations**

Type-safe GraphQL operations with comprehensive schema support:

#### GraphQL Queries
```java
// Hotel search query with nested field selection
SearchHotelsQuery query = SearchHotelsQuery.builder()
    .city(Optional.of("New York"))
    .maxPrice(Optional.of(BigDecimal.valueOf(400.00)))
    .build();

ApolloResponse<SearchHotelsQuery.Data> response = client.query(query).execute();
List<SearchHotelsQuery.Hotel> hotels = response.data.hotels;
```

#### GraphQL Mutations
```java
// Create booking mutation
BookingInput input = BookingInput.builder()
    .hotelId("hotel-123")
    .checkInDate(LocalDate.of(2025, 8, 15))
    .checkOutDate(LocalDate.of(2025, 8, 18))
    .guests(2)
    .guestInfo(guestInfoInput)
    .build();

CreateBookingMutation mutation = CreateBookingMutation.builder()
    .input(input)
    .build();

ApolloResponse<CreateBookingMutation.Data> response = client.mutation(mutation).execute();
CreateBookingMutation.CreateBooking booking = response.data.createBooking;
```

### 3. **Async Programming Patterns**

Complete async implementation using CompletableFuture:

#### Async REST Operations
```java
AsyncExemplarClient asyncClient = new AsyncExemplarClient();

// Async hotel search
CompletableFuture<Response<List<? extends Hotel>>> hotelsFuture = 
    asyncClient.execute(searchOperation);

// Chain async operations
CompletableFuture<Booking> bookingFuture = hotelsFuture
    .thenCompose(hotelsResponse -> {
        Hotel selectedHotel = hotelsResponse.getData().get(0);
        CreateBookingOperation bookingOp = new CreateBookingOperation(
            createBookingRequest(selectedHotel)
        );
        return asyncClient.execute(bookingOp);
    })
    .thenApply(Response::getData);
```

#### Async GraphQL Operations
```java
ExemplarAsyncGraphQLClient asyncGraphQLClient = new ExemplarAsyncGraphQLClient();

// Async GraphQL query
CompletableFuture<ApolloResponse<SearchHotelsQuery.Data>> future = 
    asyncGraphQLClient.query(searchQuery).toFlow().single();

// Handle async results
future.thenAccept(response -> {
    if (!response.hasErrors()) {
        List<SearchHotelsQuery.Hotel> hotels = response.data.hotels;
        logger.info("Found {} hotels asynchronously", hotels.size());
    }
});
```

### 4. **Custom Transport Implementations**

Pluggable transport layer supporting different HTTP clients:

#### Built-in OkHttp Transport Configuration
```java
// Custom OkHttp client configuration
OkHttpClient customHttpClient = new OkHttpClient.Builder()
    .connectTimeout(30, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .addInterceptor(new LoggingInterceptor())
    .build();

// Create transport with custom client
OkHttpTransport transport = OkHttpTransport.builder()
    .httpClient(customHttpClient)
    .build();

// Use transport with SDK client
ExemplarClient client = new ExemplarClient(transport);
```

#### Java HttpClient Custom Transport
```java
// Custom transport using Java's built-in HttpClient
public class Java11HttpClientTransport implements Transport {
    private final HttpClient httpClient;
    
    public Java11HttpClientTransport() {
        this.httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(30))
            .followRedirects(HttpClient.Redirect.NORMAL)
            .version(HttpClient.Version.HTTP_2)
            .build();
    }
    
    @Override
    public Response execute(Request request) {
        // Custom HTTP client implementation
        // Map SDK request -> HTTP request -> HTTP response -> SDK response
    }
}
```

### 5. **Comprehensive Error Handling**

Production-ready error handling for different failure scenarios:

#### REST Error Handling
```java
try {
    SearchHotelOperation operation = new SearchHotelOperation(params);
    Response<List<? extends Hotel>> response = client.execute(operation);
    
    // Handle successful response
    List<? extends Hotel> hotels = response.getData();
    
} catch (ServiceException e) {
    // Handle service-level errors (4xx, 5xx responses)
    logger.error("Service error: {} (HTTP {})", e.getMessage(), e.getStatusCode());
    
} catch (TransportException e) {
    // Handle transport-level errors (network issues, timeouts)
    logger.error("Transport error: {}", e.getMessage());
    
} catch (Exception e) {
    // Handle unexpected errors
    logger.error("Unexpected error: {}", e.getMessage());
}
```

#### GraphQL Error Handling
```java
ApolloResponse<SearchHotelsQuery.Data> response = client.query(query).execute();

if (response.hasErrors()) {
    // Handle GraphQL errors
    for (com.apollographql.apollo3.api.Error error : response.errors) {
        logger.error("GraphQL error: {} at {}", error.getMessage(), error.getPath());
    }
} else if (response.exception != null) {
    // Handle transport/network exceptions
    logger.error("Request failed: {}", response.exception.getMessage());
} else {
    // Handle successful response
    List<SearchHotelsQuery.Hotel> hotels = response.data.hotels;
}
```

## 🚀 Getting Started

### Prerequisites

- **Java 17 or higher**
- **Gradle 8.x**
- **exemplar-server running** (see [server setup](../exemplar-server/README.md))

### 1. Start the Exemplar Server

```bash
# From the exemplar root directory
cd exemplar
./gradlew exemplar-server:bootRun
```

The server will start on `http://localhost:8080` with:
- **REST API** at `http://localhost:8080/api/v1/`
- **GraphQL endpoint** at `http://localhost:8080/graphql`
- **Swagger UI** at `http://localhost:8080/swagger-ui.html`
- **GraphiQL** at `http://localhost:8080/graphiql`

### 2. Build the Playground

```bash
cd exemplar-playground-java
./gradlew build
```

### 3. Run Individual Examples

Each example can be run independently:

```bash
# Full REST workflow (synchronous)
./gradlew run --args="com.expediagroup.sdk.exemplar.playground.rest.FullExemplarScenario"

# Full REST workflow (asynchronous)
./gradlew run --args="com.expediagroup.sdk.exemplar.playground.rest.AsyncFullExemplarScenario"

# GraphQL workflow (synchronous)
./gradlew run --args="com.expediagroup.sdk.exemplar.playground.graphql.FullExemplarScenario"

# GraphQL workflow (asynchronous)
./gradlew run --args="com.expediagroup.sdk.exemplar.playground.graphql.AsyncFullExemplarScenario"

# Error handling examples
./gradlew run --args="com.expediagroup.sdk.exemplar.playground.rest.HandleOperationException"
./gradlew run --args="com.expediagroup.sdk.exemplar.playground.graphql.HandleOperationException"

# Custom transport examples
./gradlew run --args="com.expediagroup.sdk.exemplar.playground.common.ConfigureOkHttpTransport"
./gradlew run --args="com.expediagroup.sdk.exemplar.playground.common.CustomTransport"
./gradlew run --args="com.expediagroup.sdk.exemplar.playground.common.CustomAsyncTransport"
```

## 💡 Usage Examples

### Complete REST Workflow

The [`FullExemplarScenario.java`](src/main/java/com/expediagroup/sdk/exemplar/playground/rest/FullExemplarScenario.java) demonstrates a complete hotel booking workflow:

1. **Hotel Search**: Search for hotels with specific criteria
2. **Hotel Selection**: Select hotels from search results
3. **Booking Creation**: Create multiple bookings for selected hotels
4. **Booking Retrieval**: Fetch all existing bookings
5. **Booking Updates**: Modify booking details (dates, guest count, etc.)

```java
public class FullExemplarScenario {
    private static final ExemplarClient client = new ExemplarClient();
    
    public static void main(String[] args) {
        // 1. Search for hotels
        List<? extends Hotel> hotels = searchHotels();
        
        // 2. Create bookings for selected hotels
        List<Booking> bookings = createBookings(hotels);
        
        // 3. Retrieve and display all bookings
        displayAllBookings();
        
        // 4. Update booking details
        updateBookings(bookings);
    }
}
```

### Complete GraphQL Workflow

The [`FullExemplarScenario.java`](src/main/java/com/expediagroup/sdk/exemplar/playground/graphql/FullExemplarScenario.java) demonstrates GraphQL operations:

```java
public class FullExemplarScenario {
    private static final ExemplarGraphQLClient client = new ExemplarGraphQLClient();
    
    public static void main(String[] args) {
        // 1. Execute GraphQL hotel search query
        SearchHotelsQuery query = SearchHotelsQuery.builder()
            .city(Optional.of("New York"))
            .maxPrice(Optional.of(BigDecimal.valueOf(400.00)))
            .build();
            
        ApolloResponse<SearchHotelsQuery.Data> response = client.query(query).execute();
        
        // 2. Create booking using GraphQL mutation
        if (!response.hasErrors() && !response.data.hotels.isEmpty()) {
            createBookingWithGraphQL(response.data.hotels.get(0));
        }
    }
}
```

### Async Programming Patterns

The async examples demonstrate proper CompletableFuture usage:

```java
// Async REST example
CompletableFuture<Void> workflow = searchHotelsAsync()
    .thenCompose(this::createBookingsAsync)
    .thenCompose(this::updateBookingsAsync)
    .thenRun(() -> logger.info("✅ Async workflow completed successfully!"))
    .exceptionally(throwable -> {
        logger.error("❌ Async workflow failed: {}", throwable.getMessage());
        return null;
    });

// Wait for completion
workflow.join();
```

## 🔧 Advanced Features

### Custom Transport Layer

The playground includes examples of implementing custom transport layers:

#### Synchronous Custom Transport
```java
public class MyCustomTransport implements Transport {
    private final HttpClient httpClient;
    
    @Override
    public Response execute(Request request) {
        // Map SDK Request -> HTTP Request
        HttpRequest httpRequest = buildHttpRequest(request);
        
        // Execute HTTP request  
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, 
            HttpResponse.BodyHandlers.ofString());
            
        // Map HTTP Response -> SDK Response
        return mapToSdkResponse(httpResponse, request);
    }
}
```

#### Asynchronous Custom Transport  
```java
public class MyAsyncTransport implements AsyncTransport {
    @Override
    public CompletableFuture<Response> execute(Request request) {
        return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
            .thenApply(httpResponse -> mapToSdkResponse(httpResponse, request));
    }
}
```

### Configuration Management

Examples show flexible client configuration:

```java
// Production configuration
ExemplarClient prodClient = ExemplarClient.builder()
    .endpoint("https://api.production.com")
    .transport(createProductionTransport())
    .build();

// Development configuration with custom transport
ExemplarClient devClient = ExemplarClient.builder()
    .endpoint("http://localhost:8080")
    .transport(createDevelopmentTransport())
    .build();
```

## 📚 Best Practices

### 1. **Resource Management**
Always properly dispose of clients and transports:

```java
try (ExemplarClient client = new ExemplarClient()) {
    // Use the client
} // Client automatically disposed
```

### 2. **Error Handling Strategy**
Implement comprehensive error handling:

```java
public void handleOperation() {
    try {
        // Execute operation
        Response<Data> response = client.execute(operation);
        processResponse(response);
        
    } catch (ServiceException e) {
        // Handle 4xx/5xx HTTP errors
        handleServiceError(e);
    } catch (TransportException e) {
        // Handle network/transport errors
        handleTransportError(e);
    } catch (Exception e) {
        // Handle unexpected errors
        handleUnexpectedError(e);
    }
}
```

### 3. **Async Programming**
Use proper async patterns with CompletableFuture:

```java
// Good: Chain operations properly
CompletableFuture<Result> future = asyncOperation1()
    .thenCompose(result1 -> asyncOperation2(result1))
    .thenApply(this::processResult)
    .exceptionally(this::handleError);

// Handle completion
future.thenAccept(this::handleSuccess);
```

### 4. **Logging and Monitoring**
Use structured logging for better observability:

```java
logger.info("Starting hotel search with criteria: city={}, maxPrice={}", 
    city, maxPrice);
    
logger.debug("Search operation completed in {}ms with {} results", 
    duration, results.size());
```

## 🔍 Troubleshooting

### Common Issues and Solutions

#### Server Connection Issues
```bash
# Verify server is running
curl http://localhost:8080/api/v1/hotels

# Check server logs
./gradlew exemplar-server:bootRun --info
```

#### SDK Generation Issues
```bash
# Regenerate SDK if models are outdated
cd exemplar-sdk-rest
./gradlew transformSpecs generateSdk

cd exemplar-sdk-graphql  
./gradlew generateExemplarApolloSources
```

#### Build Issues
```bash
# Clean and rebuild
./gradlew clean build

# Check for dependency conflicts
./gradlew dependencies
```

#### Runtime Errors
- **ClassNotFoundException**: Ensure all required dependencies are included
- **Connection refused**: Verify exemplar-server is running on localhost:8080
- **Timeout errors**: Check network connectivity and increase timeout values

### Debug Mode

Enable debug logging by updating log4j2.xml:

```xml
<Logger name="com.expediagroup.sdk" level="DEBUG"/>
<Logger name="okhttp3" level="DEBUG"/>
```

## 🔗 Related Documentation

- **[Exemplar Server](../exemplar-server/README.md)**: API server implementation
- **[Exemplar REST SDK](../exemplar-sdk-rest/README.md)**: Generated REST client
- **[Exemplar GraphQL SDK](../exemplar-sdk-graphql/README.md)**: Generated GraphQL client  
- **[SDK Core](../../expediagroup-sdk-core/README.md)**: Core SDK foundation
- **[SDK REST](../../expediagroup-sdk-rest/README.md)**: REST client framework
- **[SDK Transport OkHttp](../../expediagroup-sdk-transport-okhttp/README.md)**: Default transport layer

## 🤝 Contributing

When extending the playground or adding new examples:

1. **Follow the established package structure**: `common/`, `rest/`, `graphql/`
2. **Include comprehensive documentation**: JavaDoc comments and README updates
3. **Add proper error handling**: Demonstrate both happy path and error scenarios
4. **Provide runnable examples**: Each class should have a main method
5. **Use meaningful logging**: Help users understand what's happening
6. **Test with the server**: Ensure examples work with exemplar-server

### Adding New Examples

1. Create the example class in the appropriate package
2. Include comprehensive JavaDoc documentation
3. Add a main method for standalone execution
4. Update this README with usage instructions
5. Test the example end-to-end

---

This playground provides a comprehensive foundation for understanding and using the Expedia Group Java SDK. Use these examples as a starting point for your own SDK integration projects, and refer to the individual class documentation for detailed implementation guidance.
