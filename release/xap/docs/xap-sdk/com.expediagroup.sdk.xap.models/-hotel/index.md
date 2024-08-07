//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[Hotel](index.md)

# Hotel

public final class [Hotel](index.md)

Container for information on each offered hotel.

#### Parameters

JVM

| | |
|---|---|
| id | The unique, Expedia-specific hotel property identifier used to designate a single hotel. |
| name | The common name of the hotel |
| petFriendly | Indicates whether the property allows certain pets under certain circumstances.  Prior to booking, guests should review the PetPolicies information in the Lodging Details API to find out whether a particular pet will be permitted to stay at the property. |
| hcomId | The unique, Hotels.com-specific hotel property identifier used to designate a single hotel.  This will only be returned if searching via hcomHotelIds in request. |
| propertyType |
| propertyDetails |
| localCurrencyCode | The Local Currency Code for Hotel (which will be used for any fees that must be paid at the hotel) |
| location |
| phoneInfos | Container for property phone numbers.  Note: PhoneInfos section will not return for Vrbo Vacation Rental properties. |
| distance |
| description |
| status | Indicates whether there are available offers at the property during the dates requested, as well as information as to why.  Note that pricing will <u>only</u> be present in the API response for a status of `AVAILABLE`.  If there are no rooms available at the property for the dates requested, then `NOT_AVAILABLE` will be returned.  If there are available rooms, but none that meet the specific parameters of the search request, then one of the other messages will be returned. |
| renovationsAndClosures | The information about renovations and closures |
| chainAndBrandInfo |
| thumbnailUrl | URL of the thumbnail image of the hotel.  Note that other images sizes are available - You can find a link to the complete list of Supported Hotel Image Sizes in [Lodging Image Captions, IDs, and Sizes](https://developers.expediagroup.com/xap/products/xap/lodging/references/image-captions-ids-and-sizes). |
| starRating | Star rating value of the hotel property. |
| guestRating | Average overall guest rating of the hotel.  The value is between 1.0 and 5.0 in 0.1 increments.  Higher is better. |
| guestReviewCount | The total count of guest reviews used to create the average `GuestRating` above. |
| lgbtqiaFriendly | This value is returned if the property owner has specifically designated this property as LGBTQIA-friendly. |
| links |
| policies |
| cleanlinessAndSafety | Container for all cleanliness and safety measures.  The key is the measures category, the values are the information. The category will be: - CLEANLINESS - SOCIAL_DISTANCING - SAFETY - DISCLAIMER |
| optionalExtras | The optional extras info. |
| importantNotices | The important notices for hotel. |
| media | Container for hotel images |
| hotelAmenities | Container for all hotel amenities. |
| hotelDescriptiveAmenities | Container for all hotel amenities in group.  The key is amenity category, the values are the amenity information. The category for grouped amenities in hotel level for conventional lodging hotel will be: - PARKING - FOOD_AND_DRINK - INTERNET - THINGS_TO_DO - FAMILY_FRIENDLY - CONVENIENCES - GUEST_SERVICES - BUSINESS_SERVICE - OUTDOOR - ACCESSIBILITY - SPA - ACTIVITIES_NEARBY - LANGS_SPOKEN - MORE  The category for grouped amenities in hotel level for Vacation Rental hotel will be: - BEACH - SKI - POOL/SPA - INTERNET - PARKING - FAMILY_FRIENDLY - KITCHEN - DINING - BEDROOM - BATHROOMS - LIVING_SPACES - ENTERTAINMENT - OUTDOORS - LAUNDRY - WORKSPACES - CLIMATE_CONTROL - PETS - SUITABILITY/ACCESSIBILITY - SERVICES_AND_CONVENIENCES - LOCATION_HIGHLIGHTS - THINGS_TO_DO - GENERAL - SAFETY |
| roomAmenities | Container for all room amenities. |
| roomDescriptiveAmenities | Container for all common room amenities in group.  The key is amenity category, the values are the amenity information. The category for grouped amenities in common room level will be: - BEDROOM - BATHROOM - FOOD_AND_DRINK - ENTERTAINMENT - OUTDOOR_SPACE - MORE |
| accessibility | The accessibility options available for the room.  Possible accessibility include: - Accessible path of travel - Accessible bathroom - Roll-in shower - Handicapped parking - In-room accessibility - Accessibility equipment for the deaf - Braille or raised signage |
| memberOnlyDealAvailable | Indicates whether the property has member only deal rates available. |
| roomTypes | Container for all of available room types. |

## Constructors

| | |
|---|---|
| [Hotel](-hotel.md) | [JVM]<br>public [Hotel](index.md)[Hotel](-hotel.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)petFriendly, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)hcomId, [HotelPropertyType](../-hotel-property-type/index.md)propertyType, [PropertyDetails](../-property-details/index.md)propertyDetails, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)localCurrencyCode, [HotelLocation](../-hotel-location/index.md)location, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Phone](../-phone/index.md)&gt;phoneInfos, [Distance](../-distance/index.md)distance, [Description](../-description/index.md)description, [Hotel.Status](-status/index.md)status, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;renovationsAndClosures, [ChainAndBrandInfo](../-chain-and-brand-info/index.md)chainAndBrandInfo, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)thumbnailUrl, [Hotel.StarRating](-star-rating/index.md)starRating, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)guestRating, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)guestReviewCount, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)lgbtqiaFriendly, [HotelLinks](../-hotel-links/index.md)links, [HotelPolicies](../-hotel-policies/index.md)policies, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;cleanlinessAndSafety, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;optionalExtras, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;importantNotices, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Media](../-media/index.md)&gt;media, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelHotelAmenitiesInner](../-hotel-hotel-amenities-inner/index.md)&gt;hotelAmenities, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;hotelDescriptiveAmenities, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelRoomAmenitiesInner](../-hotel-room-amenities-inner/index.md)&gt;roomAmenities, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;roomDescriptiveAmenities, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;accessibility, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)memberOnlyDealAvailable, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomType](../-room-type/index.md)&gt;roomTypes) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [StarRating](-star-rating/index.md) | [JVM]<br>public enum [StarRating](-star-rating/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Hotel.StarRating](-star-rating/index.md)&gt;<br>Star rating value of the hotel property. Values: _1_PERIOD0,_1_PERIOD5,_2_PERIOD0,_2_PERIOD5,_3_PERIOD0,_3_PERIOD5,_4_PERIOD0,_4_PERIOD5,_5_PERIOD0 |
| [Status](-status/index.md) | [JVM]<br>public enum [Status](-status/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Hotel.Status](-status/index.md)&gt;<br>Indicates whether there are available offers at the property during the dates requested, as well as information as to why.  Note that pricing will <u>only</u> be present in the API response for a status of `AVAILABLE`.  If there are no rooms available at the property for the dates requested, then `NOT_AVAILABLE` will be returned.  If there are available rooms, but none that meet the specific parameters of the search request, then one of the other messages will be returned. Values: AVAILABLE,NOT_AVAILABLE,ERROR,NUMBER_OF_ADULTS_NOT_ACCEPTED,NUMBER_OF_CHILDREN_NOT_ACCEPTED,NUMBER_OF_INFANTS_NOT_ACCEPTED,NUMBER_OF_PERSONS_NOT_ACCEPTED,CHECK_IN_AGE_NOT_ACCEPTED |

## Properties

| Name | Summary |
|---|---|
| [accessibility](index.md#2142975710%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[accessibility](index.md#2142975710%2FProperties%2F699445674) |
| [chainAndBrandInfo](index.md#1140786093%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [ChainAndBrandInfo](../-chain-and-brand-info/index.md)[chainAndBrandInfo](index.md#1140786093%2FProperties%2F699445674) |
| [cleanlinessAndSafety](index.md#625276546%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[cleanlinessAndSafety](index.md#625276546%2FProperties%2F699445674) |
| [description](index.md#1450480560%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Description](../-description/index.md)[description](index.md#1450480560%2FProperties%2F699445674) |
| [distance](index.md#967586649%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Distance](../-distance/index.md)[distance](index.md#967586649%2FProperties%2F699445674) |
| [guestRating](index.md#-2053940169%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[guestRating](index.md#-2053940169%2FProperties%2F699445674) |
| [guestReviewCount](index.md#1594306031%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[guestReviewCount](index.md#1594306031%2FProperties%2F699445674) |
| [hcomId](index.md#-1933457062%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[hcomId](index.md#-1933457062%2FProperties%2F699445674) |
| [hotelAmenities](index.md#1535388811%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelHotelAmenitiesInner](../-hotel-hotel-amenities-inner/index.md)&gt;[hotelAmenities](index.md#1535388811%2FProperties%2F699445674) |
| [hotelDescriptiveAmenities](index.md#937126221%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[hotelDescriptiveAmenities](index.md#937126221%2FProperties%2F699445674) |
| [id](index.md#-260787789%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#-260787789%2FProperties%2F699445674) |
| [importantNotices](index.md#1530791093%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[importantNotices](index.md#1530791093%2FProperties%2F699445674) |
| [lgbtqiaFriendly](index.md#-2137919835%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[lgbtqiaFriendly](index.md#-2137919835%2FProperties%2F699445674) |
| [links](index.md#-1940109869%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [HotelLinks](../-hotel-links/index.md)[links](index.md#-1940109869%2FProperties%2F699445674) |
| [localCurrencyCode](index.md#-1882068893%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[localCurrencyCode](index.md#-1882068893%2FProperties%2F699445674) |
| [location](index.md#460838809%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [HotelLocation](../-hotel-location/index.md)[location](index.md#460838809%2FProperties%2F699445674) |
| [media](index.md#-340452344%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Media](../-media/index.md)&gt;[media](index.md#-340452344%2FProperties%2F699445674) |
| [memberOnlyDealAvailable](index.md#-639730283%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[memberOnlyDealAvailable](index.md#-639730283%2FProperties%2F699445674) |
| [name](index.md#-607692285%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#-607692285%2FProperties%2F699445674) |
| [optionalExtras](index.md#370806891%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[optionalExtras](index.md#370806891%2FProperties%2F699445674) |
| [petFriendly](index.md#2048798850%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[petFriendly](index.md#2048798850%2FProperties%2F699445674) |
| [phoneInfos](index.md#-1543222121%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Phone](../-phone/index.md)&gt;[phoneInfos](index.md#-1543222121%2FProperties%2F699445674) |
| [policies](index.md#-500106658%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [HotelPolicies](../-hotel-policies/index.md)[policies](index.md#-500106658%2FProperties%2F699445674) |
| [propertyDetails](index.md#-1235018081%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [PropertyDetails](../-property-details/index.md)[propertyDetails](index.md#-1235018081%2FProperties%2F699445674) |
| [propertyType](index.md#1105401183%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [HotelPropertyType](../-hotel-property-type/index.md)[propertyType](index.md#1105401183%2FProperties%2F699445674) |
| [renovationsAndClosures](index.md#-762688321%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[renovationsAndClosures](index.md#-762688321%2FProperties%2F699445674) |
| [roomAmenities](index.md#1717505392%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelRoomAmenitiesInner](../-hotel-room-amenities-inner/index.md)&gt;[roomAmenities](index.md#1717505392%2FProperties%2F699445674) |
| [roomDescriptiveAmenities](index.md#324892488%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[roomDescriptiveAmenities](index.md#324892488%2FProperties%2F699445674) |
| [roomTypes](index.md#-383155890%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomType](../-room-type/index.md)&gt;[roomTypes](index.md#-383155890%2FProperties%2F699445674) |
| [starRating](index.md#-222615105%2FProperties%2F699445674) | [JVM]<br>private final [Hotel.StarRating](-star-rating/index.md)[starRating](index.md#-222615105%2FProperties%2F699445674) |
| [status](index.md#-952287684%2FProperties%2F699445674) | [JVM]<br>private final [Hotel.Status](-status/index.md)[status](index.md#-952287684%2FProperties%2F699445674) |
| [thumbnailUrl](index.md#118579627%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[thumbnailUrl](index.md#118579627%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Hotel.Builder](-builder/index.md)[builder](builder.md)() |
| [getAccessibility](get-accessibility.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getAccessibility](get-accessibility.md)() |
| [getChainAndBrandInfo](get-chain-and-brand-info.md) | [JVM]<br>public final [ChainAndBrandInfo](../-chain-and-brand-info/index.md)[getChainAndBrandInfo](get-chain-and-brand-info.md)() |
| [getCleanlinessAndSafety](get-cleanliness-and-safety.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getCleanlinessAndSafety](get-cleanliness-and-safety.md)() |
| [getDescription](get-description.md) | [JVM]<br>public final [Description](../-description/index.md)[getDescription](get-description.md)() |
| [getDistance](get-distance.md) | [JVM]<br>public final [Distance](../-distance/index.md)[getDistance](get-distance.md)() |
| [getGuestRating](get-guest-rating.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGuestRating](get-guest-rating.md)() |
| [getGuestReviewCount](get-guest-review-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getGuestReviewCount](get-guest-review-count.md)() |
| [getHcomId](get-hcom-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getHcomId](get-hcom-id.md)() |
| [getHotelAmenities](get-hotel-amenities.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelHotelAmenitiesInner](../-hotel-hotel-amenities-inner/index.md)&gt;[getHotelAmenities](get-hotel-amenities.md)() |
| [getHotelDescriptiveAmenities](get-hotel-descriptive-amenities.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getHotelDescriptiveAmenities](get-hotel-descriptive-amenities.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getImportantNotices](get-important-notices.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getImportantNotices](get-important-notices.md)() |
| [getLgbtqiaFriendly](get-lgbtqia-friendly.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getLgbtqiaFriendly](get-lgbtqia-friendly.md)() |
| [getLinks](get-links.md) | [JVM]<br>public final [HotelLinks](../-hotel-links/index.md)[getLinks](get-links.md)() |
| [getLocalCurrencyCode](get-local-currency-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLocalCurrencyCode](get-local-currency-code.md)() |
| [getLocation](get-location.md) | [JVM]<br>public final [HotelLocation](../-hotel-location/index.md)[getLocation](get-location.md)() |
| [getMedia](get-media.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Media](../-media/index.md)&gt;[getMedia](get-media.md)() |
| [getMemberOnlyDealAvailable](get-member-only-deal-available.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getMemberOnlyDealAvailable](get-member-only-deal-available.md)() |
| [getName](get-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
| [getOptionalExtras](get-optional-extras.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getOptionalExtras](get-optional-extras.md)() |
| [getPetFriendly](get-pet-friendly.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getPetFriendly](get-pet-friendly.md)() |
| [getPhoneInfos](get-phone-infos.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Phone](../-phone/index.md)&gt;[getPhoneInfos](get-phone-infos.md)() |
| [getPolicies](get-policies.md) | [JVM]<br>public final [HotelPolicies](../-hotel-policies/index.md)[getPolicies](get-policies.md)() |
| [getPropertyDetails](get-property-details.md) | [JVM]<br>public final [PropertyDetails](../-property-details/index.md)[getPropertyDetails](get-property-details.md)() |
| [getPropertyType](get-property-type.md) | [JVM]<br>public final [HotelPropertyType](../-hotel-property-type/index.md)[getPropertyType](get-property-type.md)() |
| [getRenovationsAndClosures](get-renovations-and-closures.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getRenovationsAndClosures](get-renovations-and-closures.md)() |
| [getRoomAmenities](get-room-amenities.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelRoomAmenitiesInner](../-hotel-room-amenities-inner/index.md)&gt;[getRoomAmenities](get-room-amenities.md)() |
| [getRoomDescriptiveAmenities](get-room-descriptive-amenities.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getRoomDescriptiveAmenities](get-room-descriptive-amenities.md)() |
| [getRoomTypes](get-room-types.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomType](../-room-type/index.md)&gt;[getRoomTypes](get-room-types.md)() |
| [getStarRating](get-star-rating.md) | [JVM]<br>public final [Hotel.StarRating](-star-rating/index.md)[getStarRating](get-star-rating.md)() |
| [getStatus](get-status.md) | [JVM]<br>public final [Hotel.Status](-status/index.md)[getStatus](get-status.md)() |
| [getThumbnailUrl](get-thumbnail-url.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getThumbnailUrl](get-thumbnail-url.md)() |
