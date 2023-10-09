//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.client](../index.md)/[FraudPreventionV2Client](index.md)/[notifyWithOrderUpdate](notify-with-order-update.md)

# notifyWithOrderUpdate

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [OrderPurchaseUpdateResponse](../../com.expediagroup.sdk.fraudpreventionv2.models/-order-purchase-update-response/index.md)[notifyWithOrderUpdate](notify-with-order-update.md)([OrderPurchaseUpdateRequest](../../com.expediagroup.sdk.fraudpreventionv2.models/-order-purchase-update-request/index.md)orderPurchaseUpdateRequest, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [OrderPurchaseUpdateResponse](../../com.expediagroup.sdk.fraudpreventionv2.models/-order-purchase-update-response/index.md)[notifyWithOrderUpdate](notify-with-order-update.md)([OrderPurchaseUpdateRequest](../../com.expediagroup.sdk.fraudpreventionv2.models/-order-purchase-update-request/index.md)orderPurchaseUpdateRequest)

Send an update for a transaction The Order Purchase Update API is called when the status of the order has changed.  For example, if the customer cancels the reservation, changes reservation in any way, or adds additional products or travelers to the reservation, the Order Purchase Update API is called to notify Expedia Group about the change.  The Order Purchase Update API is also called when the merchant cancels or changes an order based on a Fraud recommendation.

#### Return

OrderPurchaseUpdateResponse

#### Parameters

JVM

| | |
|---|---|
| orderPurchaseUpdateRequest | An OrderPurchaseUpdate request may be of one of the following types `ORDER_UPDATE`, `CHARGEBACK_FEEDBACK`, `INSULT_FEEDBACK`, `REFUND_UPDATE`, `PAYMENT_UPDATE`. |

#### Throws

| |
|---|
| [ExpediaGroupApiBadRequestErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-bad-request-error-exception/index.md) |
| [ExpediaGroupApiUnauthorizedErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-unauthorized-error-exception/index.md) |
| [ExpediaGroupApiForbiddenErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-forbidden-error-exception/index.md) |
| [ExpediaGroupApiOrderPurchaseUpdateNotFoundErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-order-purchase-update-not-found-error-exception/index.md) |
| [ExpediaGroupApiTooManyRequestsErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-too-many-requests-error-exception/index.md) |
| [ExpediaGroupApiInternalServerErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-internal-server-error-exception/index.md) |
| [ExpediaGroupApiBadGatewayErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-bad-gateway-error-exception/index.md) |
| [ExpediaGroupApiRetryableOrderPurchaseUpdateFailureException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-retryable-order-purchase-update-failure-exception/index.md) |
| [ExpediaGroupApiGatewayTimeoutErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-gateway-timeout-error-exception/index.md) |
