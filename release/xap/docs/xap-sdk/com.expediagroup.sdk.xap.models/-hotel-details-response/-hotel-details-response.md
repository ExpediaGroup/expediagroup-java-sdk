//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelDetailsResponse](index.md)/[HotelDetailsResponse](-hotel-details-response.md)

# HotelDetailsResponse

[JVM]\

public [HotelDetailsResponse](index.md)[HotelDetailsResponse](-hotel-details-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)transactionId, [HotelDetailsResponseStayDates](../-hotel-details-response-stay-dates/index.md)stayDates, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)lengthOfStay, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)numberOfRooms, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelDetailsResponseOccupantsInner](../-hotel-details-response-occupants-inner/index.md)&gt;occupants, [Hotel](../-hotel/index.md)hotelDetails, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelDetailsResponseWarningsInner](../-hotel-details-response-warnings-inner/index.md)&gt;warnings, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ValidFormsOfPayment](../-valid-forms-of-payment/index.md)&gt;validFormsOfPayment)

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
