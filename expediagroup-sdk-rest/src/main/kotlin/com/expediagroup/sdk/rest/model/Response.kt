/*
 * Copyright (C) 2025 Expedia, Inc.
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

package com.expediagroup.sdk.rest.model

import com.expediagroup.sdk.core.http.Headers

/**
 * A generic response model that contains the data and headers of an HTTP response.
 *
 * @param T the type of the response data
 * @property data the response data
 * @property headers the response headers
 */
data class Response<T>(
    val data: T,
    val headers: Headers
)
