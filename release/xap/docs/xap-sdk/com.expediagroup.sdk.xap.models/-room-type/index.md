//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RoomType](index.md)

# RoomType

public final class [RoomType](index.md)

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

## Constructors

| | |
|---|---|
| [RoomType](-room-type.md) | [JVM]<br>public [RoomType](index.md)[RoomType](-room-type.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)description, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomKey, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)offerId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantName, [RoomType.RatePlanType](-rate-plan-type/index.md)ratePlanType, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlan](../-rate-plan/index.md)&gt;ratePlans, [RoomTypePrice](../-room-type-price/index.md)price, [RoomTypeStandalonePrice](../-room-type-standalone-price/index.md)standalonePrice, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Promotion](../-promotion/index.md)&gt;promotionsDeprecated, [RoomTypeLinks](../-room-type-links/index.md)links, [RoomType.SmokingOption](-smoking-option/index.md)smokingOption, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BedType](../-bed-type/index.md)&gt;bedTypeOptions, [RoomOccupancyPolicy](../-room-occupancy-policy/index.md)roomOccupancyPolicy, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomTypeAmenitiesInner](../-room-type-amenities-inner/index.md)&gt;amenities, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;descriptiveAmenities, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomTypeMediaInner](../-room-type-media-inner/index.md)&gt;media) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [RatePlanType](-rate-plan-type/index.md) | [JVM]<br>public enum [RatePlanType](-rate-plan-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RoomType.RatePlanType](-rate-plan-type/index.md)&gt;<br>Indicate the room type is sold as package or standalone. Values: STANDALONE,PACKAGE,WHOLESALE |
| [SmokingOption](-smoking-option/index.md) | [JVM]<br>public enum [SmokingOption](-smoking-option/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RoomType.SmokingOption](-smoking-option/index.md)&gt;<br>The smoking options available for the room type. Values: SMOKING_OR_NON_SMOKING,SMOKING,NON_SMOKING |

## Properties

| Name | Summary |
|---|---|
| [amenities](index.md#-2077881940%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomTypeAmenitiesInner](../-room-type-amenities-inner/index.md)&gt;[amenities](index.md#-2077881940%2FProperties%2F699445674) |
| [bedTypeOptions](index.md#-52986124%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BedType](../-bed-type/index.md)&gt;[bedTypeOptions](index.md#-52986124%2FProperties%2F699445674) |
| [description](index.md#-787872537%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[description](index.md#-787872537%2FProperties%2F699445674) |
| [descriptiveAmenities](index.md#1782824332%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[descriptiveAmenities](index.md#1782824332%2FProperties%2F699445674) |
| [links](index.md#-1152340918%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RoomTypeLinks](../-room-type-links/index.md)[links](index.md#-1152340918%2FProperties%2F699445674) |
| [media](index.md#447316607%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomTypeMediaInner](../-room-type-media-inner/index.md)&gt;[media](index.md#447316607%2FProperties%2F699445674) |
| [merchantName](index.md#-942708284%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[merchantName](index.md#-942708284%2FProperties%2F699445674) |
| [offerId](index.md#-1108106324%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[offerId](index.md#-1108106324%2FProperties%2F699445674) |
| [price](index.md#-1722667846%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RoomTypePrice](../-room-type-price/index.md)[price](index.md#-1722667846%2FProperties%2F699445674) |
| [promotionsDeprecated](index.md#597870644%2FProperties%2F699445674) | [JVM]<br>@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;This property is deprecated.&quot;)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Promotion](../-promotion/index.md)&gt;[~~promotionsDeprecated~~](index.md#597870644%2FProperties%2F699445674) |
| [ratePlans](index.md#230647993%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlan](../-rate-plan/index.md)&gt;[ratePlans](index.md#230647993%2FProperties%2F699445674) |
| [ratePlanType](index.md#-764355276%2FProperties%2F699445674) | [JVM]<br>private final [RoomType.RatePlanType](-rate-plan-type/index.md)[ratePlanType](index.md#-764355276%2FProperties%2F699445674) |
| [roomKey](index.md#522068319%2FProperties%2F699445674) | [JVM]<br>@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;This property is deprecated.&quot;)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[~~roomKey~~](index.md#522068319%2FProperties%2F699445674) |
| [roomOccupancyPolicy](index.md#-368086433%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RoomOccupancyPolicy](../-room-occupancy-policy/index.md)[roomOccupancyPolicy](index.md#-368086433%2FProperties%2F699445674) |
| [smokingOption](index.md#-917381886%2FProperties%2F699445674) | [JVM]<br>private final [RoomType.SmokingOption](-smoking-option/index.md)[smokingOption](index.md#-917381886%2FProperties%2F699445674) |
| [standalonePrice](index.md#-74736929%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RoomTypeStandalonePrice](../-room-type-standalone-price/index.md)[standalonePrice](index.md#-74736929%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomType.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmenities](get-amenities.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomTypeAmenitiesInner](../-room-type-amenities-inner/index.md)&gt;[getAmenities](get-amenities.md)() |
| [getBedTypeOptions](get-bed-type-options.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BedType](../-bed-type/index.md)&gt;[getBedTypeOptions](get-bed-type-options.md)() |
| [getDescription](get-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDescription](get-description.md)() |
| [getDescriptiveAmenities](get-descriptive-amenities.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getDescriptiveAmenities](get-descriptive-amenities.md)() |
| [getLinks](get-links.md) | [JVM]<br>public final [RoomTypeLinks](../-room-type-links/index.md)[getLinks](get-links.md)() |
| [getMedia](get-media.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomTypeMediaInner](../-room-type-media-inner/index.md)&gt;[getMedia](get-media.md)() |
| [getMerchantName](get-merchant-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMerchantName](get-merchant-name.md)() |
| [getOfferId](get-offer-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getOfferId](get-offer-id.md)() |
| [getPrice](get-price.md) | [JVM]<br>public final [RoomTypePrice](../-room-type-price/index.md)[getPrice](get-price.md)() |
| [getPromotionsDeprecated](get-promotions-deprecated.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Promotion](../-promotion/index.md)&gt;[getPromotionsDeprecated](get-promotions-deprecated.md)() |
| [getRatePlans](get-rate-plans.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RatePlan](../-rate-plan/index.md)&gt;[getRatePlans](get-rate-plans.md)() |
| [getRatePlanType](get-rate-plan-type.md) | [JVM]<br>public final [RoomType.RatePlanType](-rate-plan-type/index.md)[getRatePlanType](get-rate-plan-type.md)() |
| [getRoomKey](get-room-key.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRoomKey](get-room-key.md)() |
| [getRoomOccupancyPolicy](get-room-occupancy-policy.md) | [JVM]<br>public final [RoomOccupancyPolicy](../-room-occupancy-policy/index.md)[getRoomOccupancyPolicy](get-room-occupancy-policy.md)() |
| [getSmokingOption](get-smoking-option.md) | [JVM]<br>public final [RoomType.SmokingOption](-smoking-option/index.md)[getSmokingOption](get-smoking-option.md)() |
| [getStandalonePrice](get-standalone-price.md) | [JVM]<br>public final [RoomTypeStandalonePrice](../-room-type-standalone-price/index.md)[getStandalonePrice](get-standalone-price.md)() |
