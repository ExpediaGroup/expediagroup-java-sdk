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

package com.expediagroup.sdk.graphql.paging.model

/**
 * Represents pagination information for a paginated response.
 *
 * @param pageSize The number of items per page.
 * @param hasNext Indicates if there is a next page available.
 * @param cursor The current cursor position, if applicable.
 * @param nextPageCursor The cursor for the next page, used to fetch the following set of results.
 * @param totalCount The total count of items across all pages, if available.
 */
data class PageInfo(
    val pageSize: Int,
    val hasNext: Boolean,
    val cursor: String? = null,
    val nextPageCursor: String? = null,
    val totalCount: Int? = null
)
