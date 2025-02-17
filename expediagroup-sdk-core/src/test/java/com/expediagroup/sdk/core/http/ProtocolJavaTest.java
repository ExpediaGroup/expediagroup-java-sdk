package com.expediagroup.sdk.core.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProtocolJavaTest {
    @Test
    @DisplayName("should access Protocol.get() as static method in Java")
    public void shouldAccessGetAsStaticMethod() {
        assertEquals(Protocol.HTTP_1_0, Protocol.get("HTTP/1.0"));
    }
}
