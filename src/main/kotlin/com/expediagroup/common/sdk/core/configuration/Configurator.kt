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
package com.expediagroup.common.sdk.core.configuration

import com.expediagroup.common.sdk.core.client.Client
import com.expediagroup.common.sdk.core.contract.Contract
import com.expediagroup.common.sdk.core.contract.adhereTo

abstract class Configurator<SELF : Configurator<SELF>> {
    protected var key: String? = null
    protected var secret: String? = null
    protected var endpoint: String? = null

    /** Sets the API key to use for authentication.
     *
     * @param key The API key to use for authentication.
     * @return The [Builder] instance.
     */
    fun key(key: String): SELF {
        this.key = key
        return self()
    }

    /** Sets the API secret to use for authentication.
     *
     * @param secret The API secret to use for authentication.
     * @return The [Builder] instance.
     */
    fun secret(secret: String): SELF {
        this.secret = secret
        return self()
    }

    /** Sets the API endpoint to use for requests.
     *
     * @param endpoint The API endpoint to use for requests.
     * @return The [Builder] instance.
     */
    fun endpoint(endpoint: String): SELF {
        this.endpoint = endpoint.adhereTo(Contract.TRAILING_SLASH)
        return self()
    }

    /** Builds the [Client] object. */
    abstract fun build(): Client

    @Suppress("UNCHECKED_CAST") // This is safe because of the type parameter
    protected open fun self(): SELF = this as SELF
}
