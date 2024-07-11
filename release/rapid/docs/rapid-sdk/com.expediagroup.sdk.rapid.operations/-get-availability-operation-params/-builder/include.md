//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[GetAvailabilityOperationParams](../index.md)/[Builder](index.md)/[include](include.md)

# include

[JVM]\

public final [GetAvailabilityOperationParams.Builder](index.md)[include](include.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;include)

#### Parameters

JVM

| | |
|---|---|
| include | Modify the response by including types of responses that are not provided by default.<br> * `unavailable_reason` - When a property is unavailable for an actionable reason, return a response with that reason - See [Unavailable Reason Codes](https://developers.expediagroup.com/docs/rapid/resources/reference/unavailable-reason-codes) for possible values. * `sale_scenario.mobile_promotion` - Enable the `mobile_promotion` flag under the `room.rate.sale_scenario` section of the response. * `rooms.rates.marketing_fee_incentives` - When a rate has a marketing fee incentive applied, the response will include the `marketing_fee_incentives` array if this flag is provided in the request. |
