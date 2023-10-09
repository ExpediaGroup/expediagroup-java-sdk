//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[RemediationUpdateAction](index.md)

# RemediationUpdateAction

public final class [RemediationUpdateAction](index.md)

Information specific to the remediation action initiated by the Partner's system to a user.

#### Parameters

JVM

| | |
|---|---|
| actionName | The categorized remediation action initiated by the Partner''s system to a user. Possible values are: - `PASSWORD_RESET` - Applicable if this event is the result of a password reset by the Partner''s system. - `DISABLE_ACCOUNT` - Applicable if this event is the result of disabling an account by the Partner''s system. - `TERMINATE_ALL_SESSIONS` - Applicable if this event is the result of terminating all active user sessions of an account by the Partner''s system. |
| status | The status of the remediation action.   - `SUCCESS` - Applicable if the Partner''s system was successfully able to perform the remediation action.   - `FAILED` - Applicable if the Partner''s system failed to perform the remediation action. |
| updateEndDateTime | The local date and time the remediation action to a user ended in the Partner's system, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |

## Constructors

| | |
|---|---|
| [RemediationUpdateAction](-remediation-update-action.md) | [JVM]<br>public [RemediationUpdateAction](index.md)[RemediationUpdateAction](-remediation-update-action.md)([RemediationUpdateAction.ActionName](-action-name/index.md)actionName, [RemediationUpdateAction.Status](-status/index.md)status, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)updateEndDateTime) |

## Types

| Name | Summary |
|---|---|
| [ActionName](-action-name/index.md) | [JVM]<br>public enum [ActionName](-action-name/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RemediationUpdateAction.ActionName](-action-name/index.md)&gt;<br>The categorized remediation action initiated by the Partner''s system to a user. Possible values are: - `PASSWORD_RESET` - Applicable if this event is the result of a password reset by the Partner''s system. - `DISABLE_ACCOUNT` - Applicable if this event is the result of disabling an account by the Partner''s system. - `TERMINATE_ALL_SESSIONS` - Applicable if this event is the result of terminating all active user sessions of an account by the Partner''s system. Values: PASSWORD_RESET,DISABLE_ACCOUNT,TERMINATE_ALL_SESSIONS |
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Status](-status/index.md) | [JVM]<br>public enum [Status](-status/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RemediationUpdateAction.Status](-status/index.md)&gt;<br>The status of the remediation action.   - `SUCCESS` - Applicable if the Partner''s system was successfully able to perform the remediation action.   - `FAILED` - Applicable if the Partner''s system failed to perform the remediation action. Values: SUCCESS,FAILED |

## Properties

| Name | Summary |
|---|---|
| [actionName](index.md#-501345900%2FProperties%2F-173342751) | [JVM]<br>private final [RemediationUpdateAction.ActionName](-action-name/index.md)[actionName](index.md#-501345900%2FProperties%2F-173342751) |
| [status](index.md#1728902307%2FProperties%2F-173342751) | [JVM]<br>private final [RemediationUpdateAction.Status](-status/index.md)[status](index.md#1728902307%2FProperties%2F-173342751) |
| [updateEndDateTime](index.md#181839800%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[updateEndDateTime](index.md#181839800%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RemediationUpdateAction.Builder](-builder/index.md)[builder](builder.md)() |
| [getActionName](get-action-name.md) | [JVM]<br>public final [RemediationUpdateAction.ActionName](-action-name/index.md)[getActionName](get-action-name.md)() |
| [getStatus](get-status.md) | [JVM]<br>public final [RemediationUpdateAction.Status](-status/index.md)[getStatus](get-status.md)() |
| [getUpdateEndDateTime](get-update-end-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getUpdateEndDateTime](get-update-end-date-time.md)() |
