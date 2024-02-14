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
import com.expediagroup.sdk.core.model.Response
import com.expediagroup.sdk.core.model.exception.handle
import com.expediagroup.sdk.fraudpreventionv2.models.AccountScreenRequest
import com.expediagroup.sdk.fraudpreventionv2.models.AccountScreenResponse
import com.expediagroup.sdk.fraudpreventionv2.models.AccountUpdateRequest
import com.expediagroup.sdk.fraudpreventionv2.models.AccountUpdateResponse
import com.expediagroup.sdk.fraudpreventionv2.models.OrderPurchaseScreenRequest
import com.expediagroup.sdk.fraudpreventionv2.models.OrderPurchaseScreenResponse
import com.expediagroup.sdk.fraudpreventionv2.models.OrderPurchaseUpdateRequest
import com.expediagroup.sdk.fraudpreventionv2.models.OrderPurchaseUpdateResponse
import com.expediagroup.sdk.fraudpreventionv2.models.exception.*
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
import java.util.UUID

/**
*
*/
class FraudPreventionV2Client private constructor(clientConfiguration: ExpediaGroupClientConfiguration) : ExpediaGroupClient("fraudpreventionv2", clientConfiguration) {

    class Builder : ExpediaGroupClient.Builder<Builder>() {
        override fun build(): FraudPreventionV2Client =
            FraudPreventionV2Client(
                ExpediaGroupClientConfiguration(key, secret, endpoint, requestTimeout, maskedLoggingHeaders, maskedLoggingBodyFields, authEndpoint)
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

    private suspend inline fun knotifyWithAccountUpdate(
        accountUpdateRequest: AccountUpdateRequest,
        transactionId: UUID = UUID.randomUUID()
    ): AccountUpdateResponse {
        return knotifyWithAccountUpdateWithResponse(accountUpdateRequest, transactionId).body
    }

    private suspend inline fun knotifyWithAccountUpdateWithResponse(
        accountUpdateRequest: AccountUpdateRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<AccountUpdateResponse> {
        val response =
            httpClient.request {
                method = HttpMethod.parse("POST")
                url("fraud-prevention/v2/account/update")
                appendHeaders(transactionId)
                validateConstraints(accountUpdateRequest)
                contentType(ContentType.Application.Json)
                setBody(accountUpdateRequest)
            }
        throwIfError(response, "notifyWithAccountUpdate")
        return Response(response.status.value, response.body<AccountUpdateResponse>(), response.headers.entries())
    }

    /**
     * Send an update as a result of an account screen transaction
     * The Account Update API is called when there is an account lifecycle transition such as a challenge outcome, account restoration, or remediation action completion. For example, if a user's account is disabled, deleted, or restored, the Account Update API is called to notify Expedia Group about the change. The Account Update API is also called when a user responds to a login Multi-Factor Authentication based on a Fraud recommendation.
     * @param accountUpdateRequest An AccountUpdate request may be of one of the following types `MULTI_FACTOR_AUTHENTICATION_UPDATE`, `REMEDIATION_UPDATE`.
     * @param transactionId The transaction id for the request (optional, defaults to a new UUID)
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
    fun notifyWithAccountUpdate(
        accountUpdateRequest: AccountUpdateRequest,
        transactionId: UUID = UUID.randomUUID()
    ): AccountUpdateResponse {
        return notifyWithAccountUpdateWithResponse(accountUpdateRequest, transactionId).body
    }

    /**
     * Send an update as a result of an account screen transaction
     * The Account Update API is called when there is an account lifecycle transition such as a challenge outcome, account restoration, or remediation action completion. For example, if a user's account is disabled, deleted, or restored, the Account Update API is called to notify Expedia Group about the change. The Account Update API is also called when a user responds to a login Multi-Factor Authentication based on a Fraud recommendation.
     * @param accountUpdateRequest An AccountUpdate request may be of one of the following types `MULTI_FACTOR_AUTHENTICATION_UPDATE`, `REMEDIATION_UPDATE`.
     * @param transactionId The transaction id for the request (optional, defaults to a new UUID)
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
    fun notifyWithAccountUpdateWithResponse(
        accountUpdateRequest: AccountUpdateRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<AccountUpdateResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                knotifyWithAccountUpdateWithResponse(accountUpdateRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            exception.handle()
        }
    }

    private suspend inline fun knotifyWithOrderUpdate(
        orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest,
        transactionId: UUID = UUID.randomUUID()
    ): OrderPurchaseUpdateResponse {
        return knotifyWithOrderUpdateWithResponse(orderPurchaseUpdateRequest, transactionId).body
    }

    private suspend inline fun knotifyWithOrderUpdateWithResponse(
        orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<OrderPurchaseUpdateResponse> {
        val response =
            httpClient.request {
                method = HttpMethod.parse("POST")
                url("fraud-prevention/v2/order/purchase/update")
                appendHeaders(transactionId)
                validateConstraints(orderPurchaseUpdateRequest)
                contentType(ContentType.Application.Json)
                setBody(orderPurchaseUpdateRequest)
            }
        throwIfError(response, "notifyWithOrderUpdate")
        return Response(response.status.value, response.body<OrderPurchaseUpdateResponse>(), response.headers.entries())
    }

    /**
     * Send an update for a transaction
     * The Order Purchase Update API is called when the status of the order has changed.  For example, if the customer cancels the reservation, changes reservation in any way, or adds additional products or travelers to the reservation, the Order Purchase Update API is called to notify Expedia Group about the change.  The Order Purchase Update API is also called when the merchant cancels or changes an order based on a Fraud recommendation.
     * @param orderPurchaseUpdateRequest An OrderPurchaseUpdate request may be of one of the following types `ORDER_UPDATE`, `CHARGEBACK_FEEDBACK`, `INSULT_FEEDBACK`, `REFUND_UPDATE`, `PAYMENT_UPDATE`.
     * @param transactionId The transaction id for the request (optional, defaults to a new UUID)
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
    fun notifyWithOrderUpdate(
        orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest,
        transactionId: UUID = UUID.randomUUID()
    ): OrderPurchaseUpdateResponse {
        return notifyWithOrderUpdateWithResponse(orderPurchaseUpdateRequest, transactionId).body
    }

    /**
     * Send an update for a transaction
     * The Order Purchase Update API is called when the status of the order has changed.  For example, if the customer cancels the reservation, changes reservation in any way, or adds additional products or travelers to the reservation, the Order Purchase Update API is called to notify Expedia Group about the change.  The Order Purchase Update API is also called when the merchant cancels or changes an order based on a Fraud recommendation.
     * @param orderPurchaseUpdateRequest An OrderPurchaseUpdate request may be of one of the following types `ORDER_UPDATE`, `CHARGEBACK_FEEDBACK`, `INSULT_FEEDBACK`, `REFUND_UPDATE`, `PAYMENT_UPDATE`.
     * @param transactionId The transaction id for the request (optional, defaults to a new UUID)
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
    fun notifyWithOrderUpdateWithResponse(
        orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<OrderPurchaseUpdateResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                knotifyWithOrderUpdateWithResponse(orderPurchaseUpdateRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            exception.handle()
        }
    }

    private suspend inline fun kscreenAccount(
        accountScreenRequest: AccountScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): AccountScreenResponse {
        return kscreenAccountWithResponse(accountScreenRequest, transactionId).body
    }

    private suspend inline fun kscreenAccountWithResponse(
        accountScreenRequest: AccountScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<AccountScreenResponse> {
        val response =
            httpClient.request {
                method = HttpMethod.parse("POST")
                url("fraud-prevention/v2/account/screen")
                appendHeaders(transactionId)
                validateConstraints(accountScreenRequest)
                contentType(ContentType.Application.Json)
                setBody(accountScreenRequest)
            }
        throwIfError(response, "screenAccount")
        return Response(response.status.value, response.body<AccountScreenResponse>(), response.headers.entries())
    }

    /**
     * Run fraud screening for one transaction
     * The Account Screen API gives a Fraud recommendation for an account transaction. A recommendation can be ACCEPT, CHALLENGE, or REJECT. A transaction is marked as CHALLENGE whenever there are insufficient signals to recommend ACCEPT or REJECT. These CHALLENGE incidents are manually reviewed, and a corrected recommendation is made asynchronously.
     * @param accountScreenRequest
     * @param transactionId The transaction id for the request (optional, defaults to a new UUID)
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
    fun screenAccount(
        accountScreenRequest: AccountScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): AccountScreenResponse {
        return screenAccountWithResponse(accountScreenRequest, transactionId).body
    }

    /**
     * Run fraud screening for one transaction
     * The Account Screen API gives a Fraud recommendation for an account transaction. A recommendation can be ACCEPT, CHALLENGE, or REJECT. A transaction is marked as CHALLENGE whenever there are insufficient signals to recommend ACCEPT or REJECT. These CHALLENGE incidents are manually reviewed, and a corrected recommendation is made asynchronously.
     * @param accountScreenRequest
     * @param transactionId The transaction id for the request (optional, defaults to a new UUID)
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
    fun screenAccountWithResponse(
        accountScreenRequest: AccountScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<AccountScreenResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kscreenAccountWithResponse(accountScreenRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            exception.handle()
        }
    }

    private suspend inline fun kscreenOrder(
        orderPurchaseScreenRequest: OrderPurchaseScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): OrderPurchaseScreenResponse {
        return kscreenOrderWithResponse(orderPurchaseScreenRequest, transactionId).body
    }

    private suspend inline fun kscreenOrderWithResponse(
        orderPurchaseScreenRequest: OrderPurchaseScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<OrderPurchaseScreenResponse> {
        val response =
            httpClient.request {
                method = HttpMethod.parse("POST")
                url("fraud-prevention/v2/order/purchase/screen")
                appendHeaders(transactionId)
                validateConstraints(orderPurchaseScreenRequest)
                contentType(ContentType.Application.Json)
                setBody(orderPurchaseScreenRequest)
            }
        throwIfError(response, "screenOrder")
        return Response(response.status.value, response.body<OrderPurchaseScreenResponse>(), response.headers.entries())
    }

    /**
     * Run fraud screening for one transaction
     * The Order Purchase API gives a Fraud recommendation for a transaction. A recommendation can be Accept, Reject, or Review. A transaction is marked as Review whenever there are insufficient signals to recommend Accept or Reject. These incidents are manually reviewed, and a corrected recommendation is made asynchronously.
     * @param orderPurchaseScreenRequest
     * @param transactionId The transaction id for the request (optional, defaults to a new UUID)
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
    fun screenOrder(
        orderPurchaseScreenRequest: OrderPurchaseScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): OrderPurchaseScreenResponse {
        return screenOrderWithResponse(orderPurchaseScreenRequest, transactionId).body
    }

    /**
     * Run fraud screening for one transaction
     * The Order Purchase API gives a Fraud recommendation for a transaction. A recommendation can be Accept, Reject, or Review. A transaction is marked as Review whenever there are insufficient signals to recommend Accept or Reject. These incidents are manually reviewed, and a corrected recommendation is made asynchronously.
     * @param orderPurchaseScreenRequest
     * @param transactionId The transaction id for the request (optional, defaults to a new UUID)
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
    fun screenOrderWithResponse(
        orderPurchaseScreenRequest: OrderPurchaseScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<OrderPurchaseScreenResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kscreenOrderWithResponse(orderPurchaseScreenRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            exception.handle()
        }
    }
}
