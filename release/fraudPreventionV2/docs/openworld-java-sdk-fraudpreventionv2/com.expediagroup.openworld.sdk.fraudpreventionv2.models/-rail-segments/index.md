//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[RailSegments](index.md)

# RailSegments

public final class [RailSegments](index.md)

#### Parameters

JVM

| | |
|---|---|
| departureTime | The local date and time of the scheduled departure from the departure station, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| arrivalTime | The local date and time of the scheduled arrival at the destination station, in ISO-8061 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| departureStation |
| arrivalStation |
| transportationMethod | This attribute represents the specific transportation method by which the passenger is traveling. It captures the mode of transportation used during the Rail product journey, Possible values are:     - `BUS` - The Rail product includes bus transportation for certain segments of the itinerary.     - `FERRY` - The Rail product involves ferry transportation as part of the journey.     - `PUBLIC_TRANSPORT` - The Rail product represents the use of public transportation modes for the journey.     - `TRAM` - The Rail product includes tram transportation as part of the journey.     - `RAIL` - The Rail product specifically utilizes train transportation for the journey.     - `TRANSFER` - The Rail product involves transfers between different modes of transportation.     - `OTHER` - The Rail product utilizes transportation methods not covered by the aforementioned categories. |
| operatingCompany |

## Constructors

| | |
|---|---|
| [RailSegments](-rail-segments.md) | [JVM]<br>public [RailSegments](index.md)[RailSegments](-rail-segments.md)([OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)departureTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)arrivalTime, [RailwayStationDetails](../-railway-station-details/index.md)departureStation, [RailwayStationDetails](../-railway-station-details/index.md)arrivalStation, [RailSegments.TransportationMethod](-transportation-method/index.md)transportationMethod, [RailSegmentsOperatingCompany](../-rail-segments-operating-company/index.md)operatingCompany) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [TransportationMethod](-transportation-method/index.md) | [JVM]<br>public enum [TransportationMethod](-transportation-method/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RailSegments.TransportationMethod](-transportation-method/index.md)&gt;<br>This attribute represents the specific transportation method by which the passenger is traveling. It captures the mode of transportation used during the Rail product journey, Possible values are:     - `BUS` - The Rail product includes bus transportation for certain segments of the itinerary.     - `FERRY` - The Rail product involves ferry transportation as part of the journey.     - `PUBLIC_TRANSPORT` - The Rail product represents the use of public transportation modes for the journey.     - `TRAM` - The Rail product includes tram transportation as part of the journey.     - `RAIL` - The Rail product specifically utilizes train transportation for the journey.     - `TRANSFER` - The Rail product involves transfers between different modes of transportation.     - `OTHER` - The Rail product utilizes transportation methods not covered by the aforementioned categories. Values: BUS,FERRY,PUBLIC_TRANSPORT,RAIL,TRAM,TRANSFER,OTHERS |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RailSegments.Builder](-builder/index.md)[builder](builder.md)() |
| [getArrivalStation](get-arrival-station.md) | [JVM]<br>public final [RailwayStationDetails](../-railway-station-details/index.md)[getArrivalStation](get-arrival-station.md)() |
| [getArrivalTime](get-arrival-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getArrivalTime](get-arrival-time.md)() |
| [getDepartureStation](get-departure-station.md) | [JVM]<br>public final [RailwayStationDetails](../-railway-station-details/index.md)[getDepartureStation](get-departure-station.md)() |
| [getDepartureTime](get-departure-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getDepartureTime](get-departure-time.md)() |
| [getOperatingCompany](get-operating-company.md) | [JVM]<br>public final [RailSegmentsOperatingCompany](../-rail-segments-operating-company/index.md)[getOperatingCompany](get-operating-company.md)() |
| [getTransportationMethod](get-transportation-method.md) | [JVM]<br>public final [RailSegments.TransportationMethod](-transportation-method/index.md)[getTransportationMethod](get-transportation-method.md)() |

## Properties

| Name | Summary |
|---|---|
| [arrivalStation](index.md#-158783140%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [RailwayStationDetails](../-railway-station-details/index.md)[arrivalStation](index.md#-158783140%2FProperties%2F-1883119931) |
| [arrivalTime](index.md#1971009053%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[arrivalTime](index.md#1971009053%2FProperties%2F-1883119931) |
| [departureStation](index.md#1809939415%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [RailwayStationDetails](../-railway-station-details/index.md)[departureStation](index.md#1809939415%2FProperties%2F-1883119931) |
| [departureTime](index.md#-1718522494%2FProperties%2F-1883119931) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[departureTime](index.md#-1718522494%2FProperties%2F-1883119931) |
| [operatingCompany](index.md#-1155093253%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [RailSegmentsOperatingCompany](../-rail-segments-operating-company/index.md)[operatingCompany](index.md#-1155093253%2FProperties%2F-1883119931) |
| [transportationMethod](index.md#307364778%2FProperties%2F-1883119931) | [JVM]<br>private final [RailSegments.TransportationMethod](-transportation-method/index.md)[transportationMethod](index.md#307364778%2FProperties%2F-1883119931) |
