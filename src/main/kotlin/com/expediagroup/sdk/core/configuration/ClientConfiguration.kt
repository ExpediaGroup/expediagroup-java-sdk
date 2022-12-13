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
package com.expediagroup.sdk.core.configuration

import com.expediagroup.sdk.core.configuration.provider.RuntimeConfigurationProvider
import com.expediagroup.sdk.core.contract.Contract
import com.expediagroup.sdk.core.contract.adhereTo

/**
 * SDK Client Configurations Provider.
 *
 * @property key The API key to use for authentication.
 * @property secret The API secret to use for authentication.
 * @property endpoint The API endpoint to use for requests.
 * @property authEndpoint The API endpoint to use for authentication.
 */
data class ClientConfiguration(
    val key: String? = null,
    val secret: String? = null,
    val endpoint: String? = null,
    val authEndpoint: String? = null
) {

    companion object {
        /** An empty configuration. */
        @JvmField
        val EMPTY = ClientConfiguration()

        /** Creates a new ClientConfigurations.Builder instance. */
        @JvmStatic
        fun builder() = Builder()
    }

    /**
     * A Builder for [ClientConfiguration] Provider.
     */
    class Builder {
        private var key: String? = null
        private var secret: String? = null
        private var endpoint: String? = null
        private var authEndpoint: String? = null

        /** Sets the API key to use for authentication.
         *
         * @param key The API key to use for authentication.
         * @return The [Builder] instance.
         */
        fun key(key: String) = apply { this.key = key }

        /** Sets the API secret to use for authentication.
         *
         * @param secret The API secret to use for authentication.
         * @return The [Builder] instance.
         */
        fun secret(secret: String) = apply { this.secret = secret }

        /** Sets the API endpoint to use for requests.
         *
         * @param endpoint The API endpoint to use for requests.
         * @return The [Builder] instance.
         */
        fun endpoint(endpoint: String) = apply { this.endpoint = endpoint.adhereTo(Contract.TRAILING_SLASH) }

        /** Sets the API auth endpoint to use for requests.
         *
         * @param authEndpoint The API auth endpoint to use for requests.
         * @return The [Builder] instance.
         */
        fun authEndpoint(authEndpoint: String) = apply { this.authEndpoint = authEndpoint }

        /** Builds the [ClientConfiguration] object.
         *
         * @return The [ClientConfiguration] object.
         */
        fun build() = ClientConfiguration(
            key = key,
            secret = secret,
            endpoint = endpoint?.adhereTo(Contract.TRAILING_SLASH),
            authEndpoint = authEndpoint
        )
    }
}

/**
 * Build a [RuntimeConfigurationProvider] from a [ClientConfiguration].
 */
internal fun ClientConfiguration.toProvider(): RuntimeConfigurationProvider = RuntimeConfigurationProvider(
    key = key,
    secret = secret,
    endpoint = endpoint,
    authEndpoint = authEndpoint
)
