//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[getReservationWithResponse](get-reservation-with-response.md)

# getReservationWithResponse

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Itinerary](../../com.expediagroup.sdk.rapid.models/-itinerary/index.md)&gt;&gt;[getReservationWithResponse](get-reservation-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateReferenceId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;include, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Itinerary](../../com.expediagroup.sdk.rapid.models/-itinerary/index.md)&gt;&gt;[getReservationWithResponse](get-reservation-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateReferenceId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;include)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Itinerary](../../com.expediagroup.sdk.rapid.models/-itinerary/index.md)&gt;&gt;[getReservationWithResponse](get-reservation-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateReferenceId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Itinerary](../../com.expediagroup.sdk.rapid.models/-itinerary/index.md)&gt;&gt;[getReservationWithResponse](get-reservation-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateReferenceId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Itinerary](../../com.expediagroup.sdk.rapid.models/-itinerary/index.md)&gt;&gt;[getReservationWithResponse](get-reservation-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateReferenceId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email)

Search for and retrieve Bookings with Affiliate Reference Id This can be called directly without a token when an affiliate reference id is provided. It returns details about bookings associated with an affiliate reference id, along with cancel links to cancel the bookings.  <i>Note: Newly created itineraries may sometimes have a small delay between the time of creation and the time that the itinerary can be retrieved. If you receive no results while trying to find an itinerary that was successfully created, please wait a few minutes before trying to search for the itinerary again.</i>

#### Return

a Response object with a body of type kotlin.collections.List<Itinerary>

#### Parameters

JVM

| | |
|---|---|
| affiliateReferenceId | The affilliate reference id value. This field supports a maximum of 28 characters. |
| email | Email associated with the booking. Special characters in the local part or domain should be encoded.<br> |
| include | Options for which information to return in the response. The value must be lower case.   * history - Include itinerary history, showing details of the changes made to this itinerary  (optional) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
