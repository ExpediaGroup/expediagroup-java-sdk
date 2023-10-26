//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RoomHistoryItem](index.md)

# RoomHistoryItem

public final class [RoomHistoryItem](index.md)

A room history event, representing a change made to a specific room.

#### Parameters

JVM

| | |
|---|---|
| historyId | Room history id for particular change. |
| eventTimestamp | Date and time in UTC of the change event, in extended ISO 8601 format. |
| eventType | Type type of event associated with this history item such as modified or canceled. |
| eventSource | The source of the event. If `voyager_agent`, `agent_id` will be supplied. |
| changeReferenceId | Optional identifier provided during changes via Rapid. |
| agentId | An agent user id number associated with a modification. |
| roomId | The room id. |
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
| amountCharged |
| amountRefunded |
| penalty |
| rate |

## Constructors

| | |
|---|---|
| [RoomHistoryItem](-room-history-item.md) | [JVM]<br>public [RoomHistoryItem](index.md)[RoomHistoryItem](-room-history-item.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)historyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)eventTimestamp, [RoomHistoryItem.EventType](-event-type/index.md)eventType, [RoomHistoryItem.EventSource](-event-source/index.md)eventSource, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)changeReferenceId, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)agentId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [ConfirmationId](../-confirmation-id/index.md)confirmationId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bedGroupId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkin, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkout, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)numberOfAdults, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;childAges, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)givenName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)familyName, [StatusItinerary](../-status-itinerary/index.md)status, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)specialRequest, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)smoking, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)loyaltyId, [Charge](../-charge/index.md)amountCharged, [Charge](../-charge/index.md)amountRefunded, [Charge](../-charge/index.md)penalty, [RateHistory](../-rate-history/index.md)rate) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [EventSource](-event-source/index.md) | [JVM]<br>public enum [EventSource](-event-source/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RoomHistoryItem.EventSource](-event-source/index.md)&gt;<br>The source of the event. If `voyager_agent`, `agent_id` will be supplied. Values: RAPID_API,VOYAGER_AGENT,OTHER |
| [EventType](-event-type/index.md) | [JVM]<br>public enum [EventType](-event-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RoomHistoryItem.EventType](-event-type/index.md)&gt;<br>Type type of event associated with this history item such as modified or canceled. Values: CREATED,MODIFIED,CANCELED |

## Properties

| Name | Summary |
|---|---|
| [agentId](index.md#-842582967%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[agentId](index.md#-842582967%2FProperties%2F700308213) |
| [amountCharged](index.md#-1544949615%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[amountCharged](index.md#-1544949615%2FProperties%2F700308213) |
| [amountRefunded](index.md#-1236802814%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[amountRefunded](index.md#-1236802814%2FProperties%2F700308213) |
| [bedGroupId](index.md#-952564072%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[bedGroupId](index.md#-952564072%2FProperties%2F700308213) |
| [changeReferenceId](index.md#427601171%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[changeReferenceId](index.md#427601171%2FProperties%2F700308213) |
| [checkin](index.md#-236470340%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[checkin](index.md#-236470340%2FProperties%2F700308213) |
| [checkout](index.md#-530427093%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[checkout](index.md#-530427093%2FProperties%2F700308213) |
| [childAges](index.md#1844518841%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;[childAges](index.md#1844518841%2FProperties%2F700308213) |
| [confirmationId](index.md#961984641%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [ConfirmationId](../-confirmation-id/index.md)[confirmationId](index.md#961984641%2FProperties%2F700308213) |
| [eventSource](index.md#-417899628%2FProperties%2F700308213) | [JVM]<br>private final [RoomHistoryItem.EventSource](-event-source/index.md)[eventSource](index.md#-417899628%2FProperties%2F700308213) |
| [eventTimestamp](index.md#-1731403115%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[eventTimestamp](index.md#-1731403115%2FProperties%2F700308213) |
| [eventType](index.md#974250453%2FProperties%2F700308213) | [JVM]<br>private final [RoomHistoryItem.EventType](-event-type/index.md)[eventType](index.md#974250453%2FProperties%2F700308213) |
| [familyName](index.md#607747970%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[familyName](index.md#607747970%2FProperties%2F700308213) |
| [givenName](index.md#1676332449%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[givenName](index.md#1676332449%2FProperties%2F700308213) |
| [historyId](index.md#-1805689254%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[historyId](index.md#-1805689254%2FProperties%2F700308213) |
| [loyaltyId](index.md#1885421416%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[loyaltyId](index.md#1885421416%2FProperties%2F700308213) |
| [numberOfAdults](index.md#852116408%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[numberOfAdults](index.md#852116408%2FProperties%2F700308213) |
| [penalty](index.md#-860473632%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Charge](../-charge/index.md)[penalty](index.md#-860473632%2FProperties%2F700308213) |
| [rate](index.md#1599622865%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [RateHistory](../-rate-history/index.md)[rate](index.md#1599622865%2FProperties%2F700308213) |
| [roomId](index.md#-733593573%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[roomId](index.md#-733593573%2FProperties%2F700308213) |
| [smoking](index.md#1589083741%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[smoking](index.md#1589083741%2FProperties%2F700308213) |
| [specialRequest](index.md#1719065563%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[specialRequest](index.md#1719065563%2FProperties%2F700308213) |
| [status](index.md#898750207%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [StatusItinerary](../-status-itinerary/index.md)[status](index.md#898750207%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomHistoryItem.Builder](-builder/index.md)[builder](builder.md)() |
| [getAgentId](get-agent-id.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getAgentId](get-agent-id.md)() |
| [getAmountCharged](get-amount-charged.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getAmountCharged](get-amount-charged.md)() |
| [getAmountRefunded](get-amount-refunded.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getAmountRefunded](get-amount-refunded.md)() |
| [getBedGroupId](get-bed-group-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBedGroupId](get-bed-group-id.md)() |
| [getChangeReferenceId](get-change-reference-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getChangeReferenceId](get-change-reference-id.md)() |
| [getCheckin](get-checkin.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCheckin](get-checkin.md)() |
| [getCheckout](get-checkout.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCheckout](get-checkout.md)() |
| [getChildAges](get-child-ages.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;[getChildAges](get-child-ages.md)() |
| [getConfirmationId](get-confirmation-id.md) | [JVM]<br>public final [ConfirmationId](../-confirmation-id/index.md)[getConfirmationId](get-confirmation-id.md)() |
| [getEventSource](get-event-source.md) | [JVM]<br>public final [RoomHistoryItem.EventSource](-event-source/index.md)[getEventSource](get-event-source.md)() |
| [getEventTimestamp](get-event-timestamp.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEventTimestamp](get-event-timestamp.md)() |
| [getEventType](get-event-type.md) | [JVM]<br>public final [RoomHistoryItem.EventType](-event-type/index.md)[getEventType](get-event-type.md)() |
| [getFamilyName](get-family-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getFamilyName](get-family-name.md)() |
| [getGivenName](get-given-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGivenName](get-given-name.md)() |
| [getHistoryId](get-history-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getHistoryId](get-history-id.md)() |
| [getLoyaltyId](get-loyalty-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLoyaltyId](get-loyalty-id.md)() |
| [getNumberOfAdults](get-number-of-adults.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getNumberOfAdults](get-number-of-adults.md)() |
| [getPenalty](get-penalty.md) | [JVM]<br>public final [Charge](../-charge/index.md)[getPenalty](get-penalty.md)() |
| [getRate](get-rate.md) | [JVM]<br>public final [RateHistory](../-rate-history/index.md)[getRate](get-rate.md)() |
| [getRoomId](get-room-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRoomId](get-room-id.md)() |
| [getSmoking](get-smoking.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getSmoking](get-smoking.md)() |
| [getSpecialRequest](get-special-request.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSpecialRequest](get-special-request.md)() |
| [getStatus](get-status.md) | [JVM]<br>public final [StatusItinerary](../-status-itinerary/index.md)[getStatus](get-status.md)() |
