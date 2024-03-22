//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[postItineraryWithResponse](post-itinerary-with-response.md)

# postItineraryWithResponse

[JVM]\

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
| customerIp | IP address of the customer, as captured by your integration.<br> Ensure your integration passes the customer's IP, not your own. This value helps determine their location and assign the correct payment gateway.<br> Also used for fraud recovery and other important analytics. |
| token | Provided as part of the link object and used to maintain state across calls. This simplifies each subsequent call by limiting the amount of information required at each step and reduces the potential for errors. Token values cannot be viewed or changed. |
| createItineraryRequest |
| customerSessionId | Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session.  (optional) |
| test | The book call has a test header that can be used to return set responses with the following keywords:<br> * `standard` * `complete_payment_session` * `service_unavailable` * `internal_server_error` * `price_mismatch` * `cc_declined` * `rooms_unavailable`  (optional) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
