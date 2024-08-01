//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.models](../../index.md)/[RateCalendar](../index.md)/[PriceLevel](index.md)

# PriceLevel

[JVM]\
public enum [PriceLevel](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RateCalendar.PriceLevel](index.md)&gt;

Indicates how that day's price compares to the other lowest price for that hotel over the searched date range. Prices will be bucketed into LOW/MEDIUM/HIGH. Here are the details for each `PriceLevel`: - HIGH: 65th percentile+ - MEDIUM: 30th Percentile+ - LOW: Anything lower than 30th percentile Values: HIGH,MEDIUM,LOW

## Entries

| | |
|---|---|
| [HIGH](-h-i-g-h/index.md) | [JVM]<br>[HIGH](-h-i-g-h/index.md) |
| [MEDIUM](-m-e-d-i-u-m/index.md) | [JVM]<br>[MEDIUM](-m-e-d-i-u-m/index.md) |
| [LOW](-l-o-w/index.md) | [JVM]<br>[LOW](-l-o-w/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#953243941%2FProperties%2F699445674) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[RateCalendar.PriceLevel](index.md)&gt;[entries](index.md#953243941%2FProperties%2F699445674)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#1539078500%2FProperties%2F699445674) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#1539078500%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[RateCalendar.PriceLevel](index.md)&gt;[getEntries](get-entries.md)()<br>Indicates how that day's price compares to the other lowest price for that hotel over the searched date range. Prices will be bucketed into LOW/MEDIUM/HIGH. Here are the details for each `PriceLevel`: - HIGH: 65th percentile+ - MEDIUM: 30th Percentile+ - LOW: Anything lower than 30th percentile Values: HIGH,MEDIUM,LOW |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [RateCalendar.PriceLevel](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[RateCalendar.PriceLevel](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
