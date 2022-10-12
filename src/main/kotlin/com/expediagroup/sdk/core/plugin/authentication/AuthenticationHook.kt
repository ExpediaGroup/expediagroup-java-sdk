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
import com.expediagroup.sdk.core.constant.Header
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
import org.slf4j.LoggerFactory

internal const val AUTHORIZATION_REQUEST_LOCK_DELAY = 20L

internal class AuthenticationHook(
    configuration: AuthenticationConfiguration
) : Hook<AuthenticationConfiguration>(
    configuration,
    AuthenticationHookBuilder
) {
    companion object : HookConfigsBuilder<AuthenticationConfiguration, AuthenticationHook> {
        override fun with(configuration: AuthenticationConfiguration): AuthenticationHook =
            AuthenticationHook(configuration)
    }
}

private object AuthenticationHookBuilder : HookBuilder<AuthenticationConfiguration> {
    private val logger = LoggerFactory.getLogger(javaClass)
    private val isLock = atomic(false)

    override fun build(client: Client, configs: AuthenticationConfiguration) {
        val httpClient = client.httpClient

        httpClient.plugin(HttpSend).intercept { request ->
            val originalCall = execute(request)
            if (originalCall.response.status.value == 401 && AuthenticationPlugin.isIdentityRequest(
                    request,
                    configs
                ) && !isUnauthorizedIdentityResponse(originalCall)
            ) {
                logger.info("Client[$client]: Token expired or is about to expire: Request [$request] will wait until the token is renewed")
                if (!isLock.getAndSet(true)) {
                    AuthenticationPlugin.refreshToken(httpClient, configs)
                    isLock.compareAndSet(expect = true, update = false)
                    makeRequest(request)
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
            Header.CAPITALIZED_AUTHENTICATE
        )?.startsWith("Bearer") ?: false || getResponseHeader(
            httpCall,
            Header.AUTHORIZATION
        )?.startsWith("Bearer") ?: false

    private fun getResponseHeader(httpCall: HttpClientCall, header: String) =
        httpCall.response.headers[header]

    private suspend fun Sender.makeRequest(request: HttpRequestBuilder): HttpClientCall {
        request.headers[Header.AUTHORIZATION] =
            "Bearer ${AuthenticationPlugin.getToken().accessToken}"
        return execute(request)
    }

    private suspend fun waitUntilTheTokenIsRefreshed() {
        while (isLock.value) {
            delay(AUTHORIZATION_REQUEST_LOCK_DELAY)
        }
    }
}
