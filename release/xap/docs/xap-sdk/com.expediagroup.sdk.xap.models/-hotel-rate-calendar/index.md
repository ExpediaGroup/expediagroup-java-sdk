//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelRateCalendar](index.md)

# HotelRateCalendar

public final class [HotelRateCalendar](index.md)

Container for all hotel rate calendar data.

#### Parameters

JVM

| | |
|---|---|
| ecomHotelId | The unique, Expedia-specific hotel property identifier used to designate a single hotel. |
| rateCalendar | Container for all rate calendar data. |
| hcomHotelId | The unique, Hotels.com-specific hotel property identifier used to designate a single hotel.  This will be returned if searching via `hcomHotelId` in request or the request is coming from Hcom partner. |

## Constructors

| | |
|---|---|
| [HotelRateCalendar](-hotel-rate-calendar.md) | [JVM]<br>public [HotelRateCalendar](index.md)[HotelRateCalendar](-hotel-rate-calendar.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)ecomHotelId, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RateCalendar](../-rate-calendar/index.md)&gt;rateCalendar, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)hcomHotelId) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [ecomHotelId](index.md#-1658637669%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[ecomHotelId](index.md#-1658637669%2FProperties%2F699445674) |
| [hcomHotelId](index.md#-102704200%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[hcomHotelId](index.md#-102704200%2FProperties%2F699445674) |
| [rateCalendar](index.md#279040142%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RateCalendar](../-rate-calendar/index.md)&gt;[rateCalendar](index.md#279040142%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [HotelRateCalendar.Builder](-builder/index.md)[builder](builder.md)() |
| [getEcomHotelId](get-ecom-hotel-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEcomHotelId](get-ecom-hotel-id.md)() |
| [getHcomHotelId](get-hcom-hotel-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getHcomHotelId](get-hcom-hotel-id.md)() |
| [getRateCalendar](get-rate-calendar.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[RateCalendar](../-rate-calendar/index.md)&gt;[getRateCalendar](get-rate-calendar.md)() |
