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
package com.expediagroup.sdk.core.plugin.serialization

import com.expediagroup.sdk.core.plugin.Plugin
import com.google.gson.FieldNamingPolicy
import com.google.gson.JsonDeserializer
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.gson.gson
import java.time.OffsetDateTime

internal object SerializationPlugin : Plugin<SerializationConfiguration> {
    override fun install(configurations: SerializationConfiguration) {
        configurations.httpClientConfiguration.install(ContentNegotiation) {
            when (configurations.contentType.contentSubtype) {
                ContentType.Application.Json.contentSubtype -> gson {
                    setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    setPrettyPrinting().registerTypeAdapter(
                        OffsetDateTime::class.java,
                        JsonDeserializer { json, _, _ ->
                            OffsetDateTime.parse(json.asString)
                        }
                    ).registerTypeAdapter(
                        OffsetDateTime::class.java,
                        JsonSerializer<OffsetDateTime> { time, _, _ ->
                            JsonPrimitive(time.toString())
                        }
                    )
                }
            }
        }
    }
}
