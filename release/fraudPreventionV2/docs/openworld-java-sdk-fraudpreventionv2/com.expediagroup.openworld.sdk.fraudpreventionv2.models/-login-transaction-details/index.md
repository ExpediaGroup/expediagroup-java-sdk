//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[LoginTransactionDetails](index.md)

# LoginTransactionDetails

public final class [LoginTransactionDetails](index.md) implements [AccountTakeoverTransactionDetails](../-account-takeover-transaction-details/index.md)

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
| [LoginTransactionDetails](-login-transaction-details.md) | [JVM]<br>public [LoginTransactionDetails](index.md)[LoginTransactionDetails](-login-transaction-details.md)([OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)transactionDateTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)transactionId, [LoginTransactionDetails.AuthenticationType](-authentication-type/index.md)authenticationType, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)successfulLoginFlag, [CurrentUserSession](../-current-user-session/index.md)currentUserSession, [LoginTransactionDetails.AuthenticationSubType](-authentication-sub-type/index.md)authenticationSubType, [LoginTransactionDetails.FailedLoginReason](-failed-login-reason/index.md)failedLoginReason) |

## Types

| Name | Summary |
|---|---|
| [AuthenticationSubType](-authentication-sub-type/index.md) | [JVM]<br>public enum [AuthenticationSubType](-authentication-sub-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[LoginTransactionDetails.AuthenticationSubType](-authentication-sub-type/index.md)&gt;<br>The sub type of login authentication method used by a user. For `authentication_sub_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_sub_type` is an enum value with the following mapping with `authentication_type` attribute: *       authentication_sub_type   :     authentication_type * ------------------------------------------------------------------------------- * `EMAIL`                               : `CREDENTIALS` * `EMAIL`                               : `PASSWORD_RESET` * `EMAIL`                               : `SINGLE_SIGN_ON` * `EMAIL`                               : `MULTI_FACTOR_AUTHENTICATION` * `PHONE`                               : `MULTI_FACTOR_AUTHENTICATION` * `GOOGLE`                              : `SOCIAL` * `FACEBOOK`                            : `SOCIAL` * `APPLE`                               : `SOCIAL` *                                       : `CREDENTIALS` Values: EMAIL,PHONE,GOOGLE,FACEBOOK,APPLE |
| [AuthenticationType](-authentication-type/index.md) | [JVM]<br>public enum [AuthenticationType](-authentication-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[LoginTransactionDetails.AuthenticationType](-authentication-type/index.md)&gt;<br>The type of login authentication method used by a user. For `authentication_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_type` is an enum value with the following mapping with `authentication_sub_type` attribute: *       authentication_type       :     authentication_sub_type * ------------------------------------------------------------------------------- * `CREDENTIALS`                         : `EMAIL` * `CREDENTIALS`                         : * `PASSWORD_RESET`                      : `EMAIL` * `SINGLE_SIGN_ON`                      : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `PHONE` * `SOCIAL`                              : `GOOGLE` * `SOCIAL`                              : `FACEBOOK` * `SOCIAL`                              : `APPLE` Values: CREDENTIALS,PASSWORD_RESET,SOCIAL,SINGLE_SIGN_ON,MULTI_FACTOR_AUTHENTICATION |
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [FailedLoginReason](-failed-login-reason/index.md) | [JVM]<br>public enum [FailedLoginReason](-failed-login-reason/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[LoginTransactionDetails.FailedLoginReason](-failed-login-reason/index.md)&gt;<br>The reason for the failed login attempt in the Partner''s system, related to user failure or Partner''s system failure. - `INVALID_CREDENTIALS` - Applicable if the user provided invalid login credentials for this login attempt. - `ACCOUNT_NOT_FOUND` - Applicable if the user attempted to login to an account that doesn't exist. - `VERIFICATION_FAILED` - Applicable if the user failed the verification for this login, or any authentication exception occured in the Partner system for this login attempt. - `ACCOUNT_LOCKED` - Applicable if the user attempted to login to an account that is locked. Values: INVALID_CREDENTIALS,ACCOUNT_NOT_FOUND,VERIFICATION_FAILED,ACCOUNT_LOCKED |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [LoginTransactionDetails.Builder](-builder/index.md)[builder](builder.md)() |
| [getAuthenticationSubType](get-authentication-sub-type.md) | [JVM]<br>public final [LoginTransactionDetails.AuthenticationSubType](-authentication-sub-type/index.md)[getAuthenticationSubType](get-authentication-sub-type.md)() |
| [getAuthenticationType](get-authentication-type.md) | [JVM]<br>public final [LoginTransactionDetails.AuthenticationType](-authentication-type/index.md)[getAuthenticationType](get-authentication-type.md)() |
| [getCurrentUserSession](get-current-user-session.md) | [JVM]<br>public [CurrentUserSession](../-current-user-session/index.md)[getCurrentUserSession](get-current-user-session.md)() |
| [getFailedLoginReason](get-failed-login-reason.md) | [JVM]<br>public final [LoginTransactionDetails.FailedLoginReason](-failed-login-reason/index.md)[getFailedLoginReason](get-failed-login-reason.md)() |
| [getSuccessfulLoginFlag](get-successful-login-flag.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getSuccessfulLoginFlag](get-successful-login-flag.md)() |
| [getTransactionDateTime](get-transaction-date-time.md) | [JVM]<br>public [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getTransactionDateTime](get-transaction-date-time.md)() |
| [getTransactionId](get-transaction-id.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTransactionId](get-transaction-id.md)() |
| [getType](get-type.md) | [JVM]<br>public [AccountTakeoverTransactionDetails.Type](../-account-takeover-transaction-details/-type/index.md)[getType](get-type.md)() |

## Properties

| Name | Summary |
|---|---|
| [authenticationSubType](index.md#-960628812%2FProperties%2F-1883119931) | [JVM]<br>private final [LoginTransactionDetails.AuthenticationSubType](-authentication-sub-type/index.md)[authenticationSubType](index.md#-960628812%2FProperties%2F-1883119931) |
| [authenticationType](index.md#-626213102%2FProperties%2F-1883119931) | [JVM]<br>private final [LoginTransactionDetails.AuthenticationType](-authentication-type/index.md)[authenticationType](index.md#-626213102%2FProperties%2F-1883119931) |
| [currentUserSession](index.md#-1919485998%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [CurrentUserSession](../-current-user-session/index.md)[currentUserSession](index.md#-1919485998%2FProperties%2F-1883119931) |
| [failedLoginReason](index.md#-929676954%2FProperties%2F-1883119931) | [JVM]<br>private final [LoginTransactionDetails.FailedLoginReason](-failed-login-reason/index.md)[failedLoginReason](index.md#-929676954%2FProperties%2F-1883119931) |
| [successfulLoginFlag](index.md#209306395%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[successfulLoginFlag](index.md#209306395%2FProperties%2F-1883119931) |
| [transactionDateTime](index.md#1118867773%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[transactionDateTime](index.md#1118867773%2FProperties%2F-1883119931) |
| [transactionId](index.md#-371733507%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[transactionId](index.md#-371733507%2FProperties%2F-1883119931) |
| [type](index.md#-596832534%2FProperties%2F-1883119931) | [JVM]<br>private final [AccountTakeoverTransactionDetails.Type](../-account-takeover-transaction-details/-type/index.md)[type](index.md#-596832534%2FProperties%2F-1883119931) |
