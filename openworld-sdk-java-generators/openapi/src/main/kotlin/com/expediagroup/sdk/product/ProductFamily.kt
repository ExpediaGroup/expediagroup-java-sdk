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

enum class ProductFamily(val id: String) {
    OPEN_WORLD("openworld"),
    RAPID("rapid");

    companion object {
        /**
         * Returns if the given ProductFamily is Rapid.
         *
         * @param productFamily the ProductFamily to check
         * @return true if the ProductFamily is Rapid
         */
        fun isRapid(productFamily: ProductFamily): Boolean = productFamily == RAPID

        /**
         * Returns if the given ProductFamily is OpenWorld.
         *
         * @param productFamily the ProductFamily to check
         * @return true if the ProductFamily is OpenWorld
         */
        fun isOpenWorld(productFamily: ProductFamily): Boolean = productFamily == OPEN_WORLD
    }
}
