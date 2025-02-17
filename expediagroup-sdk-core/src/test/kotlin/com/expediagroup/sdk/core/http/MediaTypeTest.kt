package com.expediagroup.sdk.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.nio.charset.Charset

class MediaTypeTest {
    @Test
    fun `should create MediaType without parameters`() {
        // Given
        val mediaType = MediaType.of("application", "json")

        // When
        val type = mediaType.type
        val subtype = mediaType.subtype

        // Expect
        assertEquals("application", type)
        assertEquals("json", subtype)
        assertTrue(mediaType.parameters.isEmpty())
    }

    @Test
    fun `should create MediaType with provided parameters`() {
        // Given
        val mediaType = MediaType.of("text", "html", mapOf("charset" to "UTF-8"))

        // When
        val type = mediaType.type
        val subtype = mediaType.subtype
        val parameters = mediaType.parameters

        // Expect
        assertEquals("text", type)
        assertEquals("html", subtype)
        assertEquals(mapOf("charset" to "UTF-8"), parameters)
    }

    @Test
    fun `should normalize type, subtype, and parameters to lowercase`() {
        // Given
        val mediaType = MediaType.of("APPLICATION", "JSON", mapOf("CHARSET" to "UTF-8"))

        // When
        val type = mediaType.type
        val subtype = mediaType.subtype
        val parameters = mediaType.parameters

        // Expect
        assertEquals("application", type)
        assertEquals("json", subtype)
        assertEquals(mapOf("charset" to "UTF-8"), parameters)
    }

    @Test
    fun `should throw an exception for blank type`() {
        // Given
        val blankType = ""

        // When
        val exception =
            assertThrows<IllegalArgumentException> {
                MediaType.of(blankType, "json")
            }

        // Expect
        assertEquals("Type must not be blank", exception.message)
    }

    @Test
    fun `should throw an exception for black subtype`() {
        // Given
        val blankSubType = ""

        // When
        val exception =
            assertThrows<IllegalArgumentException> {
                MediaType.of("application", blankSubType)
            }

        // Expect
        assertEquals("Subtype must not be blank", exception.message)
    }

    @Test
    fun `should return full type`() {
        // Given
        val mediaType = MediaType.of("application", "json")

        // When
        val fullType = mediaType.fullType

        // Expect
        assertEquals("application/json", fullType)
    }

    @Test
    fun `should return charset when present`() {
        // Given
        val mediaType = MediaType.of("text", "html", mapOf("charset" to "UTF-8"))

        // When
        val charset = mediaType.charset

        // Expect
        assertEquals(Charset.forName("UTF-8"), charset)
    }

    @Test
    fun `should return null charset when not present`() {
        // Given
        val mediaType = MediaType.of("text", "html")

        // When
        val charset = mediaType.charset

        // Expect
        assertNull(charset)
    }

    @Test
    fun `should return null charset for invalid charset`() {
        // Given
        val mediaType = MediaType.of("text", "html", mapOf("charset" to "INVALID"))

        // When
        val charset = mediaType.charset

        // Expect
        assertNull(charset)
    }

    @Test
    fun `should include media type with wildcard subtype`() {
        // Given
        val wildcardSubtype = MediaType.of("application", "*")
        val other = MediaType.of("application", "json")

        // When
        val includes = wildcardSubtype.includes(other)

        // Expect
        assertTrue(includes)
    }

    @Test
    fun `should include media type with both wildcards`() {
        // Given
        val wildcardBoth = MediaType.of("*", "*")
        val other = MediaType.of("application", "json")

        // When
        val includes = wildcardBoth.includes(other)

        // Expect
        assertTrue(includes)
    }

    @Test
    fun `should include media type with exact match`() {
        // Given
        val exact = MediaType.of("application", "json")
        val other = MediaType.of("application", "json")

        // When
        val includes = exact.includes(other)

        // Expect
        assertTrue(includes)
    }

    @Test
    fun `should not include media type with mismatched type`() {
        // Given
        val mediaType = MediaType.of("application", "json")
        val other = MediaType.of("text", "json")

        // When
        val includes = mediaType.includes(other)

        // Expect
        assertFalse(includes)
    }

    @Test
    fun `should not include media type with mismatched subtype`() {
        // Given
        val mediaType = MediaType.of("application", "json")
        val other = MediaType.of("application", "xml")

        // When
        val includes = mediaType.includes(other)

        // Expect
        assertFalse(includes)
    }

    @Test
    fun `should include media type with case-insensitive match`() {
        // Given
        val mediaType = MediaType.of("APPLICATION", "JSON")
        val other = MediaType.of("application", "json")

        // When
        val includes = mediaType.includes(other)

        // Expect
        assertTrue(includes)
    }

    @Test
    fun `should not include media type with neither wildcard nor match`() {
        // Given
        val mediaType = MediaType.of("text", "xml")
        val other = MediaType.of("application", "json")

        // When
        val includes = mediaType.includes(other)

        // Expect
        assertFalse(includes)
    }

    @Test
    fun `should return formatted media type string without parameters`() {
        // Given
        val mediaType = MediaType.of("application", "json")

        // When
        val stringRepresentation = mediaType.toString()

        // Expect
        assertEquals("application/json", stringRepresentation)
    }

    @Test
    fun `should return formatted media type string with parameters`() {
        // Given
        val mediaType = MediaType.of("application", "json", mapOf("charset" to "UTF-8", "version" to "1.0"))

        // When
        val stringRepresentation = mediaType.toString()

        // Expect
        assertEquals("application/json;charset=UTF-8;version=1.0", stringRepresentation)
    }

    @Test
    fun `should throw exception if type is wildcard with defined subtype`() {
        // Given
        val type = "*"
        val subtype = "html"

        // When
        val exception =
            assertThrows<IllegalArgumentException> {
                MediaType.of(type, subtype)
            }

        // Expect
        assertEquals("Invalid media type format: type=*, subtype=html", exception.message)
    }

    @Nested
    inner class MediaTypeParser {
        @Test
        fun `should parse valid media type with no parameters`() {
            // Given
            val mediaType = "text/html"

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("text", result.type)
            assertEquals("html", result.subtype)
            assertTrue(result.parameters.isEmpty())
        }

        @Test
        fun `should parse valid media type with one parameter`() {
            // Given
            val mediaType = "application/json; charset=UTF-8"

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("application", result.type)
            assertEquals("json", result.subtype)
            assertEquals(mapOf("charset" to "utf-8"), result.parameters)
        }

        @Test
        fun `should parse media type with structured subtype`() {
            // Given
            val mediaType = "application/json+graphql; charset=UTF-8"

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("application", result.type)
            assertEquals("json+graphql", result.subtype)
            assertEquals(mapOf("charset" to "utf-8"), result.parameters)
        }

        @Test
        fun `should parse media type with wildcard subtype`() {
            // Given
            val mediaType = "application/*"

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("application", result.type)
            assertEquals("*", result.subtype)
            assertTrue(result.parameters.isEmpty())
        }

        @Test
        fun `should parse media type with wildcard type and subtype`() {
            // Given
            val mediaType = "*/*"

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("*", result.type)
            assertEquals("*", result.subtype)
            assertTrue(result.parameters.isEmpty())
        }

        @Test
        fun `should parse valid media type with multiple parameters`() {
            // Given
            val mediaType = "multipart/form-data; boundary=abc123; charset=UTF-8"

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("multipart", result.type)
            assertEquals("form-data", result.subtype)
            assertEquals(
                mapOf(
                    "boundary" to "abc123",
                    "charset" to "utf-8"
                ),
                result.parameters
            )
        }

        @Test
        fun `should ignore extra spaces in media type and parameters`() {
            // Given
            val mediaType = "  text/html  ;  charset = UTF-8  ; boundary =   my-boundary   "

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("text", result.type)
            assertEquals("html", result.subtype)
            assertEquals(
                mapOf(
                    "charset" to "utf-8",
                    "boundary" to "my-boundary"
                ),
                result.parameters
            )
        }

        @Test
        fun `should parse media type with encoded parameters`() {
            // Given
            val mediaType = "application/x-www-form-urlencoded; charset=UTF-8"

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("application", result.type)
            assertEquals("x-www-form-urlencoded", result.subtype)
            assertEquals(mapOf("charset" to "utf-8"), result.parameters)
        }

        @Test
        fun `should parse media type with vendor-specific subtype`() {
            // Given
            val mediaType = "application/vnd.mspowerpoint"

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("application", result.type)
            assertEquals("vnd.mspowerpoint", result.subtype)
            assertTrue(result.parameters.isEmpty())
        }

        @Test
        fun `should handle valid media type with empty parameters`() {
            // Given
            val mediaType = "text/html;"

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("text", result.type)
            assertEquals("html", result.subtype)
            assertTrue(result.parameters.isEmpty())
        }

        @Test
        fun `should parse valid media type with multiple semicolons`() {
            // Given
            val mediaType = "application/json;;; charset=UTF-8;; boundary=abc123"

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("application", result.type)
            assertEquals("json", result.subtype)
            assertEquals(
                mapOf(
                    "charset" to "utf-8",
                    "boundary" to "abc123"
                ),
                result.parameters
            )
        }

        @Test
        fun `should handle lowercase conversion for type, subtype, and parameters`() {
            // Given
            val mediaType = "APPLICATION/JSON; CHARSET=UTF-8; BOUNDARY=ABC"

            // When
            val result = MediaType.parse(mediaType)

            // Expect
            assertEquals("application", result.type)
            assertEquals("json", result.subtype)
            assertEquals(
                mapOf(
                    "charset" to "utf-8",
                    "boundary" to "abc"
                ),
                result.parameters
            )
        }

        @Test
        fun `should throw exception for missing subtype`() {
            // Given
            val mediaType = "application/"

            // When
            val exception =
                assertThrows<IllegalArgumentException> {
                    MediaType.parse(mediaType)
                }

            // Expect
            assertEquals("Invalid media type format: application/", exception.message)
        }

        @Test
        fun `should throw exception for missing type`() {
            // Given
            val mediaType = "/json"

            // When
            val exception =
                assertThrows<IllegalArgumentException> {
                    MediaType.parse(mediaType)
                }

            // Expect
            assertEquals("Invalid media type format: /json", exception.message)
        }

        @Test
        fun `should throw exception for blank media type`() {
            // Given
            val mediaType = "   "

            // When
            val exception =
                assertThrows<IllegalArgumentException> {
                    MediaType.parse(mediaType)
                }

            // Expect
            assertEquals("Media type must not be blank", exception.message)
        }

        @Test
        fun `should throw exception for invalid format without slash`() {
            // Given
            val mediaType = "invalidMediaType"

            // When
            val exception =
                assertThrows<IllegalArgumentException> {
                    MediaType.parse(mediaType)
                }

            // Expect
            assertEquals("Invalid media type format: invalidMediaType", exception.message)
        }

        @Test
        fun `should throw exception for malformed parameters`() {
            // Given
            val mediaType = "text/html; charset; boundary=abc123"

            // When
            val exception =
                assertThrows<IllegalArgumentException> {
                    MediaType.parse(mediaType)
                }

            // Expect
            assertEquals("Invalid parameter format: charset", exception.message)
        }

        @Test
        fun `should throw exception for malformed parameter with missing value`() {
            // Given
            val mediaType = "text/html; charset="

            // When
            val exception =
                assertThrows<IllegalArgumentException> {
                    MediaType.parse(mediaType)
                }

            // Expect
            assertEquals("Invalid parameter format: charset=", exception.message)
        }

        @Test
        fun `should throw exception if type is wildcard with defined subtype`() {
            // Given
            val mediaType = "*/html"

            // When
            val exception =
                assertThrows<IllegalArgumentException> {
                    MediaType.parse(mediaType)
                }

            // Expect
            assertEquals("Invalid media type format: */html", exception.message)
        }
    }
}
