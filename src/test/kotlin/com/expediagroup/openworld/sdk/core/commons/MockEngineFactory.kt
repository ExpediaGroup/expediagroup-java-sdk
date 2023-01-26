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
package com.expediagroup.openworld.sdk.core.commons

import com.expediagroup.openworld.sdk.core.commons.TestConstants.ACCESS_TOKEN
import com.expediagroup.openworld.sdk.core.commons.TestConstants.APPLICATION_JSON
import com.expediagroup.openworld.sdk.core.commons.TestConstants.BAD_REQUEST_ATTRIBUTE
import com.expediagroup.openworld.sdk.core.commons.TestConstants.BASIC
import com.expediagroup.openworld.sdk.core.commons.TestConstants.CLIENT_KEY_TEST_CREDENTIAL
import com.expediagroup.openworld.sdk.core.commons.TestConstants.CLIENT_SECRET_TEST_CREDENTIAL
import com.expediagroup.openworld.sdk.core.commons.TestConstants.SUCCESSFUL_DUMMY_REQUEST
import com.expediagroup.openworld.sdk.core.commons.TestConstants.TEST_URL
import com.expediagroup.openworld.sdk.core.configuration.provider.DefaultConfigurationProvider
import com.expediagroup.openworld.sdk.core.constant.Authentication.BEARER
import com.expediagroup.openworld.sdk.core.constant.Constant.EMPTY_STRING
import com.expediagroup.openworld.sdk.core.constant.HeaderKey
import com.expediagroup.openworld.sdk.core.model.exception.service.OpenWorldAuthException
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

object MockEngineFactory {
    fun createDefaultEngine(): HttpClientEngine = MockEngine { request ->
        if (isIdentityRequest(request) && isValidCredentialsRequest(request)) {
            tokenResponse(HttpStatusCode.OK)
        } else if (isIdentityRequest(request) && !isValidCredentialsRequest(request)) {
            unAuthorizedIdentityRespond()
        } else if (isAuthorizedHeader(request) && !isBadRequest(request)) {
            successfulRespond()
        } else if (!isAuthorizedHeader(request)) {
            unAuthorizedRespond(HttpStatusCode.Unauthorized)
        } else if (isBadRequest(request)) {
            errorResponse()
        } else {
            throw OpenWorldAuthException(HttpStatusCode.InternalServerError, "unsupported case in the mock engine")
        }
    }

    fun createMockEngineExpiresInPerCall(vararg expiresIn: Int): MockEngine {
        var timesCalled = -1
        val mockEngine = MockEngine {
            timesCalled++
            if (timesCalled in expiresIn.indices) {
                createTokenResponse(expiresIn[timesCalled])
            } else {
                createTokenResponse(1000)
            }
        }
        return mockEngine
    }

    fun createUnauthorizedMockEngineWithStatusCode(statusCode: HttpStatusCode): HttpClientEngine = MockEngine {
        unAuthorizedRespond(statusCode)
    }

    fun createTokenMockEngineWithStatusCode(statusCode: HttpStatusCode): HttpClientEngine = MockEngine {
        tokenResponse(statusCode)
    }

    private fun MockRequestHandleScope.createTokenResponse(expiresIn: Int) = respond(
        content = ByteReadChannel(
            """
                    {
                        "access_token": "$ACCESS_TOKEN",
                        "token_type": "bearer",
                        "expires_in": $expiresIn,
                        "scope": "any-scope"
                    }
                    """
        ),
        status = HttpStatusCode.OK,
        headers = headersOf(HttpHeaders.ContentType, "application/json")
    )

    fun createEmptyResponseEngine() = MockEngine {
        respond(
            content = EMPTY_STRING
        )
    }

    private fun isIdentityRequest(request: HttpRequestData) = request.url.toString() == DefaultConfigurationProvider.authEndpoint

    private fun isBadRequest(request: HttpRequestData) = request.attributes.getOrNull(AttributeKey(BAD_REQUEST_ATTRIBUTE)) != null

    private fun isValidCredentialsRequest(request: HttpRequestData) = request.headers[HeaderKey.AUTHORIZATION] == "$BASIC ${
    String(
        Base64.getEncoder().encode(
            "$CLIENT_KEY_TEST_CREDENTIAL:$CLIENT_SECRET_TEST_CREDENTIAL".toByteArray()
        )
    )
    }"

    private fun isAuthorizedHeader(request: HttpRequestData) =
        request.headers[HeaderKey.AUTHORIZATION] == "$BEARER $ACCESS_TOKEN"

    private fun MockRequestHandleScope.tokenResponse(httpStatusCode: HttpStatusCode) = respond(
        content = ByteReadChannel(
            """
                {
                    "access_token": "$ACCESS_TOKEN",
                    "token_type": "bearer",
                    "expires_in": 1800,
                    "scope": "any-scope"
                }
                """
        ),
        status = httpStatusCode,
        headers = headersOf(HttpHeaders.ContentType, APPLICATION_JSON)
    )

    private fun MockRequestHandleScope.successfulRespond() = respond(
        content = ByteReadChannel(SUCCESSFUL_DUMMY_REQUEST),
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

    private fun MockRequestHandleScope.unAuthorizedRespond(httpStatusCode: HttpStatusCode) = respond(
        content = ByteReadChannel(
            """
                {
                      "error": "invalid_client",
                      "error_description": "Unauthorized"
                }
                """
        ),
        status = httpStatusCode
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
        headersOf(HttpHeaders.ContentType, APPLICATION_JSON)
    )
}
