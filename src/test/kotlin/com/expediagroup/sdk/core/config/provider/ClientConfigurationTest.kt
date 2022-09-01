package com.expediagroup.sdk.core.config.provider

import com.expediagroup.sdk.core.configuration.provider.ClientConfiguration
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ClientConfigurationTest {

    @Test
    fun `verify that the EMPTY instance has no properties`() {
        ClientConfiguration.EMPTY.let {
            assertNull(it.key)
            assertNull(it.secret)
            assertNull(it.endpoint)
            assertNull(it.authEndpoint)
        }
    }

    @Nested
    inner class ClientConfigurationBuilderTest {

        @Test
        fun `verify that the builder can be used to create a ClientConfiguration instance`() {
            ClientConfiguration.Builder()
                .key("key")
                .secret("secret")
                .endpoint("endpoint")
                .authEndpoint("authEndpoint")
                .build()
                .let {
                    assertEquals("key", it.key)
                    assertEquals("secret", it.secret)
                    assertEquals("endpoint", it.endpoint)
                    assertEquals("authEndpoint", it.authEndpoint)
                }
        }
    }
}
