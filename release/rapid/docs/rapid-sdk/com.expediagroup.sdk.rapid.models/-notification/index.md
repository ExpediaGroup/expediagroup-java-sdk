//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Notification](index.md)

# Notification

public final class [Notification](index.md)

A notification.

#### Parameters

JVM

| | |
|---|---|
| eventId | Unique identifier for each message |
| eventType | An indication of what event caused the notification. This value can be used for message handling and routing. Refer to the list of event types for more information. |
| eventTime | Timestamp of the event notification, in UTC |
| itineraryId | The Itinerary ID of the affected booking |
| email | The customer e-mail address associated with the affected itinerary |
| message | Description of event notification |
| affiliateReferenceId | The Affiliate Reference ID of the affected booking |

## Constructors

| | |
|---|---|
| [Notification](-notification.md) | [JVM]<br>public [Notification](index.md)[Notification](-notification.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)eventId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)eventType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)eventTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)message, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateReferenceId) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [affiliateReferenceId](index.md#1122642441%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[affiliateReferenceId](index.md#1122642441%2FProperties%2F700308213) |
| [email](index.md#-918692900%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[email](index.md#-918692900%2FProperties%2F700308213) |
| [eventId](index.md#-1383335549%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[eventId](index.md#-1383335549%2FProperties%2F700308213) |
| [eventTime](index.md#781419473%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[eventTime](index.md#781419473%2FProperties%2F700308213) |
| [eventType](index.md#-409523196%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[eventType](index.md#-409523196%2FProperties%2F700308213) |
| [itineraryId](index.md#165340914%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[itineraryId](index.md#165340914%2FProperties%2F700308213) |
| [message](index.md#1030701841%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[message](index.md#1030701841%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Notification.Builder](-builder/index.md)[builder](builder.md)() |
| [getAffiliateReferenceId](get-affiliate-reference-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAffiliateReferenceId](get-affiliate-reference-id.md)() |
| [getEmail](get-email.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEmail](get-email.md)() |
| [getEventId](get-event-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEventId](get-event-id.md)() |
| [getEventTime](get-event-time.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEventTime](get-event-time.md)() |
| [getEventType](get-event-type.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEventType](get-event-type.md)() |
| [getItineraryId](get-itinerary-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getItineraryId](get-itinerary-id.md)() |
| [getMessage](get-message.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMessage](get-message.md)() |
