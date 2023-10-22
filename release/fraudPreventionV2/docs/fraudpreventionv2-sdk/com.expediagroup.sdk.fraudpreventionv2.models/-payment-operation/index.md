//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[PaymentOperation](index.md)

# PaymentOperation

public final class [PaymentOperation](index.md)

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
| [PaymentOperation](-payment-operation.md) | [JVM]<br>public [PaymentOperation](index.md)[PaymentOperation](-payment-operation.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [Amount](../-amount/index.md)amount, [PaymentOutcome](../-payment-outcome/index.md)outcome) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [amount](index.md#1456257588%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[amount](index.md#1456257588%2FProperties%2F-173342751) |
| [id](index.md#-1742401967%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#-1742401967%2FProperties%2F-173342751) |
| [outcome](index.md#1535623868%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [PaymentOutcome](../-payment-outcome/index.md)[outcome](index.md#1535623868%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentOperation.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmount](get-amount.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getAmount](get-amount.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getOutcome](get-outcome.md) | [JVM]<br>public final [PaymentOutcome](../-payment-outcome/index.md)[getOutcome](get-outcome.md)() |
