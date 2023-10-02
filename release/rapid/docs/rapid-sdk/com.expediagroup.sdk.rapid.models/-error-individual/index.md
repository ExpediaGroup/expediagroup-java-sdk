//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[ErrorIndividual](index.md)

# ErrorIndividual

public final class [ErrorIndividual](index.md)

An individual error.

#### Parameters

JVM

| | |
|---|---|
| type | The error type. |
| message | A human readable message giving details about this error. |
| fields | Details about the specific fields that had an error. |

## Constructors

| | |
|---|---|
| [ErrorIndividual](-error-individual.md) | [JVM]<br>public [ErrorIndividual](index.md)[ErrorIndividual](-error-individual.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)type, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)message, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Field](../-field/index.md)&gt;fields) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [fields](index.md#1151422189%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Field](../-field/index.md)&gt;[fields](index.md#1151422189%2FProperties%2F700308213) |
| [message](index.md#-1592751379%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[message](index.md#-1592751379%2FProperties%2F700308213) |
| [type](index.md#1641709516%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[type](index.md#1641709516%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [ErrorIndividual.Builder](-builder/index.md)[builder](builder.md)() |
| [getFields](get-fields.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Field](../-field/index.md)&gt;[getFields](get-fields.md)() |
| [getMessage](get-message.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMessage](get-message.md)() |
| [getType](get-type.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getType](get-type.md)() |
