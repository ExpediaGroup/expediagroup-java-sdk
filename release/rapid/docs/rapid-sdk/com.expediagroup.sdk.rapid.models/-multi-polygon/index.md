//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[MultiPolygon](index.md)

# MultiPolygon

public final class [MultiPolygon](index.md) implements [BoundingPolygon](../-bounding-polygon/index.md)

#### Parameters

JVM

| | |
|---|---|
| coordinates | An array of multiple polygon(s) that combine to make a full [MultiPolygon](https://www.rfc-editor.org/rfc/rfc7946#section-3.1.7) in geojson format. |

## Constructors

| | |
|---|---|
| [MultiPolygon](-multi-polygon.md) | [JVM]<br>public [MultiPolygon](index.md)[MultiPolygon](-multi-polygon.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;&gt;&gt;&gt;coordinates) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [coordinates](index.md#-159338745%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;&gt;&gt;&gt;[coordinates](index.md#-159338745%2FProperties%2F700308213) |
| [type](index.md#-1719620482%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[type](index.md#-1719620482%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [MultiPolygon.Builder](-builder/index.md)[builder](builder.md)() |
| [getCoordinates](get-coordinates.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;&gt;&gt;&gt;[getCoordinates](get-coordinates.md)() |
| [getType](get-type.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getType](get-type.md)() |
