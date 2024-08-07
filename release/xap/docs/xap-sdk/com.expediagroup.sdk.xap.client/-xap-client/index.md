//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.client](../index.md)/[XapClient](index.md)

# XapClient

[JVM]\
public final class [XapClient](index.md) extends BaseXapClient

The XAP Lodging Search APIs can be used by partners both booking via an Expedia website, or by partners that will be booking via the XAP APIs. Each API also provides pre-configured links to the Expedia website, the XAP Booking API, or both.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) extends BaseXapClient.Builder&lt;[XapClient.Builder](-builder/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [XapClient.Builder](-builder/index.md)[builder](builder.md)() |
| [execute](execute.md) | [JVM]<br>public final Response&lt;[HotelDetailsResponse](../../com.expediagroup.sdk.xap.models/-hotel-details-response/index.md)&gt;[execute](execute.md)([GetLodgingDetailsOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-details-operation/index.md)operation)<br>Get Extended information with a single property offer Extended information about the rate, charges, fees, and financial terms associated with booking a single lodging rate plan offer.<br>[JVM]<br>public final Response&lt;[HotelListingsResponse](../../com.expediagroup.sdk.xap.models/-hotel-listings-response/index.md)&gt;[execute](execute.md)([GetLodgingListingsOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-listings-operation/index.md)operation)<br>Search lodging inventory Search Expedia lodging inventory by Location Keyword, Region ID, Lat/Long, or Hotel ID(s) and return up to 1,000 offers in response.  Provides deeplink to Expedia site to book, or rate plan info to enable API booking.<br>[JVM]<br>public final Response&lt;[RateCalendarResponse](../../com.expediagroup.sdk.xap.models/-rate-calendar-response/index.md)&gt;[execute](execute.md)([GetLodgingRateCalendarOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-rate-calendar-operation/index.md)operation)<br>Get rate calendar of a property The Rate Calendar API will return the lowest rate plan for a range of days for one selected Expedia lodging property. |
| [executeAsync](execute-async.md) | [JVM]<br>public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[HotelDetailsResponse](../../com.expediagroup.sdk.xap.models/-hotel-details-response/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetLodgingDetailsOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-details-operation/index.md)operation)<br>Get Extended information with a single property offer Extended information about the rate, charges, fees, and financial terms associated with booking a single lodging rate plan offer.<br>[JVM]<br>public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[HotelListingsResponse](../../com.expediagroup.sdk.xap.models/-hotel-listings-response/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetLodgingListingsOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-listings-operation/index.md)operation)<br>Search lodging inventory Search Expedia lodging inventory by Location Keyword, Region ID, Lat/Long, or Hotel ID(s) and return up to 1,000 offers in response.  Provides deeplink to Expedia site to book, or rate plan info to enable API booking.<br>[JVM]<br>public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[RateCalendarResponse](../../com.expediagroup.sdk.xap.models/-rate-calendar-response/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetLodgingRateCalendarOperation](../../com.expediagroup.sdk.xap.operations/-get-lodging-rate-calendar-operation/index.md)operation)<br>Get rate calendar of a property The Rate Calendar API will return the lowest rate plan for a range of days for one selected Expedia lodging property. |
| [throwServiceException](throw-service-exception.md) | [JVM]<br>public [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[throwServiceException](throw-service-exception.md)(HttpResponseresponse, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)operationId) |
