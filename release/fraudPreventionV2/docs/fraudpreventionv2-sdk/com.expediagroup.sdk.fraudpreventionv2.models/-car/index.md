//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Car](index.md)

# Car

public final class [Car](index.md) implements [TravelProduct](../-travel-product/index.md)

#### Parameters

JVM

| | |
|---|---|
| pickUpLocation | Location where the automobile will be picked up. |
| dropOffLocation | Location at which the automobile will be returned. |
| pickupTime | Local date and time the automobile will be picked-up, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| returnTime | Local date and time the automobile will be returned, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |

## Constructors

| | |
|---|---|
| [Car](-car.md) | [JVM]<br>public [Car](index.md)[Car](-car.md)([Amount](../-amount/index.md)price, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventoryType, [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)inventorySource, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)pickUpLocation, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)dropOffLocation, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)pickupTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)returnTime, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;travelersReferences, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)payLater) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [dropOffLocation](index.md#-624284736%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[dropOffLocation](index.md#-624284736%2FProperties%2F-173342751) |
| [inventorySource](index.md#-1341251266%2FProperties%2F-173342751) | [JVM]<br>private final [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[inventorySource](index.md#-1341251266%2FProperties%2F-173342751) |
| [inventoryType](index.md#-1703802369%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 30)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[inventoryType](index.md#-1703802369%2FProperties%2F-173342751) |
| [payLater](index.md#-1862869439%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[payLater](index.md#-1862869439%2FProperties%2F-173342751) |
| [pickUpLocation](index.md#759845172%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[pickUpLocation](index.md#759845172%2FProperties%2F-173342751) |
| [pickupTime](index.md#1752528700%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[pickupTime](index.md#1752528700%2FProperties%2F-173342751) |
| [price](index.md#1938234060%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[price](index.md#1938234060%2FProperties%2F-173342751) |
| [returnTime](index.md#-1362480888%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[returnTime](index.md#-1362480888%2FProperties%2F-173342751) |
| [travelersReferences](index.md#-677993279%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 40)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[travelersReferences](index.md#-677993279%2FProperties%2F-173342751) |
| [type](index.md#-88600949%2FProperties%2F-173342751) | [JVM]<br>private final [TravelProductType](../-travel-product-type/index.md)[type](index.md#-88600949%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Car.Builder](-builder/index.md)[builder](builder.md)() |
| [getDropOffLocation](get-drop-off-location.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDropOffLocation](get-drop-off-location.md)() |
| [getInventorySource](get-inventory-source.md) | [JVM]<br>public [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[getInventorySource](get-inventory-source.md)() |
| [getInventoryType](get-inventory-type.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getInventoryType](get-inventory-type.md)() |
| [getPayLater](get-pay-later.md) | [JVM]<br>public [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getPayLater](get-pay-later.md)() |
| [getPickUpLocation](get-pick-up-location.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPickUpLocation](get-pick-up-location.md)() |
| [getPickupTime](get-pickup-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getPickupTime](get-pickup-time.md)() |
| [getPrice](get-price.md) | [JVM]<br>public [Amount](../-amount/index.md)[getPrice](get-price.md)() |
| [getReturnTime](get-return-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getReturnTime](get-return-time.md)() |
| [getTravelersReferences](get-travelers-references.md) | [JVM]<br>public [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getTravelersReferences](get-travelers-references.md)() |
| [getType](get-type.md) | [JVM]<br>public [TravelProductType](../-travel-product-type/index.md)[getType](get-type.md)() |
