//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[Rail](index.md)

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
| [Rail](-rail.md) | [JVM]<br>public [Rail](index.md)[Rail](-rail.md)([Amount](../-amount/index.md)price, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventoryType, [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)inventorySource, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;travelersReferences, [Rail.RouteType](-route-type/index.md)routeType, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RailSegments](../-rail-segments/index.md)&gt;railSegments) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [RouteType](-route-type/index.md) | [JVM]<br>public enum [RouteType](-route-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Rail.RouteType](-route-type/index.md)&gt;<br>The type of route or itinerary for the Rail product, indicating the travel arrangement and pattern. Possible values are: - `MULTIPLE_DESTINATIONS` - The Rail product includes multiple destinations in its itinerary. - `ONE_WAY` - The Rail product represents a one-way journey. - `ROUNDTRIP` - The Rail product represents a roundtrip journey. Values: MULTIPLE_DESTINATIONS,ONE_WAY,ROUND_TRIP |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Rail.Builder](-builder/index.md)[builder](builder.md)() |
| [getInventorySource](get-inventory-source.md) | [JVM]<br>public [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[getInventorySource](get-inventory-source.md)() |
| [getInventoryType](get-inventory-type.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getInventoryType](get-inventory-type.md)() |
| [getPrice](get-price.md) | [JVM]<br>public [Amount](../-amount/index.md)[getPrice](get-price.md)() |
| [getRailSegments](get-rail-segments.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RailSegments](../-rail-segments/index.md)&gt;[getRailSegments](get-rail-segments.md)() |
| [getRouteType](get-route-type.md) | [JVM]<br>public final [Rail.RouteType](-route-type/index.md)[getRouteType](get-route-type.md)() |
| [getTravelersReferences](get-travelers-references.md) | [JVM]<br>public [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getTravelersReferences](get-travelers-references.md)() |
| [getType](get-type.md) | [JVM]<br>public [TravelProductType](../-travel-product-type/index.md)[getType](get-type.md)() |

## Properties

| Name | Summary |
|---|---|
| [inventorySource](index.md#-1579682612%2FProperties%2F-1883119931) | [JVM]<br>private final [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[inventorySource](index.md#-1579682612%2FProperties%2F-1883119931) |
| [inventoryType](index.md#1612146957%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 30)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[inventoryType](index.md#1612146957%2FProperties%2F-1883119931) |
| [price](index.md#1275815898%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[price](index.md#1275815898%2FProperties%2F-1883119931) |
| [railSegments](index.md#286925477%2FProperties%2F-1883119931) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RailSegments](../-rail-segments/index.md)&gt;[railSegments](index.md#286925477%2FProperties%2F-1883119931) |
| [routeType](index.md#-1144306112%2FProperties%2F-1883119931) | [JVM]<br>private final [Rail.RouteType](-route-type/index.md)[routeType](index.md#-1144306112%2FProperties%2F-1883119931) |
| [travelersReferences](index.md#1645216079%2FProperties%2F-1883119931) | [JVM]<br>@Size(min = 1, max = 40)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[travelersReferences](index.md#1645216079%2FProperties%2F-1883119931) |
| [type](index.md#1829693373%2FProperties%2F-1883119931) | [JVM]<br>private final [TravelProductType](../-travel-product-type/index.md)[type](index.md#1829693373%2FProperties%2F-1883119931) |
