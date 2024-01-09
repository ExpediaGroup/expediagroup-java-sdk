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
package com.expediagroup.sdk.core.test

import java.util.Base64

object TestConstants {
    const val TEST_URL = "https://example.com"

    const val CLIENT_KEY_TEST_CREDENTIAL = "any client key"

    const val CLIENT_SECRET_TEST_CREDENTIAL = "any client secret"

    const val ACCESS_TOKEN = "test-access-token"

    const val BAD_REQUEST_ATTRIBUTE = "bad-request"

    const val ANY_URL = "http://any-url"

    const val TEXT_PLAIN = "text/plain"

    const val SUCCESSFUL_DUMMY_REQUEST = "successful dummy request"

    const val BASIC = "Basic"

    const val APPLICATION_JSON = "application/json"

    val ENCODED_CREDENTIALS = String(Base64.getEncoder().encode("$CLIENT_KEY_TEST_CREDENTIAL:$CLIENT_SECRET_TEST_CREDENTIAL".toByteArray()))
}
