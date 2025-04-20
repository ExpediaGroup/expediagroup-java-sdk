package com.expediagroup.sdk.rest.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UrlUtilsTest {
    @Nested
    inner class ParsePathParamsTest {
        @Test
        fun `parses path template parameters correctly`() {
            // Given
            val template = "/api/v1/users/{userId}/posts/{postId}"
            val path = "/api/v1/users/123/posts/456"

            // When
            val result =
                UrlUtils.parsePathParams(
                    template = template,
                    path = path
                )

            // Then
            val expected =
                mapOf(
                    "userId" to "123",
                    "postId" to "456"
                )
            assertEquals(expected, result)
        }

        @Test
        fun `throws illegalArgumentException when template and path do not match`() {
            // Given
            val template = "/api/v1/users"
            val path = "/api/v1/users/123/posts/456"

            // When
            val exception =
                assertThrows<IllegalArgumentException> {
                    UrlUtils.parsePathParams(
                        template = template,
                        path = path
                    )
                }

            // Then
            val expectedExceptionMessage = "Template and path must contain the same number of segments"

            assertEquals(expectedExceptionMessage, exception.message)
        }

        @Test
        fun `returns empty map when template and path are identical`() {
            // Given
            val template = "/api/v1/users/123/posts/456"
            val path = "/api/v1/users/123/posts/456"

            // When
            val result =
                UrlUtils.parsePathParams(
                    template = template,
                    path = path
                )

            // Then
            assertEquals(emptyMap<String, String>(), result)
        }

        @ParameterizedTest
        @ValueSource(
            strings = [
                "{id",
                "id}",
                "i{d}",
                "{i}d"
            ]
        )
        fun `does not parse param when param format is invalid`(paramTemplate: String) {
            // Given
            val template = "/api/v1/users/$paramTemplate"
            val path = "/api/v1/users/123"

            // When
            val result =
                UrlUtils.parsePathParams(
                    template = template,
                    path = path
                )

            // Then
            assertEquals(emptyMap<String, String>(), result)
        }

        @Test
        fun `returns empty map when template and path are empty`() {
            // Given
            val template = ""
            val path = ""

            // When
            val result =
                UrlUtils.parsePathParams(
                    template = template,
                    path = path
                )

            // Then
            assertEquals(emptyMap<String, String>(), result)
        }
    }

    @Nested
    inner class ParseQueryParamsTest {
        @Test
        fun `parses query string with pipe-delimited values using pipe strategy`() {
            val query = "key=value1|value2|value3&key2=value1,value2"
            val destringifyStrategies =
                mapOf(
                    "key" to "pipes",
                    "key2" to "csv"
                )

            val result = UrlUtils.parseQueryParams(query, destringifyStrategies)

            val expected =
                mapOf(
                    "key" to mutableListOf("value1", "value2", "value3"),
                    "key2" to mutableListOf("value1", "value2")
                )

            assertEquals(expected, result)
        }

        @Test
        fun `parses query string with comma-separated values using csv strategy`() {
            val query = "key=value1,value2,value3"
            val destringifyStrategies = mapOf("key" to "csv")

            val result = UrlUtils.parseQueryParams(query, destringifyStrategies)

            val expected =
                mapOf(
                    "key" to mutableListOf("value1", "value2", "value3")
                )
            assertEquals(expected, result)
        }

        @Test
        fun `parses query string with single key-value pair correctly`() {
            val query = "key=value"
            val destringifyStrategies = emptyMap<String, String>()

            val result = UrlUtils.parseQueryParams(query, destringifyStrategies)

            val expected =
                mapOf(
                    "key" to mutableListOf("value")
                )
            assertEquals(expected, result)
        }

        @Test
        fun `parses query string with multiple key-value pairs correctly`() {
            val query = "key1=value1&key2=value2"
            val destringifyStrategies = emptyMap<String, String>()

            val result = UrlUtils.parseQueryParams(query, destringifyStrategies)

            val expected =
                mapOf(
                    "key1" to mutableListOf("value1"),
                    "key2" to mutableListOf("value2")
                )
            assertEquals(expected, result)
        }

        @Test
        fun `parses query string with space-delimited values using space strategy`() {
            val query = "key=value1%20value2%20value3"
            val destringifyStrategies = mapOf("key" to "ssv")

            val result = UrlUtils.parseQueryParams(query, destringifyStrategies)

            val expected =
                mapOf(
                    "key" to mutableListOf("value1", "value2", "value3")
                )
            assertEquals(expected, result)
        }

        @Test
        fun `parses query string with special characters correctly`() {
            val query = "key1=value%201&key2=value%2C2"
            val destringifyStrategies = emptyMap<String, String>()

            val result = UrlUtils.parseQueryParams(query, destringifyStrategies)

            val expected =
                mapOf(
                    "key1" to mutableListOf("value 1"),
                    "key2" to mutableListOf("value,2")
                )
            assertEquals(expected, result)
        }

        @Test
        fun `ignores empty query string and returns empty map`() {
            val query = ""
            val destringifyStrategies = emptyMap<String, String>()

            val result = UrlUtils.parseQueryParams(query, destringifyStrategies)

            assertEquals(emptyMap<String, MutableList<String>>(), result)
        }

        @Test
        fun `ignores invalid query parameters with missing keys or values`() {
            val query = "key1=value1&=value2&key3="
            val destringifyStrategies = emptyMap<String, String>()

            val result = UrlUtils.parseQueryParams(query, destringifyStrategies)

            val expected =
                mapOf(
                    "key1" to mutableListOf("value1")
                )
            assertEquals(expected, result)
        }

        @Test
        fun `parses query parameters correctly with multiple destringify strategies`() {
            // Given
            val query = "param1=value1&param1=value2&param2=value2&csvarray=2,3,4&pipesarray=5|6|7"
            val destringifyStrategies =
                mapOf(
                    "csvarray" to "csv",
                    "pipesarray" to "pipes"
                )

            // When
            val result =
                UrlUtils.parseQueryParams(
                    query = query,
                    destringifyStrategies = destringifyStrategies
                )

            // Then
            val expected =
                mapOf(
                    "param1" to mutableListOf("value1", "value2"),
                    "param2" to mutableListOf("value2"),
                    "csvarray" to mutableListOf("2", "3", "4"),
                    "pipesarray" to mutableListOf("5", "6", "7")
                )

            assertEquals(expected, result)
        }

        @Test
        fun `does not destringify query parameters without a strategy`() {
            // Given
            val query = "param1=value1&param2=value2,value3"
            val destringifyStrategies = emptyMap<String, String>()

            // When
            val result = UrlUtils.parseQueryParams(query, destringifyStrategies)

            // Then
            val expected =
                mapOf(
                    "param1" to mutableListOf("value1"),
                    "param2" to mutableListOf("value2,value3")
                )
            assertEquals(expected, result)
        }

        @Test
        fun `throws IllegalArgumentException on unknown destringify strategy`() {
            // Given
            val query = "param1=value1&param2=value2,value3"
            val destringifyStrategies = mapOf("param2" to "random")

            // When
            val exception =
                Assertions.assertThrows(IllegalArgumentException::class.java) {
                    UrlUtils.parseQueryParams(query, destringifyStrategies)
                }

            // Then
            val expectedMessage = "Unknown destringify strategy [random] for key: param2"
            assertEquals(expectedMessage, exception.message)
        }
    }

    @Nested
    inner class ResolveUrlQueryParamValuesTypeTest {
        private val objectMapper = jacksonObjectMapper()

        @Test
        fun `resolves single value to specified type`() {
            val values = listOf("123")
            val jacksonTypeRef = jacksonTypeRef<Int>()

            val result = UrlUtils.resolveUrlQueryParamValuesType(values, objectMapper, jacksonTypeRef)
            val expected = 123

            assertEquals(expected, result)
        }

        @Test
        fun `resolves multiple values to list of specified type`() {
            val values = listOf("1", "2", "3")
            val jacksonTypeRef = jacksonTypeRef<List<Int>>()

            val result = UrlUtils.resolveUrlQueryParamValuesType(values, objectMapper, jacksonTypeRef)
            val expected = listOf(1, 2, 3)

            assertEquals(expected, result)
        }

        @Test
        fun `resolves single value to string when type is string`() {
            val values = listOf("testValue")
            val jacksonTypeRef = jacksonTypeRef<String>()

            val result = UrlUtils.resolveUrlQueryParamValuesType(values, objectMapper, jacksonTypeRef)
            val expected = "testValue"

            assertEquals(expected, result)
        }

        @Test
        fun `returns empty list when values list is empty and type ref is a list`() {
            val values = emptyList<String>()
            val jacksonTypeRef = jacksonTypeRef<List<Int>>()

            val result = UrlUtils.resolveUrlQueryParamValuesType(values, objectMapper, jacksonTypeRef)
            val expected = emptyList<Int>()

            assertEquals(expected, result)
        }

        @Test
        fun `throws IllegalArgumentException when unable to convert values to specified type`() {
            val values = listOf("invalidValue")
            val jacksonTypeRef = jacksonTypeRef<Int>()

            assertThrows<IllegalArgumentException> {
                UrlUtils.resolveUrlQueryParamValuesType(values, objectMapper, jacksonTypeRef)
            }
        }

        @Test
        fun `throws IllegalArgumentException when type ref is not container and values list is empty`() {
            // Given
            val values = emptyList<String>()

            val jacksonTypeRef1 = jacksonTypeRef<Int>()
            val jacksonTypeRef2 = jacksonTypeRef<String>()

            // When
            val exception1 =
                assertThrows<IllegalArgumentException> {
                    UrlUtils.resolveUrlQueryParamValuesType(values, objectMapper, jacksonTypeRef1)
                }
            val exception2 =
                assertThrows<IllegalArgumentException> {
                    UrlUtils.resolveUrlQueryParamValuesType(values, objectMapper, jacksonTypeRef2)
                }

            // Then
            val expectedExceptionMessage = "Cannot resolve type for empty values"

            assertEquals(expectedExceptionMessage, exception1.message)
            assertEquals(expectedExceptionMessage, exception2.message)
        }
    }
}
