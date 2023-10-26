//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[AccountScreenResponse](index.md)

# AccountScreenResponse

public final class [AccountScreenResponse](index.md)

Response for an account transaction provided by Expedia's Fraud Prevention Service.

#### Parameters

JVM

| | |
|---|---|
| riskId | Unique identifier assigned to the transaction by Expedia's Fraud Prevention Service. |
| decision |

## Constructors

| | |
|---|---|
| [AccountScreenResponse](-account-screen-response.md) | [JVM]<br>public [AccountScreenResponse](index.md)[AccountScreenResponse](-account-screen-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)riskId, [AccountTakeoverFraudDecision](../-account-takeover-fraud-decision/index.md)decision) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [decision](index.md#1900243055%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [AccountTakeoverFraudDecision](../-account-takeover-fraud-decision/index.md)[decision](index.md#1900243055%2FProperties%2F-173342751) |
| [riskId](index.md#-967393471%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[riskId](index.md#-967393471%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [AccountScreenResponse.Builder](-builder/index.md)[builder](builder.md)() |
| [getDecision](get-decision.md) | [JVM]<br>public final [AccountTakeoverFraudDecision](../-account-takeover-fraud-decision/index.md)[getDecision](get-decision.md)() |
| [getRiskId](get-risk-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRiskId](get-risk-id.md)() |
