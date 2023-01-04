
# ErrorCause

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**java.net.URI**](java.net.URI.md) | A URI reference, compliant with the standard EG error type format, which identifies the cause type. It provides a machine-readable identifier for the cause type. The cause type will be aligned with the error type. The URI can either be absolute or relative to the API&#39;s base URI. When dereferenced, it provides human-readable documentation for the cause type.  | 
**detail** | **kotlin.String** | A human-readable explanation of the cause, specific to this cause occurrence. | 
**location** | [**inline**](#Location) | The location of the element in the request that identifies this specific cause. When specified, the &#x60;name&#x60; will be specified and when applicable, the &#x60;value&#x60; as well. Can be one of: * &#x60;HEADER&#x60; - When an error has been identified in one of the request headers. * &#x60;PATH&#x60; - When an error has been identified in one of the path parameters. * &#x60;QUERY&#x60; - When an error has been identified in one of the query parameters. * &#x60;BODY&#x60; - When an error has been identified in the request body.  |  [optional]
**name** | **kotlin.String** | The name of the element for this cause. When specified, the &#x60;location&#x60; will be specified and when applicable, the &#x60;value&#x60; as well. This name is a function of the value of the &#x60;location&#x60; property:   * When the &#x60;location&#x60; is set to &#x60;HEADER&#x60;, this will be the name of the request header (e.g. &#x60;Content-Type&#x60;).   * When the &#x60;location&#x60; is set to &#x60;PATH&#x60;, this will be the name of the path parameter (e.g. in a path defined as &#x60;/users/{user_id}&#x60;, the value would be &#x60;user_id&#x60;).   * When the &#x60;location&#x60; is set to &#x60;QUERY&#x60;, this will be the name of the query string parameter (e.g. &#x60;offset&#x60;).   * When the &#x60;location&#x60; is set to &#x60;BODY&#x60;, this will one of the field names specified in the body of the request.     * For a top level field, it should only be set to the field name (e.g. &#x60;firstName&#x60;).     * For a field in a nested object, it may contain the path to reach the field (e.g. &#x60;address.city&#x60;).     * For a field in an object part of collection, it may contain the index in the collection (e.g. &#x60;permissions[0].name&#x60;).  |  [optional]
**&#x60;value&#x60;** | **kotlin.String** | A string representation of the erroneous value of the element identified in &#x60;name&#x60;, perceived to be the cause of the error. When specified, the &#x60;location&#x60; and &#x60;name&#x60; should be specified as well. This value may be omitted in cases where it cannot be provided (e.g. missing require field), or the erroneous value cannot be represented as a string.  |  [optional]


<a name="Location"></a>
## Enum: location
Name | Value
---- | -----
location | HEADER, PATH, QUERY, BODY



