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
interface HookBuilder<in C : PluginConfigs> {
    fun build(client: Client, configs: C)
}

/**
 * A helper to build Hook configs.
 *
 * Ideally, it should be implemented by a companion object in a Hook class.
 */
interface HookConfigsBuilder<in C : PluginConfigs, out H : Hook<C>> {
    fun with(configs: C): H
}

/**
 * A hook is a post action we need to apply after creating a [Client].
 */
open class Hook<in C : PluginConfigs>(
    private val configs: C,
    private val builder: HookBuilder<C>
) {
    fun execute(client: Client) = builder.build(client, configs)
}

/**
 * A singleton repository of all [Hook]s we need to apply on the [Client].
 */
object Hooks {
    private var hooks: MutableList<Hook<*>> = mutableListOf()

    fun <C : PluginConfigs> add(hook: Hook<C>) {
        hooks += hook
    }

    fun execute(client: Client) {
        hooks.forEach { it.execute(client) }
    }
}

/**
 * Provide an idiomatic scope to define hooks.
 */
fun hooks(block: () -> Unit) = block()

/**
 * Provides an idiomatic way of defining a hook.
 */
fun <C : PluginConfigs> use(hook: Hook<C>) = Hooks.add(hook)
