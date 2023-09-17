//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[SettledRefundUpdate](index.md)

# SettledRefundUpdate

public final class [SettledRefundUpdate](index.md) implements [RefundUpdate](../-refund-update/index.md)

Data related to the settled refund that should be updated.

#### Parameters

JVM

| |
|---|
| refundDetails |

## Constructors

| | |
|---|---|
| [SettledRefundUpdate](-settled-refund-update.md) | [JVM]<br>public [SettledRefundUpdate](index.md)[SettledRefundUpdate](-settled-refund-update.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)riskId, [SettledRefundUpdateDetails](../-settled-refund-update-details/index.md)refundDetails) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [SettledRefundUpdate.Builder](-builder/index.md)[builder](builder.md)() |
| [getRefundDetails](get-refund-details.md) | [JVM]<br>public final [SettledRefundUpdateDetails](../-settled-refund-update-details/index.md)[getRefundDetails](get-refund-details.md)() |
| [getRefundStatus](get-refund-status.md) | [JVM]<br>public [RefundUpdate.RefundStatus](../-refund-update/-refund-status/index.md)[getRefundStatus](get-refund-status.md)() |
| [getRiskId](get-risk-id.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRiskId](get-risk-id.md)() |
| [getType](get-type.md) | [JVM]<br>public [UpdateType](../-update-type/index.md)[getType](get-type.md)() |

## Properties

| Name | Summary |
|---|---|
| [refundDetails](index.md#-1383018433%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [SettledRefundUpdateDetails](../-settled-refund-update-details/index.md)[refundDetails](index.md#-1383018433%2FProperties%2F-1883119931) |
| [refundStatus](index.md#1162393351%2FProperties%2F-1883119931) | [JVM]<br>private final [RefundUpdate.RefundStatus](../-refund-update/-refund-status/index.md)[refundStatus](index.md#1162393351%2FProperties%2F-1883119931) |
| [riskId](index.md#616969031%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[riskId](index.md#616969031%2FProperties%2F-1883119931) |
| [type](index.md#-2019826857%2FProperties%2F-1883119931) | [JVM]<br>private final [UpdateType](../-update-type/index.md)[type](index.md#-2019826857%2FProperties%2F-1883119931) |
