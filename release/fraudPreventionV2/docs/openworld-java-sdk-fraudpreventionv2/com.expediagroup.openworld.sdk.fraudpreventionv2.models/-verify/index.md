//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[Verify](index.md)

# Verify

public final class [Verify](index.md)

A verify operation represents the intent to verify the payment associated with this transaction.

#### Parameters

JVM

| |
|---|
| id |
| amount |
| outcome |
| type |

## Constructors

| | |
|---|---|
| [Verify](-verify.md) | [JVM]<br>public [Verify](index.md)[Verify](-verify.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)id, [Amount](../-amount/index.md)amount, [PaymentOutcome](../-payment-outcome/index.md)outcome, [VerificationType](../-verification-type/index.md)type) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Verify.Builder](-builder/index.md)[builder](builder.md)() |
| [getAmount](get-amount.md) | [JVM]<br>public final [Amount](../-amount/index.md)[getAmount](get-amount.md)() |
| [getId](get-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getId](get-id.md)() |
| [getOutcome](get-outcome.md) | [JVM]<br>public final [PaymentOutcome](../-payment-outcome/index.md)[getOutcome](get-outcome.md)() |
| [getType](get-type.md) | [JVM]<br>public final [VerificationType](../-verification-type/index.md)[getType](get-type.md)() |

## Properties

| Name | Summary |
|---|---|
| [amount](index.md#-491148026%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Amount](../-amount/index.md)[amount](index.md#-491148026%2FProperties%2F-1883119931) |
| [id](index.md#-1475331549%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[id](index.md#-1475331549%2FProperties%2F-1883119931) |
| [outcome](index.md#1295591978%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [PaymentOutcome](../-payment-outcome/index.md)[outcome](index.md#1295591978%2FProperties%2F-1883119931) |
| [type](index.md#1376634020%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [VerificationType](../-verification-type/index.md)[type](index.md#1376634020%2FProperties%2F-1883119931) |
