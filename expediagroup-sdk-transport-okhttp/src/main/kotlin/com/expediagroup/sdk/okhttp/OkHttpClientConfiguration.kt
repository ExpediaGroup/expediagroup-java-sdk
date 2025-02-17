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

package com.expediagroup.sdk.okhttp

import okhttp3.ConnectionPool
import okhttp3.Interceptor

/**
 * Represents configuration options for an `OkHttpClient` instance.
 *
 * The `OkHttpClientConfiguration` class encapsulates various settings that can be applied
 * to an `OkHttpClient`, including interceptors, timeouts, connection pooling, and retry behavior.
 * It provides a nested `Builder` class for constructing instances in a flexible and fluent manner.
 *
 * ## Configuration Options
 * - **Interceptors**: Application-level interceptors for modifying requests or responses.
 * - **Network Interceptors**: Network-level interceptors for observing network traffic.
 * - **Connection Pool**: Customizes the connection pooling behavior.
 * - **Retry on Connection Failure**: Specifies whether the client should retry failed connections.
 * - **Timeouts**: Configures call, connect, read, and write timeouts.
 *
 * ## Example Usage
 * ```kotlin
 * val configuration = OkHttpClientConfiguration.builder()
 *     .interceptors(listOf(loggingInterceptor))
 *     .callTimeout(30_000) // 30 seconds
 *     .connectTimeout(10_000) // 10 seconds
 *     .retryOnConnectionFailure(true)
 *     .build()
 * ```
 *
 * @property interceptors A list of application-level interceptors to apply.
 * @property networkInterceptors A list of network-level interceptors to apply.
 * @property connectionPool The connection pool configuration.
 * @property retryOnConnectionFailure Whether to retry on connection failure.
 * @property callTimeout The timeout for a complete HTTP call, in milliseconds.
 * @property connectTimeout The timeout for establishing a connection, in milliseconds.
 * @property readTimeout The timeout for reading data from a connection, in milliseconds.
 * @property writeTimeout The timeout for writing data to a connection, in milliseconds.
 */
@ConsistentCopyVisibility
data class OkHttpClientConfiguration private constructor(
    val interceptors: List<Interceptor>? = null,
    val networkInterceptors: List<Interceptor>? = null,
    val connectionPool: ConnectionPool? = null,
    val retryOnConnectionFailure: Boolean? = null,
    val callTimeout: Int? = null,
    val connectTimeout: Int? = null,
    val readTimeout: Int? = null,
    val writeTimeout: Int? = null,
) {

    /**
     * A builder class for constructing `OkHttpClientConfiguration` instances.
     *
     * The `Builder` class provides a fluent API for setting configuration options
     * and creating an instance of `OkHttpClientConfiguration`.
     *
     * ## Example Usage
     * ```kotlin
     * val configuration = OkHttpClientConfiguration.builder()
     *     .callTimeout(15_000)
     *     .readTimeout(20_000)
     *     .retryOnConnectionFailure(true)
     *     .build()
     * ```
     */
    open class Builder {
        private var interceptors: List<Interceptor>? = null
        private var networkInterceptors: List<Interceptor>? = null
        private var connectionPool: ConnectionPool? = null
        private var retryOnConnectionFailure: Boolean? = null
        private var callTimeout: Int? = null
        private var connectTimeout: Int? = null
        private var readTimeout: Int? = null
        private var writeTimeout: Int? = null

        /**
         * Sets the application-level interceptors.
         * @param interceptors A list of interceptors to apply.
         * @return The builder instance.
         */
        fun interceptors(interceptors: List<Interceptor>) = apply {
            this.interceptors = interceptors
        }

        /**
         * Sets the network-level interceptors.
         * @param networkInterceptors A list of interceptors to apply.
         * @return The builder instance.
         */
        fun networkInterceptors(networkInterceptors: List<Interceptor>) = apply {
            this.networkInterceptors = networkInterceptors
        }

        /**
         * Sets the connection pool configuration.
         *
         * **WARNING: This configuration will create a new connection pool for the new instance and will not be shared
         * with the base instance.**
         *
         * @param connectionPool The connection pool to use.
         * @return The builder instance.
         */
        fun connectionPool(connectionPool: ConnectionPool) = apply {
            this.connectionPool = connectionPool
        }

        /**
         * Sets whether to retry on connection failure.
         * @param retryOnConnectionFailure `true` to retry on failure, `false` otherwise.
         * @return The builder instance.
         */
        fun retryOnConnectionFailure(retryOnConnectionFailure: Boolean) = apply {
            this.retryOnConnectionFailure = retryOnConnectionFailure
        }

        /**
         * Sets the call timeout.
         * @param callTimeout The timeout duration in milliseconds.
         * @return The builder instance.
         */
        fun callTimeout(callTimeout: Int) = apply {
            this.callTimeout = callTimeout
        }

        /**
         * Sets the connection timeout.
         * @param connectTimeout The timeout duration in milliseconds.
         * @return The builder instance.
         */
        fun connectTimeout(connectTimeout: Int) = apply {
            this.connectTimeout = connectTimeout
        }

        /**
         * Sets the read timeout.
         * @param readTimeout The timeout duration in milliseconds.
         * @return The builder instance.
         */
        fun readTimeout(readTimeout: Int) = apply {
            this.readTimeout = readTimeout
        }

        /**
         * Sets the write timeout.
         * @param writeTimeout The timeout duration in milliseconds.
         * @return The builder instance.
         */
        fun writeTimeout(writeTimeout: Int) = apply {
            this.writeTimeout = writeTimeout
        }

        /**
         * Builds and returns an `OkHttpClientConfiguration` instance.
         *
         * @return A configured instance of `OkHttpClientConfiguration`.
         */
        fun build(): OkHttpClientConfiguration {
            return OkHttpClientConfiguration(
                interceptors,
                networkInterceptors,
                connectionPool,
                retryOnConnectionFailure,
                callTimeout,
                connectTimeout,
                readTimeout,
                writeTimeout
            )
        }
    }

    companion object {
        /**
         * Creates a new builder for constructing an `OkHttpClientConfiguration`.
         *
         * @return A new instance of `Builder`.
         */
        @JvmStatic
        fun builder() = Builder()
    }
}
