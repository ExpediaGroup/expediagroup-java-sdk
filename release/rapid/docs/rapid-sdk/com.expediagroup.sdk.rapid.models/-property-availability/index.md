//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PropertyAvailability](index.md)

# PropertyAvailability

public final class [PropertyAvailability](index.md) implements [Property](../-property/index.md)

#### Parameters

JVM

| | |
|---|---|
| rooms | Array of objects containing room information. |
| links |

## Constructors

| | |
|---|---|
| [PropertyAvailability](-property-availability.md) | [JVM]<br>public [PropertyAvailability](index.md)[PropertyAvailability](-property-availability.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)score, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomAvailability](../-room-availability/index.md)&gt;rooms, [PropertyAvailabilityLinks](../-property-availability-links/index.md)links) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [links](index.md#757856218%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [PropertyAvailabilityLinks](../-property-availability-links/index.md)[links](index.md#757856218%2FProperties%2F700308213) |
| [propertyId](index.md#-1073088521%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[propertyId](index.md#-1073088521%2FProperties%2F700308213) |
| [rooms](index.md#-1937079941%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomAvailability](../-room-availability/index.md)&gt;[rooms](index.md#-1937079941%2FProperties%2F700308213) |
| [score](index.md#-1574224095%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[score](index.md#-1574224095%2FProperties%2F700308213) |
| [status](index.md#1080282389%2FProperties%2F700308213) | [JVM]<br>private final [Property.Status](../-property/-status/index.md)[status](index.md#1080282389%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PropertyAvailability.Builder](-builder/index.md)[builder](builder.md)() |
| [getLinks](get-links.md) | [JVM]<br>public final [PropertyAvailabilityLinks](../-property-availability-links/index.md)[getLinks](get-links.md)() |
| [getPropertyId](get-property-id.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPropertyId](get-property-id.md)() |
| [getRooms](get-rooms.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomAvailability](../-room-availability/index.md)&gt;[getRooms](get-rooms.md)() |
| [getScore](get-score.md) | [JVM]<br>public [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getScore](get-score.md)() |
| [getStatus](get-status.md) | [JVM]<br>public [Property.Status](../-property/-status/index.md)[getStatus](get-status.md)() |
