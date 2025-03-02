package com.expediagroup.sdk.rest.util

import com.expediagroup.sdk.rest.model.UrlQueryParam
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UrlQueryParamUtilsTest {
    companion object {
        val stringifyQueryParam = mockk<StringifyQueryParam>()
    }

    @Test
    fun `invoke should correctly convert UrlQueryParam to String using provided logic`() {
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
    fun `stringifyForm should correctly convert UrlQueryParam to form-encoded String`() {
        val param = UrlQueryParam("myKey", listOf("v1", "v2"), stringifyForm)
        val expectedString = "myKey=v1%2Cv2"

        val actualString = stringifyForm(param)

        assertEquals(expectedString, actualString)
    }

    @Test
    fun `stringifyExplode should correctly convert UrlQueryParam to exploded form-encoded String`() {
        val param = UrlQueryParam("myKey", listOf("v1", "v2"), stringifyExplode)
        val expectedString = "myKey=v1&myKey=v2"

        val actualString = stringifyExplode(param)

        assertEquals(expectedString, actualString)
    }

    @Test
    fun `stringifySpaceDelimited should correctly convert UrlQueryParam to space-delimited String`() {
        val param = UrlQueryParam("myKey", listOf("v1", "v2"), stringifySpaceDelimited)
        val expectedString = "myKey=v1+v2"

        val actualString = stringifySpaceDelimited(param)

        assertEquals(expectedString, actualString)
    }

    @Test
    fun `stringifyPipeDelimited should correctly convert UrlQueryParam to pipe-delimited String`() {
        val param = UrlQueryParam("myKey", listOf("v1", "v2"), stringifyPipeDelimited)
        val expectedString = "myKey=v1%7Cv2"

        val actualString = stringifyPipeDelimited(param)

        assertEquals(expectedString, actualString)
    }

    @Test
    fun `swaggerCollectionFormatStringifier should return correct stringify method`() {
        mapOf(
            "csv" to stringifyForm,
            "pipes" to stringifyPipeDelimited,
            "ssv" to stringifySpaceDelimited,
            "multi" to stringifyExplode
        ).forEach { (format, expected) ->
            assertEquals(swaggerCollectionFormatStringifier.get(format), expected)
        }
    }
}
