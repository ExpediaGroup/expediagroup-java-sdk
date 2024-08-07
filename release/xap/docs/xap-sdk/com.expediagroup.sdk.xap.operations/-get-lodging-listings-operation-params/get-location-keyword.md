//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingListingsOperationParams](index.md)/[getLocationKeyword](get-location-keyword.md)

# getLocationKeyword

[JVM]\

public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLocationKeyword](get-location-keyword.md)()

A keyword search for a location. The keyword can be a city, address, airport or a landmark.  This parameter should be used in combination with the `radius` and `unit` parameters above to define a circle around the landmark.  The default radius value is 25 if not specified.  Combined search is not supported, if more than one search method is included in the request, an error will be returned.
