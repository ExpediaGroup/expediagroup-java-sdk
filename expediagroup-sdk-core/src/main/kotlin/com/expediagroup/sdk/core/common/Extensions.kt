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

package com.expediagroup.sdk.core.common

inline fun <T> T?.getOrThrow(exceptionSupplier: () -> Throwable): T = this ?: throw exceptionSupplier()

/**
 * Retrieves an exception of the specified type from the exception stack.
 *
 * This function traverses the exception cause chain up to the specified limit
 * to find the first occurrence of the requested exception type.
 *
 * @param exceptionType The class of the exception type to search for
 * @param limit Maximum number of exceptions to traverse in the chain (default: 1_000)
 * @return The first exception of the specified type found in the chain, or null if not found
 *
 * @see Throwable.cause
 */
fun Throwable.getExceptionFromStack(exceptionType: Class<out Throwable>, limit: Int = 1_000): Throwable? {
    var depth = 0
    var throwable: Throwable? = this

    while (throwable != null && depth < limit) {
        if (exceptionType.isInstance(throwable)) {
            return throwable
        }

        throwable = throwable.cause
        depth++
    }

    return null
}
