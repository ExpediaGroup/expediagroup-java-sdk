//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[AccountTakeoverFraudDecision](index.md)

# AccountTakeoverFraudDecision

[JVM]\
public enum [AccountTakeoverFraudDecision](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AccountTakeoverFraudDecision](index.md)&gt;

Fraud recommendation for an account transaction. A recommendation can be ACCEPT, CHALLENGE, or REJECT. - `ACCEPT` - Represents an account transaction where the user’’s account activity is accepted. - `CHALLENGE` - Represents an account transaction that requires additional verification or challenges the user’’s identity (example: CAPTCHA, MULTI_FACTOR_AUTHENTICATION, etc). - `REJECT` - Represents a suspicious account transaction where the user’’s credentials or their behavior requires us to block the account activity. Values: ACCEPT,CHALLENGE,REJECT

## Entries

| | |
|---|---|
| [ACCEPT](-a-c-c-e-p-t/index.md) | [JVM]<br>[ACCEPT](-a-c-c-e-p-t/index.md) |
| [CHALLENGE](-c-h-a-l-l-e-n-g-e/index.md) | [JVM]<br>[CHALLENGE](-c-h-a-l-l-e-n-g-e/index.md) |
| [REJECT](-r-e-j-e-c-t/index.md) | [JVM]<br>[REJECT](-r-e-j-e-c-t/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-1413308537%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[AccountTakeoverFraudDecision](index.md)&gt;[entries](index.md#-1413308537%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [name](../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-173342751) |
| [ordinal](../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-173342751) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-173342751) |
| [value](-r-e-j-e-c-t/index.md#2108682310%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-r-e-j-e-c-t/index.md#2108682310%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[AccountTakeoverFraudDecision](index.md)&gt;[getEntries](get-entries.md)()<br>Fraud recommendation for an account transaction. A recommendation can be ACCEPT, CHALLENGE, or REJECT. - `ACCEPT` - Represents an account transaction where the user’’s account activity is accepted. - `CHALLENGE` - Represents an account transaction that requires additional verification or challenges the user’’s identity (example: CAPTCHA, MULTI_FACTOR_AUTHENTICATION, etc). - `REJECT` - Represents a suspicious account transaction where the user’’s credentials or their behavior requires us to block the account activity. Values: ACCEPT,CHALLENGE,REJECT |
| [getName](index.md#693944901%2FFunctions%2F-173342751) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#693944901%2FFunctions%2F-173342751)() |
| [getOrdinal](index.md#1109279449%2FFunctions%2F-173342751) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#1109279449%2FFunctions%2F-173342751)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [AccountTakeoverFraudDecision](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[AccountTakeoverFraudDecision](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
