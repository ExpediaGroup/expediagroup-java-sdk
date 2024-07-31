//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[executeAsync](execute-async.md)

# executeAsync

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;EmptyResponse&gt;[executeAsync](execute-async.md)([ChangeRoomDetailsOperation](../../com.expediagroup.sdk.rapid.operations/-change-room-details-operation/index.md)operation)

Change details of a room. This link will be available in the retrieve response. Changes in smoking preference and special request will be passed along to the property and are not guaranteed.

#### Return

a CompletableFuture<Response> object with a body of type Nothing

#### Parameters

JVM

| | |
|---|---|
| operation | [ChangeRoomDetailsOperation](../../com.expediagroup.sdk.rapid.operations/-change-room-details-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;EmptyResponse&gt;[executeAsync](execute-async.md)([CommitChangeOperation](../../com.expediagroup.sdk.rapid.operations/-commit-change-operation/index.md)operation)

Commit a change of itinerary that may require additional payment or refund. This link will be available in the change response to confirm and complete the change transaction.  If additional charges are due, a payment must be submitted with this request. Note that Two-Factor  Authentication is not supported at this time.

#### Return

a CompletableFuture<Response> object with a body of type Nothing

#### Parameters

JVM

| | |
|---|---|
| operation | [CommitChangeOperation](../../com.expediagroup.sdk.rapid.operations/-commit-change-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;EmptyResponse&gt;[executeAsync](execute-async.md)([DeleteHeldBookingOperation](../../com.expediagroup.sdk.rapid.operations/-delete-held-booking-operation/index.md)operation)

Cancel Held Booking This link will be available in a held booking response.

#### Return

a CompletableFuture<Response> object with a body of type Nothing

#### Parameters

JVM

| | |
|---|---|
| operation | [DeleteHeldBookingOperation](../../com.expediagroup.sdk.rapid.operations/-delete-held-booking-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;EmptyResponse&gt;[executeAsync](execute-async.md)([DeleteRoomOperation](../../com.expediagroup.sdk.rapid.operations/-delete-room-operation/index.md)operation)

Cancel a room. This link will be available in the retrieve response.

#### Return

a CompletableFuture<Response> object with a body of type Nothing

#### Parameters

JVM

| | |
|---|---|
| operation | [DeleteRoomOperation](../../com.expediagroup.sdk.rapid.operations/-delete-room-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PropertyAvailability](../../com.expediagroup.sdk.rapid.models/-property-availability/index.md)&gt;&gt;&gt;[executeAsync](execute-async.md)([GetAdditionalAvailabilityOperation](../../com.expediagroup.sdk.rapid.operations/-get-additional-availability-operation/index.md)operation)

Get additional property room rates and availability Returns additional rates on available room types, using the parameters of the previous call.  The response includes rate details such as promos, whether the rate is refundable, cancellation penalties and a full price breakdown to meet the price display requirements for your market. *Note*: If there are no available rooms, the response will be an empty array. * The `nightly` array includes each individual night's charges. When the total price includes fees, charges, or adjustments that are not divided by night, these amounts will be included in the `stay` rate array, which details charges applied to the entire stay (each check-in).

#### Return

a CompletableFuture<Response> object with a body of type kotlin.collections.List<PropertyAvailability>

#### Parameters

JVM

| | |
|---|---|
| operation | [GetAdditionalAvailabilityOperation](../../com.expediagroup.sdk.rapid.operations/-get-additional-availability-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Property](../../com.expediagroup.sdk.rapid.models/-property/index.md)&gt;&gt;&gt;[executeAsync](execute-async.md)([GetAvailabilityOperation](../../com.expediagroup.sdk.rapid.operations/-get-availability-operation/index.md)operation)

Get property room rates and availability Returns rates on available room types for specified properties (maximum of 250 properties per request).  The response includes rate details such as promos, whether the rate is refundable, cancellation penalties and a full price breakdown to meet the price display requirements for your market. *Note*: If there are no available rooms, the response will be an empty array. * Multiple rooms of the same type may be requested by including multiple instances of the `occupancy` parameter. * The `nightly` array includes each individual night's charges. When the total price includes fees, charges, or adjustments that are not divided by night, these amounts will be included in the `stay` rate array, which details charges applied to the entire stay (each check-in).

#### Return

a CompletableFuture<Response> object with a body of type kotlin.collections.List<Property>

#### Parameters

JVM

| | |
|---|---|
| operation | [GetAvailabilityOperation](../../com.expediagroup.sdk.rapid.operations/-get-availability-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PropertyCalendarAvailability](../../com.expediagroup.sdk.rapid.models/-property-calendar-availability/index.md)&gt;&gt;&gt;[executeAsync](execute-async.md)([GetCalendarAvailabilityOperation](../../com.expediagroup.sdk.rapid.operations/-get-calendar-availability-operation/index.md)operation)

Get a calendar of availability dates for properties. This is currently a Vrbo property only feature. Returns availability information for the specified properties (maximum of 25 properties per request).  The response includes per day information about the property's availability, information about if check-in or check-out is available for the day,   and information regarding the stay constraints.

#### Return

a CompletableFuture<Response> object with a body of type kotlin.collections.List<PropertyCalendarAvailability>

#### Parameters

JVM

| | |
|---|---|
| operation | [GetCalendarAvailabilityOperation](../../com.expediagroup.sdk.rapid.operations/-get-calendar-availability-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Chain](../../com.expediagroup.sdk.rapid.models/-chain/index.md)&gt;&gt;&gt;[executeAsync](execute-async.md)([GetChainReferenceOperation](../../com.expediagroup.sdk.rapid.operations/-get-chain-reference-operation/index.md)operation)

Chain Reference Returns a complete collection of chains recognized by the Rapid API. <br>Chains represent a parent company which can have multiple brands associated with it. A brand can only be associated with one chain. For example, Hilton Worldwide is a chain that has multiple associated brands including DoubleTree, Hampton Inn and Embassy Suites. <br>The response is a JSON map where the key is the chain ID and the value is a chain object. Each chain object also contains a map of its related brands. <br>Note that the set of chain IDs and brand IDs are totally independent of one another. It is possible for a chain and a brand to both use the same number as their ID, but this is just a coincidence that holds no meaning. <br>Chain and brand names are provided in English only.

#### Return

a CompletableFuture<Response> object with a body of type kotlin.collections.Map<kotlin.String, Chain>

#### Parameters

JVM

| | |
|---|---|
| operation | [GetChainReferenceOperation](../../com.expediagroup.sdk.rapid.operations/-get-chain-reference-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PropertyInactive](../../com.expediagroup.sdk.rapid.models/-property-inactive/index.md)&gt;&gt;&gt;[executeAsync](execute-async.md)([GetInactivePropertiesOperation](../../com.expediagroup.sdk.rapid.operations/-get-inactive-properties-operation/index.md)operation)

Inactive Properties Request a list of properties that are inactive because they have been removed from sale since a specified date.<br><br> When there are a large number of properties in the response, it will be paginated. See the `Link` header in the 200 response section.

#### Return

a CompletableFuture<Response> object with a body of type kotlin.collections.List<PropertyInactive>

#### Parameters

JVM

| | |
|---|---|
| operation | [GetInactivePropertiesOperation](../../com.expediagroup.sdk.rapid.operations/-get-inactive-properties-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[PaymentOption](../../com.expediagroup.sdk.rapid.models/-payment-option/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetPaymentOptionsOperation](../../com.expediagroup.sdk.rapid.operations/-get-payment-options-operation/index.md)operation)

Get Accepted Payment Types - EPS MOR Only Returns the accepted payment options.  Use this API to power your checkout page and display valid forms of payment, ensuring a smooth booking.

#### Return

a CompletableFuture<Response> object with a body of type PaymentOption

#### Parameters

JVM

| | |
|---|---|
| operation | [GetPaymentOptionsOperation](../../com.expediagroup.sdk.rapid.operations/-get-payment-options-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[Link](../../com.expediagroup.sdk.rapid.models/-link/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetPropertyCatalogFileOperation](../../com.expediagroup.sdk.rapid.operations/-get-property-catalog-file-operation/index.md)operation)

Property Catalog File Returns a link to download the master list of EPS's active properties in the requested language. The response includes high-level details about each property.<br> This file is in JSONL format and is gzipped. The schema of each JSON object in the JSONL file is a subset of the schema of each JSON object from the Property Content call. The subset of fields included are:   * `property_id`   * `name`   * `address`   * `ratings`   * `location`   * `phone`   * `fax`   * `category`   * `rank`   * `business_model`   * `dates`   * `statistics`   * `chain`   * `brand`   * `supply_source`  Example of a JSONL file with 2 properties: ```nowrap {\"property_id\":\"12345\",\"name\":\"Test Property Name\",\"address\":{\"line_1\":\"123 Main St\",\"line_2\":\"Apt A\",\"city\":\"Springfield\",\"state_province_code\":\"MO\",\"state_province_name\":\"Missouri\",\"postal_code\":\"65804\",\"country_code\":\"US\",\"obfuscation_required\":false,\"localized\":{\"links\":{\"es-ES\":{\"method\":\"GET\",\"href\":\"https://api.ean.com/v3/properties/content?language=es-ES&include=address&property_id=12345\"},\"fr-FR\":{\"method\":\"GET\",\"href\":\"https://api.ean.com/v3/properties/content?language=fr-FR&include=address&property_id=12345\"}}}},\"ratings\":{\"property\":{\"rating\":\"3.5\",\"type\":\"Star\"},\"guest\":{\"count\":48382,\"overall\":\"3.1\",\"cleanliness\":\"4.2\",\"service\":\"1.1\",\"comfort\":\"4.3\",\"condition\":\"1.6\",\"location\":\"4.0\",\"neighborhood\":\"3.4\",\"quality\":\"3.4\",\"value\":\"2.2\",\"amenities\":\"1.4\",\"recommendation_percent\":\"73%\"}},\"location\":{\"coordinates\":{\"latitude\":37.15845,\"longitude\":-93.26838}},\"phone\":\"1-417-862-0153\",\"fax\":\"1-417-863-7249\",\"category\":{\"id\":\"1\",\"name\":\"Hotel\"},\"rank\":42,\"business_model\":{\"expedia_collect\":true,\"property_collect\":false},\"dates\":{\"added\":\"1998-07-19T05:00:00.000Z\",\"updated\":\"2018-03-22T07:23:14.000Z\"},\"statistics\":{\"52\":{\"id\":\"52\",\"name\":\"Total number of rooms - 820\",\"value\":\"820\"},\"54\":{\"id\":\"54\",\"name\":\"Number of floors - 38\",\"value\":\"38\"}},\"chain\":{\"id\":\"-6\",\"name\":\"Hyatt Hotels\"},\"brand\":{\"id\":\"2209\",\"name\":\"Hyatt Place\"},\"supply_source\":\"expedia\"} {\"property_id\":\"67890\",\"name\":\"Test Property Name 2\",\"address\":{\"line_1\":\"123 Main St\",\"line_2\":\"Apt A\",\"city\":\"Springfield\",\"state_province_code\":\"MO\",\"state_province_name\":\"Missouri\",\"postal_code\":\"65804\",\"country_code\":\"US\",\"obfuscation_required\":true,\"localized\":{\"links\":{\"es-ES\":{\"method\":\"GET\",\"href\":\"https://api.ean.com/v3/properties/content?language=es-ES&include=address&property_id=67890\"},\"de-DE\":{\"method\":\"GET\",\"href\":\"https://api.ean.com/v3/properties/content?language=de-DE&include=address&property_id=67890\"}}}},\"ratings\":{\"property\":{\"rating\":\"3.5\",\"type\":\"Star\"},\"guest\":{\"count\":7651,\"overall\":\"4.3\",\"cleanliness\":\"4.2\",\"service\":\"1.1\",\"comfort\":\"4.3\",\"condition\":\"1.6\",\"location\":\"4.0\",\"neighborhood\":\"3.4\",\"quality\":\"3.4\",\"value\":\"2.2\",\"amenities\":\"1.4\",\"recommendation_percent\":\"80%\"}},\"location\":{\"coordinates\":{\"latitude\":37.15845,\"longitude\":-93.26838}},\"phone\":\"1-417-862-0153\",\"fax\":\"1-417-863-7249\",\"category\":{\"id\":\"1\",\"name\":\"Hotel\"},\"rank\":42,\"business_model\":{\"expedia_collect\":true,\"property_collect\":true},\"dates\":{\"added\":\"1998-07-20T05:00:00.000Z\",\"updated\":\"2018-03-22T13:33:17.000Z\"},\"statistics\":{\"52\":{\"id\":\"52\",\"name\":\"Total number of rooms - 820\",\"value\":\"820\"},\"54\":{\"id\":\"54\",\"name\":\"Number of floors - 38\",\"value\":\"38\"}},\"chain\":{\"id\":\"-5\",\"name\":\"Hilton Worldwide\"},\"brand\":{\"id\":\"358\",\"name\":\"Hampton Inn\"},\"supply_source\":\"expedia\"} ```  @param operation [GetPropertyCatalogFileOperation](../../com.expediagroup.sdk.rapid.operations/-get-property-catalog-file-operation/index.md) @throws ExpediaGroupApiErrorException @return a CompletableFuture<Response> object with a body of type Link

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PropertyContent](../../com.expediagroup.sdk.rapid.models/-property-content/index.md)&gt;&gt;&gt;[executeAsync](execute-async.md)([GetPropertyContentOperation](../../com.expediagroup.sdk.rapid.operations/-get-property-content-operation/index.md)operation)

Property Content Search property content for active properties in the requested language.<br><br> When searching with query parameter, `property_id`, you may request 1 to 250 properties at a time.<br><br> When searching with query parameters other than `property_id`, the response will be paginated. See the `Link` header in the 200 response section.<br><br> The response is a JSON map where the key is the property ID and the value is the property object itself, which can include property-level, room-level and rate-level information.

#### Return

a CompletableFuture<Response> object with a body of type kotlin.collections.Map<kotlin.String, PropertyContent>

#### Parameters

JVM

| | |
|---|---|
| operation | [GetPropertyContentOperation](../../com.expediagroup.sdk.rapid.operations/-get-property-content-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[Link](../../com.expediagroup.sdk.rapid.models/-link/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetPropertyContentFileOperation](../../com.expediagroup.sdk.rapid.operations/-get-property-content-file-operation/index.md)operation)

Property Content File Returns a link to download all content for all of EPS’s active properties in the requested language. The response includes property-level, room-level and rate-level information. <br><br>This file is in JSONL format and is gzipped. The schema of each JSON object in the JSONL file is the same as the schema of each JSON object from the Property Content call. <br><br>Example of a JSONL file with 2 properties: ```nowrap {\"property_id\":\"12345\",\"name\":\"Test Property Name\",\"address\":{\"line_1\":\"123 Main St\",\"line_2\":\"Apt A\",\"city\":\"Springfield\",\"state_province_code\":\"MO\",\"state_province_name\":\"Missouri\",\"postal_code\":\"65804\",\"country_code\":\"US\",\"obfuscation_required\":false,\"localized\":{\"links\":{\"es-ES\":{\"method\":\"GET\",\"href\":\"https://api.ean.com/v3/properties/content?language=es-ES&include=address&property_id=12345\"},\"fr-FR\":{\"method\":\"GET\",\"href\":\"https://api.ean.com/v3/properties/content?language=fr-FR&include=address&property_id=12345\"}}}},\"ratings\":{\"property\":{\"rating\":\"3.5\",\"type\":\"Star\"},\"guest\":{\"count\":48382,\"overall\":\"3.1\",\"cleanliness\":\"4.2\",\"service\":\"1.1\",\"comfort\":\"4.3\",\"condition\":\"1.6\",\"location\":\"4.0\",\"neighborhood\":\"3.4\",\"quality\":\"3.4\",\"value\":\"2.2\",\"amenities\":\"1.4\",\"recommendation_percent\":\"73%\"}},\"location\":{\"coordinates\":{\"latitude\":37.15845,\"longitude\":-93.26838}},\"phone\":\"1-417-862-0153\",\"fax\":\"1-417-863-7249\",\"category\":{\"id\":\"1\",\"name\":\"Hotel\"},\"rank\":42,\"business_model\":{\"expedia_collect\":true,\"property_collect\":false},\"checkin\":{\"24_hour\":\"24-hour check-in\",\"begin_time\":\"3:00 PM\",\"end_time\":\"11:00 PM\",\"instructions\":\"Extra-person charges may apply and vary depending on hotel policy. &lt;br />Government-issued photo identification and a credit card or cash deposit are required at check-in for incidental charges. &lt;br />Special requests are subject to availability upon check-in and may incur additional charges. Special requests cannot be guaranteed. &lt;br />\",\"special_instructions\":\"There is no front desk at this property. To make arrangements for check-in please contact the property ahead of time using the information on the booking confirmation.\",\"min_age\":18},\"checkout\":{\"time\":\"11:00 AM\"},\"fees\":{\"mandatory\":\"<p>You'll be asked to pay the following charges at the hotel:</p> <ul><li>Deposit: USD 50 per day</li><li>Resort fee: USD 29.12 per accommodation, per night</li></ul> The hotel resort fee includes:<ul><li>Fitness center access</li><li>Internet access</li><li>Phone calls</li><li>Additional inclusions</li></ul> <p>We have included all charges provided to us by the property. However, charges can vary, for example, based on length of stay or the room you book. </p>\",\"optional\":\"Fee for in-room wireless Internet: USD 15 per hour (rates may vary)</li> <li>Airport shuttle fee: USD 350 per vehicle (one way)</li>           <li>Rollaway bed fee: USD 175 per night</li>\"},\"policies\":{\"know_before_you_go\":\"Reservations are required for massage services and spa treatments. Reservations can be made by contacting the hotel prior to arrival, using the contact information on the booking confirmation. </li><li>Children 11 years old and younger stay free when occupying the parent or guardian's room, using existing bedding. </li><li>Only registered guests are allowed in the guestrooms. </li> <li>Some facilities may have restricted access. Guests can contact the property for details using the contact information on the booking confirmation. </li> </ul>\"},\"attributes\":{\"general\":{\"2549\":{\"id\":\"2549\",\"name\":\"No elevators\"},\"3357\":{\"id\":\"3357\",\"name\":\"Caters to adults only\"}},\"pets\":{\"51\":{\"id\":\"51\",\"name\":\"Pets allowed\"},\"2809\":{\"id\":\"2809\",\"name\":\"Dogs only\"},\"3321\":{\"id\":\"3321\",\"name\":\"Pet maximum weight in kg is - 24\",\"value\":24}}},\"amenities\":{\"9\":{\"id\":\"9\",\"name\":\"Fitness facilities\"},\"2820\":{\"id\":\"2820\",\"name\":\"Number of indoor pools - 10\",\"value\":10}},\"images\":[{\"caption\":\"Featured Image\",\"hero_image\":true,\"category\":3,\"links\":{\"70px\":{\"method\":\"GET\",\"href\":\"https://i.travelapi.com/hotels/1000000/20000/15300/15237/bef1b976_t.jpg\"}}}],\"onsite_payments\":{\"currency\":\"USD\",\"types\":{\"171\":{\"id\":\"171\",\"name\":\"American Express\"}}},\"rooms\":{\"224829\":{\"id\":\"224829\",\"name\":\"Single Room\",\"descriptions\":{\"overview\":\"<strong>2 Twin Beds</strong><br />269-sq-foot (25-sq-meter) room with mountain views<br /><br /><b>Internet</b> - Free WiFi <br /> <b>Entertainment</b> - Flat-screen TV with cable channels<br /><b>Food & Drink</b> - Refrigerator, coffee/tea maker,  room service, and free bottled water<br /><b>Sleep</b> - Premium bedding <br /><b>Bathroom</b> - Private bathroom, shower, bathrobes, and free toiletries<br /><b>Practical</b> - Safe and desk; cribs/infant beds available on request<br /><b>Comfort</b> - Climate-controlled air conditioning and daily housekeeping<br />Non-Smoking<br />\"},\"amenities\":{\"130\":{\"id\":\"130\",\"name\":\"Refrigerator\"},\"1234\":{\"id\":\"1234\",\"name\":\"Test Amenity - 200\",\"value\":\"200\"}},\"images\":[{\"hero_image\":true,\"category\":21001,\"links\":{\"70px\":{\"method\":\"GET\",\"href\":\"https://i.travelapi.com/hotels/1000000/20000/15300/15237/bef1b976_t.jpg\"}},\"caption\":\"Guestroom\"}],\"bed_groups\":{\"37321\":{\"id\":\"37321\",\"description\":\"1 King Bed\",\"configuration\":[{\"type\":\"KingBed\",\"size\":\"King\",\"quantity\":1}]}},\"area\":{\"square_meters\":20,\"square_feet\":215},\"views\":{\"4146\":{\"id\":\"4146\",\"name\":\"Courtyard view\"}},\"occupancy\":{\"max_allowed\":{\"total\":5,\"children\":2,\"adults\":4},\"age_categories\":{\"Adult\":{\"name\":\"Adult\",\"minimum_age\":9}}}}},\"rates\":{\"333abc\":{\"id\":\"333abc\",\"amenities\":{\"1234\":{\"id\":\"1234\",\"name\":\"Test Amenity - 200\",\"value\":\"200\"},\"2104\":{\"id\":\"2104\",\"name\":\"Full Breakfast\"}},\"special_offer_description\":\"<strong>Breakfast for 2</strong> - Rate includes the following:\\r\\n<ul><li>Accommodations as selected</li>\\r\\n<li>Breakfast in hotel restaurant for up to 2 adults and children 12 years old and under registered in the same room</li>\\r\\n</ul><em>Must book this rate plan to receive benefits. Details provided at check-in. Taxes and gratuity may not be included. No refunds for any unused portion of offer. Offer subject to availability. Offer is not valid with groups/conventions and may not be combined with other promotional offers. Other restrictions and blackout dates may apply.</em>\\r\\n\"}},\"dates\":{\"added\":\"1998-07-19T05:00:00.000Z\",\"updated\":\"2018-03-22T07:23:14.000Z\"},\"descriptions\":{\"amenities\":\"Don't miss out on the many recreational opportunities, including an outdoor pool, a sauna, and a fitness center. Additional features at this hotel include complimentary wireless Internet access, concierge services, and an arcade/game room.\",\"dining\":\"Grab a bite at one of the hotel's 3 restaurants, or stay in and take advantage of 24-hour room service. Quench your thirst with your favorite drink at a bar/lounge. Buffet breakfasts are available daily for a fee.\",\"renovations\":\"During renovations, the hotel will make every effort to minimize noise and disturbance.  The property will be renovating from 08 May 2017 to 18 May 2017 (completion date subject to change). The following areas are affected:  <ul><li>Fitness facilities</li></ul>\",\"national_ratings\":\"For the benefit of our customers, we have provided a rating based on our rating system.\",\"business_amenities\":\"Featured amenities include complimentary wired Internet access, a 24-hour business center, and limo/town car service. Event facilities at this hotel consist of a conference center and meeting rooms. Free self parking is available onsite.\",\"rooms\":\"Make yourself at home in one of the 334 air-conditioned rooms featuring LCD televisions. Complimentary wired and wireless Internet access keeps you connected, and satellite programming provides entertainment. Private bathrooms with separate bathtubs and showers feature deep soaking bathtubs and complimentary toiletries. Conveniences include phones, as well as safes and desks.\",\"attractions\":\"Distances are calculated in a straight line from the property's location to the point of interest or attraction, and may not reflect actual travel distance. <br /><br /> Distances are displayed to the nearest 0.1 mile and kilometer. <p>Sogo Department Store - 0.7 km / 0.4 mi <br />National Museum of Natural Science - 1.1 km / 0.7 mi <br />Shr-Hwa International Tower - 1.4 km / 0.8 mi <br />Shinkong Mitsukoshi Department Store - 1.5 km / 0.9 mi <br />Taichung Metropolitan Opera House - 1.7 km / 1 mi <br />Tiger City Mall - 1.8 km / 1.1 mi <br />Maple Garden Park - 1.9 km / 1.2 mi <br />National Museum of Fine Arts - 2.1 km / 1.3 mi <br />Feng Chia University - 2.4 km / 1.5 mi <br />Bao An Temple - 2.5 km / 1.6 mi <br />Fengjia Night Market - 2.5 km / 1.6 mi <br />Zhonghua Night Market - 2.7 km / 1.7 mi <br />Chonglun Park - 2.9 km / 1.8 mi <br />Wan He Temple - 2.9 km / 1.8 mi <br />Chungyo Department Store - 3.1 km / 1.9 mi <br /></p><p>The nearest airports are:<br />Taichung (RMQ) - 12 km / 7.5 mi<br />Taipei (TPE-Taoyuan Intl.) - 118.3 km / 73.5 mi<br />Taipei (TSA-Songshan) - 135.5 km / 84.2 mi<br /></p><p></p>\",\"location\":\"This 4-star hotel is within close proximity of Shr-Hwa International Tower and Shinkong Mitsukoshi Department Store.  A stay at Tempus Hotel Taichung places you in the heart of Taichung, convenient to Sogo Department Store and National Museum of Natural Science.\",\"headline\":\"Near National Museum of Natural Science\",\"general\":\"General description\"},\"statistics\":{\"52\":{\"id\":\"52\",\"name\":\"Total number of rooms - 820\",\"value\":\"820\"},\"54\":{\"id\":\"54\",\"name\":\"Number of floors - 38\",\"value\":\"38\"}},\"airports\":{\"preferred\":{\"iata_airport_code\":\"SGF\"}},\"themes\":{\"2337\":{\"id\":\"2337\",\"name\":\"Luxury Hotel\"},\"2341\":{\"id\":\"2341\",\"name\":\"Spa Hotel\"}},\"all_inclusive\":{\"all_rate_plans\":true,\"some_rate_plans\":false,\"details\":\"<p>This resort is all-inclusive. Onsite food and beverages are included in the room price (some restrictions may apply). </p><p><strong>Activities and facilities/equipment</strong><br />Land activities<ul><li>Fitness facilities</li></ul><br />Lessons/classes/games <ul><li>Pilates</li><li>Yoga</li></ul></p><p><strong>Entertainment</strong><ul><li>Onsite entertainment and activities</li><li>Onsite live performances</li></ul></p>\"},\"tax_id\":\"AB-012-987-1234-01\",\"chain\":{\"id\":\"-6\",\"name\":\"Hyatt Hotels\"},\"brand\":{\"id\":\"2209\",\"name\":\"Hyatt Place\"},\"spoken_languages\":{\"vi\":{\"id\":\"vi\",\"name\":\"Vietnamese\"}},\"multi_unit\":true,\"payment_registration_recommended\":false,\"vacation_rental_details\": {\"registry_number\": \"Property Registration Number 123456\",\"private_host\": \"true\",\"property_manager\": {\"name\": \"Victor\",\"links\": {\"image\": {\"method\": \"GET\",\"href\": \"https://test-image/test/test/836f1097-fbcf-43b5-bc02-c8ff6658cb90.c1.jpg\"}}},\"rental_agreement\": {\"links\": {\"rental_agreement\": {\"method\": \"GET\",\"href\": \"https://test-link.test.amazonaws.com/rentalconditions_property_d65e7eb5-4a7c-4a80-a8a3-171999f9f444.pdf\"}}},\"house_rules\": [\"Children welcome\",\"No pets\",\"No smoking\",\"No parties or events\"],\"amenities\": {\"4296\": {\"id\": \"4296\",\"name\": \"Furnished balcony or patio\"},\"2859\": {\"id\": \"2859\",\"name\": \"Private pool\"}},\"vrbo_srp_id\": \"123.1234567.5678910\",\"listing_id\": \"1234567\",\"listing_number\": \"5678910\",\"listing_source\": \"HOMEAWAY_US\",\"listing_unit\": \"/units/0000/32d82dfa-1a48-45d6-9132-49fdbf1bfc60\"},\"supply_source\":\"vrbo\"} {\"property_id\":\"67890\",\"name\":\"Test Property Name 2\",\"address\":{\"line_1\":\"123 Main St\",\"line_2\":\"Apt A\",\"city\":\"Springfield\",\"state_province_code\":\"MO\",\"state_province_name\":\"Missouri\",\"postal_code\":\"65804\",\"country_code\":\"US\",\"obfuscation_required\":true,\"localized\":{\"links\":{\"es-ES\":{\"method\":\"GET\",\"href\":\"https://api.ean.com/v3/properties/content?language=es-ES&include=address&property_id=67890\"},\"de-DE\":{\"method\":\"GET\",\"href\":\"https://api.ean.com/v3/properties/content?language=de-DE&include=address&property_id=67890\"}}}},\"ratings\":{\"property\":{\"rating\":\"3.5\",\"type\":\"Star\"},\"guest\":{\"count\":7651,\"overall\":\"4.3\",\"cleanliness\":\"4.2\",\"service\":\"1.1\",\"comfort\":\"4.3\",\"condition\":\"1.6\",\"location\":\"4.0\",\"neighborhood\":\"3.4\",\"quality\":\"3.4\",\"value\":\"2.2\",\"amenities\":\"1.4\",\"recommendation_percent\":\"80%\"}},\"location\":{\"coordinates\":{\"latitude\":37.15845,\"longitude\":-93.26838},\"obfuscated_coordinates\":{\"latitude\":28.339303,\"longitude\":-81.47791},\"obfuscation_required\":true},\"phone\":\"1-417-862-0153\",\"fax\":\"1-417-863-7249\",\"category\":{\"id\":\"1\",\"name\":\"Hotel\"},\"rank\":42,\"business_model\":{\"expedia_collect\":true,\"property_collect\":true},\"checkin\":{\"24_hour\":\"24-hour check-in\",\"begin_time\":\"3:00 PM\",\"end_time\":\"11:00 PM\",\"instructions\":\"Extra-person charges may apply and vary depending on hotel policy. &lt;br />Government-issued photo identification and a credit card or cash deposit are required at check-in for incidental charges. &lt;br />Special requests are subject to availability upon check-in and may incur additional charges. Special requests cannot be guaranteed. &lt;br />\",\"special_instructions\":\"There is no front desk at this property. To make arrangements for check-in please contact the property ahead of time using the information on the booking confirmation.\",\"min_age\":18},\"checkout\":{\"time\":\"11:00 AM\"},\"fees\":{\"mandatory\":\"<p>You'll be asked to pay the following charges at the hotel:</p> <ul><li>Deposit: USD 50 per day</li><li>Resort fee: USD 29.12 per accommodation, per night</li></ul> The hotel resort fee includes:<ul><li>Fitness center access</li><li>Internet access</li><li>Phone calls</li><li>Additional inclusions</li></ul> <p>We have included all charges provided to us by the property. However, charges can vary, for example, based on length of stay or the room you book. </p>\",\"optional\":\"Fee for in-room wireless Internet: USD 15 per hour (rates may vary)</li> <li>Airport shuttle fee: USD 350 per vehicle (one way)</li>           <li>Rollaway bed fee: USD 175 per night</li>\"},\"policies\":{\"know_before_you_go\":\"Reservations are required for massage services and spa treatments. Reservations can be made by contacting the hotel prior to arrival, using the contact information on the booking confirmation. </li><li>Children 11 years old and younger stay free when occupying the parent or guardian's room, using existing bedding. </li><li>Only registered guests are allowed in the guestrooms. </li> <li>Some facilities may have restricted access. Guests can contact the property for details using the contact information on the booking confirmation. </li> </ul>\"},\"attributes\":{\"general\":{\"2549\":{\"id\":\"2549\",\"name\":\"No elevators\"},\"3357\":{\"id\":\"3357\",\"name\":\"Caters to adults only\"}},\"pets\":{\"51\":{\"id\":\"51\",\"name\":\"Pets allowed\"},\"2809\":{\"id\":\"2809\",\"name\":\"Dogs only\"},\"3321\":{\"id\":\"3321\",\"name\":\"Pet maximum weight in kg is - 24\",\"value\":24}}},\"amenities\":{\"9\":{\"id\":\"9\",\"name\":\"Fitness facilities\"},\"2820\":{\"id\":\"2820\",\"name\":\"Number of indoor pools - 10\",\"value\":10}},\"images\":[{\"caption\":\"Featured Image\",\"hero_image\":true,\"category\":3,\"links\":{\"70px\":{\"method\":\"GET\",\"href\":\"https://i.travelapi.com/hotels/1000000/20000/15300/15237/bef1b976_t.jpg\"}}}],\"onsite_payments\":{\"currency\":\"USD\",\"types\":{\"171\":{\"id\":\"171\",\"name\":\"American Express\"}}},\"rooms\":{\"224829\":{\"id\":\"224829\",\"name\":\"Single Room\",\"descriptions\":{\"overview\":\"<strong>2 Twin Beds</strong><br />269-sq-foot (25-sq-meter) room with mountain views<br /><br /><b>Internet</b> - Free WiFi <br /> <b>Entertainment</b> - Flat-screen TV with cable channels<br /><b>Food & Drink</b> - Refrigerator, coffee/tea maker,  room service, and free bottled water<br /><b>Sleep</b> - Premium bedding <br /><b>Bathroom</b> - Private bathroom, shower, bathrobes, and free toiletries<br /><b>Practical</b> - Safe and desk; cribs/infant beds available on request<br /><b>Comfort</b> - Climate-controlled air conditioning and daily housekeeping<br />Non-Smoking<br />\"},\"amenities\":{\"130\":{\"id\":\"130\",\"name\":\"Refrigerator\"},\"1234\":{\"id\":\"1234\",\"name\":\"Test Amenity - 200\",\"value\":\"200\"}},\"images\":[{\"hero_image\":true,\"category\":21001,\"links\":{\"70px\":{\"method\":\"GET\",\"href\":\"https://i.travelapi.com/hotels/1000000/20000/15300/15237/bef1b976_t.jpg\"}},\"caption\":\"Guestroom\"}],\"bed_groups\":{\"37321\":{\"id\":\"37321\",\"description\":\"1 King Bed\",\"configuration\":[{\"type\":\"KingBed\",\"size\":\"King\",\"quantity\":1}]}},\"area\":{\"square_meters\":17},\"views\":{\"4134\":{\"id\":\"4134\",\"name\":\"City view\"}},\"occupancy\":{\"max_allowed\":{\"total\":3,\"children\":2,\"adults\":3},\"age_categories\":{\"ChildAgeA\":{\"name\":\"ChildAgeA\",\"minimum_age\":3}}}}},\"rates\":{\"333abc\":{\"id\":\"333abc\",\"amenities\":{\"1234\":{\"id\":\"1234\",\"name\":\"Test Amenity - 200\",\"value\":\"200\"},\"2104\":{\"id\":\"2104\",\"name\":\"Full Breakfast\"}},\"special_offer_description\":\"<strong>Breakfast for 2</strong> - Rate includes the following:\\r\\n<ul><li>Accommodations as selected</li>\\r\\n<li>Breakfast in hotel restaurant for up to 2 adults and children 12 years old and under registered in the same room</li>\\r\\n</ul><em>Must book this rate plan to receive benefits. Details provided at check-in. Taxes and gratuity may not be included. No refunds for any unused portion of offer. Offer subject to availability. Offer is not valid with groups/conventions and may not be combined with other promotional offers. Other restrictions and blackout dates may apply.</em>\\r\\n\"}},\"dates\":{\"added\":\"1998-07-20T05:00:00.000Z\",\"updated\":\"2018-03-22T13:33:17.000Z\"},\"descriptions\":{\"amenities\":\"Don't miss out on the many recreational opportunities, including an outdoor pool, a sauna, and a fitness center. Additional features at this hotel include complimentary wireless Internet access, concierge services, and an arcade/game room.\",\"dining\":\"Grab a bite at one of the hotel's 3 restaurants, or stay in and take advantage of 24-hour room service. Quench your thirst with your favorite drink at a bar/lounge. Buffet breakfasts are available daily for a fee.\",\"renovations\":\"During renovations, the hotel will make every effort to minimize noise and disturbance.  The property will be renovating from 08 May 2017 to 18 May 2017 (completion date subject to change). The following areas are affected:  <ul><li>Fitness facilities</li></ul>\",\"national_ratings\":\"For the benefit of our customers, we have provided a rating based on our rating system.\",\"business_amenities\":\"Featured amenities include complimentary wired Internet access, a 24-hour business center, and limo/town car service. Event facilities at this hotel consist of a conference center and meeting rooms. Free self parking is available onsite.\",\"rooms\":\"Make yourself at home in one of the 334 air-conditioned rooms featuring LCD televisions. Complimentary wired and wireless Internet access keeps you connected, and satellite programming provides entertainment. Private bathrooms with separate bathtubs and showers feature deep soaking bathtubs and complimentary toiletries. Conveniences include phones, as well as safes and desks.\",\"attractions\":\"Distances are calculated in a straight line from the property's location to the point of interest or attraction, and may not reflect actual travel distance. <br /><br /> Distances are displayed to the nearest 0.1 mile and kilometer. <p>Sogo Department Store - 0.7 km / 0.4 mi <br />National Museum of Natural Science - 1.1 km / 0.7 mi <br />Shr-Hwa International Tower - 1.4 km / 0.8 mi <br />Shinkong Mitsukoshi Department Store - 1.5 km / 0.9 mi <br />Taichung Metropolitan Opera House - 1.7 km / 1 mi <br />Tiger City Mall - 1.8 km / 1.1 mi <br />Maple Garden Park - 1.9 km / 1.2 mi <br />National Museum of Fine Arts - 2.1 km / 1.3 mi <br />Feng Chia University - 2.4 km / 1.5 mi <br />Bao An Temple - 2.5 km / 1.6 mi <br />Fengjia Night Market - 2.5 km / 1.6 mi <br />Zhonghua Night Market - 2.7 km / 1.7 mi <br />Chonglun Park - 2.9 km / 1.8 mi <br />Wan He Temple - 2.9 km / 1.8 mi <br />Chungyo Department Store - 3.1 km / 1.9 mi <br /></p><p>The nearest airports are:<br />Taichung (RMQ) - 12 km / 7.5 mi<br />Taipei (TPE-Taoyuan Intl.) - 118.3 km / 73.5 mi<br />Taipei (TSA-Songshan) - 135.5 km / 84.2 mi<br /></p><p></p>\",\"location\":\"This 4-star hotel is within close proximity of Shr-Hwa International Tower and Shinkong Mitsukoshi Department Store.  A stay at Tempus Hotel Taichung places you in the heart of Taichung, convenient to Sogo Department Store and National Museum of Natural Science.\",\"headline\":\"Near National Museum of Natural Science\",\"general\":\"General description\"},\"statistics\":{\"52\":{\"id\":\"52\",\"name\":\"Total number of rooms - 820\",\"value\":\"820\"},\"54\":{\"id\":\"54\",\"name\":\"Number of floors - 38\",\"value\":\"38\"}},\"airports\":{\"preferred\":{\"iata_airport_code\":\"SGF\"}},\"themes\":{\"2337\":{\"id\":\"2337\",\"name\":\"Luxury Hotel\"},\"2341\":{\"id\":\"2341\",\"name\":\"Spa Hotel\"}},\"all_inclusive\":{\"all_rate_plans\":true,\"some_rate_plans\":false,\"details\":\"<p>This resort is all-inclusive. Onsite food and beverages are included in the room price (some restrictions may apply). </p><p><strong>Activities and facilities/equipment</strong><br />Land activities<ul><li>Fitness facilities</li></ul><br />Lessons/classes/games <ul><li>Pilates</li><li>Yoga</li></ul></p><p><strong>Entertainment</strong><ul><li>Onsite entertainment and activities</li><li>Onsite live performances</li></ul></p>\"},\"tax_id\":\"CD-012-987-1234-02\",\"chain\":{\"id\":\"-5\",\"name\":\"Hilton Worldwide\"},\"brand\":{\"id\":\"358\",\"name\":\"Hampton Inn\"},\"spoken_languages\":{\"en\":{\"id\":\"en\",\"name\":\"English\"}},\"multi_unit\":true,\"payment_registration_recommended\":true,\"vacation_rental_details\":{\"registry_number\":\"Property Registration Number 123456\",\"private_host\":\"true\",\"property_manager\":{\"name\":\"John Smith\",\"links\":{\"image\":{\"method\":\"GET\",\"href\":\"https://example.com/profile.jpg\"}}},\"rental_agreement\":{\"links\":{\"rental_agreement\":{\"method\":\"GET\",\"href\":\"https:/example.com/rentalconditions.pdf\"}}},\"house_rules\":[\"Children welcome\",\"No pets\",\"No smoking\",\"No parties or events\"],\"amenities\":{\"2859\":{\"id\":\"2859\",\"name\":\"Private pool\"},\"4296\":{\"id\":\"4296\",\"name\":\"Furnished balcony or patio\"}},\"vrbo_srp_id\":\"123.1234567.5678910\",\"listing_id\":\"1234567\",\"listing_number\":\"5678910\",\"listing_source\":\"HOMEAWAY_US\",\"listing_unit\":\"/units/0000/32d82dfa-1a48-45d6-9132-49fdbf1bfc60\"},\"supply_source\":\"vrbo\"} ```  @param operation [GetPropertyContentFileOperation](../../com.expediagroup.sdk.rapid.operations/-get-property-content-file-operation/index.md) @throws ExpediaGroupApiErrorException @return a CompletableFuture<Response> object with a body of type Link

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[GuestReviews](../../com.expediagroup.sdk.rapid.models/-guest-reviews/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetPropertyGuestReviewsOperation](../../com.expediagroup.sdk.rapid.operations/-get-property-guest-reviews-operation/index.md)operation)

Property Guest Reviews <i>Note: Property Guest Reviews are only available if your account is configured for access and all launch requirements have been followed. Please review the [launch requirements](https://developers.expediagroup.com/docs/products/rapid/setup/launch-requirements) and contact your Account Manager for more details.</i><br><br> The response is an individual Guest Reviews object containing multiple guest reviews for the requested active property.<br><br> To ensure you always show the latest guest reviews, this call should be made whenever a customer looks at the details for a specific property.

#### Return

a CompletableFuture<Response> object with a body of type GuestReviews

#### Parameters

JVM

| | |
|---|---|
| operation | [GetPropertyGuestReviewsOperation](../../com.expediagroup.sdk.rapid.operations/-get-property-guest-reviews-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[Region](../../com.expediagroup.sdk.rapid.models/-region/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetRegionOperation](../../com.expediagroup.sdk.rapid.operations/-get-region-operation/index.md)operation)

Region Returns the geographic definition and property mappings for the requested Region ID. The response is a single JSON formatted region object.

#### Return

a CompletableFuture<Response> object with a body of type Region

#### Parameters

JVM

| | |
|---|---|
| operation | [GetRegionOperation](../../com.expediagroup.sdk.rapid.operations/-get-region-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Region](../../com.expediagroup.sdk.rapid.models/-region/index.md)&gt;&gt;&gt;[executeAsync](execute-async.md)([GetRegionsOperation](../../com.expediagroup.sdk.rapid.operations/-get-regions-operation/index.md)operation)

Regions Returns the geographic definition and property mappings of regions matching the specified parameters.<br><br> To request all regions in the world, omit the `ancestor` query parameter. To request all regions in a specific continent, country or other level, specify the ID of that region as the `ancestor`. Refer to the list of [top level regions](https://developers.expediagroup.com/docs/rapid/lodging/geography/geography-reference-lists). <br><br> The response is a paginated list of regions. See the `Link` header in the 200 response section.

#### Return

a CompletableFuture<Response> object with a body of type kotlin.collections.List<Region>

#### Parameters

JVM

| | |
|---|---|
| operation | [GetRegionsOperation](../../com.expediagroup.sdk.rapid.operations/-get-regions-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Itinerary](../../com.expediagroup.sdk.rapid.models/-itinerary/index.md)&gt;&gt;&gt;[executeAsync](execute-async.md)([GetReservationOperation](../../com.expediagroup.sdk.rapid.operations/-get-reservation-operation/index.md)operation)

Search for and retrieve Bookings with Affiliate Reference Id This can be called directly without a token when an affiliate reference id is provided. It returns details about bookings associated with an affiliate reference id, along with cancel links to cancel the bookings.  <i>Note: Newly created itineraries may sometimes have a small delay between the time of creation and the time that the itinerary can be retrieved. If you receive no results while trying to search for an itinerary that was successfully created, or if you receive a response with two fields, namely, `itinerary_id` and `creation_date_time`, then please wait a few minutes before trying to search for the itinerary again.</i>

#### Return

a CompletableFuture<Response> object with a body of type kotlin.collections.List<Itinerary>

#### Parameters

JVM

| | |
|---|---|
| operation | [GetReservationOperation](../../com.expediagroup.sdk.rapid.operations/-get-reservation-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[Itinerary](../../com.expediagroup.sdk.rapid.models/-itinerary/index.md)&gt;&gt;[executeAsync](execute-async.md)([GetReservationByItineraryIdOperation](../../com.expediagroup.sdk.rapid.operations/-get-reservation-by-itinerary-id-operation/index.md)operation)

Retrieve Booking This API call returns itinerary details and links to resume or cancel the booking. There are two methods to retrieve a booking: * Using the link included in the original Book response, example: https://api.ean.com/v3/itineraries/8955599932111?token=QldfCGlcUA4GXVlSAQ4W * Using the email of the booking. If the email contains special characters, they must be encoded to successfully retrieve the booking. Example: https://api.ean.com/v3/itineraries/8955599932111?email=customer@email.com  <i>Note: Newly created itineraries may sometimes have a small delay between the time of creation and the time that the itinerary can be retrieved. If you receive an error when trying to retrieve an itinerary that was successfully created, or if you receive a response with two fields, namely, `itinerary_id` and `creation_date_time`, then please wait a few minutes before trying to retrieve the itinerary again.</i>

#### Return

a CompletableFuture<Response> object with a body of type Itinerary

#### Parameters

JVM

| | |
|---|---|
| operation | [GetReservationByItineraryIdOperation](../../com.expediagroup.sdk.rapid.operations/-get-reservation-by-itinerary-id-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [PropertyGeography](../../com.expediagroup.sdk.rapid.models/-property-geography/index.md)&gt;&gt;&gt;[executeAsync](execute-async.md)([PostGeographyOperation](../../com.expediagroup.sdk.rapid.operations/-post-geography-operation/index.md)operation)

Properties within Polygon Returns the properties within an custom polygon that represents a multi-city area or smaller. The coordinates of the polygon should be in [GeoJSON format](https://tools.ietf.org/html/rfc7946) and the polygon must conform to the following restrictions:   * Polygon size - diagonal distance of the polygon must be less than 500km   * Polygon type - only single polygons are supported   * Number of coordinates - must be <= 2000

#### Return

a CompletableFuture<Response> object with a body of type kotlin.collections.Map<kotlin.String, PropertyGeography>

#### Parameters

JVM

| | |
|---|---|
| operation | [PostGeographyOperation](../../com.expediagroup.sdk.rapid.operations/-post-geography-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[ItineraryCreation](../../com.expediagroup.sdk.rapid.models/-itinerary-creation/index.md)&gt;&gt;[executeAsync](execute-async.md)([PostItineraryOperation](../../com.expediagroup.sdk.rapid.operations/-post-itinerary-operation/index.md)operation)

Create Booking This link will be available in the Price Check response or in the register payments response when Two-Factor Authentication is used. It returns an itinerary id and links to retrieve reservation details, cancel a held booking, resume a held booking or complete payment session. Please note that depending on the state of the booking, the response will contain only the applicable link(s).

#### Return

a CompletableFuture<Response> object with a body of type ItineraryCreation

#### Parameters

JVM

| | |
|---|---|
| operation | [PostItineraryOperation](../../com.expediagroup.sdk.rapid.operations/-post-itinerary-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[PaymentSessions](../../com.expediagroup.sdk.rapid.models/-payment-sessions/index.md)&gt;&gt;[executeAsync](execute-async.md)([PostPaymentSessionsOperation](../../com.expediagroup.sdk.rapid.operations/-post-payment-sessions-operation/index.md)operation)

Register Payments <b>This link only applies to transactions where EPS takes the customer's payment information. This includes both Expedia Collect and Property Collect transactions.</b><br> This link will be available in the Price Check response if payment registration is required. It returns a payment session ID and a link to create a booking. This will be the first step in the booking flow only if you've opted into Two-Factor Authentication to comply with the September 2019 EU Regulations for PSD2. Learn more with our [PSD2 Overview](https://developers.expediagroup.com/docs/rapid/lodging/booking/psd2-regulation)

#### Return

a CompletableFuture<Response> object with a body of type PaymentSessions

#### Parameters

JVM

| | |
|---|---|
| operation | [PostPaymentSessionsOperation](../../com.expediagroup.sdk.rapid.operations/-post-payment-sessions-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[RoomPriceCheck](../../com.expediagroup.sdk.rapid.models/-room-price-check/index.md)&gt;&gt;[executeAsync](execute-async.md)([PriceCheckOperation](../../com.expediagroup.sdk.rapid.operations/-price-check-operation/index.md)operation)

Price-Check Confirms the price returned by the Property Availability response. Use this API to verify a previously-selected rate is still valid before booking. If the price is matched, the response returns a link to request a booking. If the price has changed, the response returns new price details and a booking link for the new price. If the rate is no longer available, the response will return a new Property Availability request link to search again for different rates. In the event of a price change, go back to Property Availability and book the property at the new price or return to additional rates for the property.

#### Return

a CompletableFuture<Response> object with a body of type RoomPriceCheck

#### Parameters

JVM

| | |
|---|---|
| operation | [PriceCheckOperation](../../com.expediagroup.sdk.rapid.operations/-price-check-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[CompletePaymentSession](../../com.expediagroup.sdk.rapid.models/-complete-payment-session/index.md)&gt;&gt;[executeAsync](execute-async.md)([PutCompletePaymentSessionOperation](../../com.expediagroup.sdk.rapid.operations/-put-complete-payment-session-operation/index.md)operation)

Complete Payment Session <b>This link only applies to transactions where EPS takes the customer's payment information. This includes both Expedia Collect and Property Collect transactions.</b><br> This link will be available in the booking response only if you've opted into Two-Factor Authentication to comply with the September 2019 EU Regulations for PSD2. It should be called after Two-Factor Authentication has been completed by the customer in order to finalize the payment and complete the booking or hold attempt. Learn more with our [PSD2 Overview](https://developers.expediagroup.com/docs/rapid/lodging/booking/psd2-regulation)

#### Return

a CompletableFuture<Response> object with a body of type CompletePaymentSession

#### Parameters

JVM

| | |
|---|---|
| operation | [PutCompletePaymentSessionOperation](../../com.expediagroup.sdk.rapid.operations/-put-complete-payment-session-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;EmptyResponse&gt;[executeAsync](execute-async.md)([PutResumeBookingOperation](../../com.expediagroup.sdk.rapid.operations/-put-resume-booking-operation/index.md)operation)

Resume Booking This link will be available in the booking response after creating a held booking.

#### Return

a CompletableFuture<Response> object with a body of type Nothing

#### Parameters

JVM

| | |
|---|---|
| operation | [PutResumeBookingOperation](../../com.expediagroup.sdk.rapid.operations/-put-resume-booking-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;EmptyResponse&gt;[executeAsync](execute-async.md)([RequestTestNotificationOperation](../../com.expediagroup.sdk.rapid.operations/-request-test-notification-operation/index.md)operation)

Request Test Notification This request triggers a test notification according to the specified event_type. All event types supported by the Notifications API are available to test.

#### Return

a CompletableFuture<Response> object with a body of type Nothing

#### Parameters

JVM

| | |
|---|---|
| operation | [RequestTestNotificationOperation](../../com.expediagroup.sdk.rapid.operations/-request-test-notification-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |

[JVM]\

public final [CompletableFuture](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)&lt;Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Notification](../../com.expediagroup.sdk.rapid.models/-notification/index.md)&gt;&gt;&gt;[executeAsync](execute-async.md)([RequestUndeliveredNotificationsOperation](../../com.expediagroup.sdk.rapid.operations/-request-undelivered-notifications-operation/index.md)operation)

Request Undelivered Notifications Use this API to fetch undelivered notifications. Up to 25 notifications are returned with each call. Each undelivered notification will be returned only once.

#### Return

a CompletableFuture<Response> object with a body of type kotlin.collections.List<Notification>

#### Parameters

JVM

| | |
|---|---|
| operation | [RequestUndeliveredNotificationsOperation](../../com.expediagroup.sdk.rapid.operations/-request-undelivered-notifications-operation/index.md) |
