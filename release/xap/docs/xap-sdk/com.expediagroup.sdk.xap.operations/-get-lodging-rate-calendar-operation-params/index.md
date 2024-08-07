//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.operations](../index.md)/[GetLodgingRateCalendarOperationParams](index.md)

# GetLodgingRateCalendarOperationParams

[JVM]\
public final class [GetLodgingRateCalendarOperationParams](index.md) implements OperationParams

## Constructors

| | |
|---|---|
| [GetLodgingRateCalendarOperationParams](-get-lodging-rate-calendar-operation-params.md) | [JVM]<br>public [GetLodgingRateCalendarOperationParams](index.md)[GetLodgingRateCalendarOperationParams](-get-lodging-rate-calendar-operation-params.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerTransactionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)ecomHotelId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)hcomHotelId, [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)startDate, [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)endDate, [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)lengthOfStay, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)currency) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [currency](index.md#13790196%2FProperties%2F699445674) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[currency](index.md#13790196%2FProperties%2F699445674)<br>The requested currency expressed according to ISO 4217. |
| [ecomHotelId](index.md#-1507308638%2FProperties%2F699445674) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[ecomHotelId](index.md#-1507308638%2FProperties%2F699445674)<br>The Expedia hotel ID for which the calendar is being requested.  **Note**: Either an Expedia Hotel ID or a Hotels.com Hotel ID must be included in the request. You may use one or the other, but not both. |
| [endDate](index.md#143561868%2FProperties%2F699445674) | [JVM]<br>private final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[endDate](index.md#143561868%2FProperties%2F699445674)<br>End date for check-in search range in an ISO 8601 Date format YYYY-MM-DD.  **Note**: The end date must be after the start date. The maximum supported search range is 180 days. |
| [hcomHotelId](index.md#48624831%2FProperties%2F699445674) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[hcomHotelId](index.md#48624831%2FProperties%2F699445674)<br>The Hotel.com hotel ID for which the calendar is being requested.  **Note**: Either an Expedia Hotel ID or a Hotels.com Hotel ID must be included in the request. You may use one or the other, but not both. |
| [lengthOfStay](index.md#-990369713%2FProperties%2F699445674) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[lengthOfStay](index.md#-990369713%2FProperties%2F699445674)<br>The length of stay to retrieve the lowest price for. |
| [partnerTransactionId](index.md#1014914900%2FProperties%2F699445674) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[partnerTransactionId](index.md#1014914900%2FProperties%2F699445674)<br>The `Partner-Transaction-ID` is a required API request header element that is <u>not</u> consumed by Expedia. It will be required in all XAP v3 API request headers and will be mirrored back to the partner in the corresponding API response header.  The `Partner-Transaction-ID` may be any alphanumeric string of the partner's choosing. |
| [startDate](index.md#-391175067%2FProperties%2F699445674) | [JVM]<br>private final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[startDate](index.md#-391175067%2FProperties%2F699445674)<br>Start date for check-in search range in an ISO 8601 Date format YYYY-MM-DD.  **Note**: The start date may not be in the past. |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [GetLodgingRateCalendarOperationParams.Builder](-builder/index.md)[builder](builder.md)() |
| [getCurrency](get-currency.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCurrency](get-currency.md)()<br>The requested currency expressed according to ISO 4217. |
| [getEcomHotelId](get-ecom-hotel-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEcomHotelId](get-ecom-hotel-id.md)()<br>The Expedia hotel ID for which the calendar is being requested.  **Note**: Either an Expedia Hotel ID or a Hotels.com Hotel ID must be included in the request. You may use one or the other, but not both. |
| [getEndDate](get-end-date.md) | [JVM]<br>public final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[getEndDate](get-end-date.md)()<br>End date for check-in search range in an ISO 8601 Date format YYYY-MM-DD.  **Note**: The end date must be after the start date. The maximum supported search range is 180 days. |
| [getHcomHotelId](get-hcom-hotel-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getHcomHotelId](get-hcom-hotel-id.md)()<br>The Hotel.com hotel ID for which the calendar is being requested.  **Note**: Either an Expedia Hotel ID or a Hotels.com Hotel ID must be included in the request. You may use one or the other, but not both. |
| [getHeaders](get-headers.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getHeaders](get-headers.md)() |
| [getLengthOfStay](get-length-of-stay.md) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getLengthOfStay](get-length-of-stay.md)()<br>The length of stay to retrieve the lowest price for. |
| [getPartnerTransactionId](get-partner-transaction-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPartnerTransactionId](get-partner-transaction-id.md)()<br>The `Partner-Transaction-ID` is a required API request header element that is <u>not</u> consumed by Expedia. It will be required in all XAP v3 API request headers and will be mirrored back to the partner in the corresponding API response header.  The `Partner-Transaction-ID` may be any alphanumeric string of the partner's choosing. |
| [getPathParams](get-path-params.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getPathParams](get-path-params.md)() |
| [getQueryParams](get-query-params.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Iterable](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getQueryParams](get-query-params.md)() |
| [getStartDate](get-start-date.md) | [JVM]<br>public final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[getStartDate](get-start-date.md)()<br>Start date for check-in search range in an ISO 8601 Date format YYYY-MM-DD.  **Note**: The start date may not be in the past. |
