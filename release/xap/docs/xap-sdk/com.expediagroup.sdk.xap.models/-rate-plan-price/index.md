//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RatePlanPrice](index.md)

# RatePlanPrice

public final class [RatePlanPrice](index.md)

Container for all price components of the rate plan.

#### Parameters

JVM

| |
|---|
| totalPrice |
| avgNightlyRate |
| baseRate |
| taxesAndFees |
| totalStrikeOutPrice |
| avgNightlyStrikeOutRate |
| hotelMandatoryFees |
| refundableDamageDeposit |
| nightlyRates | Nightly base rate of the rate plan. |
| taxesAndFeesDetails | Container for taxes and fees detail information. Only visible by configuration. Please contact your Expedia Account Manager if you need this node. |
| roomRates | Container for the rate information of all rooms. This is only returned in Lodging Details API. |

## Constructors

| | |
|---|---|
| [RatePlanPrice](-rate-plan-price.md) | [JVM]<br>public [RatePlanPrice](index.md)[RatePlanPrice](-rate-plan-price.md)([RatePlanPriceTotalPrice](../-rate-plan-price-total-price/index.md)totalPrice, [RatePlanPriceAvgNightlyRate](../-rate-plan-price-avg-nightly-rate/index.md)avgNightlyRate, [RatePlanPriceBaseRate](../-rate-plan-price-base-rate/index.md)baseRate, [RatePlanPriceTaxesAndFees](../-rate-plan-price-taxes-and-fees/index.md)taxesAndFees, [RatePlanPriceTotalStrikeOutPrice](../-rate-plan-price-total-strike-out-price/index.md)totalStrikeOutPrice, [RatePlanPriceAvgNightlyStrikeOutRate](../-rate-plan-price-avg-nightly-strike-out-rate/index.md)avgNightlyStrikeOutRate, [RatePlanPriceHotelMandatoryFees](../-rate-plan-price-hotel-mandatory-fees/index.md)hotelMandatoryFees, [RatePlanPriceRefundableDamageDeposit](../-rate-plan-price-refundable-damage-deposit/index.md)refundableDamageDeposit, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanPriceNightlyRatesInner](../-rate-plan-price-nightly-rates-inner/index.md)&gt;nightlyRates, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanPriceTaxesAndFeesDetailsInner](../-rate-plan-price-taxes-and-fees-details-inner/index.md)&gt;taxesAndFeesDetails, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanPriceRoomRatesInner](../-rate-plan-price-room-rates-inner/index.md)&gt;roomRates) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [avgNightlyRate](index.md#-1952479929%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RatePlanPriceAvgNightlyRate](../-rate-plan-price-avg-nightly-rate/index.md)[avgNightlyRate](index.md#-1952479929%2FProperties%2F699445674) |
| [avgNightlyStrikeOutRate](index.md#1372405463%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RatePlanPriceAvgNightlyStrikeOutRate](../-rate-plan-price-avg-nightly-strike-out-rate/index.md)[avgNightlyStrikeOutRate](index.md#1372405463%2FProperties%2F699445674) |
| [baseRate](index.md#-791030423%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RatePlanPriceBaseRate](../-rate-plan-price-base-rate/index.md)[baseRate](index.md#-791030423%2FProperties%2F699445674) |
| [hotelMandatoryFees](index.md#-739820088%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RatePlanPriceHotelMandatoryFees](../-rate-plan-price-hotel-mandatory-fees/index.md)[hotelMandatoryFees](index.md#-739820088%2FProperties%2F699445674) |
| [nightlyRates](index.md#-756228628%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanPriceNightlyRatesInner](../-rate-plan-price-nightly-rates-inner/index.md)&gt;[nightlyRates](index.md#-756228628%2FProperties%2F699445674) |
| [refundableDamageDeposit](index.md#13309027%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RatePlanPriceRefundableDamageDeposit](../-rate-plan-price-refundable-damage-deposit/index.md)[refundableDamageDeposit](index.md#13309027%2FProperties%2F699445674) |
| [roomRates](index.md#-502674680%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanPriceRoomRatesInner](../-rate-plan-price-room-rates-inner/index.md)&gt;[roomRates](index.md#-502674680%2FProperties%2F699445674) |
| [taxesAndFees](index.md#342619951%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RatePlanPriceTaxesAndFees](../-rate-plan-price-taxes-and-fees/index.md)[taxesAndFees](index.md#342619951%2FProperties%2F699445674) |
| [taxesAndFeesDetails](index.md#-816796631%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanPriceTaxesAndFeesDetailsInner](../-rate-plan-price-taxes-and-fees-details-inner/index.md)&gt;[taxesAndFeesDetails](index.md#-816796631%2FProperties%2F699445674) |
| [totalPrice](index.md#1930270613%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RatePlanPriceTotalPrice](../-rate-plan-price-total-price/index.md)[totalPrice](index.md#1930270613%2FProperties%2F699445674) |
| [totalStrikeOutPrice](index.md#-1833376753%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RatePlanPriceTotalStrikeOutPrice](../-rate-plan-price-total-strike-out-price/index.md)[totalStrikeOutPrice](index.md#-1833376753%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RatePlanPrice.Builder](-builder/index.md)[builder](builder.md)() |
| [getAvgNightlyRate](get-avg-nightly-rate.md) | [JVM]<br>public final [RatePlanPriceAvgNightlyRate](../-rate-plan-price-avg-nightly-rate/index.md)[getAvgNightlyRate](get-avg-nightly-rate.md)() |
| [getAvgNightlyStrikeOutRate](get-avg-nightly-strike-out-rate.md) | [JVM]<br>public final [RatePlanPriceAvgNightlyStrikeOutRate](../-rate-plan-price-avg-nightly-strike-out-rate/index.md)[getAvgNightlyStrikeOutRate](get-avg-nightly-strike-out-rate.md)() |
| [getBaseRate](get-base-rate.md) | [JVM]<br>public final [RatePlanPriceBaseRate](../-rate-plan-price-base-rate/index.md)[getBaseRate](get-base-rate.md)() |
| [getHotelMandatoryFees](get-hotel-mandatory-fees.md) | [JVM]<br>public final [RatePlanPriceHotelMandatoryFees](../-rate-plan-price-hotel-mandatory-fees/index.md)[getHotelMandatoryFees](get-hotel-mandatory-fees.md)() |
| [getNightlyRates](get-nightly-rates.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanPriceNightlyRatesInner](../-rate-plan-price-nightly-rates-inner/index.md)&gt;[getNightlyRates](get-nightly-rates.md)() |
| [getRefundableDamageDeposit](get-refundable-damage-deposit.md) | [JVM]<br>public final [RatePlanPriceRefundableDamageDeposit](../-rate-plan-price-refundable-damage-deposit/index.md)[getRefundableDamageDeposit](get-refundable-damage-deposit.md)() |
| [getRoomRates](get-room-rates.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanPriceRoomRatesInner](../-rate-plan-price-room-rates-inner/index.md)&gt;[getRoomRates](get-room-rates.md)() |
| [getTaxesAndFees](get-taxes-and-fees.md) | [JVM]<br>public final [RatePlanPriceTaxesAndFees](../-rate-plan-price-taxes-and-fees/index.md)[getTaxesAndFees](get-taxes-and-fees.md)() |
| [getTaxesAndFeesDetails](get-taxes-and-fees-details.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlanPriceTaxesAndFeesDetailsInner](../-rate-plan-price-taxes-and-fees-details-inner/index.md)&gt;[getTaxesAndFeesDetails](get-taxes-and-fees-details.md)() |
| [getTotalPrice](get-total-price.md) | [JVM]<br>public final [RatePlanPriceTotalPrice](../-rate-plan-price-total-price/index.md)[getTotalPrice](get-total-price.md)() |
| [getTotalStrikeOutPrice](get-total-strike-out-price.md) | [JVM]<br>public final [RatePlanPriceTotalStrikeOutPrice](../-rate-plan-price-total-strike-out-price/index.md)[getTotalStrikeOutPrice](get-total-strike-out-price.md)() |
