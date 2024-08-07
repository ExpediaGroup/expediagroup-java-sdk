//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RateCalendarResponse](index.md)/[RateCalendarResponse](-rate-calendar-response.md)

# RateCalendarResponse

[JVM]\

public [RateCalendarResponse](index.md)[RateCalendarResponse](-rate-calendar-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)transactionId, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Warning](../-warning/index.md)&gt;warnings, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelRateCalendar](../-hotel-rate-calendar/index.md)&gt;rateCalendars)

#### Parameters

JVM

| | |
|---|---|
| transactionId | Unique identifier for the transaction. |
| warnings | There were some errors or events during the transaction, but the API has still returned a response.  Container for all warnings. |
| rateCalendars | Container for all hotel rate calendar data. |
