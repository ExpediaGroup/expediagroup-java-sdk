//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Activity](index.md)/[Activity](-activity.md)

# Activity

[JVM]\

public [Activity](index.md)[Activity](-activity.md)([Amount](../-amount/index.md)price, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventoryType, [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)inventorySource, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)categoryName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)activityDescription, [SupplyProvider](../-supply-provider/index.md)supplyProvider, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Ticket](../-ticket/index.md)&gt;tickets, [Coordinates](../-coordinates/index.md)coordinates, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;travelersReferences, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)payLater, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)startDateTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)endDateTime, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)isPassbook, [AvailablePolicy](../-available-policy/index.md)availablePolicy)

#### Parameters

JVM

| | |
|---|---|
| categoryName | This field categorizes various types of activities available within the product. It allows API consumers to assign descriptive labels or keywords representing the nature of each activity. Possible category name values include: * `Adventures`: This category includes activities such as hiking, zip-lining, rock climbing, bungee jumping, and other adventurous pursuits. * `Air, Balloon & Helicopter Tours`: This category offers activities like hot air balloon rides, helicopter tours, and aerial sightseeing experiences. * `Cruises & Water Tours`: This includes options such as boat cruises, yacht tours, river rafting, snorkeling, and diving expeditions.  * `Nightlife`: This category encompasses activities like clubbing, pub crawls, live music events, and cultural performances. These activities predominantly occur during the evening or nighttime. |
| activityDescription | This field provides additional details or a brief explanation of the specific activity. |
| supplyProvider |
| tickets |
| coordinates |
| startDateTime | The field represents the start time of an activity, using the ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| endDateTime | The field represents the end time of an activity, using the ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| isPassbook | Indicates whether a QR code is required for an activity, serving as proof of reservation or purchase. This includes digital tickets saved on mobile applications such as Google Pay, Apple Wallet, or similar services provided by activity organizers. |
| availablePolicy |
