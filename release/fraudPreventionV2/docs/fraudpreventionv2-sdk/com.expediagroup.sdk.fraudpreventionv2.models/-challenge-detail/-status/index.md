//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[ChallengeDetail](../index.md)/[Status](index.md)

# Status

[JVM]\
public enum [Status](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[ChallengeDetail.Status](index.md)&gt;

The status of the challenge served by the Partner''s system to a user before calling Expedia''s Fraud Prevention Service. - `SUCCESS` - Applicable if the user successfully passed the challenge. - `FAILED` - Applicable if the user failed the challenge. Values: SUCCESS,FAILED

## Entries

| | |
|---|---|
| [SUCCESS](-s-u-c-c-e-s-s/index.md) | [JVM]<br>[SUCCESS](-s-u-c-c-e-s-s/index.md) |
| [FAILED](-f-a-i-l-e-d/index.md) | [JVM]<br>[FAILED](-f-a-i-l-e-d/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#1935322035%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[ChallengeDetail.Status](index.md)&gt;[entries](index.md#1935322035%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#1106581362%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#1106581362%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[ChallengeDetail.Status](index.md)&gt;[getEntries](get-entries.md)()<br>The status of the challenge served by the Partner''s system to a user before calling Expedia''s Fraud Prevention Service. - `SUCCESS` - Applicable if the user successfully passed the challenge. - `FAILED` - Applicable if the user failed the challenge. Values: SUCCESS,FAILED |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [ChallengeDetail.Status](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[ChallengeDetail.Status](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
