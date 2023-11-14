//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[DirectDebitAllOf](index.md)

# DirectDebitAllOf

public final class [DirectDebitAllOf](index.md)

#### Parameters

JVM

| | |
|---|---|
| accountNumber | Cleartext (unencrypted) DirectDebit bank account number associated with the payment instrument. |
| telephones | Telephone(s) associated with direct debit payment provider. |
| routingNumber | A code that identifies the financial institution for a specific bank account. `routing_number` is required if given `INTER_COMPANY` or `ELV` as `brand`. |
| mandateType | The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING` |

## Constructors

| | |
|---|---|
| [DirectDebitAllOf](-direct-debit-all-of.md) | [JVM]<br>public [DirectDebitAllOf](index.md)[DirectDebitAllOf](-direct-debit-all-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)accountNumber, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)routingNumber, [DirectDebitAllOf.MandateType](-mandate-type/index.md)mandateType) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [MandateType](-mandate-type/index.md) | [JVM]<br>public enum [MandateType](-mandate-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[DirectDebitAllOf.MandateType](-mandate-type/index.md)&gt;<br>The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING` Values: ONE_OFF,RECURRING |

## Properties

| Name | Summary |
|---|---|
| [accountNumber](index.md#-342028572%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 100)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[accountNumber](index.md#-342028572%2FProperties%2F-173342751) |
| [mandateType](index.md#-1102220264%2FProperties%2F-173342751) | [JVM]<br>private final [DirectDebitAllOf.MandateType](-mandate-type/index.md)[mandateType](index.md#-1102220264%2FProperties%2F-173342751) |
| [routingNumber](index.md#-1263229653%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 15)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[routingNumber](index.md#-1263229653%2FProperties%2F-173342751) |
| [telephones](index.md#881039505%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[telephones](index.md#881039505%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [DirectDebitAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getAccountNumber](get-account-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAccountNumber](get-account-number.md)() |
| [getMandateType](get-mandate-type.md) | [JVM]<br>public final [DirectDebitAllOf.MandateType](-mandate-type/index.md)[getMandateType](get-mandate-type.md)() |
| [getRoutingNumber](get-routing-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRoutingNumber](get-routing-number.md)() |
| [getTelephones](get-telephones.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[getTelephones](get-telephones.md)() |
