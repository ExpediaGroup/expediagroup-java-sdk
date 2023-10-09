//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[RemediationUpdateAction](index.md)/[RemediationUpdateAction](-remediation-update-action.md)

# RemediationUpdateAction

[JVM]\

public [RemediationUpdateAction](index.md)[RemediationUpdateAction](-remediation-update-action.md)([RemediationUpdateAction.ActionName](-action-name/index.md)actionName, [RemediationUpdateAction.Status](-status/index.md)status, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)updateEndDateTime)

#### Parameters

JVM

| | |
|---|---|
| actionName | The categorized remediation action initiated by the Partner''s system to a user. Possible values are: - `PASSWORD_RESET` - Applicable if this event is the result of a password reset by the Partner''s system. - `DISABLE_ACCOUNT` - Applicable if this event is the result of disabling an account by the Partner''s system. - `TERMINATE_ALL_SESSIONS` - Applicable if this event is the result of terminating all active user sessions of an account by the Partner''s system. |
| status | The status of the remediation action.   - `SUCCESS` - Applicable if the Partner''s system was successfully able to perform the remediation action.   - `FAILED` - Applicable if the Partner''s system failed to perform the remediation action. |
| updateEndDateTime | The local date and time the remediation action to a user ended in the Partner's system, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
