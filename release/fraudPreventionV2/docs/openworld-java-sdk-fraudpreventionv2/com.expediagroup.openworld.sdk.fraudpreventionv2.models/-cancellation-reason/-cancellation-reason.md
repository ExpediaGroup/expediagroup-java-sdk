//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[CancellationReason](index.md)/[CancellationReason](-cancellation-reason.md)

# CancellationReason

[JVM]\

public [CancellationReason](index.md)[CancellationReason](-cancellation-reason.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)primaryReasonCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)subReasonCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)primaryReasonDescription, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)subReasonDescription)

#### Parameters

JVM

| | |
|---|---|
| primaryReasonCode | Primary cancellation reason code. |
| subReasonCode | Substitute cancellation reason code. |
| primaryReasonDescription | Primary cancellation reason code. Required if `order_status = CANCELLED`. |
| subReasonDescription | Substitute cancellation reason description. |
