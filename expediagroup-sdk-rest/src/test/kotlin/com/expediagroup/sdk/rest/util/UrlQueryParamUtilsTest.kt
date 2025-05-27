package com.expediagroup.sdk.rest.util

import com.expediagroup.sdk.rest.model.UrlQueryParam
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class UrlQueryParamUtilsTest {
    companion object {
        val stringifyQueryParam = mockk<StringifyQueryParam>()
    }

    @Test
    fun `invoke in StringifyQueryParam instances should correctly convert UrlQueryParam to String using provided logic`() {
        val customStringify =
            StringifyQueryParam { param ->
                "${param.key}:${param.value.joinToString("-")}"
            }

        val param = UrlQueryParam("myKey", listOf("v1", "v2"), stringifyQueryParam)
        val expectedString = "myKey:v1-v2"

        val actualString = customStringify(param)

        assertEquals(expectedString, actualString)
    }

    @Test
    fun `invoke in DestringifyQueryParam instances should correctly convert String to UrlQueryParam using provided logic`() {
        val customDestringify =
            DestringifyQueryParam { name, query ->
                val values = query.split("-")
                UrlQueryParam(name, values, stringifyQueryParam)
            }

        val expectedParam = UrlQueryParam("myKey", listOf("v1", "v2"), stringifyQueryParam)
        val actualParam = customDestringify("myKey", "v1-v2")

        assertEquals(expectedParam, actualParam)
    }

    @Nested
    inner class StringifiersTest {
        @Test
        fun `stringifyForm should convert UrlQueryParam to form-encoded String`() {
            val param = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifier.form)
            val expectedString = "myKey=v1,v2"

            val actualString = UrlQueryParamStringifier.form(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `stringifyForm should convert and encode UrlQueryParam to form-encoded String`() {
            val param = UrlQueryParam("myKey", listOf("v1 v2", "v3,v4"), UrlQueryParamStringifier.form)
            val expectedString = "myKey=v1%20v2,v3%2Cv4"

            val actualString = UrlQueryParamStringifier.form(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `stringifyExplode should convert UrlQueryParam to exploded-form String`() {
            val param = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifier.explode)
            val expectedString = "myKey=v1&myKey=v2"

            val actualString = UrlQueryParamStringifier.explode(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `stringifyExplode should convert and encode UrlQueryParam to exploded-form String`() {
            val param = UrlQueryParam("myKey", listOf("v1 v2", "v3,v4"), UrlQueryParamStringifier.explode)
            val expectedString = "myKey=v1%20v2&myKey=v3%2Cv4"
            val actualString = UrlQueryParamStringifier.explode(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `stringifySpaceDelimited should convert UrlQueryParam to space-delimited String`() {
            val param = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifier.spaceDelimited)
            val expectedString = "myKey=v1%20v2"

            val actualString = UrlQueryParamStringifier.spaceDelimited(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `stringifyPipeDelimited should convert UrlQueryParam to pipe-delimited String`() {
            val param = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifier.pipeDelimited)
            val expectedString = "myKey=v1|v2"

            val actualString = UrlQueryParamStringifier.pipeDelimited(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `stringifyPipeDelimited should convert and encode UrlQueryParam to pipe-delimited String`() {
            val param = UrlQueryParam("myKey", listOf("v1 v2", "v3,v4"), UrlQueryParamStringifier.pipeDelimited)
            val expectedString = "myKey=v1%20v2|v3%2Cv4"

            val actualString = UrlQueryParamStringifier.pipeDelimited(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `swaggerCollectionFormatStringifier should return correct stringify method`() {
            mapOf(
                "csv" to UrlQueryParamStringifier.form,
                "pipes" to UrlQueryParamStringifier.pipeDelimited,
                "ssv" to UrlQueryParamStringifier.spaceDelimited,
                "multi" to UrlQueryParamStringifier.explode
            ).forEach { (format, expected) ->
                assertEquals(swaggerCollectionFormatStringifier.get(format), expected)
            }
        }

        @Test
        fun `stringifiers return empty string if the params list is empty`() {
            val param = UrlQueryParam("myKey", emptyList(), UrlQueryParamStringifier.form)
            assertEquals("", UrlQueryParamStringifier.form(param))
            assertEquals("", UrlQueryParamStringifier.explode(param))
            assertEquals("", UrlQueryParamStringifier.pipeDelimited(param))
            assertEquals("", UrlQueryParamStringifier.spaceDelimited(param))
        }
    }

    @Nested
    inner class DestringifiersTest {
        @Test
        fun `destringifyForm should correctly convert form-encoded String to UrlQueryParam`() {
            // Given
            val queryParamName = "myKey"
            val queryParamValue = "v1,v2"

            // When
            val actualParam = UrlQueryParamDestringifiers.form(queryParamName, queryParamValue)
            val expectedParam = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifier.form)

            // Then
            assertEquals(expectedParam, actualParam)
        }

        @Test
        fun `destringifyExplode should correctly convert exploded form-encoded String to UrlQueryParam`() {
            // Given
            val queryParamName = "myKey"
            val queryParamValue = "v1&v2"

            // When
            val actualParam = UrlQueryParamDestringifiers.explode(queryParamName, queryParamValue)
            val expectedParam = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifier.explode)

            // Then
            assertEquals(expectedParam, actualParam)
        }

        @Test
        fun `destringifySpaceDelimited should correctly convert space-delimited String to UrlQueryParam`() {
            // Given
            val queryParamName = "myKey"
            val queryParamValue = "v1 v2"

            // When
            val actualParam = UrlQueryParamDestringifiers.spaceDelimited(queryParamName, queryParamValue)
            val expectedParam = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifier.spaceDelimited)

            // Then
            assertEquals(expectedParam, actualParam)
        }

        @Test
        fun `destringifyPipeDelimited should correctly convert pipe-delimited String to UrlQueryParam`() {
            // Given
            val queryParamName = "myKey"
            val queryParamValue = "v1|v2"

            // When
            val actualParam = UrlQueryParamDestringifiers.pipeDelimited(queryParamName, queryParamValue)
            val expectedParam = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifier.pipeDelimited)

            // Then
            assertEquals(expectedParam, actualParam)
        }

        @Test
        fun `all destringifiers should correctly convert single value String to UrlQueryParam`() {
            // Given
            val queryParamName = "myKey"
            val queryParamValue = "v1"

            // When
            val pipeDelimitedActualParam = UrlQueryParamDestringifiers.pipeDelimited(queryParamName, queryParamValue)
            val spaceDelimitedActualParam = UrlQueryParamDestringifiers.spaceDelimited(queryParamName, queryParamValue)
            val explodeActualParam = UrlQueryParamDestringifiers.explode(queryParamName, queryParamValue)
            val formActualParam = UrlQueryParamDestringifiers.form(queryParamName, queryParamValue)

            val expectedValue = listOf("v1")

            // Then
            assertEquals(expectedValue, pipeDelimitedActualParam.value)
            assertEquals(expectedValue, spaceDelimitedActualParam.value)
            assertEquals(expectedValue, explodeActualParam.value)
            assertEquals(expectedValue, formActualParam.value)
        }
    }
}
