package com.expediagroup.sdk.core.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MediaTypeJavaTest {
    @Test
    @DisplayName("should be able to access of() static method with type and subtype as params")
    public void ofStaticMethodShouldBeCallableWithTypeAndSubtypeOnly() {
        MediaType.of("application", "json");
    }

    @Test
    @DisplayName("should be able to access of() static method with type, subtype, parameters map as params")
    public void ofStaticMethodShouldBeCallableWithParametersMap() {
        MediaType.of("application", "json", new HashMap<>());
    }

    @Test
    @DisplayName("should be able to access of() static method with type, subtype, parameters map as params")
    public void parseStaticMethodShouldBeAccessible() {
        MediaType.parse("application/json; charset=utf-8");
    }
}
