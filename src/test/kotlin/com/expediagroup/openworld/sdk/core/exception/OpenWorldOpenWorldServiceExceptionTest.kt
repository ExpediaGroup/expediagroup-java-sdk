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
package com.expediagroup.openworld.sdk.core.exception

import com.expediagroup.openworld.sdk.core.commons.ClientFactory
import com.expediagroup.openworld.sdk.core.commons.TestConstants.BAD_REQUEST_ATTRIBUTE
import com.expediagroup.openworld.sdk.core.commons.TestConstants.TEST_URL
import com.expediagroup.openworld.sdk.core.model.error.Error
import com.expediagroup.openworld.sdk.core.model.error.ErrorCause
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.HttpStatusCode
import io.ktor.util.AttributeKey
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.net.URI

class OpenWorldOpenWorldServiceExceptionTest {

    @Test
    internal fun `request with invalid body should throw an exception`() {
        runBlocking {
            val httpClient = ClientFactory.createClient().httpClient
            val response = httpClient.get {
                url("http://anyurl")
                setAttributes {
                    put(AttributeKey(BAD_REQUEST_ATTRIBUTE), "any value")
                }
            }

            assertThat(response.status).isEqualTo(HttpStatusCode.BadRequest)

            val error = response.body<Error>()

            assertThat(error).isEqualTo(DEFAULT_ERROR_OBJECT)
        }
    }

    @Test
    internal fun `request with invalid body with PROD profile should throw an exception`() {
        runBlocking {
            val httpClient = ClientFactory.createClient().httpClient
            val response = httpClient.get {
                url("http://anyurl")
                setAttributes {
                    put(AttributeKey(BAD_REQUEST_ATTRIBUTE), "any value")
                }
            }

            assertThat(response.status).isEqualTo(HttpStatusCode.BadRequest)

            val error = response.body<Error>()

            assertThat(error).isEqualTo(DEFAULT_ERROR_OBJECT)
        }
    }

    private companion object {
        private val DEFAULT_ERROR_OBJECT = Error(
            type = URI(TEST_URL),
            detail = "The request failed because one or many input values are invalid. Please see the causes for more details.",
            causes = listOf(
                ErrorCause(
                    type = URI(TEST_URL),
                    detail = "The number of results per page you provided ('NotANumber') is invalid.",
                    location = ErrorCause.Location.QUERY,
                    name = "result",
                    value = "NotANumber"
                )
            )
        )
    }
}
