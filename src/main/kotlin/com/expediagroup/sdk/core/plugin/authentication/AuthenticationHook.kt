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
package com.expediagroup.sdk.core.plugin.authentication

import com.expediagroup.sdk.core.client.Client
import com.expediagroup.sdk.core.constants.ClientConstants.AUTHENTICATE_HEADER
import com.expediagroup.sdk.core.constants.ClientConstants.AUTHORIZATION_HEADER
import com.expediagroup.sdk.core.constants.ClientConstants.AUTHORIZATION_REQUEST_LOCK_DELAY
import com.expediagroup.sdk.core.constants.ClientConstants.CAPITALIZED_AUTHENTICATE_HEADER
import com.expediagroup.sdk.core.plugin.Hook
import com.expediagroup.sdk.core.plugin.HookBuilder
import com.expediagroup.sdk.core.plugin.HookConfigsBuilder
import io.ktor.client.call.HttpClientCall
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.Sender
import io.ktor.client.plugins.plugin
import io.ktor.client.request.HttpRequestBuilder
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.delay

class AuthenticationHook(
    configs: AuthenticationConfigs
) : Hook<AuthenticationConfigs>(
    configs,
    AuthenticationHookBuilder
) {
    companion object : HookConfigsBuilder<AuthenticationConfigs, AuthenticationHook> {
        override fun with(configs: AuthenticationConfigs): AuthenticationHook = AuthenticationHook(configs)
    }
}

private object AuthenticationHookBuilder : HookBuilder<AuthenticationConfigs> {
    private val isLock = atomic(false)

    override fun build(client: Client, configs: AuthenticationConfigs) {
        val httpClient = client.httpClient

        httpClient.plugin(HttpSend).intercept { request ->
            val originalCall = execute(request)
            if (originalCall.response.status.value == 401 && AuthenticationPlugin.isIdentityRequest(
                    request,
                    configs
                ) && !isUnauthorizedIdentityResponse(originalCall)
            ) {
                if (!isLock.getAndSet(true)) {
                    AuthenticationPlugin.refreshToken(httpClient, configs)
                    isLock.compareAndSet(expect = true, update = false)
                    return@intercept makeRequest(request)
                }
                waitUntilTheTokenIsRefreshed()
                makeRequest(request)
            } else {
                originalCall
            }
        }
    }

    private fun isUnauthorizedIdentityResponse(httpCall: HttpClientCall) =
        getResponseHeader(
            httpCall,
            CAPITALIZED_AUTHENTICATE_HEADER
        )?.startsWith("Bearer") ?: false || getResponseHeader(
            httpCall,
            AUTHENTICATE_HEADER
        )?.startsWith("Bearer") ?: false

    private fun getResponseHeader(httpCall: HttpClientCall, header: String) =
        httpCall.response.headers[header]

    private suspend fun Sender.makeRequest(request: HttpRequestBuilder): HttpClientCall {
        request.headers[AUTHORIZATION_HEADER] =
            "Bearer ${AuthenticationPlugin.getToken().accessToken}"
        return execute(request)
    }

    private suspend fun waitUntilTheTokenIsRefreshed() {
        while (isLock.value) {
            delay(AUTHORIZATION_REQUEST_LOCK_DELAY)
        }
    }
}
