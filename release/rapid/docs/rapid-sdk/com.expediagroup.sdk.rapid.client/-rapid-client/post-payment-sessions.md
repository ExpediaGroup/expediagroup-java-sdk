//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[postPaymentSessions](post-payment-sessions.md)

# postPaymentSessions

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [PaymentSessions](../../com.expediagroup.sdk.rapid.models/-payment-sessions/index.md)[postPaymentSessions](post-payment-sessions.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [PaymentSessionsRequest](../../com.expediagroup.sdk.rapid.models/-payment-sessions-request/index.md)paymentSessionsRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [PaymentSessions](../../com.expediagroup.sdk.rapid.models/-payment-sessions/index.md)[postPaymentSessions](post-payment-sessions.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [PaymentSessionsRequest](../../com.expediagroup.sdk.rapid.models/-payment-sessions-request/index.md)paymentSessionsRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [PaymentSessions](../../com.expediagroup.sdk.rapid.models/-payment-sessions/index.md)[postPaymentSessions](post-payment-sessions.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [PaymentSessionsRequest](../../com.expediagroup.sdk.rapid.models/-payment-sessions-request/index.md)paymentSessionsRequest, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [PaymentSessions](../../com.expediagroup.sdk.rapid.models/-payment-sessions/index.md)[postPaymentSessions](post-payment-sessions.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [PaymentSessionsRequest](../../com.expediagroup.sdk.rapid.models/-payment-sessions-request/index.md)paymentSessionsRequest)

Register Payments <b>This link only applies to transactions where EPS takes the customer's payment information. This includes both Expedia Collect and Property Collect transactions.</b><br> This link will be available in the Price Check response if payment registration is required. It returns a payment session ID and a link to create a booking. This will be the first step in the booking flow only if you've opted into Two-Factor Authentication to comply with the September 2019 EU Regulations for PSD2. Learn more with our [PSD2 Overview](https://developers.expediagroup.com/docs/rapid/lodging/booking/psd2-regulation)

#### Return

PaymentSessions

#### Parameters

JVM

| | |
|---|---|
| token | Provided as part of the link object and used to maintain state across calls. This simplifies each subsequent call by limiting the amount of information required at each step and reduces the potential for errors. Token values cannot be viewed or changed. |
| paymentSessionsRequest |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
