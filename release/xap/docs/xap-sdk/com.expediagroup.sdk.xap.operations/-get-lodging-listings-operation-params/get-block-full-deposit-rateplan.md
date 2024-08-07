//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingListingsOperationParams](index.md)/[getBlockFullDepositRateplan](get-block-full-deposit-rateplan.md)

# getBlockFullDepositRateplan

[JVM]\

public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getBlockFullDepositRateplan](get-block-full-deposit-rateplan.md)()

Specifies whether to return `rateplan` with `FullDepositUponBooking` as true.  If `blockFullDepositRateplans` is true, the search results will not return `rateplan` with `FullDepositUponBooking` as true.  The default value is false, if query without this parameter or the value of this parameter is false, all available rateplan will be returned.  This parameter is ignored for dateless search.
