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
package com.expediagroup.sdk.core.constants

import java.io.File

object ClientConstants {
    const val EMPTY_STRING = ""

    const val DEFAULT_BASE_URL = "https://api.expediagroup.com"

    const val DEFAULT_AUTH_URL = "$DEFAULT_BASE_URL/identity/oauth2/v2/token"

    const val AUTHORIZATION_REQUEST_LOCK_DELAY = 20L // TODO: Update me.

    const val AUTHORIZATION_HEADER = "Authorization"

    const val CAPITALIZED_AUTHENTICATE_HEADER = "WWW-Authenticate"

    const val AUTHENTICATE_HEADER = "www-authenticate"

    const val GRANT_TYPE_HEADER = "grant_type"

    const val CLIENT_CREDENTIALS_HEADER = "client_credentials"

    const val CLIENT_KEY = "client_key"

    const val CLIENT_SECRET = "client_secret"

    const val BASE_URL = "base_url"

    const val AUTH_URL = "auth_url"

    private val OPEN_WORLD_HOME_PATH = "${System.getProperty("user.home")}${File.separator}.openworld${File.separator}"

    val CREDENTIALS_FILE_PATH = "${OPEN_WORLD_HOME_PATH}credentials"

    val CLIENT_CONFIGS_FILE_PATH = "${OPEN_WORLD_HOME_PATH}configuration"
}
