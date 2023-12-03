//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[TransactionDetails](../index.md)/[CurrentOrderStatus](index.md)

# CurrentOrderStatus

[JVM]\
public enum [CurrentOrderStatus](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[TransactionDetails.CurrentOrderStatus](index.md)&gt;

Status of the order: * `IN_PROGRESS` is used when order has not processed fully. For example, inventory has not yet been reserved, or payment has not yet been settled. * `COMPLETED` is used when an order has been processed fully. For example, inventory has been reserved, and the payment has been settled. Values: IN_PROGRESS,COMPLETED

## Entries

| | |
|---|---|
| [IN_PROGRESS](-i-n_-p-r-o-g-r-e-s-s/index.md) | [JVM]<br>[IN_PROGRESS](-i-n_-p-r-o-g-r-e-s-s/index.md) |
| [COMPLETED](-c-o-m-p-l-e-t-e-d/index.md) | [JVM]<br>[COMPLETED](-c-o-m-p-l-e-t-e-d/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#698522920%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[TransactionDetails.CurrentOrderStatus](index.md)&gt;[entries](index.md#698522920%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#2097472039%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#2097472039%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[TransactionDetails.CurrentOrderStatus](index.md)&gt;[getEntries](get-entries.md)()<br>Status of the order: * `IN_PROGRESS` is used when order has not processed fully. For example, inventory has not yet been reserved, or payment has not yet been settled. * `COMPLETED` is used when an order has been processed fully. For example, inventory has been reserved, and the payment has been settled. Values: IN_PROGRESS,COMPLETED |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [TransactionDetails.CurrentOrderStatus](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[TransactionDetails.CurrentOrderStatus](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
