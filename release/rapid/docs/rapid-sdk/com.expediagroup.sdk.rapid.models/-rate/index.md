//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Rate](index.md)

# Rate

public final class [Rate](index.md)

A rate.

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
| occupancyPricing | A map of room information by occupancy. |
| promotions |
| cardOnFileLimit |
| refundableDamageDeposit |
| deposits | Array of deposits for the rate. |

## Constructors

| | |
|---|---|
| [Rate](-rate.md) | [JVM]<br>public [Rate](index.md)[Rate](-rate.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [Status](../-status/index.md)status, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)availableRooms, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)refundable, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)memberDealAvailable, [SaleScenario](../-sale-scenario/index.md)saleScenario, [MerchantOfRecord](../-merchant-of-record/index.md)merchantOfRecord, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;amenities, [RateLinks](../-rate-links/index.md)links, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [BedGroupAvailability](../-bed-group-availability/index.md)&gt;bedGroups, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../-cancel-penalty/index.md)&gt;cancelPenalties, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../-nonrefundable-date-range/index.md)&gt;nonrefundableDateRanges, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PricingInformation](../-pricing-information/index.md)&gt;occupancyPricing, [Promotions](../-promotions/index.md)promotions, [Amount](../-amount/index.md)cardOnFileLimit, [Amount](../-amount/index.md)refundableDamageDeposit, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Deposit](../-deposit/index.md)&gt;deposits) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [amenities](index.md#-564304852%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;[amenities](index.md#-564304852%2FProperties%2F700308213) |
| [availableRooms](index.md#-1090979064%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[availableRooms](index.md#-1090979064%2FProperties%2F700308213) |
| [bedGroups](index.md#1826826574%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [BedGroupAvailability](../-bed-group-availability/index.md)&gt;[bedGroups](index.md#1826826574%2FProperties%2F700308213) |
| [cancelPenalties](index.md#-1802743818%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../-cancel-penalty/index.md)&gt;[cancelPenalties](index.md#-1802743818%2FProperties%2F700308213) |
| [cardOnFileLimit](index.md#-1551723629%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[cardOnFileLimit](index.md#-1551723629%2FProperties%2F700308213) |
| [deposits](index.md#1240620386%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Deposit](../-deposit/index.md)&gt;[deposits](index.md#1240620386%2FProperties%2F700308213) |
| [id](index.md#2065509404%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#2065509404%2FProperties%2F700308213) |
| [links](index.md#1482245834%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [RateLinks](../-rate-links/index.md)[links](index.md#1482245834%2FProperties%2F700308213) |
| [memberDealAvailable](index.md#1660163072%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[memberDealAvailable](index.md#1660163072%2FProperties%2F700308213) |
| [merchantOfRecord](index.md#-1796850073%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [MerchantOfRecord](../-merchant-of-record/index.md)[merchantOfRecord](index.md#-1796850073%2FProperties%2F700308213) |
| [nonrefundableDateRanges](index.md#-739691680%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../-nonrefundable-date-range/index.md)&gt;[nonrefundableDateRanges](index.md#-739691680%2FProperties%2F700308213) |
| [occupancyPricing](index.md#-1422234946%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PricingInformation](../-pricing-information/index.md)&gt;[occupancyPricing](index.md#-1422234946%2FProperties%2F700308213) |
| [promotions](index.md#-1404888921%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Promotions](../-promotions/index.md)[promotions](index.md#-1404888921%2FProperties%2F700308213) |
| [refundable](index.md#49238597%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[refundable](index.md#49238597%2FProperties%2F700308213) |
| [refundableDamageDeposit](index.md#1693337862%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[refundableDamageDeposit](index.md#1693337862%2FProperties%2F700308213) |
| [saleScenario](index.md#1190432576%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [SaleScenario](../-sale-scenario/index.md)[saleScenario](index.md#1190432576%2FProperties%2F700308213) |
| [status](index.md#2061524005%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Status](../-status/index.md)[status](index.md#2061524005%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Rate.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmenities](get-amenities.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;[getAmenities](get-amenities.md)() |
| [getAvailableRooms](get-available-rooms.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getAvailableRooms](get-available-rooms.md)() |
| [getBedGroups](get-bed-groups.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [BedGroupAvailability](../-bed-group-availability/index.md)&gt;[getBedGroups](get-bed-groups.md)() |
| [getCancelPenalties](get-cancel-penalties.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../-cancel-penalty/index.md)&gt;[getCancelPenalties](get-cancel-penalties.md)() |
| [getCardOnFileLimit](get-card-on-file-limit.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getCardOnFileLimit](get-card-on-file-limit.md)() |
| [getDeposits](get-deposits.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Deposit](../-deposit/index.md)&gt;[getDeposits](get-deposits.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getLinks](get-links.md) | [JVM]<br>public final [RateLinks](../-rate-links/index.md)[getLinks](get-links.md)() |
| [getMemberDealAvailable](get-member-deal-available.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getMemberDealAvailable](get-member-deal-available.md)() |
| [getMerchantOfRecord](get-merchant-of-record.md) | [JVM]<br>public final [MerchantOfRecord](../-merchant-of-record/index.md)[getMerchantOfRecord](get-merchant-of-record.md)() |
| [getNonrefundableDateRanges](get-nonrefundable-date-ranges.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../-nonrefundable-date-range/index.md)&gt;[getNonrefundableDateRanges](get-nonrefundable-date-ranges.md)() |
| [getOccupancyPricing](get-occupancy-pricing.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PricingInformation](../-pricing-information/index.md)&gt;[getOccupancyPricing](get-occupancy-pricing.md)() |
| [getPromotions](get-promotions.md) | [JVM]<br>public final [Promotions](../-promotions/index.md)[getPromotions](get-promotions.md)() |
| [getRefundable](get-refundable.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getRefundable](get-refundable.md)() |
| [getRefundableDamageDeposit](get-refundable-damage-deposit.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getRefundableDamageDeposit](get-refundable-damage-deposit.md)() |
| [getSaleScenario](get-sale-scenario.md) | [JVM]<br>public final [SaleScenario](../-sale-scenario/index.md)[getSaleScenario](get-sale-scenario.md)() |
| [getStatus](get-status.md) | [JVM]<br>public final [Status](../-status/index.md)[getStatus](get-status.md)() |
