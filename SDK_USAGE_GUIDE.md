# SDK Usage Guide

## Quick Start for SDK Users

This guide shows you how to use the generated Expedia Group SDKs in your applications.

## 🏨 Rapid SDK - Hotel Booking

### Installation

```xml
<dependency>
    <groupId>com.expediagroup</groupId>
    <artifactId>rapid-sdk</artifactId>
    <version>5.0.1</version>
</dependency>
```

### Basic Setup

```kotlin
val rapidClient = RapidClient.builder()
    .key("your-api-key")
    .secret("your-api-secret")
    .endpoint("https://test.ean.com/v3") // Test environment
    .build()
```

### Common Operations

#### 1. Search for Hotels

```kotlin
// Search for available properties
val searchParams = GetAvailabilityOperationParams.builder()
    .checkin("2024-12-01")
    .checkout("2024-12-03")
    .occupancy(listOf("2"))  // 2 adults
    .currency("USD")
    .language("en-US")
    .countryCode("US")
    .propertyId(listOf("12345"))
    .customerIp("192.168.1.1")
    .build()

val searchOperation = GetAvailabilityOperation(searchParams)
val response = rapidClient.execute(searchOperation)

response.data.forEach { property ->
    println("Property: ${property.propertyId}")
    property.roomTypes?.forEach { room ->
        println("  Room: ${room.name} - ${room.ratePlans?.firstOrNull()?.price?.total?.inclusive}")
    }
}
```

#### 2. Get Property Details

```kotlin
val contentParams = GetPropertyContentOperationParams.builder()
    .propertyId(listOf("12345"))
    .language("en-US")
    .include(listOf(
        GetPropertyContentOperationParams.Include.AMENITIES,
        GetPropertyContentOperationParams.Include.IMAGES,
        GetPropertyContentOperationParams.Include.THEMES
    ))
    .build()

val contentOperation = GetPropertyContentOperation(contentParams)
val contentResponse = rapidClient.execute(contentOperation)

contentResponse.data.forEach { (propertyId, content) ->
    println("Property: ${content.name}")
    println("Description: ${content.descriptions?.overview}")
    println("Address: ${content.address?.line1}, ${content.address?.city}")
    
    content.images?.forEach { image ->
        println("Image: ${image.url}")
    }
}
```

#### 3. Create a Booking

```kotlin
// Build the booking request
val guestInfo = CreateItineraryRequestRoomsGuestInfo.builder()
    .firstName("John")
    .lastName("Doe")
    .build()

val room = CreateItineraryRequestRoom.builder()
    .occupancy(CreateItineraryRequestRoomOccupancy.builder()
        .numberOfAdults(2)
        .build())
    .ratePlanId("12345-rate-plan")
    .guestInfo(listOf(guestInfo))
    .build()

val bookingRequest = CreateItineraryRequest.builder()
    .affiliateReferenceId("your-booking-ref-${System.currentTimeMillis()}")
    .hold(false)  // false = book immediately, true = hold reservation
    .email("john.doe@example.com")
    .phone(PhoneRequest.builder()
        .countryCode("1")
        .areaCode("555")
        .number("1234567")
        .build())
    .rooms(listOf(room))
    .payments(listOf(
        PaymentRequest.builder()
            .type(PaymentRequest.Type.CUSTOMER_CARD)
            .number("4111111111111111")
            .expirationMonth("12")
            .expirationYear("2025")
            .securityCode("123")
            .build()
    ))
    .build()

val bookingParams = PostItineraryOperationParams.builder()
    .customerIp("192.168.1.1")
    .customerSessionId("session-${System.currentTimeMillis()}")
    .build()

val bookingOperation = PostItineraryOperation(bookingParams, bookingRequest)

try {
    val bookingResponse = rapidClient.execute(bookingOperation)
    val itinerary = bookingResponse.data
    
    println("Booking successful!")
    println("Itinerary ID: ${itinerary.itineraryId}")
    println("Confirmation Number: ${itinerary.confirmationId}")
    
    itinerary.rooms?.forEach { room ->
        println("Room ${room.id}: ${room.confirmationId}")
    }
    
} catch (e: ExpediaGroupApiErrorException) {
    println("Booking failed: ${e.message}")
    // Handle specific error scenarios
    when (val error = e.errorResponse) {
        is RapidError -> {
            error.errors?.forEach { err ->
                println("Error: ${err.type} - ${err.message}")
            }
        }
    }
}
```

#### 4. Retrieve Existing Booking

```kotlin
val retrieveParams = GetReservationByItineraryIdOperationParams.builder()
    .itineraryId("12345678")
    .customerIp("192.168.1.1")
    .include(listOf(
        GetReservationByItineraryIdOperationParams.Include.HISTORY,
        GetReservationByItineraryIdOperationParams.Include.LINKS
    ))
    .build()

val retrieveOperation = GetReservationByItineraryIdOperation(retrieveParams)
val reservationResponse = rapidClient.execute(retrieveOperation)

val reservation = reservationResponse.data
println("Booking Status: ${reservation.bookingStatus}")
println("Total Price: ${reservation.totalAmount}")

reservation.rooms?.forEach { room ->
    println("Room: ${room.ratePlans?.firstOrNull()?.description}")
    println("Check-in: ${room.checkIn}")
    println("Check-out: ${room.checkOut}")
}
```

#### 5. Cancel a Booking

```kotlin
val cancelParams = DeleteRoomOperationParams.builder()
    .itineraryId("12345678")
    .roomId("room-123")
    .customerIp("192.168.1.1")
    .reason("customer_request")
    .build()

val cancelOperation = DeleteRoomOperation(cancelParams)

try {
    rapidClient.execute(cancelOperation)
    println("Room cancelled successfully")
} catch (e: ExpediaGroupApiErrorException) {
    println("Cancellation failed: ${e.message}")
}
```

### Advanced Features

#### Pagination

```kotlin
// Use paginator for large result sets
val params = GetRegionsOperationParams.builder()
    .language("en-US")
    .include(listOf(GetRegionsOperationParams.Include.STANDARD))
    .build()

val paginator = rapidClient.paginate(GetRegionsOperation(params))

for (page in paginator) {
    page.data.forEach { region ->
        println("Region: ${region.name}")
    }
}
```

#### Async Operations

```kotlin
val futureResponse = rapidClient.executeAsync(searchOperation)

futureResponse.thenAccept { response ->
    response.data.forEach { property ->
        println("Found property: ${property.propertyId}")
    }
}.exceptionally { throwable ->
    println("Search failed: ${throwable.message}")
    null
}
```

#### Custom HTTP Configuration

```kotlin
val customClient = OkHttpClient.Builder()
    .connectTimeout(10, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("X-My-Custom-Header", "value")
            .build()
        chain.proceed(request)
    }
    .build()

val rapidClient = RapidClient.builder()
    .key("api-key")
    .secret("api-secret")
    .httpClient(customClient)
    .build()
```

## 🛡️ Fraud Prevention SDK

### Installation

```xml
<dependency>
    <groupId>com.expediagroup</groupId>
    <artifactId>fraudpreventionv2-sdk</artifactId>
    <version>2.0.0</version>
</dependency>
```

### Basic Usage

```kotlin
val fraudClient = FraudPreventionV2Client.builder()
    .key("your-api-key")
    .secret("your-api-secret")
    .endpoint("https://api.expediagroup.com/fraudpreventionv2")
    .build()

// Submit account screen event
val accountScreen = AccountScreenRequest.builder()
    .siteInfo(SiteInfo.builder()
        .brandName("YourBrand")
        .locale("en-US")
        .build())
    .deviceDetails(DeviceDetails.builder()
        .ipAddress("192.168.1.1")
        .userAgent("Mozilla/5.0...")
        .build())
    .accountDetails(AccountDetails.builder()
        .userId("user123")
        .username("john.doe@example.com")
        .build())
    .build()

val params = AccountScreenNotifyOperationParams.builder()
    .build()

val operation = AccountScreenNotifyOperation(params, accountScreen)
fraudClient.execute(operation)
```

## 🔧 Error Handling Patterns

### Comprehensive Error Handling

```kotlin
fun bookHotel(bookingRequest: CreateItineraryRequest): BookingResult {
    return try {
        val response = rapidClient.execute(bookingOperation)
        BookingResult.Success(response.data)
        
    } catch (e: ExpediaGroupApiErrorException) {
        when (val error = e.errorResponse) {
            is RapidError -> {
                val firstError = error.errors?.firstOrNull()
                when (firstError?.type) {
                    "ROOM_UNAVAILABLE" -> BookingResult.RoomUnavailable
                    "PAYMENT_FAILED" -> BookingResult.PaymentFailed(firstError.message)
                    "INVALID_INPUT" -> BookingResult.InvalidInput(firstError.message)
                    else -> BookingResult.ApiError(e.message ?: "Unknown error")
                }
            }
            else -> BookingResult.ApiError(e.message ?: "Unknown error")
        }
    } catch (e: ExpediaGroupServiceException) {
        BookingResult.ServiceUnavailable
    } catch (e: ExpediaGroupConfigurationException) {
        BookingResult.ConfigurationError(e.message ?: "Configuration error")
    } catch (e: Exception) {
        BookingResult.UnknownError(e.message ?: "Unknown error")
    }
}

sealed class BookingResult {
    data class Success(val itinerary: ItineraryCreation) : BookingResult()
    object RoomUnavailable : BookingResult()
    data class PaymentFailed(val reason: String?) : BookingResult()
    data class InvalidInput(val message: String?) : BookingResult()
    data class ApiError(val message: String) : BookingResult()
    object ServiceUnavailable : BookingResult()
    data class ConfigurationError(val message: String) : BookingResult()
    data class UnknownError(val message: String) : BookingResult()
}
```

## 🏗️ Builder Pattern Examples

All SDK objects use the builder pattern for clean, type-safe construction:

```kotlin
// Complex nested object construction
val searchRequest = GetAvailabilityOperationParams.builder()
    .checkin("2024-12-01")
    .checkout("2024-12-05")
    .occupancy(listOf("2", "1-9"))  // 2 adults, 1 adult + 1 child age 9
    .currency("USD")
    .language("en-US")
    .countryCode("US")
    .propertyId(listOf("12345", "67890"))
    .rateOption(listOf(
        GetAvailabilityOperationParams.RateOption.MEMBER,
        GetAvailabilityOperationParams.RateOption.NET_RATES
    ))
    .salesChannel("website")
    .salesEnvironment("hotel_only")
    .filter(listOf(
        GetAvailabilityOperationParams.Filter.REFUNDABLE,
        GetAvailabilityOperationParams.Filter.PROPERTY_COLLECTBOOLEAN
    ))
    .include(listOf(
        GetAvailabilityOperationParams.Include.AMENITIES,
        GetAvailabilityOperationParams.Include.SALE_SCENARIO
    ))
    .build()
```

## 📊 Response Processing

### Extracting Data from Responses

```kotlin
val response = rapidClient.execute(searchOperation)

// Response metadata
println("Status: ${response.statusCode}")
println("Transaction ID: ${response.transactionId}")
response.headers.forEach { (key, values) ->
    println("Header $key: ${values.joinToString(", ")}")
}

// Process the actual data
response.data.forEach { property ->
    // Property details
    println("Property: ${property.propertyId}")
    println("Name: ${property.name}")
    
    // Availability and pricing
    property.roomTypes?.forEach { roomType ->
        println("  Room Type: ${roomType.name}")
        
        roomType.ratePlans?.forEach { ratePlan ->
            println("    Rate Plan: ${ratePlan.id}")
            println("    Price: ${ratePlan.price?.total?.inclusive} ${ratePlan.price?.total?.currency}")
            
            // Cancellation policy
            ratePlan.cancellationPolicy?.let { policy ->
                println("    Cancellation: ${policy.type}")
            }
        }
    }
    
    // Property amenities
    property.amenities?.forEach { amenity ->
        println("  Amenity: ${amenity.name}")
    }
}
```

## 🔄 Configuration Management

### Environment-Based Configuration

```kotlin
class RapidClientFactory {
    companion object {
        fun createClient(environment: Environment): RapidClient {
            return when (environment) {
                Environment.TEST -> RapidClient.builder()
                    .key(System.getenv("RAPID_TEST_KEY"))
                    .secret(System.getenv("RAPID_TEST_SECRET"))
                    .endpoint("https://test.ean.com/v3")
                    .requestTimeout(30000)
                    .build()
                    
                Environment.PRODUCTION -> RapidClient.builder()
                    .key(System.getenv("RAPID_PROD_KEY"))
                    .secret(System.getenv("RAPID_PROD_SECRET"))
                    .endpoint("https://api.ean.com/v3")
                    .requestTimeout(10000)
                    .build()
            }
        }
    }
    
    enum class Environment {
        TEST, PRODUCTION
    }
}
```

### Spring Boot Integration

```kotlin
@Configuration
class SdkConfiguration {
    
    @Bean
    @Primary
    fun rapidClient(
        @Value("\${rapid.api.key}") apiKey: String,
        @Value("\${rapid.api.secret}") apiSecret: String,
        @Value("\${rapid.api.endpoint}") endpoint: String
    ): RapidClient {
        return RapidClient.builder()
            .key(apiKey)
            .secret(apiSecret)
            .endpoint(endpoint)
            .requestTimeout(30000)
            .connectionTimeout(10000)
            .socketTimeout(60000)
            .build()
    }
}

@Service
class HotelService(private val rapidClient: RapidClient) {
    
    fun searchHotels(searchCriteria: SearchCriteria): List<Property> {
        val params = GetAvailabilityOperationParams.builder()
            .checkin(searchCriteria.checkin)
            .checkout(searchCriteria.checkout)
            .occupancy(searchCriteria.occupancy)
            .customerIp(searchCriteria.customerIp)
            .build()
            
        val operation = GetAvailabilityOperation(params)
        return rapidClient.execute(operation).data
    }
}
```

This usage guide provides practical examples and patterns for using the generated SDKs effectively in real applications.
