//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[Hotel](index.md)/[Hotel](-hotel.md)

# Hotel

[JVM]\

public [Hotel](index.md)[Hotel](-hotel.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)petFriendly, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)hcomId, [HotelPropertyType](../-hotel-property-type/index.md)propertyType, [PropertyDetails](../-property-details/index.md)propertyDetails, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)localCurrencyCode, [HotelLocation](../-hotel-location/index.md)location, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Phone](../-phone/index.md)&gt;phoneInfos, [Distance](../-distance/index.md)distance, [Description](../-description/index.md)description, [Hotel.Status](-status/index.md)status, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;renovationsAndClosures, [ChainAndBrandInfo](../-chain-and-brand-info/index.md)chainAndBrandInfo, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)thumbnailUrl, [Hotel.StarRating](-star-rating/index.md)starRating, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)guestRating, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)guestReviewCount, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)lgbtqiaFriendly, [HotelLinks](../-hotel-links/index.md)links, [HotelPolicies](../-hotel-policies/index.md)policies, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;cleanlinessAndSafety, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;optionalExtras, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;importantNotices, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Media](../-media/index.md)&gt;media, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelHotelAmenitiesInner](../-hotel-hotel-amenities-inner/index.md)&gt;hotelAmenities, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;hotelDescriptiveAmenities, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelRoomAmenitiesInner](../-hotel-room-amenities-inner/index.md)&gt;roomAmenities, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;roomDescriptiveAmenities, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;accessibility, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)memberOnlyDealAvailable, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomType](../-room-type/index.md)&gt;roomTypes)

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
