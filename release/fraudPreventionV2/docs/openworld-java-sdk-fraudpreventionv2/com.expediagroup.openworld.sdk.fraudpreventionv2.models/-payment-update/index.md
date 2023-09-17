//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[PaymentUpdate](index.md)

# PaymentUpdate

public final class [PaymentUpdate](index.md) implements [OrderPurchaseUpdateRequest](../-order-purchase-update-request/index.md)

Payment related data that should be updated.

#### Parameters

JVM

| | |
|---|---|
| merchantOrderCode | Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level. |

## Constructors

| | |
|---|---|
| [PaymentUpdate](-payment-update.md) | [JVM]<br>public [PaymentUpdate](index.md)[PaymentUpdate](-payment-update.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)riskId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantOrderCode) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentUpdate.Builder](-builder/index.md)[builder](builder.md)() |
| [getMerchantOrderCode](get-merchant-order-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMerchantOrderCode](get-merchant-order-code.md)() |
| [getRiskId](get-risk-id.md) | [JVM]<br>public [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRiskId](get-risk-id.md)() |
| [getType](get-type.md) | [JVM]<br>public [UpdateType](../-update-type/index.md)[getType](get-type.md)() |

## Properties

| Name | Summary |
|---|---|
| [merchantOrderCode](index.md#1131029953%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[merchantOrderCode](index.md#1131029953%2FProperties%2F-1883119931) |
| [riskId](index.md#854106876%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[riskId](index.md#854106876%2FProperties%2F-1883119931) |
| [type](index.md#-1081033652%2FProperties%2F-1883119931) | [JVM]<br>private final [UpdateType](../-update-type/index.md)[type](index.md#-1081033652%2FProperties%2F-1883119931) |
