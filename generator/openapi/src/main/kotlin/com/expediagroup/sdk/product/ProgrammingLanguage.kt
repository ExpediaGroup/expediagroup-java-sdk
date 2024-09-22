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

enum class ProgrammingLanguage(val id: String) {
    JAVA("java"),
    KOTLIN("kotlin"),;

    companion object {
        /**
         * Returns the ProgrammingLanguage enum value for the given name.
         *
         * @param language the name of the ProgrammingLanguage
         * @return the ProgrammingLanguage enum value
         */
        fun from(language: String): ProgrammingLanguage = ProgrammingLanguage.values().first { it.id == language }

        /**
         * Returns true if the given ProgrammingLanguage is Kotlin.
         *
         * @param language the ProgrammingLanguage to check
         * @return true if the ProgrammingLanguage is Kotlin
         */
        fun isKotlin(language: ProgrammingLanguage): Boolean = language == KOTLIN
    }
}
