//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[ChallengeDetail](../index.md)/[Type](index.md)/[getEntries](get-entries.md)

# getEntries

[JVM]\

public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[ChallengeDetail.Type](index.md)&gt;[getEntries](get-entries.md)()

The kind of challenge served by the Partner''s system to a user prior to calling Expedia''s Fraud Prevention Service. - `CAPTCHA` - Applicable if the challenge served by the Partner''s system was a Captcha challenge. - `TWO_FACTOR` - Applicable if the challenge served by the Partner''s system was a two-factor challenge including (Email verification, One Time Password, Okta, etc). Values: CAPTCHA,TWO_FACTOR
