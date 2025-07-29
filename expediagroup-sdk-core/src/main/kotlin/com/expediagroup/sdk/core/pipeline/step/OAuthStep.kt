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

package com.expediagroup.sdk.core.pipeline.step

import com.expediagroup.sdk.core.auth.oauth.AbstractOAuthManager
import com.expediagroup.sdk.core.common.getExceptionFromStack
import com.expediagroup.sdk.core.exception.service.ExpediaGroupAuthException
import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.pipeline.RequestPipelineStep
import java.util.UUID

class OAuthStep(
    private val authenticationManager: AbstractOAuthManager
) : RequestPipelineStep {
    private val lock = Any()

    override fun invoke(request: Request): Request {
        ensureValidAuthentication()
        return addAuthorizationHeader(request)
    }

    private fun ensureValidAuthentication() {
        try {
            if (authenticationManager.isTokenAboutToExpire()) {
                synchronized(lock) {
                    if (authenticationManager.isTokenAboutToExpire()) {
                        authenticationManager.authenticate()
                    }
                }
            }
        } catch (e: Exception) {
            val id: UUID? =
                e.getExceptionFromStack(ExpediaGroupServiceException::class.java)?.let {
                    (it as ExpediaGroupServiceException).requestId
                }

            throw ExpediaGroupAuthException(
                requestId = id,
                message = "Failed to authenticate",
                cause = e
            )
        }
    }

    private fun addAuthorizationHeader(request: Request): Request = request
        .newBuilder()
        .addHeader("Authorization", authenticationManager.getAuthorizationHeaderValue())
        .build()
}
