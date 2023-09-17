//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[LoginTransactionDetailsAllOf](index.md)

# LoginTransactionDetailsAllOf

public final class [LoginTransactionDetailsAllOf](index.md)

Specific information about a login transaction for a user.

#### Parameters

JVM

| | |
|---|---|
| authenticationType | The type of login authentication method used by a user. For `authentication_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_type` is an enum value with the following mapping with `authentication_sub_type` attribute: *       authentication_type       :     authentication_sub_type * ------------------------------------------------------------------------------- * `CREDENTIALS`                         : `EMAIL` * `CREDENTIALS`                         : * `PASSWORD_RESET`                      : `EMAIL` * `SINGLE_SIGN_ON`                      : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `PHONE` * `SOCIAL`                              : `GOOGLE` * `SOCIAL`                              : `FACEBOOK` * `SOCIAL`                              : `APPLE` |
| successfulLoginFlag | Identifies if a login attempt by a user was successful or not. |
| authenticationSubType | The sub type of login authentication method used by a user. For `authentication_sub_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_sub_type` is an enum value with the following mapping with `authentication_type` attribute: *       authentication_sub_type   :     authentication_type * ------------------------------------------------------------------------------- * `EMAIL`                               : `CREDENTIALS` * `EMAIL`                               : `PASSWORD_RESET` * `EMAIL`                               : `SINGLE_SIGN_ON` * `EMAIL`                               : `MULTI_FACTOR_AUTHENTICATION` * `PHONE`                               : `MULTI_FACTOR_AUTHENTICATION` * `GOOGLE`                              : `SOCIAL` * `FACEBOOK`                            : `SOCIAL` * `APPLE`                               : `SOCIAL` *                                       : `CREDENTIALS` |
| failedLoginReason | The reason for the failed login attempt in the Partner''s system, related to user failure or Partner''s system failure. - `INVALID_CREDENTIALS` - Applicable if the user provided invalid login credentials for this login attempt. - `ACCOUNT_NOT_FOUND` - Applicable if the user attempted to login to an account that doesn't exist. - `VERIFICATION_FAILED` - Applicable if the user failed the verification for this login, or any authentication exception occured in the Partner system for this login attempt. - `ACCOUNT_LOCKED` - Applicable if the user attempted to login to an account that is locked. |

## Constructors

| | |
|---|---|
| [LoginTransactionDetailsAllOf](-login-transaction-details-all-of.md) | [JVM]<br>public [LoginTransactionDetailsAllOf](index.md)[LoginTransactionDetailsAllOf](-login-transaction-details-all-of.md)([LoginTransactionDetailsAllOf.AuthenticationType](-authentication-type/index.md)authenticationType, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)successfulLoginFlag, [LoginTransactionDetailsAllOf.AuthenticationSubType](-authentication-sub-type/index.md)authenticationSubType, [LoginTransactionDetailsAllOf.FailedLoginReason](-failed-login-reason/index.md)failedLoginReason) |

## Types

| Name | Summary |
|---|---|
| [AuthenticationSubType](-authentication-sub-type/index.md) | [JVM]<br>public enum [AuthenticationSubType](-authentication-sub-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[LoginTransactionDetailsAllOf.AuthenticationSubType](-authentication-sub-type/index.md)&gt;<br>The sub type of login authentication method used by a user. For `authentication_sub_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_sub_type` is an enum value with the following mapping with `authentication_type` attribute: *       authentication_sub_type   :     authentication_type * ------------------------------------------------------------------------------- * `EMAIL`                               : `CREDENTIALS` * `EMAIL`                               : `PASSWORD_RESET` * `EMAIL`                               : `SINGLE_SIGN_ON` * `EMAIL`                               : `MULTI_FACTOR_AUTHENTICATION` * `PHONE`                               : `MULTI_FACTOR_AUTHENTICATION` * `GOOGLE`                              : `SOCIAL` * `FACEBOOK`                            : `SOCIAL` * `APPLE`                               : `SOCIAL` *                                       : `CREDENTIALS` Values: EMAIL,PHONE,GOOGLE,FACEBOOK,APPLE |
| [AuthenticationType](-authentication-type/index.md) | [JVM]<br>public enum [AuthenticationType](-authentication-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[LoginTransactionDetailsAllOf.AuthenticationType](-authentication-type/index.md)&gt;<br>The type of login authentication method used by a user. For `authentication_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_type` is an enum value with the following mapping with `authentication_sub_type` attribute: *       authentication_type       :     authentication_sub_type * ------------------------------------------------------------------------------- * `CREDENTIALS`                         : `EMAIL` * `CREDENTIALS`                         : * `PASSWORD_RESET`                      : `EMAIL` * `SINGLE_SIGN_ON`                      : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `PHONE` * `SOCIAL`                              : `GOOGLE` * `SOCIAL`                              : `FACEBOOK` * `SOCIAL`                              : `APPLE` Values: CREDENTIALS,PASSWORD_RESET,SOCIAL,SINGLE_SIGN_ON,MULTI_FACTOR_AUTHENTICATION |
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [FailedLoginReason](-failed-login-reason/index.md) | [JVM]<br>public enum [FailedLoginReason](-failed-login-reason/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[LoginTransactionDetailsAllOf.FailedLoginReason](-failed-login-reason/index.md)&gt;<br>The reason for the failed login attempt in the Partner''s system, related to user failure or Partner''s system failure. - `INVALID_CREDENTIALS` - Applicable if the user provided invalid login credentials for this login attempt. - `ACCOUNT_NOT_FOUND` - Applicable if the user attempted to login to an account that doesn't exist. - `VERIFICATION_FAILED` - Applicable if the user failed the verification for this login, or any authentication exception occured in the Partner system for this login attempt. - `ACCOUNT_LOCKED` - Applicable if the user attempted to login to an account that is locked. Values: INVALID_CREDENTIALS,ACCOUNT_NOT_FOUND,VERIFICATION_FAILED,ACCOUNT_LOCKED |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [LoginTransactionDetailsAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getAuthenticationSubType](get-authentication-sub-type.md) | [JVM]<br>public final [LoginTransactionDetailsAllOf.AuthenticationSubType](-authentication-sub-type/index.md)[getAuthenticationSubType](get-authentication-sub-type.md)() |
| [getAuthenticationType](get-authentication-type.md) | [JVM]<br>public final [LoginTransactionDetailsAllOf.AuthenticationType](-authentication-type/index.md)[getAuthenticationType](get-authentication-type.md)() |
| [getFailedLoginReason](get-failed-login-reason.md) | [JVM]<br>public final [LoginTransactionDetailsAllOf.FailedLoginReason](-failed-login-reason/index.md)[getFailedLoginReason](get-failed-login-reason.md)() |
| [getSuccessfulLoginFlag](get-successful-login-flag.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getSuccessfulLoginFlag](get-successful-login-flag.md)() |

## Properties

| Name | Summary |
|---|---|
| [authenticationSubType](index.md#1548521512%2FProperties%2F-1883119931) | [JVM]<br>private final [LoginTransactionDetailsAllOf.AuthenticationSubType](-authentication-sub-type/index.md)[authenticationSubType](index.md#1548521512%2FProperties%2F-1883119931) |
| [authenticationType](index.md#-497673442%2FProperties%2F-1883119931) | [JVM]<br>private final [LoginTransactionDetailsAllOf.AuthenticationType](-authentication-type/index.md)[authenticationType](index.md#-497673442%2FProperties%2F-1883119931) |
| [failedLoginReason](index.md#-1618267174%2FProperties%2F-1883119931) | [JVM]<br>private final [LoginTransactionDetailsAllOf.FailedLoginReason](-failed-login-reason/index.md)[failedLoginReason](index.md#-1618267174%2FProperties%2F-1883119931) |
| [successfulLoginFlag](index.md#-100931441%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[successfulLoginFlag](index.md#-100931441%2FProperties%2F-1883119931) |
