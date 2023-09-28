//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[OrderPurchaseScreenResponse](index.md)

# OrderPurchaseScreenResponse

public final class [OrderPurchaseScreenResponse](index.md)

#### Parameters

JVM

| | |
|---|---|
| riskId | Unique identifier assigned to the transaction by Expedia's Fraud Prevention Service. |
| decision |

## Constructors

| | |
|---|---|
| [OrderPurchaseScreenResponse](-order-purchase-screen-response.md) | [JVM]<br>public [OrderPurchaseScreenResponse](index.md)[OrderPurchaseScreenResponse](-order-purchase-screen-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)riskId, [FraudDecision](../-fraud-decision/index.md)decision) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [decision](index.md#167700081%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [FraudDecision](../-fraud-decision/index.md)[decision](index.md#167700081%2FProperties%2F-173342751) |
| [riskId](index.md#1283315139%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[riskId](index.md#1283315139%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [OrderPurchaseScreenResponse.Builder](-builder/index.md)[builder](builder.md)() |
| [getDecision](get-decision.md) | [JVM]<br>public final [FraudDecision](../-fraud-decision/index.md)[getDecision](get-decision.md)() |
| [getRiskId](get-risk-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRiskId](get-risk-id.md)() |
