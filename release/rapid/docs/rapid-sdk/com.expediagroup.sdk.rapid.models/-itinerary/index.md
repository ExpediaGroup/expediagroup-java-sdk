//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Itinerary](index.md)

# Itinerary

public final class [Itinerary](index.md)

The itinerary object.

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

## Constructors

| | |
|---|---|
| [Itinerary](-itinerary.md) | [JVM]<br>public [Itinerary](index.md)[Itinerary](-itinerary.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [ItineraryLinks](../-itinerary-links/index.md)links, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email, [Phone](../-phone/index.md)phone, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomItinerary](../-room-itinerary/index.md)&gt;rooms, [BillingContact](../-billing-contact/index.md)billingContact, [Adjustment](../-adjustment/index.md)adjustment, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)creationDateTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateReferenceId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateMetadata, [Conversations](../-conversations/index.md)conversations, [TraderInformation](../-trader-information/index.md)traderInformation, [EssentialInformation](../-essential-information/index.md)essentialInformation, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ItineraryHistoryItem](../-itinerary-history-item/index.md)&gt;itineraryHistory, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomHistoryItem](../-room-history-item/index.md)&gt;&gt;roomHistory) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [adjustment](index.md#-1563307837%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Adjustment](../-adjustment/index.md)[adjustment](index.md#-1563307837%2FProperties%2F700308213) |
| [affiliateMetadata](index.md#-1925469586%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[affiliateMetadata](index.md#-1925469586%2FProperties%2F700308213) |
| [affiliateReferenceId](index.md#-600756809%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[affiliateReferenceId](index.md#-600756809%2FProperties%2F700308213) |
| [billingContact](index.md#1567019659%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BillingContact](../-billing-contact/index.md)[billingContact](index.md#1567019659%2FProperties%2F700308213) |
| [conversations](index.md#1435311802%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Conversations](../-conversations/index.md)[conversations](index.md#1435311802%2FProperties%2F700308213) |
| [creationDateTime](index.md#102857974%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[creationDateTime](index.md#102857974%2FProperties%2F700308213) |
| [email](index.md#860991982%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[email](index.md#860991982%2FProperties%2F700308213) |
| [essentialInformation](index.md#1239849618%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [EssentialInformation](../-essential-information/index.md)[essentialInformation](index.md#1239849618%2FProperties%2F700308213) |
| [itineraryHistory](index.md#1345544807%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ItineraryHistoryItem](../-itinerary-history-item/index.md)&gt;[itineraryHistory](index.md#1345544807%2FProperties%2F700308213) |
| [itineraryId](index.md#-2023331964%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[itineraryId](index.md#-2023331964%2FProperties%2F700308213) |
| [links](index.md#1291556977%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [ItineraryLinks](../-itinerary-links/index.md)[links](index.md#1291556977%2FProperties%2F700308213) |
| [phone](index.md#-1455419300%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Phone](../-phone/index.md)[phone](index.md#-1455419300%2FProperties%2F700308213) |
| [propertyId](index.md#850009536%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[propertyId](index.md#850009536%2FProperties%2F700308213) |
| [roomHistory](index.md#-1374860495%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomHistoryItem](../-room-history-item/index.md)&gt;&gt;[roomHistory](index.md#-1374860495%2FProperties%2F700308213) |
| [rooms](index.md#-1403379182%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomItinerary](../-room-itinerary/index.md)&gt;[rooms](index.md#-1403379182%2FProperties%2F700308213) |
| [traderInformation](index.md#706699148%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [TraderInformation](../-trader-information/index.md)[traderInformation](index.md#706699148%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Itinerary.Builder](-builder/index.md)[builder](builder.md)() |
| [getAdjustment](get-adjustment.md) | [JVM]<br>public final [Adjustment](../-adjustment/index.md)[getAdjustment](get-adjustment.md)() |
| [getAffiliateMetadata](get-affiliate-metadata.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAffiliateMetadata](get-affiliate-metadata.md)() |
| [getAffiliateReferenceId](get-affiliate-reference-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAffiliateReferenceId](get-affiliate-reference-id.md)() |
| [getBillingContact](get-billing-contact.md) | [JVM]<br>public final [BillingContact](../-billing-contact/index.md)[getBillingContact](get-billing-contact.md)() |
| [getConversations](get-conversations.md) | [JVM]<br>public final [Conversations](../-conversations/index.md)[getConversations](get-conversations.md)() |
| [getCreationDateTime](get-creation-date-time.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCreationDateTime](get-creation-date-time.md)() |
| [getEmail](get-email.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEmail](get-email.md)() |
| [getEssentialInformation](get-essential-information.md) | [JVM]<br>public final [EssentialInformation](../-essential-information/index.md)[getEssentialInformation](get-essential-information.md)() |
| [getItineraryHistory](get-itinerary-history.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ItineraryHistoryItem](../-itinerary-history-item/index.md)&gt;[getItineraryHistory](get-itinerary-history.md)() |
| [getItineraryId](get-itinerary-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getItineraryId](get-itinerary-id.md)() |
| [getLinks](get-links.md) | [JVM]<br>public final [ItineraryLinks](../-itinerary-links/index.md)[getLinks](get-links.md)() |
| [getPhone](get-phone.md) | [JVM]<br>public final [Phone](../-phone/index.md)[getPhone](get-phone.md)() |
| [getPropertyId](get-property-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPropertyId](get-property-id.md)() |
| [getRoomHistory](get-room-history.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomHistoryItem](../-room-history-item/index.md)&gt;&gt;[getRoomHistory](get-room-history.md)() |
| [getRooms](get-rooms.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RoomItinerary](../-room-itinerary/index.md)&gt;[getRooms](get-rooms.md)() |
| [getTraderInformation](get-trader-information.md) | [JVM]<br>public final [TraderInformation](../-trader-information/index.md)[getTraderInformation](get-trader-information.md)() |
