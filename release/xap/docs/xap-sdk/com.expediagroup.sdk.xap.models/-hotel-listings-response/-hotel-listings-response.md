//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelListingsResponse](index.md)/[HotelListingsResponse](-hotel-listings-response.md)

# HotelListingsResponse

[JVM]\

public [HotelListingsResponse](index.md)[HotelListingsResponse](-hotel-listings-response.md)([Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)count, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)totalHotelCount, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)transactionId, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)lengthOfStay, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)numberOfRooms, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Occupant](../-occupant/index.md)&gt;occupants, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Warning](../-warning/index.md)&gt;warnings, [HotelListingsResponseStayDates](../-hotel-listings-response-stay-dates/index.md)stayDates, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Hotel](../-hotel/index.md)&gt;hotels)

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
