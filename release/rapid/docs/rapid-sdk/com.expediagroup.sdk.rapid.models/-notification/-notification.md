//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Notification](index.md)/[Notification](-notification.md)

# Notification

[JVM]\

public [Notification](index.md)[Notification](-notification.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)eventId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)eventType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)eventTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)itineraryId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)message, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateReferenceId)

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
