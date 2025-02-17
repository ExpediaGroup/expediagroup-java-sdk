/*
 * Copyright (C) 2024 Expedia, Inc.
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

package com.expediagroup.sdk.graphql.paging

import com.expediagroup.sdk.graphql.paging.model.PaginatedResponse

abstract class Paginator<T : PaginatedResponse<*, *>> : Iterator<T> {
    protected var hasNext: Boolean = true
    private var initialized: Boolean = false

    override fun hasNext(): Boolean {
        if (!initialized) {
            initialized = true
            return hasPagesToFetch().also { hasNext = it }
        }

        return hasNext
    }

    protected abstract fun hasPagesToFetch(): Boolean
}
