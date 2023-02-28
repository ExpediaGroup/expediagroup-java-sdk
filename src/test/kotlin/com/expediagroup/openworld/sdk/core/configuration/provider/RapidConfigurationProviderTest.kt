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
package com.expediagroup.openworld.sdk.core.configuration.provider

import com.expediagroup.openworld.sdk.core.constant.Constant.EMPTY_STRING
import com.expediagroup.openworld.sdk.core.constant.Constant.TEN_SECONDS_IN_MILLIS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RapidConfigurationProviderTest {

    @Test
    fun `verify default values`() {
        assertEquals(EMPTY_STRING, RapidConfigurationProvider.key)
        assertEquals(EMPTY_STRING, RapidConfigurationProvider.secret)
        assertEquals("https://api.ean.com/v3", RapidConfigurationProvider.endpoint)
        assertEquals(EMPTY_STRING, RapidConfigurationProvider.authEndpoint)
        assertEquals(TEN_SECONDS_IN_MILLIS, RapidConfigurationProvider.requestTimeout)
    }
}
