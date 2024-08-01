//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelListingsResponse](index.md)

# HotelListingsResponse

public final class [HotelListingsResponse](index.md)

#### Parameters

JVM

| | |
|---|---|
| count | The number of hotels actually returned in the response. |
| totalHotelCount | The number of hotels present in the location. |
| transactionId | Unique identifier for the transaction. |
| lengthOfStay | The number of stay nights. |
| numberOfRooms | The number of the rooms requested on behalf of the user. |
| occupants | Container of occupants. It is an array including occupants of each room. |
| warnings | There were some errors or events during the transaction, but the API has still returned a response.  Container for all warnings. |
| stayDates |
| hotels | Container for all hotels. |

## Constructors

| | |
|---|---|
| [HotelListingsResponse](-hotel-listings-response.md) | [JVM]<br>public [HotelListingsResponse](index.md)[HotelListingsResponse](-hotel-listings-response.md)([Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)count, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)totalHotelCount, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)transactionId, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)lengthOfStay, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)numberOfRooms, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Occupant](../-occupant/index.md)&gt;occupants, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Warning](../-warning/index.md)&gt;warnings, [HotelListingsResponseStayDates](../-hotel-listings-response-stay-dates/index.md)stayDates, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Hotel](../-hotel/index.md)&gt;hotels) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [count](index.md#396418893%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[count](index.md#396418893%2FProperties%2F699445674) |
| [hotels](index.md#925920639%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Hotel](../-hotel/index.md)&gt;[hotels](index.md#925920639%2FProperties%2F699445674) |
| [lengthOfStay](index.md#1843140232%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[lengthOfStay](index.md#1843140232%2FProperties%2F699445674) |
| [numberOfRooms](index.md#866103716%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[numberOfRooms](index.md#866103716%2FProperties%2F699445674) |
| [occupants](index.md#881980518%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Occupant](../-occupant/index.md)&gt;[occupants](index.md#881980518%2FProperties%2F699445674) |
| [stayDates](index.md#-216017968%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [HotelListingsResponseStayDates](../-hotel-listings-response-stay-dates/index.md)[stayDates](index.md#-216017968%2FProperties%2F699445674) |
| [totalHotelCount](index.md#180985213%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[totalHotelCount](index.md#180985213%2FProperties%2F699445674) |
| [transactionId](index.md#1480823811%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[transactionId](index.md#1480823811%2FProperties%2F699445674) |
| [warnings](index.md#-1046526681%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Warning](../-warning/index.md)&gt;[warnings](index.md#-1046526681%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [HotelListingsResponse.Builder](-builder/index.md)[builder](builder.md)() |
| [getCount](get-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getCount](get-count.md)() |
| [getHotels](get-hotels.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Hotel](../-hotel/index.md)&gt;[getHotels](get-hotels.md)() |
| [getLengthOfStay](get-length-of-stay.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getLengthOfStay](get-length-of-stay.md)() |
| [getNumberOfRooms](get-number-of-rooms.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getNumberOfRooms](get-number-of-rooms.md)() |
| [getOccupants](get-occupants.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Occupant](../-occupant/index.md)&gt;[getOccupants](get-occupants.md)() |
| [getStayDates](get-stay-dates.md) | [JVM]<br>public final [HotelListingsResponseStayDates](../-hotel-listings-response-stay-dates/index.md)[getStayDates](get-stay-dates.md)() |
| [getTotalHotelCount](get-total-hotel-count.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getTotalHotelCount](get-total-hotel-count.md)() |
| [getTransactionId](get-transaction-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTransactionId](get-transaction-id.md)() |
| [getWarnings](get-warnings.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Warning](../-warning/index.md)&gt;[getWarnings](get-warnings.md)() |
