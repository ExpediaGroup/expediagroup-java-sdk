//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RateItinerary](index.md)/[RateItinerary](-rate-itinerary.md)

# RateItinerary

[JVM]\

public [RateItinerary](index.md)[RateItinerary](-rate-itinerary.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [MerchantOfRecord](../-merchant-of-record/index.md)merchantOfRecord, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)refundable, [CancelRefund](../-cancel-refund/index.md)cancelRefund, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;amenities, [PromotionsItinerary](../-promotions-itinerary/index.md)promotions, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../-cancel-penalty/index.md)&gt;cancelPenalties, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../-nonrefundable-date-range/index.md)&gt;nonrefundableDateRanges, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[DepositItinerary](../-deposit-itinerary/index.md)&gt;deposits, [Amount](../-amount/index.md)cardOnFileLimit, [Amount](../-amount/index.md)refundableDamageDeposit, [PricingInformation](../-pricing-information/index.md)pricing)

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
