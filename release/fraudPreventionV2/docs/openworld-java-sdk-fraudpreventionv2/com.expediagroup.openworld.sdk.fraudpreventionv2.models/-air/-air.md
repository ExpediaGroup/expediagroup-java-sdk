//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[Air](index.md)/[Air](-air.md)

# Air

[JVM]\

public [Air](index.md)[Air](-air.md)([Amount](../-amount/index.md)price, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventoryType, [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)inventorySource, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;travelersReferences, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)departureTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)arrivalTime, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[AirSegment](../-air-segment/index.md)&gt;airSegments, [Air.FlightType](-flight-type/index.md)flightType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)passengerNameRecord, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)globalDistributionSystemType)

#### Parameters

JVM

| | |
|---|---|
| departureTime | Local date and time of departure from original departure location, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| arrivalTime | Local date and time of arrival to final destination location, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| airSegments | Additional airline and flight details for each of the trip segments. |
| flightType | Identifies the type of air trip based on the air destinations. |
| passengerNameRecord | Airline booking confirmation code for the trip. |
| globalDistributionSystemType | Associated with Passenger Name Record (PNR). |
