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
package com.expediagroup.common.sdk.core.constant

internal object ConfigurationName {
    const val KEY = "key"

    const val SECRET = "secret"

    const val ENDPOINT = "endpoint"

    const val AUTH_ENDPOINT = "auth endpoint"

    const val DEFAULT_CONFIGURATION_PROVIDER = "default"

    const val FILE_SYSTEM_CONFIGURATION_PROVIDER = "file system"

    const val RUNTIME_CONFIGURATION_PROVIDER = "runtime configuration"

    const val CONFIGURATION_COLLECTOR = "configuration collector"
}
