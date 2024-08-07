//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.operations](../../index.md)/[GetLodgingListingsOperationParams](../index.md)/[Builder](index.md)/[checkOut](check-out.md)

# checkOut

[JVM]\

public final [GetLodgingListingsOperationParams.Builder](index.md)[checkOut](check-out.md)([LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)checkOut)

#### Parameters

JVM

| | |
|---|---|
| checkOut | Checkout date for hotel stay in an ISO 8601 Date format YYYY-MM-DD.  This parameter should be used in combination with the `checkIn` parameter.  If `checkIn` and `checkOut` are not included, a dateless search will be conducted which returns a `Featured Offer` for each of the hotels found.  If one of `checkIn` and `checkOut` is not included, an error will be returned.  The maximum advanced search window is 500 days in the future, and the maximum length of stay is 28. |
