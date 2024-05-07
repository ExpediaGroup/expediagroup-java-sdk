//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[MarketingFeeIncentive](index.md)

# MarketingFeeIncentive

public final class [MarketingFeeIncentive](index.md)

An object representing one incentive source and the stay dates relevant to that particular incentive.

#### Parameters

JVM

| | |
|---|---|
| source | The source of the incentive. This can be used to differentiate between incentives in the case that more than one incentive applies to a particular rate. |
| start | The first stay date with the incentive applied in ISO 8601 format. |
| end | The last stay date with the incentive applied in ISO 8601 format. |

## Constructors

| | |
|---|---|
| [MarketingFeeIncentive](-marketing-fee-incentive.md) | [JVM]<br>public [MarketingFeeIncentive](index.md)[MarketingFeeIncentive](-marketing-fee-incentive.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)source, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)start, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)end) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [end](index.md#-425025905%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[end](index.md#-425025905%2FProperties%2F700308213) |
| [source](index.md#1269578133%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[source](index.md#1269578133%2FProperties%2F700308213) |
| [start](index.md#-1991771736%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[start](index.md#-1991771736%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [MarketingFeeIncentive.Builder](-builder/index.md)[builder](builder.md)() |
| [getEnd](get-end.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEnd](get-end.md)() |
| [getSource](get-source.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSource](get-source.md)() |
| [getStart](get-start.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getStart](get-start.md)() |
