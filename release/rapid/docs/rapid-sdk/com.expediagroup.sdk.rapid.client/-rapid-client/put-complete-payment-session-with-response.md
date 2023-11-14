//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[putCompletePaymentSessionWithResponse](put-complete-payment-session-with-response.md)

# putCompletePaymentSessionWithResponse

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[CompletePaymentSession](../../com.expediagroup.sdk.rapid.models/-complete-payment-session/index.md)&gt;[putCompletePaymentSessionWithResponse](put-complete-payment-session-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[CompletePaymentSession](../../com.expediagroup.sdk.rapid.models/-complete-payment-session/index.md)&gt;[putCompletePaymentSessionWithResponse](put-complete-payment-session-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[CompletePaymentSession](../../com.expediagroup.sdk.rapid.models/-complete-payment-session/index.md)&gt;[putCompletePaymentSessionWithResponse](put-complete-payment-session-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final Response&lt;[CompletePaymentSession](../../com.expediagroup.sdk.rapid.models/-complete-payment-session/index.md)&gt;[putCompletePaymentSessionWithResponse](put-complete-payment-session-with-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerIp, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token)

Complete Payment Session <b>This link only applies to transactions where EPS takes the customer's payment information. This includes both Expedia Collect and Property Collect transactions.</b><br> This link will be available in the booking response only if you've opted into Two-Factor Authentication to comply with the September 2019 EU Regulations for PSD2. It should be called after Two-Factor Authentication has been completed by the customer in order to finalize the payment and complete the booking or hold attempt. Learn more with our [PSD2 Overview](https://developers.expediagroup.com/docs/rapid/lodging/booking/psd2-regulation)

#### Return

a Response object with a body of type CompletePaymentSession

#### Parameters

JVM

| | |
|---|---|
| token | Provided as part of the link object and used to maintain state across calls. This simplifies each subsequent call by limiting the amount of information required at each step and reduces the potential for errors. Token values cannot be viewed or changed. |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
