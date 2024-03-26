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

import com.expediagroup.sdk.core.client.BaseRapidClient

/**
 * Configuration for the [BaseRapidClient].
 *
 * @property key The API key to use for authentication.
 * @property secret The API secret to use for authentication.
 * @property endpoint The API endpoint to use for requests.
 * @property requestTimeout The request timeout to be used in milliseconds.
 * @property connectionTimeout The connection timeout to be used in milliseconds.
 * @property socketTimeout The socket timeout to be used in milliseconds.
 * @property maskedLoggingHeaders The headers to be masked in logging.
 * @property maskedLoggingBodyFields The body fields to be masked in logging.
 */
data class RapidClientConfiguration(
    override val key: String? = null,
    override val secret: String? = null,
    override val endpoint: String? = null,
    override val requestTimeout: Long? = null,
    override val connectionTimeout: Long? = null,
    override val socketTimeout: Long? = null,
    override val maskedLoggingHeaders: Set<String>? = null,
    override val maskedLoggingBodyFields: Set<String>? = null
) : ClientConfiguration
