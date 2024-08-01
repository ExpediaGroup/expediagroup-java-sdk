//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RoomTypeLinks](index.md)

# RoomTypeLinks

public final class [RoomTypeLinks](index.md)

Container for list of HATEOAS links to either Expedia website or additional Expedia APIs to complete booking of the selected offer.  Which links are returned in this section are defined by the `links` parameter in the Search API query.  Available links are: - WebSearchResult (link to web search result page) - WebDetails (link to web infosite) - ApiDetails (link for details API)

#### Parameters

JVM

| |
|---|
| webSearchResult |
| webDetails |
| apiDetails |

## Constructors

| | |
|---|---|
| [RoomTypeLinks](-room-type-links.md) | [JVM]<br>public [RoomTypeLinks](index.md)[RoomTypeLinks](-room-type-links.md)([HotelLinksWebSearchResult](../-hotel-links-web-search-result/index.md)webSearchResult, [RoomTypeLinksWebDetails](../-room-type-links-web-details/index.md)webDetails, [RoomTypeLinksApiDetails](../-room-type-links-api-details/index.md)apiDetails) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [apiDetails](index.md#203825142%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RoomTypeLinksApiDetails](../-room-type-links-api-details/index.md)[apiDetails](index.md#203825142%2FProperties%2F699445674) |
| [webDetails](index.md#-779941584%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [RoomTypeLinksWebDetails](../-room-type-links-web-details/index.md)[webDetails](index.md#-779941584%2FProperties%2F699445674) |
| [webSearchResult](index.md#-670885085%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [HotelLinksWebSearchResult](../-hotel-links-web-search-result/index.md)[webSearchResult](index.md#-670885085%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomTypeLinks.Builder](-builder/index.md)[builder](builder.md)() |
| [getApiDetails](get-api-details.md) | [JVM]<br>public final [RoomTypeLinksApiDetails](../-room-type-links-api-details/index.md)[getApiDetails](get-api-details.md)() |
| [getWebDetails](get-web-details.md) | [JVM]<br>public final [RoomTypeLinksWebDetails](../-room-type-links-web-details/index.md)[getWebDetails](get-web-details.md)() |
| [getWebSearchResult](get-web-search-result.md) | [JVM]<br>public final [HotelLinksWebSearchResult](../-hotel-links-web-search-result/index.md)[getWebSearchResult](get-web-search-result.md)() |
