//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Totals](index.md)

# Totals

public final class [Totals](index.md)

The total price of charges, given various critera. * `inclusive` - provides the total price including taxes and fees. This does not include hotel collected fees such as resort, mandatory taxes, and mandatory fees. * `exclusive` - provides the total price excluding taxes and fees. * `inclusive_strikethrough` - provides the tax `inclusive` total price with any hotel funded discounts added back. Can be used to merchandise the savings due to a discount. * `strikethrough` - provides the tax `exclusive` total price with any hotel funded discounts added back. Can be used to merchandise the savings due to a discount. * `marketing_fee` - provides the potential owed earnings per transaction. * `gross_profit` - provides the estimated gross profit per transaction. * `minimum_selling_price` - provides the minimum selling price. * `property_fees` - provides the total of the fees collected by the property.

#### Parameters

JVM

| |
|---|
| inclusive |
| exclusive |
| inclusiveStrikethrough |
| strikethrough |
| marketingFee |
| grossProfit |
| minimumSellingPrice |
| propertyFees |

## Constructors

| | |
|---|---|
| [Totals](-totals.md) | [JVM]<br>public [Totals](index.md)[Totals](-totals.md)([Charge](../-charge/index.md)inclusive, [Charge](../-charge/index.md)exclusive, [Charge](../-charge/index.md)inclusiveStrikethrough, [Charge](../-charge/index.md)strikethrough, [Charge](../-charge/index.md)marketingFee, [Charge](../-charge/index.md)grossProfit, [Charge](../-charge/index.md)minimumSellingPrice, [Charge](../-charge/index.md)propertyFees) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [exclusive](index.md#954620822%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[exclusive](index.md#954620822%2FProperties%2F700308213) |
| [grossProfit](index.md#-1071740404%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[grossProfit](index.md#-1071740404%2FProperties%2F700308213) |
| [inclusive](index.md#1123554312%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[inclusive](index.md#1123554312%2FProperties%2F700308213) |
| [inclusiveStrikethrough](index.md#1855223295%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[inclusiveStrikethrough](index.md#1855223295%2FProperties%2F700308213) |
| [marketingFee](index.md#-107967450%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[marketingFee](index.md#-107967450%2FProperties%2F700308213) |
| [minimumSellingPrice](index.md#-225503603%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[minimumSellingPrice](index.md#-225503603%2FProperties%2F700308213) |
| [propertyFees](index.md#-1228877628%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[propertyFees](index.md#-1228877628%2FProperties%2F700308213) |
| [strikethrough](index.md#31104385%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[strikethrough](index.md#31104385%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Totals.Builder](-builder/index.md)[builder](builder.md)() |
| [getExclusive](get-exclusive.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getExclusive](get-exclusive.md)() |
| [getGrossProfit](get-gross-profit.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getGrossProfit](get-gross-profit.md)() |
| [getInclusive](get-inclusive.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getInclusive](get-inclusive.md)() |
| [getInclusiveStrikethrough](get-inclusive-strikethrough.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getInclusiveStrikethrough](get-inclusive-strikethrough.md)() |
| [getMarketingFee](get-marketing-fee.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getMarketingFee](get-marketing-fee.md)() |
| [getMinimumSellingPrice](get-minimum-selling-price.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getMinimumSellingPrice](get-minimum-selling-price.md)() |
| [getPropertyFees](get-property-fees.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getPropertyFees](get-property-fees.md)() |
| [getStrikethrough](get-strikethrough.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getStrikethrough](get-strikethrough.md)() |
