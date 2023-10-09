//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[OrderUpdateAllOf](index.md)

# OrderUpdateAllOf

public final class [OrderUpdateAllOf](index.md)

#### Parameters

JVM

| |
|---|
| orderStatus |
| acquirerReferenceNumber | A unique number that tags a credit or debit card transaction when it goes from the merchant's bank through to the cardholder's bank. `acquirer_reference_number` is a required field only if `order_status` = `COMPLETED` Typically, merchants can get this number from their payment processors. This number is used when dealing with disputes/chargebacks on original transactions. |
| cancellationReason |

## Constructors

| | |
|---|---|
| [OrderUpdateAllOf](-order-update-all-of.md) | [JVM]<br>public [OrderUpdateAllOf](index.md)[OrderUpdateAllOf](-order-update-all-of.md)([Status](../-status/index.md)orderStatus, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)acquirerReferenceNumber, [CancellationReason](../-cancellation-reason/index.md)cancellationReason) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [OrderUpdateAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getAcquirerReferenceNumber](get-acquirer-reference-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAcquirerReferenceNumber](get-acquirer-reference-number.md)() |
| [getCancellationReason](get-cancellation-reason.md) | [JVM]<br>public final [CancellationReason](../-cancellation-reason/index.md)[getCancellationReason](get-cancellation-reason.md)() |
| [getOrderStatus](get-order-status.md) | [JVM]<br>public final [Status](../-status/index.md)[getOrderStatus](get-order-status.md)() |

## Properties

| Name | Summary |
|---|---|
| [acquirerReferenceNumber](index.md#-19340260%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[acquirerReferenceNumber](index.md#-19340260%2FProperties%2F-1883119931) |
| [cancellationReason](index.md#3900479%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [CancellationReason](../-cancellation-reason/index.md)[cancellationReason](index.md#3900479%2FProperties%2F-1883119931) |
| [orderStatus](index.md#63471412%2FProperties%2F-1883119931) | [JVM]<br>@Valid()<br>private final [Status](../-status/index.md)[orderStatus](index.md#63471412%2FProperties%2F-1883119931) |
