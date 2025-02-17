package com.expediagroup.sdk.core.http;

import okio.Buffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ResponseBodyJavaTest {
    @Test
    @DisplayName("should access ResponseBody.create as static method with InputStream only")
    public void shouldCreateResponseBodyFromInputStreamOnly() {
        String content = "Hello World";
        InputStream inputStream = new ByteArrayInputStream(content.getBytes());
        ResponseBody.create(inputStream);
    }

    @Test
    @DisplayName("should access ResponseBody.create as static method with InputStream, media type, content length")
    public void shouldCreateResponseBodyFromInputStreamAndMediaTypeAndContentLength() {
        String content = "Hello World";
        InputStream inputStream = new ByteArrayInputStream(content.getBytes());
        ResponseBody.create(inputStream, CommonMediaTypes.TEXT_PLAIN, content.getBytes().length);
    }

    @Test
    @DisplayName("should access ResponseBody.create as static method with Source only")
    public void shouldCreateResponseBodyFromSourceOnly() {
        String content = "Hello World";

        try (Buffer source = new Buffer().writeUtf8(content)) {
            ResponseBody.create(source);
        }
    }

    @Test
    @DisplayName("should access ResponseBody.create as static method with Source, media type, content length")
    public void shouldCreateResponseBodyFromSourceAndMediaTypeAndContentLength() {
        String content = "Hello World";
        try (Buffer source = new Buffer().writeUtf8(content)) {
            ResponseBody.create(source, CommonMediaTypes.TEXT_PLAIN, content.getBytes().length);
        }
    }
}
