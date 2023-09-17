//[openworld-java-sdk-fraudpreventionv2](../../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../../index.md)/[LoginTransactionDetails](../index.md)/[AuthenticationSubType](index.md)

# AuthenticationSubType

[JVM]\
public enum [AuthenticationSubType](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[LoginTransactionDetails.AuthenticationSubType](index.md)&gt;

The sub type of login authentication method used by a user. For `authentication_sub_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_sub_type` is an enum value with the following mapping with `authentication_type` attribute: *       authentication_sub_type   :     authentication_type * ------------------------------------------------------------------------------- * `EMAIL`                               : `CREDENTIALS` * `EMAIL`                               : `PASSWORD_RESET` * `EMAIL`                               : `SINGLE_SIGN_ON` * `EMAIL`                               : `MULTI_FACTOR_AUTHENTICATION` * `PHONE`                               : `MULTI_FACTOR_AUTHENTICATION` * `GOOGLE`                              : `SOCIAL` * `FACEBOOK`                            : `SOCIAL` * `APPLE`                               : `SOCIAL` *                                       : `CREDENTIALS` Values: EMAIL,PHONE,GOOGLE,FACEBOOK,APPLE

## Entries

| | |
|---|---|
| [EMAIL](-e-m-a-i-l/index.md) | [JVM]<br>[EMAIL](-e-m-a-i-l/index.md) |
| [PHONE](-p-h-o-n-e/index.md) | [JVM]<br>[PHONE](-p-h-o-n-e/index.md) |
| [GOOGLE](-g-o-o-g-l-e/index.md) | [JVM]<br>[GOOGLE](-g-o-o-g-l-e/index.md) |
| [FACEBOOK](-f-a-c-e-b-o-o-k/index.md) | [JVM]<br>[FACEBOOK](-f-a-c-e-b-o-o-k/index.md) |
| [APPLE](-a-p-p-l-e/index.md) | [JVM]<br>[APPLE](-a-p-p-l-e/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getName](index.md#-744564328%2FFunctions%2F-1883119931) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#-744564328%2FFunctions%2F-1883119931)() |
| [getOrdinal](index.md#1664517798%2FFunctions%2F-1883119931) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#1664517798%2FFunctions%2F-1883119931)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [LoginTransactionDetails.AuthenticationSubType](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[LoginTransactionDetails.AuthenticationSubType](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) |
| [ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) |
| [value](-a-p-p-l-e/index.md#-1143215951%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-a-p-p-l-e/index.md#-1143215951%2FProperties%2F-1883119931) |
