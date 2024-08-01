//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.operations](../../index.md)/[GetLodgingListingsOperationParams](../index.md)/[Builder](index.md)/[excludedPropertyTypeIds](excluded-property-type-ids.md)

# excludedPropertyTypeIds

[JVM]\

public final [GetLodgingListingsOperationParams.Builder](index.md)[excludedPropertyTypeIds](excluded-property-type-ids.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)excludedPropertyTypeIds)

#### Parameters

JVM

| | |
|---|---|
| excludedPropertyTypeIds | Return all hotels **except** those whose `PropertyType` ID is in the `excludedPropertyTypeIds` field.  If the API query includes the parameter `contentDetail=lowest` the `PropertyType` parameter will not be returned in the response. Even in this case, the filtering is still being applied, even though there is no `PropertyType` parameter in the response with which to validate.  `includedPropertyTypeIds` and `excludedPropertyTypeIds` fields are mutually exclusive - which means that each query may contain **one** of the parameters, or **neither** of the parameters, but the query may not contain **both** of the parameters.  A complete list of supported Expedia Property Types can be found in [Lodging Property Types](https://developers.expediagroup.com/xap/products/xap/lodging/references/property-types). |
