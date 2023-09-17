//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[PaymentOperation](index.md)

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

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentOperation.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmount](get-amount.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getAmount](get-amount.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getOutcome](get-outcome.md) | [JVM]<br>public final [PaymentOutcome](../-payment-outcome/index.md)[getOutcome](get-outcome.md)() |

## Properties

| Name | Summary |
|---|---|
| [amount](index.md#1801655758%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[amount](index.md#1801655758%2FProperties%2F-1883119931) |
| [id](index.md#-887273749%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#-887273749%2FProperties%2F-1883119931) |
| [outcome](index.md#-641934750%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentOutcome](../-payment-outcome/index.md)[outcome](index.md#-641934750%2FProperties%2F-1883119931) |
