//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RateItinerary](index.md)

# RateItinerary

public final class [RateItinerary](index.md)

The rate information associated with the itinerary.

#### Parameters

JVM

| | |
|---|---|
| id | The id of the rate. |
| merchantOfRecord |
| refundable | Indicates whether the itinerary is refundable or not. |
| cancelRefund |
| amenities |
| promotions |
| cancelPenalties | The cancel penalties associated with the itinerary. |
| nonrefundableDateRanges | A list of date exceptions. Dates within these ranges provide no refund on cancellation, regardless of cancel penalty windows. Nonrefundable range begins at 00:00:00 on the start date, and ends at 23:59:59 on the end date, in the local time zone of the property. |
| deposits |
| cardOnFileLimit |
| refundableDamageDeposit |
| pricing |

## Constructors

| | |
|---|---|
| [RateItinerary](-rate-itinerary.md) | [JVM]<br>public [RateItinerary](index.md)[RateItinerary](-rate-itinerary.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [MerchantOfRecord](../-merchant-of-record/index.md)merchantOfRecord, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)refundable, [CancelRefund](../-cancel-refund/index.md)cancelRefund, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;amenities, [PromotionsItinerary](../-promotions-itinerary/index.md)promotions, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../-cancel-penalty/index.md)&gt;cancelPenalties, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../-nonrefundable-date-range/index.md)&gt;nonrefundableDateRanges, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[DepositItinerary](../-deposit-itinerary/index.md)&gt;deposits, [Amount](../-amount/index.md)cardOnFileLimit, [Amount](../-amount/index.md)refundableDamageDeposit, [PricingInformation](../-pricing-information/index.md)pricing) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [amenities](index.md#-1225027885%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[amenities](index.md#-1225027885%2FProperties%2F700308213) |
| [cancelPenalties](index.md#1184080221%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../-cancel-penalty/index.md)&gt;[cancelPenalties](index.md#1184080221%2FProperties%2F700308213) |
| [cancelRefund](index.md#682929662%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [CancelRefund](../-cancel-refund/index.md)[cancelRefund](index.md#682929662%2FProperties%2F700308213) |
| [cardOnFileLimit](index.md#1435100410%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[cardOnFileLimit](index.md#1435100410%2FProperties%2F700308213) |
| [deposits](index.md#388022747%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[DepositItinerary](../-deposit-itinerary/index.md)&gt;[deposits](index.md#388022747%2FProperties%2F700308213) |
| [id](index.md#1378525013%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#1378525013%2FProperties%2F700308213) |
| [merchantOfRecord](index.md#600381920%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [MerchantOfRecord](../-merchant-of-record/index.md)[merchantOfRecord](index.md#600381920%2FProperties%2F700308213) |
| [nonrefundableDateRanges](index.md#-577229369%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../-nonrefundable-date-range/index.md)&gt;[nonrefundableDateRanges](index.md#-577229369%2FProperties%2F700308213) |
| [pricing](index.md#1817200196%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [PricingInformation](../-pricing-information/index.md)[pricing](index.md#1817200196%2FProperties%2F700308213) |
| [promotions](index.md#-412466464%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [PromotionsItinerary](../-promotions-itinerary/index.md)[promotions](index.md#-412466464%2FProperties%2F700308213) |
| [refundable](index.md#1041661054%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[refundable](index.md#1041661054%2FProperties%2F700308213) |
| [refundableDamageDeposit](index.md#1855800173%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[refundableDamageDeposit](index.md#1855800173%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RateItinerary.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmenities](get-amenities.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getAmenities](get-amenities.md)() |
| [getCancelPenalties](get-cancel-penalties.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../-cancel-penalty/index.md)&gt;[getCancelPenalties](get-cancel-penalties.md)() |
| [getCancelRefund](get-cancel-refund.md) | [JVM]<br>public final [CancelRefund](../-cancel-refund/index.md)[getCancelRefund](get-cancel-refund.md)() |
| [getCardOnFileLimit](get-card-on-file-limit.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getCardOnFileLimit](get-card-on-file-limit.md)() |
| [getDeposits](get-deposits.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[DepositItinerary](../-deposit-itinerary/index.md)&gt;[getDeposits](get-deposits.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getMerchantOfRecord](get-merchant-of-record.md) | [JVM]<br>public final [MerchantOfRecord](../-merchant-of-record/index.md)[getMerchantOfRecord](get-merchant-of-record.md)() |
| [getNonrefundableDateRanges](get-nonrefundable-date-ranges.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../-nonrefundable-date-range/index.md)&gt;[getNonrefundableDateRanges](get-nonrefundable-date-ranges.md)() |
| [getPricing](get-pricing.md) | [JVM]<br>public final [PricingInformation](../-pricing-information/index.md)[getPricing](get-pricing.md)() |
| [getPromotions](get-promotions.md) | [JVM]<br>public final [PromotionsItinerary](../-promotions-itinerary/index.md)[getPromotions](get-promotions.md)() |
| [getRefundable](get-refundable.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getRefundable](get-refundable.md)() |
| [getRefundableDamageDeposit](get-refundable-damage-deposit.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getRefundableDamageDeposit](get-refundable-damage-deposit.md)() |
