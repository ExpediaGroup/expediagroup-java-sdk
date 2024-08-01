//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[LocationGeoLocationAllOf](index.md)/[LocationGeoLocationAllOf](-location-geo-location-all-of.md)

# LocationGeoLocationAllOf

[JVM]\

public [LocationGeoLocationAllOf](index.md)[LocationGeoLocationAllOf](-location-geo-location-all-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)latitude, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)longitude, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)obfuscated)

#### Parameters

JVM

| | |
|---|---|
| latitude | The geographic coordinates of the hotel property, based on a horizontal angular measurement relative to The Equator.  North latitude will be represented by a positive value.  South latitude will be represented by a negative value. |
| longitude | The geographic coordinates of the hotel property, based on a vertical angular measurement relative to the universal Prime Meridian (Royal Observatory, Greenwich).  East longitude will be represented by a positive value.  West longitude will be represented by a negative value. |
| obfuscated | Indicates whether the displayed Latitude/Longitude information is obfuscated.  Note: Exact Lat/Long values for Vacation Rental properties will not be shown in either XAPv3 Search or Details responses to respect the security of the homeowner. Instead an 'obfuscated' Lat/Long value will be returned that will indicate the general area within which the property is located, but not the exact location of the property itself. |
