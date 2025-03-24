package com.expediagroup.sdk.core.authentication.oauth

import com.expediagroup.sdk.core.exception.client.ExpediaGroupResponseParsingException
import com.expediagroup.sdk.core.http.CommonMediaTypes
import com.expediagroup.sdk.core.http.MediaType
import com.expediagroup.sdk.core.http.Method
import com.expediagroup.sdk.core.http.Protocol
import com.expediagroup.sdk.core.http.Request
import com.expediagroup.sdk.core.http.Response
import com.expediagroup.sdk.core.http.ResponseBody
import com.expediagroup.sdk.core.http.Status
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OAuthTokenResponseTest {
    @Test
    fun `should map to the expected api response`() {
        val accessToken = "token"
        val expiresIn = 3600L

        var available: Int?
        val oauthTokenResponse =
            OAuthTokenResponse.parse(
                Response
                    .builder()
                    .body(
                        ResponseBody.create(
                            """{ "access_token": "$accessToken", "expires_in": $expiresIn }"""
                                .toByteArray()
                                .inputStream()
                                .also {
                                    available = it.available()
                                },
                            CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                            available!!.toLong()
                        )
                    ).status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .message("Accepted")
                    .request(
                        Request
                            .builder()
                            .url("http://localhost")
                            .method(Method.POST)
                            .build()
                    ).build()
            )

        assertEquals(oauthTokenResponse.accessToken, accessToken)
        assertEquals(oauthTokenResponse.expiresIn, expiresIn)
    }

    @Test
    fun `should map to the expected api response with the response media type charset`() {
        // Given
        val accessToken = "token"
        val responseString = """{ "access_token": "$accessToken", "expires_in": 3600 }"""

        val oauthTokenResponse =
            OAuthTokenResponse.parse(
                Response
                    .builder()
                    .body(
                        ResponseBody.create(
                            responseString.toByteArray().inputStream(),
                            mediaType = MediaType.parse("application/json; charset=utf-8")
                        )
                    ).status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .request(
                        Request
                            .builder()
                            .url("http://localhost")
                            .method(Method.POST)
                            .build()
                    ).build()
            )

        assertEquals(oauthTokenResponse.accessToken, accessToken)
        assertEquals(oauthTokenResponse.expiresIn, 3600L)
    }

    @Test
    fun `should map to the expected api response without media type and default to utf8`() {
        // Given
        val accessToken = "token"
        val responseString = """{ "access_token": "$accessToken", "expires_in": 3600 }"""

        val oauthTokenResponse =
            OAuthTokenResponse.parse(
                Response
                    .builder()
                    .body(ResponseBody.create(responseString.toByteArray().inputStream(), mediaType = null))
                    .status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .request(
                        Request
                            .builder()
                            .url("http://localhost")
                            .method(Method.POST)
                            .build()
                    ).build()
            )

        assertEquals(oauthTokenResponse.accessToken, accessToken)
        assertEquals(oauthTokenResponse.expiresIn, 3600L)
    }

    @Test
    fun `parse should throw ExpediaGroupResponseParsingException in case of unsuccessful response`() {
        assertThrows<ExpediaGroupResponseParsingException> {
            OAuthTokenResponse.parse(
                Response
                    .builder()
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .protocol(Protocol.HTTP_1_1)
                    .message(Status.INTERNAL_SERVER_ERROR.name)
                    .request(
                        Request
                            .builder()
                            .url("http://localhost")
                            .method(Method.POST)
                            .build()
                    ).build()
            )
        }
    }

    @Test
    fun `parse should throw ExpediaGroupResponseParsingException if access_token or expiresIn are missing`() {
        var available: Int?
        assertThrows<ExpediaGroupResponseParsingException> {
            OAuthTokenResponse.parse(
                Response
                    .builder()
                    .body(
                        ResponseBody.create(
                            """{ "expires_in": 3600 }"""
                                .toByteArray()
                                .inputStream()
                                .also { available = it.available() },
                            CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                            available!!.toLong()
                        )
                    ).status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .message("Accepted")
                    .request(
                        Request
                            .builder()
                            .url("http://localhost")
                            .method(Method.POST)
                            .build()
                    ).build()
            )
        }
    }

    @Test
    fun `parse should ignore extra fields as long as access_token and expires_in are present`() {
        val accessToken = "token"
        val expiresIn = 3600L
        var available: Int?
        val oauthTokenResponse =
            OAuthTokenResponse.parse(
                Response
                    .builder()
                    .body(
                        ResponseBody.create(
                            """{ "access_token": "$accessToken", "expires_in": $expiresIn, "extra": "random" }"""
                                .toByteArray()
                                .inputStream()
                                .also {
                                    available = it.available()
                                },
                            CommonMediaTypes.APPLICATION_FORM_URLENCODED,
                            available!!.toLong()
                        )
                    ).status(Status.ACCEPTED)
                    .protocol(Protocol.HTTP_1_1)
                    .message("Accepted")
                    .request(
                        Request
                            .builder()
                            .url("http://localhost")
                            .method(Method.POST)
                            .build()
                    ).build()
            )

        assertEquals(oauthTokenResponse.accessToken, accessToken)
        assertEquals(oauthTokenResponse.expiresIn, expiresIn)
    }
}
