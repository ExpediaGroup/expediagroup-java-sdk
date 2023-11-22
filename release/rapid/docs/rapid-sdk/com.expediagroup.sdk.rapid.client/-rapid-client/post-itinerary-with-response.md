//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[postItineraryWithResponse](post-itinerary-with-response.md)

# postItineraryWithResponse

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[ItineraryCreation](../../com.expediagroup.sdk.rapid.models/-itinerary-creation/index.md)&gt;[postItineraryWithResponse](post-itinerary-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [CreateItineraryRequest](../../com.expediagroup.sdk.rapid.models/-create-itinerary-request/index.md)createItineraryRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[ItineraryCreation](../../com.expediagroup.sdk.rapid.models/-itinerary-creation/index.md)&gt;[postItineraryWithResponse](post-itinerary-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [CreateItineraryRequest](../../com.expediagroup.sdk.rapid.models/-create-itinerary-request/index.md)createItineraryRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[ItineraryCreation](../../com.expediagroup.sdk.rapid.models/-itinerary-creation/index.md)&gt;[postItineraryWithResponse](post-itinerary-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [CreateItineraryRequest](../../com.expediagroup.sdk.rapid.models/-create-itinerary-request/index.md)createItineraryRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[ItineraryCreation](../../com.expediagroup.sdk.rapid.models/-itinerary-creation/index.md)&gt;[postItineraryWithResponse](post-itinerary-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [CreateItineraryRequest](../../com.expediagroup.sdk.rapid.models/-create-itinerary-request/index.md)createItineraryRequest)

Create Booking This link will be available in the Price Check response or in the register payments response when Two-Factor Authentication is used. It returns an itinerary id and links to retrieve reservation details, cancel a held booking, resume a held booking or complete payment session. Please note that depending on the state of the booking, the response will contain only the applicable link(s).

#### Return

a Response object with a body of type ItineraryCreation

#### Parameters

JVM

| | |
|---|---|
| token | Provided as part of the link object and used to maintain state across calls. This simplifies each subsequent call by limiting the amount of information required at each step and reduces the potential for errors. Token values cannot be viewed or changed. |
| createItineraryRequest |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
