//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PropertiesGeoJsonRequest](index.md)/[PropertiesGeoJsonRequest](-properties-geo-json-request.md)

# PropertiesGeoJsonRequest

[JVM]\

public [PropertiesGeoJsonRequest](index.md)[PropertiesGeoJsonRequest](-properties-geo-json-request.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)type, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)&gt;&gt;&gt;coordinates)

#### Parameters

JVM

| | |
|---|---|
| type | The geometry type. The only supported type is `Polygon` |
| coordinates | An array of linear ring coordinate arrays that combine to make up a single [Polygon](https://www.rfc-editor.org/rfc/rfc7946#section-3.1.6) in geojson format. If there is more than one linear ring at this level, the first is the outer boundary and the remaining linear rings are interior rings or holes. |
