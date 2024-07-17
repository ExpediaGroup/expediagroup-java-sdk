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

import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Test
import java.util.UUID

class TransactionIdTest {
    private val uuids = listOf(UUID.randomUUID(), UUID.randomUUID())

    @Test
    fun `peek should return a UUID`() {
        mockkStatic(UUID::class) {
            every { UUID.randomUUID() } returnsMany uuids
            val transactionId = TransactionId()
            assert(transactionId.peek() == uuids[0])
            assert(transactionId.peek() == uuids[0])
        }
    }

    @Test
    fun `dequeue should return a UUID and change it`() {
        mockkStatic(UUID::class) {
            every { UUID.randomUUID() } returnsMany uuids
            val transactionId = TransactionId()
            assert(transactionId.dequeue() == uuids[0])
            assert(transactionId.peek() == uuids[1])
        }
    }
}
