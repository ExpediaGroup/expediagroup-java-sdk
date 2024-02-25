//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.client](../index.md)/[FraudPreventionV2Client](index.md)/[notifyWithAccountUpdate](notify-with-account-update.md)

# notifyWithAccountUpdate

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [AccountUpdateResponse](../../com.expediagroup.sdk.fraudpreventionv2.models/-account-update-response/index.md)[notifyWithAccountUpdate](notify-with-account-update.md)([AccountUpdateRequest](../../com.expediagroup.sdk.fraudpreventionv2.models/-account-update-request/index.md)accountUpdateRequest)

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
| [ExpediaGroupApiAccountTakeoverBadRequestErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-account-takeover-bad-request-error-exception/index.md) |
| [ExpediaGroupApiAccountTakeoverUnauthorizedErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-account-takeover-unauthorized-error-exception/index.md) |
| [ExpediaGroupApiForbiddenErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-forbidden-error-exception/index.md) |
| [ExpediaGroupApiAccountUpdateNotFoundErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-account-update-not-found-error-exception/index.md) |
| [ExpediaGroupApiTooManyRequestsErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-too-many-requests-error-exception/index.md) |
| [ExpediaGroupApiInternalServerErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-internal-server-error-exception/index.md) |
| [ExpediaGroupApiBadGatewayErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-bad-gateway-error-exception/index.md) |
| [ExpediaGroupApiServiceUnavailableErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-service-unavailable-error-exception/index.md) |
| [ExpediaGroupApiGatewayTimeoutErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-gateway-timeout-error-exception/index.md) |
