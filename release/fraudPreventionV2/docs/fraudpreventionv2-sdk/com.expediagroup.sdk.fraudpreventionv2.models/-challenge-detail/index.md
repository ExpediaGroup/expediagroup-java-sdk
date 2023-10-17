//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[ChallengeDetail](index.md)

# ChallengeDetail

public final class [ChallengeDetail](index.md)

Information related to challenges initiated by the Partner's system to a user before calling Expedia's Fraud Prevention Service.

#### Parameters

JVM

| | |
|---|---|
| displayedFlag | Indicates that there was a challenge initiated by the Partner's system to a user before calling Expedia's Fraud Prevention Service. |
| type | The kind of challenge served by the Partner''s system to a user prior to calling Expedia''s Fraud Prevention Service. - `CAPTCHA` - Applicable if the challenge served by the Partner''s system was a Captcha challenge. - `TWO_FACTOR` - Applicable if the challenge served by the Partner''s system was a two-factor challenge including (Email verification, One Time Password, Okta, etc). |
| status | The status of the challenge served by the Partner''s system to a user before calling Expedia''s Fraud Prevention Service. - `SUCCESS` - Applicable if the user successfully passed the challenge. - `FAILED` - Applicable if the user failed the challenge. |

## Constructors

| | |
|---|---|
| [ChallengeDetail](-challenge-detail.md) | [JVM]<br>public [ChallengeDetail](index.md)[ChallengeDetail](-challenge-detail.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)displayedFlag, [ChallengeDetail.Type](-type/index.md)type, [ChallengeDetail.Status](-status/index.md)status) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Status](-status/index.md) | [JVM]<br>public enum [Status](-status/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[ChallengeDetail.Status](-status/index.md)&gt;<br>The status of the challenge served by the Partner''s system to a user before calling Expedia''s Fraud Prevention Service. - `SUCCESS` - Applicable if the user successfully passed the challenge. - `FAILED` - Applicable if the user failed the challenge. Values: SUCCESS,FAILED |
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[ChallengeDetail.Type](-type/index.md)&gt;<br>The kind of challenge served by the Partner''s system to a user prior to calling Expedia''s Fraud Prevention Service. - `CAPTCHA` - Applicable if the challenge served by the Partner''s system was a Captcha challenge. - `TWO_FACTOR` - Applicable if the challenge served by the Partner''s system was a two-factor challenge including (Email verification, One Time Password, Okta, etc). Values: CAPTCHA,TWO_FACTOR |

## Properties

| Name | Summary |
|---|---|
| [displayedFlag](index.md#-1158678936%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[displayedFlag](index.md#-1158678936%2FProperties%2F-173342751) |
| [status](index.md#1760229651%2FProperties%2F-173342751) | [JVM]<br>private final [ChallengeDetail.Status](-status/index.md)[status](index.md#1760229651%2FProperties%2F-173342751) |
| [type](index.md#1911495883%2FProperties%2F-173342751) | [JVM]<br>private final [ChallengeDetail.Type](-type/index.md)[type](index.md#1911495883%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [ChallengeDetail.Builder](-builder/index.md)[builder](builder.md)() |
| [getDisplayedFlag](get-displayed-flag.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getDisplayedFlag](get-displayed-flag.md)() |
| [getStatus](get-status.md) | [JVM]<br>public final [ChallengeDetail.Status](-status/index.md)[getStatus](get-status.md)() |
| [getType](get-type.md) | [JVM]<br>public final [ChallengeDetail.Type](-type/index.md)[getType](get-type.md)() |
