//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.models](../../index.md)/[DepositDetail](../index.md)/[Type](index.md)

# Type

[JVM]\
public enum [Type](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[DepositDetail.Type](index.md)&gt;

Should be one of the following values: PERCENT The deposit amount is calculated as a percentage of the total booking cost. NIGHT The deposit amount is calculated in terms of nights plus tax. AMOUNT The deposit amount in USD. REMAINDER The deposit amount is equal to the booking cost minus any deposits that have been made before this point. Values: PERCENT,NIGHT,AMOUNT,REMAINDER

## Entries

| | |
|---|---|
| [PERCENT](-p-e-r-c-e-n-t/index.md) | [JVM]<br>[PERCENT](-p-e-r-c-e-n-t/index.md) |
| [NIGHT](-n-i-g-h-t/index.md) | [JVM]<br>[NIGHT](-n-i-g-h-t/index.md) |
| [AMOUNT](-a-m-o-u-n-t/index.md) | [JVM]<br>[AMOUNT](-a-m-o-u-n-t/index.md) |
| [REMAINDER](-r-e-m-a-i-n-d-e-r/index.md) | [JVM]<br>[REMAINDER](-r-e-m-a-i-n-d-e-r/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#1269663919%2FProperties%2F699445674) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[DepositDetail.Type](index.md)&gt;[entries](index.md#1269663919%2FProperties%2F699445674)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#-1441594514%2FProperties%2F699445674) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#-1441594514%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[DepositDetail.Type](index.md)&gt;[getEntries](get-entries.md)()<br>Should be one of the following values: PERCENT The deposit amount is calculated as a percentage of the total booking cost. NIGHT The deposit amount is calculated in terms of nights plus tax. AMOUNT The deposit amount in USD. REMAINDER The deposit amount is equal to the booking cost minus any deposits that have been made before this point. Values: PERCENT,NIGHT,AMOUNT,REMAINDER |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [DepositDetail.Type](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[DepositDetail.Type](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
