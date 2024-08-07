//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.operations](../../index.md)/[GetLodgingListingsOperationParams](../index.md)/[Builder](index.md)/[freeCancellation](free-cancellation.md)

# freeCancellation

[JVM]\

public final [GetLodgingListingsOperationParams.Builder](index.md)[freeCancellation](free-cancellation.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)freeCancellation)

#### Parameters

JVM

| | |
|---|---|
| freeCancellation | Specifies whether to return only free cancelable room rates in the search results.  If the value of this parameter is true, the search results will only return hotels that have free cancelable room rates during the requested dates.  If there are no hotels with free cancelable room rates in your search then an empty record set will be returned.  Default value is false, if query without this parameter or the value of this parameter is false, all available room rates will be returned.  This parameter is ignored for dateless searches. |
