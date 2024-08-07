//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[Error](index.md)

# Error

public final class [Error](index.md)

Container for error list.

#### Parameters

JVM

| | |
|---|---|
| code | Error code describing the issue |
| description | A simple description of what the error is. |
| detailCode | Detailed error code describing the issue. |
| locationKeyword | The requested location that caused the error. |
| locationOptions | Container for possible matches to your ambiguous `locationKeyword` query. |

## Constructors

| | |
|---|---|
| [Error](-error.md) | [JVM]<br>public [Error](index.md)[Error](-error.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)code, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)description, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)detailCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)locationKeyword, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[LocationOption](../-location-option/index.md)&gt;locationOptions) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [code](index.md#-1821761995%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[code](index.md#-1821761995%2FProperties%2F699445674) |
| [description](index.md#1508042716%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[description](index.md#1508042716%2FProperties%2F699445674) |
| [detailCode](index.md#397286308%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[detailCode](index.md#397286308%2FProperties%2F699445674) |
| [locationKeyword](index.md#1234513124%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[locationKeyword](index.md#1234513124%2FProperties%2F699445674) |
| [locationOptions](index.md#1091602895%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[LocationOption](../-location-option/index.md)&gt;[locationOptions](index.md#1091602895%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Error.Builder](-builder/index.md)[builder](builder.md)() |
| [getCode](get-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCode](get-code.md)() |
| [getDescription](get-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDescription](get-description.md)() |
| [getDetailCode](get-detail-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDetailCode](get-detail-code.md)() |
| [getLocationKeyword](get-location-keyword.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLocationKeyword](get-location-keyword.md)() |
| [getLocationOptions](get-location-options.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[LocationOption](../-location-option/index.md)&gt;[getLocationOptions](get-location-options.md)() |
