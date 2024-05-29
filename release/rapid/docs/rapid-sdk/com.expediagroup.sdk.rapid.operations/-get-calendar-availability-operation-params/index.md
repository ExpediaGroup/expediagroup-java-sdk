//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[GetCalendarAvailabilityOperationParams](index.md)

# GetCalendarAvailabilityOperationParams

[JVM]\
public final class [GetCalendarAvailabilityOperationParams](index.md) implements OperationParams

## Constructors

| | |
|---|---|
| [GetCalendarAvailabilityOperationParams](-get-calendar-availability-operation-params.md) | [JVM]<br>public [GetCalendarAvailabilityOperationParams](index.md)[GetCalendarAvailabilityOperationParams](-get-calendar-availability-operation-params.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;propertyId, [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)startDate, [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)endDate) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [endDate](index.md#-1029292386%2FProperties%2F700308213) | [JVM]<br>private final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[endDate](index.md#-1029292386%2FProperties%2F700308213)<br>The last day of availability information to be returned, in ISO 8601 format (YYYY-MM-DD). This must be 365 days or less from the start_date. |
| [propertyId](index.md#-1093184061%2FProperties%2F700308213) | [JVM]<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[propertyId](index.md#-1093184061%2FProperties%2F700308213)<br>The ID of the property you want to search for. You can provide 1 to 250 property_id parameters. |
| [startDate](index.md#2072285687%2FProperties%2F700308213) | [JVM]<br>private final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[startDate](index.md#2072285687%2FProperties%2F700308213)<br>The first day of availability information to be returned, in ISO 8601 format (YYYY-MM-DD), up to 500 days in the future from the current date. |
| [test](index.md#1307979201%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[test](index.md#1307979201%2FProperties%2F700308213)<br>Shop calls have a test header that can be used to return set responses with the following keywords:<br> * `standard` * `service_unavailable` * `unknown_internal_error` |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [GetCalendarAvailabilityOperationParams.Builder](-builder/index.md)[builder](builder.md)() |
| [getEndDate](get-end-date.md) | [JVM]<br>public final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[getEndDate](get-end-date.md)()<br>The last day of availability information to be returned, in ISO 8601 format (YYYY-MM-DD). This must be 365 days or less from the start_date. |
| [getHeaders](get-headers.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getHeaders](get-headers.md)() |
| [getPropertyId](get-property-id.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getPropertyId](get-property-id.md)()<br>The ID of the property you want to search for. You can provide 1 to 250 property_id parameters. |
| [getQueryParams](get-query-params.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Iterable](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getQueryParams](get-query-params.md)() |
| [getStartDate](get-start-date.md) | [JVM]<br>public final [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)[getStartDate](get-start-date.md)()<br>The first day of availability information to be returned, in ISO 8601 format (YYYY-MM-DD), up to 500 days in the future from the current date. |
| [getTest](get-test.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTest](get-test.md)()<br>Shop calls have a test header that can be used to return set responses with the following keywords:<br> * `standard` * `service_unavailable` * `unknown_internal_error` |
