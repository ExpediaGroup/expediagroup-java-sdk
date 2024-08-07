//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RoomType](index.md)/[RoomType](-room-type.md)

# RoomType

[JVM]\

public [RoomType](index.md)[RoomType](-room-type.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)description, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomKey, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)offerId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantName, [RoomType.RatePlanType](-rate-plan-type/index.md)ratePlanType, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlan](../-rate-plan/index.md)&gt;ratePlans, [RoomTypePrice](../-room-type-price/index.md)price, [RoomTypeStandalonePrice](../-room-type-standalone-price/index.md)standalonePrice, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Promotion](../-promotion/index.md)&gt;promotionsDeprecated, [RoomTypeLinks](../-room-type-links/index.md)links, [RoomType.SmokingOption](-smoking-option/index.md)smokingOption, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BedType](../-bed-type/index.md)&gt;bedTypeOptions, [RoomOccupancyPolicy](../-room-occupancy-policy/index.md)roomOccupancyPolicy, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomTypeAmenitiesInner](../-room-type-amenities-inner/index.md)&gt;amenities, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;descriptiveAmenities, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomTypeMediaInner](../-room-type-media-inner/index.md)&gt;media)

#### Parameters

JVM

| | |
|---|---|
| description | Text description of the room type. |
| roomKey | An encrypted string which includes the information that could be used to address the current room type.  `RoomKey` has been renamed as `OfferId`. |
| offerId | An encrypted string which includes the information that could be used to address the current room type. |
| merchantName | Name of Merchant that did the initial Authentication. |
| ratePlanType | Indicate the room type is sold as package or standalone. |
| ratePlans | Container for rate plan information. |
| price |
| standalonePrice |
| promotionsDeprecated | All promotion information of the room.  **Note**: The node has been moved to `RatePlan` node, and will be deprecated soon. |
| links |
| smokingOption | The smoking options available for the room type. |
| bedTypeOptions | Statement of bed types available for this offer. A room may have several bed type options available.  **NOTE**: due to the large number of bed type options available, we no longer publish a list of available bed types. More information is available in [Lodging Bed Types](https://developers.expediagroup.com/xap/products/xap/lodging/references/bed-types). |
| roomOccupancyPolicy |
| amenities | Container for all room amenities. |
| descriptiveAmenities | Container for all room amenities in group.  The key is amenity category, the values are the amenity information. The category for grouped amenities in room level will be: - ACCESSIBILITY - BATHROOM - BEDROOM - CLUB_EXEC - FAMILY_FRIENDLY - ENTERTAINMENT - FOOD_AND_DRINK - INTERNET - MORE - OUTDOOR_SPACE - SAFETY |
| media | Container for Media elements. |
