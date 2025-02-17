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

package com.expediagroup.sdk.core.transport

/**
 * Represents a resource or operation that can be explicitly disposed of to release its resources.
 *
 * Implementing classes should ensure that the `dispose()` method is called when the resource
 * is no longer needed to prevent resource leaks or unnecessary resource consumption.
 */
interface Disposable {
    /**
     * Releases any resources or operations associated with this instance.
     *
     * Implementers should ensure that:
     * - This method can be safely called multiple times.
     * - After calling this method, the instance is no longer usable.
     */
    fun dispose()
}
