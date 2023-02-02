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
package com.expediagroup.common.sdk.core.test

import com.expediagroup.common.sdk.core.constant.SignatureValues.API_KEY
import com.expediagroup.common.sdk.core.constant.SignatureValues.SIGNATURE
import com.expediagroup.common.sdk.core.constant.SignatureValues.TIMESTAMP

object TestConstants {
    const val TEST_URL = "https://example.com"

    const val CLIENT_KEY_TEST_CREDENTIAL = "any client key"

    const val CLIENT_SECRET_TEST_CREDENTIAL = "any client secret"

    const val ACCESS_TOKEN = "test-access-token"

    const val BAD_REQUEST_ATTRIBUTE = "bad-request"

    const val ANY_URL = "http://any-url"

    const val GZIP = "gzip"

    const val TEXT_PLAIN = "text/plain"

    const val SUCCESSFUL_DUMMY_REQUEST = "successful dummy request"

    const val SIGNATURE_VALUE = "signature-value"

    private const val SIGNATURE_MANUALLY_CALCULATED_VALUE = "497c9934cbfed8ccaeaf6a242d4eec88866f00965c641f68afe1f428d101b50aabacb7f8769fcad15cba8aff0970044c5cd51d022f5b0817007a58b545ff4d0d"
    const val SIGNATURE_TIMESTAMP_UTC: Long = 918_943_200
    const val MANUALLY_CALCULATED_SIGNATURE = "$API_KEY=any client key,$SIGNATURE=$SIGNATURE_MANUALLY_CALCULATED_VALUE,$TIMESTAMP=$SIGNATURE_TIMESTAMP_UTC"

    const val BASIC = "Basic"

    const val APPLICATION_JSON = "application/json"
}
