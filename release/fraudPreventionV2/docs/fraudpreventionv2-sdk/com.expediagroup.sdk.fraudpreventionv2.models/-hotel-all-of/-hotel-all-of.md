//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[HotelAllOf](index.md)/[HotelAllOf](-hotel-all-of.md)

# HotelAllOf

[JVM]\

public [HotelAllOf](index.md)[HotelAllOf](-hotel-all-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)hotelId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)hotelName, [HotelAddress](../-hotel-address/index.md)address, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)checkinTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)checkoutTime, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)priceWithheld, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)roomCount)

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
