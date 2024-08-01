//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelDetailsResponseStayDates](index.md)

# HotelDetailsResponseStayDates

public final class [HotelDetailsResponseStayDates](index.md)

#### Parameters

JVM

| | |
|---|---|
| checkInDate | Check-in date for property stay in an ISO 8601 Date format YYYY-MM-DD.  This parameter should be used in combination with the `checkOut` parameter.  The maximum advanced search window is 330 days in the future.  The maximum length of stay is 28 days. |
| checkOutDate | Checkout date for property stay in an ISO 8601 Date format YYYY-MM-DD.  This parameter should be used in combination with the `checkIn` parameter.  The maximum advanced search window is 330 days in the future.  The maximum length of stay is 28 days. |

## Constructors

| | |
|---|---|
| [HotelDetailsResponseStayDates](-hotel-details-response-stay-dates.md) | [JVM]<br>public [HotelDetailsResponseStayDates](index.md)[HotelDetailsResponseStayDates](-hotel-details-response-stay-dates.md)([Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)checkInDate, [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)checkOutDate) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [checkInDate](index.md#-682298840%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[checkInDate](index.md#-682298840%2FProperties%2F699445674) |
| [checkOutDate](index.md#147890531%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[checkOutDate](index.md#147890531%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [HotelDetailsResponseStayDates.Builder](-builder/index.md)[builder](builder.md)() |
| [getCheckInDate](get-check-in-date.md) | [JVM]<br>public final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[getCheckInDate](get-check-in-date.md)() |
| [getCheckOutDate](get-check-out-date.md) | [JVM]<br>public final [Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)[getCheckOutDate](get-check-out-date.md)() |
