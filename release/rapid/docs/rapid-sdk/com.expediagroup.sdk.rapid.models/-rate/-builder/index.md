//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.models](../../index.md)/[Rate](../index.md)/[Builder](index.md)

# Builder

[JVM]\
public final class [Builder](index.md)

## Constructors

| | |
|---|---|
| [Rate.Builder](-rate.-builder.md) | [JVM]<br>public [Rate.Builder](index.md)[Rate.Builder](-rate.-builder.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [Status](../../-status/index.md)status, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)availableRooms, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)refundable, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)memberDealAvailable, [SaleScenario](../../-sale-scenario/index.md)saleScenario, [MerchantOfRecord](../../-merchant-of-record/index.md)merchantOfRecord, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../../-amenity/index.md)&gt;amenities, [RateLinks](../../-rate-links/index.md)links, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [BedGroupAvailability](../../-bed-group-availability/index.md)&gt;bedGroups, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../../-cancel-penalty/index.md)&gt;cancelPenalties, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../../-nonrefundable-date-range/index.md)&gt;nonrefundableDateRanges, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PricingInformation](../../-pricing-information/index.md)&gt;occupancyPricing, [Promotions](../../-promotions/index.md)promotions, [Amount](../../-amount/index.md)cardOnFileLimit, [Amount](../../-amount/index.md)refundableDamageDeposit, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Deposit](../../-deposit/index.md)&gt;deposits) |

## Functions

| Name | Summary |
|---|---|
| [amenities](amenities.md) | [JVM]<br>public final [Rate.Builder](index.md)[amenities](amenities.md)([Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../../-amenity/index.md)&gt;amenities) |
| [availableRooms](available-rooms.md) | [JVM]<br>public final [Rate.Builder](index.md)[availableRooms](available-rooms.md)([BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)availableRooms) |
| [bedGroups](bed-groups.md) | [JVM]<br>public final [Rate.Builder](index.md)[bedGroups](bed-groups.md)([Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [BedGroupAvailability](../../-bed-group-availability/index.md)&gt;bedGroups) |
| [build](build.md) | [JVM]<br>public final [Rate](../index.md)[build](build.md)() |
| [cancelPenalties](cancel-penalties.md) | [JVM]<br>public final [Rate.Builder](index.md)[cancelPenalties](cancel-penalties.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CancelPenalty](../../-cancel-penalty/index.md)&gt;cancelPenalties) |
| [cardOnFileLimit](card-on-file-limit.md) | [JVM]<br>public final [Rate.Builder](index.md)[cardOnFileLimit](card-on-file-limit.md)([Amount](../../-amount/index.md)cardOnFileLimit) |
| [deposits](deposits.md) | [JVM]<br>public final [Rate.Builder](index.md)[deposits](deposits.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Deposit](../../-deposit/index.md)&gt;deposits) |
| [id](id.md) | [JVM]<br>public final [Rate.Builder](index.md)[id](id.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id) |
| [links](links.md) | [JVM]<br>public final [Rate.Builder](index.md)[links](links.md)([RateLinks](../../-rate-links/index.md)links) |
| [memberDealAvailable](member-deal-available.md) | [JVM]<br>public final [Rate.Builder](index.md)[memberDealAvailable](member-deal-available.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)memberDealAvailable) |
| [merchantOfRecord](merchant-of-record.md) | [JVM]<br>public final [Rate.Builder](index.md)[merchantOfRecord](merchant-of-record.md)([MerchantOfRecord](../../-merchant-of-record/index.md)merchantOfRecord) |
| [nonrefundableDateRanges](nonrefundable-date-ranges.md) | [JVM]<br>public final [Rate.Builder](index.md)[nonrefundableDateRanges](nonrefundable-date-ranges.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../../-nonrefundable-date-range/index.md)&gt;nonrefundableDateRanges) |
| [occupancyPricing](occupancy-pricing.md) | [JVM]<br>public final [Rate.Builder](index.md)[occupancyPricing](occupancy-pricing.md)([Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PricingInformation](../../-pricing-information/index.md)&gt;occupancyPricing) |
| [promotions](promotions.md) | [JVM]<br>public final [Rate.Builder](index.md)[promotions](promotions.md)([Promotions](../../-promotions/index.md)promotions) |
| [refundable](refundable.md) | [JVM]<br>public final [Rate.Builder](index.md)[refundable](refundable.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)refundable) |
| [refundableDamageDeposit](refundable-damage-deposit.md) | [JVM]<br>public final [Rate.Builder](index.md)[refundableDamageDeposit](refundable-damage-deposit.md)([Amount](../../-amount/index.md)refundableDamageDeposit) |
| [saleScenario](sale-scenario.md) | [JVM]<br>public final [Rate.Builder](index.md)[saleScenario](sale-scenario.md)([SaleScenario](../../-sale-scenario/index.md)saleScenario) |
| [status](status.md) | [JVM]<br>public final [Rate.Builder](index.md)[status](status.md)([Status](../../-status/index.md)status) |
