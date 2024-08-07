//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.operations](../../index.md)/[GetLodgingListingsOperationParams](../index.md)/[Builder](index.md)/[blockFullDepositRateplan](block-full-deposit-rateplan.md)

# blockFullDepositRateplan

[JVM]\

public final [GetLodgingListingsOperationParams.Builder](index.md)[blockFullDepositRateplan](block-full-deposit-rateplan.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)blockFullDepositRateplan)

#### Parameters

JVM

| | |
|---|---|
| blockFullDepositRateplan | Specifies whether to return `rateplan` with `FullDepositUponBooking` as true.  If `blockFullDepositRateplans` is true, the search results will not return `rateplan` with `FullDepositUponBooking` as true.  The default value is false, if query without this parameter or the value of this parameter is false, all available rateplan will be returned.  This parameter is ignored for dateless search. |
