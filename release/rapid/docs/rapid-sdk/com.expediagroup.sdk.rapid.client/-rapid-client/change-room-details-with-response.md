//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[changeRoomDetailsWithResponse](change-room-details-with-response.md)

# changeRoomDetailsWithResponse

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Use execute method instead&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;execute(operation: ChangeRoomDetailsOperation)&quot;))

public final Response&lt;Nothing&gt;[~~changeRoomDetailsWithResponse~~](change-room-details-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [ChangeRoomDetailsRequest](../../com.expediagroup.sdk.rapid.models/-change-room-details-request/index.md)changeRoomDetailsRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Use execute method instead&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;execute(operation: ChangeRoomDetailsOperation)&quot;))

public final Response&lt;Nothing&gt;[~~changeRoomDetailsWithResponse~~](change-room-details-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [ChangeRoomDetailsRequest](../../com.expediagroup.sdk.rapid.models/-change-room-details-request/index.md)changeRoomDetailsRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Use execute method instead&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;execute(operation: ChangeRoomDetailsOperation)&quot;))

public final Response&lt;Nothing&gt;[~~changeRoomDetailsWithResponse~~](change-room-details-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [ChangeRoomDetailsRequest](../../com.expediagroup.sdk.rapid.models/-change-room-details-request/index.md)changeRoomDetailsRequest)

---

### Deprecated

Use execute method instead

#### Replace with

```kotlin
execute(operation: ChangeRoomDetailsOperation)
```
---

Change details of a room. This link will be available in the retrieve response. Changes in smoking preference and special request will be passed along to the property and are not guaranteed.

#### Return

a Response object with a body of type Nothing

#### Parameters

JVM

| | |
|---|---|
| customerIp | IP address of the customer, as captured by your integration.<br> Ensure your integration passes the customer's IP, not your own. This value helps determine their location and assign the correct payment gateway.<br> Also used for fraud recovery and other important analytics. |
| itineraryId | This parameter is used only to prefix the token value - no ID value is used.<br> |
| roomId | Room ID of a property.<br> |
| token | Provided as part of the link object and used to maintain state across calls. This simplifies each subsequent call by limiting the amount of information required at each step and reduces the potential for errors. Token values cannot be viewed or changed. |
| changeRoomDetailsRequest | The request body is required, but only the fields that are being changed need to be passed in. Fields that are not being changed should not be included in the request body. |
| customerSessionId | Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session.  (optional) |
| test | The change call has a test header that can be used to return set responses with the following keywords:<br> * `standard` - Requires valid test booking. * `service_unavailable` * `unknown_internal_error`  (optional) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
