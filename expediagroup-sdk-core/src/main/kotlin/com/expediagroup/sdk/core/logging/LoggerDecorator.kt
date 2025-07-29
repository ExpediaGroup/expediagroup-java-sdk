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

package com.expediagroup.sdk.core.logging

import org.slf4j.Logger

class LoggerDecorator(
    private val logger: Logger
) : Logger by logger {
    override fun info(msg: String) = logger.info(decorate(msg))

    override fun warn(msg: String) = logger.warn(decorate(msg))

    override fun debug(msg: String) = logger.debug(decorate(msg))

    override fun error(msg: String) = logger.error(decorate(msg))

    override fun trace(msg: String) = logger.trace(decorate(msg))

    fun info(msg: String, vararg tags: String) = logger.info(decorate(msg, tags.toSet()))

    fun warn(msg: String, vararg tags: String) = logger.warn(decorate(msg, tags.toSet()))

    fun debug(msg: String, vararg tags: String) = logger.debug(decorate(msg, tags.toSet()))

    fun error(msg: String, vararg tags: String) = logger.error(decorate(msg, tags.toSet()))

    fun trace(msg: String, vararg tags: String) = logger.trace(decorate(msg, tags.toSet()))

    private fun decorate(msg: String, tags: Set<String>? = null): String = buildString {
        append("[${Constant.EXPEDIA_GROUP_SDK}] - ")
        tags?.let {
            if (tags.isNotEmpty()) {
                append("[")
                append(it.joinToString(", "))
                append("] - ")
            }
        }
        append(msg.trim())
    }
}
