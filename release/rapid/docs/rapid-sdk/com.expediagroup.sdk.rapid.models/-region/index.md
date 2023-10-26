//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Region](index.md)

# Region

public final class [Region](index.md)

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

## Constructors

| | |
|---|---|
| [Region](-region.md) | [JVM]<br>public [Region](index.md)[Region](-region.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)type, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)nameFull, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)descriptor, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)iataAirportCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)iataAirportMetroCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countryCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countrySubdivisionCode, [CoordinatesRegion](../-coordinates-region/index.md)coordinates, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;associations, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Ancestors](../-ancestors/index.md)&gt;ancestors, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;descendants, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;propertyIds, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;propertyIdsExpanded, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;categories, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;tags) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [ancestors](index.md#334459919%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Ancestors](../-ancestors/index.md)&gt;[ancestors](index.md#334459919%2FProperties%2F700308213) |
| [associations](index.md#-1054765735%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[associations](index.md#-1054765735%2FProperties%2F700308213) |
| [categories](index.md#-1180631537%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[categories](index.md#-1180631537%2FProperties%2F700308213) |
| [coordinates](index.md#1084448500%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [CoordinatesRegion](../-coordinates-region/index.md)[coordinates](index.md#1084448500%2FProperties%2F700308213) |
| [countryCode](index.md#536602444%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[countryCode](index.md#536602444%2FProperties%2F700308213) |
| [countrySubdivisionCode](index.md#-2131480537%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[countrySubdivisionCode](index.md#-2131480537%2FProperties%2F700308213) |
| [descendants](index.md#-434279879%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[descendants](index.md#-434279879%2FProperties%2F700308213) |
| [descriptor](index.md#-1436416996%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[descriptor](index.md#-1436416996%2FProperties%2F700308213) |
| [iataAirportCode](index.md#108158044%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[iataAirportCode](index.md#108158044%2FProperties%2F700308213) |
| [iataAirportMetroCode](index.md#1207611755%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[iataAirportMetroCode](index.md#1207611755%2FProperties%2F700308213) |
| [id](index.md#-100429328%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#-100429328%2FProperties%2F700308213) |
| [name](index.md#-1122033920%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#-1122033920%2FProperties%2F700308213) |
| [nameFull](index.md#-606289487%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[nameFull](index.md#-606289487%2FProperties%2F700308213) |
| [propertyIds](index.md#-600870580%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[propertyIds](index.md#-600870580%2FProperties%2F700308213) |
| [propertyIdsExpanded](index.md#-2060462189%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[propertyIdsExpanded](index.md#-2060462189%2FProperties%2F700308213) |
| [tags](index.md#1996136754%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[tags](index.md#1996136754%2FProperties%2F700308213) |
| [type](index.md#-192258767%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[type](index.md#-192258767%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Region.Builder](-builder/index.md)[builder](builder.md)() |
| [getAncestors](get-ancestors.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Ancestors](../-ancestors/index.md)&gt;[getAncestors](get-ancestors.md)() |
| [getAssociations](get-associations.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getAssociations](get-associations.md)() |
| [getCategories](get-categories.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getCategories](get-categories.md)() |
| [getCoordinates](get-coordinates.md) | [JVM]<br>public final [CoordinatesRegion](../-coordinates-region/index.md)[getCoordinates](get-coordinates.md)() |
| [getCountryCode](get-country-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCountryCode](get-country-code.md)() |
| [getCountrySubdivisionCode](get-country-subdivision-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCountrySubdivisionCode](get-country-subdivision-code.md)() |
| [getDescendants](get-descendants.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getDescendants](get-descendants.md)() |
| [getDescriptor](get-descriptor.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDescriptor](get-descriptor.md)() |
| [getIataAirportCode](get-iata-airport-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getIataAirportCode](get-iata-airport-code.md)() |
| [getIataAirportMetroCode](get-iata-airport-metro-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getIataAirportMetroCode](get-iata-airport-metro-code.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getName](get-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
| [getNameFull](get-name-full.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getNameFull](get-name-full.md)() |
| [getPropertyIds](get-property-ids.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getPropertyIds](get-property-ids.md)() |
| [getPropertyIdsExpanded](get-property-ids-expanded.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getPropertyIdsExpanded](get-property-ids-expanded.md)() |
| [getTags](get-tags.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getTags](get-tags.md)() |
| [getType](get-type.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getType](get-type.md)() |
