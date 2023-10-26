//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[IssuedRefundUpdate](index.md)

# IssuedRefundUpdate

public final class [IssuedRefundUpdate](index.md) implements [RefundUpdate](../-refund-update/index.md)

Data related to the issued refund that should be updated.

#### Parameters

JVM

| |
|---|
| refundDetails |

## Constructors

| | |
|---|---|
| [IssuedRefundUpdate](-issued-refund-update.md) | [JVM]<br>public [IssuedRefundUpdate](index.md)[IssuedRefundUpdate](-issued-refund-update.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)riskId, [IssuedRefundUpdateDetails](../-issued-refund-update-details/index.md)refundDetails) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [refundDetails](index.md#719735513%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [IssuedRefundUpdateDetails](../-issued-refund-update-details/index.md)[refundDetails](index.md#719735513%2FProperties%2F-173342751) |
| [refundStatus](index.md#-1402175187%2FProperties%2F-173342751) | [JVM]<br>private final [RefundUpdate.RefundStatus](../-refund-update/-refund-status/index.md)[refundStatus](index.md#-1402175187%2FProperties%2F-173342751) |
| [riskId](index.md#2088636909%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[riskId](index.md#2088636909%2FProperties%2F-173342751) |
| [type](index.md#82260861%2FProperties%2F-173342751) | [JVM]<br>private final [UpdateType](../-update-type/index.md)[type](index.md#82260861%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [IssuedRefundUpdate.Builder](-builder/index.md)[builder](builder.md)() |
| [getRefundDetails](get-refund-details.md) | [JVM]<br>public final [IssuedRefundUpdateDetails](../-issued-refund-update-details/index.md)[getRefundDetails](get-refund-details.md)() |
| [getRefundStatus](get-refund-status.md) | [JVM]<br>public [RefundUpdate.RefundStatus](../-refund-update/-refund-status/index.md)[getRefundStatus](get-refund-status.md)() |
| [getRiskId](get-risk-id.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRiskId](get-risk-id.md)() |
| [getType](get-type.md) | [JVM]<br>public [UpdateType](../-update-type/index.md)[getType](get-type.md)() |
