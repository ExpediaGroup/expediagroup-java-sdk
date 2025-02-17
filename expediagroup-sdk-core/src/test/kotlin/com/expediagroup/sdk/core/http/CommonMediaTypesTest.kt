package com.expediagroup.sdk.core.http

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CommonMediaTypesTest {
    @Test
    fun `TEXT_PLAIN should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.TEXT_PLAIN
        assertEquals("text", mediaType.type)
        assertEquals("plain", mediaType.subtype)
    }

    @Test
    fun `TEXT_HTML should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.TEXT_HTML
        assertEquals("text", mediaType.type)
        assertEquals("html", mediaType.subtype)
    }

    @Test
    fun `TEXT_CSS should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.TEXT_CSS
        assertEquals("text", mediaType.type)
        assertEquals("css", mediaType.subtype)
    }

    @Test
    fun `TEXT_JAVASCRIPT should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.TEXT_JAVASCRIPT
        assertEquals("text", mediaType.type)
        assertEquals("javascript", mediaType.subtype)
    }

    @Test
    fun `TEXT_CSV should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.TEXT_CSV
        assertEquals("text", mediaType.type)
        assertEquals("csv", mediaType.subtype)
    }

    @Test
    fun `APPLICATION_JSON should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.APPLICATION_JSON
        assertEquals("application", mediaType.type)
        assertEquals("json", mediaType.subtype)
    }

    @Test
    fun `APPLICATION_XML should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.APPLICATION_XML
        assertEquals("application", mediaType.type)
        assertEquals("xml", mediaType.subtype)
    }

    @Test
    fun `APPLICATION_FORM_URLENCODED should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.APPLICATION_FORM_URLENCODED
        assertEquals("application", mediaType.type)
        assertEquals("x-www-form-urlencoded", mediaType.subtype)
    }

    @Test
    fun `APPLICATION_OCTET_STREAM should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.APPLICATION_OCTET_STREAM
        assertEquals("application", mediaType.type)
        assertEquals("octet-stream", mediaType.subtype)
    }

    @Test
    fun `APPLICATION_PDF should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.APPLICATION_PDF
        assertEquals("application", mediaType.type)
        assertEquals("pdf", mediaType.subtype)
    }

    @Test
    fun `APPLICATION_VND_API_JSON should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.APPLICATION_VND_API_JSON
        assertEquals("application", mediaType.type)
        assertEquals("vnd.api+json", mediaType.subtype)
    }

    @Test
    fun `APPLICATION_JSON_GRAPHQL should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.APPLICATION_JSON_GRAPHQL
        assertEquals("application", mediaType.type)
        assertEquals("json+graphql", mediaType.subtype)
    }

    @Test
    fun `APPLICATION_HAL_JSON should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.APPLICATION_HAL_JSON
        assertEquals("application", mediaType.type)
        assertEquals("hal+json", mediaType.subtype)
    }

    @Test
    fun `APPLICATION_PROBLEM_JSON should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.APPLICATION_PROBLEM_JSON
        assertEquals("application", mediaType.type)
        assertEquals("problem+json", mediaType.subtype)
    }

    @Test
    fun `APPLICATION_ZIP should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.APPLICATION_ZIP
        assertEquals("application", mediaType.type)
        assertEquals("zip", mediaType.subtype)
    }

    @Test
    fun `IMAGE_JPEG should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.IMAGE_JPEG
        assertEquals("image", mediaType.type)
        assertEquals("jpeg", mediaType.subtype)
    }

    @Test
    fun `IMAGE_PNG should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.IMAGE_PNG
        assertEquals("image", mediaType.type)
        assertEquals("png", mediaType.subtype)
    }

    @Test
    fun `IMAGE_GIF should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.IMAGE_GIF
        assertEquals("image", mediaType.type)
        assertEquals("gif", mediaType.subtype)
    }

    @Test
    fun `IMAGE_SVG_XML should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.IMAGE_SVG_XML
        assertEquals("image", mediaType.type)
        assertEquals("svg+xml", mediaType.subtype)
    }

    @Test
    fun `AUDIO_MPEG should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.AUDIO_MPEG
        assertEquals("audio", mediaType.type)
        assertEquals("mpeg", mediaType.subtype)
    }

    @Test
    fun `AUDIO_WAV should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.AUDIO_WAV
        assertEquals("audio", mediaType.type)
        assertEquals("wav", mediaType.subtype)
    }

    @Test
    fun `VIDEO_MP4 should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.VIDEO_MP4
        assertEquals("video", mediaType.type)
        assertEquals("mp4", mediaType.subtype)
    }

    @Test
    fun `VIDEO_MPEG should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.VIDEO_MPEG
        assertEquals("video", mediaType.type)
        assertEquals("mpeg", mediaType.subtype)
    }

    @Test
    fun `MULTIPART_FORM_DATA should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.MULTIPART_FORM_DATA
        assertEquals("multipart", mediaType.type)
        assertEquals("form-data", mediaType.subtype)
    }

    @Test
    fun `MULTIPART_BYTERANGES should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.MULTIPART_BYTERANGES
        assertEquals("multipart", mediaType.type)
        assertEquals("byteranges", mediaType.subtype)
    }

    @Test
    fun `APPLICATION_JAVASCRIPT should have correct type and subtype`() {
        val mediaType = CommonMediaTypes.APPLICATION_JAVASCRIPT
        assertEquals("application", mediaType.type)
        assertEquals("javascript", mediaType.subtype)
    }
}
