//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[ValueAdd](index.md)

# ValueAdd

public final class [ValueAdd](index.md)

An individual value add.

#### Parameters

JVM

| | |
|---|---|
| id | Unique identifier for the value add promotion. |
| description | A localized description of the value add promotion. |
| category |
| offerType |
| frequency |
| personCount | Indicates how many guests the value add promotion applies to. |

## Constructors

| | |
|---|---|
| [ValueAdd](-value-add.md) | [JVM]<br>public [ValueAdd](index.md)[ValueAdd](-value-add.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)description, [CategoryValueAdd](../-category-value-add/index.md)category, [OfferType](../-offer-type/index.md)offerType, [Frequency](../-frequency/index.md)frequency, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)personCount) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [category](index.md#1778607657%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [CategoryValueAdd](../-category-value-add/index.md)[category](index.md#1778607657%2FProperties%2F700308213) |
| [description](index.md#217707863%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[description](index.md#217707863%2FProperties%2F700308213) |
| [frequency](index.md#230411639%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Frequency](../-frequency/index.md)[frequency](index.md#230411639%2FProperties%2F700308213) |
| [id](index.md#-1571387348%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#-1571387348%2FProperties%2F700308213) |
| [offerType](index.md#936262749%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [OfferType](../-offer-type/index.md)[offerType](index.md#936262749%2FProperties%2F700308213) |
| [personCount](index.md#519133273%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[personCount](index.md#519133273%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [ValueAdd.Builder](-builder/index.md)[builder](builder.md)() |
| [getCategory](get-category.md) | [JVM]<br>public final [CategoryValueAdd](../-category-value-add/index.md)[getCategory](get-category.md)() |
| [getDescription](get-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDescription](get-description.md)() |
| [getFrequency](get-frequency.md) | [JVM]<br>public final [Frequency](../-frequency/index.md)[getFrequency](get-frequency.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getOfferType](get-offer-type.md) | [JVM]<br>public final [OfferType](../-offer-type/index.md)[getOfferType](get-offer-type.md)() |
| [getPersonCount](get-person-count.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getPersonCount](get-person-count.md)() |
