/*
 * Copyright (C) 2024 Expedia, Inc.
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

package com.expediagroup.sdk.graphql

import com.apollographql.apollo.api.ApolloResponse
import com.apollographql.apollo.api.Error
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.composeJsonRequest
import com.apollographql.apollo.api.http.HttpHeader
import com.apollographql.apollo.api.json.buildJsonString
import com.apollographql.apollo.api.json.jsonReader
import com.apollographql.apollo.api.parseResponse
import com.apollographql.apollo.exception.ApolloHttpException
import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.RequestBody
import com.expediagroup.sdk.core.http.Response
import okio.Buffer

fun <D : Operation.Data> Operation<D>.toSDKRequest(url: String): Request {
    val body =
        buildJsonString {
            this@toSDKRequest.composeJsonRequest(this)
        }

    val requestBody =
        RequestBody.create(
            source = Buffer().writeUtf8(body),
            mediaType = CommonMediaTypes.APPLICATION_JSON,
            contentLength = body.length.toLong()
        )

    return Request.builder()
        .url(url)
        .method(Method.POST)
        .addHeader("Content-Type", CommonMediaTypes.APPLICATION_JSON.fullType)
        .body(requestBody)
        .build()
}

fun <D : Operation.Data> Response.toApolloResponse(operation: Operation<D>): ApolloResponse<D> {
    if (status.code != 200) {
        return ApolloResponse.Builder(operation, request.id)
            .exception(
                ApolloHttpException(
                    statusCode = status.code,
                    headers = headers.entries().map { HttpHeader(it.key, it.value.toString()) },
                    message = "Received non 200 response from the GraphQL server",
                    body = this.body?.source()?.buffer
                )
            ).build()
    }

    val apolloResponse =
        this.body?.let {
            val jsonReader = it.source().buffer.jsonReader()
            operation.parseResponse(jsonReader)
        }

    return apolloResponse ?: ApolloResponse.Builder(operation, request.id)
        .data(null)
        .errors(listOf(Error.Builder("Failed to parse response with null body").build()))
        .build()
}
