//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[AirSegment](index.md)

# AirSegment

public final class [AirSegment](index.md)

#### Parameters

JVM

| | |
|---|---|
| airlineCode | Airline code of the trip segment |
| departureAirportCode | Departure airport of the trip segment |
| arrivalAirportCode | Arrival airport of the trip segment |
| departureTime | Local date and time of departure from departure location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| arrivalTime | Local date and time of arrival to destination location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |

## Constructors

| | |
|---|---|
| [AirSegment](-air-segment.md) | [JVM]<br>public [AirSegment](index.md)[AirSegment](-air-segment.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)airlineCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)departureAirportCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)arrivalAirportCode, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)departureTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)arrivalTime) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [airlineCode](index.md#-569818341%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 10)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[airlineCode](index.md#-569818341%2FProperties%2F-173342751) |
| [arrivalAirportCode](index.md#2028922005%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 10)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[arrivalAirportCode](index.md#2028922005%2FProperties%2F-173342751) |
| [arrivalTime](index.md#-21223328%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[arrivalTime](index.md#-21223328%2FProperties%2F-173342751) |
| [departureAirportCode](index.md#-1402872240%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 10)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[departureAirportCode](index.md#-1402872240%2FProperties%2F-173342751) |
| [departureTime](index.md#-698426619%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[departureTime](index.md#-698426619%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [AirSegment.Builder](-builder/index.md)[builder](builder.md)() |
| [getAirlineCode](get-airline-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAirlineCode](get-airline-code.md)() |
| [getArrivalAirportCode](get-arrival-airport-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getArrivalAirportCode](get-arrival-airport-code.md)() |
| [getArrivalTime](get-arrival-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getArrivalTime](get-arrival-time.md)() |
| [getDepartureAirportCode](get-departure-airport-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDepartureAirportCode](get-departure-airport-code.md)() |
| [getDepartureTime](get-departure-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getDepartureTime](get-departure-time.md)() |
