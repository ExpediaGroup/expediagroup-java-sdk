//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PropertyContent](index.md)/[PropertyContent](-property-content.md)

# PropertyContent

[JVM]\

public [PropertyContent](index.md)[PropertyContent](-property-content.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [Address](../-address/index.md)address, [Ratings](../-ratings/index.md)ratings, [Location](../-location/index.md)location, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)phone, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)fax, [CategoryProperty](../-category-property/index.md)category, [BusinessModel](../-business-model/index.md)businessModel, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)rank, [Checkin](../-checkin/index.md)checkin, [Checkout](../-checkout/index.md)checkout, [Fees](../-fees/index.md)fees, [Policies](../-policies/index.md)policies, [Attributes](../-attributes/index.md)attributes, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;amenities, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Image](../-image/index.md)&gt;images, [OnsitePayments](../-onsite-payments/index.md)onsitePayments, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [RoomContent](../-room-content/index.md)&gt;rooms, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [RateContent](../-rate-content/index.md)&gt;rates, [Dates](../-dates/index.md)dates, [Descriptions](../-descriptions/index.md)descriptions, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Statistic](../-statistic/index.md)&gt;statistics, [AssociatedAirports](../-associated-airports/index.md)airports, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Theme](../-theme/index.md)&gt;themes, [AllInclusive](../-all-inclusive/index.md)allInclusive, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)taxId, [Chain](../-chain/index.md)chain, [Brand](../-brand/index.md)brand, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [SpokenLanguage](../-spoken-language/index.md)&gt;spokenLanguages, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)multiUnit, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)paymentRegistrationRecommended, [VacationRentalDetails](../-vacation-rental-details/index.md)vacationRentalDetails, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)supplySource)

#### Parameters

JVM

| | |
|---|---|
| propertyId | Unique Expedia property ID. |
| name | Property name. |
| address |
| ratings |
| location |
| phone | The property's phone number. |
| fax | The property's fax number. |
| category |
| businessModel |
| rank | The property’s rank across all properties. This value sorts properties based on EPS transactional data and details about the property, with 1 indicating the best-performing property and others following in ascending numerical order. |
| checkin |
| checkout |
| fees |
| policies |
| attributes |
| amenities | Lists all of the amenities available for all guests at the property. See our [amenities reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known amenity ID and name values. |
| images | Contains all property images available. |
| onsitePayments |
| rooms | Information about all of the rooms at the property. |
| rates | Additional information about the rates offered by the property. This should be used in conjunction with the pricing and other rate-related information in shopping. |
| dates |
| descriptions |
| statistics | Statistics of the property, such as number of floors. See our [statistics reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known statistics ID and name values. |
| airports |
| themes | Themes that describe the property. See our [themes reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known theme ID and name values. |
| allInclusive |
| taxId | Tax ID. |
| chain |
| brand |
| spokenLanguages | Languages spoken at the property. |
| multiUnit | Boolean value indicating if a property is a multi-unit property. |
| paymentRegistrationRecommended | Boolean value indicating if a property may require payment registration to process payments, even when using the property_collect Business Model. If true, then a property may not be successfully bookable without registering payments first. |
| vacationRentalDetails |
| supplySource | The supply source of the property. |
