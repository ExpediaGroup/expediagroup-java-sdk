//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[ItineraryHistoryItem](index.md)

# ItineraryHistoryItem

public final class [ItineraryHistoryItem](index.md)

An itinerary history change event, representing a charge or refund made to the itinerary and not a specific room.

#### Parameters

JVM

| | |
|---|---|
| historyId | Itinerary history id for particular change. |
| eventTimestamp | Date and time in UTC of the change event, in extended ISO 8601 format. |
| eventType |
| amount |
| agentId | An agent user id number associated with a modification. |

## Constructors

| | |
|---|---|
| [ItineraryHistoryItem](-itinerary-history-item.md) | [JVM]<br>public [ItineraryHistoryItem](index.md)[ItineraryHistoryItem](-itinerary-history-item.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)historyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)eventTimestamp, [ItineraryHistoryItem.EventType](-event-type/index.md)eventType, [Amount](../-amount/index.md)amount, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)agentId) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [EventType](-event-type/index.md) | [JVM]<br>public enum [EventType](-event-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[ItineraryHistoryItem.EventType](-event-type/index.md)&gt;<br>Values: ADJUSTMENT,COUPON |

## Properties

| Name | Summary |
|---|---|
| [agentId](index.md#-763321721%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[agentId](index.md#-763321721%2FProperties%2F700308213) |
| [amount](index.md#1135429467%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[amount](index.md#1135429467%2FProperties%2F700308213) |
| [eventTimestamp](index.md#1808044695%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[eventTimestamp](index.md#1808044695%2FProperties%2F700308213) |
| [eventType](index.md#-165103469%2FProperties%2F700308213) | [JVM]<br>private final [ItineraryHistoryItem.EventType](-event-type/index.md)[eventType](index.md#-165103469%2FProperties%2F700308213) |
| [historyId](index.md#1349924120%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[historyId](index.md#1349924120%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [ItineraryHistoryItem.Builder](-builder/index.md)[builder](builder.md)() |
| [getAgentId](get-agent-id.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getAgentId](get-agent-id.md)() |
| [getAmount](get-amount.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getAmount](get-amount.md)() |
| [getEventTimestamp](get-event-timestamp.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEventTimestamp](get-event-timestamp.md)() |
| [getEventType](get-event-type.md) | [JVM]<br>public final [ItineraryHistoryItem.EventType](-event-type/index.md)[getEventType](get-event-type.md)() |
| [getHistoryId](get-history-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getHistoryId](get-history-id.md)() |
