//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[CancellationPenaltyRule](index.md)

# CancellationPenaltyRule

public final class [CancellationPenaltyRule](index.md)

#### Parameters

JVM

| | |
|---|---|
| penaltyNightCount | Specifies the per-stay cancellation fee charged in terms of the cost of the number of nights listed, in addition to any other penalties. The rate charged is based on the earliest night(s) of the stay. |
| penaltyPercentOfStay | Specifies the per-stay cancellation fee charged as a percentage of the total rate, in addition to any other penalties listed. |
| penaltyPrice |
| penaltyStartDateTime | The beginning of the window of time when the `CancellationPenaltyRule` is in effect.  The date and time are expressed in ISO 8601 International Date format, and local to the hotel. |
| penaltyEndDateTime | The end of the window of time when the `CancellationPenaltyRule` is in effect.  The date and time are expressed in ISO 8601 International Date format, and local to the hotel. |

## Constructors

| | |
|---|---|
| [CancellationPenaltyRule](-cancellation-penalty-rule.md) | [JVM]<br>public [CancellationPenaltyRule](index.md)[CancellationPenaltyRule](-cancellation-penalty-rule.md)([Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)penaltyNightCount, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)penaltyPercentOfStay, [CancellationPenaltyRulePenaltyPrice](../-cancellation-penalty-rule-penalty-price/index.md)penaltyPrice, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)penaltyStartDateTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)penaltyEndDateTime) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [penaltyEndDateTime](index.md#-1325431761%2FProperties%2F699445674) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[penaltyEndDateTime](index.md#-1325431761%2FProperties%2F699445674) |
| [penaltyNightCount](index.md#1475092862%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[penaltyNightCount](index.md#1475092862%2FProperties%2F699445674) |
| [penaltyPercentOfStay](index.md#-416800976%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[penaltyPercentOfStay](index.md#-416800976%2FProperties%2F699445674) |
| [penaltyPrice](index.md#1679915484%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [CancellationPenaltyRulePenaltyPrice](../-cancellation-penalty-rule-penalty-price/index.md)[penaltyPrice](index.md#1679915484%2FProperties%2F699445674) |
| [penaltyStartDateTime](index.md#-1267211384%2FProperties%2F699445674) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[penaltyStartDateTime](index.md#-1267211384%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CancellationPenaltyRule.Builder](-builder/index.md)[builder](builder.md)() |
| [getPenaltyEndDateTime](get-penalty-end-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getPenaltyEndDateTime](get-penalty-end-date-time.md)() |
| [getPenaltyNightCount](get-penalty-night-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getPenaltyNightCount](get-penalty-night-count.md)() |
| [getPenaltyPercentOfStay](get-penalty-percent-of-stay.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPenaltyPercentOfStay](get-penalty-percent-of-stay.md)() |
| [getPenaltyPrice](get-penalty-price.md) | [JVM]<br>public final [CancellationPenaltyRulePenaltyPrice](../-cancellation-penalty-rule-penalty-price/index.md)[getPenaltyPrice](get-penalty-price.md)() |
| [getPenaltyStartDateTime](get-penalty-start-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getPenaltyStartDateTime](get-penalty-start-date-time.md)() |
