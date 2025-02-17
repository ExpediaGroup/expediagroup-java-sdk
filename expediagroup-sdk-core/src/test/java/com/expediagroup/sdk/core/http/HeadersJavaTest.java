package com.expediagroup.sdk.core.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HeadersJavaTest {

    @Test
    @DisplayName("should access default builder static method")
    public void defaultStaticBuilderIsAccessibleFromJava() {
        // Given
        Headers headers = Headers
                .builder()
                .add("content-type", "application/json")
                .build();

        // When
        String headerValue = headers.get("content-type");

        // Expect
        assertEquals("application/json", headerValue);
    }

    @Test
    @DisplayName("should access parameterized builder static method")
    public void parameterizedStaticBuilderIsAccessibleFromJava() {
        // Given
        Headers originalHeaders = Headers
                .builder()
                .add("content-type", "application/json")
                .build();

        Headers derivedHeaders = Headers
                .builder(originalHeaders)
                .add("accept", "text/plain")
                .build();

        // When
        String contentTypeHeaderValue = originalHeaders.get("content-type");
        String acceptHeaderValue = derivedHeaders.get("accept");

        // Expect
        assertEquals("application/json", contentTypeHeaderValue);
        assertEquals("text/plain", acceptHeaderValue);
        assertEquals("application/json", derivedHeaders.get("content-type"));
        assertNull(originalHeaders.get("accept"));
    }
}
