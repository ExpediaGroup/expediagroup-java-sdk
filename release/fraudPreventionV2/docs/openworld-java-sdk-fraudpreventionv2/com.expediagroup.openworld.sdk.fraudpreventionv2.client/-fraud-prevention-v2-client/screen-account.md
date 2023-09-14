//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.client](../index.md)/[FraudPreventionV2Client](index.md)/[screenAccount](screen-account.md)

# screenAccount

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [AccountScreenResponse](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-account-screen-response/index.md)[screenAccount](screen-account.md)([AccountScreenRequest](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-account-screen-request/index.md)accountScreenRequest, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [AccountScreenResponse](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-account-screen-response/index.md)[screenAccount](screen-account.md)([AccountScreenRequest](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-account-screen-request/index.md)accountScreenRequest)

Run fraud screening for one transaction The Account Screen API gives a Fraud recommendation for an account transaction. A recommendation can be ACCEPT, CHALLENGE, or REJECT. A transaction is marked as CHALLENGE whenever there are insufficient signals to recommend ACCEPT or REJECT. These CHALLENGE incidents are manually reviewed, and a corrected recommendation is made asynchronously.

#### Return

AccountScreenResponse

#### Parameters

JVM

| |
|---|
| accountScreenRequest |

#### Throws

| |
|---|
| [OpenWorldApiAccountTakeoverBadRequestErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-account-takeover-bad-request-error-exception/index.md) |
| [OpenWorldApiAccountTakeoverUnauthorizedErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-account-takeover-unauthorized-error-exception/index.md) |
| [OpenWorldApiForbiddenErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-forbidden-error-exception/index.md) |
| [OpenWorldApiNotFoundErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-not-found-error-exception/index.md) |
| [OpenWorldApiTooManyRequestsErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-too-many-requests-error-exception/index.md) |
| [OpenWorldApiInternalServerErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-internal-server-error-exception/index.md) |
| [OpenWorldApiBadGatewayErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-bad-gateway-error-exception/index.md) |
| [OpenWorldApiAccountTakeoverServiceUnavailableErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-account-takeover-service-unavailable-error-exception/index.md) |
| [OpenWorldApiGatewayTimeoutErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-gateway-timeout-error-exception/index.md) |
