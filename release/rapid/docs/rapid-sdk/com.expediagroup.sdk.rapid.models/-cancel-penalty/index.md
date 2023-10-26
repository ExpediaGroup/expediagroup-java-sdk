//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[CancelPenalty](index.md)

# CancelPenalty

public final class [CancelPenalty](index.md)

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

## Constructors

| | |
|---|---|
| [CancelPenalty](-cancel-penalty.md) | [JVM]<br>public [CancelPenalty](index.md)[CancelPenalty](-cancel-penalty.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)currency, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)start, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)end, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)amount, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)nights, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)percent) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [amount](index.md#2113191388%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[amount](index.md#2113191388%2FProperties%2F700308213) |
| [currency](index.md#1448676995%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[currency](index.md#1448676995%2FProperties%2F700308213) |
| [end](index.md#-2118554837%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[end](index.md#-2118554837%2FProperties%2F700308213) |
| [nights](index.md#1543817273%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[nights](index.md#1543817273%2FProperties%2F700308213) |
| [percent](index.md#1049443969%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[percent](index.md#1049443969%2FProperties%2F700308213) |
| [start](index.md#-1680470204%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[start](index.md#-1680470204%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CancelPenalty.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmount](get-amount.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAmount](get-amount.md)() |
| [getCurrency](get-currency.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCurrency](get-currency.md)() |
| [getEnd](get-end.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEnd](get-end.md)() |
| [getNights](get-nights.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getNights](get-nights.md)() |
| [getPercent](get-percent.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPercent](get-percent.md)() |
| [getStart](get-start.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getStart](get-start.md)() |
