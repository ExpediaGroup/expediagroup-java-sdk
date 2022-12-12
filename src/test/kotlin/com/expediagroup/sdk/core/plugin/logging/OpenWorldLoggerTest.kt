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
package com.expediagroup.sdk.core.plugin.logging

import com.expediagroup.sdk.core.constant.LoggingMessage.LOGGING_PREFIX
import io.mockk.every
import io.mockk.mockkClass
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.slf4j.Logger

class OpenWorldLoggerTest {
    @Test
    fun `should prepend info logging`() {
        val mockedLogger = createMockedLogger()
        val openWorldLogger = OpenWorldLogger(mockedLogger)

        val message = "message"
        openWorldLogger.info(message)

        verify(exactly = 1) { mockedLogger.info("$LOGGING_PREFIX $message") }
    }

    @Test
    fun `should prepend warn logging`() {
        val mockedLogger = createMockedLogger()
        val openWorldLogger = OpenWorldLogger(mockedLogger)

        val message = "message"
        openWorldLogger.warn(message)

        verify(exactly = 1) { mockedLogger.warn("$LOGGING_PREFIX $message") }
    }

    private fun createMockedLogger(): Logger {
        val mockedLogger = mockkClass(Logger::class)
        every { mockedLogger.info(any()) }.answers { }
        every { mockedLogger.warn(any()) }.answers { }
        return mockedLogger
    }
}
