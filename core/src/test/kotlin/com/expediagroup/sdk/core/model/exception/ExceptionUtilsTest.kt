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
                exception.handleWith(UUID.randomUUID().toString())
            } catch (e: Exception) {
                assert(e is ExpediaGroupException)
            }
        }

        @Test
        fun `should throw ExpediaGroupException when cause is ExpediaGroupException`() {
            val exception = RuntimeException(ExpediaGroupException())
            try {
                exception.handleWith(UUID.randomUUID().toString())
            } catch (e: Exception) {
                assert(e is ExpediaGroupException)
            }
        }

        @Test
        fun `should throw ExpediaGroupException even when cause is not ExpediaGroupException`() {
            val exception = RuntimeException()
            try {
                exception.handleWith(UUID.randomUUID().toString())
            } catch (e: Exception) {
                assert(e is ExpediaGroupException)
            }
        }
    }
}
