//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[RailSegments](index.md)/[RailSegments](-rail-segments.md)

# RailSegments

[JVM]\

public [RailSegments](index.md)[RailSegments](-rail-segments.md)([OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)departureTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)arrivalTime, [RailwayStationDetails](../-railway-station-details/index.md)departureStation, [RailwayStationDetails](../-railway-station-details/index.md)arrivalStation, [RailSegments.TransportationMethod](-transportation-method/index.md)transportationMethod, [RailSegmentsOperatingCompany](../-rail-segments-operating-company/index.md)operatingCompany)

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
