//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[EssentialInformation](index.md)

# EssentialInformation

public final class [EssentialInformation](index.md)

Essential information, including the supply contact information and any other essential information.

#### Parameters

JVM

| |
|---|
| contact |
| essentials |
| updateAvailableDate | The date and time when new essential information is available for retrieval, in extended ISO 8601 format, with ±hh:mm timezone offset. |

## Constructors

| | |
|---|---|
| [EssentialInformation](-essential-information.md) | [JVM]<br>public [EssentialInformation](index.md)[EssentialInformation](-essential-information.md)([SupplyContact](../-supply-contact/index.md)contact, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Essential](../-essential/index.md)&gt;essentials, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)updateAvailableDate) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [contact](index.md#-254582683%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [SupplyContact](../-supply-contact/index.md)[contact](index.md#-254582683%2FProperties%2F700308213) |
| [essentials](index.md#1446262448%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Essential](../-essential/index.md)&gt;[essentials](index.md#1446262448%2FProperties%2F700308213) |
| [updateAvailableDate](index.md#2079510647%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[updateAvailableDate](index.md#2079510647%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [EssentialInformation.Builder](-builder/index.md)[builder](builder.md)() |
| [getContact](get-contact.md) | [JVM]<br>public final [SupplyContact](../-supply-contact/index.md)[getContact](get-contact.md)() |
| [getEssentials](get-essentials.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Essential](../-essential/index.md)&gt;[getEssentials](get-essentials.md)() |
| [getUpdateAvailableDate](get-update-available-date.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getUpdateAvailableDate](get-update-available-date.md)() |
