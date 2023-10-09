//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[InsultFeedback](index.md)

# InsultFeedback

public final class [InsultFeedback](index.md) implements [OrderPurchaseUpdateRequest](../-order-purchase-update-request/index.md)

Feedback from EG external partners regarding a false positive recommendation that from Fraud Prevention system gave for their customer.

#### Parameters

JVM

| |
|---|
| insultDetail |

## Constructors

| | |
|---|---|
| [InsultFeedback](-insult-feedback.md) | [JVM]<br>public [InsultFeedback](index.md)[InsultFeedback](-insult-feedback.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)riskId, [InsultDetail](../-insult-detail/index.md)insultDetail) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [insultDetail](index.md#-1182386497%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [InsultDetail](../-insult-detail/index.md)[insultDetail](index.md#-1182386497%2FProperties%2F-173342751) |
| [riskId](index.md#-771101067%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[riskId](index.md#-771101067%2FProperties%2F-173342751) |
| [type](index.md#1330680325%2FProperties%2F-173342751) | [JVM]<br>private final [UpdateType](../-update-type/index.md)[type](index.md#1330680325%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [InsultFeedback.Builder](-builder/index.md)[builder](builder.md)() |
| [getInsultDetail](get-insult-detail.md) | [JVM]<br>public final [InsultDetail](../-insult-detail/index.md)[getInsultDetail](get-insult-detail.md)() |
| [getRiskId](get-risk-id.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRiskId](get-risk-id.md)() |
| [getType](get-type.md) | [JVM]<br>public [UpdateType](../-update-type/index.md)[getType](get-type.md)() |
