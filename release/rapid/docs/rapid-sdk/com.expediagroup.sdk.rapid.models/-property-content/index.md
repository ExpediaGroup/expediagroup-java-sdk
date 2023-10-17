//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PropertyContent](index.md)

# PropertyContent

public final class [PropertyContent](index.md)

An individual property object in the map of property objects.

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

## Constructors

| | |
|---|---|
| [PropertyContent](-property-content.md) | [JVM]<br>public [PropertyContent](index.md)[PropertyContent](-property-content.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [Address](../-address/index.md)address, [Ratings](../-ratings/index.md)ratings, [Location](../-location/index.md)location, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)phone, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)fax, [CategoryProperty](../-category-property/index.md)category, [BusinessModel](../-business-model/index.md)businessModel, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)rank, [Checkin](../-checkin/index.md)checkin, [Checkout](../-checkout/index.md)checkout, [Fees](../-fees/index.md)fees, [Policies](../-policies/index.md)policies, [Attributes](../-attributes/index.md)attributes, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;amenities, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Image](../-image/index.md)&gt;images, [OnsitePayments](../-onsite-payments/index.md)onsitePayments, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [RoomContent](../-room-content/index.md)&gt;rooms, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [RateContent](../-rate-content/index.md)&gt;rates, [Dates](../-dates/index.md)dates, [Descriptions](../-descriptions/index.md)descriptions, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Statistic](../-statistic/index.md)&gt;statistics, [AssociatedAirports](../-associated-airports/index.md)airports, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Theme](../-theme/index.md)&gt;themes, [AllInclusive](../-all-inclusive/index.md)allInclusive, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)taxId, [Chain](../-chain/index.md)chain, [Brand](../-brand/index.md)brand, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [SpokenLanguage](../-spoken-language/index.md)&gt;spokenLanguages, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)multiUnit, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)paymentRegistrationRecommended, [VacationRentalDetails](../-vacation-rental-details/index.md)vacationRentalDetails, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)supplySource) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [address](index.md#-2046585379%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Address](../-address/index.md)[address](index.md#-2046585379%2FProperties%2F700308213) |
| [airports](index.md#1237065377%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [AssociatedAirports](../-associated-airports/index.md)[airports](index.md#1237065377%2FProperties%2F700308213) |
| [allInclusive](index.md#2071011774%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [AllInclusive](../-all-inclusive/index.md)[allInclusive](index.md#2071011774%2FProperties%2F700308213) |
| [amenities](index.md#23495962%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;[amenities](index.md#23495962%2FProperties%2F700308213) |
| [attributes](index.md#-1837904334%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Attributes](../-attributes/index.md)[attributes](index.md#-1837904334%2FProperties%2F700308213) |
| [brand](index.md#-1582410070%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Brand](../-brand/index.md)[brand](index.md#-1582410070%2FProperties%2F700308213) |
| [businessModel](index.md#-656176856%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BusinessModel](../-business-model/index.md)[businessModel](index.md#-656176856%2FProperties%2F700308213) |
| [category](index.md#-1579982997%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [CategoryProperty](../-category-property/index.md)[category](index.md#-1579982997%2FProperties%2F700308213) |
| [chain](index.md#-115081040%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Chain](../-chain/index.md)[chain](index.md#-115081040%2FProperties%2F700308213) |
| [checkin](index.md#-578657340%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Checkin](../-checkin/index.md)[checkin](index.md#-578657340%2FProperties%2F700308213) |
| [checkout](index.md#1746677795%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Checkout](../-checkout/index.md)[checkout](index.md#1746677795%2FProperties%2F700308213) |
| [dates](index.md#-601926292%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Dates](../-dates/index.md)[dates](index.md#-601926292%2FProperties%2F700308213) |
| [descriptions](index.md#1617781906%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Descriptions](../-descriptions/index.md)[descriptions](index.md#1617781906%2FProperties%2F700308213) |
| [fax](index.md#-1246510892%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[fax](index.md#-1246510892%2FProperties%2F700308213) |
| [fees](index.md#-530620516%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Fees](../-fees/index.md)[fees](index.md#-530620516%2FProperties%2F700308213) |
| [images](index.md#605004337%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Image](../-image/index.md)&gt;[images](index.md#605004337%2FProperties%2F700308213) |
| [location](index.md#-826070892%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Location](../-location/index.md)[location](index.md#-826070892%2FProperties%2F700308213) |
| [multiUnit](index.md#-1628563820%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[multiUnit](index.md#-1628563820%2FProperties%2F700308213) |
| [name](index.md#406872190%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#406872190%2FProperties%2F700308213) |
| [onsitePayments](index.md#-809560554%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [OnsitePayments](../-onsite-payments/index.md)[onsitePayments](index.md#-809560554%2FProperties%2F700308213) |
| [paymentRegistrationRecommended](index.md#-1680302547%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[paymentRegistrationRecommended](index.md#-1680302547%2FProperties%2F700308213) |
| [phone](index.md#994608803%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[phone](index.md#994608803%2FProperties%2F700308213) |
| [policies](index.md#-1787016359%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Policies](../-policies/index.md)[policies](index.md#-1787016359%2FProperties%2F700308213) |
| [propertyId](index.md#2057534425%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[propertyId](index.md#2057534425%2FProperties%2F700308213) |
| [rank](index.md#32044541%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[rank](index.md#32044541%2FProperties%2F700308213) |
| [rates](index.md#-443500514%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [RateContent](../-rate-content/index.md)&gt;[rates](index.md#-443500514%2FProperties%2F700308213) |
| [ratings](index.md#-1325029989%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Ratings](../-ratings/index.md)[ratings](index.md#-1325029989%2FProperties%2F700308213) |
| [rooms](index.md#1046648921%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [RoomContent](../-room-content/index.md)&gt;[rooms](index.md#1046648921%2FProperties%2F700308213) |
| [spokenLanguages](index.md#747732632%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [SpokenLanguage](../-spoken-language/index.md)&gt;[spokenLanguages](index.md#747732632%2FProperties%2F700308213) |
| [statistics](index.md#-1650924570%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Statistic](../-statistic/index.md)&gt;[statistics](index.md#-1650924570%2FProperties%2F700308213) |
| [supplySource](index.md#290724351%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[supplySource](index.md#290724351%2FProperties%2F700308213) |
| [taxId](index.md#1234467051%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[taxId](index.md#1234467051%2FProperties%2F700308213) |
| [themes](index.md#1356243231%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Theme](../-theme/index.md)&gt;[themes](index.md#1356243231%2FProperties%2F700308213) |
| [vacationRentalDetails](index.md#1203565264%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [VacationRentalDetails](../-vacation-rental-details/index.md)[vacationRentalDetails](index.md#1203565264%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PropertyContent.Builder](-builder/index.md)[builder](builder.md)() |
| [getAddress](get-address.md) | [JVM]<br>public final [Address](../-address/index.md)[getAddress](get-address.md)() |
| [getAirports](get-airports.md) | [JVM]<br>public final [AssociatedAirports](../-associated-airports/index.md)[getAirports](get-airports.md)() |
| [getAllInclusive](get-all-inclusive.md) | [JVM]<br>public final [AllInclusive](../-all-inclusive/index.md)[getAllInclusive](get-all-inclusive.md)() |
| [getAmenities](get-amenities.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;[getAmenities](get-amenities.md)() |
| [getAttributes](get-attributes.md) | [JVM]<br>public final [Attributes](../-attributes/index.md)[getAttributes](get-attributes.md)() |
| [getBrand](get-brand.md) | [JVM]<br>public final [Brand](../-brand/index.md)[getBrand](get-brand.md)() |
| [getBusinessModel](get-business-model.md) | [JVM]<br>public final [BusinessModel](../-business-model/index.md)[getBusinessModel](get-business-model.md)() |
| [getCategory](get-category.md) | [JVM]<br>public final [CategoryProperty](../-category-property/index.md)[getCategory](get-category.md)() |
| [getChain](get-chain.md) | [JVM]<br>public final [Chain](../-chain/index.md)[getChain](get-chain.md)() |
| [getCheckin](get-checkin.md) | [JVM]<br>public final [Checkin](../-checkin/index.md)[getCheckin](get-checkin.md)() |
| [getCheckout](get-checkout.md) | [JVM]<br>public final [Checkout](../-checkout/index.md)[getCheckout](get-checkout.md)() |
| [getDates](get-dates.md) | [JVM]<br>public final [Dates](../-dates/index.md)[getDates](get-dates.md)() |
| [getDescriptions](get-descriptions.md) | [JVM]<br>public final [Descriptions](../-descriptions/index.md)[getDescriptions](get-descriptions.md)() |
| [getFax](get-fax.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getFax](get-fax.md)() |
| [getFees](get-fees.md) | [JVM]<br>public final [Fees](../-fees/index.md)[getFees](get-fees.md)() |
| [getImages](get-images.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Image](../-image/index.md)&gt;[getImages](get-images.md)() |
| [getLocation](get-location.md) | [JVM]<br>public final [Location](../-location/index.md)[getLocation](get-location.md)() |
| [getMultiUnit](get-multi-unit.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getMultiUnit](get-multi-unit.md)() |
| [getName](get-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
| [getOnsitePayments](get-onsite-payments.md) | [JVM]<br>public final [OnsitePayments](../-onsite-payments/index.md)[getOnsitePayments](get-onsite-payments.md)() |
| [getPaymentRegistrationRecommended](get-payment-registration-recommended.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getPaymentRegistrationRecommended](get-payment-registration-recommended.md)() |
| [getPhone](get-phone.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPhone](get-phone.md)() |
| [getPolicies](get-policies.md) | [JVM]<br>public final [Policies](../-policies/index.md)[getPolicies](get-policies.md)() |
| [getPropertyId](get-property-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPropertyId](get-property-id.md)() |
| [getRank](get-rank.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getRank](get-rank.md)() |
| [getRates](get-rates.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [RateContent](../-rate-content/index.md)&gt;[getRates](get-rates.md)() |
| [getRatings](get-ratings.md) | [JVM]<br>public final [Ratings](../-ratings/index.md)[getRatings](get-ratings.md)() |
| [getRooms](get-rooms.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [RoomContent](../-room-content/index.md)&gt;[getRooms](get-rooms.md)() |
| [getSpokenLanguages](get-spoken-languages.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [SpokenLanguage](../-spoken-language/index.md)&gt;[getSpokenLanguages](get-spoken-languages.md)() |
| [getStatistics](get-statistics.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Statistic](../-statistic/index.md)&gt;[getStatistics](get-statistics.md)() |
| [getSupplySource](get-supply-source.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSupplySource](get-supply-source.md)() |
| [getTaxId](get-tax-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTaxId](get-tax-id.md)() |
| [getThemes](get-themes.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Theme](../-theme/index.md)&gt;[getThemes](get-themes.md)() |
| [getVacationRentalDetails](get-vacation-rental-details.md) | [JVM]<br>public final [VacationRentalDetails](../-vacation-rental-details/index.md)[getVacationRentalDetails](get-vacation-rental-details.md)() |
