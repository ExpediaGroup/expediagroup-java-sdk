//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelDetailsResponse](index.md)

# HotelDetailsResponse

public final class [HotelDetailsResponse](index.md)

#### Parameters

JVM

| | |
|---|---|
| transactionId | Unique identifier for the transaction. |
| stayDates |
| lengthOfStay | The number of stay nights. |
| numberOfRooms | Number of rooms requested. |
| occupants | Container for the list of rooms requested by the traveler.  Occupancy for each room is specified in this node. |
| hotelDetails |
| warnings | There were some errors or events during the transaction, but the API has still returned a response.  Container for all warnings. |
| validFormsOfPayment | Container for payment information. |

## Constructors

| | |
|---|---|
| [HotelDetailsResponse](-hotel-details-response.md) | [JVM]<br>public [HotelDetailsResponse](index.md)[HotelDetailsResponse](-hotel-details-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)transactionId, [HotelDetailsResponseStayDates](../-hotel-details-response-stay-dates/index.md)stayDates, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)lengthOfStay, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)numberOfRooms, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelDetailsResponseOccupantsInner](../-hotel-details-response-occupants-inner/index.md)&gt;occupants, [Hotel](../-hotel/index.md)hotelDetails, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelDetailsResponseWarningsInner](../-hotel-details-response-warnings-inner/index.md)&gt;warnings, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ValidFormsOfPayment](../-valid-forms-of-payment/index.md)&gt;validFormsOfPayment) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [hotelDetails](index.md#-1871623997%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Hotel](../-hotel/index.md)[hotelDetails](index.md#-1871623997%2FProperties%2F699445674) |
| [lengthOfStay](index.md#1360051291%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[lengthOfStay](index.md#1360051291%2FProperties%2F699445674) |
| [numberOfRooms](index.md#-1224751567%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[numberOfRooms](index.md#-1224751567%2FProperties%2F699445674) |
| [occupants](index.md#-584820877%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelDetailsResponseOccupantsInner](../-hotel-details-response-occupants-inner/index.md)&gt;[occupants](index.md#-584820877%2FProperties%2F699445674) |
| [stayDates](index.md#-1682819363%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [HotelDetailsResponseStayDates](../-hotel-details-response-stay-dates/index.md)[stayDates](index.md#-1682819363%2FProperties%2F699445674) |
| [transactionId](index.md#-610031472%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[transactionId](index.md#-610031472%2FProperties%2F699445674) |
| [validFormsOfPayment](index.md#1888445869%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ValidFormsOfPayment](../-valid-forms-of-payment/index.md)&gt;[validFormsOfPayment](index.md#1888445869%2FProperties%2F699445674) |
| [warnings](index.md#14535802%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelDetailsResponseWarningsInner](../-hotel-details-response-warnings-inner/index.md)&gt;[warnings](index.md#14535802%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [HotelDetailsResponse.Builder](-builder/index.md)[builder](builder.md)() |
| [getHotelDetails](get-hotel-details.md) | [JVM]<br>public final [Hotel](../-hotel/index.md)[getHotelDetails](get-hotel-details.md)() |
| [getLengthOfStay](get-length-of-stay.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getLengthOfStay](get-length-of-stay.md)() |
| [getNumberOfRooms](get-number-of-rooms.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getNumberOfRooms](get-number-of-rooms.md)() |
| [getOccupants](get-occupants.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelDetailsResponseOccupantsInner](../-hotel-details-response-occupants-inner/index.md)&gt;[getOccupants](get-occupants.md)() |
| [getStayDates](get-stay-dates.md) | [JVM]<br>public final [HotelDetailsResponseStayDates](../-hotel-details-response-stay-dates/index.md)[getStayDates](get-stay-dates.md)() |
| [getTransactionId](get-transaction-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTransactionId](get-transaction-id.md)() |
| [getValidFormsOfPayment](get-valid-forms-of-payment.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ValidFormsOfPayment](../-valid-forms-of-payment/index.md)&gt;[getValidFormsOfPayment](get-valid-forms-of-payment.md)() |
| [getWarnings](get-warnings.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelDetailsResponseWarningsInner](../-hotel-details-response-warnings-inner/index.md)&gt;[getWarnings](get-warnings.md)() |
