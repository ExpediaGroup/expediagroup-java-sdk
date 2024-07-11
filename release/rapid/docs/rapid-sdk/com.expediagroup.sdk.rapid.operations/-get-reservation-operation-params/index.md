//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[GetReservationOperationParams](index.md)

# GetReservationOperationParams

[JVM]\
public final class [GetReservationOperationParams](index.md) implements OperationParams

## Constructors

| | |
|---|---|
| [GetReservationOperationParams](-get-reservation-operation-params.md) | [JVM]<br>public [GetReservationOperationParams](index.md)[GetReservationOperationParams](-get-reservation-operation-params.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateReferenceId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;include) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [affiliateReferenceId](index.md#-1783389435%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[affiliateReferenceId](index.md#-1783389435%2FProperties%2F700308213)<br>The affilliate reference id value. This field supports a maximum of 28 characters. |
| [customerIp](index.md#1379041881%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[customerIp](index.md#1379041881%2FProperties%2F700308213)<br>IP address of the customer, as captured by your integration.<br> Ensure your integration passes the customer's IP, not your own. This value helps determine their location and assign the correct payment gateway.<br> Also used for fraud recovery and other important analytics. |
| [customerSessionId](index.md#316635977%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[customerSessionId](index.md#316635977%2FProperties%2F700308213)<br>Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session. |
| [email](index.md#-399963552%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[email](index.md#-399963552%2FProperties%2F700308213)<br>Email associated with the booking. Special characters in the local part or domain should be encoded.<br> |
| [include](index.md#-501329132%2FProperties%2F700308213) | [JVM]<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[include](index.md#-501329132%2FProperties%2F700308213)<br>Options for which information to return in the response. The value must be lower case.   * history - Include itinerary history, showing details of the changes made to this itinerary |
| [test](index.md#-452146996%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[test](index.md#-452146996%2FProperties%2F700308213)<br>The retrieve call has a test header that can be used to return set responses with the following keywords:<br> * `standard` - Requires valid test booking. * `service_unavailable` * `internal_server_error` |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [GetReservationOperationParams.Builder](-builder/index.md)[builder](builder.md)() |
| [getAffiliateReferenceId](get-affiliate-reference-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAffiliateReferenceId](get-affiliate-reference-id.md)()<br>The affilliate reference id value. This field supports a maximum of 28 characters. |
| [getCustomerIp](get-customer-ip.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCustomerIp](get-customer-ip.md)()<br>IP address of the customer, as captured by your integration.<br> Ensure your integration passes the customer's IP, not your own. This value helps determine their location and assign the correct payment gateway.<br> Also used for fraud recovery and other important analytics. |
| [getCustomerSessionId](get-customer-session-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCustomerSessionId](get-customer-session-id.md)()<br>Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session. |
| [getEmail](get-email.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEmail](get-email.md)()<br>Email associated with the booking. Special characters in the local part or domain should be encoded.<br> |
| [getHeaders](get-headers.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getHeaders](get-headers.md)() |
| [getInclude](get-include.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getInclude](get-include.md)()<br>Options for which information to return in the response. The value must be lower case.   * history - Include itinerary history, showing details of the changes made to this itinerary |
| [getQueryParams](get-query-params.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Iterable](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getQueryParams](get-query-params.md)() |
| [getTest](get-test.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTest](get-test.md)()<br>The retrieve call has a test header that can be used to return set responses with the following keywords:<br> * `standard` - Requires valid test booking. * `service_unavailable` * `internal_server_error` |
