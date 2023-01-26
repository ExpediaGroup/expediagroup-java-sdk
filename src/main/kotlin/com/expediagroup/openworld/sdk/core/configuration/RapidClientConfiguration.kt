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
package com.expediagroup.openworld.sdk.core.configuration

/**
 * SDK Client Configurations Provider.
 *
 * @property key The API key to use for authentication.
 * @property secret The API secret to use for authentication.
 * @property endpoint The API endpoint to use for requests.
 */
data class RapidClientConfiguration(
    val key: String? = null,
    val secret: String? = null,
    val endpoint: String? = null
) {

    companion object {
        /** An empty configuration. */
        @JvmField
        val EMPTY = RapidClientConfiguration()

        /** Creates a new RapidClientConfigurations.Builder instance. */
        @JvmStatic
        fun builder() = Builder()
    }

    internal fun toClientConfiguration(): ClientConfiguration = ClientConfiguration(key, secret, endpoint, null)

    /**
     * A Builder for [RapidClientConfiguration] Provider.
     */
    class Builder {
        private var key: String? = null
        private var secret: String? = null
        private var endpoint: String? = null

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
        fun endpoint(endpoint: String) = apply { this.endpoint = endpoint }

        /** Builds the [RapidClientConfiguration] object.
         *
         * @return The [RapidClientConfiguration] object.
         */
        fun build() = RapidClientConfiguration(
            key = key,
            secret = secret,
            endpoint = endpoint
        )
    }
}
