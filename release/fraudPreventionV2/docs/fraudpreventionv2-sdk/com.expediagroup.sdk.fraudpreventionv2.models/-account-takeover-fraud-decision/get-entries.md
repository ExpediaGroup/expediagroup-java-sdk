//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[AccountTakeoverFraudDecision](index.md)/[getEntries](get-entries.md)

# getEntries

[JVM]\

public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[AccountTakeoverFraudDecision](index.md)&gt;[getEntries](get-entries.md)()

Fraud recommendation for an account transaction. A recommendation can be ACCEPT, CHALLENGE, or REJECT. - `ACCEPT` - Represents an account transaction where the user’’s account activity is accepted. - `CHALLENGE` - Represents an account transaction that requires additional verification or challenges the user’’s identity (example: CAPTCHA, MULTI_FACTOR_AUTHENTICATION, etc). - `REJECT` - Represents a suspicious account transaction where the user’’s credentials or their behavior requires us to block the account activity. Values: ACCEPT,CHALLENGE,REJECT
