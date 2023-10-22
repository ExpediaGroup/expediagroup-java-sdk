//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[CancelPenalty](index.md)/[CancelPenalty](-cancel-penalty.md)

# CancelPenalty

[JVM]\

public [CancelPenalty](index.md)[CancelPenalty](-cancel-penalty.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)currency, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)start, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)end, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)amount, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)nights, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)percent)

#### Parameters

JVM

| | |
|---|---|
| currency | Currency of the amount object. |
| start | Effective date and time of cancellation penalty in extended ISO 8601 format, with ±hh:mm timezone offset |
| end | End date and time of cancellation penalty in extended ISO 8601 format, with ±hh:mm timezone offset |
| amount | The monetary amount of the penalty. |
| nights | Number of nights charged for as penalty. |
| percent | Percentage of total booking charged for as penalty. A thirty percent penalty would be returned as 30% |
