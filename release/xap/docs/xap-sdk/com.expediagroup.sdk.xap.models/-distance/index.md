//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[Distance](index.md)

# Distance

public final class [Distance](index.md)

Container for distance information.  Only returned for city/address search or `geoLocation` search or single `regionId` search.

#### Parameters

JVM

| | |
|---|---|
|  | `value` The distance between the center of the search and the hotel. |
| unit | The unit of distance. |
| direction | The direction to the hotel from the center point of the search. |

## Constructors

| | |
|---|---|
| [Distance](-distance.md) | [JVM]<br>public [Distance](index.md)[Distance](-distance.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value, [Distance.Unit](-unit/index.md)unit, [Distance.Direction](-direction/index.md)direction) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Direction](-direction/index.md) | [JVM]<br>public enum [Direction](-direction/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Distance.Direction](-direction/index.md)&gt;<br>The direction to the hotel from the center point of the search. Values: N,S,W,E,NW,NE,SW,SE |
| [Unit](-unit/index.md) | [JVM]<br>public enum [Unit](-unit/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Distance.Unit](-unit/index.md)&gt;<br>The unit of distance. Values: KM,MI |

## Properties

| Name | Summary |
|---|---|
| [direction](index.md#-2019318012%2FProperties%2F699445674) | [JVM]<br>private final [Distance.Direction](-direction/index.md)[direction](index.md#-2019318012%2FProperties%2F699445674) |
| [unit](index.md#-425705197%2FProperties%2F699445674) | [JVM]<br>private final [Distance.Unit](-unit/index.md)[unit](index.md#-425705197%2FProperties%2F699445674) |
| [value](index.md#608351314%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#608351314%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Distance.Builder](-builder/index.md)[builder](builder.md)() |
| [getDirection](get-direction.md) | [JVM]<br>public final [Distance.Direction](-direction/index.md)[getDirection](get-direction.md)() |
| [getUnit](get-unit.md) | [JVM]<br>public final [Distance.Unit](-unit/index.md)[getUnit](get-unit.md)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
