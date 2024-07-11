//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RoomItinerary](index.md)/[RoomItinerary](-room-itinerary.md)

# RoomItinerary

[JVM]\

public [RoomItinerary](index.md)[RoomItinerary](-room-itinerary.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [ConfirmationId](../-confirmation-id/index.md)confirmationId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bedGroupId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkin, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkout, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)numberOfAdults, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;childAges, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)givenName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)familyName, [StatusItinerary](../-status-itinerary/index.md)status, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)specialRequest, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)smoking, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)loyaltyId, [Loyalty](../-loyalty/index.md)loyalty, [RateItinerary](../-rate-itinerary/index.md)rate, [RoomItineraryLinks](../-room-itinerary-links/index.md)links)

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
| loyaltyId | Deprecated. Please use the loyalty id inside the loyalty object. |
| loyalty |
| rate |
| links |
