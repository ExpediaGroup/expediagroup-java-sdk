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

import com.expediagroup.common.sdk.core.constant.Constant.EMPTY_STRING
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class OpenWorldConfigurationProviderTest {

    @Test
    fun `verify default values`() {
        assertEquals(EMPTY_STRING, OpenWorldConfigurationProvider.key)
        assertEquals(EMPTY_STRING, OpenWorldConfigurationProvider.secret)
        assertEquals("https://api.expediagroup.com/", OpenWorldConfigurationProvider.endpoint)
        assertEquals("https://api.expediagroup.com/identity/oauth2/v2/token/", OpenWorldConfigurationProvider.authEndpoint)
    }
}
