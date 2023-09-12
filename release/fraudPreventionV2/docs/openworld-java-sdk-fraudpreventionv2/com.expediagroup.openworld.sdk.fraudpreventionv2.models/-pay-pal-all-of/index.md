//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[PayPalAllOf](index.md)

# PayPalAllOf

public final class [PayPalAllOf](index.md)

#### Parameters

JVM

| | |
|---|---|
| payerId | Unique PayPal Customer Account identification number. |
| transactionId | Unique transaction number to identify Auth calls at PayPal. |
| merchantOrderCode | Reference code passed to acquiring bank at the time of payment. This code is the key ID that ties back to payments data at the payment level. |

## Constructors

| | |
|---|---|
| [PayPalAllOf](-pay-pal-all-of.md) | [JVM]<br>public [PayPalAllOf](index.md)[PayPalAllOf](-pay-pal-all-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)payerId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)transactionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantOrderCode) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PayPalAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getMerchantOrderCode](get-merchant-order-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMerchantOrderCode](get-merchant-order-code.md)() |
| [getPayerId](get-payer-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPayerId](get-payer-id.md)() |
| [getTransactionId](get-transaction-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTransactionId](get-transaction-id.md)() |

## Properties

| Name | Summary |
|---|---|
| [merchantOrderCode](index.md#-1954778133%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[merchantOrderCode](index.md#-1954778133%2FProperties%2F-1883119931) |
| [payerId](index.md#1397387758%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[payerId](index.md#1397387758%2FProperties%2F-1883119931) |
| [transactionId](index.md#-1701314555%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[transactionId](index.md#-1701314555%2FProperties%2F-1883119931) |
