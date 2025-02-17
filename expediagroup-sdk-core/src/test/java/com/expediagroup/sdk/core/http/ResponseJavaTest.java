package com.expediagroup.sdk.core.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseJavaTest {
    @Test
    @DisplayName("should access default builder static method")
    public void defaultStaticBuilderIsAccessibleFromJava() throws IOException {
        try (Response response = Response.builder()
                .request(new Request.Builder().method(Method.GET).url("https://example.com").build())
                .protocol(Protocol.HTTP_1_1)
                .message("OK")
                .status(Status.OK)
                .build()
        ) {
            assertEquals("OK", response.getMessage());
        }
    }
}
