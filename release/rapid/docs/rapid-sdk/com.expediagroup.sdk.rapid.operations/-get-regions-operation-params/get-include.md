//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[GetRegionsOperationParams](index.md)/[getInclude](get-include.md)

# getInclude

[JVM]\

public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getInclude](get-include.md)()

Options for which content to return in the response. This parameter can be supplied multiple times with different values. The standard and details options cannot be requested together. The value must be lower case.   * standard - Include the metadata and basic hierarchy of each region.   * details - Include the metadata, coordinates and full hierarchy of each region.   * property_ids - Include the list of property IDs within the bounding polygon of each region.   * property_ids_expanded - Include the list of property IDs within the bounding polygon of each region and property IDs from the surrounding area if minimal properties are within the region.
