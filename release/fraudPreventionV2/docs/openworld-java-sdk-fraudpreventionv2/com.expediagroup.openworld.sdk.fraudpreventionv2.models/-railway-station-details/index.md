//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[RailwayStationDetails](index.md)

# RailwayStationDetails

public final class [RailwayStationDetails](index.md)

#### Parameters

JVM

| | |
|---|---|
| name | The popularly known name or title by which the railway station is identified. |
| stationCode | The unique identifier or code assigned to an individual rail station or a pseudo-station representing all the stations within a specific city, from which rail travel originates. |
| address |
| type | This attribute provides information about the specific classification assigned to the rail station. It helps differentiate between different types of stations, such as major stations (STATION) or stations located within a city (city). |
| timezone | The timezone associated with the location of the station, specifying the local time offset from Coordinated Universal Time (UTC). |

## Constructors

| | |
|---|---|
| [RailwayStationDetails](-railway-station-details.md) | [JVM]<br>public [RailwayStationDetails](index.md)[RailwayStationDetails](-railway-station-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)stationCode, [Address](../-address/index.md)address, [RailwayStationDetails.Type](-type/index.md)type, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)timezone) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RailwayStationDetails.Type](-type/index.md)&gt;<br>This attribute provides information about the specific classification assigned to the rail station. It helps differentiate between different types of stations, such as major stations (STATION) or stations located within a city (city). Values: STATION,CITY |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RailwayStationDetails.Builder](-builder/index.md)[builder](builder.md)() |
| [getAddress](get-address.md) | [JVM]<br>public final [Address](../-address/index.md)[getAddress](get-address.md)() |
| [getName](get-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
| [getStationCode](get-station-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getStationCode](get-station-code.md)() |
| [getTimezone](get-timezone.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTimezone](get-timezone.md)() |
| [getType](get-type.md) | [JVM]<br>public final [RailwayStationDetails.Type](-type/index.md)[getType](get-type.md)() |

## Properties

| Name | Summary |
|---|---|
| [address](index.md#325046308%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Address](../-address/index.md)[address](index.md#325046308%2FProperties%2F-1883119931) |
| [name](index.md#1994695575%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#1994695575%2FProperties%2F-1883119931) |
| [stationCode](index.md#-2112537097%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[stationCode](index.md#-2112537097%2FProperties%2F-1883119931) |
| [timezone](index.md#-786062487%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[timezone](index.md#-786062487%2FProperties%2F-1883119931) |
| [type](index.md#-1370496568%2FProperties%2F-1883119931) | [JVM]<br>private final [RailwayStationDetails.Type](-type/index.md)[type](index.md#-1370496568%2FProperties%2F-1883119931) |
