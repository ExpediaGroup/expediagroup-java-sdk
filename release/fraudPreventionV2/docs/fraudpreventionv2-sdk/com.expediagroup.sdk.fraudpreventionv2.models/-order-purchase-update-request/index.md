//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[OrderPurchaseUpdateRequest](index.md)

# OrderPurchaseUpdateRequest

public interface [OrderPurchaseUpdateRequest](index.md)

The `type` field value is used as a discriminator, with the following mapping: * `ORDER_UPDATE`: `OrderUpdate` * `CHARGEBACK_FEEDBACK`: `ChargebackFeedback` * `INSULT_FEEDBACK`: `InsultFeedback` * `REFUND_UPDATE`: `RefundUpdate` * `PAYMENT_UPDATE`: `PaymentUpdate`

#### Parameters

JVM

| |
|---|
| type |
| riskId | The `risk_id` provided by Expedia's Fraud Prevention Service in the `OrderPurchaseScreenResponse`. |

#### Inheritors

| |
|---|
| [ChargebackFeedback](../-chargeback-feedback/index.md) |
| [InsultFeedback](../-insult-feedback/index.md) |
| [OrderUpdate](../-order-update/index.md) |
| [PaymentUpdate](../-payment-update/index.md) |
| [RefundUpdate](../-refund-update/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getRiskId](get-risk-id.md) | [JVM]<br>public abstract [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getRiskId](get-risk-id.md)() |
| [getType](get-type.md) | [JVM]<br>public abstract [UpdateType](../-update-type/index.md)[getType](get-type.md)() |
