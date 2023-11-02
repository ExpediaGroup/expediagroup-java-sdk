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
import com.expediagroup.sdk.core.model.Properties
import com.expediagroup.sdk.core.model.exception.ExpediaGroupException
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
import io.ktor.client.request.HttpRequestBuilder
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
import kotlinx.coroutines.runBlocking
import java.util.UUID
import java.util.stream.Collectors
import kotlin.collections.Map.Entry

/**
*
*/
class FraudPreventionV2Client private constructor(clientConfiguration: ExpediaGroupClientConfiguration) : ExpediaGroupClient(clientConfiguration) {
    private val properties = Properties.from(javaClass.classLoader.getResource("sdk.properties")!!)
    private val javaVersion = System.getProperty("java.version")
    private val operatingSystemName = System.getProperty("os.name")
    private val operatingSystemVersion = System.getProperty("os.version")
    private val userAgent = "expediagroup-sdk-java-fraudpreventionv2/${properties["sdk-version"]!!} (Java $javaVersion; $operatingSystemName $operatingSystemVersion)"

    class Builder : ExpediaGroupClient.Builder<Builder>() {
        override fun build(): FraudPreventionV2Client =
            FraudPreventionV2Client(
                ExpediaGroupClientConfiguration(key, secret, endpoint, requestTimeout, maskedLoggingHeaders, maskedLoggingBodyFields, authEndpoint)
            )
    }

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    private fun HttpRequestBuilder.appendHeaders(transactionId: UUID) {
        headers.append("x-sdk-title", properties["sdk-title"]!!)
        headers.append("transaction-id", transactionId.toString())
        headers.append("User-agent", userAgent)
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
        return Response(response.body<AccountUpdateResponse>(), toHeadersMap(response.headers.entries()))
    }

    /**
     * Send an update as a result of an account screen transaction
     * The Account Update API is called when there is an account lifecycle transition such as a challenge outcome, account restoration, or remediation action completion. For example, if a user&#39;s account is disabled, deleted, or restored, the Account Update API is called to notify Expedia Group about the change. The Account Update API is also called when a user responds to a login Multi-Factor Authentication based on a Fraud recommendation.
     * @param accountUpdateRequest An AccountUpdate request may be of one of the following types &#x60;MULTI_FACTOR_AUTHENTICATION_UPDATE&#x60;, &#x60;REMEDIATION_UPDATE&#x60;.

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

    private fun notifyWithAccountUpdateWithResponse(
        accountUpdateRequest: AccountUpdateRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<AccountUpdateResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                knotifyWithAccountUpdateWithResponse(accountUpdateRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            if (exception is ExpediaGroupException) throw exception

            when (val cause = exception.cause) {
                is ExpediaGroupException -> throw cause
                else -> throw ExpediaGroupException("ExpediaGroup Error", exception)
            }
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
        return Response(response.body<OrderPurchaseUpdateResponse>(), toHeadersMap(response.headers.entries()))
    }

    /**
     * Send an update for a transaction
     * The Order Purchase Update API is called when the status of the order has changed.  For example, if the customer cancels the reservation, changes reservation in any way, or adds additional products or travelers to the reservation, the Order Purchase Update API is called to notify Expedia Group about the change.  The Order Purchase Update API is also called when the merchant cancels or changes an order based on a Fraud recommendation.
     * @param orderPurchaseUpdateRequest An OrderPurchaseUpdate request may be of one of the following types &#x60;ORDER_UPDATE&#x60;, &#x60;CHARGEBACK_FEEDBACK&#x60;, &#x60;INSULT_FEEDBACK&#x60;, &#x60;REFUND_UPDATE&#x60;, &#x60;PAYMENT_UPDATE&#x60;.

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

    private fun notifyWithOrderUpdateWithResponse(
        orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<OrderPurchaseUpdateResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                knotifyWithOrderUpdateWithResponse(orderPurchaseUpdateRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            if (exception is ExpediaGroupException) throw exception

            when (val cause = exception.cause) {
                is ExpediaGroupException -> throw cause
                else -> throw ExpediaGroupException("ExpediaGroup Error", exception)
            }
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
        return Response(response.body<AccountScreenResponse>(), toHeadersMap(response.headers.entries()))
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
    fun screenAccount(
        accountScreenRequest: AccountScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): AccountScreenResponse {
        return screenAccountWithResponse(accountScreenRequest, transactionId).body
    }

    private fun screenAccountWithResponse(
        accountScreenRequest: AccountScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<AccountScreenResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kscreenAccountWithResponse(accountScreenRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            if (exception is ExpediaGroupException) throw exception

            when (val cause = exception.cause) {
                is ExpediaGroupException -> throw cause
                else -> throw ExpediaGroupException("ExpediaGroup Error", exception)
            }
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
        return Response(response.body<OrderPurchaseScreenResponse>(), toHeadersMap(response.headers.entries()))
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
    fun screenOrder(
        orderPurchaseScreenRequest: OrderPurchaseScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): OrderPurchaseScreenResponse {
        return screenOrderWithResponse(orderPurchaseScreenRequest, transactionId).body
    }

    private fun screenOrderWithResponse(
        orderPurchaseScreenRequest: OrderPurchaseScreenRequest,
        transactionId: UUID = UUID.randomUUID()
    ): Response<OrderPurchaseScreenResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kscreenOrderWithResponse(orderPurchaseScreenRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            if (exception is ExpediaGroupException) throw exception

            when (val cause = exception.cause) {
                is ExpediaGroupException -> throw cause
                else -> throw ExpediaGroupException("ExpediaGroup Error", exception)
            }
        }
    }

    internal suspend fun getFromLink(link: String): HttpResponse {
        return httpClient.request {
            method = HttpMethod.parse("GET")
            url(link)
            appendHeaders(UUID.randomUUID())
        }
    }
}

class Paginator<T>(
    private val client: FraudPreventionV2Client,
    firstResponse: Response<T>,
    private val getBody: suspend (HttpResponse) -> T
) : Iterator<T> {
    private var state: ResponseState<T>
    val paginationTotalResults: Long?

    init {
        state = FirstResponseState(firstResponse)
        paginationTotalResults = extractPaginationTotalResults(firstResponse.headers)
    }

    override fun hasNext(): Boolean {
        return state.hasNext()
    }

    override fun next(): T {
        val response = state.getNextResponse()
        state = ResponseStateFactory.getState(extractLink(response.headers), client, getBody)
        return response.body
    }

    private fun extractPaginationTotalResults(headers: Map<String, List<String>>): Long? {
        return headers["pagination-total-results"]?.getOrNull(0)?.toLongOrNull()
    }

    private fun extractLink(headers: Map<String, List<String>>): String? {
        return headers["link"]?.getOrNull(0)?.split(";")?.let {
            if (it.isNotEmpty()) it[0] else null
        }?.let {
            it.substring(it.indexOf("<") + 1, it.indexOf(">"))
        }
    }
}

internal class FirstResponseState<T>(
    private val response: Response<T>
) : ResponseState<T> {
    override fun getNextResponse(): Response<T> {
        return response
    }

    override fun hasNext(): Boolean {
        return true
    }
}

internal class FetchLinkState<T>(
    private val link: String,
    private val client: FraudPreventionV2Client,
    private val getBody: suspend (HttpResponse) -> T
) : ResponseState<T> {
    override fun getNextResponse(): Response<T> {
        return runBlocking {
            val response = client.getFromLink(link)
            val body = getBody(response)
            Response(body, toHeadersMap(response.headers.entries()))
        }
    }

    override fun hasNext(): Boolean {
        return true
    }
}

internal class LastResponseState<T> : ResponseState<T> {
    override fun getNextResponse(): Response<T> {
        throw NoSuchElementException()
    }

    override fun hasNext(): Boolean {
        return false
    }
}

internal class ResponseStateFactory {
    companion object {
        fun <T> getState(
            link: String?,
            client: FraudPreventionV2Client,
            getBody: suspend (HttpResponse) -> T
        ): ResponseState<T> {
            return link?.let { FetchLinkState(it, client, getBody) } ?: LastResponseState()
        }
    }
}

internal interface ResponseState<T> {
    fun getNextResponse(): Response<T>

    fun hasNext(): Boolean
}

data class Response<T>(val body: T, val headers: Map<String, List<String>>)

internal fun toHeadersMap(entries: Set<Entry<String, List<String>>>): Map<String, List<String>> {
    return entries.stream().collect(
        Collectors.toMap(
            Entry<String, List<String>>::key,
            Entry<String, List<String>>::value
        )
    )
}
