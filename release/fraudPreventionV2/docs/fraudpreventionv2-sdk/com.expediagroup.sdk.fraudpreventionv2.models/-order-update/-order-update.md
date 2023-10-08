//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[OrderUpdate](index.md)/[OrderUpdate](-order-update.md)

# OrderUpdate

[JVM]\

public [OrderUpdate](index.md)[OrderUpdate](-order-update.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)riskId, [Status](../-status/index.md)orderStatus, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)acquirerReferenceNumber, [CancellationReason](../-cancellation-reason/index.md)cancellationReason)

#### Parameters

JVM

| |
|---|
| orderStatus |
| acquirerReferenceNumber | A unique number that tags a credit or debit card transaction when it goes from the merchant's bank through to the cardholder's bank. `acquirer_reference_number` is a required field only if `order_status` = `COMPLETED` Typically, merchants can get this number from their payment processors. This number is used when dealing with disputes/chargebacks on original transactions. |
| cancellationReason |
