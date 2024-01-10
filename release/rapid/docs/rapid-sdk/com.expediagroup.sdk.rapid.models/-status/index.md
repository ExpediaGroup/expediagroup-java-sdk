//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Status](index.md)

# Status

[JVM]\
public enum [Status](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Status](index.md)&gt;

Indicates the status of the rate. If the rate is still available then available will be returned. If the rate is no longer available at that price then price_changed will be returned. If the rate is no longer available at all then sold_out will be returned. Values: AVAILABLE,PRICE_CHANGED,SOLD_OUT

## Entries

| | |
|---|---|
| [AVAILABLE](-a-v-a-i-l-a-b-l-e/index.md) | [JVM]<br>[AVAILABLE](-a-v-a-i-l-a-b-l-e/index.md) |
| [PRICE_CHANGED](-p-r-i-c-e_-c-h-a-n-g-e-d/index.md) | [JVM]<br>[PRICE_CHANGED](-p-r-i-c-e_-c-h-a-n-g-e-d/index.md) |
| [SOLD_OUT](-s-o-l-d_-o-u-t/index.md) | [JVM]<br>[SOLD_OUT](-s-o-l-d_-o-u-t/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-523510335%2FProperties%2F700308213) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[Status](index.md)&gt;[entries](index.md#-523510335%2FProperties%2F700308213)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#-1970834176%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#-1970834176%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[Status](index.md)&gt;[getEntries](get-entries.md)()<br>Indicates the status of the rate. If the rate is still available then available will be returned. If the rate is no longer available at that price then price_changed will be returned. If the rate is no longer available at all then sold_out will be returned. Values: AVAILABLE,PRICE_CHANGED,SOLD_OUT |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [Status](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Status](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
