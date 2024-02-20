//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Activity](index.md)

# Activity

public final class [Activity](index.md) implements [TravelProduct](../-travel-product/index.md)

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

## Constructors

| | |
|---|---|
| [Activity](-activity.md) | [JVM]<br>public [Activity](index.md)[Activity](-activity.md)([Amount](../-amount/index.md)price, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventoryType, [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)inventorySource, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)categoryName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)activityDescription, [SupplyProvider](../-supply-provider/index.md)supplyProvider, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Ticket](../-ticket/index.md)&gt;tickets, [Coordinates](../-coordinates/index.md)coordinates, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;travelersReferences, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)payLater, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)startDateTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)endDateTime, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)isPassbook, [AvailablePolicy](../-available-policy/index.md)availablePolicy) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [activityDescription](index.md#-1446953933%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[activityDescription](index.md#-1446953933%2FProperties%2F-173342751) |
| [availablePolicy](index.md#-1010801275%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [AvailablePolicy](../-available-policy/index.md)[availablePolicy](index.md#-1010801275%2FProperties%2F-173342751) |
| [categoryName](index.md#-590479535%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[categoryName](index.md#-590479535%2FProperties%2F-173342751) |
| [coordinates](index.md#32316005%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Coordinates](../-coordinates/index.md)[coordinates](index.md#32316005%2FProperties%2F-173342751) |
| [endDateTime](index.md#-865372374%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[endDateTime](index.md#-865372374%2FProperties%2F-173342751) |
| [inventorySource](index.md#582805961%2FProperties%2F-173342751) | [JVM]<br>private final [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[inventorySource](index.md#582805961%2FProperties%2F-173342751) |
| [inventoryType](index.md#-356550326%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 30)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[inventoryType](index.md#-356550326%2FProperties%2F-173342751) |
| [isPassbook](is-passbook.md) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[isPassbook](is-passbook.md) |
| [payLater](index.md#-1838298090%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[payLater](index.md#-1838298090%2FProperties%2F-173342751) |
| [price](index.md#810681623%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[price](index.md#810681623%2FProperties%2F-173342751) |
| [startDateTime](index.md#-1531771965%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[startDateTime](index.md#-1531771965%2FProperties%2F-173342751) |
| [supplyProvider](index.md#1654641818%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [SupplyProvider](../-supply-provider/index.md)[supplyProvider](index.md#1654641818%2FProperties%2F-173342751) |
| [tickets](index.md#-207611783%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 40)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Ticket](../-ticket/index.md)&gt;[tickets](index.md#-207611783%2FProperties%2F-173342751) |
| [travelersReferences](index.md#1296576460%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 40)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[travelersReferences](index.md#1296576460%2FProperties%2F-173342751) |
| [type](index.md#152121056%2FProperties%2F-173342751) | [JVM]<br>private final [TravelProductType](../-travel-product-type/index.md)[type](index.md#152121056%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Activity.Builder](-builder/index.md)[builder](builder.md)() |
| [getActivityDescription](get-activity-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getActivityDescription](get-activity-description.md)() |
| [getAvailablePolicy](get-available-policy.md) | [JVM]<br>public final [AvailablePolicy](../-available-policy/index.md)[getAvailablePolicy](get-available-policy.md)() |
| [getCategoryName](get-category-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCategoryName](get-category-name.md)() |
| [getCoordinates](get-coordinates.md) | [JVM]<br>public final [Coordinates](../-coordinates/index.md)[getCoordinates](get-coordinates.md)() |
| [getEndDateTime](get-end-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getEndDateTime](get-end-date-time.md)() |
| [getInventorySource](get-inventory-source.md) | [JVM]<br>public [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[getInventorySource](get-inventory-source.md)() |
| [getInventoryType](get-inventory-type.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getInventoryType](get-inventory-type.md)() |
| [getPayLater](get-pay-later.md) | [JVM]<br>public [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getPayLater](get-pay-later.md)() |
| [getPrice](get-price.md) | [JVM]<br>public [Amount](../-amount/index.md)[getPrice](get-price.md)() |
| [getStartDateTime](get-start-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getStartDateTime](get-start-date-time.md)() |
| [getSupplyProvider](get-supply-provider.md) | [JVM]<br>public final [SupplyProvider](../-supply-provider/index.md)[getSupplyProvider](get-supply-provider.md)() |
| [getTickets](get-tickets.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Ticket](../-ticket/index.md)&gt;[getTickets](get-tickets.md)() |
| [getTravelersReferences](get-travelers-references.md) | [JVM]<br>public [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getTravelersReferences](get-travelers-references.md)() |
| [getType](get-type.md) | [JVM]<br>public [TravelProductType](../-travel-product-type/index.md)[getType](get-type.md)() |
| [isPassbook](is-passbook.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[isPassbook](is-passbook.md)() |
