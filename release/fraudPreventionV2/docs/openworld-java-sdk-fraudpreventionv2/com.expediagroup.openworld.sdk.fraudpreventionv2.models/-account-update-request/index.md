//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[AccountUpdateRequest](index.md)

# AccountUpdateRequest

public interface [AccountUpdateRequest](index.md)

The `type` field value is used as a discriminator, with the following mapping: * `MULTI_FACTOR_AUTHENTICATION_UPDATE`: `MultiFactorAuthenticationUpdate` * `REMEDIATION_UPDATE`: `RemediationUpdate`

#### Parameters

JVM

| | |
|---|---|
| type | The categorized type of account update event from the Partner's system. |
| riskId | The `risk_id` provided by Expedia's Fraud Prevention Service in the `AccountScreenResponse`. |

#### Inheritors

| |
|---|
| [MultiFactorAuthenticationUpdate](../-multi-factor-authentication-update/index.md) |
| [RemediationUpdate](../-remediation-update/index.md) |

## Types

| Name | Summary |
|---|---|
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AccountUpdateRequest.Type](-type/index.md)&gt;<br>The categorized type of account update event from the Partner's system. Values: MULTI_FACTOR_AUTHENTICATION_UPDATE,REMEDIATION_UPDATE |

## Functions

| Name | Summary |
|---|---|
| [getRiskId](get-risk-id.md) | [JVM]<br>public abstract [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRiskId](get-risk-id.md)() |
| [getType](get-type.md) | [JVM]<br>public abstract [AccountUpdateRequest.Type](-type/index.md)[getType](get-type.md)() |
