//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[GetRegionsOperationParams](index.md)/[getArea](get-area.md)

# getArea

[JVM]\

public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getArea](get-area.md)()

Filter the results to regions that intersect with a specified area.<br><br> The area may be defined in one of two ways:   * radius,region_id   * radius,latitude,longitude  Radius combined with region id would search an area that extends the number of kilometers out from the boundaries of the region in all directions.<br> Radius combined with a single point, specified by a latitude, longitude pair would search an area in a circle with the specified radius and the point as the center.<br> Radius should be specified in non-negative whole kilometers, decimals will return an error. A radius of 0 is allowed.<br> When specifying the area parameter, there will be a limit of 100 results, which can be narrowed further by the limit parameter.<br> Due to the number of results, unless `point_of_interest` is specified as the only type, regions of type `point_of_interest` will not be included in a request that filters to an area.<br><br> An example use case would be searching for the closest 3 airports within 50 kilometers of a specified point.<br>`&type=airport&limit=3&area=50,37.227924,-93.310036`
