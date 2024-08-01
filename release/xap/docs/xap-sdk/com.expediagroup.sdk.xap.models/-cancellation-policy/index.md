//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[CancellationPolicy](index.md)

# CancellationPolicy

public final class [CancellationPolicy](index.md)

Container for room cancellation policy.

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

## Constructors

| | |
|---|---|
| [CancellationPolicy](-cancellation-policy.md) | [JVM]<br>public [CancellationPolicy](index.md)[CancellationPolicy](-cancellation-policy.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)cancellableOnline, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)refundable, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)freeCancellation, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)freeCancellationEndDateTime, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancellationPenaltyRule](../-cancellation-penalty-rule/index.md)&gt;cancellationPenaltyRules, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cancelPolicyDescription, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonRefundableDateRange](../-non-refundable-date-range/index.md)&gt;nonRefundableDateRanges) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [cancellableOnline](index.md#-758485404%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[cancellableOnline](index.md#-758485404%2FProperties%2F699445674) |
| [cancellationPenaltyRules](index.md#-427402554%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancellationPenaltyRule](../-cancellation-penalty-rule/index.md)&gt;[cancellationPenaltyRules](index.md#-427402554%2FProperties%2F699445674) |
| [cancelPolicyDescription](index.md#1821652467%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cancelPolicyDescription](index.md#1821652467%2FProperties%2F699445674) |
| [freeCancellation](index.md#626260872%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[freeCancellation](index.md#626260872%2FProperties%2F699445674) |
| [freeCancellationEndDateTime](index.md#-202914212%2FProperties%2F699445674) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[freeCancellationEndDateTime](index.md#-202914212%2FProperties%2F699445674) |
| [nonRefundableDateRanges](index.md#-1168693152%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonRefundableDateRange](../-non-refundable-date-range/index.md)&gt;[nonRefundableDateRanges](index.md#-1168693152%2FProperties%2F699445674) |
| [refundable](index.md#1577007397%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[refundable](index.md#1577007397%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CancellationPolicy.Builder](-builder/index.md)[builder](builder.md)() |
| [getCancellableOnline](get-cancellable-online.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getCancellableOnline](get-cancellable-online.md)() |
| [getCancellationPenaltyRules](get-cancellation-penalty-rules.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancellationPenaltyRule](../-cancellation-penalty-rule/index.md)&gt;[getCancellationPenaltyRules](get-cancellation-penalty-rules.md)() |
| [getCancelPolicyDescription](get-cancel-policy-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCancelPolicyDescription](get-cancel-policy-description.md)() |
| [getFreeCancellation](get-free-cancellation.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getFreeCancellation](get-free-cancellation.md)() |
| [getFreeCancellationEndDateTime](get-free-cancellation-end-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getFreeCancellationEndDateTime](get-free-cancellation-end-date-time.md)() |
| [getNonRefundableDateRanges](get-non-refundable-date-ranges.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonRefundableDateRange](../-non-refundable-date-range/index.md)&gt;[getNonRefundableDateRanges](get-non-refundable-date-ranges.md)() |
| [getRefundable](get-refundable.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getRefundable](get-refundable.md)() |
