//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RoomTypeStandalonePriceTotalPrice](index.md)

# RoomTypeStandalonePriceTotalPrice

public final class [RoomTypeStandalonePriceTotalPrice](index.md)

The total standalone price of the rate plan, which is equal to the sum of `BaseRate` and `TaxesAndFees`. Hotel mandatory fees are not included as these are paid at the hotel at checkout.

#### Parameters

JVM

| | |
|---|---|
|  | `value` The value of the element being defined. |
| currency | The ISO 4217 Currency Code that the value is expressed in. |
| localCurrencyPrice |

## Constructors

| | |
|---|---|
| [RoomTypeStandalonePriceTotalPrice](-room-type-standalone-price-total-price.md) | [JVM]<br>public [RoomTypeStandalonePriceTotalPrice](index.md)[RoomTypeStandalonePriceTotalPrice](-room-type-standalone-price-total-price.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)currency, [Money](../-money/index.md)localCurrencyPrice) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [currency](index.md#2059105629%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[currency](index.md#2059105629%2FProperties%2F699445674) |
| [localCurrencyPrice](index.md#-965907039%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Money](../-money/index.md)[localCurrencyPrice](index.md#-965907039%2FProperties%2F699445674) |
| [value](index.md#1083267195%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#1083267195%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomTypeStandalonePriceTotalPrice.Builder](-builder/index.md)[builder](builder.md)() |
| [getCurrency](get-currency.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCurrency](get-currency.md)() |
| [getLocalCurrencyPrice](get-local-currency-price.md) | [JVM]<br>public final [Money](../-money/index.md)[getLocalCurrencyPrice](get-local-currency-price.md)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
