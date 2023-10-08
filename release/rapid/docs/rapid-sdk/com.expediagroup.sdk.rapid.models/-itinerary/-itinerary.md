//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Itinerary](index.md)/[Itinerary](-itinerary.md)

# Itinerary

[JVM]\

public [Itinerary](index.md)[Itinerary](-itinerary.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [ItineraryLinks](../-itinerary-links/index.md)links, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email, [Phone](../-phone/index.md)phone, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomItinerary](../-room-itinerary/index.md)&gt;rooms, [BillingContact](../-billing-contact/index.md)billingContact, [Adjustment](../-adjustment/index.md)adjustment, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)creationDateTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateReferenceId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateMetadata, [Conversations](../-conversations/index.md)conversations, [TraderInformation](../-trader-information/index.md)traderInformation, [EssentialInformation](../-essential-information/index.md)essentialInformation, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ItineraryHistoryItem](../-itinerary-history-item/index.md)&gt;itineraryHistory, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomHistoryItem](../-room-history-item/index.md)&gt;&gt;roomHistory)

#### Parameters

JVM

| | |
|---|---|
| itineraryId | The itinerary id. |
| propertyId | The property id. |
| links |
| email | Email address for the customer. |
| phone |
| rooms |
| billingContact |
| adjustment |
| creationDateTime | The creation date/time of the booking. |
| affiliateReferenceId | Your unique reference value. This field supports from 3 to a maximum of 28 characters. |
| affiliateMetadata | Field that stores up to 256 characters of additional metadata with the itinerary, uniqueness is not required. |
| conversations |
| traderInformation |
| essentialInformation |
| itineraryHistory |
| roomHistory | An array of rooms each containing an array of room history events. |
