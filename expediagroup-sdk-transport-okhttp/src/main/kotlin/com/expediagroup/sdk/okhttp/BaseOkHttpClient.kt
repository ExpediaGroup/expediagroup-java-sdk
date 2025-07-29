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

import okhttp3.OkHttpClient
import java.time.Duration

/**
 * A utility object for managing and configuring a singleton instance of an `OkHttpClient`.
 *
 * The `BaseOkHttpClient` object provides methods to retrieve a singleton instance of
 * `OkHttpClient` and to configure a new instance based on the provided `OkHttpClientConfiguration`.
 * It ensures thread safety and avoids recreating the client unnecessarily.
 *
 * ## Usage
 * - Use `getInstance()` to retrieve the singleton instance of `OkHttpClient`.
 * - Use `getInstance(configuration)` to create a configured `OkHttpClient` instance
 *   with specific settings provided via the `OkHttpClientConfiguration` object.
 */
internal object BaseOkHttpClient {
    /**
     * Volatile storage for the singleton `OkHttpClient` instance.
     * Ensures visibility and prevents duplicate initialization in a multithreaded environment.
     */
    @Volatile
    private var instance: OkHttpClient? = null

    /**
     * Retrieves the singleton instance of `OkHttpClient`.
     *
     * This method ensures that the instance is initialized lazily and safely for concurrent access.
     * If the instance is not yet initialized, it will create a new instance.
     *
     * @return The singleton instance of `OkHttpClient`.
     */
    fun getInstance(): OkHttpClient = instance ?: synchronized(this) {
        OkHttpClient().also { instance = it }
    }

    /**
     * Creates a new `OkHttpClient` instance configured with the provided settings.
     *
     * This method uses the singleton instance as a base and applies the settings specified
     * in the `OkHttpClientConfiguration` object to create a customized `OkHttpClient`.
     *
     * @param configuration The `OkHttpClientConfiguration` containing settings for the client.
     * @return A new `OkHttpClient` instance configured with the specified settings.
     */
    fun getConfiguredInstance(configuration: OkHttpClientConfiguration): OkHttpClient = getInstance()
        .newBuilder()
        .apply {
            configuration.callTimeout?.let {
                callTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.connectTimeout?.let {
                connectTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.readTimeout?.let {
                readTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.writeTimeout?.let {
                writeTimeout(Duration.ofMillis(it.toLong()))
            }
            configuration.connectionPool?.let {
                connectionPool(it)
            }
            configuration.retryOnConnectionFailure?.let {
                retryOnConnectionFailure(it)
            }
            configuration.interceptors?.forEach {
                addInterceptor(it)
            }
            configuration.networkInterceptors?.forEach {
                addNetworkInterceptor(it)
            }
        }.build()
}
