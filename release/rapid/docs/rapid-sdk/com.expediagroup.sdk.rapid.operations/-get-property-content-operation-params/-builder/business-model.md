//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[GetPropertyContentOperationParams](../index.md)/[Builder](index.md)/[businessModel](business-model.md)

# businessModel

[JVM]\

public final [GetPropertyContentOperationParams.Builder](index.md)[businessModel](business-model.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;businessModel)

#### Parameters

JVM

| | |
|---|---|
| businessModel | Search for properties with the requested business model enabled. This parameter can be supplied multiple times with different values, which will return all properties that match any of the requested business models. The value must be lower case.   * `expedia_collect` - Return only properties where the payment is collected by Expedia.   * `property_collect` - Return only properties where the payment is collected at the property. |
