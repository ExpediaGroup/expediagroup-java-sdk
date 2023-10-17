//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[LoginTransactionDetails](../index.md)/[FailedLoginReason](index.md)/[getEntries](get-entries.md)

# getEntries

[JVM]\

public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[LoginTransactionDetails.FailedLoginReason](index.md)&gt;[getEntries](get-entries.md)()

The reason for the failed login attempt in the Partner''s system, related to user failure or Partner''s system failure. - `INVALID_CREDENTIALS` - Applicable if the user provided invalid login credentials for this login attempt. - `ACCOUNT_NOT_FOUND` - Applicable if the user attempted to login to an account that doesn't exist. - `VERIFICATION_FAILED` - Applicable if the user failed the verification for this login, or any authentication exception occured in the Partner system for this login attempt. - `ACCOUNT_LOCKED` - Applicable if the user attempted to login to an account that is locked. Values: INVALID_CREDENTIALS,ACCOUNT_NOT_FOUND,VERIFICATION_FAILED,ACCOUNT_LOCKED
