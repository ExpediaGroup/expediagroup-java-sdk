//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.client](../index.md)/[FraudPreventionV2Client](index.md)/[notifyWithAccountUpdate](notify-with-account-update.md)

# notifyWithAccountUpdate

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [AccountUpdateResponse](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-account-update-response/index.md)[notifyWithAccountUpdate](notify-with-account-update.md)([AccountUpdateRequest](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-account-update-request/index.md)accountUpdateRequest, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [AccountUpdateResponse](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-account-update-response/index.md)[notifyWithAccountUpdate](notify-with-account-update.md)([AccountUpdateRequest](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models/-account-update-request/index.md)accountUpdateRequest)

Send an update as a result of an account screen transaction The Account Update API is called when there is an account lifecycle transition such as a challenge outcome, account restoration, or remediation action completion. For example, if a user's account is disabled, deleted, or restored, the Account Update API is called to notify Expedia Group about the change. The Account Update API is also called when a user responds to a login Multi-Factor Authentication based on a Fraud recommendation.

#### Return

AccountUpdateResponse

#### Parameters

JVM

| | |
|---|---|
| accountUpdateRequest | An AccountUpdate request may be of one of the following types `MULTI_FACTOR_AUTHENTICATION_UPDATE`, `REMEDIATION_UPDATE`. |

#### Throws

| |
|---|
| [OpenWorldApiAccountTakeoverBadRequestErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-account-takeover-bad-request-error-exception/index.md) |
| [OpenWorldApiAccountTakeoverUnauthorizedErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-account-takeover-unauthorized-error-exception/index.md) |
| [OpenWorldApiForbiddenErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-forbidden-error-exception/index.md) |
| [OpenWorldApiAccountUpdateNotFoundErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-account-update-not-found-error-exception/index.md) |
| [OpenWorldApiTooManyRequestsErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-too-many-requests-error-exception/index.md) |
| [OpenWorldApiInternalServerErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-internal-server-error-exception/index.md) |
| [OpenWorldApiBadGatewayErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-bad-gateway-error-exception/index.md) |
| [OpenWorldApiAccountTakeoverServiceUnavailableErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-account-takeover-service-unavailable-error-exception/index.md) |
| [OpenWorldApiGatewayTimeoutErrorException](../../com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception/-open-world-api-gateway-timeout-error-exception/index.md) |
