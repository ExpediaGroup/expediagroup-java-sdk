//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RoomItinerary](index.md)

# RoomItinerary

public final class [RoomItinerary](index.md)

The room information.

#### Parameters

JVM

| | |
|---|---|
| id | The room id. |
| confirmationId |
| bedGroupId | Unique identifier for a bed type. |
| checkin | The check-in date of the itinerary. |
| checkout | The check-out date of the itinerary. |
| numberOfAdults | The number of adults staying in the room. |
| childAges | The ages of children for the room. |
| givenName | The first name of the main guest staying in the room. |
| familyName | The last name of the main guest staying in the room. |
| status |
| specialRequest | Any special request info associated with the room. |
| smoking | Indicates if the room is smoking or non-smoking. |
| loyaltyId | A loyalty identifier for a hotel loyalty program associated with this room guest. |
| rate |
| links |

## Constructors

| | |
|---|---|
| [RoomItinerary](-room-itinerary.md) | [JVM]<br>public [RoomItinerary](index.md)[RoomItinerary](-room-itinerary.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [ConfirmationId](../-confirmation-id/index.md)confirmationId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bedGroupId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkin, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkout, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)numberOfAdults, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;childAges, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)givenName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)familyName, [StatusItinerary](../-status-itinerary/index.md)status, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)specialRequest, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)smoking, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)loyaltyId, [RateItinerary](../-rate-itinerary/index.md)rate, [RoomItineraryLinks](../-room-itinerary-links/index.md)links) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [bedGroupId](index.md#-295028004%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[bedGroupId](index.md#-295028004%2FProperties%2F700308213) |
| [checkin](index.md#1313378808%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[checkin](index.md#1313378808%2FProperties%2F700308213) |
| [checkout](index.md#270256239%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[checkout](index.md#270256239%2FProperties%2F700308213) |
| [childAges](index.md#895898357%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;[childAges](index.md#895898357%2FProperties%2F700308213) |
| [confirmationId](index.md#1082927813%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [ConfirmationId](../-confirmation-id/index.md)[confirmationId](index.md#1082927813%2FProperties%2F700308213) |
| [familyName](index.md#1265284038%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[familyName](index.md#1265284038%2FProperties%2F700308213) |
| [givenName](index.md#727711965%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[givenName](index.md#727711965%2FProperties%2F700308213) |
| [id](index.md#861789242%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#861789242%2FProperties%2F700308213) |
| [links](index.md#136853996%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [RoomItineraryLinks](../-room-itinerary-links/index.md)[links](index.md#136853996%2FProperties%2F700308213) |
| [loyaltyId](index.md#936800932%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[loyaltyId](index.md#936800932%2FProperties%2F700308213) |
| [numberOfAdults](index.md#973059580%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[numberOfAdults](index.md#973059580%2FProperties%2F700308213) |
| [rate](index.md#1065813525%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [RateItinerary](../-rate-itinerary/index.md)[rate](index.md#1065813525%2FProperties%2F700308213) |
| [smoking](index.md#-1156034407%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[smoking](index.md#-1156034407%2FProperties%2F700308213) |
| [specialRequest](index.md#1840008735%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[specialRequest](index.md#1840008735%2FProperties%2F700308213) |
| [status](index.md#-990917309%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [StatusItinerary](../-status-itinerary/index.md)[status](index.md#-990917309%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomItinerary.Builder](-builder/index.md)[builder](builder.md)() |
| [getBedGroupId](get-bed-group-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBedGroupId](get-bed-group-id.md)() |
| [getCheckin](get-checkin.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCheckin](get-checkin.md)() |
| [getCheckout](get-checkout.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCheckout](get-checkout.md)() |
| [getChildAges](get-child-ages.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;[getChildAges](get-child-ages.md)() |
| [getConfirmationId](get-confirmation-id.md) | [JVM]<br>public final [ConfirmationId](../-confirmation-id/index.md)[getConfirmationId](get-confirmation-id.md)() |
| [getFamilyName](get-family-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getFamilyName](get-family-name.md)() |
| [getGivenName](get-given-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGivenName](get-given-name.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getLinks](get-links.md) | [JVM]<br>public final [RoomItineraryLinks](../-room-itinerary-links/index.md)[getLinks](get-links.md)() |
| [getLoyaltyId](get-loyalty-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLoyaltyId](get-loyalty-id.md)() |
| [getNumberOfAdults](get-number-of-adults.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getNumberOfAdults](get-number-of-adults.md)() |
| [getRate](get-rate.md) | [JVM]<br>public final [RateItinerary](../-rate-itinerary/index.md)[getRate](get-rate.md)() |
| [getSmoking](get-smoking.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getSmoking](get-smoking.md)() |
| [getSpecialRequest](get-special-request.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSpecialRequest](get-special-request.md)() |
| [getStatus](get-status.md) | [JVM]<br>public final [StatusItinerary](../-status-itinerary/index.md)[getStatus](get-status.md)() |
