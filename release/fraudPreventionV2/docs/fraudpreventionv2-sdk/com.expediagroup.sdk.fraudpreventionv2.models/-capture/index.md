//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Capture](index.md)

# Capture

public final class [Capture](index.md)

Capture operation on the payment. A capture operation represents a notification received usually from a 3rd party payment processor to indicate that the funds placed on hold will be captured and the funds transfer process will occur from the customer's funds to the merchant's funds.

#### Parameters

JVM

| |
|---|
| id |
| amount |
| outcome |

## Constructors

| | |
|---|---|
| [Capture](-capture.md) | [JVM]<br>public [Capture](index.md)[Capture](-capture.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [Amount](../-amount/index.md)amount, [PaymentOutcome](../-payment-outcome/index.md)outcome) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [amount](index.md#620420895%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[amount](index.md#620420895%2FProperties%2F-173342751) |
| [id](index.md#-1234673476%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#-1234673476%2FProperties%2F-173342751) |
| [outcome](index.md#1394490161%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [PaymentOutcome](../-payment-outcome/index.md)[outcome](index.md#1394490161%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Capture.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmount](get-amount.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getAmount](get-amount.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getOutcome](get-outcome.md) | [JVM]<br>public final [PaymentOutcome](../-payment-outcome/index.md)[getOutcome](get-outcome.md)() |
