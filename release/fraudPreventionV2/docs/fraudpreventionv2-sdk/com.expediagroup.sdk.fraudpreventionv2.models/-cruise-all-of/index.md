//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[CruiseAllOf](index.md)

# CruiseAllOf

public final class [CruiseAllOf](index.md)

#### Parameters

JVM

| | |
|---|---|
| departureTime | Local date and time of departure from original departure location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| arrivalTime | Local date and time of arrival from original arrival location, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| embarkationPort | Location from where cruise will depart. |
| disembarkationPort | The cruise's final destination. |
| shipName | Name of the cruise ship. |

## Constructors

| | |
|---|---|
| [CruiseAllOf](-cruise-all-of.md) | [JVM]<br>public [CruiseAllOf](index.md)[CruiseAllOf](-cruise-all-of.md)([OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)departureTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)arrivalTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)embarkationPort, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)disembarkationPort, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)shipName) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [arrivalTime](index.md#-215276800%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[arrivalTime](index.md#-215276800%2FProperties%2F-173342751) |
| [departureTime](index.md#1794747813%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[departureTime](index.md#1794747813%2FProperties%2F-173342751) |
| [disembarkationPort](index.md#236984908%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[disembarkationPort](index.md#236984908%2FProperties%2F-173342751) |
| [embarkationPort](index.md#-30190288%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[embarkationPort](index.md#-30190288%2FProperties%2F-173342751) |
| [shipName](index.md#-1640856467%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[shipName](index.md#-1640856467%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CruiseAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getArrivalTime](get-arrival-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getArrivalTime](get-arrival-time.md)() |
| [getDepartureTime](get-departure-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getDepartureTime](get-departure-time.md)() |
| [getDisembarkationPort](get-disembarkation-port.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDisembarkationPort](get-disembarkation-port.md)() |
| [getEmbarkationPort](get-embarkation-port.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEmbarkationPort](get-embarkation-port.md)() |
| [getShipName](get-ship-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getShipName](get-ship-name.md)() |
