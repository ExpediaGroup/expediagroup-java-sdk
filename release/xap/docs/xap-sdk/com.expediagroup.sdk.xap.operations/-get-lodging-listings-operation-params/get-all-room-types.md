//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingListingsOperationParams](index.md)/[getAllRoomTypes](get-all-room-types.md)

# getAllRoomTypes

[JVM]\

public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getAllRoomTypes](get-all-room-types.md)()

Returns all available rate plans for the selected hotels.  This parameter requires that a `checkIn` date and `checkOut` date be supplied, as the API cannot return additional room rates on a dateless search.  Including `allRoomTypes=true` in your query will automatically limit your response size to no more than 200 hotels.  Including `allRoomTypes=true` and `contentDetails=high` will limit your response size to no more than 5 hotels.
