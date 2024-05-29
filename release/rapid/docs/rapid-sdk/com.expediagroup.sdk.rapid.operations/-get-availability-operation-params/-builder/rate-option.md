//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[GetAvailabilityOperationParams](../index.md)/[Builder](index.md)/[rateOption](rate-option.md)

# rateOption

[JVM]\

public final [GetAvailabilityOperationParams.Builder](index.md)[rateOption](rate-option.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;rateOption)

#### Parameters

JVM

| | |
|---|---|
| rateOption | Request specific rate options for each property. Send multiple instances of this parameter to request multiple rate options. Accepted values:<br> * `member` - Return member rates for each property. This feature must be enabled and requires a user to be logged in to request these rates. * `net_rates` - Return net rates for each property. This feature must be enabled to request these rates. * `cross_sell` - Identify if the traffic is coming from a cross sell booking. Where the traveler has booked another service (flight, car, activities...) before hotel. |
