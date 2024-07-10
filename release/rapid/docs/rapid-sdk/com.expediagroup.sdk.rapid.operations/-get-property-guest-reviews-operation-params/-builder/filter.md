//[rapid-sdk](../../../../index.md)/[com.expediagroup.sdk.rapid.operations](../../index.md)/[GetPropertyGuestReviewsOperationParams](../index.md)/[Builder](index.md)/[filter](filter.md)

# filter

[JVM]\

public final [GetPropertyGuestReviewsOperationParams.Builder](index.md)[filter](filter.md)([List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;filter)

#### Parameters

JVM

| | |
|---|---|
| filter | Single filter value. Send multiple instances of this parameter to request multiple filters. * `language` - Filters reviews to only those that match the specified `language` parameter value. Without   this filter, the matching language will be preferred, but other language results can be returned.   Specifying this filter could produce an error when there are no matching results. |
