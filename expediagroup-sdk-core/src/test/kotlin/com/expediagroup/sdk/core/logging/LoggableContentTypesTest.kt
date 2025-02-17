package com.expediagroup.sdk.core.logging

import com.expediagroup.sdk.core.http.MediaType
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LoggableContentTypesTest {
    @Test
    fun `LOGGABLE_CONTENT_TYPES should contain specific MIME types`() {
        val expectedContentTypes =
            listOf(
                MediaType.of("text", "plain"),
                MediaType.of("text", "html"),
                MediaType.of("text", "css"),
                MediaType.of("text", "javascript"),
                MediaType.of("text", "csv"),
                MediaType.of("text", "*"),
                MediaType.of("application", "json"),
                MediaType.of("application", "xml"),
                MediaType.of("application", "x-www-form-urlencoded"),
                MediaType.of("application", "json+graphql"),
                MediaType.of("application", "hal+json")
            )

        assertTrue(LOGGABLE_CONTENT_TYPES.containsAll(expectedContentTypes))
    }

    @Test
    fun `isLoggable should return true for loggable MIME types`() {
        val loggableTypes =
            listOf(
                MediaType.of("text", "plain"),
                MediaType.of("application", "json"),
                MediaType.of("text", "html"),
                MediaType.of("application", "x-www-form-urlencoded"),
                MediaType.of("application", "hal+json")
            )

        // Act & Assert
        loggableTypes.forEach { mediaType -> assertTrue(isLoggable(mediaType)) }
    }

    @Test
    fun `isLoggable should return false for non-loggable MIME types`() {
        val nonLoggableTypes =
            listOf(
                MediaType.of("image", "png"),
                MediaType.of("application", "octet-stream"),
                MediaType.of("application", "zip"),
                MediaType.of("video", "mp4"),
                MediaType.of("audio", "mpeg")
            )

        nonLoggableTypes.forEach { mediaType -> assertFalse(isLoggable(mediaType)) }
    }

    @Test
    fun `isLoggable should return true for wildcard loggable MIME types`() {
        val wildcardTypes =
            listOf(
                MediaType.of("text", "markdown"),
                MediaType.of("text", "richtext")
            )

        wildcardTypes.forEach { mediaType -> assertTrue(isLoggable(mediaType)) }
    }
}
