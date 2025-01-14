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
package com.expediagroup.sdk.core.model.paging

import com.expediagroup.sdk.core.constant.Constant.EMPTY_STRING
import com.expediagroup.sdk.core.model.Response
import com.expediagroup.sdk.core.test.ClientFactory.createExpediaGroupClient
import com.expediagroup.sdk.core.test.ClientFactory.createRapidClient
import com.expediagroup.sdk.core.test.MockEngineFactory.createEmptyResponseEngine
import com.expediagroup.sdk.core.test.MockEngineFactory.createGzipEncodedEmptyResponseEngine
import com.expediagroup.sdk.core.test.TestConstants.SUCCESSFUL_DUMMY_REQUEST
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PaginatorTest {
    companion object {
        val client = createExpediaGroupClient()
        val getBody: suspend (HttpResponse) -> String = { it.body<String>() }
    }

    @Nested
    inner class PaginatorTest {
        @Test
        fun `test paginator with one response`() {
            val firstResponse = Response(200, "first", emptyMap())

            val paginator = Paginator(client, firstResponse, getBody)
            assertTrue(paginator.hasNext())
            assertEquals("first", paginator.next())
            assertFalse(paginator.hasNext())
        }

        @Test
        fun `test paginator with multiple responses`() {
            val firstResponse = Response(200, "first", mapOf("link" to listOf("<second>; rel=\"next\"")))

            val paginator = Paginator(client, firstResponse, getBody)
            assertTrue(paginator.hasNext())
            assertEquals("first", paginator.next())
            assertTrue(paginator.hasNext())
            assertEquals(SUCCESSFUL_DUMMY_REQUEST, paginator.next())
            assertFalse(paginator.hasNext())
        }

        @Test
        fun `test paginator with multiple responses and total results`() {
            val firstResponse = Response(200, "first", mapOf("link" to listOf("<second>; rel=\"next\""), "pagination-total-results" to listOf("2")))

            val paginator = Paginator(client, firstResponse, getBody)
            assertTrue(paginator.hasNext())
            assertEquals("first", paginator.next())
            assertTrue(paginator.hasNext())
            assertEquals(SUCCESSFUL_DUMMY_REQUEST, paginator.next())
            assertFalse(paginator.hasNext())
            assertEquals(2, paginator.paginationTotalResults)
        }

        @Test
        fun `test paginator as list`() {
            val firstResponse = Response(200, "first", mapOf("link" to listOf("<second>; rel=\"next\""), "pagination-total-results" to listOf("2")))

            val paginator = Paginator(client, firstResponse, getBody)
            val list = paginator.asSequence().toList()
            assertEquals(2, list.size)
            assertEquals("first", list[0])
            assertEquals(SUCCESSFUL_DUMMY_REQUEST, list[1])
        }
    }

    @Nested
    inner class ResponsePaginatorTest {
        @Test
        fun `test response paginator with one response`() {
            val firstResponse = Response(200, "first", emptyMap())

            val paginator = ResponsePaginator(client, firstResponse, getBody)
            assertTrue(paginator.hasNext())
            assertEquals("first", paginator.next().data)
            assertFalse(paginator.hasNext())
        }

        @Test
        fun `test response paginator with multiple responses`() {
            val firstResponse = Response(200, "first", mapOf("link" to listOf("<second>; rel=\"next\"")))

            val paginator = ResponsePaginator(client, firstResponse, getBody)
            assertTrue(paginator.hasNext())
            assertEquals("first", paginator.next().data)
            assertTrue(paginator.hasNext())
            assertEquals(SUCCESSFUL_DUMMY_REQUEST, paginator.next().data)
            assertFalse(paginator.hasNext())
        }

        @Test
        fun `test response paginator with multiple responses and total results`() {
            val firstResponse = Response(200, "first", mapOf("link" to listOf("<second>; rel=\"next\""), "pagination-total-results" to listOf("2")))

            val paginator = ResponsePaginator(client, firstResponse, getBody)
            assertTrue(paginator.hasNext())
            assertEquals("first", paginator.next().data)
            assertTrue(paginator.hasNext())
            assertEquals(SUCCESSFUL_DUMMY_REQUEST, paginator.next().data)
            assertFalse(paginator.hasNext())
            assertEquals(2, paginator.paginationTotalResults)
        }
    }
}
