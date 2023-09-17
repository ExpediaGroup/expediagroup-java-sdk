//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[Hotel](index.md)

# Hotel

public final class [Hotel](index.md) implements [TravelProduct](../-travel-product/index.md)

#### Parameters

JVM

| | |
|---|---|
| hotelId | Unique hotel identifier assigned by the partner. |
| hotelName | Name of the hotel. |
| address |
| checkinTime | Local date and time of the hotel check-in, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| checkoutTime | Local date and time of the hotel check-out, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| priceWithheld | Identifies if the product price was withheld from the customer during the booking process. |
| roomCount | Total number of rooms booked within the hotel product collection. |

## Constructors

| | |
|---|---|
| [Hotel](-hotel.md) | [JVM]<br>public [Hotel](index.md)[Hotel](-hotel.md)([Amount](../-amount/index.md)price, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventoryType, [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)inventorySource, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;travelersReferences, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)hotelId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)hotelName, [HotelAddress](../-hotel-address/index.md)address, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)checkinTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)checkoutTime, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)priceWithheld, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)roomCount) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Hotel.Builder](-builder/index.md)[builder](builder.md)() |
| [getAddress](get-address.md) | [JVM]<br>public final [HotelAddress](../-hotel-address/index.md)[getAddress](get-address.md)() |
| [getCheckinTime](get-checkin-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getCheckinTime](get-checkin-time.md)() |
| [getCheckoutTime](get-checkout-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getCheckoutTime](get-checkout-time.md)() |
| [getHotelId](get-hotel-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getHotelId](get-hotel-id.md)() |
| [getHotelName](get-hotel-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getHotelName](get-hotel-name.md)() |
| [getInventorySource](get-inventory-source.md) | [JVM]<br>public [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[getInventorySource](get-inventory-source.md)() |
| [getInventoryType](get-inventory-type.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getInventoryType](get-inventory-type.md)() |
| [getPrice](get-price.md) | [JVM]<br>public [Amount](../-amount/index.md)[getPrice](get-price.md)() |
| [getPriceWithheld](get-price-withheld.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getPriceWithheld](get-price-withheld.md)() |
| [getRoomCount](get-room-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getRoomCount](get-room-count.md)() |
| [getTravelersReferences](get-travelers-references.md) | [JVM]<br>public [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getTravelersReferences](get-travelers-references.md)() |
| [getType](get-type.md) | [JVM]<br>public [TravelProductType](../-travel-product-type/index.md)[getType](get-type.md)() |

## Properties

| Name | Summary |
|---|---|
| [address](index.md#233902971%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [HotelAddress](../-hotel-address/index.md)[address](index.md#233902971%2FProperties%2F-1883119931) |
| [checkinTime](index.md#-1269599083%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[checkinTime](index.md#-1269599083%2FProperties%2F-1883119931) |
| [checkoutTime](index.md#-1772171272%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[checkoutTime](index.md#-1772171272%2FProperties%2F-1883119931) |
| [hotelId](index.md#-1313988128%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[hotelId](index.md#-1313988128%2FProperties%2F-1883119931) |
| [hotelName](index.md#879063792%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[hotelName](index.md#879063792%2FProperties%2F-1883119931) |
| [inventorySource](index.md#244896312%2FProperties%2F-1883119931) | [JVM]<br>private final [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[inventorySource](index.md#244896312%2FProperties%2F-1883119931) |
| [inventoryType](index.md#67678585%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 30)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[inventoryType](index.md#67678585%2FProperties%2F-1883119931) |
| [price](index.md#-2033066938%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[price](index.md#-2033066938%2FProperties%2F-1883119931) |
| [priceWithheld](index.md#1333335691%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[priceWithheld](index.md#1333335691%2FProperties%2F-1883119931) |
| [roomCount](index.md#-218195461%2FProperties%2F-1883119931) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[roomCount](index.md#-218195461%2FProperties%2F-1883119931) |
| [travelersReferences](index.md#-1626584901%2FProperties%2F-1883119931) | [JVM]<br>@Size(min = 1, max = 40)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[travelersReferences](index.md#-1626584901%2FProperties%2F-1883119931) |
| [type](index.md#1722955217%2FProperties%2F-1883119931) | [JVM]<br>private final [TravelProductType](../-travel-product-type/index.md)[type](index.md#1722955217%2FProperties%2F-1883119931) |
