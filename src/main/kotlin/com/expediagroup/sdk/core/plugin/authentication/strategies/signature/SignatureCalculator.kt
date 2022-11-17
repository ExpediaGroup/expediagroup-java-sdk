/*
 * Copyright (C) 2022 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.sdk.core.plugin.authentication.strategies.signature

import com.expediagroup.sdk.core.constant.Signature.INCREMENT
import com.expediagroup.sdk.core.constant.Signature.ONE_BYTE_MASK
import com.expediagroup.sdk.core.constant.Signature.RADIX
import java.math.BigInteger.ONE
import java.nio.charset.StandardCharsets.UTF_8
import java.security.MessageDigest
import java.security.spec.MGF1ParameterSpec.SHA512
import java.time.LocalDateTime
import java.time.ZoneId

internal fun calculateSignature(apiKey: String, sharedSecret: String, localDateTime: LocalDateTime): String {
    val timestamp: Long = localDateTime.atZone(ZoneId.systemDefault()).toEpochSecond()
    val signature: String = generateSignature(apiKey, sharedSecret, timestamp)
    return "apikey=$apiKey,signature=$signature,timestamp=$timestamp"
}

private fun generateSignature(apiKey: String, secret: String, timestamp: Long): String {
    val toBeHashed = apiKey + secret + timestamp
    val md = MessageDigest.getInstance(SHA512.digestAlgorithm)
    val bytes = md.digest(toBeHashed.toByteArray(UTF_8))
    val sb = StringBuilder()
    for (aByte in bytes) {
        sb.append(((aByte.toInt() and ONE_BYTE_MASK) + INCREMENT).toString(RADIX).substring(ONE.toInt()))
    }
    return sb.toString()
}
