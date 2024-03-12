//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.client](../index.md)/[FraudPreventionV2Client](index.md)/[screenOrder](screen-order.md)

# screenOrder

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [OrderPurchaseScreenResponse](../../com.expediagroup.sdk.fraudpreventionv2.models/-order-purchase-screen-response/index.md)[screenOrder](screen-order.md)([OrderPurchaseScreenRequest](../../com.expediagroup.sdk.fraudpreventionv2.models/-order-purchase-screen-request/index.md)orderPurchaseScreenRequest)

Run fraud screening for one transaction The Order Purchase API gives a Fraud recommendation for a transaction. A recommendation can be Accept, Reject, or Review. A transaction is marked as Review whenever there are insufficient signals to recommend Accept or Reject. These incidents are manually reviewed, and a corrected recommendation is made asynchronously.

#### Return

OrderPurchaseScreenResponse

#### Parameters

JVM

| |
|---|
| orderPurchaseScreenRequest |

#### Throws

| |
|---|
| [ExpediaGroupApiBadRequestErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-bad-request-error-exception/index.md) |
| [ExpediaGroupApiUnauthorizedErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-unauthorized-error-exception/index.md) |
| [ExpediaGroupApiForbiddenErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-forbidden-error-exception/index.md) |
| [ExpediaGroupApiNotFoundErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-not-found-error-exception/index.md) |
| [ExpediaGroupApiTooManyRequestsErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-too-many-requests-error-exception/index.md) |
| [ExpediaGroupApiInternalServerErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-internal-server-error-exception/index.md) |
| [ExpediaGroupApiBadGatewayErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-bad-gateway-error-exception/index.md) |
| [ExpediaGroupApiRetryableOrderPurchaseScreenFailureException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-retryable-order-purchase-screen-failure-exception/index.md) |
| [ExpediaGroupApiGatewayTimeoutErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-gateway-timeout-error-exception/index.md) |
