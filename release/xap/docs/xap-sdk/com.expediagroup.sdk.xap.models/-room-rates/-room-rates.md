//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RoomRates](index.md)/[RoomRates](-room-rates.md)

# RoomRates

[JVM]\

public [RoomRates](index.md)[RoomRates](-room-rates.md)([Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)roomIndex, [RoomRatesTotalPrice](../-room-rates-total-price/index.md)totalPrice, [RoomRatesBaseRate](../-room-rates-base-rate/index.md)baseRate, [RoomRatesTaxesAndFees](../-room-rates-taxes-and-fees/index.md)taxesAndFees, [RoomRatesTotalStrikeOutPrice](../-room-rates-total-strike-out-price/index.md)totalStrikeOutPrice, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomRatesTaxesAndFeesDetailsInner](../-room-rates-taxes-and-fees-details-inner/index.md)&gt;taxesAndFeesDetails, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[MandatoryFeesDetail](../-mandatory-fees-detail/index.md)&gt;mandatoryFeesDetails, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomRatesNightlyRatesInner](../-room-rates-nightly-rates-inner/index.md)&gt;nightlyRates)

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
