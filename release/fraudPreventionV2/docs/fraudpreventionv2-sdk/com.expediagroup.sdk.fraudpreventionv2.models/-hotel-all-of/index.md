//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[HotelAllOf](index.md)

# HotelAllOf

public final class [HotelAllOf](index.md)

#### Parameters

JVM

| | |
|---|---|
| hotelId | Unique hotel identifier assigned by the partner. |
| hotelName | Name of the hotel. |
| address |
| checkinTime | Local date and time of the hotel check-in, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| checkoutTime | Local date and time of the hotel check-out, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| priceWithheld | Identifies if the product price was withheld from the customer during the booking process. |
| roomCount | Total number of rooms booked within the hotel product collection. |

## Constructors

| | |
|---|---|
| [HotelAllOf](-hotel-all-of.md) | [JVM]<br>public [HotelAllOf](index.md)[HotelAllOf](-hotel-all-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)hotelId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)hotelName, [HotelAddress](../-hotel-address/index.md)address, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)checkinTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)checkoutTime, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)priceWithheld, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)roomCount) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [address](index.md#-1005801737%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [HotelAddress](../-hotel-address/index.md)[address](index.md#-1005801737%2FProperties%2F-173342751) |
| [checkinTime](index.md#1945956881%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[checkinTime](index.md#1945956881%2FProperties%2F-173342751) |
| [checkoutTime](index.md#-874184196%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[checkoutTime](index.md#-874184196%2FProperties%2F-173342751) |
| [hotelId](index.md#1741274460%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[hotelId](index.md#1741274460%2FProperties%2F-173342751) |
| [hotelName](index.md#-771219604%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[hotelName](index.md#-771219604%2FProperties%2F-173342751) |
| [priceWithheld](index.md#-893836025%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[priceWithheld](index.md#-893836025%2FProperties%2F-173342751) |
| [roomCount](index.md#-1868478857%2FProperties%2F-173342751) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[roomCount](index.md#-1868478857%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [HotelAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getAddress](get-address.md) | [JVM]<br>public final [HotelAddress](../-hotel-address/index.md)[getAddress](get-address.md)() |
| [getCheckinTime](get-checkin-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getCheckinTime](get-checkin-time.md)() |
| [getCheckoutTime](get-checkout-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getCheckoutTime](get-checkout-time.md)() |
| [getHotelId](get-hotel-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getHotelId](get-hotel-id.md)() |
| [getHotelName](get-hotel-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getHotelName](get-hotel-name.md)() |
| [getPriceWithheld](get-price-withheld.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getPriceWithheld](get-price-withheld.md)() |
| [getRoomCount](get-room-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getRoomCount](get-room-count.md)() |
