//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Cruise](index.md)/[Cruise](-cruise.md)

# Cruise

[JVM]\

public [Cruise](index.md)[Cruise](-cruise.md)([Amount](../-amount/index.md)price, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventoryType, [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)inventorySource, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)departureTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)arrivalTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)embarkationPort, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)disembarkationPort, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)shipName, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;travelersReferences, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)payLater)

#### Parameters

JVM

| | |
|---|---|
| departureTime | Local date and time of departure from original departure location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| arrivalTime | Local date and time of arrival from original arrival location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| embarkationPort | Location from where cruise will depart. |
| disembarkationPort | The cruise's final destination. |
| shipName | Name of the cruise ship. |
