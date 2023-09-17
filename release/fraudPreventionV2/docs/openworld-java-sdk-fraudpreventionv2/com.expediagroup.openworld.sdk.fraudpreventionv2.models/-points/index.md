//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[Points](index.md)

# Points

public final class [Points](index.md) implements [Payment](../-payment/index.md)

#### Parameters

JVM

| | |
|---|---|
| accountId | Points account id. |

## Constructors

| | |
|---|---|
| [Points](-points.md) | [JVM]<br>public [Points](index.md)[Points](-points.md)([Payment.Brand](../-payment/-brand/index.md)brand, [Name](../-name/index.md)billingName, [PaymentBillingAddress](../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)accountId, [PaymentReason](../-payment-reason/index.md)reason, [Amount](../-amount/index.md)authorizedAmount, [Amount](../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../-operations/index.md)operations) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Points.Builder](-builder/index.md)[builder](builder.md)() |
| [getAccountId](get-account-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAccountId](get-account-id.md)() |
| [getAuthorizedAmount](get-authorized-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getAuthorizedAmount](get-authorized-amount.md)() |
| [getBillingAddress](get-billing-address.md) | [JVM]<br>public [PaymentBillingAddress](../-payment-billing-address/index.md)[getBillingAddress](get-billing-address.md)() |
| [getBillingEmailAddress](get-billing-email-address.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBillingEmailAddress](get-billing-email-address.md)() |
| [getBillingName](get-billing-name.md) | [JVM]<br>public [Name](../-name/index.md)[getBillingName](get-billing-name.md)() |
| [getBrand](get-brand.md) | [JVM]<br>public [Payment.Brand](../-payment/-brand/index.md)[getBrand](get-brand.md)() |
| [getMethod](get-method.md) | [JVM]<br>public [PaymentMethod](../-payment-method/index.md)[getMethod](get-method.md)() |
| [getOperations](get-operations.md) | [JVM]<br>public [Operations](../-operations/index.md)[getOperations](get-operations.md)() |
| [getReason](get-reason.md) | [JVM]<br>public [PaymentReason](../-payment-reason/index.md)[getReason](get-reason.md)() |
| [getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md) | [JVM]<br>public [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md)() |
| [getVerifiedAmount](get-verified-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getVerifiedAmount](get-verified-amount.md)() |

## Properties

| Name | Summary |
|---|---|
| [accountId](index.md#1594692010%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[accountId](index.md#1594692010%2FProperties%2F-1883119931) |
| [authorizedAmount](index.md#1192973973%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[authorizedAmount](index.md#1192973973%2FProperties%2F-1883119931) |
| [billingAddress](index.md#527324399%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentBillingAddress](../-payment-billing-address/index.md)[billingAddress](index.md#527324399%2FProperties%2F-1883119931) |
| [billingEmailAddress](index.md#-123107553%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[billingEmailAddress](index.md#-123107553%2FProperties%2F-1883119931) |
| [billingName](index.md#615140012%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Name](../-name/index.md)[billingName](index.md#615140012%2FProperties%2F-1883119931) |
| [brand](index.md#1153764779%2FProperties%2F-1883119931) | [JVM]<br>private final [Payment.Brand](../-payment/-brand/index.md)[brand](index.md#1153764779%2FProperties%2F-1883119931) |
| [method](index.md#1429951751%2FProperties%2F-1883119931) | [JVM]<br>private final [PaymentMethod](../-payment-method/index.md)[method](index.md#1429951751%2FProperties%2F-1883119931) |
| [operations](index.md#-968408356%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Operations](../-operations/index.md)[operations](index.md#-968408356%2FProperties%2F-1883119931) |
| [reason](index.md#408017156%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentReason](../-payment-reason/index.md)[reason](index.md#408017156%2FProperties%2F-1883119931) |
| [threeDigitsSecureCriteria](index.md#41940696%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[threeDigitsSecureCriteria](index.md#41940696%2FProperties%2F-1883119931) |
| [verifiedAmount](index.md#1120673416%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[verifiedAmount](index.md#1120673416%2FProperties%2F-1883119931) |
