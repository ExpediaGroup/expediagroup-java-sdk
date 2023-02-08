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
package com.expediagroup.rapid.sdk.core.plugin.authentication.strategy

import com.expediagroup.common.sdk.core.constant.SignatureValues
import java.math.BigInteger.ONE
import java.nio.charset.StandardCharsets.UTF_8
import java.security.MessageDigest
import java.security.spec.MGF1ParameterSpec.SHA512

internal fun calculateSignature(apiKey: String, secret: String, timestamp: Long): String {
    val toBeHashed = apiKey + secret + timestamp
    val md = MessageDigest.getInstance(SHA512.digestAlgorithm)
    val bytes = md.digest(toBeHashed.toByteArray(UTF_8))
    val sb = StringBuilder()
    for (aByte in bytes) {
        sb.append(((aByte.toInt() and SignatureValues.ONE_BYTE_MASK) + SignatureValues.INCREMENT).toString(SignatureValues.RADIX).substring(ONE.toInt()))
    }
    val signature = sb.toString()
    return "${SignatureValues.API_KEY}=$apiKey,${SignatureValues.SIGNATURE}=$signature,${SignatureValues.TIMESTAMP}=$timestamp"
}
