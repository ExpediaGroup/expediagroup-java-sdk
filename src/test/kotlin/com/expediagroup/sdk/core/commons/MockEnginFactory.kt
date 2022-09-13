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
package com.expediagroup.sdk.core.commons

import com.expediagroup.sdk.core.commons.TestConstants.ACCESS_TOKEN
import com.expediagroup.sdk.core.commons.TestConstants.BAD_REQUEST_ATTRIBUTE
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import com.expediagroup.sdk.core.commons.TestConstants.TEST_URL
import com.expediagroup.sdk.core.configuration.provider.DefaultConfigurationProvider
import com.expediagroup.sdk.core.constant.Header
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.HttpRequestData
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.util.AttributeKey
import io.ktor.utils.io.ByteReadChannel
import java.util.Base64

object MockEnginFactory {

    fun createDefaultEngine(): HttpClientEngine = MockEngine { request ->
        if (isIdentityRequest(request) && isValidCredentialsRequest(request)) {
            tokenResponse()
        } else if (isIdentityRequest(request) && !isValidCredentialsRequest(request)) {
            unAuthorizedIdentityRespond()
        } else if (isAuthorizedHeader(request) && !isBadRequest(request)) {
            successfulRespond()
        } else if (!isAuthorizedHeader(request)) {
            unAuthorizedRespond()
        } else if (isBadRequest(request)) {
            errorResponse()
        } else {
            throw RuntimeException("un supported case in the mock engin")
        }
    }

    private fun isIdentityRequest(request: HttpRequestData) = request.url.toString() == DefaultConfigurationProvider.authEndpoint

    private fun isBadRequest(request: HttpRequestData) = request.attributes.getOrNull(AttributeKey(BAD_REQUEST_ATTRIBUTE)) != null

    private fun isValidCredentialsRequest(request: HttpRequestData) = request.headers[Header.AUTHORIZATION] == "Basic ${
    String(
        Base64.getEncoder().encode(
            "$CLIENT_KEY_TEST_CREDENTIAL:$CLIENT_SECRET_TEST_CREDENTIAL".toByteArray()
        )
    )
    }"

    private fun isAuthorizedHeader(request: HttpRequestData) =
        request.headers[Header.AUTHORIZATION] == "Bearer $ACCESS_TOKEN"

    private fun MockRequestHandleScope.tokenResponse() = respond(
        content = ByteReadChannel(
            """
                {
                    "access_token": $ACCESS_TOKEN,
                    "token_type": "bearer",
                    "expires_in": 1800,
                    "scope": "any-scope"
                }
                """
        ),
        status = HttpStatusCode.OK,
        headers = headersOf(HttpHeaders.ContentType, "application/json")
    )

    private fun MockRequestHandleScope.successfulRespond() = respond(
        content = ByteReadChannel(
            "successful dummy request"
        ),
        status = HttpStatusCode.OK,
        headers = headersOf(HttpHeaders.ContentType, "text/plain")
    )

    private fun MockRequestHandleScope.unAuthorizedIdentityRespond() = respond(
        content = ByteReadChannel(
            """
                {
                      "error": "invalid_client",
                      "error_description": "Unauthorized"
                }
                """
        ),
        status = HttpStatusCode.Unauthorized,
        headers = headersOf("WWW-Authenticate", "Basic realm=\"Access to the '/' path\"")
    )

    private fun MockRequestHandleScope.unAuthorizedRespond() = respond(
        content = ByteReadChannel(
            """
                {
                      "error": "invalid_client",
                      "error_description": "Unauthorized"
                }
                """
        ),
        status = HttpStatusCode.Unauthorized
    )

    private fun MockRequestHandleScope.errorResponse() = respond(
        content = ByteReadChannel(
            """
                 {
                   "type": "$TEST_URL",
                   "detail":"The request failed because one or many input values are invalid. Please see the causes for more details.",
                   "causes":[
                      {
                         "type":"$TEST_URL",
                         "detail":"The number of results per page you provided ('NotANumber') is invalid.",
                         "location":"QUERY",
                         "name":"result",
                         "value":"NotANumber"
                      }
                   ]
                }  
                 """
        ),
        status = HttpStatusCode.BadRequest,
        headersOf(HttpHeaders.ContentType, "application/json")
    )
}
