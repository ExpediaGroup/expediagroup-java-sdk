//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[MultiFactorAuthenticationAttempt](../index.md)/[Status](index.md)

# Status

[JVM]\
public enum [Status](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[MultiFactorAuthenticationAttempt.Status](index.md)&gt;

The status of a user''s response to the Multi-Factor Authentication initiated by the Partner''s system to the user.' - `SUCCESS` - Applicable if the user successfully passed the challenge. - `ABANDON` - Applicable if the user did not complete the challenge. - `FAILED` - Applicable if the user failed the challenge. Values: SUCCESS,ABANDON,FAILED

## Entries

| | |
|---|---|
| [SUCCESS](-s-u-c-c-e-s-s/index.md) | [JVM]<br>[SUCCESS](-s-u-c-c-e-s-s/index.md) |
| [ABANDON](-a-b-a-n-d-o-n/index.md) | [JVM]<br>[ABANDON](-a-b-a-n-d-o-n/index.md) |
| [FAILED](-f-a-i-l-e-d/index.md) | [JVM]<br>[FAILED](-f-a-i-l-e-d/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-662901338%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[MultiFactorAuthenticationAttempt.Status](index.md)&gt;[entries](index.md#-662901338%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-173342751) |
| [ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-173342751) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-173342751) |
| [value](-f-a-i-l-e-d/index.md#1318402597%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-f-a-i-l-e-d/index.md#1318402597%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[MultiFactorAuthenticationAttempt.Status](index.md)&gt;[getEntries](get-entries.md)()<br>The status of a user''s response to the Multi-Factor Authentication initiated by the Partner''s system to the user.' - `SUCCESS` - Applicable if the user successfully passed the challenge. - `ABANDON` - Applicable if the user did not complete the challenge. - `FAILED` - Applicable if the user failed the challenge. Values: SUCCESS,ABANDON,FAILED |
| [getName](index.md#-1134059290%2FFunctions%2F-173342751) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#-1134059290%2FFunctions%2F-173342751)() |
| [getOrdinal](index.md#-1073228648%2FFunctions%2F-173342751) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#-1073228648%2FFunctions%2F-173342751)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [MultiFactorAuthenticationAttempt.Status](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[MultiFactorAuthenticationAttempt.Status](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
