//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PaymentRequestWithPhone](index.md)/[PaymentRequestWithPhone](-payment-request-with-phone.md)

# PaymentRequestWithPhone

[JVM]\

public [PaymentRequestWithPhone](index.md)[PaymentRequestWithPhone](-payment-request-with-phone.md)([PaymentRequestWithPhone.Type](-type/index.md)type, [BillingContactRequestWithPhone](../-billing-contact-request-with-phone/index.md)billingContact, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)number, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)securityCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)expirationMonth, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)expirationYear, [ThirdPartyAuthRequest](../-third-party-auth-request/index.md)thirdPartyAuthentication, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)enrollmentDate)

#### Parameters

JVM

| | |
|---|---|
| type | Identifier for the type of payment. If affiliate_collect, cardholder information is not required as EPS will not be processing the payment. |
| billingContact |
| number | Card number. Required for credit card transactions. |
| securityCode | CVV/CSV code from the back of the customer's card. Required for credit card transactions. |
| expirationMonth | Two-digit month the credit card will expire. Required for credit card transactions. |
| expirationYear | Year the credit card will expire. Required for credit card transactions. |
| thirdPartyAuthentication |
| enrollmentDate | Date the payment account was enrolled in the cardholder's account with the merchant, in ISO 8601 format (YYYY-MM-DD). |
