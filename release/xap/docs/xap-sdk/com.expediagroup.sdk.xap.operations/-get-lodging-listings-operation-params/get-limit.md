//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingListingsOperationParams](index.md)/[getLimit](get-limit.md)

# getLimit

[JVM]\

public final [Long](https://docs.oracle.com/javase/8/docs/api/java/lang/Long.html)[getLimit](get-limit.md)()

The maximum number of hotels returned in the response. Must be an integer greater than 0.  If the value is greater than 1000, only the first 1000 hotels are returned.  Settings on `contentDetails` and `allRoomTypes` parameters may cause this value to be overridden and a lower number of hotels to be returned.  The `limit` parameter is intended to be used to control the response size, but partners should be careful about combining it with other filter parameters, as each parameter that you add will shrink the response, even to the point where you may even get a \&quot;no hotel found\&quot; error if none of the hotels in the base response meet the combined filter requirements.  Filters are cumulative in effect, and results must meet all filter requirements to be displayed.
