//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[AirAllOf](index.md)

# AirAllOf

public final class [AirAllOf](index.md)

#### Parameters

JVM

| | |
|---|---|
| departureTime | Local date and time of departure from original departure location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| arrivalTime | Local date and time of arrival to final destination location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| airSegments | Additional airline and flight details for each of the trip segments. |
| flightType | Identifies the type of air trip based on the air destinations. |
| passengerNameRecord | Airline booking confirmation code for the trip. |
| globalDistributionSystemType | Associated with Passenger Name Record (PNR). |

## Constructors

| | |
|---|---|
| [AirAllOf](-air-all-of.md) | [JVM]<br>public [AirAllOf](index.md)[AirAllOf](-air-all-of.md)([OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)departureTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)arrivalTime, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[AirSegment](../-air-segment/index.md)&gt;airSegments, [AirAllOf.FlightType](-flight-type/index.md)flightType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)passengerNameRecord, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)globalDistributionSystemType) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [FlightType](-flight-type/index.md) | [JVM]<br>public enum [FlightType](-flight-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AirAllOf.FlightType](-flight-type/index.md)&gt;<br>Identifies the type of air trip based on the air destinations. Values: ROUNDTRIP,ONEWAY,MULTIPLE_DESTINATION |

## Properties

| Name | Summary |
|---|---|
| [airSegments](index.md#-999346569%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 30)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[AirSegment](../-air-segment/index.md)&gt;[airSegments](index.md#-999346569%2FProperties%2F-173342751) |
| [arrivalTime](index.md#-1574067557%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[arrivalTime](index.md#-1574067557%2FProperties%2F-173342751) |
| [departureTime](index.md#1666888320%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[departureTime](index.md#1666888320%2FProperties%2F-173342751) |
| [flightType](index.md#-567589841%2FProperties%2F-173342751) | [JVM]<br>private final [AirAllOf.FlightType](-flight-type/index.md)[flightType](index.md#-567589841%2FProperties%2F-173342751) |
| [globalDistributionSystemType](index.md#-22762359%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 100)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[globalDistributionSystemType](index.md#-22762359%2FProperties%2F-173342751) |
| [passengerNameRecord](index.md#435974155%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 100)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[passengerNameRecord](index.md#435974155%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [AirAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getAirSegments](get-air-segments.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[AirSegment](../-air-segment/index.md)&gt;[getAirSegments](get-air-segments.md)() |
| [getArrivalTime](get-arrival-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getArrivalTime](get-arrival-time.md)() |
| [getDepartureTime](get-departure-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getDepartureTime](get-departure-time.md)() |
| [getFlightType](get-flight-type.md) | [JVM]<br>public final [AirAllOf.FlightType](-flight-type/index.md)[getFlightType](get-flight-type.md)() |
| [getGlobalDistributionSystemType](get-global-distribution-system-type.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGlobalDistributionSystemType](get-global-distribution-system-type.md)() |
| [getPassengerNameRecord](get-passenger-name-record.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPassengerNameRecord](get-passenger-name-record.md)() |
