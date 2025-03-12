package com.expediagroup.sdk.core.common

import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ExtensionsTest {
    @Nested
    inner class GetOrThrowTest {
        @Test
        fun `getOrThrow should return value when not null`() {
            // Given
            val value = "Hello, World!"

            // When
            val result = value.getOrThrow { IllegalStateException("Value should not be null") }

            // Expect
            assertEquals("Hello, World!", result)
        }

        @Test
        fun `getOrThrow should throw exception when value is null`() {
            // Given
            val value: String? = null

            // When & Expect
            val exception =
                assertThrows(IllegalStateException::class.java) {
                    value.getOrThrow { IllegalStateException("Value should not be null") }
                }

            assertEquals("Value should not be null", exception.message)
        }
    }

    @Nested
    inner class GetExceptionFromStackTest {
        @Test
        fun `should return exception from exception stack`() {
            // Given
            val exception = RuntimeException("Exception")
            val cause = IllegalStateException("Cause")
            exception.initCause(cause)

            // When
            val result = exception.getExceptionFromStack(IllegalStateException::class.java)

            // Expect
            assertEquals(cause, result)
        }

        @Test
        fun `should return null when exception not found in exception stack`() {
            // Given
            val exception = IllegalStateException("Exception")
            val cause = IllegalArgumentException("Cause")
            exception.initCause(cause)

            // When
            val result = exception.getExceptionFromStack(NullPointerException::class.java)

            // Expect
            assertEquals(null, result)
        }

        @Test
        fun `should not traverse exception stack beyond the passed limit`() {
            val exception1 = Exception()
            val exception2 = Exception()

            exception1.initCause(exception2)
            exception2.initCause(exception1)

            val result = exception1.getExceptionFromStack(RuntimeException::class.java, 10)

            assertNull(result)
        }

        @Test
        fun `should return first exception of the specified type`() {
            val exception =
                Exception().initCause(
                    ExpediaGroupServiceException(
                        message = "first",
                        cause = ExpediaGroupServiceException(message = "second")
                    )
                )

            val result = exception.getExceptionFromStack(ExpediaGroupServiceException::class.java)

            assertInstanceOf(ExpediaGroupServiceException::class.java, result)
            assertEquals("first", result?.message)
        }
    }
}
