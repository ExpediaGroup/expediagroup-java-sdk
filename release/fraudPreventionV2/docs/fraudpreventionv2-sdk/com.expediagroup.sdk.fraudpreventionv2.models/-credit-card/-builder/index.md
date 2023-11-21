//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[CreditCard](../index.md)/[Builder](index.md)

# Builder

[JVM]\
public final class [Builder](index.md)

## Constructors

| | |
|---|---|
| [CreditCard.Builder](-credit-card.-builder.md) | [JVM]<br>public [CreditCard.Builder](index.md)[CreditCard.Builder](-credit-card.-builder.md)([Payment.Brand](../../-payment/-brand/index.md)brand, [Name](../../-name/index.md)billingName, [PaymentBillingAddress](../../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [CreditCard.CardType](../-card-type/index.md)cardType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardNumber, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)expiryDate, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../../-telephone/index.md)&gt;telephones, [PaymentReason](../../-payment-reason/index.md)reason, [Amount](../../-amount/index.md)authorizedAmount, [Amount](../../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../../-operations/index.md)operations, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;extensions, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)electronicCommerceIndicator, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)virtualCreditCardFlag, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)walletType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardAvsResponse, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardCvvResponse, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantOrderCode, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)cardAuthenticationFailureCount) |

## Functions

| Name | Summary |
|---|---|
| [authorizedAmount](authorized-amount.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[authorizedAmount](authorized-amount.md)([Amount](../../-amount/index.md)authorizedAmount) |
| [billingAddress](billing-address.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[billingAddress](billing-address.md)([PaymentBillingAddress](../../-payment-billing-address/index.md)billingAddress) |
| [billingEmailAddress](billing-email-address.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[billingEmailAddress](billing-email-address.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress) |
| [billingName](billing-name.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[billingName](billing-name.md)([Name](../../-name/index.md)billingName) |
| [brand](brand.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[brand](brand.md)([Payment.Brand](../../-payment/-brand/index.md)brand) |
| [build](build.md) | [JVM]<br>public final [CreditCard](../index.md)[build](build.md)() |
| [cardAuthenticationFailureCount](card-authentication-failure-count.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[cardAuthenticationFailureCount](card-authentication-failure-count.md)([Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)cardAuthenticationFailureCount) |
| [cardAvsResponse](card-avs-response.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[cardAvsResponse](card-avs-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardAvsResponse) |
| [cardCvvResponse](card-cvv-response.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[cardCvvResponse](card-cvv-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardCvvResponse) |
| [cardNumber](card-number.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[cardNumber](card-number.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardNumber) |
| [cardType](card-type.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[cardType](card-type.md)([CreditCard.CardType](../-card-type/index.md)cardType) |
| [electronicCommerceIndicator](electronic-commerce-indicator.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[electronicCommerceIndicator](electronic-commerce-indicator.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)electronicCommerceIndicator) |
| [expiryDate](expiry-date.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[expiryDate](expiry-date.md)([OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)expiryDate) |
| [extensions](extensions.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[extensions](extensions.md)([Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;extensions) |
| [merchantOrderCode](merchant-order-code.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[merchantOrderCode](merchant-order-code.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantOrderCode) |
| [operations](operations.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[operations](operations.md)([Operations](../../-operations/index.md)operations) |
| [reason](reason.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[reason](reason.md)([PaymentReason](../../-payment-reason/index.md)reason) |
| [telephones](telephones.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[telephones](telephones.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../../-telephone/index.md)&gt;telephones) |
| [threeDigitsSecureCriteria](three-digits-secure-criteria.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[threeDigitsSecureCriteria](three-digits-secure-criteria.md)([PaymentThreeDSCriteria](../../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria) |
| [verifiedAmount](verified-amount.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[verifiedAmount](verified-amount.md)([Amount](../../-amount/index.md)verifiedAmount) |
| [virtualCreditCardFlag](virtual-credit-card-flag.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[virtualCreditCardFlag](virtual-credit-card-flag.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)virtualCreditCardFlag) |
| [walletType](wallet-type.md) | [JVM]<br>public final [CreditCard.Builder](index.md)[walletType](wallet-type.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)walletType) |
