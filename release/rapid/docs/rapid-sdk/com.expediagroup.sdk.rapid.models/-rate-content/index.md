//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RateContent](index.md)

# RateContent

public final class [RateContent](index.md)

An individual rate.

#### Parameters

JVM

| | |
|---|---|
| id | Unique identifier for a rate. |
| amenities | This lists all of the Amenities available with a specific rate, including value adds, such as breakfast. See our [amenities reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known amenity ID and name values. |
| specialOfferDescription | A text description of any special offers for this rate. |

## Constructors

| | |
|---|---|
| [RateContent](-rate-content.md) | [JVM]<br>public [RateContent](index.md)[RateContent](-rate-content.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;amenities, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)specialOfferDescription) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [amenities](index.md#-1275649307%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;[amenities](index.md#-1275649307%2FProperties%2F700308213) |
| [id](index.md#957455235%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#957455235%2FProperties%2F700308213) |
| [specialOfferDescription](index.md#-902328029%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[specialOfferDescription](index.md#-902328029%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RateContent.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmenities](get-amenities.md) | [JVM]<br>public final [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Amenity](../-amenity/index.md)&gt;[getAmenities](get-amenities.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getSpecialOfferDescription](get-special-offer-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSpecialOfferDescription](get-special-offer-description.md)() |
