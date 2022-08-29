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
package com.expediagroup.sdk.core.config

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ClientCredentialsTest {

    @Test
    fun `test ClientCredentialsFactory`() {
        ClientCredentials.from("client-key", "client-secret").let {
            Assertions.assertEquals(it, ClientCredentials("client-key", "client-secret"))
        }
    }
}
