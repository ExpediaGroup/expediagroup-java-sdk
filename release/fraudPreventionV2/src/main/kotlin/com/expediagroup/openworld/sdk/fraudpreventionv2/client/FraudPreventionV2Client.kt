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

package com.expediagroup.openworld.sdk.fraudpreventionv2.client

import kotlinx.coroutines.runBlocking
import java.util.stream.Collectors
import kotlin.collections.Map.Entry

import com.expediagroup.openworld.sdk.fraudpreventionv2.models.BadGatewayError
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.BadRequestError
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.ForbiddenError
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.GatewayTimeoutError
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.InternalServerError
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.NotFoundError
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.OrderPurchaseScreenRequest
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.OrderPurchaseScreenResponse
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.OrderPurchaseUpdateNotFoundError
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.OrderPurchaseUpdateRequest
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.OrderPurchaseUpdateResponse
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.ServiceUnavailableError
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.TooManyRequestsError
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.UnauthorizedError
import com.expediagroup.openworld.sdk.fraudpreventionv2.validation.PropertyConstraintsValidator.validateConstraints

import com.expediagroup.openworld.sdk.core.client.OpenWorldClient
import com.expediagroup.openworld.sdk.core.config.provider.FileConfigurationProvider
import com.expediagroup.openworld.sdk.core.configuration.OpenWorldClientConfiguration
import com.expediagroup.openworld.sdk.core.model.exception.OpenWorldException
import com.expediagroup.openworld.sdk.core.model.exception.service.OpenWorldServiceException

import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.ContentType
import io.ktor.http.ParametersBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import java.util.UUID

/**
* 
*/
 class FraudPreventionV2Client private constructor(clientConfiguration: OpenWorldClientConfiguration) : OpenWorldClient(clientConfiguration){
    private val loader = FileConfigurationProvider()[javaClass.classLoader.getResource("sdk.properties")!!]
    private val javaVersion = System.getProperty("java.version")
    private val operatingSystemName = System.getProperty("os.name")
    private val operatingSystemVersion = System.getProperty("os.version")
    private val userAgent = "open-world-sdk-java-fraudpreventionv2/${loader.data()["sdk-version"]!!} (Java $javaVersion; $operatingSystemName $operatingSystemVersion)"

    class Builder : OpenWorldClient.Builder<Builder>() {
        override fun build(): FraudPreventionV2Client = FraudPreventionV2Client(
            OpenWorldClientConfiguration(key, secret, endpoint, requestTimeout , authEndpoint)
        )
    }

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    private fun HttpRequestBuilder.appendHeaders(transactionId: UUID) {
        headers.append("x-sdk-title", loader.data()["sdk-title"]!!)
        headers.append("transaction-id", transactionId.toString())
        headers.append("User-agent", userAgent)
    }

    override suspend fun throwServiceException(response: HttpResponse) {
        runCatching {
            response.body<Error>()
        }.getOrThrow().let {
            throw OpenWorldServiceException(it.toString())
        }
    }

    private suspend inline fun kscreen(orderPurchaseScreenRequest: OrderPurchaseScreenRequest, transactionId: UUID = UUID.randomUUID()): OrderPurchaseScreenResponse {
        return kscreenWithResponse(orderPurchaseScreenRequest, transactionId).body
    }

    private suspend inline fun kscreenWithResponse(orderPurchaseScreenRequest: OrderPurchaseScreenRequest, transactionId: UUID = UUID.randomUUID()): Response<OrderPurchaseScreenResponse> {
        val response = httpClient.request {
            method = HttpMethod.parse("POST")
            url("fraud-prevention/v2/order/purchase/screen")
            appendHeaders(transactionId)
            validateConstraints(orderPurchaseScreenRequest)
            contentType(ContentType.Application.Json)
            setBody(orderPurchaseScreenRequest)
        }
        throwIfError(response)
        return Response(response.body<OrderPurchaseScreenResponse>(), toHeadersMap(response.headers.entries()))
    }

    /**
    * Run fraud screening for one transaction
    * The Order Purchase API gives a Fraud recommendation for a transaction. A recommendation can be Accept, Reject, or Review. A transaction is marked as Review whenever there are insufficient signals to recommend Accept or Reject. These incidents are manually reviewed, and a corrected recommendation is made asynchronously. 
     * @param orderPurchaseScreenRequest 
     * @return OrderPurchaseScreenResponse
    */
    @JvmOverloads
    fun screen(orderPurchaseScreenRequest: OrderPurchaseScreenRequest, transactionId: UUID = UUID.randomUUID()) : OrderPurchaseScreenResponse {
        return screenWithResponse(orderPurchaseScreenRequest, transactionId).body
    }

    private fun screenWithResponse(orderPurchaseScreenRequest: OrderPurchaseScreenRequest, transactionId: UUID = UUID.randomUUID()) : Response<OrderPurchaseScreenResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kscreenWithResponse(orderPurchaseScreenRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            if (exception is OpenWorldException) throw exception

            when (val cause = exception.cause) {
                is OpenWorldException -> throw cause
                else -> throw OpenWorldException("OpenWorld Error", exception)
            }
        }
    }
    private suspend inline fun kupdate(orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest, transactionId: UUID = UUID.randomUUID()): OrderPurchaseUpdateResponse {
        return kupdateWithResponse(orderPurchaseUpdateRequest, transactionId).body
    }

    private suspend inline fun kupdateWithResponse(orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest, transactionId: UUID = UUID.randomUUID()): Response<OrderPurchaseUpdateResponse> {
        val response = httpClient.request {
            method = HttpMethod.parse("POST")
            url("fraud-prevention/v2/order/purchase/update")
            appendHeaders(transactionId)
            validateConstraints(orderPurchaseUpdateRequest)
            contentType(ContentType.Application.Json)
            setBody(orderPurchaseUpdateRequest)
        }
        throwIfError(response)
        return Response(response.body<OrderPurchaseUpdateResponse>(), toHeadersMap(response.headers.entries()))
    }

    /**
    * Send an update for a transaction
    * The Order Purchase Update API is called when the status of the order has changed.  For example, if the customer cancels the reservation, changes reservation in any way, or adds additional products or travelers to the reservation, the Order Purchase Update API is called to notify Expedia Group about the change.  The Order Purchase Update API is also called when the merchant cancels or changes an order based on a Fraud recommendation. 
     * @param orderPurchaseUpdateRequest An OrderPurchaseUpdate request may be of one of the following types &#x60;ORDER_UPDATE&#x60;, &#x60;CHARGEBACK_FEEDBACK&#x60;, &#x60;INSULT_FEEDBACK&#x60;, &#x60;REFUND_UPDATE&#x60;, &#x60;PAYMENT_UPDATE&#x60;. 
     * @return OrderPurchaseUpdateResponse
    */
    @JvmOverloads
    fun update(orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest, transactionId: UUID = UUID.randomUUID()) : OrderPurchaseUpdateResponse {
        return updateWithResponse(orderPurchaseUpdateRequest, transactionId).body
    }

    private fun updateWithResponse(orderPurchaseUpdateRequest: OrderPurchaseUpdateRequest, transactionId: UUID = UUID.randomUUID()) : Response<OrderPurchaseUpdateResponse> {
        try {
            return GlobalScope.future(Dispatchers.IO) {
                kupdateWithResponse(orderPurchaseUpdateRequest, transactionId)
            }.get()
        } catch (exception: Exception) {
            if (exception is OpenWorldException) throw exception

            when (val cause = exception.cause) {
                is OpenWorldException -> throw cause
                else -> throw OpenWorldException("OpenWorld Error", exception)
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
        fun <T> getState(link: String?, client: FraudPreventionV2Client, getBody: suspend (HttpResponse) -> T): ResponseState<T> {
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
