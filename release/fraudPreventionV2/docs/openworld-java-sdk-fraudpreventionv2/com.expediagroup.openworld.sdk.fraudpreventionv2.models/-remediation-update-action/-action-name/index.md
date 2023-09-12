//[openworld-java-sdk-fraudpreventionv2](../../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../../index.md)/[RemediationUpdateAction](../index.md)/[ActionName](index.md)

# ActionName

[JVM]\
public enum [ActionName](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RemediationUpdateAction.ActionName](index.md)&gt;

The categorized remediation action initiated by the Partner''s system to a user. Possible values are: - `PASSWORD_RESET` - Applicable if this event is the result of a password reset by the Partner''s system. - `DISABLE_ACCOUNT` - Applicable if this event is the result of disabling an account by the Partner''s system. - `TERMINATE_ALL_SESSIONS` - Applicable if this event is the result of terminating all active user sessions of an account by the Partner''s system. Values: PASSWORD_RESET,DISABLE_ACCOUNT,TERMINATE_ALL_SESSIONS

## Entries

| | |
|---|---|
| [PASSWORD_RESET](-p-a-s-s-w-o-r-d_-r-e-s-e-t/index.md) | [JVM]<br>[PASSWORD_RESET](-p-a-s-s-w-o-r-d_-r-e-s-e-t/index.md) |
| [DISABLE_ACCOUNT](-d-i-s-a-b-l-e_-a-c-c-o-u-n-t/index.md) | [JVM]<br>[DISABLE_ACCOUNT](-d-i-s-a-b-l-e_-a-c-c-o-u-n-t/index.md) |
| [TERMINATE_ALL_SESSIONS](-t-e-r-m-i-n-a-t-e_-a-l-l_-s-e-s-s-i-o-n-s/index.md) | [JVM]<br>[TERMINATE_ALL_SESSIONS](-t-e-r-m-i-n-a-t-e_-a-l-l_-s-e-s-s-i-o-n-s/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getName](index.md#-266344910%2FFunctions%2F-1883119931) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#-266344910%2FFunctions%2F-1883119931)() |
| [getOrdinal](index.md#1892678604%2FFunctions%2F-1883119931) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#1892678604%2FFunctions%2F-1883119931)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [RemediationUpdateAction.ActionName](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[RemediationUpdateAction.ActionName](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) |
| [ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) |
| [value](-t-e-r-m-i-n-a-t-e_-a-l-l_-s-e-s-s-i-o-n-s/index.md#1185517145%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-t-e-r-m-i-n-a-t-e_-a-l-l_-s-e-s-s-i-o-n-s/index.md#1185517145%2FProperties%2F-1883119931) |
