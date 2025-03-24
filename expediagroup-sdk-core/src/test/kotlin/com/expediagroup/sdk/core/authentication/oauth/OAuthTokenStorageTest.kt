package com.expediagroup.sdk.core.authentication.oauth

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class OAuthTokenStorageTest {
    @Test
    fun `toString should not expose sensitive data`() {
        // Given
        val mockClock =
            mockk<Clock> {
                every { instant() } returns Instant.parse("2024-01-01T12:00:00Z")
                every { zone } returns ZoneOffset.UTC
            }
        val tokenStorage = OAuthTokenStorage.create("standard_token", 3600, clock = mockClock)

        // When
        val stringToken = tokenStorage.toString()

        // Expect
        val expected = "OAuthTokenStorage(expiresIn=3600, expirationBufferSeconds=60, expiryInstant=${
            Instant.now(mockClock).plusSeconds(3600)
        })"
        assertEquals(expected, stringToken)
    }

    @Nested
    inner class TokenCreationTests {
        @Test
        fun `create token with standard parameters`() {
            val mockClock =
                mockk<Clock> {
                    every { instant() } returns Instant.parse("2024-01-01T12:00:00Z")
                    every { zone } returns ZoneOffset.UTC
                }

            val tokenStorage =
                OAuthTokenStorage.create(
                    accessToken = "standard_token",
                    expiresIn = 3600,
                    clock = mockClock
                )

            assertAll(
                "Token creation assertions",
                { assertEquals("standard_token", tokenStorage.accessToken) },
                { assertFalse(tokenStorage.isAboutToExpire()) },
                { assertEquals("Bearer standard_token", tokenStorage.getAuthorizationHeaderValue()) }
            )
        }

        @ParameterizedTest
        @ValueSource(longs = [0, 1, 59, 60, 61, 3600, 3600 * 24 * 365]) // Use a more reasonable large value
        fun `create token with varied expiration times`(expiresIn: Long) {
            val tokenStorage =
                try {
                    OAuthTokenStorage.create(
                        accessToken = "test_token",
                        expiresIn = expiresIn.coerceAtMost(3600 * 24 * 365) // Limit to max 1 year
                    )
                } catch (e: Exception) {
                    // If creation fails, the token should be considered expired
                    null
                }

            if (expiresIn < 0) {
                assertTrue(
                    tokenStorage == null || tokenStorage.isAboutToExpire(),
                    "Token with negative expiration should be null or expired"
                )
            } else {
                assertNotNull(tokenStorage, "Token storage should not be null for non-negative expiration")
            }
        }
    }

    @Nested
    inner class ExpirationTests {
        @Test
        fun `token with negative expiration time`() {
            val tokenStorage =
                OAuthTokenStorage.create(
                    accessToken = "expired_token",
                    expiresIn = -1
                )

            assertTrue(tokenStorage.isAboutToExpire(), "Negative expiration should always be considered expired")
        }

        @Test
        fun `empty token always expires`() {
            val emptyTokenStorage = OAuthTokenStorage.empty

            assertAll(
                "Empty token assertions",
                { assertTrue(emptyTokenStorage.isAboutToExpire()) },
                { assertEquals("Bearer ", emptyTokenStorage.getAuthorizationHeaderValue()) },
                { assertEquals("", emptyTokenStorage.accessToken) }
            )
        }

        @ParameterizedTest
        @CsvSource(
            "3, 1, false", // Not yet expired
            "3, 2, true" // About to expire
        )
        fun `token expiration with custom buffer`(
            expiresIn: Long,
            bufferSeconds: Long,
            expectedExpired: Boolean
        ) {
            val tokenStorage =
                OAuthTokenStorage.create(
                    accessToken = "buffer_test_token",
                    expiresIn = expiresIn,
                    expirationBufferSeconds = bufferSeconds,
                    clock = Clock.systemUTC()
                )

            Thread.sleep(1000 * bufferSeconds)

            assertEquals(expectedExpired, tokenStorage.isAboutToExpire())
        }
    }

    @Nested
    inner class AuthorizationHeaderTests {
        @Test
        fun `authorization header with special characters`() {
            val tokenWithSpecialChars = "token!@#$%^&*()_+"
            val tokenStorage =
                OAuthTokenStorage.create(
                    accessToken = tokenWithSpecialChars,
                    expiresIn = 3600
                )

            assertEquals("Bearer token!@#\$%^&*()_+", tokenStorage.getAuthorizationHeaderValue())
        }

        @Test
        fun `authorization header with unicode characters`() {
            val tokenWithUnicode = "token_🚀_special@chars_😊"
            val tokenStorage =
                OAuthTokenStorage.create(
                    accessToken = tokenWithUnicode,
                    expiresIn = 3600
                )

            assertEquals("Bearer token_🚀_special@chars_😊", tokenStorage.getAuthorizationHeaderValue())
        }
    }

    @Nested
    inner class ConcurrencyTests {
        @Test
        fun `concurrent token creation`() {
            val executor = Executors.newFixedThreadPool(10)
            val latch = CountDownLatch(100)
            val tokens = ConcurrentLinkedQueue<OAuthTokenStorage>()

            repeat(100) {
                executor.submit {
                    try {
                        val token =
                            OAuthTokenStorage.create(
                                accessToken = "concurrent_token_$it",
                                expiresIn = 3600
                            )
                        tokens.add(token)
                    } finally {
                        latch.countDown()
                    }
                }
            }

            latch.await(5, TimeUnit.SECONDS)
            executor.shutdown()

            assertEquals(100, tokens.size, "All tokens should be created successfully")
            assertTrue(tokens.all { it.accessToken.startsWith("concurrent_token_") })
        }
    }

    @Nested
    inner class EdgeCaseTests {
        @Test
        fun `extreme expiration buffer scenarios`() {
            // Very small buffer
            val smallBufferToken =
                OAuthTokenStorage.create(
                    accessToken = "small_buffer_token",
                    expiresIn = 10,
                    expirationBufferSeconds = 1
                )

            // Extremely large buffer
            val largeBufferToken =
                OAuthTokenStorage.create(
                    accessToken = "large_buffer_token",
                    expiresIn = 3600,
                    expirationBufferSeconds = 3599
                )

            assertAll(
                "Extreme buffer assertions",
                { assertNotNull(smallBufferToken) },
                { assertNotNull(largeBufferToken) }
            )
        }

        @Test
        fun `clock precision edge cases`() {
            val precisionTestClock =
                mockk<Clock> {
                    every { instant() } returns
                        Instant
                            .now()
                            .plusSeconds(30)
                            .plusNanos(999_999_999)
                    every { zone } returns ZoneOffset.UTC
                }

            val tokenStorage =
                OAuthTokenStorage.create(
                    accessToken = "precision_test_token",
                    expiresIn = 30,
                    expirationBufferSeconds = 31,
                    clock = precisionTestClock
                )

            assertTrue(
                tokenStorage.isAboutToExpire(),
                "Token should be considered about to expire near precision boundaries"
            )
        }
    }

    @Nested
    inner class StabilityTests {
        @Test
        fun `verify empty token singleton`() {
            val emptyToken1 = OAuthTokenStorage.empty
            val emptyToken2 = OAuthTokenStorage.empty

            assertSame(emptyToken1, emptyToken2, "Empty token should be a singleton")
        }

        @Test
        fun `multiple token creations consistency`() {
            val tokens =
                (1..100).map {
                    OAuthTokenStorage.create("token_$it", 3600)
                }

            assertTrue(
                tokens.all { !it.isAboutToExpire() },
                "None of the created tokens should be expired"
            )
            assertTrue(
                tokens.all { it.getAuthorizationHeaderValue().startsWith("Bearer token_") },
                "All tokens should have correct authorization header"
            )
        }
    }
}
