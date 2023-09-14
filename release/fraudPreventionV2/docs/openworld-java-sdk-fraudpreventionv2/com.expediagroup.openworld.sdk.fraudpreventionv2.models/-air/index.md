//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[Air](index.md)

# Air

public final class [Air](index.md) implements [TravelProduct](../-travel-product/index.md)

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

## Constructors

| | |
|---|---|
| [Air](-air.md) | [JVM]<br>public [Air](index.md)[Air](-air.md)([Amount](../-amount/index.md)price, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)inventoryType, [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)inventorySource, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;travelersReferences, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)departureTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)arrivalTime, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[AirSegment](../-air-segment/index.md)&gt;airSegments, [Air.FlightType](-flight-type/index.md)flightType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)passengerNameRecord, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)globalDistributionSystemType) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [FlightType](-flight-type/index.md) | [JVM]<br>public enum [FlightType](-flight-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Air.FlightType](-flight-type/index.md)&gt;<br>Identifies the type of air trip based on the air destinations. Values: ROUNDTRIP,ONEWAY,MULTIPLE_DESTINATION |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Air.Builder](-builder/index.md)[builder](builder.md)() |
| [getAirSegments](get-air-segments.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[AirSegment](../-air-segment/index.md)&gt;[getAirSegments](get-air-segments.md)() |
| [getArrivalTime](get-arrival-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getArrivalTime](get-arrival-time.md)() |
| [getDepartureTime](get-departure-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getDepartureTime](get-departure-time.md)() |
| [getFlightType](get-flight-type.md) | [JVM]<br>public final [Air.FlightType](-flight-type/index.md)[getFlightType](get-flight-type.md)() |
| [getGlobalDistributionSystemType](get-global-distribution-system-type.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGlobalDistributionSystemType](get-global-distribution-system-type.md)() |
| [getInventorySource](get-inventory-source.md) | [JVM]<br>public [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[getInventorySource](get-inventory-source.md)() |
| [getInventoryType](get-inventory-type.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getInventoryType](get-inventory-type.md)() |
| [getPassengerNameRecord](get-passenger-name-record.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPassengerNameRecord](get-passenger-name-record.md)() |
| [getPrice](get-price.md) | [JVM]<br>public [Amount](../-amount/index.md)[getPrice](get-price.md)() |
| [getTravelersReferences](get-travelers-references.md) | [JVM]<br>public [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getTravelersReferences](get-travelers-references.md)() |
| [getType](get-type.md) | [JVM]<br>public [TravelProductType](../-travel-product-type/index.md)[getType](get-type.md)() |

## Properties

| Name | Summary |
|---|---|
| [airSegments](index.md#-300236785%2FProperties%2F-1883119931) | [JVM]<br>@Size(min = 1, max = 30)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[AirSegment](../-air-segment/index.md)&gt;[airSegments](index.md#-300236785%2FProperties%2F-1883119931) |
| [arrivalTime](index.md#-874957773%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[arrivalTime](index.md#-874957773%2FProperties%2F-1883119931) |
| [departureTime](index.md#-798474728%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[departureTime](index.md#-798474728%2FProperties%2F-1883119931) |
| [flightType](index.md#-1099227241%2FProperties%2F-1883119931) | [JVM]<br>private final [Air.FlightType](-flight-type/index.md)[flightType](index.md#-1099227241%2FProperties%2F-1883119931) |
| [globalDistributionSystemType](index.md#1477148145%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 100)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[globalDistributionSystemType](index.md#1477148145%2FProperties%2F-1883119931) |
| [inventorySource](index.md#-2026308318%2FProperties%2F-1883119931) | [JVM]<br>private final [TravelProduct.InventorySource](../-travel-product/-inventory-source/index.md)[inventorySource](index.md#-2026308318%2FProperties%2F-1883119931) |
| [inventoryType](index.md#1571458787%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 30)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[inventoryType](index.md#1571458787%2FProperties%2F-1883119931) |
| [passengerNameRecord](index.md#875096483%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 100)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[passengerNameRecord](index.md#875096483%2FProperties%2F-1883119931) |
| [price](index.md#-34290768%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[price](index.md#-34290768%2FProperties%2F-1883119931) |
| [travelersReferences](index.md#610856613%2FProperties%2F-1883119931) | [JVM]<br>@Size(min = 1, max = 40)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[travelersReferences](index.md#610856613%2FProperties%2F-1883119931) |
| [type](index.md#1094695207%2FProperties%2F-1883119931) | [JVM]<br>private final [TravelProductType](../-travel-product-type/index.md)[type](index.md#1094695207%2FProperties%2F-1883119931) |
