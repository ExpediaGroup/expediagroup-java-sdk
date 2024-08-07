//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelDetailsResponseWarningsInner](index.md)

# HotelDetailsResponseWarningsInner

public final class [HotelDetailsResponseWarningsInner](index.md)

#### Parameters

JVM

| | |
|---|---|
| code | The code of the warning.  Available values are: - PRICE_DECREASED: The price decreased after shopping. - PRICE_INCREASED: The price increased after shopping. - CURRENCY_CHANGE: You will be charged in a different currency. |
| description | A detail information of what happened. |
| originalPrice | The original price from the Lodging Search API response. |
| newPrice | The new price. |
| changedAmount | The difference between `OriginalPrice` and `NewPrice`. |
| changedPercentage | The changed percentage. In the sample 2.97 means the changed percentage is 2.97%. |

## Constructors

| | |
|---|---|
| [HotelDetailsResponseWarningsInner](-hotel-details-response-warnings-inner.md) | [JVM]<br>public [HotelDetailsResponseWarningsInner](index.md)[HotelDetailsResponseWarningsInner](-hotel-details-response-warnings-inner.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)code, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)description, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)originalPrice, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)newPrice, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)changedAmount, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)changedPercentage) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [changedAmount](index.md#-71942716%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[changedAmount](index.md#-71942716%2FProperties%2F699445674) |
| [changedPercentage](index.md#1553695298%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[changedPercentage](index.md#1553695298%2FProperties%2F699445674) |
| [code](index.md#1312836701%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[code](index.md#1312836701%2FProperties%2F699445674) |
| [description](index.md#-1819542348%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[description](index.md#-1819542348%2FProperties%2F699445674) |
| [newPrice](index.md#-933140543%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[newPrice](index.md#-933140543%2FProperties%2F699445674) |
| [originalPrice](index.md#2146087288%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[originalPrice](index.md#2146087288%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [HotelDetailsResponseWarningsInner.Builder](-builder/index.md)[builder](builder.md)() |
| [getChangedAmount](get-changed-amount.md) | [JVM]<br>public final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[getChangedAmount](get-changed-amount.md)() |
| [getChangedPercentage](get-changed-percentage.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getChangedPercentage](get-changed-percentage.md)() |
| [getCode](get-code.md) | [JVM]<br>public final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[getCode](get-code.md)() |
| [getDescription](get-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDescription](get-description.md)() |
| [getNewPrice](get-new-price.md) | [JVM]<br>public final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[getNewPrice](get-new-price.md)() |
| [getOriginalPrice](get-original-price.md) | [JVM]<br>public final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[getOriginalPrice](get-original-price.md)() |
