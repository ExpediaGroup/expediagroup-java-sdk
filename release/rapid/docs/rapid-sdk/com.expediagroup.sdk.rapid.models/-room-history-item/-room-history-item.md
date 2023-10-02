//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RoomHistoryItem](index.md)/[RoomHistoryItem](-room-history-item.md)

# RoomHistoryItem

[JVM]\

public [RoomHistoryItem](index.md)[RoomHistoryItem](-room-history-item.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)historyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)eventTimestamp, [RoomHistoryItem.EventType](-event-type/index.md)eventType, [RoomHistoryItem.EventSource](-event-source/index.md)eventSource, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)changeReferenceId, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)agentId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)roomId, [ConfirmationId](../-confirmation-id/index.md)confirmationId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bedGroupId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkin, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)checkout, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)numberOfAdults, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;childAges, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)givenName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)familyName, [StatusItinerary](../-status-itinerary/index.md)status, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)specialRequest, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)smoking, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)loyaltyId, [Charge](../-charge/index.md)amountCharged, [Charge](../-charge/index.md)amountRefunded, [Charge](../-charge/index.md)penalty, [RateHistory](../-rate-history/index.md)rate)

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
