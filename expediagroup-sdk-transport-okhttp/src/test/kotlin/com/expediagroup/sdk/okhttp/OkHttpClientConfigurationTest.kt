package com.expediagroup.sdk.okhttp

import okhttp3.ConnectionPool
import okhttp3.Interceptor
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

class OkHttpClientConfigurationTest {
    @Nested
    inner class OkHttpClientBuilderTest {
        @Test
        fun `builder should build configuration with all properties set`() {
            // Given
            val mockInterceptor1 = Interceptor { chain -> chain.proceed(chain.request()) }
            val mockInterceptor2 = Interceptor { chain -> chain.proceed(chain.request()) }
            val connectionPool = ConnectionPool(5, 5, TimeUnit.MINUTES)

            // When
            val config =
                OkHttpClientConfiguration
                    .builder()
                    .interceptors(listOf(mockInterceptor1))
                    .networkInterceptors(listOf(mockInterceptor2))
                    .connectionPool(connectionPool)
                    .retryOnConnectionFailure(true)
                    .callTimeout(1000)
                    .connectTimeout(2000)
                    .readTimeout(3000)
                    .writeTimeout(4000)
                    .build()

            // Expect
            assertNotNull(config)
            assertEquals(listOf(mockInterceptor1), config.interceptors)
            assertEquals(listOf(mockInterceptor2), config.networkInterceptors)
            assertEquals(connectionPool, config.connectionPool)
            assertTrue(config.retryOnConnectionFailure!!)
            assertEquals(1000, config.callTimeout)
            assertEquals(2000, config.connectTimeout)
            assertEquals(3000, config.readTimeout)
            assertEquals(4000, config.writeTimeout)
        }
    }
}
