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
package com.expediagroup.rapid.sdk.core.configuration

import com.expediagroup.common.sdk.core.test.TestConstants
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class BaseRapidClientBuilderTest {

    @Test
    fun `verify typical behaviour with no configurations`() {
        assertNotNull(BaseRapidClientBuilder().build().httpClient)
    }

    @Test
    fun `verify typical behaviour with configurations`() {
        assertNotNull(
            BaseRapidClientBuilder()
                .key(TestConstants.CLIENT_KEY_TEST_CREDENTIAL)
                .secret(TestConstants.CLIENT_SECRET_TEST_CREDENTIAL)
                .endpoint(TestConstants.ANY_URL)
                .build()
                .httpClient
        )
    }
}
