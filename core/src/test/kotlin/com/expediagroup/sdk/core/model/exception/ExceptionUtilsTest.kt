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
package com.expediagroup.sdk.core.model.exception

import com.expediagroup.sdk.core.model.exception.service.ExpediaGroupServiceException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.UUID

class ExceptionUtilsTest {
    @Nested
    inner class Handle {
        @Test
        fun `should throw ExpediaGroupException when it is ExpediaGroupException`() {
            val exception = ExpediaGroupException()
            try {
                exception.handle()
            } catch (e: Exception) {
                assertTrue(e is ExpediaGroupException)
            }
        }

        @Test
        fun `should throw ExpediaGroupException when cause is ExpediaGroupException`() {
            val exception = RuntimeException(ExpediaGroupException())
            try {
                exception.handle()
            } catch (e: Exception) {
                assertTrue(e is ExpediaGroupException)
            }
        }

        @Test
        fun `should throw ExpediaGroupException even when cause is not ExpediaGroupException`() {
            val exception = RuntimeException("Some message")
            try {
                exception.handle()
            } catch (e: Exception) {
                assertTrue(e is ExpediaGroupServiceException)
                assertEquals("Exception occurred: Some message", (e as ExpediaGroupServiceException).message)
                assertNull(e.transactionId)
            }
        }
    }

    @Nested
    inner class HandleWith {
        @Test
        fun `should throw ExpediaGroupException when it is ExpediaGroupException`() {
            val exception = ExpediaGroupException()
            try {
                exception.handleWith(UUID.randomUUID().toString())
            } catch (e: Exception) {
                assertTrue(e is ExpediaGroupException)
            }
        }

        @Test
        fun `should throw ExpediaGroupException when cause is ExpediaGroupException`() {
            val exception = RuntimeException(ExpediaGroupException())
            try {
                exception.handleWith(UUID.randomUUID().toString())
            } catch (e: Exception) {
                assertTrue(e is ExpediaGroupException)
            }
        }

        @Test
        fun `should throw ExpediaGroupException even when cause is not ExpediaGroupException`() {
            val exception = RuntimeException()
            val transactionId = UUID.randomUUID().toString()
            try {
                exception.handleWith(transactionId)
            } catch (e: Exception) {
                assertTrue(e is ExpediaGroupServiceException)
                assertEquals("Exception occurred for transaction-id [$transactionId]", (e as ExpediaGroupServiceException).message)
                assertEquals(transactionId, e.transactionId)
            }
        }
    }
}
