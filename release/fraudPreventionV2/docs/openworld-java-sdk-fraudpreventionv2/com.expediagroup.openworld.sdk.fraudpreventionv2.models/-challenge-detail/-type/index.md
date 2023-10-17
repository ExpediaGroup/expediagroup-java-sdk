//[openworld-java-sdk-fraudpreventionv2](../../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../../index.md)/[ChallengeDetail](../index.md)/[Type](index.md)

# Type

[JVM]\
public enum [Type](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[ChallengeDetail.Type](index.md)&gt;

The kind of challenge served by the Partner''s system to a user prior to calling Expedia''s Fraud Prevention Service. - `CAPTCHA` - Applicable if the challenge served by the Partner''s system was a Captcha challenge. - `TWO_FACTOR` - Applicable if the challenge served by the Partner''s system was a two-factor challenge including (Email verification, One Time Password, Okta, etc). Values: CAPTCHA,TWO_FACTOR

## Entries

| | |
|---|---|
| [CAPTCHA](-c-a-p-t-c-h-a/index.md) | [JVM]<br>[CAPTCHA](-c-a-p-t-c-h-a/index.md) |
| [TWO_FACTOR](-t-w-o_-f-a-c-t-o-r/index.md) | [JVM]<br>[TWO_FACTOR](-t-w-o_-f-a-c-t-o-r/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getName](index.md#-1941830295%2FFunctions%2F-1883119931) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#-1941830295%2FFunctions%2F-1883119931)() |
| [getOrdinal](index.md#-677479115%2FFunctions%2F-1883119931) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#-677479115%2FFunctions%2F-1883119931)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [ChallengeDetail.Type](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[ChallengeDetail.Type](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) |
| [ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) |
| [value](-t-w-o_-f-a-c-t-o-r/index.md#1137783696%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-t-w-o_-f-a-c-t-o-r/index.md#1137783696%2FProperties%2F-1883119931) |
