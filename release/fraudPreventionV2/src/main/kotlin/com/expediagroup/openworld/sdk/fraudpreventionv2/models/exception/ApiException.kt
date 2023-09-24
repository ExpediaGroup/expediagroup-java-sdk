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

package com.expediagroup.openworld.sdk.fraudpreventionv2.models.exception

import com.expediagroup.openworld.sdk.core.model.exception.service.OpenWorldApiException
import com.expediagroup.openworld.sdk.core.model.exception.service.OpenWorldServiceException
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.*
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

internal open class HttpStatusCodeRange(
    private val statusCode: String,
    val getException: (HttpResponse) -> OpenWorldApiException
) : Comparable<HttpStatusCodeRange> {
    open fun matches(statusCode: String): Boolean = if (isRangeDefinition()) this.statusCode.first() == statusCode.first() else this.statusCode == statusCode
    open fun isRangeDefinition(): Boolean = statusCode.matches(Regex("^[1-5]XX$"))
    override fun compareTo(other: HttpStatusCodeRange): Int = (if (this.isRangeDefinition()) 1 else 0).compareTo(if (other.isRangeDefinition()) 1 else 0)
}

internal object DefaultHttpStatusCodeRange : HttpStatusCodeRange(
    "DefaultHttpStatusCodeRange",
    { OpenWorldServiceDefaultErrorException(it.status.value, runBlocking { it.bodyAsText() }) }
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
                HttpStatusCodeRange("400") { OpenWorldApiAccountTakeoverBadRequestErrorException(it.status.value, fetchErrorObject(it) as AccountTakeoverBadRequestError) },
                HttpStatusCodeRange("401") { OpenWorldApiAccountTakeoverUnauthorizedErrorException(it.status.value, fetchErrorObject(it) as AccountTakeoverUnauthorizedError) },
                HttpStatusCodeRange("403") { OpenWorldApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError) },
                HttpStatusCodeRange("404") { OpenWorldApiAccountUpdateNotFoundErrorException(it.status.value, fetchErrorObject(it) as AccountUpdateNotFoundError) },
                HttpStatusCodeRange("429") { OpenWorldApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError) },
                HttpStatusCodeRange("500") { OpenWorldApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError) },
                HttpStatusCodeRange("502") { OpenWorldApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError) },
                HttpStatusCodeRange("503") {
                    OpenWorldApiAccountTakeoverServiceUnavailableErrorException(it.status.value, fetchErrorObject(it) as AccountTakeoverServiceUnavailableError)
                },
                HttpStatusCodeRange("504") { OpenWorldApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError) },
                DefaultHttpStatusCodeRange
            )
        ),
        Pair(
            "notifyWithOrderUpdate",
            listOf(
                HttpStatusCodeRange("400") { OpenWorldApiBadRequestErrorException(it.status.value, fetchErrorObject(it) as BadRequestError) },
                HttpStatusCodeRange("401") { OpenWorldApiUnauthorizedErrorException(it.status.value, fetchErrorObject(it) as UnauthorizedError) },
                HttpStatusCodeRange("403") { OpenWorldApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError) },
                HttpStatusCodeRange("404") { OpenWorldApiOrderPurchaseUpdateNotFoundErrorException(it.status.value, fetchErrorObject(it) as OrderPurchaseUpdateNotFoundError) },
                HttpStatusCodeRange("429") { OpenWorldApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError) },
                HttpStatusCodeRange("500") { OpenWorldApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError) },
                HttpStatusCodeRange("502") { OpenWorldApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError) },
                HttpStatusCodeRange("503") { OpenWorldApiServiceUnavailableErrorException(it.status.value, fetchErrorObject(it) as ServiceUnavailableError) },
                HttpStatusCodeRange("504") { OpenWorldApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError) },
                DefaultHttpStatusCodeRange
            )
        ),
        Pair(
            "screenAccount",
            listOf(
                HttpStatusCodeRange("400") { OpenWorldApiAccountTakeoverBadRequestErrorException(it.status.value, fetchErrorObject(it) as AccountTakeoverBadRequestError) },
                HttpStatusCodeRange("401") { OpenWorldApiAccountTakeoverUnauthorizedErrorException(it.status.value, fetchErrorObject(it) as AccountTakeoverUnauthorizedError) },
                HttpStatusCodeRange("403") { OpenWorldApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError) },
                HttpStatusCodeRange("404") { OpenWorldApiNotFoundErrorException(it.status.value, fetchErrorObject(it) as NotFoundError) },
                HttpStatusCodeRange("429") { OpenWorldApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError) },
                HttpStatusCodeRange("500") { OpenWorldApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError) },
                HttpStatusCodeRange("502") { OpenWorldApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError) },
                HttpStatusCodeRange("503") {
                    OpenWorldApiAccountTakeoverServiceUnavailableErrorException(it.status.value, fetchErrorObject(it) as AccountTakeoverServiceUnavailableError)
                },
                HttpStatusCodeRange("504") { OpenWorldApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError) },
                DefaultHttpStatusCodeRange
            )
        ),
        Pair(
            "screenOrder",
            listOf(
                HttpStatusCodeRange("400") { OpenWorldApiBadRequestErrorException(it.status.value, fetchErrorObject(it) as BadRequestError) },
                HttpStatusCodeRange("401") { OpenWorldApiUnauthorizedErrorException(it.status.value, fetchErrorObject(it) as UnauthorizedError) },
                HttpStatusCodeRange("403") { OpenWorldApiForbiddenErrorException(it.status.value, fetchErrorObject(it) as ForbiddenError) },
                HttpStatusCodeRange("404") { OpenWorldApiNotFoundErrorException(it.status.value, fetchErrorObject(it) as NotFoundError) },
                HttpStatusCodeRange("429") { OpenWorldApiTooManyRequestsErrorException(it.status.value, fetchErrorObject(it) as TooManyRequestsError) },
                HttpStatusCodeRange("500") { OpenWorldApiInternalServerErrorException(it.status.value, fetchErrorObject(it) as InternalServerError) },
                HttpStatusCodeRange("502") { OpenWorldApiBadGatewayErrorException(it.status.value, fetchErrorObject(it) as BadGatewayError) },
                HttpStatusCodeRange("503") { OpenWorldApiServiceUnavailableErrorException(it.status.value, fetchErrorObject(it) as ServiceUnavailableError) },
                HttpStatusCodeRange("504") { OpenWorldApiGatewayTimeoutErrorException(it.status.value, fetchErrorObject(it) as GatewayTimeoutError) },
                DefaultHttpStatusCodeRange
            )
        )
    )

    fun process(httpResponse: HttpResponse, operationId: String): OpenWorldApiException =
        httpStatusCodeRanges.getOrDefault(operationId, defaultHttpStatusCodeRanges).filter { it.matches(httpResponse.status.value.toString()) }.min().getException(httpResponse)

    private inline fun <reified T> fetchErrorObject(httpResponse: HttpResponse): T = runBlocking {
        runCatching { httpResponse.body<T>() }.getOrElse { throw OpenWorldServiceException(httpResponse.bodyAsText()) }
    }
}

class OpenWorldApiAccountTakeoverBadRequestErrorException(code: Int, override val errorObject: AccountTakeoverBadRequestError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiAccountTakeoverUnauthorizedErrorException(code: Int, override val errorObject: AccountTakeoverUnauthorizedError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiForbiddenErrorException(code: Int, override val errorObject: ForbiddenError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiAccountUpdateNotFoundErrorException(code: Int, override val errorObject: AccountUpdateNotFoundError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiTooManyRequestsErrorException(code: Int, override val errorObject: TooManyRequestsError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiInternalServerErrorException(code: Int, override val errorObject: InternalServerError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiBadGatewayErrorException(code: Int, override val errorObject: BadGatewayError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiAccountTakeoverServiceUnavailableErrorException(code: Int, override val errorObject: AccountTakeoverServiceUnavailableError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiGatewayTimeoutErrorException(code: Int, override val errorObject: GatewayTimeoutError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiBadRequestErrorException(code: Int, override val errorObject: BadRequestError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiUnauthorizedErrorException(code: Int, override val errorObject: UnauthorizedError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiOrderPurchaseUpdateNotFoundErrorException(code: Int, override val errorObject: OrderPurchaseUpdateNotFoundError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiServiceUnavailableErrorException(code: Int, override val errorObject: ServiceUnavailableError) : OpenWorldApiException(code, errorObject)
class OpenWorldApiNotFoundErrorException(code: Int, override val errorObject: NotFoundError) : OpenWorldApiException(code, errorObject)

class OpenWorldServiceDefaultErrorException(code: Int, override val errorObject: String) : OpenWorldApiException(code, errorObject)
