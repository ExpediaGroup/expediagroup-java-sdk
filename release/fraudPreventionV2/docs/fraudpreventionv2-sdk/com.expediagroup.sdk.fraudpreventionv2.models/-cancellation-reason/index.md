//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[CancellationReason](index.md)

# CancellationReason

public final class [CancellationReason](index.md)

Reason of order update cancellation.

#### Parameters

JVM

| | |
|---|---|
| primaryReasonCode | Primary cancellation reason code. |
| subReasonCode | Substitute cancellation reason code. |
| primaryReasonDescription | Primary cancellation reason code. Required if `order_status = CANCELLED`. |
| subReasonDescription | Substitute cancellation reason description. |

## Constructors

| | |
|---|---|
| [CancellationReason](-cancellation-reason.md) | [JVM]<br>public [CancellationReason](index.md)[CancellationReason](-cancellation-reason.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)primaryReasonCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)subReasonCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)primaryReasonDescription, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)subReasonDescription) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [primaryReasonCode](index.md#-194777515%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[primaryReasonCode](index.md#-194777515%2FProperties%2F-173342751) |
| [primaryReasonDescription](index.md#-1889225796%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[primaryReasonDescription](index.md#-1889225796%2FProperties%2F-173342751) |
| [subReasonCode](index.md#-733990185%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[subReasonCode](index.md#-733990185%2FProperties%2F-173342751) |
| [subReasonDescription](index.md#-263407366%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[subReasonDescription](index.md#-263407366%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CancellationReason.Builder](-builder/index.md)[builder](builder.md)() |
| [getPrimaryReasonCode](get-primary-reason-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPrimaryReasonCode](get-primary-reason-code.md)() |
| [getPrimaryReasonDescription](get-primary-reason-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPrimaryReasonDescription](get-primary-reason-description.md)() |
| [getSubReasonCode](get-sub-reason-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSubReasonCode](get-sub-reason-code.md)() |
| [getSubReasonDescription](get-sub-reason-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSubReasonDescription](get-sub-reason-description.md)() |
