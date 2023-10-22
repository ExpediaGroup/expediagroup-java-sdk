//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PricingInformation](index.md)/[PricingInformation](-pricing-information.md)

# PricingInformation

[JVM]\

public [PricingInformation](index.md)[PricingInformation](-pricing-information.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NightCharge](../-night-charge/index.md)&gt;&gt;nightly, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Stay](../-stay/index.md)&gt;stay, [Totals](../-totals/index.md)totals, [FeesPricingInformation](../-fees-pricing-information/index.md)fees)

#### Parameters

JVM

| | |
|---|---|
| nightly | Array of arrays of amount objects. Each sub-array of amount objects represents a single night's charges. |
| stay | Array of amount objects. Details any charges that apply to the entire stay (not divided per-night). Any per-room adjustments are applied to the `base_rate` amount within this object. |
| totals |
| fees |
