//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Polygon](index.md)

# Polygon

public final class [Polygon](index.md) implements [BoundingPolygon](../-bounding-polygon/index.md)

#### Parameters

JVM

| | |
|---|---|
| coordinates | An array of linear ring coordinate arrays that combine to make up a single [Polygon](https://www.rfc-editor.org/rfc/rfc7946#section-3.1.6) in geojson format. If there is more than one linear ring at this level, the first is the outer boundary and the remaining linear rings are interior rings or holes. |

## Constructors

| | |
|---|---|
| [Polygon](-polygon.md) | [JVM]<br>public [Polygon](index.md)[Polygon](-polygon.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;&gt;&gt;coordinates) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [coordinates](index.md#734353952%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;&gt;&gt;[coordinates](index.md#734353952%2FProperties%2F700308213) |
| [type](index.md#-955163771%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[type](index.md#-955163771%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Polygon.Builder](-builder/index.md)[builder](builder.md)() |
| [getCoordinates](get-coordinates.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;&gt;&gt;[getCoordinates](get-coordinates.md)() |
| [getType](get-type.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getType](get-type.md)() |
