//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[postPaymentSessionsWithResponse](post-payment-sessions-with-response.md)

# postPaymentSessionsWithResponse

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[PaymentSessions](../../com.expediagroup.sdk.rapid.models/-payment-sessions/index.md)&gt;[postPaymentSessionsWithResponse](post-payment-sessions-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [PaymentSessionsRequest](../../com.expediagroup.sdk.rapid.models/-payment-sessions-request/index.md)paymentSessionsRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[PaymentSessions](../../com.expediagroup.sdk.rapid.models/-payment-sessions/index.md)&gt;[postPaymentSessionsWithResponse](post-payment-sessions-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [PaymentSessionsRequest](../../com.expediagroup.sdk.rapid.models/-payment-sessions-request/index.md)paymentSessionsRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[PaymentSessions](../../com.expediagroup.sdk.rapid.models/-payment-sessions/index.md)&gt;[postPaymentSessionsWithResponse](post-payment-sessions-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [PaymentSessionsRequest](../../com.expediagroup.sdk.rapid.models/-payment-sessions-request/index.md)paymentSessionsRequest)

Register Payments <b>This link only applies to transactions where EPS takes the customer's payment information. This includes both Expedia Collect and Property Collect transactions.</b><br> This link will be available in the Price Check response if payment registration is required. It returns a payment session ID and a link to create a booking. This will be the first step in the booking flow only if you've opted into Two-Factor Authentication to comply with the September 2019 EU Regulations for PSD2. Learn more with our [PSD2 Overview](https://developers.expediagroup.com/docs/rapid/lodging/booking/psd2-regulation)

#### Return

a Response object with a body of type PaymentSessions

#### Parameters

JVM

| | |
|---|---|
| customerIp | IP address of the customer, as captured by your integration.<br> Ensure your integration passes the customer's IP, not your own. This value helps determine their location and assign the correct payment gateway.<br> Also used for fraud recovery and other important analytics. |
| token | Provided as part of the link object and used to maintain state across calls. This simplifies each subsequent call by limiting the amount of information required at each step and reduces the potential for errors. Token values cannot be viewed or changed. |
| paymentSessionsRequest |
| customerSessionId | Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session.  (optional) |
| test | The book call has a test header that can be used to return set responses with the following keywords:<br> * `standard` * `service_unavailable` * `internal_server_error`  (optional) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
