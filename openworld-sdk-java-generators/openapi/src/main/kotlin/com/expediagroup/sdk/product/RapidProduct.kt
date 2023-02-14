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
package com.expediagroup.sdk.product

data class RapidProduct(
    val inputNamespace: String = "rapid",
    override val programmingLanguage: ProgrammingLanguage = ProgrammingLanguage.JAVA
) : Product {

    constructor(inputNamespace: String = "rapid", programmingLanguage: String = "java") : this(
        inputNamespace,
        ProgrammingLanguage.from(programmingLanguage)
    )

    private val normalizedNamespace = normalizeNamespace(inputNamespace).lowercase()

    override val productFamily: ProductFamily
        get() = ProductFamily.RAPID

    override val namespace: String
        get() = normalizedNamespace

    override val apiPackage: String
        get() = "com.expediagroup.$normalizedNamespace.sdk.client"

    override val artifactId: String
        get() = "rapid-${programmingLanguage.id}-sdk"

    override val packagePath: String
        get() = "src/main/kotlin/com/expediagroup/$normalizedNamespace/sdk"

    override val packageName: String
        get() = "com.expediagroup.$normalizedNamespace.sdk"

    override val groupId: String
        get() = "com.expediagroup.rapid.sdk"

    override val shadePrefix: String
        get() = "com.expediagroup.rapid.sdk"

    override val excludesPath: String
        get() = "com/expediagroup/openworld/**"
}
