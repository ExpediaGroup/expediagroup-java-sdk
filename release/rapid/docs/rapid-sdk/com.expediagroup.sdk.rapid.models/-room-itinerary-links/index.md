//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RoomItineraryLinks](index.md)

# RoomItineraryLinks

public final class [RoomItineraryLinks](index.md)

A map of links - * `cancel` - Cancel the booking for this room * `change` - A PUT call to modify the details of the booking for this room (soft change) * `shop_for_change` - Shop for rates to evaluate for possible rebooking. This shop call will show the estimated financial impact of the change.<br>   Current parameters supported in shop for change: `checkin`, `checkout`, `occupancy` See: #get-/properties/-property_id-/availability

#### Parameters

JVM

| |
|---|
| cancel |
| change |
| shopForChange |

## Constructors

| | |
|---|---|
| [RoomItineraryLinks](-room-itinerary-links.md) | [JVM]<br>public [RoomItineraryLinks](index.md)[RoomItineraryLinks](-room-itinerary-links.md)([Link](../-link/index.md)cancel, [Link](../-link/index.md)change, [Link](../-link/index.md)shopForChange) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [cancel](index.md#813330726%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Link](../-link/index.md)[cancel](index.md#813330726%2FProperties%2F700308213) |
| [change](index.md#-623856464%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Link](../-link/index.md)[change](index.md#-623856464%2FProperties%2F700308213) |
| [shopForChange](index.md#-739215977%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Link](../-link/index.md)[shopForChange](index.md#-739215977%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomItineraryLinks.Builder](-builder/index.md)[builder](builder.md)() |
| [getCancel](get-cancel.md) | [JVM]<br>public final [Link](../-link/index.md)[getCancel](get-cancel.md)() |
| [getChange](get-change.md) | [JVM]<br>public final [Link](../-link/index.md)[getChange](get-change.md)() |
| [getShopForChange](get-shop-for-change.md) | [JVM]<br>public final [Link](../-link/index.md)[getShopForChange](get-shop-for-change.md)() |
