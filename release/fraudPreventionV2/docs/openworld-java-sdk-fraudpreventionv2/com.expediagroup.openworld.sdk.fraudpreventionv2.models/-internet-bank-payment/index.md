//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[InternetBankPayment](index.md)

# InternetBankPayment

public final class [InternetBankPayment](index.md) implements [Payment](../-payment/index.md)

#### Parameters

JVM

| | |
|---|---|
| bankId | The bank_id provided by the internet bank payment(IBP) provider (DRWP aka NetGiro) for the bank used for processing the payment. |
| bankBranchCode | A code that identifies the bank branch for internet bank payment(IBP). |
| telephones | Telephone(s) associated with internet bank payment(IBP) provider. |

## Constructors

| | |
|---|---|
| [InternetBankPayment](-internet-bank-payment.md) | [JVM]<br>public [InternetBankPayment](index.md)[InternetBankPayment](-internet-bank-payment.md)([Payment.Brand](../-payment/-brand/index.md)brand, [Name](../-name/index.md)billingName, [PaymentBillingAddress](../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bankId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bankBranchCode, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [PaymentReason](../-payment-reason/index.md)reason, [Amount](../-amount/index.md)authorizedAmount, [Amount](../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../-operations/index.md)operations) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [InternetBankPayment.Builder](-builder/index.md)[builder](builder.md)() |
| [getAuthorizedAmount](get-authorized-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getAuthorizedAmount](get-authorized-amount.md)() |
| [getBankBranchCode](get-bank-branch-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBankBranchCode](get-bank-branch-code.md)() |
| [getBankId](get-bank-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBankId](get-bank-id.md)() |
| [getBillingAddress](get-billing-address.md) | [JVM]<br>public [PaymentBillingAddress](../-payment-billing-address/index.md)[getBillingAddress](get-billing-address.md)() |
| [getBillingEmailAddress](get-billing-email-address.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBillingEmailAddress](get-billing-email-address.md)() |
| [getBillingName](get-billing-name.md) | [JVM]<br>public [Name](../-name/index.md)[getBillingName](get-billing-name.md)() |
| [getBrand](get-brand.md) | [JVM]<br>public [Payment.Brand](../-payment/-brand/index.md)[getBrand](get-brand.md)() |
| [getMethod](get-method.md) | [JVM]<br>public [PaymentMethod](../-payment-method/index.md)[getMethod](get-method.md)() |
| [getOperations](get-operations.md) | [JVM]<br>public [Operations](../-operations/index.md)[getOperations](get-operations.md)() |
| [getReason](get-reason.md) | [JVM]<br>public [PaymentReason](../-payment-reason/index.md)[getReason](get-reason.md)() |
| [getTelephones](get-telephones.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[getTelephones](get-telephones.md)() |
| [getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md) | [JVM]<br>public [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md)() |
| [getVerifiedAmount](get-verified-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getVerifiedAmount](get-verified-amount.md)() |

## Properties

| Name | Summary |
|---|---|
| [authorizedAmount](index.md#-1229847859%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[authorizedAmount](index.md#-1229847859%2FProperties%2F-1883119931) |
| [bankBranchCode](index.md#-2000971179%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 15)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[bankBranchCode](index.md#-2000971179%2FProperties%2F-1883119931) |
| [bankId](index.md#328293481%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 15)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[bankId](index.md#328293481%2FProperties%2F-1883119931) |
| [billingAddress](index.md#1320333095%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentBillingAddress](../-payment-billing-address/index.md)[billingAddress](index.md#1320333095%2FProperties%2F-1883119931) |
| [billingEmailAddress](index.md#-1482895385%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[billingEmailAddress](index.md#-1482895385%2FProperties%2F-1883119931) |
| [billingName](index.md#1270274932%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Name](../-name/index.md)[billingName](index.md#1270274932%2FProperties%2F-1883119931) |
| [brand](index.md#-1851796365%2FProperties%2F-1883119931) | [JVM]<br>private final [Payment.Brand](../-payment/-brand/index.md)[brand](index.md#-1851796365%2FProperties%2F-1883119931) |
| [method](index.md#-1548130497%2FProperties%2F-1883119931) | [JVM]<br>private final [PaymentMethod](../-payment-method/index.md)[method](index.md#-1548130497%2FProperties%2F-1883119931) |
| [operations](index.md#-1501464300%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Operations](../-operations/index.md)[operations](index.md#-1501464300%2FProperties%2F-1883119931) |
| [reason](index.md#1724902204%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentReason](../-payment-reason/index.md)[reason](index.md#1724902204%2FProperties%2F-1883119931) |
| [telephones](index.md#-1013768847%2FProperties%2F-1883119931) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[telephones](index.md#-1013768847%2FProperties%2F-1883119931) |
| [threeDigitsSecureCriteria](index.md#-2084861536%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[threeDigitsSecureCriteria](index.md#-2084861536%2FProperties%2F-1883119931) |
| [verifiedAmount](index.md#1913682112%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[verifiedAmount](index.md#1913682112%2FProperties%2F-1883119931) |