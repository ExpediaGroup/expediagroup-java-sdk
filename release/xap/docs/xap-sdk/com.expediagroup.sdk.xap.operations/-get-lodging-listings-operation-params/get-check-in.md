//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingListingsOperationParams](index.md)/[getCheckIn](get-check-in.md)

# getCheckIn

[JVM]\

public final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[getCheckIn](get-check-in.md)()

Check-in date for hotel stay in an ISO 8601 Date format YYYY-MM-DD.  This parameter should be used in combination with the `checkOut` parameter.  If `checkIn` and `checkOut` are not included, a dateless search will be conducted which returns a `Featured Offer` for each of the hotels found.  If one of `checkIn` and `checkOut` is not included, an error will be returned.  The maximum advanced search window is 500 days in the future, and the maximum length of stay is 28.
