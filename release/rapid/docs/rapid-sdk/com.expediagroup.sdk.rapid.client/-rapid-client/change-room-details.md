//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[changeRoomDetails](change-room-details.md)

# changeRoomDetails

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Nothing[changeRoomDetails](change-room-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [ChangeRoomDetailsRequest](../../com.expediagroup.sdk.rapid.models/-change-room-details-request/index.md)changeRoomDetailsRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Nothing[changeRoomDetails](change-room-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [ChangeRoomDetailsRequest](../../com.expediagroup.sdk.rapid.models/-change-room-details-request/index.md)changeRoomDetailsRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Nothing[changeRoomDetails](change-room-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [ChangeRoomDetailsRequest](../../com.expediagroup.sdk.rapid.models/-change-room-details-request/index.md)changeRoomDetailsRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Nothing[changeRoomDetails](change-room-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [ChangeRoomDetailsRequest](../../com.expediagroup.sdk.rapid.models/-change-room-details-request/index.md)changeRoomDetailsRequest)

Change details of a room. This link will be available in the retrieve response. Changes in smoking preference and special request will be passed along to the property and are not guaranteed.

#### Return

Nothing

#### Parameters

JVM

| | |
|---|---|
| token | Provided as part of the link object and used to maintain state across calls. This simplifies each subsequent call by limiting the amount of information required at each step and reduces the potential for errors. Token values cannot be viewed or changed. |
| changeRoomDetailsRequest | The request body is required, but only the fields that are being changed need to be passed in. Fields that are not being changed should not be included in the request body. |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
