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
package com.expediagroup.sdk.core.plugin.exception

import com.expediagroup.sdk.core.constant.HeaderKey.TRANSACTION_ID
import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import com.expediagroup.sdk.core.test.ClientFactory
import com.expediagroup.sdk.core.test.MockEngineFactory
import com.expediagroup.sdk.core.test.TestConstants
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.UUID

internal class ExceptionHandlingPluginTest {
    @Test
    fun `request with transaction-id exceptions get wrapped with ExpediaGroupServiceException`() {
        runBlocking {
            val httpClient =
                ClientFactory.createExpediaGroupClient(
                    MockEngineFactory.createEngineWithCustomResponse {
                        throw ArithmeticException("Division by zero")
                    }
                ).httpClient

            val transactionId = UUID.randomUUID().toString()
            val exception =
                assertThrows<ExpediaGroupServiceException> {
                    httpClient.get(TestConstants.ANY_URL) {
                        headers.append(TRANSACTION_ID, transactionId)
                    }
                }
            assertThat(exception.message).isEqualTo("Exception occurred for transaction-id [$transactionId]")
            assertThat(exception.transactionId).isEqualTo(transactionId)
            assertThat(exception).hasCauseExactlyInstanceOf(ArithmeticException::class.java)
            assertThat(exception.cause?.message).isEqualTo("Division by zero")
        }
    }

    @Test
    fun `request without transaction-id exceptions get wrapped with ExpediaGroupServiceException`() {
        runBlocking {
            val httpClient =
                ClientFactory.createExpediaGroupClient(
                    MockEngineFactory.createEngineWithCustomResponse {
                        throw IllegalArgumentException("Argument must be legal")
                    }
                ).httpClient

            val exception =
                assertThrows<ExpediaGroupServiceException> {
                    httpClient.get(TestConstants.ANY_URL)
                }
            assertThat(exception.message).isEqualTo("Exception occurred")
            assertThat(exception.transactionId).isNull()
            assertThat(exception).hasCauseExactlyInstanceOf(IllegalArgumentException::class.java)
            assertThat(exception.cause?.message).isEqualTo("Argument must be legal")
        }
    }
}
