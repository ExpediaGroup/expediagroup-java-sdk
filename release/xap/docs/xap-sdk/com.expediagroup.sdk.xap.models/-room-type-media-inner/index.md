//[xap-sdk](../../../index.md)/[com.expediagroup.sdk.xap.models](../index.md)/[RoomTypeMediaInner](index.md)

# RoomTypeMediaInner

public final class [RoomTypeMediaInner](index.md)

#### Parameters

JVM

| | |
|---|---|
| type | Supported type of media.  1=Image.  Only 1 is supported now. |
| propertySize | Image size. You can find a link to the complete list of Supported Images Sizes in [Lodging Image Captions, IDs, and Sizes](https://developers.expediagroup.com/xap/products/xap/lodging/references/image-captions-ids-and-sizes). |
| url | Image URL |
| title | Image title |

## Constructors

| | |
|---|---|
| [RoomTypeMediaInner](-room-type-media-inner.md) | [JVM]<br>public [RoomTypeMediaInner](index.md)[RoomTypeMediaInner](-room-type-media-inner.md)([RoomTypeMediaInner.Type](-type/index.md)type, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertySize, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)url, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)title) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RoomTypeMediaInner.Type](-type/index.md)&gt;<br>Supported type of media.  1=Image.  Only 1 is supported now. Values: _1 |

## Properties

| Name | Summary |
|---|---|
| [propertySize](index.md#-406823853%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[propertySize](index.md#-406823853%2FProperties%2F699445674) |
| [title](index.md#1825237657%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[title](index.md#1825237657%2FProperties%2F699445674) |
| [type](index.md#1442749711%2FProperties%2F699445674) | [JVM]<br>private final [RoomTypeMediaInner.Type](-type/index.md)[type](index.md#1442749711%2FProperties%2F699445674) |
| [url](index.md#1212750946%2FProperties%2F699445674) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[url](index.md#1212750946%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomTypeMediaInner.Builder](-builder/index.md)[builder](builder.md)() |
| [getPropertySize](get-property-size.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPropertySize](get-property-size.md)() |
| [getTitle](get-title.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTitle](get-title.md)() |
| [getType](get-type.md) | [JVM]<br>public final [RoomTypeMediaInner.Type](-type/index.md)[getType](get-type.md)() |
| [getUrl](get-url.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getUrl](get-url.md)() |
