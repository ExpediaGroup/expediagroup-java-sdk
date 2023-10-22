//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.models](../../index.md)/[PaymentRequest](../index.md)/[Type](index.md)

# Type

[JVM]\
public enum [Type](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[PaymentRequest.Type](index.md)&gt;

Identifier for the type of payment. If affiliate_collect, card information is not required as EPS will not be processing the payment. However, billing contact information is still required. Values: CORPORATE_CARD,CUSTOMER_CARD,VIRTUAL_CARD,AFFILIATE_COLLECT

## Entries

| | |
|---|---|
| [CORPORATE_CARD](-c-o-r-p-o-r-a-t-e_-c-a-r-d/index.md) | [JVM]<br>[CORPORATE_CARD](-c-o-r-p-o-r-a-t-e_-c-a-r-d/index.md) |
| [CUSTOMER_CARD](-c-u-s-t-o-m-e-r_-c-a-r-d/index.md) | [JVM]<br>[CUSTOMER_CARD](-c-u-s-t-o-m-e-r_-c-a-r-d/index.md) |
| [VIRTUAL_CARD](-v-i-r-t-u-a-l_-c-a-r-d/index.md) | [JVM]<br>[VIRTUAL_CARD](-v-i-r-t-u-a-l_-c-a-r-d/index.md) |
| [AFFILIATE_COLLECT](-a-f-f-i-l-i-a-t-e_-c-o-l-l-e-c-t/index.md) | [JVM]<br>[AFFILIATE_COLLECT](-a-f-f-i-l-i-a-t-e_-c-o-l-l-e-c-t/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-246885370%2FProperties%2F700308213) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[PaymentRequest.Type](index.md)&gt;[entries](index.md#-246885370%2FProperties%2F700308213)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [name](../../-unavailable-reason/-code/-n-o_-i-n-v-e-n-t-o-r-y_-a-v-a-i-l-a-b-l-e/index.md#-372974862%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../../-unavailable-reason/-code/-n-o_-i-n-v-e-n-t-o-r-y_-a-v-a-i-l-a-b-l-e/index.md#-372974862%2FProperties%2F700308213) |
| [ordinal](../../-unavailable-reason/-code/-n-o_-i-n-v-e-n-t-o-r-y_-a-v-a-i-l-a-b-l-e/index.md#-739389684%2FProperties%2F700308213) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../../-unavailable-reason/-code/-n-o_-i-n-v-e-n-t-o-r-y_-a-v-a-i-l-a-b-l-e/index.md#-739389684%2FProperties%2F700308213) |
| [value](-a-f-f-i-l-i-a-t-e_-c-o-l-l-e-c-t/index.md#1944533125%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-a-f-f-i-l-i-a-t-e_-c-o-l-l-e-c-t/index.md#1944533125%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[PaymentRequest.Type](index.md)&gt;[getEntries](get-entries.md)()<br>Identifier for the type of payment. If affiliate_collect, card information is not required as EPS will not be processing the payment. However, billing contact information is still required. Values: CORPORATE_CARD,CUSTOMER_CARD,VIRTUAL_CARD,AFFILIATE_COLLECT |
| [getName](index.md#2107595738%2FFunctions%2F700308213) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#2107595738%2FFunctions%2F700308213)() |
| [getOrdinal](index.md#-1267940060%2FFunctions%2F700308213) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#-1267940060%2FFunctions%2F700308213)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [PaymentRequest.Type](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[PaymentRequest.Type](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
