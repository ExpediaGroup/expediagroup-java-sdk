//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[Authorize](index.md)

# Authorize

public final class [Authorize](index.md)

Authorize operation on the payment. An authorize operation represents placing the funds on hold with the specified form of payment.

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
| [Authorize](-authorize.md) | [JVM]<br>public [Authorize](index.md)[Authorize](-authorize.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [Amount](../-amount/index.md)amount, [PaymentOutcome](../-payment-outcome/index.md)outcome) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Authorize.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmount](get-amount.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getAmount](get-amount.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getOutcome](get-outcome.md) | [JVM]<br>public final [PaymentOutcome](../-payment-outcome/index.md)[getOutcome](get-outcome.md)() |

## Properties

| Name | Summary |
|---|---|
| [amount](index.md#-1638392664%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[amount](index.md#-1638392664%2FProperties%2F-1883119931) |
| [id](index.md#1661717189%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#1661717189%2FProperties%2F-1883119931) |
| [outcome](index.md#90746568%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentOutcome](../-payment-outcome/index.md)[outcome](index.md#90746568%2FProperties%2F-1883119931) |
