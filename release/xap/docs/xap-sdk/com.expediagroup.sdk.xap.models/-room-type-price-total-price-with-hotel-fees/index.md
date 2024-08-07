//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RoomTypePriceTotalPriceWithHotelFees](index.md)

# RoomTypePriceTotalPriceWithHotelFees

public final class [RoomTypePriceTotalPriceWithHotelFees](index.md)

The total combined price that includes `TotalPrice` that will be charged by Expedia (`BaseRate` + `TaxesAndFees`) combined with any `HotelMandatoryFees` that will be charged at hotel. **NOTE**: Since UK regulations require that `HotelMandatoryFees` be included in this price, the quoted price will <u>only</u> be accurate for the day of quote. This is due to the fact that currency exchange fluctuations will change the exact amount of any `HotelMandatoryFees` that are to be collected at the hotel during the guest's stay if the cost is converted into any other currency. **CMA Compliance Note (UK)**: Websites doing business in the UK should be displaying this value to be compliant with CMA requirements.

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
| [RoomTypePriceTotalPriceWithHotelFees](-room-type-price-total-price-with-hotel-fees.md) | [JVM]<br>public [RoomTypePriceTotalPriceWithHotelFees](index.md)[RoomTypePriceTotalPriceWithHotelFees](-room-type-price-total-price-with-hotel-fees.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)currency, [Money](../-money/index.md)localCurrencyPrice) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [currency](index.md#881672627%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[currency](index.md#881672627%2FProperties%2F699445674) |
| [localCurrencyPrice](index.md#1917077111%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Money](../-money/index.md)[localCurrencyPrice](index.md#1917077111%2FProperties%2F699445674) |
| [value](index.md#-2103649307%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#-2103649307%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomTypePriceTotalPriceWithHotelFees.Builder](-builder/index.md)[builder](builder.md)() |
| [getCurrency](get-currency.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCurrency](get-currency.md)() |
| [getLocalCurrencyPrice](get-local-currency-price.md) | [JVM]<br>public final [Money](../-money/index.md)[getLocalCurrencyPrice](get-local-currency-price.md)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
