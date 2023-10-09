//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[PaymentOutcome](index.md)

# PaymentOutcome

public final class [PaymentOutcome](index.md)

#### Parameters

JVM

| |
|---|
| status |
| code | A mnemonic code for the payment processing. |
| description | A short description providing additional explanation regarding the mnemonic code. |

## Constructors

| | |
|---|---|
| [PaymentOutcome](-payment-outcome.md) | [JVM]<br>public [PaymentOutcome](index.md)[PaymentOutcome](-payment-outcome.md)([PaymentStatus](../-payment-status/index.md)status, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)code, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)description) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentOutcome.Builder](-builder/index.md)[builder](builder.md)() |
| [getCode](get-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCode](get-code.md)() |
| [getDescription](get-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDescription](get-description.md)() |
| [getStatus](get-status.md) | [JVM]<br>public final [PaymentStatus](../-payment-status/index.md)[getStatus](get-status.md)() |

## Properties

| Name | Summary |
|---|---|
| [code](index.md#2096342276%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[code](index.md#2096342276%2FProperties%2F-1883119931) |
| [description](index.md#818539053%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[description](index.md#818539053%2FProperties%2F-1883119931) |
| [status](index.md#518065567%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentStatus](../-payment-status/index.md)[status](index.md#518065567%2FProperties%2F-1883119931) |
