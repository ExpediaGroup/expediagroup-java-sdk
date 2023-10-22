//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Essential](index.md)

# Essential

public final class [Essential](index.md)

#### Parameters

JVM

| | |
|---|---|
| name | The name of the essential item. |
| instructions | The instructions for use of the essential item. |
| additionalInfo | A map of additional information that needs to be conveyed to customer. |
| images | An array of images needed for the essential item. |

## Constructors

| | |
|---|---|
| [Essential](-essential.md) | [JVM]<br>public [Essential](index.md)[Essential](-essential.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)name, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)instructions, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;additionalInfo, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Image1](../-image1/index.md)&gt;images) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [additionalInfo](index.md#-629558402%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[additionalInfo](index.md#-629558402%2FProperties%2F700308213) |
| [images](index.md#-1230559781%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Image1](../-image1/index.md)&gt;[images](index.md#-1230559781%2FProperties%2F700308213) |
| [instructions](index.md#822539982%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[instructions](index.md#822539982%2FProperties%2F700308213) |
| [name](index.md#257476264%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](index.md#257476264%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Essential.Builder](-builder/index.md)[builder](builder.md)() |
| [getAdditionalInfo](get-additional-info.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getAdditionalInfo](get-additional-info.md)() |
| [getImages](get-images.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Image1](../-image1/index.md)&gt;[getImages](get-images.md)() |
| [getInstructions](get-instructions.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getInstructions](get-instructions.md)() |
| [getName](get-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](get-name.md)() |
