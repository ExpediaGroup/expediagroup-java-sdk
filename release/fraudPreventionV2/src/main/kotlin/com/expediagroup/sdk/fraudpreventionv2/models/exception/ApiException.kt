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
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
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
    { ExpediaGroupServiceDefaultErrorException(it.status.value, runBlocking { it.bodyAsText() }) }
) {
    override fun matches(statusCode: String): Boolean = true
    override fun isRangeDefinition(): Boolean = true
}

internal object ErrorObjectMapper {
    private val defaultHttpStatusCodeRanges = listOf(DefaultHttpStatusCodeRange)
    private val httpStatusCodeRanges: Map<String, List<HttpStatusCodeRange>> = mapOf(
        Pair(
            "notifyWithAccountUpdate",
            listOf(
                HttpStatusCodeRange("400") { ExpediaGroupApiAccountTakeoverBadRequestErrorException(it.status.value, fetchErrorObject(it) as AccountTakeoverBadRequestError) },
                HttpStatusCodeRange("401") {
                    ExpediaGroupApiAccountTakeoverUnauthorizedErrorException(it.status.value, fetchErrorObject(it) as AccountTakeoverUnauthorizedError)
                },
                HttpStatusCodeRange("403") { ExpediaGroupApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError) },
                HttpStatusCodeRange("404") { ExpediaGroupApiAccountUpdateNotFoundErrorException(it.status.value, fetchErrorObject(it) as AccountUpdateNotFoundError) },
                HttpStatusCodeRange("429") { ExpediaGroupApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError) },
                HttpStatusCodeRange("500") { ExpediaGroupApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError) },
                HttpStatusCodeRange("502") { ExpediaGroupApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError) },
                HttpStatusCodeRange("503") { ExpediaGroupApiServiceUnavailableErrorException(it.status.value, fetchErrorObject(it) as ServiceUnavailableError) },
                HttpStatusCodeRange("504") { ExpediaGroupApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError) },
                DefaultHttpStatusCodeRange
            )
        ),
        Pair(
            "notifyWithOrderUpdate",
            listOf(
                HttpStatusCodeRange("400") { ExpediaGroupApiBadRequestErrorException(it.status.value, fetchErrorObject(it) as BadRequestError) },
                HttpStatusCodeRange("401") { ExpediaGroupApiUnauthorizedErrorException(it.status.value, fetchErrorObject(it) as UnauthorizedError) },
                HttpStatusCodeRange("403") { ExpediaGroupApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError) },
                HttpStatusCodeRange("404") {
                    ExpediaGroupApiOrderPurchaseUpdateNotFoundErrorException(it.status.value, fetchErrorObject(it) as OrderPurchaseUpdateNotFoundError)
                },
                HttpStatusCodeRange("429") { ExpediaGroupApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError) },
                HttpStatusCodeRange("500") { ExpediaGroupApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError) },
                HttpStatusCodeRange("502") { ExpediaGroupApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError) },
                HttpStatusCodeRange("503") {
                    ExpediaGroupApiRetryableOrderPurchaseUpdateFailureException(it.status.value, fetchErrorObject(it) as RetryableOrderPurchaseUpdateFailure)
                },
                HttpStatusCodeRange("504") { ExpediaGroupApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError) },
                DefaultHttpStatusCodeRange
            )
        ),
        Pair(
            "screenAccount",
            listOf(
                HttpStatusCodeRange("400") { ExpediaGroupApiAccountTakeoverBadRequestErrorException(it.status.value, fetchErrorObject(it) as AccountTakeoverBadRequestError) },
                HttpStatusCodeRange("401") {
                    ExpediaGroupApiAccountTakeoverUnauthorizedErrorException(it.status.value, fetchErrorObject(it) as AccountTakeoverUnauthorizedError)
                },
                HttpStatusCodeRange("403") { ExpediaGroupApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError) },
                HttpStatusCodeRange("404") { ExpediaGroupApiNotFoundErrorException(it.status.value, fetchErrorObject(it) as NotFoundError) },
                HttpStatusCodeRange("429") { ExpediaGroupApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError) },
                HttpStatusCodeRange("500") { ExpediaGroupApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError) },
                HttpStatusCodeRange("502") { ExpediaGroupApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError) },
                HttpStatusCodeRange("503") { ExpediaGroupApiServiceUnavailableErrorException(it.status.value, fetchErrorObject(it) as ServiceUnavailableError) },
                HttpStatusCodeRange("504") { ExpediaGroupApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError) },
                DefaultHttpStatusCodeRange
            )
        ),
        Pair(
            "screenOrder",
            listOf(
                HttpStatusCodeRange("400") { ExpediaGroupApiBadRequestErrorException(it.status.value, fetchErrorObject(it) as BadRequestError) },
                HttpStatusCodeRange("401") { ExpediaGroupApiUnauthorizedErrorException(it.status.value, fetchErrorObject(it) as UnauthorizedError) },
                HttpStatusCodeRange("403") { ExpediaGroupApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError) },
                HttpStatusCodeRange("404") { ExpediaGroupApiNotFoundErrorException(it.status.value, fetchErrorObject(it) as NotFoundError) },
                HttpStatusCodeRange("429") { ExpediaGroupApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError) },
                HttpStatusCodeRange("500") { ExpediaGroupApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError) },
                HttpStatusCodeRange("502") { ExpediaGroupApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError) },
                HttpStatusCodeRange("503") {
                    ExpediaGroupApiRetryableOrderPurchaseScreenFailureException(it.status.value, fetchErrorObject(it) as RetryableOrderPurchaseScreenFailure)
                },
                HttpStatusCodeRange("504") { ExpediaGroupApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError) },
                DefaultHttpStatusCodeRange
            )
        )
    )

    fun process(httpResponse: HttpResponse, operationId: String): ExpediaGroupApiException =
        httpStatusCodeRanges.getOrDefault(operationId, defaultHttpStatusCodeRanges).filter { it.matches(httpResponse.status.value.toString()) }.min().getException(httpResponse)

    private inline fun <reified T> fetchErrorObject(httpResponse: HttpResponse): T = runBlocking {
        runCatching { httpResponse.body<T>() }.getOrElse { throw ExpediaGroupServiceException(httpResponse.bodyAsText()) }
    }
}

class ExpediaGroupApiAccountTakeoverBadRequestErrorException(code: Int, override val errorObject: AccountTakeoverBadRequestError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiAccountTakeoverUnauthorizedErrorException(code: Int, override val errorObject: AccountTakeoverUnauthorizedError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiForbiddenErrorException(code: Int, override val errorObject: ForbiddenError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiAccountUpdateNotFoundErrorException(code: Int, override val errorObject: AccountUpdateNotFoundError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiTooManyRequestsErrorException(code: Int, override val errorObject: TooManyRequestsError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiInternalServerErrorException(code: Int, override val errorObject: InternalServerError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiBadGatewayErrorException(code: Int, override val errorObject: BadGatewayError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiServiceUnavailableErrorException(code: Int, override val errorObject: ServiceUnavailableError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiGatewayTimeoutErrorException(code: Int, override val errorObject: GatewayTimeoutError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiBadRequestErrorException(code: Int, override val errorObject: BadRequestError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiUnauthorizedErrorException(code: Int, override val errorObject: UnauthorizedError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiOrderPurchaseUpdateNotFoundErrorException(code: Int, override val errorObject: OrderPurchaseUpdateNotFoundError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiRetryableOrderPurchaseUpdateFailureException(code: Int, override val errorObject: RetryableOrderPurchaseUpdateFailure) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiNotFoundErrorException(code: Int, override val errorObject: NotFoundError) : ExpediaGroupApiException(code, errorObject)
class ExpediaGroupApiRetryableOrderPurchaseScreenFailureException(code: Int, override val errorObject: RetryableOrderPurchaseScreenFailure) : ExpediaGroupApiException(code, errorObject)

class ExpediaGroupServiceDefaultErrorException(code: Int, override val errorObject: String) : ExpediaGroupApiException(code, errorObject)
