//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[PostItineraryOperationParams](index.md)

# PostItineraryOperationParams

[JVM]\
public final class [PostItineraryOperationParams](index.md) implements OperationParams

## Constructors

| | |
|---|---|
| [PostItineraryOperationParams](-post-itinerary-operation-params.md) | [JVM]<br>public [PostItineraryOperationParams](index.md)[PostItineraryOperationParams](-post-itinerary-operation-params.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token)<br>public [PostItineraryOperationParams](index.md)[PostItineraryOperationParams](-post-itinerary-operation-params.md)([PostItineraryOperationContext](../-post-itinerary-operation-context/index.md)context) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [customerIp](index.md#-1872567630%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[customerIp](index.md#-1872567630%2FProperties%2F700308213)<br>IP address of the customer, as captured by your integration.<br> Ensure your integration passes the customer's IP, not your own. This value helps determine their location and assign the correct payment gateway.<br> Also used for fraud recovery and other important analytics. |
| [customerSessionId](index.md#214676688%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[customerSessionId](index.md#214676688%2FProperties%2F700308213)<br>Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session. |
| [test](index.md#-1514233883%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[test](index.md#-1514233883%2FProperties%2F700308213)<br>The book call has a test header that can be used to return set responses with the following keywords:<br> * `standard` * `complete_payment_session` * `service_unavailable` * `internal_server_error` * `price_mismatch` * `cc_declined` * `rooms_unavailable` |
| [token](index.md#554212010%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[token](index.md#554212010%2FProperties%2F700308213)<br>Provided as part of the link object and used to maintain state across calls. This simplifies each subsequent call by limiting the amount of information required at each step and reduces the potential for errors. Token values cannot be viewed or changed. |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PostItineraryOperationParams.Builder](-builder/index.md)[builder](builder.md)() |
| [getCustomerIp](get-customer-ip.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCustomerIp](get-customer-ip.md)()<br>IP address of the customer, as captured by your integration.<br> Ensure your integration passes the customer's IP, not your own. This value helps determine their location and assign the correct payment gateway.<br> Also used for fraud recovery and other important analytics. |
| [getCustomerSessionId](get-customer-session-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCustomerSessionId](get-customer-session-id.md)()<br>Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session. |
| [getHeaders](get-headers.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getHeaders](get-headers.md)() |
| [getPathParams](get-path-params.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getPathParams](get-path-params.md)() |
| [getQueryParams](get-query-params.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Iterable](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getQueryParams](get-query-params.md)() |
| [getTest](get-test.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTest](get-test.md)()<br>The book call has a test header that can be used to return set responses with the following keywords:<br> * `standard` * `complete_payment_session` * `service_unavailable` * `internal_server_error` * `price_mismatch` * `cc_declined` * `rooms_unavailable` |
| [getToken](get-token.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getToken](get-token.md)()<br>Provided as part of the link object and used to maintain state across calls. This simplifies each subsequent call by limiting the amount of information required at each step and reduces the potential for errors. Token values cannot be viewed or changed. |
