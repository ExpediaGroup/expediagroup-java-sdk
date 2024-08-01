//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingListingsOperationParams](index.md)/[getRadius](get-radius.md)

# getRadius

[JVM]\

public final [Long](https://docs.oracle.com/javase/8/docs/api/java/lang/Long.html)[getRadius](get-radius.md)()

The size of the search radius around a specified point when searching by `geoLocation`, `locationKeyword`, or `regionids`.  `radius` is optional and the default value is 25 km for `geoLocation` and `locationKeyword` if not specified. `radius` must be less than 200 km or 124 mi.  This parameter should be used in combination with the `unit` and `geoLocation`, `locationKeyword`, or `regionids` parameters.\&quot;
