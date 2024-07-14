/*
 * Copyright (C) 2022 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.sdk.fraudpreventionv2.client

import com.expediagroup.sdk.core.client.ExpediaGroupClient
import com.expediagroup.sdk.core.configuration.ExpediaGroupClientConfiguration
import com.expediagroup.sdk.core.model.EmptyResponse
import com.expediagroup.sdk.core.model.Operation
import com.expediagroup.sdk.core.model.Response
import com.expediagroup.sdk.core.model.exception.handle
import com.expediagroup.sdk.fraudpreventionv2.models.*
import com.expediagroup.sdk.fraudpreventionv2.models.exception.*
import com.expediagroup.sdk.fraudpreventionv2.operations.*
import com.expediagroup.sdk.fraudpreventionv2.validation.PropertyConstraintsValidator.validateConstraints
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future

/**
* Fraud & Risk APIs to detect fraud
*/

class FraudPreventionV2Client private constructor(clientConfiguration: ExpediaGroupClientConfiguration) : ExpediaGroupClient("fraudpreventionv2", clientConfiguration) {

    class Builder : ExpediaGroupClient.Builder<Builder>() {
        override fun build() =
            FraudPreventionV2Client(
                ExpediaGroupClientConfiguration(key, secret, endpoint, requestTimeout, connectionTimeout, socketTimeout, maskedLoggingHeaders, maskedLoggingBodyFields, authEndpoint)
            )
    }

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    override suspend fun throwServiceException(
        response: HttpResponse,
        operationId: String
    ) {
        throw ErrorObjectMapper.process(response, operationId)
    }

    private suspend inline fun <reified RequestType> executeHttpRequest(operation: Operation<RequestType>): HttpResponse {
        return httpClient.request {
            method = HttpMethod.parse(operation.method)
            url(operation.url)

            operation.params?.getHeaders()?.forEach { (key, value) ->
                headers.append(key, value)
            }

            operation.params?.getQueryParams()?.forEach { (key, value) ->
                url.parameters.appendAll(key, value)
            }

            appendHeaders(operation.transactionId)
            validateConstraints(operation.requestBody)
            contentType(ContentType.Application.Json)
            setBody(operation.requestBody)
        }
    }

    private inline fun <reified RequestType> executeWithEmptyResponse(operation: Operation<RequestType>): EmptyResponse {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                val response = executeHttpRequest(operation)
                throwIfError(response, operation.operationId)
                EmptyResponse(response.status.value, response.headers.entries())
            }.get()
        } catch (exception: Exception) {
            exception.handle()
        }
    }

    private inline fun <reified RequestType, reified ResponseType> execute(operation: Operation<RequestType>): Response<ResponseType> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                val response = executeHttpRequest(operation)
                throwIfError(response, operation.operationId)
                Response(response.status.value, response.body<ResponseType>(), response.headers.entries())
            }.get()
        } catch (exception: Exception) {
            exception.handle()
        }
    }

    /**
     * Run fraud screening for one transaction
     * The Account Screen API gives a Fraud recommendation for an account transaction. A recommendation can be ACCEPT, CHALLENGE, or REJECT. A transaction is marked as CHALLENGE whenever there are insufficient signals to recommend ACCEPT or REJECT. These CHALLENGE incidents are manually reviewed, and a corrected recommendation is made asynchronously.
     * @param operation [ScreenAccountOperation]
     * @throws ExpediaGroupApiAccountTakeoverBadRequestErrorException
     * @throws ExpediaGroupApiAccountTakeoverUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiServiceUnavailableErrorException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return a [Response] object with a body of type AccountScreenResponse
     */
    fun execute(operation: ScreenAccountOperation): Response<AccountScreenResponse> {
        return execute<AccountScreenRequest, AccountScreenResponse>(operation)
    }

    private suspend inline fun kscreenAccountWithResponse(accountScreenRequest: AccountScreenRequest): Response<AccountScreenResponse> {
        val operation =
            ScreenAccountOperation(
                requestBody = accountScreenRequest
            )

        return execute(operation)
    }

    /**
     * Run fraud screening for one transaction
     * The Account Screen API gives a Fraud recommendation for an account transaction. A recommendation can be ACCEPT, CHALLENGE, or REJECT. A transaction is marked as CHALLENGE whenever there are insufficient signals to recommend ACCEPT or REJECT. These CHALLENGE incidents are manually reviewed, and a corrected recommendation is made asynchronously.
     * @param accountScreenRequest
     * @throws ExpediaGroupApiAccountTakeoverBadRequestErrorException
     * @throws ExpediaGroupApiAccountTakeoverUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiServiceUnavailableErrorException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return AccountScreenResponse
     */
    @Throws(
        ExpediaGroupApiAccountTakeoverBadRequestErrorException::class,
        ExpediaGroupApiAccountTakeoverUnauthorizedErrorException::class,
        ExpediaGroupApiForbiddenErrorException::class,
        ExpediaGroupApiNotFoundErrorException::class,
        ExpediaGroupApiTooManyRequestsErrorException::class,
        ExpediaGroupApiInternalServerErrorException::class,
        ExpediaGroupApiBadGatewayErrorException::class,
        ExpediaGroupApiServiceUnavailableErrorException::class,
        ExpediaGroupApiGatewayTimeoutErrorException::class
    )
    @JvmOverloads
    @Deprecated("Use execute method instead", ReplaceWith("execute(operation: ScreenAccountOperation)"))
    fun screenAccount(accountScreenRequest: AccountScreenRequest): AccountScreenResponse {
        return screenAccountWithResponse(accountScreenRequest).data
    }

    /**
     * Run fraud screening for one transaction
     * The Account Screen API gives a Fraud recommendation for an account transaction. A recommendation can be ACCEPT, CHALLENGE, or REJECT. A transaction is marked as CHALLENGE whenever there are insufficient signals to recommend ACCEPT or REJECT. These CHALLENGE incidents are manually reviewed, and a corrected recommendation is made asynchronously.
     * @param accountScreenRequest
     * @throws ExpediaGroupApiAccountTakeoverBadRequestErrorException
     * @throws ExpediaGroupApiAccountTakeoverUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiServiceUnavailableErrorException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return a [Response] object with a body of type AccountScreenResponse
     */
    @Throws(
        ExpediaGroupApiAccountTakeoverBadRequestErrorException::class,
        ExpediaGroupApiAccountTakeoverUnauthorizedErrorException::class,
        ExpediaGroupApiForbiddenErrorException::class,
        ExpediaGroupApiNotFoundErrorException::class,
        ExpediaGroupApiTooManyRequestsErrorException::class,
        ExpediaGroupApiInternalServerErrorException::class,
        ExpediaGroupApiBadGatewayErrorException::class,
        ExpediaGroupApiServiceUnavailableErrorException::class,
        ExpediaGroupApiGatewayTimeoutErrorException::class
    )
    @JvmOverloads
    @Deprecated("Use execute method instead", ReplaceWith("execute(operation: ScreenAccountOperation)"))
    fun screenAccountWithResponse(accountScreenRequest: AccountScreenRequest): Response<AccountScreenResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kscreenAccountWithResponse(accountScreenRequest)
            }.get()
        } catch (exception: Exception) {
            exception.handle()
        }
    }

    /**
     * Run fraud screening for one transaction
     * The Order Purchase API gives a Fraud recommendation for a transaction. A recommendation can be Accept, Reject, or Review. A transaction is marked as Review whenever there are insufficient signals to recommend Accept or Reject. These incidents are manually reviewed, and a corrected recommendation is made asynchronously.
     * @param operation [ScreenOrderPurchaseOperation]
     * @throws ExpediaGroupApiBadRequestErrorException
     * @throws ExpediaGroupApiUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiRetryableOrderPurchaseScreenFailureException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return a [Response] object with a body of type OrderPurchaseScreenResponse
     */
    fun execute(operation: ScreenOrderPurchaseOperation): Response<OrderPurchaseScreenResponse> {
        return execute<OrderPurchaseScreenRequest, OrderPurchaseScreenResponse>(operation)
    }

    private suspend inline fun kscreenOrderPurchaseWithResponse(orderPurchaseScreenRequest: OrderPurchaseScreenRequest): Response<OrderPurchaseScreenResponse> {
        val operation =
            ScreenOrderPurchaseOperation(
                requestBody = orderPurchaseScreenRequest
            )

        return execute(operation)
    }

    /**
     * Run fraud screening for one transaction
     * The Order Purchase API gives a Fraud recommendation for a transaction. A recommendation can be Accept, Reject, or Review. A transaction is marked as Review whenever there are insufficient signals to recommend Accept or Reject. These incidents are manually reviewed, and a corrected recommendation is made asynchronously.
     * @param orderPurchaseScreenRequest
     * @throws ExpediaGroupApiBadRequestErrorException
     * @throws ExpediaGroupApiUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiRetryableOrderPurchaseScreenFailureException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return OrderPurchaseScreenResponse
     */
    @Throws(
        ExpediaGroupApiBadRequestErrorException::class,
        ExpediaGroupApiUnauthorizedErrorException::class,
        ExpediaGroupApiForbiddenErrorException::class,
        ExpediaGroupApiNotFoundErrorException::class,
        ExpediaGroupApiTooManyRequestsErrorException::class,
        ExpediaGroupApiInternalServerErrorException::class,
        ExpediaGroupApiBadGatewayErrorException::class,
        ExpediaGroupApiRetryableOrderPurchaseScreenFailureException::class,
        ExpediaGroupApiGatewayTimeoutErrorException::class
    )
    @JvmOverloads
    @Deprecated("Use execute method instead", ReplaceWith("execute(operation: ScreenOrderPurchaseOperation)"))
    fun screenOrderPurchase(orderPurchaseScreenRequest: OrderPurchaseScreenRequest): OrderPurchaseScreenResponse {
        return screenOrderPurchaseWithResponse(orderPurchaseScreenRequest).data
    }

    /**
     * Run fraud screening for one transaction
     * The Order Purchase API gives a Fraud recommendation for a transaction. A recommendation can be Accept, Reject, or Review. A transaction is marked as Review whenever there are insufficient signals to recommend Accept or Reject. These incidents are manually reviewed, and a corrected recommendation is made asynchronously.
     * @param orderPurchaseScreenRequest
     * @throws ExpediaGroupApiBadRequestErrorException
     * @throws ExpediaGroupApiUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiRetryableOrderPurchaseScreenFailureException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return a [Response] object with a body of type OrderPurchaseScreenResponse
     */
    @Throws(
        ExpediaGroupApiBadRequestErrorException::class,
        ExpediaGroupApiUnauthorizedErrorException::class,
        ExpediaGroupApiForbiddenErrorException::class,
        ExpediaGroupApiNotFoundErrorException::class,
        ExpediaGroupApiTooManyRequestsErrorException::class,
        ExpediaGroupApiInternalServerErrorException::class,
        ExpediaGroupApiBadGatewayErrorException::class,
        ExpediaGroupApiRetryableOrderPurchaseScreenFailureException::class,
        ExpediaGroupApiGatewayTimeoutErrorException::class
    )
    @JvmOverloads
    @Deprecated("Use execute method instead", ReplaceWith("execute(operation: ScreenOrderPurchaseOperation)"))
    fun screenOrderPurchaseWithResponse(orderPurchaseScreenRequest: OrderPurchaseScreenRequest): Response<OrderPurchaseScreenResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kscreenOrderPurchaseWithResponse(orderPurchaseScreenRequest)
            }.get()
        } catch (exception: Exception) {
            exception.handle()
        }
    }

    /**
     * Send an update as a result of an account screen transaction
     * The Account Update API is called when there is an account lifecycle transition such as a challenge outcome, account restoration, or remediation action completion. For example, if a user's account is disabled, deleted, or restored, the Account Update API is called to notify Expedia Group about the change. The Account Update API is also called when a user responds to a login Multi-Factor Authentication based on a Fraud recommendation.
     * @param operation [UpdateAccountOperation]
     * @throws ExpediaGroupApiAccountTakeoverBadRequestErrorException
     * @throws ExpediaGroupApiAccountTakeoverUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiAccountUpdateNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiServiceUnavailableErrorException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return a [Response] object with a body of type AccountUpdateResponse
     */
    fun execute(operation: UpdateAccountOperation): Response<AccountUpdateResponse> {
        return execute<AccountUpdateRequest, AccountUpdateResponse>(operation)
    }

    private suspend inline fun kupdateAccountWithResponse(accountUpdateRequest: AccountUpdateRequest): Response<AccountUpdateResponse> {
        val operation =
            UpdateAccountOperation(
                requestBody = accountUpdateRequest
            )

        return execute(operation)
    }

    /**
     * Send an update as a result of an account screen transaction
     * The Account Update API is called when there is an account lifecycle transition such as a challenge outcome, account restoration, or remediation action completion. For example, if a user's account is disabled, deleted, or restored, the Account Update API is called to notify Expedia Group about the change. The Account Update API is also called when a user responds to a login Multi-Factor Authentication based on a Fraud recommendation.
     * @param accountUpdateRequest An AccountUpdate request may be of one of the following types `MULTI_FACTOR_AUTHENTICATION_UPDATE`, `REMEDIATION_UPDATE`.
     * @throws ExpediaGroupApiAccountTakeoverBadRequestErrorException
     * @throws ExpediaGroupApiAccountTakeoverUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiAccountUpdateNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiServiceUnavailableErrorException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return AccountUpdateResponse
     */
    @Throws(
        ExpediaGroupApiAccountTakeoverBadRequestErrorException::class,
        ExpediaGroupApiAccountTakeoverUnauthorizedErrorException::class,
        ExpediaGroupApiForbiddenErrorException::class,
        ExpediaGroupApiAccountUpdateNotFoundErrorException::class,
        ExpediaGroupApiTooManyRequestsErrorException::class,
        ExpediaGroupApiInternalServerErrorException::class,
        ExpediaGroupApiBadGatewayErrorException::class,
        ExpediaGroupApiServiceUnavailableErrorException::class,
        ExpediaGroupApiGatewayTimeoutErrorException::class
    )
    @JvmOverloads
    @Deprecated("Use execute method instead", ReplaceWith("execute(operation: UpdateAccountOperation)"))
    fun updateAccount(accountUpdateRequest: AccountUpdateRequest): AccountUpdateResponse {
        return updateAccountWithResponse(accountUpdateRequest).data
    }

    /**
     * Send an update as a result of an account screen transaction
     * The Account Update API is called when there is an account lifecycle transition such as a challenge outcome, account restoration, or remediation action completion. For example, if a user's account is disabled, deleted, or restored, the Account Update API is called to notify Expedia Group about the change. The Account Update API is also called when a user responds to a login Multi-Factor Authentication based on a Fraud recommendation.
     * @param accountUpdateRequest An AccountUpdate request may be of one of the following types `MULTI_FACTOR_AUTHENTICATION_UPDATE`, `REMEDIATION_UPDATE`.
     * @throws ExpediaGroupApiAccountTakeoverBadRequestErrorException
     * @throws ExpediaGroupApiAccountTakeoverUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiAccountUpdateNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiServiceUnavailableErrorException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return a [Response] object with a body of type AccountUpdateResponse
     */
    @Throws(
        ExpediaGroupApiAccountTakeoverBadRequestErrorException::class,
        ExpediaGroupApiAccountTakeoverUnauthorizedErrorException::class,
        ExpediaGroupApiForbiddenErrorException::class,
        ExpediaGroupApiAccountUpdateNotFoundErrorException::class,
        ExpediaGroupApiTooManyRequestsErrorException::class,
        ExpediaGroupApiInternalServerErrorException::class,
        ExpediaGroupApiBadGatewayErrorException::class,
        ExpediaGroupApiServiceUnavailableErrorException::class,
        ExpediaGroupApiGatewayTimeoutErrorException::class
    )
    @JvmOverloads
    @Deprecated("Use execute method instead", ReplaceWith("execute(operation: UpdateAccountOperation)"))
    fun updateAccountWithResponse(accountUpdateRequest: AccountUpdateRequest): Response<AccountUpdateResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kupdateAccountWithResponse(accountUpdateRequest)
            }.get()
        } catch (exception: Exception) {
            exception.handle()
        }
    }

    /**
     * Send an update for a transaction
     * The Order Purchase Update API is called when the status of the order has changed.  For example, if the customer cancels the reservation, changes reservation in any way, or adds additional products or travelers to the reservation, the Order Purchase Update API is called to notify Expedia Group about the change.  The Order Purchase Update API is also called when the merchant cancels or changes an order based on a Fraud recommendation.
     * @param operation [UpdateOrderPurchaseOperation]
     * @throws ExpediaGroupApiBadRequestErrorException
     * @throws ExpediaGroupApiUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiOrderPurchaseUpdateNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiRetryableOrderPurchaseUpdateFailureException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return a [Response] object with a body of type OrderPurchaseUpdateResponse
     */
    fun execute(operation: UpdateOrderPurchaseOperation): Response<OrderPurchaseUpdateResponse> {
        return execute<OrderPurchaseUpdateRequest, OrderPurchaseUpdateResponse>(operation)
    }

    private suspend inline fun kupdateOrderPurchaseWithResponse(orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest): Response<OrderPurchaseUpdateResponse> {
        val operation =
            UpdateOrderPurchaseOperation(
                requestBody = orderPurchaseUpdateRequest
            )

        return execute(operation)
    }

    /**
     * Send an update for a transaction
     * The Order Purchase Update API is called when the status of the order has changed.  For example, if the customer cancels the reservation, changes reservation in any way, or adds additional products or travelers to the reservation, the Order Purchase Update API is called to notify Expedia Group about the change.  The Order Purchase Update API is also called when the merchant cancels or changes an order based on a Fraud recommendation.
     * @param orderPurchaseUpdateRequest An OrderPurchaseUpdate request may be of one of the following types `ORDER_UPDATE`, `CHARGEBACK_FEEDBACK`, `INSULT_FEEDBACK`, `REFUND_UPDATE`, `PAYMENT_UPDATE`.
     * @throws ExpediaGroupApiBadRequestErrorException
     * @throws ExpediaGroupApiUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiOrderPurchaseUpdateNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiRetryableOrderPurchaseUpdateFailureException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return OrderPurchaseUpdateResponse
     */
    @Throws(
        ExpediaGroupApiBadRequestErrorException::class,
        ExpediaGroupApiUnauthorizedErrorException::class,
        ExpediaGroupApiForbiddenErrorException::class,
        ExpediaGroupApiOrderPurchaseUpdateNotFoundErrorException::class,
        ExpediaGroupApiTooManyRequestsErrorException::class,
        ExpediaGroupApiInternalServerErrorException::class,
        ExpediaGroupApiBadGatewayErrorException::class,
        ExpediaGroupApiRetryableOrderPurchaseUpdateFailureException::class,
        ExpediaGroupApiGatewayTimeoutErrorException::class
    )
    @JvmOverloads
    @Deprecated("Use execute method instead", ReplaceWith("execute(operation: UpdateOrderPurchaseOperation)"))
    fun updateOrderPurchase(orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest): OrderPurchaseUpdateResponse {
        return updateOrderPurchaseWithResponse(orderPurchaseUpdateRequest).data
    }

    /**
     * Send an update for a transaction
     * The Order Purchase Update API is called when the status of the order has changed.  For example, if the customer cancels the reservation, changes reservation in any way, or adds additional products or travelers to the reservation, the Order Purchase Update API is called to notify Expedia Group about the change.  The Order Purchase Update API is also called when the merchant cancels or changes an order based on a Fraud recommendation.
     * @param orderPurchaseUpdateRequest An OrderPurchaseUpdate request may be of one of the following types `ORDER_UPDATE`, `CHARGEBACK_FEEDBACK`, `INSULT_FEEDBACK`, `REFUND_UPDATE`, `PAYMENT_UPDATE`.
     * @throws ExpediaGroupApiBadRequestErrorException
     * @throws ExpediaGroupApiUnauthorizedErrorException
     * @throws ExpediaGroupApiForbiddenErrorException
     * @throws ExpediaGroupApiOrderPurchaseUpdateNotFoundErrorException
     * @throws ExpediaGroupApiTooManyRequestsErrorException
     * @throws ExpediaGroupApiInternalServerErrorException
     * @throws ExpediaGroupApiBadGatewayErrorException
     * @throws ExpediaGroupApiRetryableOrderPurchaseUpdateFailureException
     * @throws ExpediaGroupApiGatewayTimeoutErrorException
     * @return a [Response] object with a body of type OrderPurchaseUpdateResponse
     */
    @Throws(
        ExpediaGroupApiBadRequestErrorException::class,
        ExpediaGroupApiUnauthorizedErrorException::class,
        ExpediaGroupApiForbiddenErrorException::class,
        ExpediaGroupApiOrderPurchaseUpdateNotFoundErrorException::class,
        ExpediaGroupApiTooManyRequestsErrorException::class,
        ExpediaGroupApiInternalServerErrorException::class,
        ExpediaGroupApiBadGatewayErrorException::class,
        ExpediaGroupApiRetryableOrderPurchaseUpdateFailureException::class,
        ExpediaGroupApiGatewayTimeoutErrorException::class
    )
    @JvmOverloads
    @Deprecated("Use execute method instead", ReplaceWith("execute(operation: UpdateOrderPurchaseOperation)"))
    fun updateOrderPurchaseWithResponse(orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest): Response<OrderPurchaseUpdateResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kupdateOrderPurchaseWithResponse(orderPurchaseUpdateRequest)
            }.get()
        } catch (exception: Exception) {
            exception.handle()
        }
    }
}
