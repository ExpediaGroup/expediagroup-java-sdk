/**
 * Copyright (C) 2025 Expedia, Inc.
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

package com.expediagroup.sdk.exemplar.rest.core.mapper

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonMapperBuilder

/**
 * Provides the default [ObjectMapper] instance used for serializing and deserializing API requests and responses.
 *
 * Each product SDK is expected to supply its own [ObjectMapper] to ensure consistent behavior across all SDK operations.
 * This also allows individual SDKs to customize the mapper by registering custom serializers/deserializers
 * or toggling specific Jackson features.
 *
 * This instance should be treated as a singleton and referenced wherever serialization is required.
 * The fully qualified class name is also used by the EG OpenAPI Generator Plugin in the generated code
 * for binding serialization logic.
 */
object DefaultObjectMapper {
    val INSTANCE: ObjectMapper =
        jacksonMapperBuilder()
            .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .build()
            .findAndRegisterModules()
}
