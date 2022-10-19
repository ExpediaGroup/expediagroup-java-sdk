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
import com.expediagroup.sdk.core.constant.LoggingMessage.TOKEN_EXPIRED
import com.expediagroup.sdk.core.plugin.Hook
import com.expediagroup.sdk.core.plugin.HookBuilder
import com.expediagroup.sdk.core.plugin.HookConfigsBuilder
import com.expediagroup.sdk.core.plugin.authentication.AuthenticationPlugin.isNotIdentityRequest
import io.ktor.client.plugins.HttpSend
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
    private val log = LoggerFactory.getLogger(javaClass)
    private val isLock = atomic(false)

    override fun build(client: Client, configs: AuthenticationConfiguration) {
        val httpClient = client.httpClient

        httpClient.plugin(HttpSend).intercept { request ->
            if (isNotIdentityRequest(request, configs) && AuthenticationPlugin.isTokenAboutToExpire()) {
                log.info(TOKEN_EXPIRED)
                if (!isLock.getAndSet(true)) {
                    AuthenticationPlugin.renewToken(httpClient, configs)
                    isLock.compareAndSet(expect = true, update = false)
                }
                waitForTokenRenewal()
                assignNewToken(request)
            }
            execute(request)
        }
    }

    private fun assignNewToken(request: HttpRequestBuilder) {
        request.headers[Header.AUTHORIZATION] = "Bearer ${AuthenticationPlugin.getToken().accessToken}"
    }

    private suspend fun waitForTokenRenewal() {
        while (isLock.value) delay(AUTHORIZATION_REQUEST_LOCK_DELAY)
    }
}
