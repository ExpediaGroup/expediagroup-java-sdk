//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[PayPal](index.md)/[PayPal](-pay-pal.md)

# PayPal

[JVM]\

public [PayPal](index.md)[PayPal](-pay-pal.md)([Payment.Brand](../-payment/-brand/index.md)brand, [Name](../-name/index.md)billingName, [PaymentBillingAddress](../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)payerId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)transactionId, [PaymentReason](../-payment-reason/index.md)reason, [Amount](../-amount/index.md)authorizedAmount, [Amount](../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../-operations/index.md)operations, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;extensions, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantOrderCode)

#### Parameters

JVM

| | |
|---|---|
| payerId | Unique PayPal Customer Account identification number. |
| transactionId | Unique transaction number to identify Auth calls at PayPal. |
| merchantOrderCode | Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level. |
