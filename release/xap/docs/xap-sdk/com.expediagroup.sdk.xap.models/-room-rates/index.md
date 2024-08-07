//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RoomRates](index.md)

# RoomRates

public final class [RoomRates](index.md)

#### Parameters

JVM

| | |
|---|---|
| roomIndex | Index of which of the requested rooms this entry refers to. |
| totalPrice |
| baseRate |
| taxesAndFees |
| totalStrikeOutPrice |
| taxesAndFeesDetails | The breakdown for taxes and fees for this room for the entire stay.  Only visible by configuration. Please contact your Expedia Account Manager if you need this node. |
| mandatoryFeesDetails | The breakdown for the taxes and fees that must be paid at the property. |
| nightlyRates | Container for the nightly rate of current room. |

## Constructors

| | |
|---|---|
| [RoomRates](-room-rates.md) | [JVM]<br>public [RoomRates](index.md)[RoomRates](-room-rates.md)([Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)roomIndex, [RoomRatesTotalPrice](../-room-rates-total-price/index.md)totalPrice, [RoomRatesBaseRate](../-room-rates-base-rate/index.md)baseRate, [RoomRatesTaxesAndFees](../-room-rates-taxes-and-fees/index.md)taxesAndFees, [RoomRatesTotalStrikeOutPrice](../-room-rates-total-strike-out-price/index.md)totalStrikeOutPrice, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomRatesTaxesAndFeesDetailsInner](../-room-rates-taxes-and-fees-details-inner/index.md)&gt;taxesAndFeesDetails, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[MandatoryFeesDetail](../-mandatory-fees-detail/index.md)&gt;mandatoryFeesDetails, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomRatesNightlyRatesInner](../-room-rates-nightly-rates-inner/index.md)&gt;nightlyRates) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [baseRate](index.md#-1645257151%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RoomRatesBaseRate](../-room-rates-base-rate/index.md)[baseRate](index.md#-1645257151%2FProperties%2F699445674) |
| [mandatoryFeesDetails](index.md#-1257711562%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[MandatoryFeesDetail](../-mandatory-fees-detail/index.md)&gt;[mandatoryFeesDetails](index.md#-1257711562%2FProperties%2F699445674) |
| [nightlyRates](index.md#-1780335932%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomRatesNightlyRatesInner](../-room-rates-nightly-rates-inner/index.md)&gt;[nightlyRates](index.md#-1780335932%2FProperties%2F699445674) |
| [roomIndex](index.md#-959440687%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[roomIndex](index.md#-959440687%2FProperties%2F699445674) |
| [taxesAndFees](index.md#-681487353%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RoomRatesTaxesAndFees](../-room-rates-taxes-and-fees/index.md)[taxesAndFees](index.md#-681487353%2FProperties%2F699445674) |
| [taxesAndFeesDetails](index.md#1356442705%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomRatesTaxesAndFeesDetailsInner](../-room-rates-taxes-and-fees-details-inner/index.md)&gt;[taxesAndFeesDetails](index.md#1356442705%2FProperties%2F699445674) |
| [totalPrice](index.md#1357138541%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RoomRatesTotalPrice](../-room-rates-total-price/index.md)[totalPrice](index.md#1357138541%2FProperties%2F699445674) |
| [totalStrikeOutPrice](index.md#339862583%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RoomRatesTotalStrikeOutPrice](../-room-rates-total-strike-out-price/index.md)[totalStrikeOutPrice](index.md#339862583%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomRates.Builder](-builder/index.md)[builder](builder.md)() |
| [getBaseRate](get-base-rate.md) | [JVM]<br>public final [RoomRatesBaseRate](../-room-rates-base-rate/index.md)[getBaseRate](get-base-rate.md)() |
| [getMandatoryFeesDetails](get-mandatory-fees-details.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[MandatoryFeesDetail](../-mandatory-fees-detail/index.md)&gt;[getMandatoryFeesDetails](get-mandatory-fees-details.md)() |
| [getNightlyRates](get-nightly-rates.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomRatesNightlyRatesInner](../-room-rates-nightly-rates-inner/index.md)&gt;[getNightlyRates](get-nightly-rates.md)() |
| [getRoomIndex](get-room-index.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getRoomIndex](get-room-index.md)() |
| [getTaxesAndFees](get-taxes-and-fees.md) | [JVM]<br>public final [RoomRatesTaxesAndFees](../-room-rates-taxes-and-fees/index.md)[getTaxesAndFees](get-taxes-and-fees.md)() |
| [getTaxesAndFeesDetails](get-taxes-and-fees-details.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomRatesTaxesAndFeesDetailsInner](../-room-rates-taxes-and-fees-details-inner/index.md)&gt;[getTaxesAndFeesDetails](get-taxes-and-fees-details.md)() |
| [getTotalPrice](get-total-price.md) | [JVM]<br>public final [RoomRatesTotalPrice](../-room-rates-total-price/index.md)[getTotalPrice](get-total-price.md)() |
| [getTotalStrikeOutPrice](get-total-strike-out-price.md) | [JVM]<br>public final [RoomRatesTotalStrikeOutPrice](../-room-rates-total-strike-out-price/index.md)[getTotalStrikeOutPrice](get-total-strike-out-price.md)() |
