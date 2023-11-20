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
package com.expediagroup.sdk.domain.rapid

import com.expediagroup.sdk.core.client.BaseRapidClient
import com.expediagroup.sdk.core.configuration.RapidClientConfiguration
import io.ktor.client.statement.HttpResponse
import org.junit.jupiter.api.Test

class RapidHelpersTest {
    companion object {
        val rapidClient =
            object : BaseRapidClient(RapidClientConfiguration()) {
                override suspend fun throwServiceException(
                    response: HttpResponse,
                    operationId: String
                ) {
                    throw UnsupportedOperationException()
                }
            }
    }

    @Test
    fun `Verify extractToken returns token when present`() {
        val url = "https://www.example.com?token=12345"
        val token = RapidHelpers(rapidClient).extractToken(url)
        assert(token == "12345")
    }

    @Test
    fun `Verify extractToken returns null when no token is present`() {
        val url = "https://www.example.com"
        val token = RapidHelpers(rapidClient).extractToken(url)
        assert(token == null)
    }

    @Test
    fun `Verify extractToken returns an empty string when token is empty`() {
        val url = "https://www.example.com?token="
        val token = RapidHelpers(rapidClient).extractToken(url)
        assert(token == "")
    }

    @Test
    fun `Verify extractToken returns token when it is not the first parameter`() {
        val url = "https://www.example.com?foo=bar&token=12345"
        val token = RapidHelpers(rapidClient).extractToken(url)
        assert(token == "12345")
    }

    @Test
    fun `Verify extractToken returns null when token is not provided but other parameters are`() {
        val url = "https://www.example.com?foo=bar"
        val token = RapidHelpers(rapidClient).extractToken(url)
        assert(token == null)
    }

    @Test
    fun `Verify extractToken returns null when token is not provided but multiple other parameters are`() {
        val url = "https://www.example.com?foo=bar&baz=qux"
        val token = RapidHelpers(rapidClient).extractToken(url)
        assert(token == null)
    }

    @Test
    fun `Verify extractToken returns it when token is not the last parameter`() {
        val url = "https://www.example.com?token=12345&foo=bar"
        val token = RapidHelpers(rapidClient).extractToken(url)
        assert(token == "12345")
    }
}
