//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.client](../index.md)/[FraudPreventionV2Client](index.md)/[notifyWithOrderUpdate](notify-with-order-update.md)

# notifyWithOrderUpdate

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [OrderPurchaseUpdateResponse](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-order-purchase-update-response/index.md)[notifyWithOrderUpdate](notify-with-order-update.md)([OrderPurchaseUpdateRequest](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-order-purchase-update-request/index.md)orderPurchaseUpdateRequest, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [OrderPurchaseUpdateResponse](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-order-purchase-update-response/index.md)[notifyWithOrderUpdate](notify-with-order-update.md)([OrderPurchaseUpdateRequest](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-order-purchase-update-request/index.md)orderPurchaseUpdateRequest)

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
| [OpenWorldApiBadRequestErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-bad-request-error-exception/index.md) |
| [OpenWorldApiUnauthorizedErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-unauthorized-error-exception/index.md) |
| [OpenWorldApiForbiddenErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-forbidden-error-exception/index.md) |
| [OpenWorldApiOrderPurchaseUpdateNotFoundErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-order-purchase-update-not-found-error-exception/index.md) |
| [OpenWorldApiTooManyRequestsErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-too-many-requests-error-exception/index.md) |
| [OpenWorldApiInternalServerErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-internal-server-error-exception/index.md) |
| [OpenWorldApiBadGatewayErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-bad-gateway-error-exception/index.md) |
| [OpenWorldApiServiceUnavailableErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-service-unavailable-error-exception/index.md) |
| [OpenWorldApiGatewayTimeoutErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-gateway-timeout-error-exception/index.md) |
