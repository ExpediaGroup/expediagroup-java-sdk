//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Rate](index.md)/[getNonrefundableDateRanges](get-nonrefundable-date-ranges.md)

# getNonrefundableDateRanges

[JVM]\

public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[NonrefundableDateRange](../-nonrefundable-date-range/index.md)&gt;[getNonrefundableDateRanges](get-nonrefundable-date-ranges.md)()

#### Parameters

JVM

| | |
|---|---|
| nonrefundableDateRanges | An array of stay date ranges within this check-in / check-out range that are not refundable. Stay dates within these ranges provide no refund on cancellation, regardless of cancel penalty windows. The stay dates are determined by the would be check-in of that night. With a check-in date of 2023-09-01, and a check-out date of 2023-09-06, this would be a 5 night stay. A `nonrefundable_date_range` with start: 2023-09-02 and end: 2023-09-03 would mean 2 of the nights are nonrefundable. The 1st night is refundable, the 2nd and 3rd nights are nonrefundable, and the 4th and 5th nights are refundable, subject to `cancel_penalties` restrictions. |
