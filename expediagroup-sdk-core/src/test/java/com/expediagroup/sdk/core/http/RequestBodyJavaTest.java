package com.expediagroup.sdk.core.http;

import okio.Buffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

public class RequestBodyJavaTest {

    @Test
    @DisplayName("should access RequestBody.create as static method with InputStream only")
    public void shouldCreateRequestBodyFromInputStreamOnly() {
        String content = "Hello World";
        InputStream inputStream = new ByteArrayInputStream(content.getBytes());
        RequestBody.create(inputStream);
    }

    @Test
    @DisplayName("should access RequestBody.create as static method with InputStream, media type, content length")
    public void shouldCreateRequestBodyFromInputStreamAndMediaTypeAndContentLength() {
        String content = "Hello World";
        InputStream inputStream = new ByteArrayInputStream(content.getBytes());
        RequestBody.create(inputStream, CommonMediaTypes.TEXT_PLAIN, content.getBytes().length);
    }

    @Test
    @DisplayName("should access RequestBody.create as static method with Source only")
    public void shouldCreateRequestBodyFromSourceOnly() {
        String content = "Hello World";

        try (Buffer source = new Buffer().writeUtf8(content)) {
            RequestBody.create(source);
        }
    }

    @Test
    @DisplayName("should access RequestBody.create as static method with Source, media type, content length")
    public void shouldCreateRequestBodyFromSourceAndMediaTypeAndContentLength() {
        String content = "Hello World";
        try (Buffer source = new Buffer().writeUtf8(content)) {
            RequestBody.create(source, CommonMediaTypes.TEXT_PLAIN, content.getBytes().length);
        }
    }

    @Test
    @DisplayName("should access RequestBody.create as static method with ByteString only")
    public void shouldCreateRequestBodyFromByteStringOnly() {
        String content = "Hello World";

        try (Buffer source = new Buffer().writeUtf8(content)) {
            RequestBody.create(source.snapshot());
        }
    }

    @Test
    @DisplayName("should access RequestBody.create as static method with ByteString, media type, content length")
    public void shouldCreateRequestBodyFromByteStringAndMediaTypeAndContentLength() {
        String content = "Hello World";
        try (Buffer source = new Buffer().writeUtf8(content)) {
            RequestBody.create(source.snapshot(), CommonMediaTypes.TEXT_PLAIN, content.getBytes().length);
        }
    }

    @Test
    @DisplayName("should access RequestBody.create as static method with map data as form")
    public void shouldCreateRequestBodyFromMapDataAsFormData() {
        HashMap<String, String> map = new HashMap<String, String>() {{
            put("A", "1");
            put("B", "2");
            put("C", "3");
        }};

        RequestBody.create(map);
    }

    @Test
    @DisplayName("should access RequestBody.create as static method with map data as form with charset")
    public void shouldCreateRequestBodyFromMapDataAndCharsetAsFormData() {
        HashMap<String, String> map = new HashMap<String, String>() {{
            put("A", "1");
            put("B", "2");
            put("C", "3");
        }};

        RequestBody.create(map, Charset.defaultCharset());
    }
}
