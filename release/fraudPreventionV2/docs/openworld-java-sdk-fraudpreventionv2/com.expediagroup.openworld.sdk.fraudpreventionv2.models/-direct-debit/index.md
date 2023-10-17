//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[DirectDebit](index.md)

# DirectDebit

public final class [DirectDebit](index.md) implements [Payment](../-payment/index.md)

#### Parameters

JVM

| | |
|---|---|
| routingNumber | A code that identifies the financial institution for a specific bank account. |
| accountNumber | Cleartext (unencrypted) DirectDebit bank account number associated with the payment instrument. |
| telephones | Telephone(s) associated with direct debit payment provider. |

## Constructors

| | |
|---|---|
| [DirectDebit](-direct-debit.md) | [JVM]<br>public [DirectDebit](index.md)[DirectDebit](-direct-debit.md)([Payment.Brand](../-payment/-brand/index.md)brand, [Name](../-name/index.md)billingName, [PaymentBillingAddress](../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)routingNumber, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)accountNumber, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [PaymentReason](../-payment-reason/index.md)reason, [Amount](../-amount/index.md)authorizedAmount, [Amount](../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../-operations/index.md)operations) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [DirectDebit.Builder](-builder/index.md)[builder](builder.md)() |
| [getAccountNumber](get-account-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAccountNumber](get-account-number.md)() |
| [getAuthorizedAmount](get-authorized-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getAuthorizedAmount](get-authorized-amount.md)() |
| [getBillingAddress](get-billing-address.md) | [JVM]<br>public [PaymentBillingAddress](../-payment-billing-address/index.md)[getBillingAddress](get-billing-address.md)() |
| [getBillingEmailAddress](get-billing-email-address.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBillingEmailAddress](get-billing-email-address.md)() |
| [getBillingName](get-billing-name.md) | [JVM]<br>public [Name](../-name/index.md)[getBillingName](get-billing-name.md)() |
| [getBrand](get-brand.md) | [JVM]<br>public [Payment.Brand](../-payment/-brand/index.md)[getBrand](get-brand.md)() |
| [getMethod](get-method.md) | [JVM]<br>public [PaymentMethod](../-payment-method/index.md)[getMethod](get-method.md)() |
| [getOperations](get-operations.md) | [JVM]<br>public [Operations](../-operations/index.md)[getOperations](get-operations.md)() |
| [getReason](get-reason.md) | [JVM]<br>public [PaymentReason](../-payment-reason/index.md)[getReason](get-reason.md)() |
| [getRoutingNumber](get-routing-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRoutingNumber](get-routing-number.md)() |
| [getTelephones](get-telephones.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[getTelephones](get-telephones.md)() |
| [getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md) | [JVM]<br>public [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[getThreeDigitsSecureCriteria](get-three-digits-secure-criteria.md)() |
| [getVerifiedAmount](get-verified-amount.md) | [JVM]<br>public [Amount](../-amount/index.md)[getVerifiedAmount](get-verified-amount.md)() |

## Properties

| Name | Summary |
|---|---|
| [accountNumber](index.md#-403265686%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 100)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[accountNumber](index.md#-403265686%2FProperties%2F-1883119931) |
| [authorizedAmount](index.md#759035815%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[authorizedAmount](index.md#759035815%2FProperties%2F-1883119931) |
| [billingAddress](index.md#495587969%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentBillingAddress](../-payment-billing-address/index.md)[billingAddress](index.md#495587969%2FProperties%2F-1883119931) |
| [billingEmailAddress](index.md#276788429%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[billingEmailAddress](index.md#276788429%2FProperties%2F-1883119931) |
| [billingName](index.md#-509098406%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Name](../-name/index.md)[billingName](index.md#-509098406%2FProperties%2F-1883119931) |
| [brand](index.md#-37985319%2FProperties%2F-1883119931) | [JVM]<br>private final [Payment.Brand](../-payment/-brand/index.md)[brand](index.md#-37985319%2FProperties%2F-1883119931) |
| [method](index.md#-1154562919%2FProperties%2F-1883119931) | [JVM]<br>private final [PaymentMethod](../-payment-method/index.md)[method](index.md#-1154562919%2FProperties%2F-1883119931) |
| [operations](index.md#519346542%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Operations](../-operations/index.md)[operations](index.md#519346542%2FProperties%2F-1883119931) |
| [reason](index.md#2118469782%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentReason](../-payment-reason/index.md)[reason](index.md#2118469782%2FProperties%2F-1883119931) |
| [routingNumber](index.md#-1324466767%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 15)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[routingNumber](index.md#-1324466767%2FProperties%2F-1883119931) |
| [telephones](index.md#1007041995%2FProperties%2F-1883119931) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[telephones](index.md#1007041995%2FProperties%2F-1883119931) |
| [threeDigitsSecureCriteria](index.md#1072458246%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)[threeDigitsSecureCriteria](index.md#1072458246%2FProperties%2F-1883119931) |
| [verifiedAmount](index.md#1088936986%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[verifiedAmount](index.md#1088936986%2FProperties%2F-1883119931) |