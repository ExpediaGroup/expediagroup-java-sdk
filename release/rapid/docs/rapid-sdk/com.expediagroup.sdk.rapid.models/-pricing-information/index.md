//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PricingInformation](index.md)

# PricingInformation

public final class [PricingInformation](index.md)

The pricing information object.

#### Parameters

JVM

| | |
|---|---|
| nightly | Array of arrays of amount objects. Each sub-array of amount objects represents a single night's charges. |
| stay | Array of amount objects. Details any charges that apply to the entire stay (not divided per-night). Any per-room adjustments are applied to the `base_rate` amount within this object. |
| totals |
| fees |

## Constructors

| | |
|---|---|
| [PricingInformation](-pricing-information.md) | [JVM]<br>public [PricingInformation](index.md)[PricingInformation](-pricing-information.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NightCharge](../-night-charge/index.md)&gt;&gt;nightly, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Stay](../-stay/index.md)&gt;stay, [Totals](../-totals/index.md)totals, [FeesPricingInformation](../-fees-pricing-information/index.md)fees) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [fees](index.md#-801829968%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [FeesPricingInformation](../-fees-pricing-information/index.md)[fees](index.md#-801829968%2FProperties%2F700308213) |
| [nightly](index.md#-1504859464%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NightCharge](../-night-charge/index.md)&gt;&gt;[nightly](index.md#-1504859464%2FProperties%2F700308213) |
| [stay](index.md#727106692%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Stay](../-stay/index.md)&gt;[stay](index.md#727106692%2FProperties%2F700308213) |
| [totals](index.md#1506003438%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Totals](../-totals/index.md)[totals](index.md#1506003438%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PricingInformation.Builder](-builder/index.md)[builder](builder.md)() |
| [getFees](get-fees.md) | [JVM]<br>public final [FeesPricingInformation](../-fees-pricing-information/index.md)[getFees](get-fees.md)() |
| [getNightly](get-nightly.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NightCharge](../-night-charge/index.md)&gt;&gt;[getNightly](get-nightly.md)() |
| [getStay](get-stay.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Stay](../-stay/index.md)&gt;[getStay](get-stay.md)() |
| [getTotals](get-totals.md) | [JVM]<br>public final [Totals](../-totals/index.md)[getTotals](get-totals.md)() |
