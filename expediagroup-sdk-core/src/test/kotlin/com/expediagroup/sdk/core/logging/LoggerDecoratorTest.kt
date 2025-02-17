package com.expediagroup.sdk.core.logging

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.Logger

class LoggerDecoratorTest {
    private lateinit var mockLogger: Logger
    private lateinit var loggerDecorator: LoggerDecorator

    companion object {
        private const val BASE_DECORATION = "[${Constant.EXPEDIA_GROUP_SDK}] - "
    }

    @BeforeEach
    fun setUp() {
        mockLogger = mockk(relaxed = true)
        loggerDecorator = LoggerDecorator(mockLogger)
    }

    @Test
    fun `info should decorate message and call logger info`() {
        // Arrange
        val message = "Test info message"
        val decoratedMessage = "$BASE_DECORATION$message"

        // Act
        loggerDecorator.info(message)

        // Assert
        verify { mockLogger.info(decoratedMessage) }
    }

    @Test
    fun `warn should decorate message and call logger warn`() {
        // Arrange
        val message = "Test warn message"
        val decoratedMessage = "$BASE_DECORATION$message"

        // Act
        loggerDecorator.warn(message)

        // Assert
        verify { mockLogger.warn(decoratedMessage) }
    }

    @Test
    fun `debug should decorate message and call logger debug`() {
        // Arrange
        val message = "Test debug message"
        val decoratedMessage = "$BASE_DECORATION$message"

        // Act
        loggerDecorator.debug(message)

        // Assert
        verify { mockLogger.debug(decoratedMessage) }
    }

    @Test
    fun `error should decorate message and call logger error`() {
        // Arrange
        val message = "Test error message"
        val decoratedMessage = "$BASE_DECORATION$message"

        // Act
        loggerDecorator.error(message)

        // Assert
        verify { mockLogger.error(decoratedMessage) }
    }

    @Test
    fun `trace should decorate message and call logger trace`() {
        // Arrange
        val message = "Test trace message"
        val decoratedMessage = "$BASE_DECORATION$message"

        // Act
        loggerDecorator.trace(message)

        // Assert
        verify { mockLogger.trace(decoratedMessage) }
    }

    @Test
    fun `info with tags should decorate message with tags and call logger info`() {
        // Arrange
        val message = "Test info message"
        val tags = arrayOf("TAG1", "TAG2")
        val decoratedMessage = "$BASE_DECORATION[${tags.joinToString(", ")}] - $message"

        // Act
        loggerDecorator.info(message, *tags)

        // Assert
        verify { mockLogger.info(decoratedMessage) }
    }

    @Test
    fun `warn with tags should decorate message with tags and call logger warn`() {
        // Arrange
        val message = "Test warn message"
        val tags = arrayOf("TAG1")
        val decoratedMessage = "$BASE_DECORATION[${tags.joinToString(", ")}] - $message"

        // Act
        loggerDecorator.warn(message, *tags)

        // Assert
        verify { mockLogger.warn(decoratedMessage) }
    }

    @Test
    fun `decorate should handle null tags`() {
        // Arrange
        val message = "Test message"
        val expectedDecoration = "$BASE_DECORATION$message"

        // Act
        val result =
            loggerDecorator::class.java
                .getDeclaredMethod("decorate", String::class.java, Set::class.java)
                .apply { isAccessible = true }
                .invoke(loggerDecorator, message, null) as String

        // Assert
        assertEquals(expectedDecoration, result)
    }

    @Test
    fun `decorate should handle empty tags`() {
        // Arrange
        val message = "Test message"
        val expectedDecoration = "$BASE_DECORATION$message"

        // Act
        val result =
            loggerDecorator::class.java
                .getDeclaredMethod("decorate", String::class.java, Set::class.java)
                .apply { isAccessible = true }
                .invoke(loggerDecorator, message, emptySet<String>()) as String

        // Assert
        assertEquals(expectedDecoration, result)
    }

    @Test
    fun `debug with tags should decorate message with tags and call logger debug`() {
        // Arrange
        val message = "Test debug message"
        val tags = arrayOf("DEBUG_TAG1", "DEBUG_TAG2")
        val decoratedMessage = "$BASE_DECORATION[${tags.joinToString(", ")}] - $message"

        // Act
        loggerDecorator.debug(message, *tags)

        // Assert
        verify { mockLogger.debug(decoratedMessage) }
    }

    @Test
    fun `error with tags should decorate message with tags and call logger error`() {
        // Arrange
        val message = "Test error message"
        val tags = arrayOf("ERROR_TAG1", "ERROR_TAG2")
        val decoratedMessage = "$BASE_DECORATION[${tags.joinToString(", ")}] - $message"

        // Act
        loggerDecorator.error(message, *tags)

        // Assert
        verify { mockLogger.error(decoratedMessage) }
    }

    @Test
    fun `trace with tags should decorate message with tags and call logger trace`() {
        // Arrange
        val message = "Test trace message"
        val tags = arrayOf("TRACE_TAG1", "TRACE_TAG2")
        val decoratedMessage = "$BASE_DECORATION[${tags.joinToString(", ")}] - $message"

        // Act
        loggerDecorator.trace(message, *tags)

        // Assert
        verify { mockLogger.trace(decoratedMessage) }
    }
}
