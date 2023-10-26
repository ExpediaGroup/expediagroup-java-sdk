//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[AuthorizeReversal](index.md)

# AuthorizeReversal

public final class [AuthorizeReversal](index.md)

Authorize Reversal operation on the payment. An authorize reversal operation represents a notification received usually from a 3rd party payment processor to indicate that an authorization hold should be released as a result of a sale being partially or completely cancelled.

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
| [AuthorizeReversal](-authorize-reversal.md) | [JVM]<br>public [AuthorizeReversal](index.md)[AuthorizeReversal](-authorize-reversal.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [Amount](../-amount/index.md)amount, [PaymentOutcome](../-payment-outcome/index.md)outcome) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [amount](index.md#1571276912%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[amount](index.md#1571276912%2FProperties%2F-173342751) |
| [id](index.md#945330829%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#945330829%2FProperties%2F-173342751) |
| [outcome](index.md#806255616%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [PaymentOutcome](../-payment-outcome/index.md)[outcome](index.md#806255616%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [AuthorizeReversal.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmount](get-amount.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getAmount](get-amount.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getOutcome](get-outcome.md) | [JVM]<br>public final [PaymentOutcome](../-payment-outcome/index.md)[getOutcome](get-outcome.md)() |
