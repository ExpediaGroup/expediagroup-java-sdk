//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[InternetBankPaymentAllOf](index.md)

# InternetBankPaymentAllOf

public final class [InternetBankPaymentAllOf](index.md)

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
| [InternetBankPaymentAllOf](-internet-bank-payment-all-of.md) | [JVM]<br>public [InternetBankPaymentAllOf](index.md)[InternetBankPaymentAllOf](-internet-bank-payment-all-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bankId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bankBranchCode, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [bankBranchCode](index.md#-228779377%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 15)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[bankBranchCode](index.md#-228779377%2FProperties%2F-173342751) |
| [bankId](index.md#-1867794781%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 15)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[bankId](index.md#-1867794781%2FProperties%2F-173342751) |
| [telephones](index.md#455199403%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[telephones](index.md#455199403%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [InternetBankPaymentAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getBankBranchCode](get-bank-branch-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBankBranchCode](get-bank-branch-code.md)() |
| [getBankId](get-bank-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBankId](get-bank-id.md)() |
| [getTelephones](get-telephones.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[getTelephones](get-telephones.md)() |
