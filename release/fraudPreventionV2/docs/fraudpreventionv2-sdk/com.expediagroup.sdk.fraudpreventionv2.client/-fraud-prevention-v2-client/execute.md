//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.client](../index.md)/[FraudPreventionV2Client](index.md)/[execute](execute.md)

# execute

[JVM]\

public final Response&lt;[AccountScreenResponse](../../com.expediagroup.sdk.fraudpreventionv2.models/-account-screen-response/index.md)&gt;[execute](execute.md)([ScreenAccountOperation](../../com.expediagroup.sdk.fraudpreventionv2.operations/-screen-account-operation/index.md)operation)

Run fraud screening for one transaction The Account Screen API gives a Fraud recommendation for an account transaction. A recommendation can be ACCEPT, CHALLENGE, or REJECT. A transaction is marked as CHALLENGE whenever there are insufficient signals to recommend ACCEPT or REJECT. These CHALLENGE incidents are manually reviewed, and a corrected recommendation is made asynchronously.

#### Return

a Response object with a body of type AccountScreenResponse

#### Parameters

JVM

| | |
|---|---|
| operation | [ScreenAccountOperation](../../com.expediagroup.sdk.fraudpreventionv2.operations/-screen-account-operation/index.md) |

#### Throws

| |
|---|
| [ExpediaGroupApiAccountTakeoverBadRequestErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-account-takeover-bad-request-error-exception/index.md) |
| [ExpediaGroupApiAccountTakeoverUnauthorizedErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-account-takeover-unauthorized-error-exception/index.md) |
| [ExpediaGroupApiForbiddenErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-forbidden-error-exception/index.md) |
| [ExpediaGroupApiNotFoundErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-not-found-error-exception/index.md) |
| [ExpediaGroupApiTooManyRequestsErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-too-many-requests-error-exception/index.md) |
| [ExpediaGroupApiInternalServerErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-internal-server-error-exception/index.md) |
| [ExpediaGroupApiBadGatewayErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-bad-gateway-error-exception/index.md) |
| [ExpediaGroupApiServiceUnavailableErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-service-unavailable-error-exception/index.md) |
| [ExpediaGroupApiGatewayTimeoutErrorException](../../com.expediagroup.sdk.fraudpreventionv2.models.exception/-expedia-group-api-gateway-timeout-error-exception/index.md) |

[JVM]\

public final Response&lt;[OrderPurchaseScreenResponse](../../com.expediagroup.sdk.fraudpreventionv2.models/-order-purchase-screen-response/index.md)&gt;[execute](execute.md)([ScreenOrderPurchaseOperation](../../com.expediagroup.sdk.fraudpreventionv2.operations/-screen-order-purchase-operation/index.md)operation)

Run fraud screening for one transaction The Order Purchase API gives a Fraud recommendation for a transaction. A recommendation can be Accept, Reject, or Review. A transaction is marked as Review whenever there are insufficient signals to recommend Accept or Reject. These incidents are manually reviewed, and a corrected recommendation is made asynchronously.

#### Return

a Response object with a body of type OrderPurchaseScreenResponse

#### Parameters

JVM

| | |
|---|---|
| operation | [ScreenOrderPurchaseOperation](../../com.expediagroup.sdk.fraudpreventionv2.operations/-screen-order-purchase-operation/index.md) |

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

[JVM]\

public final Response&lt;[AccountUpdateResponse](../../com.expediagroup.sdk.fraudpreventionv2.models/-account-update-response/index.md)&gt;[execute](execute.md)([UpdateAccountOperation](../../com.expediagroup.sdk.fraudpreventionv2.operations/-update-account-operation/index.md)operation)

Send an update as a result of an account screen transaction The Account Update API is called when there is an account lifecycle transition such as a challenge outcome, account restoration, or remediation action completion. For example, if a user's account is disabled, deleted, or restored, the Account Update API is called to notify Expedia Group about the change. The Account Update API is also called when a user responds to a login Multi-Factor Authentication based on a Fraud recommendation.

#### Return

a Response object with a body of type AccountUpdateResponse

#### Parameters

JVM

| | |
|---|---|
| operation | [UpdateAccountOperation](../../com.expediagroup.sdk.fraudpreventionv2.operations/-update-account-operation/index.md) |

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

[JVM]\

public final Response&lt;[OrderPurchaseUpdateResponse](../../com.expediagroup.sdk.fraudpreventionv2.models/-order-purchase-update-response/index.md)&gt;[execute](execute.md)([UpdateOrderPurchaseOperation](../../com.expediagroup.sdk.fraudpreventionv2.operations/-update-order-purchase-operation/index.md)operation)

Send an update for a transaction The Order Purchase Update API is called when the status of the order has changed.  For example, if the customer cancels the reservation, changes reservation in any way, or adds additional products or travelers to the reservation, the Order Purchase Update API is called to notify Expedia Group about the change.  The Order Purchase Update API is also called when the merchant cancels or changes an order based on a Fraud recommendation.

#### Return

a Response object with a body of type OrderPurchaseUpdateResponse

#### Parameters

JVM

| | |
|---|---|
| operation | [UpdateOrderPurchaseOperation](../../com.expediagroup.sdk.fraudpreventionv2.operations/-update-order-purchase-operation/index.md) |

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
