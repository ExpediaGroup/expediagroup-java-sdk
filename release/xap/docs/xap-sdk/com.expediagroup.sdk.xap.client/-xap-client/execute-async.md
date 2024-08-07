//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.client](../index.md)/[XapClient](index.md)/[executeAsync](execute-async.md)

# executeAsync

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[HotelDetailsResponse](../../com.expediagroup.sdk.xap.models/-hotel-details-response/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetLodgingDetailsOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-details-operation/index.md)operation)

Get Extended information with a single property offer Extended information about the rate, charges, fees, and financial terms associated with booking a single lodging rate plan offer.

#### Return

a CompletableFuture<Response> object with a body of type HotelDetailsResponse

#### Parameters

JVM

| | |
|---|---|
| operation | [GetLodgingDetailsOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-details-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorsException](../../com.expediagroup.sdk.xap.models.exception/-expedia-group-api-errors-exception/index.md) |
| [ExpediaGroupApiAPIGatewayErrorException](../../com.expediagroup.sdk.xap.models.exception/-expedia-group-api-a-p-i-gateway-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[HotelListingsResponse](../../com.expediagroup.sdk.xap.models/-hotel-listings-response/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetLodgingListingsOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-listings-operation/index.md)operation)

Search lodging inventory Search Expedia lodging inventory by Location Keyword, Region ID, Lat/Long, or Hotel ID(s) and return up to 1,000 offers in response.  Provides deeplink to Expedia site to book, or rate plan info to enable API booking.

#### Return

a CompletableFuture<Response> object with a body of type HotelListingsResponse

#### Parameters

JVM

| | |
|---|---|
| operation | [GetLodgingListingsOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-listings-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorsException](../../com.expediagroup.sdk.xap.models.exception/-expedia-group-api-errors-exception/index.md) |
| [ExpediaGroupApiAPIGatewayErrorException](../../com.expediagroup.sdk.xap.models.exception/-expedia-group-api-a-p-i-gateway-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[RateCalendarResponse](../../com.expediagroup.sdk.xap.models/-rate-calendar-response/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetLodgingRateCalendarOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-rate-calendar-operation/index.md)operation)

Get rate calendar of a property The Rate Calendar API will return the lowest rate plan for a range of days for one selected Expedia lodging property.

#### Return

a CompletableFuture<Response> object with a body of type RateCalendarResponse

#### Parameters

JVM

| | |
|---|---|
| operation | [GetLodgingRateCalendarOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-rate-calendar-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorsException](../../com.expediagroup.sdk.xap.models.exception/-expedia-group-api-errors-exception/index.md) |
| [ExpediaGroupApiAPIGatewayErrorException](../../com.expediagroup.sdk.xap.models.exception/-expedia-group-api-a-p-i-gateway-error-exception/index.md) |
