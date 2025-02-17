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

package com.expediagroup.sdk.core.authentication.bearer

import com.expediagroup.sdk.core.authentication.common.Credentials
import com.expediagroup.sdk.core.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.logging.LoggerDecorator
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import com.expediagroup.sdk.core.pipeline.step.RequestHeadersStep
import com.expediagroup.sdk.core.pipeline.step.RequestLoggingStep
import com.expediagroup.sdk.core.pipeline.step.ResponseLoggingStep
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.core.transport.Transport
import org.slf4j.LoggerFactory

/**
 * Manages bearer token authentication for HTTP requests.
 *
 * The `BearerAuthenticationManager` handles the lifecycle of bearer tokens, including retrieval, storage,
 * and validation. It interacts with an authentication server to fetch tokens using client credentials,
 * ensures tokens are refreshed when necessary, and provides them in the required format for authorization headers.
 *
 * @param authUrl The URL of the authentication server's endpoint to obtain bearer tokens.
 * @param credentials The [Credentials] containing the client key and secret used for authentication.
 */
class BearerAuthenticationManager(
    authUrl: String,
    credentials: Credentials,
    private val transport: Transport
) : AbstractBearerAuthenticationManager(authUrl, credentials) {
    private val requestExecutor =
        object : AbstractRequestExecutor(transport) {
            override val executionPipeline: ExecutionPipeline =
                ExecutionPipeline(
                    requestPipeline =
                        listOf(
                            RequestHeadersStep(),
                            RequestLoggingStep(logger)
                        ),
                    responsePipeline =
                        listOf(
                            ResponseLoggingStep(logger)
                        )
                )
        }

    /**
     * Initiates authentication to obtain a new bearer token.
     *
     * This method sends a request to the authentication server, parses the response, and
     * stores the token for future use.
     *
     * @throws ExpediaGroupAuthException If the authentication request fails.
     */
    override fun authenticate() {
        try {
            clearAuthentication()
                .let {
                    buildAuthenticationRequest()
                }.let {
                    executeAuthenticationRequest(it)
                }.let {
                    BearerTokenResponse.parse(it)
                }.also {
                    storeToken(it)
                }
        } catch (e: Exception) {
            throw ExpediaGroupAuthException(message = "Authentication Failed", cause = e)
        }
    }

    /**
     * Executes the authentication request and validates the response.
     *
     * @param request The [Request] object to be executed.
     * @return The [Response] received from the server.
     * @throws ExpediaGroupAuthException If the server responds with an error.
     */
    private fun executeAuthenticationRequest(request: Request): Response =
        requestExecutor.execute(request).apply {
            if (!this.isSuccessful) {
                throw throw ExpediaGroupAuthException("Received unsuccessful authentication response: [${this.status}]")
            }
        }

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}
