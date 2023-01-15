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
import com.expediagroup.sdk.core.constant.HeaderKey
import com.expediagroup.sdk.core.constant.LoggingMessage.TOKEN_EXPIRED
import com.expediagroup.sdk.core.plugin.Hook
import com.expediagroup.sdk.core.plugin.HookBuilder
import com.expediagroup.sdk.core.plugin.HookCreator
import com.expediagroup.sdk.core.plugin.logging.OpenWorldLoggerFactory
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.plugin
import io.ktor.client.request.HttpRequestBuilder
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.delay

internal const val AUTHORIZATION_REQUEST_LOCK_DELAY = 20L

internal class DaHook(client: Client, configuration: AuthenticationConfiguration) :
    Hook<AuthenticationConfiguration>(configuration, AuthenticationHookBuilder(client))

internal object AuthenticationHook : HookCreator<AuthenticationConfiguration> {
    override fun create(client: Client, configuration: AuthenticationConfiguration): Hook<AuthenticationConfiguration> {
        return DaHook(client, configuration)
    }
}

private class AuthenticationHookBuilder(private val client: Client) : HookBuilder<AuthenticationConfiguration> {
    private val log = OpenWorldLoggerFactory.getLogger(javaClass)
    private val isLock = atomic(false)
    private val auth = client.authentication()

    override fun build(configs: AuthenticationConfiguration) {
        val httpClient = client.httpClient

        httpClient.plugin(HttpSend).intercept { request ->
            if (auth.isNotIdentityRequest(request, configs) && auth.isTokenAboutToExpire()) {
                log.info(TOKEN_EXPIRED)
                if (!isLock.getAndSet(true)) {
                    auth.renewToken(httpClient, configs)
                    isLock.compareAndSet(expect = true, update = false)
                }
                waitForTokenRenewal()
                assignNewToken(request)
            }
            execute(request)
        }
    }

    private fun assignNewToken(request: HttpRequestBuilder) {
        request.headers[HeaderKey.AUTHORIZATION] = auth.getAuthorizationHeader()
    }

    private suspend fun waitForTokenRenewal() {
        while (isLock.value) delay(AUTHORIZATION_REQUEST_LOCK_DELAY)
    }
}
