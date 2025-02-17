package com.expediagroup.sdk.core.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusJavaTest {
    @Test
    @DisplayName("should access Status.fromCode() as static method in Java")
    public void shouldAccessGetAsStaticMethod() {
        assertEquals(Status.OK,  Status.fromCode(200));
    }
}
