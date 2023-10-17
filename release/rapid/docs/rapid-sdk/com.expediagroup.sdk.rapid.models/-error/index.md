//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Error](index.md)

# Error

public final class [Error](index.md)

The overall class of error that occured.

#### Parameters

JVM

| | |
|---|---|
| type | The error type. |
| message | A human readable message giving details about this error. |
| fields | Details about the specific fields that had an error. |
| errors | An array of all the actual errors that occured. |

## Constructors

| | |
|---|---|
| [Error](-error.md) | [JVM]<br>public [Error](index.md)[Error](-error.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)type, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)message, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Field](../-field/index.md)&gt;fields, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ErrorIndividual](../-error-individual/index.md)&gt;errors) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [errors](index.md#-262055294%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ErrorIndividual](../-error-individual/index.md)&gt;[errors](index.md#-262055294%2FProperties%2F700308213) |
| [fields](index.md#-246972684%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Field](../-field/index.md)&gt;[fields](index.md#-246972684%2FProperties%2F700308213) |
| [message](index.md#-1993319482%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[message](index.md#-1993319482%2FProperties%2F700308213) |
| [type](index.md#-125106797%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[type](index.md#-125106797%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Error.Builder](-builder/index.md)[builder](builder.md)() |
| [getErrors](get-errors.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[ErrorIndividual](../-error-individual/index.md)&gt;[getErrors](get-errors.md)() |
| [getFields](get-fields.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Field](../-field/index.md)&gt;[getFields](get-fields.md)() |
| [getMessage](get-message.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMessage](get-message.md)() |
| [getType](get-type.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getType](get-type.md)() |
