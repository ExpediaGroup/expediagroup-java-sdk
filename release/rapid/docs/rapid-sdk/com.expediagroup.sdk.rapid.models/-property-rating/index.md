//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PropertyRating](index.md)

# PropertyRating

public final class [PropertyRating](index.md)

Information about the property's rating.

#### Parameters

JVM

| | |
|---|---|
| rating | The rating assigned to this property. Returns a value between 0.0 and 5.0. A value of 0.0 or a blank value indicates no rating is available. |
| type | Returns a value of either \&quot;Star\&quot; or \&quot;Alternate\&quot;. Star indicates the rating is provided by the property’s local star rating authority. Alternate indicates that the rating is an Expedia-assigned value; an official rating was not available. |

## Constructors

| | |
|---|---|
| [PropertyRating](-property-rating.md) | [JVM]<br>public [PropertyRating](index.md)[PropertyRating](-property-rating.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)rating, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)type) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [rating](index.md#-408073076%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[rating](index.md#-408073076%2FProperties%2F700308213) |
| [type](index.md#796691599%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[type](index.md#796691599%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PropertyRating.Builder](-builder/index.md)[builder](builder.md)() |
| [getRating](get-rating.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRating](get-rating.md)() |
| [getType](get-type.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getType](get-type.md)() |
