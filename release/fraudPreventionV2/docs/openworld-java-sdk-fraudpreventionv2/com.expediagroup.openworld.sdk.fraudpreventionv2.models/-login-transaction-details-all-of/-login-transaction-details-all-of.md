//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[LoginTransactionDetailsAllOf](index.md)/[LoginTransactionDetailsAllOf](-login-transaction-details-all-of.md)

# LoginTransactionDetailsAllOf

[JVM]\

public [LoginTransactionDetailsAllOf](index.md)[LoginTransactionDetailsAllOf](-login-transaction-details-all-of.md)([LoginTransactionDetailsAllOf.AuthenticationType](-authentication-type/index.md)authenticationType, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)successfulLoginFlag, [LoginTransactionDetailsAllOf.AuthenticationSubType](-authentication-sub-type/index.md)authenticationSubType, [LoginTransactionDetailsAllOf.FailedLoginReason](-failed-login-reason/index.md)failedLoginReason)

#### Parameters

JVM

| | |
|---|---|
| authenticationType | The type of login authentication method used by a user. For `authentication_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_type` is an enum value with the following mapping with `authentication_sub_type` attribute: *       authentication_type       :     authentication_sub_type * ------------------------------------------------------------------------------- * `CREDENTIALS`                         : `EMAIL` * `CREDENTIALS`                         : * `PASSWORD_RESET`                      : `EMAIL` * `SINGLE_SIGN_ON`                      : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `PHONE` * `SOCIAL`                              : `GOOGLE` * `SOCIAL`                              : `FACEBOOK` * `SOCIAL`                              : `APPLE` |
| successfulLoginFlag | Identifies if a login attempt by a user was successful or not. |
| authenticationSubType | The sub type of login authentication method used by a user. For `authentication_sub_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_sub_type` is an enum value with the following mapping with `authentication_type` attribute: *       authentication_sub_type   :     authentication_type * ------------------------------------------------------------------------------- * `EMAIL`                               : `CREDENTIALS` * `EMAIL`                               : `PASSWORD_RESET` * `EMAIL`                               : `SINGLE_SIGN_ON` * `EMAIL`                               : `MULTI_FACTOR_AUTHENTICATION` * `PHONE`                               : `MULTI_FACTOR_AUTHENTICATION` * `GOOGLE`                              : `SOCIAL` * `FACEBOOK`                            : `SOCIAL` * `APPLE`                               : `SOCIAL` *                                       : `CREDENTIALS` |
| failedLoginReason | The reason for the failed login attempt in the Partner''s system, related to user failure or Partner''s system failure. - `INVALID_CREDENTIALS` - Applicable if the user provided invalid login credentials for this login attempt. - `ACCOUNT_NOT_FOUND` - Applicable if the user attempted to login to an account that doesn't exist. - `VERIFICATION_FAILED` - Applicable if the user failed the verification for this login, or any authentication exception occured in the Partner system for this login attempt. - `ACCOUNT_LOCKED` - Applicable if the user attempted to login to an account that is locked. |
