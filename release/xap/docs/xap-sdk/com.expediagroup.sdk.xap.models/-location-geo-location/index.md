//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[LocationGeoLocation](index.md)

# LocationGeoLocation

public final class [LocationGeoLocation](index.md)

#### Parameters

JVM

| | |
|---|---|
| latitude | The geographic coordinates of the hotel property, based on a horizontal angular measurement relative to The Equator.  North latitude will be represented by a positive value.  South latitude will be represented by a negative value. |
| longitude | The geographic coordinates of the hotel property, based on a vertical angular measurement relative to the universal Prime Meridian (Royal Observatory, Greenwich).  East longitude will be represented by a positive value.  West longitude will be represented by a negative value. |
| obfuscated | Indicates whether the displayed Latitude/Longitude information is obfuscated.  Note: Exact Lat/Long values for Vacation Rental properties will not be shown in either XAPv3 Search or Details responses to respect the security of the homeowner. Instead an 'obfuscated' Lat/Long value will be returned that will indicate the general area within which the property is located, but not the exact location of the property itself. |

## Constructors

| | |
|---|---|
| [LocationGeoLocation](-location-geo-location.md) | [JVM]<br>public [LocationGeoLocation](index.md)[LocationGeoLocation](-location-geo-location.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)latitude, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)longitude, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)obfuscated) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [latitude](index.md#-298158081%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[latitude](index.md#-298158081%2FProperties%2F699445674) |
| [longitude](index.md#926647168%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[longitude](index.md#926647168%2FProperties%2F699445674) |
| [obfuscated](index.md#672802087%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[obfuscated](index.md#672802087%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [LocationGeoLocation.Builder](-builder/index.md)[builder](builder.md)() |
| [getLatitude](get-latitude.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLatitude](get-latitude.md)() |
| [getLongitude](get-longitude.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLongitude](get-longitude.md)() |
| [getObfuscated](get-obfuscated.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getObfuscated](get-obfuscated.md)() |
