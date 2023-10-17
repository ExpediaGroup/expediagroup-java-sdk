//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[MultiFactorAuthenticationAttempt](../index.md)/[Status](index.md)/[getEntries](get-entries.md)

# getEntries

[JVM]\

public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[MultiFactorAuthenticationAttempt.Status](index.md)&gt;[getEntries](get-entries.md)()

The status of a user''s response to the Multi-Factor Authentication initiated by the Partner''s system to the user.' - `SUCCESS` - Applicable if the user successfully passed the challenge. - `ABANDON` - Applicable if the user did not complete the challenge. - `FAILED` - Applicable if the user failed the challenge. Values: SUCCESS,ABANDON,FAILED
