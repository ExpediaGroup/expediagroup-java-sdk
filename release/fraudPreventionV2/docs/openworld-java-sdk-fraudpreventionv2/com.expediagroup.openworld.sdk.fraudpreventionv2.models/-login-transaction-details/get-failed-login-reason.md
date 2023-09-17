//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[LoginTransactionDetails](index.md)/[getFailedLoginReason](get-failed-login-reason.md)

# getFailedLoginReason

[JVM]\

public final [LoginTransactionDetails.FailedLoginReason](-failed-login-reason/index.md)[getFailedLoginReason](get-failed-login-reason.md)()

#### Parameters

JVM

| | |
|---|---|
| failedLoginReason | The reason for the failed login attempt in the Partner''s system, related to user failure or Partner''s system failure. - `INVALID_CREDENTIALS` - Applicable if the user provided invalid login credentials for this login attempt. - `ACCOUNT_NOT_FOUND` - Applicable if the user attempted to login to an account that doesn't exist. - `VERIFICATION_FAILED` - Applicable if the user failed the verification for this login, or any authentication exception occured in the Partner system for this login attempt. - `ACCOUNT_LOCKED` - Applicable if the user attempted to login to an account that is locked. |
