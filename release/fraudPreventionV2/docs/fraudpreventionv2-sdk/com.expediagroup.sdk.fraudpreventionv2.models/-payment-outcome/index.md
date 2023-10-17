//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[PaymentOutcome](index.md)

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

## Properties

| Name | Summary |
|---|---|
| [code](index.md#1241214058%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[code](index.md#1241214058%2FProperties%2F-173342751) |
| [description](index.md#1803297799%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[description](index.md#1803297799%2FProperties%2F-173342751) |
| [status](index.md#-921398395%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [PaymentStatus](../-payment-status/index.md)[status](index.md#-921398395%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentOutcome.Builder](-builder/index.md)[builder](builder.md)() |
| [getCode](get-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCode](get-code.md)() |
| [getDescription](get-description.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDescription](get-description.md)() |
| [getStatus](get-status.md) | [JVM]<br>public final [PaymentStatus](../-payment-status/index.md)[getStatus](get-status.md)() |
