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
package com.expediagroup.sdk.core.model

import org.junit.jupiter.api.Test

class ResponseTest {
    @Test
    fun `test toHeadersMap`() {
        val headers: Set<Map.Entry<String, List<String>>> =
            setOf(
                mapOf("key1" to listOf("value1")).entries.first(),
                mapOf("key2" to listOf("value2")).entries.first()
            )

        val result = Response.toHeadersMap(headers)

        assert(result.size == 2)
        assert(result["key1"] == listOf("value1"))
        assert(result["key2"] == listOf("value2"))
    }

    @Test
    fun `test toString`() {
        val response = Response(200, "body", mapOf("key" to listOf("value")))

        val result = response.toString()

        assert(result == "Response(statusCode=200, body=body, headers={key=[value]})")
    }

    @Test
    fun `test EmptyResponse toString`() {
        val response = EmptyResponse(200, mapOf("key" to listOf("value")))

        val result = response.toString()

        assert(result == "EmptyResponse(statusCode=200, headers={key=[value]})")
    }
}
