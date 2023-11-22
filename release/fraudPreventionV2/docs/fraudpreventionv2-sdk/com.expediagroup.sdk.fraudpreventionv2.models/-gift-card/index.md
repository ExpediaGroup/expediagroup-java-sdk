//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[GiftCard](index.md)

# GiftCard

public final class [GiftCard](index.md) implements [Payment](../-payment/index.md)

#### Parameters

JVM

| | |
|---|---|
| cardNumber | Gift card number. |
| cardHolderName | The name of gift card holder. |
| pin | The PIN of gift card. |

## Constructors

| | |
|---|---|
| [GiftCard](-gift-card.md) | [JVM]<br>public [GiftCard](index.md)[GiftCard](-gift-card.md)([Payment.Brand](../-payment/-brand/index.md)brand, [Name](../-name/index.md)billingName, [PaymentBillingAddress](../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardNumber, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardHolderName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)pin, [PaymentReason](../-payment-reason/index.md)reason, [Amount](../-amount/index.md)authorizedAmount, [Amount](../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../-operations/index.md)operations, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;extensions) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [authorizedAmount](index.md#570076920%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[authorizedAmount](index.md#570076920%2FProperties%2F-173342751) |
| [billingAddress](index.md#1576954386%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [PaymentBillingAddress](../-payment-billing-address/index.md)[billingAddress](index.md#1576954386%2FProperties%2F-173342751) |
| [billingEmailAddress](index.md#1704472540%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[billingEmailAddress](index.md#1704472540%2FProperties%2F-173342751) |
| [billingName](index.md#-174587799%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Name](../-name/index.md)[billingName](index.md#-174587799%2FProperties%2F-173342751) |
| [brand](index.md#1890129192%2FProperties%2F-173342751) | [JVM]<br>private final [Payment.Brand](../-payment/-brand/index.md)[brand](index.md#1890129192%2FProperties%2F-173342751) |
| [cardHolderName](index.md#426712388%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cardHolderName](index.md#426712388%2FProperties%2F-173342751) |
| [cardNumber](index.md#-1833038958%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[0-9A-Za-z]{4,16}$&quot;)<br>@Length(max = 16)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cardNumber](index.md#-1833038958%2FProperties%2F-173342751) |
| [extensions](index.md#-1728427433%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[extensions](index.md#-1728427433%2FProperties%2F-173342751) |
| [method](index.md#-1512555222%2FProperties%2F-173342751) | [JVM]<br>private final [PaymentMethod](../-payment-method/index.md)[method](index.md#-1512555222%2FProperties%2F-173342751) |
| [operations](index.md#807231871%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Operations](../-operations/index.md)[operations](index.md#807231871%2FProperties%2F-173342751) |
| [pin](index.md#-1864525990%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[0-9]{4,8}$&quot;)<br>@Length(max = 8)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[pin](index.md#-1864525990%2FProperties%2F-173342751) |
| [reason](index.md#1760477479%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [PaymentReason](../-payment-reason/index.md)[reason](index.md#1760477479%2FProperties%2F-173342751) |
| [threeDigitsSecureCriteria](index.md#-1446355499%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[threeDigitsSecureCriteria](index.md#-1446355499%2FProperties%2F-173342751) |
| [verifiedAmount](index.md#-2124663893%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[verifiedAmount](index.md#-2124663893%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [GiftCard.Builder](-builder/index.md)[builder](builder.md)() |
| [getAuthorizedAmount](get-authorized-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getAuthorizedAmount](get-authorized-amount.md)() |
| [getBillingAddress](get-billing-address.md) | [JVM]<br>public [PaymentBillingAddress](../-payment-billing-address/index.md)[getBillingAddress](get-billing-address.md)() |
| [getBillingEmailAddress](get-billing-email-address.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBillingEmailAddress](get-billing-email-address.md)() |
| [getBillingName](get-billing-name.md) | [JVM]<br>public [Name](../-name/index.md)[getBillingName](get-billing-name.md)() |
| [getBrand](get-brand.md) | [JVM]<br>public [Payment.Brand](../-payment/-brand/index.md)[getBrand](get-brand.md)() |
| [getCardHolderName](get-card-holder-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCardHolderName](get-card-holder-name.md)() |
| [getCardNumber](get-card-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCardNumber](get-card-number.md)() |
| [getExtensions](get-extensions.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getExtensions](get-extensions.md)() |
| [getMethod](get-method.md) | [JVM]<br>public [PaymentMethod](../-payment-method/index.md)[getMethod](get-method.md)() |
| [getOperations](get-operations.md) | [JVM]<br>public [Operations](../-operations/index.md)[getOperations](get-operations.md)() |
| [getPin](get-pin.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPin](get-pin.md)() |
| [getReason](get-reason.md) | [JVM]<br>public [PaymentReason](../-payment-reason/index.md)[getReason](get-reason.md)() |
| [getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md) | [JVM]<br>public [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md)() |
| [getVerifiedAmount](get-verified-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getVerifiedAmount](get-verified-amount.md)() |
