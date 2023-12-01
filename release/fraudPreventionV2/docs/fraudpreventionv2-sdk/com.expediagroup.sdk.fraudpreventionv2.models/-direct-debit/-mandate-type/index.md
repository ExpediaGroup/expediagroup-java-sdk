//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[DirectDebit](../index.md)/[MandateType](index.md)

# MandateType

[JVM]\
public enum [MandateType](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[DirectDebit.MandateType](index.md)&gt;

The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING` Values: ONE_OFF,RECURRING

## Entries

| | |
|---|---|
| [ONE_OFF](-o-n-e_-o-f-f/index.md) | [JVM]<br>[ONE_OFF](-o-n-e_-o-f-f/index.md) |
| [RECURRING](-r-e-c-u-r-r-i-n-g/index.md) | [JVM]<br>[RECURRING](-r-e-c-u-r-r-i-n-g/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-494160190%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[DirectDebit.MandateType](index.md)&gt;[entries](index.md#-494160190%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#1220254273%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#1220254273%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[DirectDebit.MandateType](index.md)&gt;[getEntries](get-entries.md)()<br>The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING` Values: ONE_OFF,RECURRING |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [DirectDebit.MandateType](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[DirectDebit.MandateType](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
