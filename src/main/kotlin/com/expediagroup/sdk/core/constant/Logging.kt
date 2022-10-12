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
package com.expediagroup.sdk.core.constant

object Logging {
    const val RENEWING_TOKEN = "Renewing token"
    const val SUCCESSFUL_TOKEN_RENEWAL = "Token renewal successful: New token expires in {} seconds"
    const val FAILED_TOKEN_RENEWAL = "Token renewal failed: Response status[{}]"
    const val CLEARING_TOKENS = "Clearing tokens"
    const val TOKEN_EXPIRED = "Token expired or is about to expire: Requests will wait until token is renewed"
    const val UNSUCCESSFUL_RESPONSE = "Unsuccessful response [{}]"
    const val COULD_NOT_RECEIVE_RESPONSE_PAYLOAD = "Could not receive the payload of the response"
}
