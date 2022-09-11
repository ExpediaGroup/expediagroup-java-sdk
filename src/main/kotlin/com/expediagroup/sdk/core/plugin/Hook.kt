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
package com.expediagroup.sdk.core.plugin

import com.expediagroup.sdk.core.client.Client

/**
 * A helper to build a hook.
 */
internal interface HookBuilder<in C : PluginConfiguration> {
    fun build(client: Client, configs: C)
}

/**
 * A helper to build Hook configs.
 *
 * Ideally, it should be implemented by a companion object in a Hook class.
 */
internal interface HookConfigsBuilder<in C : PluginConfiguration, out H : Hook<C>> {
    fun with(configuration: C): H
}

/**
 * A hook is a post action we need to apply after creating a [Client].
 */
internal open class Hook<in C : PluginConfiguration>(
    private val configuration: C,
    private val builder: HookBuilder<C>
) {
    fun execute(client: Client) = builder.build(client, configuration)
}

/**
 * A singleton repository of all [Hook]s we need to apply on the [Client].
 */
internal object Hooks {
    private var hooks: MutableList<Hook<*>> = mutableListOf()

    fun <C : PluginConfiguration> add(hook: Hook<C>) {
        hooks += hook
    }

    fun execute(client: Client) {
        hooks.forEach { it.execute(client) }
    }
}

/**
 * Provide an idiomatic scope to define hooks.
 */
internal fun hooks(block: () -> Unit) = block()

/**
 * Provides an idiomatic way of defining a hook.
 */
internal fun <C : PluginConfiguration> use(hook: Hook<C>) = Hooks.add(hook)
