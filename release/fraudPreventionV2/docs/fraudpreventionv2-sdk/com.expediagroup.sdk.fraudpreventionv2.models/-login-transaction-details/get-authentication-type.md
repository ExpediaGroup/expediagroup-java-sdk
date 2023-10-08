//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[LoginTransactionDetails](index.md)/[getAuthenticationType](get-authentication-type.md)

# getAuthenticationType

[JVM]\

public final [LoginTransactionDetails.AuthenticationType](-authentication-type/index.md)[getAuthenticationType](get-authentication-type.md)()

#### Parameters

JVM

| | |
|---|---|
| authenticationType | The type of login authentication method used by a user. For `authentication_type` ensure attributes mentioned in dictionary below are set to corresponding values only. `authentication_type` is an enum value with the following mapping with `authentication_sub_type` attribute: *       authentication_type       :     authentication_sub_type * ------------------------------------------------------------------------------- * `CREDENTIALS`                         : `EMAIL` * `CREDENTIALS`                         : * `PASSWORD_RESET`                      : `EMAIL` * `SINGLE_SIGN_ON`                      : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `EMAIL` * `MULTI_FACTOR_AUTHENTICATION`         : `PHONE` * `SOCIAL`                              : `GOOGLE` * `SOCIAL`                              : `FACEBOOK` * `SOCIAL`                              : `APPLE` |
