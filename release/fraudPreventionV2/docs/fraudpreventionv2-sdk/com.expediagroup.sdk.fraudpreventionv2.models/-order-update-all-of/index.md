//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[OrderUpdateAllOf](index.md)

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

## Properties

| Name | Summary |
|---|---|
| [acquirerReferenceNumber](index.md#-108275594%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[acquirerReferenceNumber](index.md#-108275594%2FProperties%2F-173342751) |
| [cancellationReason](index.md#243515301%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [CancellationReason](../-cancellation-reason/index.md)[cancellationReason](index.md#243515301%2FProperties%2F-173342751) |
| [orderStatus](index.md#1523821198%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Status](../-status/index.md)[orderStatus](index.md#1523821198%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [OrderUpdateAllOf.Builder](-builder/index.md)[builder](builder.md)() |
| [getAcquirerReferenceNumber](get-acquirer-reference-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAcquirerReferenceNumber](get-acquirer-reference-number.md)() |
| [getCancellationReason](get-cancellation-reason.md) | [JVM]<br>public final [CancellationReason](../-cancellation-reason/index.md)[getCancellationReason](get-cancellation-reason.md)() |
| [getOrderStatus](get-order-status.md) | [JVM]<br>public final [Status](../-status/index.md)[getOrderStatus](get-order-status.md)() |
