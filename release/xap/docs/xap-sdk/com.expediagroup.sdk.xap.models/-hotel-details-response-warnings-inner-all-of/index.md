//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelDetailsResponseWarningsInnerAllOf](index.md)

# HotelDetailsResponseWarningsInnerAllOf

public final class [HotelDetailsResponseWarningsInnerAllOf](index.md)

#### Parameters

JVM

| | |
|---|---|
| code | The code of the warning.  Available values are: - PRICE_DECREASED: The price decreased after shopping. - PRICE_INCREASED: The price increased after shopping. - CURRENCY_CHANGE: You will be charged in a different currency. |
| originalPrice | The original price from the Lodging Search API response. |
| newPrice | The new price. |
| changedAmount | The difference between `OriginalPrice` and `NewPrice`. |

## Constructors

| | |
|---|---|
| [HotelDetailsResponseWarningsInnerAllOf](-hotel-details-response-warnings-inner-all-of.md) | [JVM]<br>public [HotelDetailsResponseWarningsInnerAllOf](index.md)[HotelDetailsResponseWarningsInnerAllOf](-hotel-details-response-warnings-inner-all-of.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)code, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)originalPrice, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)newPrice, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)changedAmount) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [changedAmount](index.md#1477554820%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[changedAmount](index.md#1477554820%2FProperties%2F699445674) |
| [code](index.md#688553885%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[code](index.md#688553885%2FProperties%2F699445674) |
| [newPrice](index.md#6290177%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[newPrice](index.md#6290177%2FProperties%2F699445674) |
| [originalPrice](index.md#-599382472%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[originalPrice](index.md#-599382472%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [HotelDetailsResponseWarningsInnerAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getChangedAmount](get-changed-amount.md) | [JVM]<br>public final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[getChangedAmount](get-changed-amount.md)() |
| [getCode](get-code.md) | [JVM]<br>public final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[getCode](get-code.md)() |
| [getNewPrice](get-new-price.md) | [JVM]<br>public final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[getNewPrice](get-new-price.md)() |
| [getOriginalPrice](get-original-price.md) | [JVM]<br>public final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[getOriginalPrice](get-original-price.md)() |
