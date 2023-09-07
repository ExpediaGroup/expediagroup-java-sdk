//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.client](../index.md)/[FraudPreventionV2Client](index.md)/[screenOrder](screen-order.md)

# screenOrder

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [OrderPurchaseScreenResponse](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-order-purchase-screen-response/index.md)[screenOrder](screen-order.md)([OrderPurchaseScreenRequest](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-order-purchase-screen-request/index.md)orderPurchaseScreenRequest, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [OrderPurchaseScreenResponse](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-order-purchase-screen-response/index.md)[screenOrder](screen-order.md)([OrderPurchaseScreenRequest](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-order-purchase-screen-request/index.md)orderPurchaseScreenRequest)

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
| [OpenWorldApiBadRequestErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-bad-request-error-exception/index.md) |
| [OpenWorldApiUnauthorizedErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-unauthorized-error-exception/index.md) |
| [OpenWorldApiForbiddenErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-forbidden-error-exception/index.md) |
| [OpenWorldApiNotFoundErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-not-found-error-exception/index.md) |
| [OpenWorldApiTooManyRequestsErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-too-many-requests-error-exception/index.md) |
| [OpenWorldApiInternalServerErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-internal-server-error-exception/index.md) |
| [OpenWorldApiBadGatewayErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-bad-gateway-error-exception/index.md) |
| [OpenWorldApiServiceUnavailableErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-service-unavailable-error-exception/index.md) |
| [OpenWorldApiGatewayTimeoutErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-gateway-timeout-error-exception/index.md) |
