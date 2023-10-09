//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[GiftCardAllOf](index.md)

# GiftCardAllOf

public final class [GiftCardAllOf](index.md)

#### Parameters

JVM

| | |
|---|---|
| cardNumber | Gift card number. |
| cardHolderName | The name of gift card holder. |
| pin | The PIN of gift card. |

## Constructors

| | |
|---|---|
| [GiftCardAllOf](-gift-card-all-of.md) | [JVM]<br>public [GiftCardAllOf](index.md)[GiftCardAllOf](-gift-card-all-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardNumber, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cardHolderName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)pin) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [cardHolderName](index.md#1114647074%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cardHolderName](index.md#1114647074%2FProperties%2F-173342751) |
| [cardNumber](index.md#747911024%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[0-9A-Za-z]{4,16}$&quot;)<br>@Length(max = 16)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cardNumber](index.md#747911024%2FProperties%2F-173342751) |
| [pin](index.md#1816389948%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[0-9]{4,8}$&quot;)<br>@Length(max = 8)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[pin](index.md#1816389948%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [GiftCardAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getCardHolderName](get-card-holder-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCardHolderName](get-card-holder-name.md)() |
| [getCardNumber](get-card-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCardNumber](get-card-number.md)() |
| [getPin](get-pin.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPin](get-pin.md)() |
