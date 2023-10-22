//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[PayPal](index.md)

# PayPal

public final class [PayPal](index.md) implements [Payment](../-payment/index.md)

#### Parameters

JVM

| | |
|---|---|
| payerId | Unique PayPal Customer Account identification number. |
| transactionId | Unique transaction number to identify Auth calls at PayPal. |
| merchantOrderCode | Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level. |

## Constructors

| | |
|---|---|
| [PayPal](-pay-pal.md) | [JVM]<br>public [PayPal](index.md)[PayPal](-pay-pal.md)([Payment.Brand](../-payment/-brand/index.md)brand, [Name](../-name/index.md)billingName, [PaymentBillingAddress](../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)payerId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)transactionId, [PaymentReason](../-payment-reason/index.md)reason, [Amount](../-amount/index.md)authorizedAmount, [Amount](../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../-operations/index.md)operations, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantOrderCode) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [authorizedAmount](index.md#-2111629077%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[authorizedAmount](index.md#-2111629077%2FProperties%2F-173342751) |
| [billingAddress](index.md#1091482821%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [PaymentBillingAddress](../-payment-billing-address/index.md)[billingAddress](index.md#1091482821%2FProperties%2F-173342751) |
| [billingEmailAddress](index.md#1687788809%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[billingEmailAddress](index.md#1687788809%2FProperties%2F-173342751) |
| [billingName](index.md#-1977881962%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Name](../-name/index.md)[billingName](index.md#-1977881962%2FProperties%2F-173342751) |
| [brand](index.md#-2009111275%2FProperties%2F-173342751) | [JVM]<br>private final [Payment.Brand](../-payment/-brand/index.md)[brand](index.md#-2009111275%2FProperties%2F-173342751) |
| [merchantOrderCode](index.md#-1031585239%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[merchantOrderCode](index.md#-1031585239%2FProperties%2F-173342751) |
| [method](index.md#-2129925411%2FProperties%2F-173342751) | [JVM]<br>private final [PaymentMethod](../-payment-method/index.md)[method](index.md#-2129925411%2FProperties%2F-173342751) |
| [operations](index.md#-913506894%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Operations](../-operations/index.md)[operations](index.md#-913506894%2FProperties%2F-173342751) |
| [payerId](index.md#1968461228%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[payerId](index.md#1968461228%2FProperties%2F-173342751) |
| [reason](index.md#1143107290%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [PaymentReason](../-payment-reason/index.md)[reason](index.md#1143107290%2FProperties%2F-173342751) |
| [threeDigitsSecureCriteria](index.md#-138513086%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[threeDigitsSecureCriteria](index.md#-138513086%2FProperties%2F-173342751) |
| [transactionId](index.md#-1152672445%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[transactionId](index.md#-1152672445%2FProperties%2F-173342751) |
| [verifiedAmount](index.md#1684831838%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[verifiedAmount](index.md#1684831838%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PayPal.Builder](-builder/index.md)[builder](builder.md)() |
| [getAuthorizedAmount](get-authorized-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getAuthorizedAmount](get-authorized-amount.md)() |
| [getBillingAddress](get-billing-address.md) | [JVM]<br>public [PaymentBillingAddress](../-payment-billing-address/index.md)[getBillingAddress](get-billing-address.md)() |
| [getBillingEmailAddress](get-billing-email-address.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBillingEmailAddress](get-billing-email-address.md)() |
| [getBillingName](get-billing-name.md) | [JVM]<br>public [Name](../-name/index.md)[getBillingName](get-billing-name.md)() |
| [getBrand](get-brand.md) | [JVM]<br>public [Payment.Brand](../-payment/-brand/index.md)[getBrand](get-brand.md)() |
| [getMerchantOrderCode](get-merchant-order-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMerchantOrderCode](get-merchant-order-code.md)() |
| [getMethod](get-method.md) | [JVM]<br>public [PaymentMethod](../-payment-method/index.md)[getMethod](get-method.md)() |
| [getOperations](get-operations.md) | [JVM]<br>public [Operations](../-operations/index.md)[getOperations](get-operations.md)() |
| [getPayerId](get-payer-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPayerId](get-payer-id.md)() |
| [getReason](get-reason.md) | [JVM]<br>public [PaymentReason](../-payment-reason/index.md)[getReason](get-reason.md)() |
| [getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md) | [JVM]<br>public [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md)() |
| [getTransactionId](get-transaction-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTransactionId](get-transaction-id.md)() |
| [getVerifiedAmount](get-verified-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getVerifiedAmount](get-verified-amount.md)() |
