//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[HotelLinks](index.md)

# HotelLinks

public final class [HotelLinks](index.md)

Container for list of **HATEOAS** links to Expedia website to complete booking.  This links section will only return a deeplink to the Website Search Results page by default.  If you have selected AD deeplinks they will only <u>appear</u> within the `RoomTypes` section of the response, as the Lodging Details API returns details at the room offer level, and not at the property level.

#### Parameters

JVM

| |
|---|
| webSearchResult |
| apiRateCalendar |

## Constructors

| | |
|---|---|
| [HotelLinks](-hotel-links.md) | [JVM]<br>public [HotelLinks](index.md)[HotelLinks](-hotel-links.md)([HotelLinksWebSearchResult](../-hotel-links-web-search-result/index.md)webSearchResult, [HotelLinksApiRateCalendar](../-hotel-links-api-rate-calendar/index.md)apiRateCalendar) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [apiRateCalendar](index.md#730638651%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [HotelLinksApiRateCalendar](../-hotel-links-api-rate-calendar/index.md)[apiRateCalendar](index.md#730638651%2FProperties%2F699445674) |
| [webSearchResult](index.md#1413619322%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [HotelLinksWebSearchResult](../-hotel-links-web-search-result/index.md)[webSearchResult](index.md#1413619322%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [HotelLinks.Builder](-builder/index.md)[builder](builder.md)() |
| [getApiRateCalendar](get-api-rate-calendar.md) | [JVM]<br>public final [HotelLinksApiRateCalendar](../-hotel-links-api-rate-calendar/index.md)[getApiRateCalendar](get-api-rate-calendar.md)() |
| [getWebSearchResult](get-web-search-result.md) | [JVM]<br>public final [HotelLinksWebSearchResult](../-hotel-links-web-search-result/index.md)[getWebSearchResult](get-web-search-result.md)() |
