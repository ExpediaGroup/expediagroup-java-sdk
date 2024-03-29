//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[CurrentUserSession](index.md)

# CurrentUserSession

public final class [CurrentUserSession](index.md)

The current user session prior to this transaction, which contains details related to any challenge initiated by the Partner''s system to a user before calling Expedia''s Fraud Prevention Service. An example is if the Partner''s system sent a Captcha challenge to the user before calling Expedia''s Fraud Prevention Service.

#### Parameters

JVM

| | |
|---|---|
| sessionId | Unique identifier for a user's session on their device |
| startDateTime | The local date and time a user's session started, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| challengeDetail |

## Constructors

| | |
|---|---|
| [CurrentUserSession](-current-user-session.md) | [JVM]<br>public [CurrentUserSession](index.md)[CurrentUserSession](-current-user-session.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)sessionId, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)startDateTime, [ChallengeDetail](../-challenge-detail/index.md)challengeDetail) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [challengeDetail](index.md#-106291191%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [ChallengeDetail](../-challenge-detail/index.md)[challengeDetail](index.md#-106291191%2FProperties%2F-173342751) |
| [sessionId](index.md#1400689388%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[sessionId](index.md#1400689388%2FProperties%2F-173342751) |
| [startDateTime](index.md#-1307105120%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[startDateTime](index.md#-1307105120%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CurrentUserSession.Builder](-builder/index.md)[builder](builder.md)() |
| [getChallengeDetail](get-challenge-detail.md) | [JVM]<br>public final [ChallengeDetail](../-challenge-detail/index.md)[getChallengeDetail](get-challenge-detail.md)() |
| [getSessionId](get-session-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSessionId](get-session-id.md)() |
| [getStartDateTime](get-start-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getStartDateTime](get-start-date-time.md)() |
