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
package com.expediagroup.sdk.core.configuration.interceptor

import com.expediagroup.sdk.core.plugin.logging.ExpediaGroupLoggerFactory
import okhttp3.Interceptor.Chain
import java.io.IOException

class OkHttpEventsLoggingInterceptor : okhttp3.Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): okhttp3.Response {
        val request: okhttp3.Request = chain.request()

        log.debug("Intercepted headers: {} from URL: {}", request.headers, request.url)
        return chain.proceed(request)
    }

    companion object {
        private val log = ExpediaGroupLoggerFactory.getLogger(this::class.java)
    }
}
