/**
 * Copyright (C) 2025 Expedia, Inc.
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
package com.expediagroup.sdk.exemplar.rest.core.executor.demo

import com.expediagroup.sdk.core.auth.oauth.OAuthCredentials
import com.expediagroup.sdk.core.auth.oauth.OAuthManager
import com.expediagroup.sdk.core.logging.LoggerDecorator
import com.expediagroup.sdk.core.pipeline.ExecutionPipeline
import com.expediagroup.sdk.core.pipeline.step.OAuthStep
import com.expediagroup.sdk.core.pipeline.step.RequestHeadersStep
import com.expediagroup.sdk.core.pipeline.step.RequestLoggingStep
import com.expediagroup.sdk.core.pipeline.step.ResponseLoggingStep
import com.expediagroup.sdk.core.transport.AbstractRequestExecutor
import com.expediagroup.sdk.core.transport.Transport
import org.slf4j.LoggerFactory

/**
 * **Demo Request Executor: OAuth 2.0 Authentication**
 *
 * This demo RequestExecutor showcases how to configure **EG** OAuth 2.0 authentication
 * for API requests using the SDK's built-in OAuth pipeline step. This handles
 * the complete OAuth flow including token acquisition and refresh.
 *
 * ## Use Case
 * When your API requires EG OAuth 2.0 authentication, this executor automatically:
 * - Obtains access tokens using client credentials
 * - Adds `Authorization: Bearer <token>` headers to requests
 * - Refreshes expired tokens automatically
 *
 * ## OAuth Flow
 * 1. **Initial Setup**: Configure OAuth credentials (key/secret) and auth endpoint
 * 2. **Token Acquisition**: First API call triggers token request to auth endpoint
 * 3. **Token Usage**: Subsequent calls use cached access token in Authorization header
 * 4. **Token Refresh**: Expired tokens are automatically refreshed when needed
 *
 * @see OAuthStep
 * @see OAuthManager
 * @see OAuthCredentials
 */
class RequestExecutorWithOAuth @JvmOverloads constructor(
    transport: Transport? = null
) : AbstractRequestExecutor(transport) {
    override val executionPipeline: ExecutionPipeline = ExecutionPipeline(
        requestPipeline = listOf(
            RequestHeadersStep(),
            RequestLoggingStep(logger = logger),
            OAuthStep(
                OAuthManager(
                    credentials = OAuthCredentials(key = "key", secret = "secret"),
                    transport = super.transport,
                    authUrl = "https://example.com/auth" // NOTE: This implementation is tied to EG OAuth APIs
                )
            )
        ),
        responsePipeline = listOf(
            ResponseLoggingStep(logger = logger)
        )
    )

    companion object {
        private val logger = LoggerDecorator(LoggerFactory.getLogger(this::class.java.enclosingClass))
    }
}
