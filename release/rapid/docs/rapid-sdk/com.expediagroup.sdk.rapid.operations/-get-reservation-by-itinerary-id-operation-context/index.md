//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[GetReservationByItineraryIdOperationContext](index.md)

# GetReservationByItineraryIdOperationContext

[JVM]\
public final class [GetReservationByItineraryIdOperationContext](index.md)

## Constructors

| | |
|---|---|
| [GetReservationByItineraryIdOperationContext](-get-reservation-by-itinerary-id-operation-context.md) | [JVM]<br>public [GetReservationByItineraryIdOperationContext](index.md)[GetReservationByItineraryIdOperationContext](-get-reservation-by-itinerary-id-operation-context.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [customerIp](index.md#999344483%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[customerIp](index.md#999344483%2FProperties%2F700308213)<br>IP address of the customer, as captured by your integration.<br> Ensure your integration passes the customer's IP, not your own. This value helps determine their location and assign the correct payment gateway.<br> Also used for fraud recovery and other important analytics. |
| [customerSessionId](index.md#100603135%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[customerSessionId](index.md#100603135%2FProperties%2F700308213)<br>Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session. |
| [test](index.md#-1471701162%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[test](index.md#-1471701162%2FProperties%2F700308213)<br>The retrieve call has a test header that can be used to return set responses. Passing standard in the Test header will retrieve a test booking, and passing any of the errors listed below will return a stubbed error response that you can use to test your error handling code. Additionally, refer to the Test Request documentation for more details on how these header values are used. * `standard` - Requires valid test booking. * `service_unavailable` * `internal_server_error` |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [GetReservationByItineraryIdOperationContext.Builder](-builder/index.md)[builder](builder.md)() |
| [getCustomerIp](get-customer-ip.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCustomerIp](get-customer-ip.md)()<br>IP address of the customer, as captured by your integration.<br> Ensure your integration passes the customer's IP, not your own. This value helps determine their location and assign the correct payment gateway.<br> Also used for fraud recovery and other important analytics. |
| [getCustomerSessionId](get-customer-session-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCustomerSessionId](get-customer-session-id.md)()<br>Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session. |
| [getHeaders](get-headers.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getHeaders](get-headers.md)() |
| [getTest](get-test.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTest](get-test.md)()<br>The retrieve call has a test header that can be used to return set responses. Passing standard in the Test header will retrieve a test booking, and passing any of the errors listed below will return a stubbed error response that you can use to test your error handling code. Additionally, refer to the Test Request documentation for more details on how these header values are used. * `standard` - Requires valid test booking. * `service_unavailable` * `internal_server_error` |
