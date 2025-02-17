package com.expediagroup.sdk.okhttp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OkHttpClientConfigurationJavaTest {
    @Test
    @DisplayName("should access default builder static method")
    public void defaultStaticBuilderIsAccessibleFromJava() {
        OkHttpClientConfiguration.builder().connectTimeout(1000).build();
    }
}
