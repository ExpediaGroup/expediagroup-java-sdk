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
package com.expediagroup.openworld.sdk.core.plugin.authentication

import com.expediagroup.openworld.sdk.core.client.Client
import com.expediagroup.openworld.sdk.core.constant.Authentication.AUTHORIZATION_REQUEST_LOCK_DELAY
import com.expediagroup.openworld.sdk.core.constant.HeaderKey
import com.expediagroup.openworld.sdk.core.constant.LoggingMessage.TOKEN_EXPIRED
import com.expediagroup.openworld.sdk.core.plugin.Hook
import com.expediagroup.openworld.sdk.core.plugin.HookBuilder
import com.expediagroup.openworld.sdk.core.plugin.HookFactory
import com.expediagroup.openworld.sdk.core.plugin.logging.OpenWorldLoggerFactory
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.plugin
import io.ktor.client.request.HttpRequestBuilder
import kotlinx.atomicfu.atomic
import kotlinx.coroutines.delay

internal object AuthenticationHookFactory : HookFactory<AuthenticationConfiguration> {
    override fun create(client: Client, configuration: AuthenticationConfiguration): Hook<AuthenticationConfiguration> {
        return Hook(configuration, AuthenticationHookBuilder(client))
    }
}

private class AuthenticationHookBuilder(private val client: Client) : HookBuilder<AuthenticationConfiguration> {
    private val log = OpenWorldLoggerFactory.getLogger(javaClass)
    private val lock = atomic(false)
    private val authenticationStrategy = client.getAuthenticationStrategy()

    override fun build(configs: AuthenticationConfiguration) {
        val httpClient = client.httpClient

        httpClient.plugin(HttpSend).intercept { request ->
            if (authenticationStrategy.isNotIdentityRequest(request)) {
                if (authenticationStrategy.isTokenAboutToExpire()) {
                    log.info(TOKEN_EXPIRED)
                    if (!lock.getAndSet(true)) {
                        try {
                            authenticationStrategy.renewToken()
                        } finally {
                            lock.compareAndSet(expect = true, update = false)
                        }
                    }
                }
                waitForTokenRenewal()
                assignNewToken(request)
            }
            execute(request)
        }
    }

    private fun assignNewToken(request: HttpRequestBuilder) {
        request.headers[HeaderKey.AUTHORIZATION] = authenticationStrategy.getAuthorizationHeader()
    }

    private suspend fun waitForTokenRenewal() {
        while (lock.value) delay(AUTHORIZATION_REQUEST_LOCK_DELAY)
    }
}
