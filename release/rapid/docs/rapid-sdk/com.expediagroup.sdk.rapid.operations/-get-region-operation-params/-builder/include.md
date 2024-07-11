//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[GetRegionOperationParams](../index.md)/[Builder](index.md)/[include](include.md)

# include

[JVM]\

public final [GetRegionOperationParams.Builder](index.md)[include](include.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;include)

#### Parameters

JVM

| | |
|---|---|
| include | Options for which content to return in the response. This parameter can be supplied multiple times with different values. The value must be lower case.   * details - Include the metadata, coordinates and full hierarchy of the region.   * property_ids - Include the list of property IDs within the bounding polygon of the region.   * property_ids_expanded - Include the list of property IDs within the bounding polygon of the region and property IDs from the surrounding area if minimal properties are within the region. |
