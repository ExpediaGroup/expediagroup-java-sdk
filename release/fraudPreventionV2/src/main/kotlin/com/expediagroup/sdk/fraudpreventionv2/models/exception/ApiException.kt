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

package com.expediagroup.sdk.fraudpreventionv2.models.exception

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupApiException
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceDefaultErrorException
import com.expediagroup.sdk.core.model.getTransactionId
import com.expediagroup.sdk.fraudpreventionv2.models.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

internal open class HttpStatusCodeRange(
    private val statusCode: String,
    val getException: (HttpResponse) -> ExpediaGroupApiException
) : Comparable<HttpStatusCodeRange> {
    open fun matches(statusCode: String): Boolean = if (isRangeDefinition()) this.statusCode.first() == statusCode.first() else this.statusCode == statusCode

    open fun isRangeDefinition(): Boolean = statusCode.matches(Regex("^[1-5]XX$"))

    override fun compareTo(other: HttpStatusCodeRange): Int = (if (this.isRangeDefinition()) 1 else 0).compareTo(if (other.isRangeDefinition()) 1 else 0)
}

internal object DefaultHttpStatusCodeRange : HttpStatusCodeRange(
    "DefaultHttpStatusCodeRange",
    { ExpediaGroupServiceDefaultErrorException(it.status.value, runBlocking { it.bodyAsText() }, it.request.headers.getTransactionId()) }
) {
    override fun matches(statusCode: String): Boolean = true

    override fun isRangeDefinition(): Boolean = true
}

internal object ErrorObjectMapper {
    private val defaultHttpStatusCodeRanges = listOf(DefaultHttpStatusCodeRange)
    private val httpStatusCodeRanges: Map<String, List<HttpStatusCodeRange>> =
        mapOf(
            Pair(
                "screenAccount",
                listOf(
                    HttpStatusCodeRange(
                        "400"
                    ) {
                        ExpediaGroupApiAccountTakeoverBadRequestErrorException(
                            it.status.value,
                            fetchErrorObject(it) as AccountTakeoverBadRequestError,
                            it.headers.getTransactionId()
                        )
                    },
                    HttpStatusCodeRange(
                        "401"
                    ) {
                        ExpediaGroupApiAccountTakeoverUnauthorizedErrorException(
                            it.status.value,
                            fetchErrorObject(it) as AccountTakeoverUnauthorizedError,
                            it.headers.getTransactionId()
                        )
                    },
                    HttpStatusCodeRange("403") { ExpediaGroupApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange("404") { ExpediaGroupApiNotFoundErrorException(it.status.value, fetchErrorObject(it) as NotFoundError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "429"
                    ) { ExpediaGroupApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "500"
                    ) { ExpediaGroupApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange("502") { ExpediaGroupApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "503"
                    ) { ExpediaGroupApiServiceUnavailableErrorException(it.status.value, fetchErrorObject(it) as ServiceUnavailableError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "504"
                    ) { ExpediaGroupApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError, it.headers.getTransactionId()) },
                    DefaultHttpStatusCodeRange
                )
            ),
            Pair(
                "screenOrderPurchase",
                listOf(
                    HttpStatusCodeRange("400") { ExpediaGroupApiBadRequestErrorException(it.status.value, fetchErrorObject(it) as BadRequestError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "401"
                    ) { ExpediaGroupApiUnauthorizedErrorException(it.status.value, fetchErrorObject(it) as UnauthorizedError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange("403") { ExpediaGroupApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange("404") { ExpediaGroupApiNotFoundErrorException(it.status.value, fetchErrorObject(it) as NotFoundError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "429"
                    ) { ExpediaGroupApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "500"
                    ) { ExpediaGroupApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange("502") { ExpediaGroupApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "503"
                    ) {
                        ExpediaGroupApiRetryableOrderPurchaseScreenFailureException(
                            it.status.value,
                            fetchErrorObject(it) as RetryableOrderPurchaseScreenFailure,
                            it.headers.getTransactionId()
                        )
                    },
                    HttpStatusCodeRange(
                        "504"
                    ) { ExpediaGroupApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError, it.headers.getTransactionId()) },
                    DefaultHttpStatusCodeRange
                )
            ),
            Pair(
                "updateAccount",
                listOf(
                    HttpStatusCodeRange(
                        "400"
                    ) {
                        ExpediaGroupApiAccountTakeoverBadRequestErrorException(
                            it.status.value,
                            fetchErrorObject(it) as AccountTakeoverBadRequestError,
                            it.headers.getTransactionId()
                        )
                    },
                    HttpStatusCodeRange(
                        "401"
                    ) {
                        ExpediaGroupApiAccountTakeoverUnauthorizedErrorException(
                            it.status.value,
                            fetchErrorObject(it) as AccountTakeoverUnauthorizedError,
                            it.headers.getTransactionId()
                        )
                    },
                    HttpStatusCodeRange("403") { ExpediaGroupApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "404"
                    ) { ExpediaGroupApiAccountUpdateNotFoundErrorException(it.status.value, fetchErrorObject(it) as AccountUpdateNotFoundError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "429"
                    ) { ExpediaGroupApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "500"
                    ) { ExpediaGroupApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange("502") { ExpediaGroupApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "503"
                    ) { ExpediaGroupApiServiceUnavailableErrorException(it.status.value, fetchErrorObject(it) as ServiceUnavailableError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "504"
                    ) { ExpediaGroupApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError, it.headers.getTransactionId()) },
                    DefaultHttpStatusCodeRange
                )
            ),
            Pair(
                "updateOrderPurchase",
                listOf(
                    HttpStatusCodeRange("400") { ExpediaGroupApiBadRequestErrorException(it.status.value, fetchErrorObject(it) as BadRequestError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "401"
                    ) { ExpediaGroupApiUnauthorizedErrorException(it.status.value, fetchErrorObject(it) as UnauthorizedError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange("403") { ExpediaGroupApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "404"
                    ) {
                        ExpediaGroupApiOrderPurchaseUpdateNotFoundErrorException(
                            it.status.value,
                            fetchErrorObject(it) as OrderPurchaseUpdateNotFoundError,
                            it.headers.getTransactionId()
                        )
                    },
                    HttpStatusCodeRange(
                        "429"
                    ) { ExpediaGroupApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "500"
                    ) { ExpediaGroupApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange("502") { ExpediaGroupApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError, it.headers.getTransactionId()) },
                    HttpStatusCodeRange(
                        "503"
                    ) {
                        ExpediaGroupApiRetryableOrderPurchaseUpdateFailureException(
                            it.status.value,
                            fetchErrorObject(it) as RetryableOrderPurchaseUpdateFailure,
                            it.headers.getTransactionId()
                        )
                    },
                    HttpStatusCodeRange(
                        "504"
                    ) { ExpediaGroupApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError, it.headers.getTransactionId()) },
                    DefaultHttpStatusCodeRange
                )
            )
        )

    fun process(
        httpResponse: HttpResponse,
        operationId: String
    ): ExpediaGroupApiException =
        httpStatusCodeRanges.getOrDefault(operationId, defaultHttpStatusCodeRanges).filter { it.matches(httpResponse.status.value.toString()) }.min().getException(httpResponse)

    private inline fun <reified T> fetchErrorObject(httpResponse: HttpResponse): T =
        runBlocking {
            runCatching {
                httpResponse.body<T>()
            }.getOrElse { throw ExpediaGroupServiceDefaultErrorException(httpResponse.status.value, httpResponse.bodyAsText(), httpResponse.request.headers.getTransactionId()) }
        }
}

class ExpediaGroupApiAccountTakeoverBadRequestErrorException(code: Int, override val errorObject: AccountTakeoverBadRequestError, transactionId: String?) : ExpediaGroupApiException(
    code,
    errorObject,
    transactionId
)

class ExpediaGroupApiAccountTakeoverUnauthorizedErrorException(code: Int, override val errorObject: AccountTakeoverUnauthorizedError, transactionId: String?) : ExpediaGroupApiException(
    code,
    errorObject,
    transactionId
)

class ExpediaGroupApiForbiddenErrorException(code: Int, override val errorObject: ForbiddenError, transactionId: String?) : ExpediaGroupApiException(code, errorObject, transactionId)

class ExpediaGroupApiNotFoundErrorException(code: Int, override val errorObject: NotFoundError, transactionId: String?) : ExpediaGroupApiException(code, errorObject, transactionId)

class ExpediaGroupApiTooManyRequestsErrorException(code: Int, override val errorObject: TooManyRequestsError, transactionId: String?) : ExpediaGroupApiException(
    code,
    errorObject,
    transactionId
)

class ExpediaGroupApiInternalServerErrorException(code: Int, override val errorObject: InternalServerError, transactionId: String?) : ExpediaGroupApiException(code, errorObject, transactionId)

class ExpediaGroupApiBadGatewayErrorException(code: Int, override val errorObject: BadGatewayError, transactionId: String?) : ExpediaGroupApiException(code, errorObject, transactionId)

class ExpediaGroupApiServiceUnavailableErrorException(code: Int, override val errorObject: ServiceUnavailableError, transactionId: String?) : ExpediaGroupApiException(
    code,
    errorObject,
    transactionId
)

class ExpediaGroupApiGatewayTimeoutErrorException(code: Int, override val errorObject: GatewayTimeoutError, transactionId: String?) : ExpediaGroupApiException(code, errorObject, transactionId)

class ExpediaGroupApiBadRequestErrorException(code: Int, override val errorObject: BadRequestError, transactionId: String?) : ExpediaGroupApiException(code, errorObject, transactionId)

class ExpediaGroupApiUnauthorizedErrorException(code: Int, override val errorObject: UnauthorizedError, transactionId: String?) : ExpediaGroupApiException(code, errorObject, transactionId)

class ExpediaGroupApiRetryableOrderPurchaseScreenFailureException(code: Int, override val errorObject: RetryableOrderPurchaseScreenFailure, transactionId: String?) : ExpediaGroupApiException(
    code,
    errorObject,
    transactionId
)

class ExpediaGroupApiAccountUpdateNotFoundErrorException(code: Int, override val errorObject: AccountUpdateNotFoundError, transactionId: String?) : ExpediaGroupApiException(
    code,
    errorObject,
    transactionId
)

class ExpediaGroupApiOrderPurchaseUpdateNotFoundErrorException(code: Int, override val errorObject: OrderPurchaseUpdateNotFoundError, transactionId: String?) : ExpediaGroupApiException(
    code,
    errorObject,
    transactionId
)

class ExpediaGroupApiRetryableOrderPurchaseUpdateFailureException(code: Int, override val errorObject: RetryableOrderPurchaseUpdateFailure, transactionId: String?) : ExpediaGroupApiException(
    code,
    errorObject,
    transactionId
)
