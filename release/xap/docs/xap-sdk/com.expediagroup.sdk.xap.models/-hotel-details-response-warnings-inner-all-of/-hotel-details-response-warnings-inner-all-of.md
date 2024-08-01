//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelDetailsResponseWarningsInnerAllOf](index.md)/[HotelDetailsResponseWarningsInnerAllOf](-hotel-details-response-warnings-inner-all-of.md)

# HotelDetailsResponseWarningsInnerAllOf

[JVM]\

public [HotelDetailsResponseWarningsInnerAllOf](index.md)[HotelDetailsResponseWarningsInnerAllOf](-hotel-details-response-warnings-inner-all-of.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)code, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)originalPrice, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)newPrice, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)changedAmount)

#### Parameters

JVM

| | |
|---|---|
| code | The code of the warning.  Available values are: - PRICE_DECREASED: The price decreased after shopping. - PRICE_INCREASED: The price increased after shopping. - CURRENCY_CHANGE: You will be charged in a different currency. |
| originalPrice | The original price from the Lodging Search API response. |
| newPrice | The new price. |
| changedAmount | The difference between `OriginalPrice` and `NewPrice`. |
