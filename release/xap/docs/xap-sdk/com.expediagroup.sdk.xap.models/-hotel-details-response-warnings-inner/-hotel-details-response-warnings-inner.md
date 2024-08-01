//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelDetailsResponseWarningsInner](index.md)/[HotelDetailsResponseWarningsInner](-hotel-details-response-warnings-inner.md)

# HotelDetailsResponseWarningsInner

[JVM]\

public [HotelDetailsResponseWarningsInner](index.md)[HotelDetailsResponseWarningsInner](-hotel-details-response-warnings-inner.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)code, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)description, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)originalPrice, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)newPrice, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)changedAmount, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)changedPercentage)

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
