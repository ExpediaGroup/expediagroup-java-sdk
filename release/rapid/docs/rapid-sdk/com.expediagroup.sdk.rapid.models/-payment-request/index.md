//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PaymentRequest](index.md)

# PaymentRequest

public final class [PaymentRequest](index.md)

#### Parameters

JVM

| | |
|---|---|
| type | Identifier for the type of payment. If affiliate_collect, card information is not required as EPS will not be processing the payment. However, billing contact information is still required. |
| billingContact |
| number | Card number. Required for credit card transactions. |
| securityCode | CVV/CSV code from the back of the customer's card. Required for credit card transactions. |
| expirationMonth | Two-digit month the credit card will expire. Required for credit card transactions. |
| expirationYear | Year the credit card will expire. Required for credit card transactions. |
| thirdPartyAuthentication |
| enrollmentDate | Date the payment account was enrolled in the cardholder's account with the merchant, in ISO 8601 format (YYYY-MM-DD). |

## Constructors

| | |
|---|---|
| [PaymentRequest](-payment-request.md) | [JVM]<br>public [PaymentRequest](index.md)[PaymentRequest](-payment-request.md)([PaymentRequest.Type](-type/index.md)type, [BillingContactRequest](../-billing-contact-request/index.md)billingContact, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)number, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)securityCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)expirationMonth, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)expirationYear, [ThirdPartyAuthRequest](../-third-party-auth-request/index.md)thirdPartyAuthentication, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)enrollmentDate) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[PaymentRequest.Type](-type/index.md)&gt;<br>Identifier for the type of payment. If affiliate_collect, card information is not required as EPS will not be processing the payment. However, billing contact information is still required. Values: CORPORATE_CARD,CUSTOMER_CARD,VIRTUAL_CARD,AFFILIATE_COLLECT |

## Properties

| Name | Summary |
|---|---|
| [billingContact](index.md#744869083%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BillingContactRequest](../-billing-contact-request/index.md)[billingContact](index.md#744869083%2FProperties%2F700308213) |
| [enrollmentDate](index.md#-415064626%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[enrollmentDate](index.md#-415064626%2FProperties%2F700308213) |
| [expirationMonth](index.md#-419860087%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[expirationMonth](index.md#-419860087%2FProperties%2F700308213) |
| [expirationYear](index.md#1019449428%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[expirationYear](index.md#1019449428%2FProperties%2F700308213) |
| [number](index.md#-1269752265%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[number](index.md#-1269752265%2FProperties%2F700308213) |
| [securityCode](index.md#-2062875021%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[securityCode](index.md#-2062875021%2FProperties%2F700308213) |
| [thirdPartyAuthentication](index.md#-683444119%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [ThirdPartyAuthRequest](../-third-party-auth-request/index.md)[thirdPartyAuthentication](index.md#-683444119%2FProperties%2F700308213) |
| [type](index.md#-2073815002%2FProperties%2F700308213) | [JVM]<br>private final [PaymentRequest.Type](-type/index.md)[type](index.md#-2073815002%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentRequest.Builder](-builder/index.md)[builder](builder.md)() |
| [getBillingContact](get-billing-contact.md) | [JVM]<br>public final [BillingContactRequest](../-billing-contact-request/index.md)[getBillingContact](get-billing-contact.md)() |
| [getEnrollmentDate](get-enrollment-date.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEnrollmentDate](get-enrollment-date.md)() |
| [getExpirationMonth](get-expiration-month.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getExpirationMonth](get-expiration-month.md)() |
| [getExpirationYear](get-expiration-year.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getExpirationYear](get-expiration-year.md)() |
| [getNumber](get-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getNumber](get-number.md)() |
| [getSecurityCode](get-security-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSecurityCode](get-security-code.md)() |
| [getThirdPartyAuthentication](get-third-party-authentication.md) | [JVM]<br>public final [ThirdPartyAuthRequest](../-third-party-auth-request/index.md)[getThirdPartyAuthentication](get-third-party-authentication.md)() |
| [getType](get-type.md) | [JVM]<br>public final [PaymentRequest.Type](-type/index.md)[getType](get-type.md)() |
