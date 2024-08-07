//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[LocationOption](index.md)

# LocationOption

public final class [LocationOption](index.md)

Container for possible matches to your ambiguous `locationKeyword` query.

#### Parameters

JVM

| | |
|---|---|
| type | Type of the location. |
| regionId | RegionId the location resides in. |
| shortName | The name of the location which matches the location keyword. |
| airportCode | Indicates the nearest major airport to the location. |
| address | The address of the location. |
| country |
| geoLocation |

## Constructors

| | |
|---|---|
| [LocationOption](-location-option.md) | [JVM]<br>public [LocationOption](index.md)[LocationOption](-location-option.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)type, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)regionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)shortName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)airportCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)address, [Country](../-country/index.md)country, [GeoLocation](../-geo-location/index.md)geoLocation) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [address](index.md#1388950202%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[address](index.md#1388950202%2FProperties%2F699445674) |
| [airportCode](index.md#1373807958%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[airportCode](index.md#1373807958%2FProperties%2F699445674) |
| [country](index.md#-1654066856%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Country](../-country/index.md)[country](index.md#-1654066856%2FProperties%2F699445674) |
| [geoLocation](index.md#-1974142904%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [GeoLocation](../-geo-location/index.md)[geoLocation](index.md#-1974142904%2FProperties%2F699445674) |
| [regionId](index.md#-436928227%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[regionId](index.md#-436928227%2FProperties%2F699445674) |
| [shortName](index.md#1095815335%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[shortName](index.md#1095815335%2FProperties%2F699445674) |
| [type](index.md#1147467506%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[type](index.md#1147467506%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [LocationOption.Builder](-builder/index.md)[builder](builder.md)() |
| [getAddress](get-address.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAddress](get-address.md)() |
| [getAirportCode](get-airport-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAirportCode](get-airport-code.md)() |
| [getCountry](get-country.md) | [JVM]<br>public final [Country](../-country/index.md)[getCountry](get-country.md)() |
| [getGeoLocation](get-geo-location.md) | [JVM]<br>public final [GeoLocation](../-geo-location/index.md)[getGeoLocation](get-geo-location.md)() |
| [getRegionId](get-region-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRegionId](get-region-id.md)() |
| [getShortName](get-short-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getShortName](get-short-name.md)() |
| [getType](get-type.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getType](get-type.md)() |
