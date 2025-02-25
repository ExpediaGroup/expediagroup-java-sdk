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

package com.expediagroup.sdk.openapigenerator.util

val NON_ALPHANUMERIC_REGEX = Regex("[^a-zA-Z0-9]")

class Product(namespace: String) {
    val namespace: String = namespace.replace(NON_ALPHANUMERIC_REGEX, "").lowercase()

    val apiPackage: String
        get() = "com.expediagroup.sdk.$namespace.operations"

    val modelsPackage: String
        get() = "com.expediagroup.sdk.$namespace.models"

    val packageName: String
        get() = "com.expediagroup.sdk.$namespace"

    val groupId: String
        get() = "com.expediagroup"
}
