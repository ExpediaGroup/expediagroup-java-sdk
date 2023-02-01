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
package com.expediagroup.common.sdk.core.plugin.authentication

import com.expediagroup.common.sdk.core.client.Client
import com.expediagroup.common.sdk.core.constant.ExceptionMessage.AUTHENTICATION_NOT_CONFIGURED_FOR_CLIENT
import com.expediagroup.common.sdk.core.model.exception.client.OpenWorldClientException
import com.expediagroup.common.sdk.core.plugin.Plugin
import com.expediagroup.common.sdk.core.plugin.authentication.strategy.AuthenticationStrategy
import io.ktor.client.plugins.auth.Auth
import kotlin.collections.set

internal object AuthenticationPlugin : Plugin<AuthenticationConfiguration> {
    val clientAuthenticationStrategies = mutableMapOf<Client, AuthenticationStrategy>()

    override fun install(client: Client, configurations: AuthenticationConfiguration) {
        val strategy = AuthenticationStrategy.from(configurations) { client.httpClient }
        clientAuthenticationStrategies[client] = strategy
        configurations.httpClientConfiguration.install(Auth) {
            strategy.loadAuth(this)
        }
    }
}

internal fun Client.getAuthenticationStrategy(): AuthenticationStrategy =
    AuthenticationPlugin.clientAuthenticationStrategies[this] ?: throw OpenWorldClientException(AUTHENTICATION_NOT_CONFIGURED_FOR_CLIENT)
