//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[RemediationUpdateAction](../index.md)/[ActionName](index.md)/[getEntries](get-entries.md)

# getEntries

[JVM]\

public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[RemediationUpdateAction.ActionName](index.md)&gt;[getEntries](get-entries.md)()

The categorized remediation action initiated by the Partner''s system to a user. Possible values are: - `PASSWORD_RESET` - Applicable if this event is the result of a password reset by the Partner''s system. - `DISABLE_ACCOUNT` - Applicable if this event is the result of disabling an account by the Partner''s system. - `TERMINATE_ALL_SESSIONS` - Applicable if this event is the result of terminating all active user sessions of an account by the Partner''s system. Values: PASSWORD_RESET,DISABLE_ACCOUNT,TERMINATE_ALL_SESSIONS
