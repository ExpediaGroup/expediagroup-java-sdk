//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Fees](index.md)

# Fees

public final class [Fees](index.md)

Information related to a property's fees.

#### Parameters

JVM

| | |
|---|---|
| mandatory | Describes resort fees and other mandatory taxes or charges. May describe which services are covered by any fees, such as fitness centers or internet access. |
| optional | Describes additional optional fees for items such as breakfast, wifi, parking, pets etc. |

## Constructors

| | |
|---|---|
| [Fees](-fees.md) | [JVM]<br>public [Fees](index.md)[Fees](-fees.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)mandatory, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)optional) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [mandatory](index.md#-1343399491%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[mandatory](index.md#-1343399491%2FProperties%2F700308213) |
| [optional](index.md#732397444%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[optional](index.md#732397444%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Fees.Builder](-builder/index.md)[builder](builder.md)() |
| [getMandatory](get-mandatory.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMandatory](get-mandatory.md)() |
| [getOptional](get-optional.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getOptional](get-optional.md)() |
