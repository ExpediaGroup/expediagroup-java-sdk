package com.expediagroup.sdk.rest.util

import com.expediagroup.sdk.rest.model.UrlQueryParam
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
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

    @Test
    fun `create instances of UrlQueryParamDestringifiers and UrlQueryParamStringifiers`() {
        val destringifier = UrlQueryParamDestringifiers()
        val stringifier = UrlQueryParamStringifiers()

        assertInstanceOf(UrlQueryParamDestringifiers::class.java, destringifier)
        assertInstanceOf(UrlQueryParamStringifiers::class.java, stringifier)
    }

    @Nested
    inner class StringifiersTest {
        @Test
        fun `stringifyForm should correctly convert UrlQueryParam to form-encoded String`() {
            val param = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifiers.stringifyForm)
            val expectedString = "myKey=v1%2Cv2"

            val actualString = UrlQueryParamStringifiers.stringifyForm(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `stringifyExplode should correctly convert UrlQueryParam to exploded form-encoded String`() {
            val param = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifiers.stringifyExplode)
            val expectedString = "myKey=v1&myKey=v2"

            val actualString = UrlQueryParamStringifiers.stringifyExplode(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `stringifySpaceDelimited should correctly convert UrlQueryParam to space-delimited String`() {
            val param = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifiers.stringifySpaceDelimited)
            val expectedString = "myKey=v1+v2"

            val actualString = UrlQueryParamStringifiers.stringifySpaceDelimited(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `stringifyPipeDelimited should correctly convert UrlQueryParam to pipe-delimited String`() {
            val param = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifiers.stringifyPipeDelimited)
            val expectedString = "myKey=v1%7Cv2"

            val actualString = UrlQueryParamStringifiers.stringifyPipeDelimited(param)

            assertEquals(expectedString, actualString)
        }

        @Test
        fun `swaggerCollectionFormatStringifier should return correct stringify method`() {
            mapOf(
                "csv" to UrlQueryParamStringifiers.stringifyForm,
                "pipes" to UrlQueryParamStringifiers.stringifyPipeDelimited,
                "ssv" to UrlQueryParamStringifiers.stringifySpaceDelimited,
                "multi" to UrlQueryParamStringifiers.stringifyExplode
            ).forEach { (format, expected) ->
                assertEquals(swaggerCollectionFormatStringifier.get(format), expected)
            }
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
            val actualParam = UrlQueryParamDestringifiers.destringifyForm(queryParamName, queryParamValue)
            val expectedParam = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifiers.stringifyForm)

            // Then
            assertEquals(expectedParam, actualParam)
        }

        @Test
        fun `destringifyExplode should correctly convert exploded form-encoded String to UrlQueryParam`() {
            // Given
            val queryParamName = "myKey"
            val queryParamValue = "v1&v2"

            // When
            val actualParam = UrlQueryParamDestringifiers.destringifyExplode(queryParamName, queryParamValue)
            val expectedParam = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifiers.stringifyExplode)

            // Then
            assertEquals(expectedParam, actualParam)
        }

        @Test
        fun `destringifySpaceDelimited should correctly convert space-delimited String to UrlQueryParam`() {
            // Given
            val queryParamName = "myKey"
            val queryParamValue = "v1 v2"

            // When
            val actualParam = UrlQueryParamDestringifiers.destringifySpaceDelimited(queryParamName, queryParamValue)
            val expectedParam = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifiers.stringifySpaceDelimited)

            // Then
            assertEquals(expectedParam, actualParam)
        }

        @Test
        fun `destringifyPipeDelimited should correctly convert pipe-delimited String to UrlQueryParam`() {
            // Given
            val queryParamName = "myKey"
            val queryParamValue = "v1|v2"

            // When
            val actualParam = UrlQueryParamDestringifiers.destringifyPipeDelimited(queryParamName, queryParamValue)
            val expectedParam = UrlQueryParam("myKey", listOf("v1", "v2"), UrlQueryParamStringifiers.stringifyPipeDelimited)

            // Then
            assertEquals(expectedParam, actualParam)
        }

        @Test
        fun `all destringifiers should correctly convert single value String to UrlQueryParam`() {
            // Given
            val queryParamName = "myKey"
            val queryParamValue = "v1"

            // When
            val pipeDelimitedActualParam = UrlQueryParamDestringifiers.destringifyPipeDelimited(queryParamName, queryParamValue)
            val spaceDelimitedActualParam = UrlQueryParamDestringifiers.destringifySpaceDelimited(queryParamName, queryParamValue)
            val explodeActualParam = UrlQueryParamDestringifiers.destringifyExplode(queryParamName, queryParamValue)
            val formActualParam = UrlQueryParamDestringifiers.destringifyForm(queryParamName, queryParamValue)

            val expectedValue = listOf("v1")

            // Then
            assertEquals(expectedValue, pipeDelimitedActualParam.value)
            assertEquals(expectedValue, spaceDelimitedActualParam.value)
            assertEquals(expectedValue, explodeActualParam.value)
            assertEquals(expectedValue, formActualParam.value)
        }
    }
}
