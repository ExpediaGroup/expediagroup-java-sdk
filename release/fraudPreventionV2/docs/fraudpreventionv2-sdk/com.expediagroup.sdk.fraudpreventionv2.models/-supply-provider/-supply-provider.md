//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[SupplyProvider](index.md)/[SupplyProvider](-supply-provider.md)

# SupplyProvider

[JVM]\

public [SupplyProvider](index.md)[SupplyProvider](-supply-provider.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [SupplyProvider.Type](-type/index.md)type, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)vendorName)

#### Parameters

JVM

| | |
|---|---|
| name | This field provides name of the partner involved in offering the activity. |
| type | This field indicates the nature or relationship of the vendor associated with a particular activity. * `THIRD_PARTY`: This value indicates that the partner integrates with a third-party platform via APIs and ingests activities from them. * `DIRECT`: This value signifies that the partner is a direct entity or provider associated with the organization or platform offering the activity. |
| vendorName | This field describes the name of the third-party vendor who provided the supply provider or the operating company with the activity. |
