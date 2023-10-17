//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[RemediationUpdate](index.md)

# RemediationUpdate

public final class [RemediationUpdate](index.md) implements [AccountUpdateRequest](../-account-update-request/index.md)

Information specific to remediation actions initiated by the Partner's system to a user as a result of a fraud recommendation.

#### Parameters

JVM

| |
|---|
| remediationUpdateActions |

## Constructors

| | |
|---|---|
| [RemediationUpdate](-remediation-update.md) | [JVM]<br>public [RemediationUpdate](index.md)[RemediationUpdate](-remediation-update.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)riskId, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RemediationUpdateAction](../-remediation-update-action/index.md)&gt;remediationUpdateActions) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [remediationUpdateActions](index.md#-1823285936%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RemediationUpdateAction](../-remediation-update-action/index.md)&gt;[remediationUpdateActions](index.md#-1823285936%2FProperties%2F-173342751) |
| [riskId](index.md#-1467213387%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[riskId](index.md#-1467213387%2FProperties%2F-173342751) |
| [type](index.md#-1159426747%2FProperties%2F-173342751) | [JVM]<br>private final [AccountUpdateRequest.Type](../-account-update-request/-type/index.md)[type](index.md#-1159426747%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RemediationUpdate.Builder](-builder/index.md)[builder](builder.md)() |
| [getRemediationUpdateActions](get-remediation-update-actions.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RemediationUpdateAction](../-remediation-update-action/index.md)&gt;[getRemediationUpdateActions](get-remediation-update-actions.md)() |
| [getRiskId](get-risk-id.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRiskId](get-risk-id.md)() |
| [getType](get-type.md) | [JVM]<br>public [AccountUpdateRequest.Type](../-account-update-request/-type/index.md)[getType](get-type.md)() |
