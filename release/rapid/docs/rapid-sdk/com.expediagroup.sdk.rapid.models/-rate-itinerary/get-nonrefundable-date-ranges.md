//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RateItinerary](index.md)/[getNonrefundableDateRanges](get-nonrefundable-date-ranges.md)

# getNonrefundableDateRanges

[JVM]\

public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../-nonrefundable-date-range/index.md)&gt;[getNonrefundableDateRanges](get-nonrefundable-date-ranges.md)()

#### Parameters

JVM

| | |
|---|---|
| nonrefundableDateRanges | A list of date exceptions. Dates within these ranges provide no refund on cancellation, regardless of cancel penalty windows. Nonrefundable range begins at 00:00:00 on the start date, and ends at 23:59:59 on the end date, in the local time zone of the property. |
