//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[ChallengeDetail](index.md)/[ChallengeDetail](-challenge-detail.md)

# ChallengeDetail

[JVM]\

public [ChallengeDetail](index.md)[ChallengeDetail](-challenge-detail.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)displayedFlag, [ChallengeDetail.Type](-type/index.md)type, [ChallengeDetail.Status](-status/index.md)status)

#### Parameters

JVM

| | |
|---|---|
| displayedFlag | Indicates that there was a challenge initiated by the Partner's system to a user before calling Expedia's Fraud Prevention Service. |
| type | The kind of challenge served by the Partner''s system to a user prior to calling Expedia''s Fraud Prevention Service. - `CAPTCHA` - Applicable if the challenge served by the Partner''s system was a Captcha challenge. - `TWO_FACTOR` - Applicable if the challenge served by the Partner''s system was a two-factor challenge including (Email verification, One Time Password, Okta, etc). |
| status | The status of the challenge served by the Partner''s system to a user before calling Expedia''s Fraud Prevention Service. - `SUCCESS` - Applicable if the user successfully passed the challenge. - `FAILED` - Applicable if the user failed the challenge. |
