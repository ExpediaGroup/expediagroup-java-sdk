package com.expediagroup.sdk.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class HeadersTest {
    @Test
    fun `should return header value when header exists with single value`() {
        // Given
        val headers =
            Headers
                .builder()
                .add("content-type", "application/json")
                .build()

        // When
        val headerValue = headers.get("content-type")

        // Expect
        assertEquals("application/json", headerValue)
    }

    @Test
    fun `should return first header value when header exists with multiple values`() {
        // Given
        val headers =
            Headers
                .builder()
                .add("accept", listOf("application/json", "text/plain"))
                .build()

        // When
        val headerValue = headers.get("accept")

        // Expect
        assertEquals("application/json", headerValue)
    }

    @Test
    fun `should return null value when header does not exist`() {
        // Given
        val headers =
            Headers
                .builder()
                .add("content-Type", "application/json")
                .build()

        // When
        val headerValue = headers.get("accept")

        // Expect
        assertNull(headerValue)
    }

    @Test
    fun `should return the value for the matched header name case-insensitive`() {
        // Given
        val headers =
            Headers
                .builder()
                .add("content-type", "application/json")
                .build()

        // When
        val value1 = headers.get("content-type")
        val value2 = headers.get("CONTENT-TYPE")

        // Expect
        assertEquals("application/json", value1)
        assertEquals("application/json", value2)
    }

    @Test
    fun `should return all values when header exists with multiple values`() {
        // Given
        val headers =
            Headers
                .builder()
                .add("accept", listOf("application/json", "text/plain"))
                .build()

        // When
        val headersValues = headers.values("accept")

        // Expect
        assertEquals(listOf("application/json", "text/plain"), headersValues)
    }

    @Test
    fun `should return empty list if the header does not exist`() {
        // Given
        val headers =
            Headers
                .builder()
                .add("accept", listOf("application/json", "text/plain"))
                .build()

        // When
        val headersValues = headers.values("content-type")

        // Expect
        assertEquals(emptyList<String>(), headersValues)
    }

    @Test
    fun `should return all values for the matched header name case-insensitive`() {
        // Given
        val headers =
            Headers
                .Builder()
                .add("accept", listOf("application/json", "text/plain"))
                .build()

        // When
        val headersNames = headers.values("accept")

        // Expect
        assertEquals(listOf("application/json", "text/plain"), headersNames)
    }

    @Test
    fun `should return all headers names`() {
        // Given
        val headers =
            Headers
                .builder()
                .add("accept", listOf("application/json", "text/plain"))
                .add("content-type", "application/json")
                .build()

        // When
        val headersNames = headers.names()

        // Expect
        assertEquals(setOf("accept", "content-type"), headersNames)
    }

    @Test
    fun `should return empty set if no headers exist`() {
        // Given
        val headers = Headers.builder().build()

        // When
        val headersNames = headers.names()

        // Expect
        assertEquals(emptySet<String>(), headersNames)
    }

    @Test
    fun `should return all headers entries`() {
        // Given
        val headers =
            Headers
                .builder()
                .add("accept", listOf("application/json", "text/plain"))
                .add("content-type", "application/json")
                .build()

        // When
        val headersEntries = headers.entries()

        // Expect
        val expectedEntries =
            mapOf(
                "accept" to listOf("application/json", "text/plain"),
                "content-type" to listOf("application/json")
            ).entries

        assertEquals(expectedEntries, headersEntries)
    }

    @Test
    fun `should return empty set of entries if no headers exist`() {
        // Given
        val headers = Headers.builder().build()

        // When
        val headersEntries = headers.entries()

        // Expect
        assertEquals(emptySet<Map.Entry<String, List<String>>>(), headersEntries)
    }

    @Test
    fun `should create a builder with existing headers`() {
        // Given
        val originalHeaders =
            Headers
                .builder()
                .add("accept", "application/json")
                .add("content-type", "application/xml")
                .build()

        // When
        val newHeaders =
            originalHeaders
                .newBuilder()
                .add("accept", "text/plain")
                .remove("content-type")
                .build()

        // Expect
        assertEquals("application/json", newHeaders.get("accept"))
        assertEquals(listOf("application/json", "text/plain"), newHeaders.values("accept"))
        assertNull(newHeaders.get("content-type"))
        assertFalse(newHeaders.names().contains("content-type"))
    }

    @Test
    fun `should return the correct string representation`() {
        //  Given
        val headers =
            Headers
                .builder()
                .add("accept", "application/json")
                .add("content-type", "application/xml")
                .build()

        // When
        val headersString = headers.toString()

        // Expect
        assertEquals("{accept=[application/json], content-type=[application/xml]}", headersString)
    }

    @Test
    fun `should return empty brackets when no headers exist`() {
        // Given
        val headers = Headers.builder().build()

        // When
        val headersString = headers.toString()

        // Expect
        assertEquals("{}", headersString)
    }

    @Nested
    inner class BuilderTests {
        @Test
        fun `should add single header with valid name and value as expected`() {
            // Given
            val headers =
                Headers
                    .builder()
                    .add("content-type", "application/json")
                    .build()

            // When
            val value1 = headers.get("Content-Type")
            val value2 = headers.get("content-type")
            val value3 = headers.get("CONTENT-TYPE")
            val values = headers.values("Content-Type")

            // Expect
            assertEquals("application/json", value1)
            assertEquals("application/json", value2)
            assertEquals("application/json", value3)
            assertEquals(listOf("application/json"), values)
        }

        @Test
        fun `should add multiple values for one header name`() {
            // Given
            val headers =
                Headers
                    .builder()
                    .add("accept", "application/json")
                    .add("accept", "text/plain")
                    .build()

            // When
            val value = headers.get("accept")
            val values = headers.values("accept")

            // Expect
            assertEquals("application/json", value)
            assertEquals(listOf("application/json", "text/plain"), values)
            assertEquals(2, values.size)
        }

        @Test
        fun `should add multiple values with valid name and values`() {
            // Given
            val headerName = "accept"
            val headerValues = listOf("application/json", "text/plain")

            // When
            val headers =
                Headers
                    .builder()
                    .add(headerName, headerValues)
                    .build()

            // Expect
            assertEquals("application/json", headers.get("accept"))
            assertEquals(headerValues, headers.values("accept"))
        }

        @Test
        fun `should set (override) single header with valid name and value`() {
            // Given
            val headerName = "accept"
            val headerValue1 = "application/json"
            val headerValue2 = "text/plain"

            // When
            val headers =
                Headers
                    .builder()
                    .add(headerName, headerValue1)
                    .set(headerName, headerValue2)
                    .build()

            // Expect
            assertEquals(headerValue2, headers.get(headerName))
            assertEquals(listOf(headerValue2), headers.values(headerName))
        }

        @Test
        fun `should set multiple values with valid name and values`() {
            // Given
            val headerName = "accept"
            val initialHeaderValues = listOf("application/json", "text/plain")
            val newHeaderValues = listOf("application/xml", "text/html")

            // When
            val headers =
                Headers
                    .builder()
                    .add(headerName, initialHeaderValues)
                    .set(headerName, newHeaderValues)
                    .build()

            // Expect
            assertEquals("application/xml", headers.get("accept"))
            assertEquals(newHeaderValues, headers.values("accept"))
        }

        @Test
        fun `should remove existing header as expected`() {
            // Given
            val headerName = "accept"
            val headerValue = "application/json"

            // When
            val headers =
                Headers
                    .builder()
                    .add(headerName, headerValue)
                    .remove(headerName)
                    .build()

            // Expect
            assertNull(headers.get(headerName))
            assertTrue(headers.values(headerName).isEmpty())
            assertFalse(headers.names().contains(headerName))
        }

        @Test
        fun `should handle removing non-existing header as expected`() {
            // Given
            val headerName = "accept"
            val headerValue = "application/json"

            // When
            val headers =
                Headers
                    .builder()
                    .add(headerName, headerValue)
                    .remove("content-type")
                    .build()

            // Expect
            assertEquals("application/json", headers.get("accept"))
            assertEquals(listOf("application/json"), headers.values("accept"))
            assertFalse(headers.names().contains("content-type"))
        }

        @Test
        fun `should build Headers with no headers as expected`() {
            // Given
            val headersBuilder = Headers.builder()

            // When
            val headers = headersBuilder.build()

            // Expect
            assertTrue(headers.names().isEmpty())
            assertTrue(headers.entries().isEmpty())
        }

        @Test
        fun `should initialize the Builder with existing Headers`() {
            // Given
            val originalHeaders =
                Headers
                    .builder()
                    .add("Accept", "application/json")
                    .add("Content-Type", "application/xml")
                    .build()

            // When
            val newHeaders =
                Headers
                    .builder(originalHeaders)
                    .add("Accept", "text/plain")
                    .remove("Content-Type")
                    .build()

            // Expect
            assertEquals("application/json", newHeaders.get("Accept"))
            assertEquals(listOf("application/json", "text/plain"), newHeaders.values("Accept"))
            assertNull(newHeaders.get("Content-Type"))
            assertFalse(newHeaders.names().contains("content-type"))
        }

        @Test
        fun `should maintain original Headers immutability when instantiating a new builder from it`() {
            // Given
            val builder = Headers.builder().add("accept", "application/json")

            // When
            val headers = builder.build()
            builder.add("content-type", "application/xml")

            // Expect
            assertEquals("application/json", headers.get("accept"))
            assertNull(headers.get("content-type"))
        }

        @Test
        fun `should lowercase and trim the header name`() {
            // Given
            val headers = Headers.builder().add(" Accept ", "application/json").build()

            // When
            val headerName = headers.names().first()

            // Expect
            assertEquals("accept", headerName)
        }
    }
}
