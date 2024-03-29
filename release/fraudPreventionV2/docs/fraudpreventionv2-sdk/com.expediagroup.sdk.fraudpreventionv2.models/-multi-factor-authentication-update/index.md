//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[MultiFactorAuthenticationUpdate](index.md)

# MultiFactorAuthenticationUpdate

public final class [MultiFactorAuthenticationUpdate](index.md) implements [AccountUpdateRequest](../-account-update-request/index.md)

Information specific to a user's response to a Multi-Factor Authentication initiated by the Partner's system as a result of a fraud recommendation.

#### Parameters

JVM

| |
|---|
| multiFactorAuthenticationAttempts |

## Constructors

| | |
|---|---|
| [MultiFactorAuthenticationUpdate](-multi-factor-authentication-update.md) | [JVM]<br>public [MultiFactorAuthenticationUpdate](index.md)[MultiFactorAuthenticationUpdate](-multi-factor-authentication-update.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)riskId, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[MultiFactorAuthenticationAttempt](../-multi-factor-authentication-attempt/index.md)&gt;multiFactorAuthenticationAttempts) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [multiFactorAuthenticationAttempts](index.md#205793946%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[MultiFactorAuthenticationAttempt](../-multi-factor-authentication-attempt/index.md)&gt;[multiFactorAuthenticationAttempts](index.md#205793946%2FProperties%2F-173342751) |
| [riskId](index.md#783164560%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[riskId](index.md#783164560%2FProperties%2F-173342751) |
| [type](index.md#1613861600%2FProperties%2F-173342751) | [JVM]<br>private final [AccountUpdateRequest.Type](../-account-update-request/-type/index.md)[type](index.md#1613861600%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [MultiFactorAuthenticationUpdate.Builder](-builder/index.md)[builder](builder.md)() |
| [getMultiFactorAuthenticationAttempts](get-multi-factor-authentication-attempts.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[MultiFactorAuthenticationAttempt](../-multi-factor-authentication-attempt/index.md)&gt;[getMultiFactorAuthenticationAttempts](get-multi-factor-authentication-attempts.md)() |
| [getRiskId](get-risk-id.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRiskId](get-risk-id.md)() |
| [getType](get-type.md) | [JVM]<br>public [AccountUpdateRequest.Type](../-account-update-request/-type/index.md)[getType](get-type.md)() |
