//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[GetAvailabilityOperationParams](../index.md)/[Builder](index.md)/[filter](filter.md)

# filter

[JVM]\

public final [GetAvailabilityOperationParams.Builder](index.md)[filter](filter.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;filter)

#### Parameters

JVM

| | |
|---|---|
| filter | Single filter type. Send multiple instances of this parameter to request multiple filters.<br> * `refundable` - Filters results to only show fully refundable rates. * `expedia_collect` - Filters results to only show rates where payment is collected by Expedia at the time of booking. These properties can be eligible for payments via Expedia Affiliate Collect(EAC). * `property_collect` - Filters results to only show rates where payment is collected by the property after booking. This can include rates that require a deposit by the property, dependent upon the deposit policies. * `loyalty` - Filters results to only show rates that are eligible for loyalty points. |
