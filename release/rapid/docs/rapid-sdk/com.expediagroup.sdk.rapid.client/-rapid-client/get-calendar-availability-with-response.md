//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[getCalendarAvailabilityWithResponse](get-calendar-availability-with-response.md)

# getCalendarAvailabilityWithResponse

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Use execute method instead&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;execute(operation: GetCalendarAvailabilityOperation)&quot;))

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PropertyCalendarAvailability](../../com.expediagroup.sdk.rapid.models/-property-calendar-availability/index.md)&gt;&gt;[~~getCalendarAvailabilityWithResponse~~](get-calendar-availability-with-response.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;propertyId, [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)startDate, [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)endDate, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)test)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

@[Deprecated](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-deprecated/index.html)(message = &quot;Use execute method instead&quot;, replaceWith = @[ReplaceWith](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-replace-with/index.html)(imports = {}, expression = &quot;execute(operation: GetCalendarAvailabilityOperation)&quot;))

public final Response&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PropertyCalendarAvailability](../../com.expediagroup.sdk.rapid.models/-property-calendar-availability/index.md)&gt;&gt;[~~getCalendarAvailabilityWithResponse~~](get-calendar-availability-with-response.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;propertyId, [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)startDate, [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)endDate)

---

### Deprecated

Use execute method instead

#### Replace with

```kotlin
execute(operation: GetCalendarAvailabilityOperation)
```
---

Get a calendar of availability dates for properties. This is currently a Vrbo property only feature. Returns availability information for the specified properties (maximum of 25 properties per request).  The response includes per day information about the property's availability, information about if check-in or check-out is available for the day,   and information regarding the stay constraints.

#### Return

a Response object with a body of type kotlin.collections.List<PropertyCalendarAvailability>

#### Parameters

JVM

| | |
|---|---|
| propertyId | The ID of the property you want to search for. You can provide 1 to 250 property_id parameters. |
| startDate | The first day of availability information to be returned, in ISO 8601 format (YYYY-MM-DD), up to 500 days in the future from the current date. |
| endDate | The last day of availability information to be returned, in ISO 8601 format (YYYY-MM-DD). This must be 365 days or less from the start_date. |
| test | Shop calls have a test header that can be used to return set responses with the following keywords:<br> * `standard` * `service_unavailable` * `unknown_internal_error`  (optional) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
