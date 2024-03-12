//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[SupplyProvider](index.md)

# SupplyProvider

public final class [SupplyProvider](index.md)

#### Parameters

JVM

| | |
|---|---|
| name | This field provides name of the partner involved in offering the activity. |
| type | This field indicates the nature or relationship of the vendor associated with a particular activity. * `THIRD_PARTY`: This value indicates that the partner integrates with a third-party platform via APIs and ingests activities from them. * `DIRECT`: This value signifies that the partner is a direct entity or provider associated with the organization or platform offering the activity. |
| vendorName | This field describes the name of the third-party vendor who provided the supply provider or the operating company with the activity. |

## Constructors

| | |
|---|---|
| [SupplyProvider](-supply-provider.md) | [JVM]<br>public [SupplyProvider](index.md)[SupplyProvider](-supply-provider.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [SupplyProvider.Type](-type/index.md)type, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)vendorName) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[SupplyProvider.Type](-type/index.md)&gt;<br>This field indicates the nature or relationship of the vendor associated with a particular activity. * `THIRD_PARTY`: This value indicates that the partner integrates with a third-party platform via APIs and ingests activities from them. * `DIRECT`: This value signifies that the partner is a direct entity or provider associated with the organization or platform offering the activity. Values: THIRD_PARTY,DIRECT |

## Properties

| Name | Summary |
|---|---|
| [name](index.md#1815669792%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#1815669792%2FProperties%2F-173342751) |
| [type](index.md#-1549522351%2FProperties%2F-173342751) | [JVM]<br>private final [SupplyProvider.Type](-type/index.md)[type](index.md#-1549522351%2FProperties%2F-173342751) |
| [vendorName](index.md#196671800%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[vendorName](index.md#196671800%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [SupplyProvider.Builder](-builder/index.md)[builder](builder.md)() |
| [getName](get-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
| [getType](get-type.md) | [JVM]<br>public final [SupplyProvider.Type](-type/index.md)[getType](get-type.md)() |
| [getVendorName](get-vendor-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getVendorName](get-vendor-name.md)() |
