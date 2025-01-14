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
import com.expediagroup.sdk.core.constant.LoggingMessage.OMITTED
import io.mockk.every
import io.mockk.mockkClass
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.slf4j.Logger

class ExpediaGroupLoggerTest {
    @Test
    fun `should prepend info logging`() {
        val mockedLogger = createMockedLogger()
        val expediaGroupLogger = ExpediaGroupLogger(mockedLogger)

        val message = "message"
        expediaGroupLogger.info(message)

        verify(exactly = 1) { mockedLogger.info("$LOGGING_PREFIX $message") }
    }

    @Test
    fun `should prepend warn logging`() {
        val mockedLogger = createMockedLogger()
        val expediaGroupLogger = ExpediaGroupLogger(mockedLogger)

        val message = "message"
        expediaGroupLogger.warn(message)

        verify(exactly = 1) { mockedLogger.warn("$LOGGING_PREFIX $message") }
    }

    @Test
    fun `should mask pci-related fields`() {
        val mockedLogger = createMockedLogger()
        val expediaGroupLogger = ExpediaGroupLogger(mockedLogger)

        val message = """METHOD: HttpMethod(value=POST)
                        COMMON HEADERS
                        -> Accept: application/json
                        -> Accept-Charset: UTF-8
                        -> Accept-Encoding: gzip
                        CONTENT HEADERS
                        -> Content-Length: 0
                        BODY Content-Type: application/json; charset=UTF-8
                        BODY START
                        { "field1": "value1", "cvv": "123", "card_number": "0123456789123456", "field": "value2" }
                        BODY END"""
        expediaGroupLogger.info(message)

        val expectedLog = """$LOGGING_PREFIX METHOD: HttpMethod(value=POST)
                        COMMON HEADERS
                        -> Accept: application/json
                        -> Accept-Charset: UTF-8
                        -> Accept-Encoding: gzip
                        CONTENT HEADERS
                        -> Content-Length: 0
                        BODY Content-Type: application/json; charset=UTF-8
                        BODY START
                        { "field1": "value1", "cvv": "$OMITTED", "card_number": "$OMITTED", "field": "value2" }
                        BODY END"""
        verify(exactly = 1) { mockedLogger.info(expectedLog) }
    }

    private fun createMockedLogger(): Logger {
        val mockedLogger: Logger = mockkClass(Logger::class)
        every { mockedLogger.info(any()) }.answers { }
        every { mockedLogger.warn(any()) }.answers { }
        every { mockedLogger.isInfoEnabled }.answers { true }
        every { mockedLogger.isWarnEnabled }.answers { true }
        return mockedLogger
    }
}
