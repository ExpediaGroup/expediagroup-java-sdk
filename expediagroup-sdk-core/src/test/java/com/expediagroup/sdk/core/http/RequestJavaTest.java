package com.expediagroup.sdk.core.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class RequestJavaTest {
    @Test
    @DisplayName("should access default builder static method")
    public void defaultStaticBuilderIsAccessibleFromJava() throws MalformedURLException {
        Request.builder().method(Method.GET).url("https://www.example.com").build();
    }
}
