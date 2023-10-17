//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[LoginTransactionDetails](index.md)/[getAuthenticationSubType](get-authentication-sub-type.md)

# getAuthenticationSubType

[JVM]\

public final [LoginTransactionDetails.AuthenticationSubType](-authentication-sub-type/index.md)[getAuthenticationSubType](get-authentication-sub-type.md)()

#### Parameters

JVM

| | |
|---|---|
| authenticationSubType | The sub type of login authentication method used by a user. For `authentication_sub_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_sub_type` is an enum value with the following mapping with `authentication_type` attribute: *       authentication_sub_type   :     authentication_type * ------------------------------------------------------------------------------- * `EMAIL`                               : `CREDENTIALS` * `EMAIL`                               : `PASSWORD_RESET` * `EMAIL`                               : `SINGLE_SIGN_ON` * `EMAIL`                               : `MULTI_FACTOR_AUTHENTICATION` * `PHONE`                               : `MULTI_FACTOR_AUTHENTICATION` * `GOOGLE`                              : `SOCIAL` * `FACEBOOK`                            : `SOCIAL` * `APPLE`                               : `SOCIAL` *                                       : `CREDENTIALS` |
