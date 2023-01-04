
# ExtendedError

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**java.net.URI**](java.net.URI.md) | A URI reference, compliant with the standard EG error type format, which identifies the error type. It provides a machine-readable identifier for the error type. The error type will be aligned with the HTTP status code of the response. The URI can either be absolute or relative to the API&#39;s base URI. When dereferenced, it can also provide human-readable documentation for the error type.  | 
**detail** | **kotlin.String** | A human-readable explanation of the error, specific to this error occurrence. | 
**causes** | [**kotlin.collections.List&lt;ErrorCause&gt;**](ErrorCause.md) | An array of cause objects, that identify the specific causes of the error. |  [optional]



