//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RateHistory](index.md)

# RateHistory

public final class [RateHistory](index.md)

The rate information associated with the itinerary.

#### Parameters

JVM

| | |
|---|---|
| id | The id of the rate. |
| promotions |
| cancelPenalties | The cancel penalties associated with the itinerary. |
| deposits |
| pricing |

## Constructors

| | |
|---|---|
| [RateHistory](-rate-history.md) | [JVM]<br>public [RateHistory](index.md)[RateHistory](-rate-history.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [PromotionsItinerary](../-promotions-itinerary/index.md)promotions, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../-cancel-penalty/index.md)&gt;cancelPenalties, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[DepositItinerary](../-deposit-itinerary/index.md)&gt;deposits, [PricingInformation](../-pricing-information/index.md)pricing) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [cancelPenalties](index.md#-2073408972%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../-cancel-penalty/index.md)&gt;[cancelPenalties](index.md#-2073408972%2FProperties%2F700308213) |
| [deposits](index.md#376589540%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[DepositItinerary](../-deposit-itinerary/index.md)&gt;[deposits](index.md#376589540%2FProperties%2F700308213) |
| [id](index.md#-467704546%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#-467704546%2FProperties%2F700308213) |
| [pricing](index.md#1955378715%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [PricingInformation](../-pricing-information/index.md)[pricing](index.md#1955378715%2FProperties%2F700308213) |
| [promotions](index.md#1485123497%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [PromotionsItinerary](../-promotions-itinerary/index.md)[promotions](index.md#1485123497%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RateHistory.Builder](-builder/index.md)[builder](builder.md)() |
| [getCancelPenalties](get-cancel-penalties.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../-cancel-penalty/index.md)&gt;[getCancelPenalties](get-cancel-penalties.md)() |
| [getDeposits](get-deposits.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[DepositItinerary](../-deposit-itinerary/index.md)&gt;[getDeposits](get-deposits.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getPricing](get-pricing.md) | [JVM]<br>public final [PricingInformation](../-pricing-information/index.md)[getPricing](get-pricing.md)() |
| [getPromotions](get-promotions.md) | [JVM]<br>public final [PromotionsItinerary](../-promotions-itinerary/index.md)[getPromotions](get-promotions.md)() |
