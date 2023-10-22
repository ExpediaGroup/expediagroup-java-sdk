//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[RoomPriceCheckLinks](index.md)

# RoomPriceCheckLinks

public final class [RoomPriceCheckLinks](index.md)

A map of links, including links to continue booking this rate or to shop for additional rates.  If this rate is still available for booking then a book link will be present if PSD2 is not a requirement for you or a payment_session link will be present if PSD2 is a requirement for you.

#### Parameters

JVM

| |
|---|
| book |
| commit |
| paymentSession |
| additionalRates |

## Constructors

| | |
|---|---|
| [RoomPriceCheckLinks](-room-price-check-links.md) | [JVM]<br>public [RoomPriceCheckLinks](index.md)[RoomPriceCheckLinks](-room-price-check-links.md)([Link](../-link/index.md)book, [Link](../-link/index.md)commit, [Link](../-link/index.md)paymentSession, [Link](../-link/index.md)additionalRates) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [additionalRates](index.md#-1212102518%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Link](../-link/index.md)[additionalRates](index.md#-1212102518%2FProperties%2F700308213) |
| [book](index.md#358981531%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Link](../-link/index.md)[book](index.md#358981531%2FProperties%2F700308213) |
| [commit](index.md#1719318349%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Link](../-link/index.md)[commit](index.md#1719318349%2FProperties%2F700308213) |
| [paymentSession](index.md#124788212%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Link](../-link/index.md)[paymentSession](index.md#124788212%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RoomPriceCheckLinks.Builder](-builder/index.md)[builder](builder.md)() |
| [getAdditionalRates](get-additional-rates.md) | [JVM]<br>public final [Link](../-link/index.md)[getAdditionalRates](get-additional-rates.md)() |
| [getBook](get-book.md) | [JVM]<br>public final [Link](../-link/index.md)[getBook](get-book.md)() |
| [getCommit](get-commit.md) | [JVM]<br>public final [Link](../-link/index.md)[getCommit](get-commit.md)() |
| [getPaymentSession](get-payment-session.md) | [JVM]<br>public final [Link](../-link/index.md)[getPaymentSession](get-payment-session.md)() |
