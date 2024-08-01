//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[CancellationPenaltyRule](index.md)/[CancellationPenaltyRule](-cancellation-penalty-rule.md)

# CancellationPenaltyRule

[JVM]\

public [CancellationPenaltyRule](index.md)[CancellationPenaltyRule](-cancellation-penalty-rule.md)([Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)penaltyNightCount, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)penaltyPercentOfStay, [CancellationPenaltyRulePenaltyPrice](../-cancellation-penalty-rule-penalty-price/index.md)penaltyPrice, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)penaltyStartDateTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)penaltyEndDateTime)

#### Parameters

JVM

| | |
|---|---|
| penaltyNightCount | Specifies the per-stay cancellation fee charged in terms of the cost of the number of nights listed, in addition to any other penalties. The rate charged is based on the earliest night(s) of the stay. |
| penaltyPercentOfStay | Specifies the per-stay cancellation fee charged as a percentage of the total rate, in addition to any other penalties listed. |
| penaltyPrice |
| penaltyStartDateTime | The beginning of the window of time when the `CancellationPenaltyRule` is in effect.  The date and time are expressed in ISO 8601 International Date format, and local to the hotel. |
| penaltyEndDateTime | The end of the window of time when the `CancellationPenaltyRule` is in effect.  The date and time are expressed in ISO 8601 International Date format, and local to the hotel. |
