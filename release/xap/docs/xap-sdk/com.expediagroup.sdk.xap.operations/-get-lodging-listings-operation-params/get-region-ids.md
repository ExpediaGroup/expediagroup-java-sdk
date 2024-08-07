//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingListingsOperationParams](index.md)/[getRegionIds](get-region-ids.md)

# getRegionIds

[JVM]\

public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRegionIds](get-region-ids.md)()

Comma-separated list of Expedia Region IDs. There can be no spaces between parameters. Search returns set of all hotels in the combined regions.  You may search using a string of 1 - 10 Region ID's. More than 10 Region ID's are not supported and will generate and error.  You can get the complete list of Expedia Region IDs from [Static Data Platform ALL_REGIONS file](https://developers.expediagroup.com/xap/products/xap/static-data-platform/download-url-api/download-url-api-v1).  This parameter could be used in combination with the `radius` and `unit` parameters above to define a circle around the `regionIds`. The default radius value is 0 if not specified.
