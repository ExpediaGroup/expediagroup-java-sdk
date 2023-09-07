//[openworld-java-sdk-fraudpreventionv2](../../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../../index.md)/[LoginTransactionDetails](../index.md)/[AuthenticationType](index.md)

# AuthenticationType

[JVM]\
public enum [AuthenticationType](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[LoginTransactionDetails.AuthenticationType](index.md)&gt;

The type of login authentication method used by a user. For `authentication_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_type` is an enum value with the following mapping with `authentication_sub_type` attribute: *       authentication_type       :     authentication_sub_type * ------------------------------------------------------------------------------- * `CREDENTIALS`                         : `EMAIL` * `CREDENTIALS`                         : * `PASSWORD_RESET`                      : `EMAIL` * `SINGLE_SIGN_ON`                      : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `PHONE` * `SOCIAL`                              : `GOOGLE` * `SOCIAL`                              : `FACEBOOK` * `SOCIAL`                              : `APPLE` Values: CREDENTIALS,PASSWORD_RESET,SOCIAL,SINGLE_SIGN_ON,MULTI_FACTOR_AUTHENTICATION

## Entries

| | |
|---|---|
| [CREDENTIALS](-c-r-e-d-e-n-t-i-a-l-s/index.md) | [JVM]<br>[CREDENTIALS](-c-r-e-d-e-n-t-i-a-l-s/index.md) |
| [PASSWORD_RESET](-p-a-s-s-w-o-r-d_-r-e-s-e-t/index.md) | [JVM]<br>[PASSWORD_RESET](-p-a-s-s-w-o-r-d_-r-e-s-e-t/index.md) |
| [SOCIAL](-s-o-c-i-a-l/index.md) | [JVM]<br>[SOCIAL](-s-o-c-i-a-l/index.md) |
| [SINGLE_SIGN_ON](-s-i-n-g-l-e_-s-i-g-n_-o-n/index.md) | [JVM]<br>[SINGLE_SIGN_ON](-s-i-n-g-l-e_-s-i-g-n_-o-n/index.md) |
| [MULTI_FACTOR_AUTHENTICATION](-m-u-l-t-i_-f-a-c-t-o-r_-a-u-t-h-e-n-t-i-c-a-t-i-o-n/index.md) | [JVM]<br>[MULTI_FACTOR_AUTHENTICATION](-m-u-l-t-i_-f-a-c-t-o-r_-a-u-t-h-e-n-t-i-c-a-t-i-o-n/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getName](index.md#-595283574%2FFunctions%2F-1883119931) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#-595283574%2FFunctions%2F-1883119931)() |
| [getOrdinal](index.md#-698658444%2FFunctions%2F-1883119931) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#-698658444%2FFunctions%2F-1883119931)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [LoginTransactionDetails.AuthenticationType](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[LoginTransactionDetails.AuthenticationType](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) |
| [ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) |
| [value](-m-u-l-t-i_-f-a-c-t-o-r_-a-u-t-h-e-n-t-i-c-a-t-i-o-n/index.md#1867794609%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-m-u-l-t-i_-f-a-c-t-o-r_-a-u-t-h-e-n-t-i-c-a-t-i-o-n/index.md#1867794609%2FProperties%2F-1883119931) |
