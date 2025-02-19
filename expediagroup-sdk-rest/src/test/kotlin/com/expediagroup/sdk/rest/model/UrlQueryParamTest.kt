package com.expediagroup.sdk.rest.model

import com.expediagroup.sdk.rest.util.StringifyQueryParam
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UrlQueryParamTest {
    @Test
    fun `does not mutate values on initialization`() {
        val stringifyMock = mockk<StringifyQueryParam>()
        val params =
            mapOf(
                "key1" to listOf("value1", "value2"),
                "key2" to listOf("value3", "value4")
            )

        params.forEach { (key, value) ->
            val queryParam = UrlQueryParam(key, value, stringifyMock)

            assertEquals(key, queryParam.key)
            assertEquals(value, queryParam.value)
            assertEquals(stringifyMock, queryParam.stringify)
        }
    }

    @Test
    fun `converts to string using stringifier`() {
        val mockStringify = mockk<StringifyQueryParam>()
        val param = UrlQueryParam("key", listOf("value1", "value2"), mockStringify)
        every { mockStringify.invoke(param) } returns "key=value1,value2"

        val result = param.toString()

        assertEquals("key=value1,value2", result)
    }

    @Test
    fun `throws IllegalArgumentException exception null key`() {
        val mockStringify = mockk<StringifyQueryParam>()
        val exception =
            assertThrows<IllegalArgumentException> {
                UrlQueryParam("", listOf("value1", "value2"), mockStringify)
            }

        assertEquals("Query parameter key cannot be blank!", exception.message)
    }
}
