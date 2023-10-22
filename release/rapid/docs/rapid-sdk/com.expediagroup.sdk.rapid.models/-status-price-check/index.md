//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[StatusPriceCheck](index.md)

# StatusPriceCheck

[JVM]\
public enum [StatusPriceCheck](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[StatusPriceCheck](index.md)&gt;

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
| [entries](index.md#-1871493630%2FProperties%2F700308213) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[StatusPriceCheck](index.md)&gt;[entries](index.md#-1871493630%2FProperties%2F700308213)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [name](../-unavailable-reason/-code/-n-o_-i-n-v-e-n-t-o-r-y_-a-v-a-i-l-a-b-l-e/index.md#-372974862%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../-unavailable-reason/-code/-n-o_-i-n-v-e-n-t-o-r-y_-a-v-a-i-l-a-b-l-e/index.md#-372974862%2FProperties%2F700308213) |
| [ordinal](../-unavailable-reason/-code/-n-o_-i-n-v-e-n-t-o-r-y_-a-v-a-i-l-a-b-l-e/index.md#-739389684%2FProperties%2F700308213) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../-unavailable-reason/-code/-n-o_-i-n-v-e-n-t-o-r-y_-a-v-a-i-l-a-b-l-e/index.md#-739389684%2FProperties%2F700308213) |
| [value](-s-o-l-d_-o-u-t/index.md#767424897%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-s-o-l-d_-o-u-t/index.md#767424897%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[StatusPriceCheck](index.md)&gt;[getEntries](get-entries.md)()<br>Indicates the status of the rate. If the rate is still available then available will be returned. If the rate is no longer available at that price then price_changed will be returned. If the rate is no longer available at all then sold_out will be returned. Values: AVAILABLE,PRICE_CHANGED,SOLD_OUT |
| [getName](index.md#-409829972%2FFunctions%2F700308213) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#-409829972%2FFunctions%2F700308213)() |
| [getOrdinal](index.md#821656082%2FFunctions%2F700308213) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#821656082%2FFunctions%2F700308213)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [StatusPriceCheck](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[StatusPriceCheck](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
