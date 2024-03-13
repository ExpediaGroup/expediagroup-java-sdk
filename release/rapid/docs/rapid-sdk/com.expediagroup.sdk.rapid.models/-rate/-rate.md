//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Rate](index.md)/[Rate](-rate.md)

# Rate

[JVM]\

public [Rate](index.md)[Rate](-rate.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [Status](../-status/index.md)status, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)availableRooms, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)refundable, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)memberDealAvailable, [SaleScenario](../-sale-scenario/index.md)saleScenario, [MerchantOfRecord](../-merchant-of-record/index.md)merchantOfRecord, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;amenities, [RateLinks](../-rate-links/index.md)links, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [BedGroupAvailability](../-bed-group-availability/index.md)&gt;bedGroups, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../-cancel-penalty/index.md)&gt;cancelPenalties, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../-nonrefundable-date-range/index.md)&gt;nonrefundableDateRanges, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[MarketingFeeIncentive](../-marketing-fee-incentive/index.md)&gt;marketingFeeIncentives, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PricingInformation](../-pricing-information/index.md)&gt;occupancyPricing, [Promotions](../-promotions/index.md)promotions, [Amount](../-amount/index.md)cardOnFileLimit, [Amount](../-amount/index.md)refundableDamageDeposit, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Deposit](../-deposit/index.md)&gt;deposits)

#### Parameters

JVM

| | |
|---|---|
| id | Unique Identifier for a rate. |
| status |
| availableRooms | The number of bookable rooms remaining with this rate in EPS inventory. Use this value to create rules for urgency messaging to alert users to low availability on busy travel dates or at popular properties. If the value returns as 2147483647 (max int value), the actual value could not be determined. Ensure your urgency messaging ignores such instances when returned. |
| refundable | Indicates if the rate is fully refundable at the time of booking. Cancel penalties may still apply. Please refer to the cancel penalties section for reference. |
| memberDealAvailable | Indicates if a \&quot;Member Only Deal\&quot; is available for this rate. |
| saleScenario |
| merchantOfRecord |
| amenities | Room amenities. |
| links |
| bedGroups | A map of the room's bed groups. |
| cancelPenalties | Array of `cancel_penalty` objects containing cancel penalty information. |
| nonrefundableDateRanges | An array of stay date ranges within this check-in / check-out range that are not refundable. Stay dates within these ranges provide no refund on cancellation, regardless of cancel penalty windows. The stay dates are determined by the would be check-in of that night. With a check-in date of 2023-09-01, and a check-out date of 2023-09-06, this would be a 5 night stay. A `nonrefundable_date_range` with start: 2023-09-02 and end: 2023-09-03 would mean 2 of the nights are nonrefundable. The 1st night is refundable, the 2nd and 3rd nights are nonrefundable, and the 4th and 5th nights are refundable, subject to `cancel_penalties` restrictions. |
| marketingFeeIncentives | An array of stay date ranges within this check-in / check-out range that have an incentive applied. The stay dates are determined by the would be check-in of that night. With a check-in date of 2023-09-01, and a check-out date of 2023-09-06, this would be a 5 night stay. A `marketing_fee_incentive` with start: 2023-09-02 and end: 2023-09-03 would mean 2 of the nights have an incentive applied. The 1st night is not part of the incentive, the 2nd and 3rd nights are part of the incentive, and the 4th and 5th nights are not part of the incentive. |
| occupancyPricing | A map of room information by occupancy. |
| promotions |
| cardOnFileLimit |
| refundableDamageDeposit |
| deposits | Array of deposits for the rate. |
