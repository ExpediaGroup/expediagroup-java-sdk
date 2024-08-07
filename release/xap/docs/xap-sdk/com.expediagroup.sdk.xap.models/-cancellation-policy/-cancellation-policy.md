//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[CancellationPolicy](index.md)/[CancellationPolicy](-cancellation-policy.md)

# CancellationPolicy

[JVM]\

public [CancellationPolicy](index.md)[CancellationPolicy](-cancellation-policy.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)cancellableOnline, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)refundable, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)freeCancellation, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)freeCancellationEndDateTime, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancellationPenaltyRule](../-cancellation-penalty-rule/index.md)&gt;cancellationPenaltyRules, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cancelPolicyDescription, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonRefundableDateRange](../-non-refundable-date-range/index.md)&gt;nonRefundableDateRanges)

#### Parameters

JVM

| | |
|---|---|
| cancellableOnline | Boolean value to identify if the reservation can be cancelled online. If false, the customer will only be able to cancel a refundable room by calling Expedia Customer Service. |
| refundable | Indicate whether the rate is refundable or not. |
| freeCancellation | Indicate whether the room can be cancelled free of charge. |
| freeCancellationEndDateTime | The date and time until which the room can be cancelled free of charge.  This is expressed in the local time of the Hotel. |
| cancellationPenaltyRules | Container for cancellation penalty details. |
| cancelPolicyDescription | Additional cancellation policy information available as static text. |
| nonRefundableDateRanges | A list of dates ranges that are non-refundable.  **Note**: The stay dates in those date ranges will always be charged whenever there is any cancellation penalty rule. |
