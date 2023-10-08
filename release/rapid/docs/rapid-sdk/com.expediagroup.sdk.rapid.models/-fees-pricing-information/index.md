//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[FeesPricingInformation](index.md)

# FeesPricingInformation

public final class [FeesPricingInformation](index.md)

The fees collected by the property. The values for each type of fee are the total for that type.  Mandatory fees are collected by the property at check-in or check-out. Resort fees are charged for amenities and extras and collected by the property at check-in or check-out. Mandatory taxes are taxes collected by the property at check-in or check-out.

#### Parameters

JVM

| |
|---|
| mandatoryFee |
| resortFee |
| mandatoryTax |

## Constructors

| | |
|---|---|
| [FeesPricingInformation](-fees-pricing-information.md) | [JVM]<br>public [FeesPricingInformation](index.md)[FeesPricingInformation](-fees-pricing-information.md)([ChargeCalculated](../-charge-calculated/index.md)mandatoryFee, [ChargeCalculated](../-charge-calculated/index.md)resortFee, [ChargeCalculated](../-charge-calculated/index.md)mandatoryTax) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [mandatoryFee](index.md#-1902609219%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [ChargeCalculated](../-charge-calculated/index.md)[mandatoryFee](index.md#-1902609219%2FProperties%2F700308213) |
| [mandatoryTax](index.md#-136065992%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [ChargeCalculated](../-charge-calculated/index.md)[mandatoryTax](index.md#-136065992%2FProperties%2F700308213) |
| [resortFee](index.md#-136444485%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [ChargeCalculated](../-charge-calculated/index.md)[resortFee](index.md#-136444485%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [FeesPricingInformation.Builder](-builder/index.md)[builder](builder.md)() |
| [getMandatoryFee](get-mandatory-fee.md) | [JVM]<br>public final [ChargeCalculated](../-charge-calculated/index.md)[getMandatoryFee](get-mandatory-fee.md)() |
| [getMandatoryTax](get-mandatory-tax.md) | [JVM]<br>public final [ChargeCalculated](../-charge-calculated/index.md)[getMandatoryTax](get-mandatory-tax.md)() |
| [getResortFee](get-resort-fee.md) | [JVM]<br>public final [ChargeCalculated](../-charge-calculated/index.md)[getResortFee](get-resort-fee.md)() |
