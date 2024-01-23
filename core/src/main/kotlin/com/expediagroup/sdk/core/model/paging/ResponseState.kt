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
package com.expediagroup.sdk.core.model.paging

import com.expediagroup.sdk.core.client.Client
import com.expediagroup.sdk.core.model.Response
import io.ktor.client.statement.HttpResponse
import io.ktor.util.InternalAPI
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.runBlocking

internal interface ResponseState<T> {
    fun getNextResponse(): Response<T>

    fun hasNext(): Boolean
}

internal class DefaultResponseState<T>(
    private val response: Response<T>
) : ResponseState<T> {
    override fun getNextResponse(): Response<T> {
        return response
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

internal class FetchLinkState<T>(
    private val link: String,
    private val client: Client,
    private val fallbackBody: T,
    private val getBody: suspend (HttpResponse) -> T
) : ResponseState<T> {
    override fun getNextResponse(): Response<T> {
        return runBlocking {
            val response: HttpResponse = client.performGet(link)
            val body: T = parseBody(response)
            Response(response.status.value, body, response.headers.entries())
        }
    }

    @OptIn(InternalAPI::class)
    private suspend fun parseBody(response: HttpResponse): T {
        // TODO: Find out if the body is empty
        val byteReadChannel: ByteReadChannel = response.content
        val body: String = byteReadChannel.readRemaining().readText()
        return if (body.isEmpty()) fallbackBody else getBody(response)
    }

    override fun hasNext(): Boolean {
        return true
    }
}

internal class ResponseStateFactory {
    companion object {
        fun <T> getState(
            link: String?,
            client: Client,
            fallbackBody: T,
            getBody: suspend (HttpResponse) -> T
        ): ResponseState<T> {
            return link?.let { FetchLinkState(it, client, fallbackBody, getBody) } ?: LastResponseState()
        }
    }
}
