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

import com.expediagroup.common.sdk.core.client.Client
import com.expediagroup.common.sdk.core.configuration.Configurator
import com.expediagroup.common.sdk.core.contract.Contract
import com.expediagroup.common.sdk.core.contract.adhereTo
import com.expediagroup.openworld.sdk.core.client.OpenWorldClient

class OpenWorldConfigrator : Configurator<OpenWorldConfigrator>() {
    private var authEndpoint: String? = null

    /** Sets the API auth endpoint to use for requests.
     *
     * @param authEndpoint The API auth endpoint to use for requests.
     * @return The [OpenWorldConfigrator] instance.
     */
    fun authEndpoint(authEndpoint: String): OpenWorldConfigrator {
        this.authEndpoint = authEndpoint
        return self()
    }

    /** Builds the [OpenWorldClientConfiguration] object. */
    override fun build(): OpenWorldClient = Client.create(
        OpenWorldClientConfiguration(
            key = key,
            secret = secret,
            endpoint = endpoint?.adhereTo(Contract.TRAILING_SLASH),
            authEndpoint = authEndpoint
        )
    )

    override fun self(): OpenWorldConfigrator = this
}
