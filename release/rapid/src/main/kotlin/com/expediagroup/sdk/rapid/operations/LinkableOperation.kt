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
package com.expediagroup.sdk.rapid.operations

import com.expediagroup.sdk.core.model.OperationParams
import com.expediagroup.sdk.core.model.exception.client.ExpediaGroupClientException
import com.expediagroup.sdk.rapid.models.Link
import org.apache.commons.text.StringSubstitutor
import java.net.URI

interface LinkableOperation {
    fun url(
        params: OperationParams?,
        link: Link?,
        url: String
    ): String {
        val pathParams = params?.getPathParams()

        if (link?.href != null) {
            val uri = URI(link.href)

            if (Regex(pathPattern()).matches(uri.path)) return "${uri.path}?${uri.query}"
            throw ExpediaGroupClientException()
        }

        val substitutor = StringSubstitutor(pathParams, "{", "}")
        return substitutor.replace(url)
    }

    fun pathPattern(): String
}
