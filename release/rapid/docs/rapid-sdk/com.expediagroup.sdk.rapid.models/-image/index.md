//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Image](index.md)

# Image

public final class [Image](index.md)

An individual image. See our [image categories reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known caption and category values.

#### Parameters

JVM

| | |
|---|---|
| heroImage | Whether this image is a hero image or not. |
| category | The category of the image. |
| caption | The image caption. |
| links | Contains urls for all of the image sizes available. Sizes may include: 70 px, 200px, 350 px, and 1,000 px |

## Constructors

| | |
|---|---|
| [Image](-image.md) | [JVM]<br>public [Image](index.md)[Image](-image.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)heroImage, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)category, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)caption, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Link](../-link/index.md)&gt;links) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [caption](index.md#-2045318700%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[caption](index.md#-2045318700%2FProperties%2F700308213) |
| [category](index.md#-2124220702%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[category](index.md#-2124220702%2FProperties%2F700308213) |
| [heroImage](index.md#1807288153%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[heroImage](index.md#1807288153%2FProperties%2F700308213) |
| [links](index.md#948273825%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Link](../-link/index.md)&gt;[links](index.md#948273825%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Image.Builder](-builder/index.md)[builder](builder.md)() |
| [getCaption](get-caption.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCaption](get-caption.md)() |
| [getCategory](get-category.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getCategory](get-category.md)() |
| [getHeroImage](get-hero-image.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getHeroImage](get-hero-image.md)() |
| [getLinks](get-links.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Link](../-link/index.md)&gt;[getLinks](get-links.md)() |
