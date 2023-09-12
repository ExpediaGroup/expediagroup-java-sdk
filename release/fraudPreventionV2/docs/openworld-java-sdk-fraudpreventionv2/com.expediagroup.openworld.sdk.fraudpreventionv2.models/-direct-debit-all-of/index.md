//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[DirectDebitAllOf](index.md)

# DirectDebitAllOf

public final class [DirectDebitAllOf](index.md)

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
| [DirectDebitAllOf](-direct-debit-all-of.md) | [JVM]<br>public [DirectDebitAllOf](index.md)[DirectDebitAllOf](-direct-debit-all-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)routingNumber, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)accountNumber, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [DirectDebitAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getAccountNumber](get-account-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAccountNumber](get-account-number.md)() |
| [getRoutingNumber](get-routing-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRoutingNumber](get-routing-number.md)() |
| [getTelephones](get-telephones.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[getTelephones](get-telephones.md)() |

## Properties

| Name | Summary |
|---|---|
| [accountNumber](index.md#716132874%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 100)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[accountNumber](index.md#716132874%2FProperties%2F-1883119931) |
| [routingNumber](index.md#-205068207%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 15)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[routingNumber](index.md#-205068207%2FProperties%2F-1883119931) |
| [telephones](index.md#418289451%2FProperties%2F-1883119931) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[telephones](index.md#418289451%2FProperties%2F-1883119931) |
