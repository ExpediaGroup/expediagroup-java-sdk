//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Region](index.md)/[Region](-region.md)

# Region

[JVM]\

public [Region](index.md)[Region](-region.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)type, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)nameFull, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)descriptor, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)iataAirportCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)iataAirportMetroCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countryCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countrySubdivisionCode, [CoordinatesRegion](../-coordinates-region/index.md)coordinates, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;associations, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Ancestors](../-ancestors/index.md)&gt;ancestors, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;descendants, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;propertyIds, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;propertyIdsExpanded, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;categories, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;tags)

#### Parameters

JVM

| | |
|---|---|
| id | Region Id. |
| type | Region type. |
| name | Region name. |
| nameFull | Full region name. |
| descriptor | Specific information about the region e.g. whether it covers surrounding areas for a city. Only present when relevant for a region. See our [region descriptors reference](https://developers.expediagroup.com/docs/rapid/lodging/geography/geography-reference-lists) for current known descriptor values. |
| iataAirportCode | 3-character IATA airport code. |
| iataAirportMetroCode | 3-character IATA airport metropolitan code of the metropolitan airport area. |
| countryCode | Region country code (ISO 3166-1 alpha-2). |
| countrySubdivisionCode | Region country subdivision code (ISO 3166-2). |
| coordinates |
| associations | A map of region types to a sorted array of region ids with a touristic association to the region. |
| ancestors | An array of the region's ancestors. |
| descendants | A map of region types to an array of region ids. The region ids are direct descendants of the region. |
| propertyIds | An array of associated property ids for the region. |
| propertyIdsExpanded | An array of associated property ids within an expanded radius for the region. |
| categories | A list of regional categories. |
| tags | A list of regional tags. |
