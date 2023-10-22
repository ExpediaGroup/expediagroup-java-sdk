//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[RailAllOf](index.md)

# RailAllOf

public final class [RailAllOf](index.md)

#### Parameters

JVM

| | |
|---|---|
| routeType | The type of route or itinerary for the Rail product, indicating the travel arrangement and pattern. Possible values are: - `MULTIPLE_DESTINATIONS` - The Rail product includes multiple destinations in its itinerary. - `ONE_WAY` - The Rail product represents a one-way journey. - `ROUNDTRIP` - The Rail product represents a roundtrip journey. |
| railSegments |

## Constructors

| | |
|---|---|
| [RailAllOf](-rail-all-of.md) | [JVM]<br>public [RailAllOf](index.md)[RailAllOf](-rail-all-of.md)([RailAllOf.RouteType](-route-type/index.md)routeType, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RailSegments](../-rail-segments/index.md)&gt;railSegments) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [RouteType](-route-type/index.md) | [JVM]<br>public enum [RouteType](-route-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RailAllOf.RouteType](-route-type/index.md)&gt;<br>The type of route or itinerary for the Rail product, indicating the travel arrangement and pattern. Possible values are: - `MULTIPLE_DESTINATIONS` - The Rail product includes multiple destinations in its itinerary. - `ONE_WAY` - The Rail product represents a one-way journey. - `ROUNDTRIP` - The Rail product represents a roundtrip journey. Values: MULTIPLE_DESTINATIONS,ONE_WAY,ROUND_TRIP |

## Properties

| Name | Summary |
|---|---|
| [railSegments](index.md#-851267899%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RailSegments](../-rail-segments/index.md)&gt;[railSegments](index.md#-851267899%2FProperties%2F-173342751) |
| [routeType](index.md#1219178016%2FProperties%2F-173342751) | [JVM]<br>private final [RailAllOf.RouteType](-route-type/index.md)[routeType](index.md#1219178016%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RailAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getRailSegments](get-rail-segments.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RailSegments](../-rail-segments/index.md)&gt;[getRailSegments](get-rail-segments.md)() |
| [getRouteType](get-route-type.md) | [JVM]<br>public final [RailAllOf.RouteType](-route-type/index.md)[getRouteType](get-route-type.md)() |
