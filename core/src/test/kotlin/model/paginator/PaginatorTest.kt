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
package model.paginator

import com.expediagroup.sdk.core.model.Response
import com.expediagroup.sdk.core.model.paging.Paginator
import com.expediagroup.sdk.core.model.paging.ResponsePaginator
import com.expediagroup.sdk.core.test.ClientFactory.createExpediaGroupClient
import com.expediagroup.sdk.core.test.TestConstants.SUCCESSFUL_DUMMY_REQUEST
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PaginatorTest {
    @Nested
    inner class PaginatorTest {
        @Test
        fun `test paginator with one response`() {
            val client = createExpediaGroupClient()
            val firstResponse = Response(200, "first", emptyMap())
            val getBody: suspend (HttpResponse) -> String = { it.body<String>() }

            val paginator = Paginator(client, firstResponse, getBody)
            assert(paginator.hasNext())
            assert(paginator.next() == "first")
            assert(!paginator.hasNext())
        }

        @Test
        fun `test paginator with multiple responses`() {
            val client = createExpediaGroupClient()
            val firstResponse = Response(200, "first", mapOf("link" to listOf("<second>; rel=\"next\"")))
            val getBody: suspend (HttpResponse) -> String = { it.body<String>() }

            val paginator = Paginator(client, firstResponse, getBody)
            assert(paginator.hasNext())
            assert(paginator.next() == "first")
            assert(paginator.hasNext())
            assert(paginator.next() == SUCCESSFUL_DUMMY_REQUEST)
            assert(!paginator.hasNext())
        }

        @Test
        fun `test paginator with multiple responses and total results`() {
            val client = createExpediaGroupClient()
            val firstResponse = Response(200, "first", mapOf("link" to listOf("<second>; rel=\"next\""), "pagination-total-results" to listOf("2")))
            val getBody: suspend (HttpResponse) -> String = { it.body<String>() }

            val paginator = Paginator(client, firstResponse, getBody)
            assert(paginator.hasNext())
            assert(paginator.next() == "first")
            assert(paginator.hasNext())
            assert(paginator.next() == SUCCESSFUL_DUMMY_REQUEST)
            assert(!paginator.hasNext())
            assert(paginator.paginationTotalResults == 2L)
        }

        @Test
        fun `test paginator as list`() {
            val client = createExpediaGroupClient()
            val firstResponse = Response(200, "first", mapOf("link" to listOf("<second>; rel=\"next\""), "pagination-total-results" to listOf("2")))
            val getBody: suspend (HttpResponse) -> String = { it.body<String>() }

            val paginator = Paginator(client, firstResponse, getBody)
            val list = paginator.asSequence().toList()
            assert(list.size == 2)
            assert(list[0] == "first")
            assert(list[1] == SUCCESSFUL_DUMMY_REQUEST)
        }
    }

    @Nested
    inner class ResponsePaginatorTest {
        @Test
        fun `test response paginator with one response`() {
            val client = createExpediaGroupClient()
            val firstResponse = Response(200, "first", emptyMap())
            val getBody: suspend (HttpResponse) -> String = { it.body<String>() }

            val paginator = ResponsePaginator(client, firstResponse, getBody)
            assert(paginator.hasNext())
            assert(paginator.next().body == "first")
            assert(!paginator.hasNext())
        }

        @Test
        fun `test response paginator with multiple responses`() {
            val client = createExpediaGroupClient()
            val firstResponse = Response(200, "first", mapOf("link" to listOf("<second>; rel=\"next\"")))
            val getBody: suspend (HttpResponse) -> String = { it.body<String>() }

            val paginator = ResponsePaginator(client, firstResponse, getBody)
            assert(paginator.hasNext())
            assert(paginator.next().body == "first")
            assert(paginator.hasNext())
            assert(paginator.next().body == SUCCESSFUL_DUMMY_REQUEST)
            assert(!paginator.hasNext())
        }

        @Test
        fun `test response paginator with multiple responses and total results`() {
            val client = createExpediaGroupClient()
            val firstResponse = Response(200, "first", mapOf("link" to listOf("<second>; rel=\"next\""), "pagination-total-results" to listOf("2")))
            val getBody: suspend (HttpResponse) -> String = { it.body<String>() }

            val paginator = ResponsePaginator(client, firstResponse, getBody)
            assert(paginator.hasNext())
            assert(paginator.next().body == "first")
            assert(paginator.hasNext())
            assert(paginator.next().body == SUCCESSFUL_DUMMY_REQUEST)
            assert(!paginator.hasNext())
            assert(paginator.paginationTotalResults == 2L)
        }
    }
}
