package com.expediagroup.sdk.core.poc.authentication

import com.expediagroup.sdk.core.constant.SignatureValues
import com.expediagroup.sdk.core.poc.constant.RAPID_DEFAULT_TOKEN_EXPIRATION_SECONDS
import com.expediagroup.sdk.core.poc.datastore.ConfigurationsStore
import com.expediagroup.sdk.core.poc.model.Credentials
import com.google.auth.oauth2.AccessToken
import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.spec.MGF1ParameterSpec
import java.time.Instant
import java.util.*

class SignatureAuthenticationProvider(
    private val serviceClientId: String
): AuthenticationProvider {
    private var signature: String = ""

    override fun refreshAccessToken(): AccessToken {
        val credentials: Credentials = ConfigurationsStore.INSTANCE.load(serviceClientId).getAuthenticationConfiguration().credentials
        signature = calculateSignature(credentials.key, credentials.secret)

        return AccessToken.newBuilder()
            .setTokenValue(signature)
            .setExpirationTime(Date.from(Instant.now().plusSeconds(RAPID_DEFAULT_TOKEN_EXPIRATION_SECONDS)))
            .build()
    }

    private fun calculateSignature(
        apiKey: String,
        secret: String,
        timestamp: Long = Instant.now().epochSecond
    ): String {
        val toBeHashed = apiKey + secret + timestamp
        val messageDigest = MessageDigest.getInstance(MGF1ParameterSpec.SHA512.digestAlgorithm)
        val bytes = messageDigest.digest(toBeHashed.toByteArray(StandardCharsets.UTF_8))
        val signature =
            buildString {
                bytes.forEach {
                    append(((it.toInt() and SignatureValues.ONE_BYTE_MASK) + SignatureValues.INCREMENT).toString(SignatureValues.RADIX).substring(BigInteger.ONE.toInt()))
                }
            }
        return "${SignatureValues.API_KEY}=$apiKey,${SignatureValues.SIGNATURE}=$signature,${SignatureValues.TIMESTAMP}=$timestamp"
    }
}
