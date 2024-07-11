//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[priceCheckWithResponse](price-check-with-response.md)

# priceCheckWithResponse

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Use execute method instead&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;execute(operation: PriceCheckOperation)&quot;))

public final Response&lt;[RoomPriceCheck](../../com.expediagroup.sdk.rapid.models/-room-price-check/index.md)&gt;[~~priceCheckWithResponse~~](price-check-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)rateId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Use execute method instead&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;execute(operation: PriceCheckOperation)&quot;))

public final Response&lt;[RoomPriceCheck](../../com.expediagroup.sdk.rapid.models/-room-price-check/index.md)&gt;[~~priceCheckWithResponse~~](price-check-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)rateId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Use execute method instead&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;execute(operation: PriceCheckOperation)&quot;))

public final Response&lt;[RoomPriceCheck](../../com.expediagroup.sdk.rapid.models/-room-price-check/index.md)&gt;[~~priceCheckWithResponse~~](price-check-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)rateId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Use execute method instead&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;execute(operation: PriceCheckOperation)&quot;))

public final Response&lt;[RoomPriceCheck](../../com.expediagroup.sdk.rapid.models/-room-price-check/index.md)&gt;[~~priceCheckWithResponse~~](price-check-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)rateId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token)

---

### Deprecated

Use execute method instead

#### Replace with

```kotlin
execute(operation: PriceCheckOperation)
```
---

Price-Check Confirms the price returned by the Property Availability response. Use this API to verify a previously-selected rate is still valid before booking. If the price is matched, the response returns a link to request a booking. If the price has changed, the response returns new price details and a booking link for the new price. If the rate is no longer available, the response will return a new Property Availability request link to search again for different rates. In the event of a price change, go back to Property Availability and book the property at the new price or return to additional rates for the property.

#### Return

a Response object with a body of type RoomPriceCheck

#### Parameters

JVM

| | |
|---|---|
| propertyId | Expedia Property ID.<br> |
| roomId | Room ID of a property.<br> |
| rateId | Rate ID of a room.<br> |
| token | A hashed collection of query parameters. Used to maintain state across calls. This token is provided as part of the price check link from the shop response. |
| customerIp | IP address of the customer, as captured by your integration.<br> Ensure your integration passes the customer's IP, not your own. This value helps determine their location and assign the correct payment gateway.<br> Also used for fraud recovery and other important analytics.  (optional) |
| customerSessionId | Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session.  (optional) |
| test | Price check calls have a test header that can be used to return set responses with the following keywords:   * `available`   * `price_changed`   * `sold_out`   * `service_unavailable`   * `unknown_internal_error`  (optional) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
