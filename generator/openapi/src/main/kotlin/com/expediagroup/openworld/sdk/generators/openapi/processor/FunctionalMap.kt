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
package com.expediagroup.openworld.sdk.generators.openapi.processor

import com.expediagroup.openworld.sdk.generators.openapi.processor.FunctionalList.Companion.toMutableList
import com.expediagroup.openworld.sdk.model.PreProcessingException

internal class FunctionalMap(val map: MutableMap<Any?, Any?>) {
    fun get(key: String) = map[key]

    fun put(key: String, value: Any) {
        map[key] = value
    }

    fun mapApply(key: String, block: (String, FunctionalMap) -> Unit) {
        val traversingMap = toMutableMap(map[key])
        block(key, FunctionalMap(traversingMap))
        put(key, traversingMap)
    }

    fun listApply(key: String, block: (FunctionalList) -> Unit) {
        val traversingList = toMutableList(map[key])
        block(FunctionalList(traversingList))
        put(key, traversingList)
    }

    fun forEachMap(block: (String, FunctionalMap) -> Unit) {
        map.keys.forEach { key ->
            mapApply(key as String, block)
        }
    }

    companion object {
        fun toMutableMap(obj: Any?): MutableMap<Any?, Any?> {
            obj ?: return mutableMapOf()
            if (obj is Map<*, *>) {
                return obj.toMutableMap()
            }
            throw PreProcessingException("Could not convert object to map")
        }
    }
}
