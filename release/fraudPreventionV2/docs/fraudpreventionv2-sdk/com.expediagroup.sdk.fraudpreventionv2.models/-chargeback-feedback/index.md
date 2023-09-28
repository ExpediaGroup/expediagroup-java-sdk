//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[ChargebackFeedback](index.md)

# ChargebackFeedback

public final class [ChargebackFeedback](index.md) implements [OrderPurchaseUpdateRequest](../-order-purchase-update-request/index.md)

Feedback from EG external partners if they receive a chargeback for a false negative recommendation from Fraud Prevention system.

#### Parameters

JVM

| |
|---|
| chargebackDetail |

## Constructors

| | |
|---|---|
| [ChargebackFeedback](-chargeback-feedback.md) | [JVM]<br>public [ChargebackFeedback](index.md)[ChargebackFeedback](-chargeback-feedback.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)riskId, [ChargebackDetail](../-chargeback-detail/index.md)chargebackDetail) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [chargebackDetail](index.md#-2074860865%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [ChargebackDetail](../-chargeback-detail/index.md)[chargebackDetail](index.md#-2074860865%2FProperties%2F-173342751) |
| [riskId](index.md#-891335807%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[riskId](index.md#-891335807%2FProperties%2F-173342751) |
| [type](index.md#-609107439%2FProperties%2F-173342751) | [JVM]<br>private final [UpdateType](../-update-type/index.md)[type](index.md#-609107439%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [ChargebackFeedback.Builder](-builder/index.md)[builder](builder.md)() |
| [getChargebackDetail](get-chargeback-detail.md) | [JVM]<br>public final [ChargebackDetail](../-chargeback-detail/index.md)[getChargebackDetail](get-chargeback-detail.md)() |
| [getRiskId](get-risk-id.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRiskId](get-risk-id.md)() |
| [getType](get-type.md) | [JVM]<br>public [UpdateType](../-update-type/index.md)[getType](get-type.md)() |
