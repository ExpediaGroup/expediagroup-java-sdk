//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RoomContent](index.md)

# RoomContent

public final class [RoomContent](index.md)

An individual room.

#### Parameters

JVM

| | |
|---|---|
| id | Unique identifier for a room type. |
| name | Room type name. |
| descriptions |
| amenities | Lists all of the amenities available in the room. See our [amenities reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known amenity ID and name values. |
| images | The room's images. Contains all room images available. |
| bedGroups | A map of the room's bed groups. |
| area |
| views | A map of the room views. See our [view reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known room view ID and name values. |
| occupancy |

## Constructors

| | |
|---|---|
| [RoomContent](-room-content.md) | [JVM]<br>public [RoomContent](index.md)[RoomContent](-room-content.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [DescriptionsRoom](../-descriptions-room/index.md)descriptions, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;amenities, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Image](../-image/index.md)&gt;images, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [BedGroup](../-bed-group/index.md)&gt;bedGroups, [Area](../-area/index.md)area, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [View](../-view/index.md)&gt;views, [Occupancy](../-occupancy/index.md)occupancy) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [amenities](index.md#-2077283040%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;[amenities](index.md#-2077283040%2FProperties%2F700308213) |
| [area](index.md#1693015286%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Area](../-area/index.md)[area](index.md#1693015286%2FProperties%2F700308213) |
| [bedGroups](index.md#313848386%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [BedGroup](../-bed-group/index.md)&gt;[bedGroups](index.md#313848386%2FProperties%2F700308213) |
| [descriptions](index.md#-720996660%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [DescriptionsRoom](../-descriptions-room/index.md)[descriptions](index.md#-720996660%2FProperties%2F700308213) |
| [id](index.md#-884421208%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#-884421208%2FProperties%2F700308213) |
| [images](index.md#-58103829%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Image](../-image/index.md)&gt;[images](index.md#-58103829%2FProperties%2F700308213) |
| [name](index.md#1376013496%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#1376013496%2FProperties%2F700308213) |
| [occupancy](index.md#-1278133590%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Occupancy](../-occupancy/index.md)[occupancy](index.md#-1278133590%2FProperties%2F700308213) |
| [views](index.md#485483689%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [View](../-view/index.md)&gt;[views](index.md#485483689%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomContent.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmenities](get-amenities.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;[getAmenities](get-amenities.md)() |
| [getArea](get-area.md) | [JVM]<br>public final [Area](../-area/index.md)[getArea](get-area.md)() |
| [getBedGroups](get-bed-groups.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [BedGroup](../-bed-group/index.md)&gt;[getBedGroups](get-bed-groups.md)() |
| [getDescriptions](get-descriptions.md) | [JVM]<br>public final [DescriptionsRoom](../-descriptions-room/index.md)[getDescriptions](get-descriptions.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getImages](get-images.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Image](../-image/index.md)&gt;[getImages](get-images.md)() |
| [getName](get-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
| [getOccupancy](get-occupancy.md) | [JVM]<br>public final [Occupancy](../-occupancy/index.md)[getOccupancy](get-occupancy.md)() |
| [getViews](get-views.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [View](../-view/index.md)&gt;[getViews](get-views.md)() |
