//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RateCalendarResponse](index.md)

# RateCalendarResponse

public final class [RateCalendarResponse](index.md)

#### Parameters

JVM

| | |
|---|---|
| transactionId | Unique identifier for the transaction. |
| warnings | There were some errors or events during the transaction, but the API has still returned a response.  Container for all warnings. |
| rateCalendars | Container for all hotel rate calendar data. |

## Constructors

| | |
|---|---|
| [RateCalendarResponse](-rate-calendar-response.md) | [JVM]<br>public [RateCalendarResponse](index.md)[RateCalendarResponse](-rate-calendar-response.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)transactionId, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Warning](../-warning/index.md)&gt;warnings, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelRateCalendar](../-hotel-rate-calendar/index.md)&gt;rateCalendars) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [rateCalendars](index.md#717523044%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelRateCalendar](../-hotel-rate-calendar/index.md)&gt;[rateCalendars](index.md#717523044%2FProperties%2F699445674) |
| [transactionId](index.md#-765990848%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[transactionId](index.md#-765990848%2FProperties%2F699445674) |
| [warnings](index.md#1577877194%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Warning](../-warning/index.md)&gt;[warnings](index.md#1577877194%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RateCalendarResponse.Builder](-builder/index.md)[builder](builder.md)() |
| [getRateCalendars](get-rate-calendars.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[HotelRateCalendar](../-hotel-rate-calendar/index.md)&gt;[getRateCalendars](get-rate-calendars.md)() |
| [getTransactionId](get-transaction-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTransactionId](get-transaction-id.md)() |
| [getWarnings](get-warnings.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Warning](../-warning/index.md)&gt;[getWarnings](get-warnings.md)() |
