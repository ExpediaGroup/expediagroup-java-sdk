//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Rail](index.md)

# Rail

public final class [Rail](index.md) implements [TravelProduct](../-travel-product/index.md)

#### Parameters

JVM

| | |
|---|---|
| routeType | The type of route or itinerary for the Rail product, indicating the travel arrangement and pattern. Possible values are: - `MULTIPLE_DESTINATIONS` - The Rail product includes multiple destinations in its itinerary. - `ONE_WAY` - The Rail product represents a one-way journey. - `ROUNDTRIP` - The Rail product represents a roundtrip journey. |
| railSegments |

## Constructors

| | |
|---|---|
| [Rail](-rail.md) | [JVM]<br>public [Rail](index.md)[Rail](-rail.md)([Amount](../-amount/index.md)price, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventoryType, [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)inventorySource, [Rail.RouteType](-route-type/index.md)routeType, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RailSegments](../-rail-segments/index.md)&gt;railSegments, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;travelersReferences, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)payLater) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [RouteType](-route-type/index.md) | [JVM]<br>public enum [RouteType](-route-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Rail.RouteType](-route-type/index.md)&gt;<br>The type of route or itinerary for the Rail product, indicating the travel arrangement and pattern. Possible values are: - `MULTIPLE_DESTINATIONS` - The Rail product includes multiple destinations in its itinerary. - `ONE_WAY` - The Rail product represents a one-way journey. - `ROUNDTRIP` - The Rail product represents a roundtrip journey. Values: MULTIPLE_DESTINATIONS,ONE_WAY,ROUND_TRIP |

## Properties

| Name | Summary |
|---|---|
| [inventorySource](index.md#1976113702%2FProperties%2F-173342751) | [JVM]<br>private final [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[inventorySource](index.md#1976113702%2FProperties%2F-173342751) |
| [inventoryType](index.md#753278183%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 30)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[inventoryType](index.md#753278183%2FProperties%2F-173342751) |
| [payLater](index.md#-542336423%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[payLater](index.md#-542336423%2FProperties%2F-173342751) |
| [price](index.md#-1542416972%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[price](index.md#-1542416972%2FProperties%2F-173342751) |
| [railSegments](index.md#-1541895285%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RailSegments](../-rail-segments/index.md)&gt;[railSegments](index.md#-1541895285%2FProperties%2F-173342751) |
| [routeType](index.md#259127066%2FProperties%2F-173342751) | [JVM]<br>private final [Rail.RouteType](-route-type/index.md)[routeType](index.md#259127066%2FProperties%2F-173342751) |
| [travelersReferences](index.md#-472192599%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 40)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[travelersReferences](index.md#-472192599%2FProperties%2F-173342751) |
| [type](index.md#1461687971%2FProperties%2F-173342751) | [JVM]<br>private final [TravelProductType](../-travel-product-type/index.md)[type](index.md#1461687971%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Rail.Builder](-builder/index.md)[builder](builder.md)() |
| [getInventorySource](get-inventory-source.md) | [JVM]<br>public [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[getInventorySource](get-inventory-source.md)() |
| [getInventoryType](get-inventory-type.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getInventoryType](get-inventory-type.md)() |
| [getPayLater](get-pay-later.md) | [JVM]<br>public [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getPayLater](get-pay-later.md)() |
| [getPrice](get-price.md) | [JVM]<br>public [Amount](../-amount/index.md)[getPrice](get-price.md)() |
| [getRailSegments](get-rail-segments.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RailSegments](../-rail-segments/index.md)&gt;[getRailSegments](get-rail-segments.md)() |
| [getRouteType](get-route-type.md) | [JVM]<br>public final [Rail.RouteType](-route-type/index.md)[getRouteType](get-route-type.md)() |
| [getTravelersReferences](get-travelers-references.md) | [JVM]<br>public [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getTravelersReferences](get-travelers-references.md)() |
| [getType](get-type.md) | [JVM]<br>public [TravelProductType](../-travel-product-type/index.md)[getType](get-type.md)() |
