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

import com.expediagroup.openworld.sdk.generators.openapi.Constant
import com.expediagroup.openworld.sdk.generators.openapi.Constant.INDENTATION_LENGTH
import com.expediagroup.openworld.sdk.generators.openapi.Constant.INDENT_WITH_INDICATOR
import com.expediagroup.openworld.sdk.generators.openapi.Constant.INDICATOR_INDENTATION_LENGTH
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml
import java.nio.file.Files
import java.util.*
import kotlin.io.path.Path
import kotlin.io.path.inputStream

internal class YamlProcessor(path: String, namespace: String) {
    private val yaml = Yaml(dumperOptions)
    private val rootMap: FunctionalMap
    private val tag: String

    init {
        val inputStream = Path(path).inputStream()
        rootMap = FunctionalMap(yaml.load(inputStream))
        tag = camelCase(namespace)
    }

    fun process(): String {
        unifyTags()
        removeUnwantedHeaders()
        return dump()
    }

    private fun unifyTags() {
        replaceTagsWithTag()
        replacePathsTags()
    }

    private fun replaceTagsWithTag() {
        val tagsList = listOf(mapOf(Pair(NAME, tag)))
        rootMap.put(TAGS, tagsList)
    }

    private fun replacePathsTags() {
        rootMap.mapApply(PATHS) { _, pathsMap ->
            pathsMap.forEachMap { _, pathMap ->
                pathMap.forEachMap { _, methodMap ->
                    methodMap.put(TAGS, listOf(tag))
                }
            }
        }
    }

    private fun removeUnwantedHeaders() {
        val unwantedComponentsParameters = getUnwantedComponentsParameters()

        rootMap.mapApply(PATHS) { _, pathsMap ->
            pathsMap.forEachMap { _, pathMap ->
                pathMap.forEachMap { _, methodMap ->
                    methodMap.listApply(PARAMETERS) { parameters ->
                        parameters.removeIf { parameter ->
                            isUnwanted(parameter, unwantedComponentsParameters)
                        }
                    }
                }
            }
        }
    }

    private fun getUnwantedComponentsParameters(): MutableList<String> {
        val unwantedComponentsParameters = mutableListOf<String>()
        rootMap.mapApply(COMPONENTS) { _, componentsMap ->
            componentsMap.mapApply(PARAMETERS) { _, parameters ->
                parameters.forEachMap { key, parameter ->
                    if (isUnwantedHeader(parameter)) {
                        unwantedComponentsParameters.add(toComponentsParameterRef(key))
                    }
                }
            }
        }
        return unwantedComponentsParameters
    }

    private fun isUnwanted(parameter: FunctionalMap, unwantedComponentsParameters: MutableList<String>) =
        isUnwantedComponentsParameter(parameter, unwantedComponentsParameters) || isUnwantedHeader(parameter)

    private fun isUnwantedHeader(parameter: FunctionalMap) =
        parameter.get(NAME)?.let { UNWANTED_HEADERS.contains((it as String).lowercase()) } ?: false

    private fun isUnwantedComponentsParameter(parameter: FunctionalMap, unwantedDefinedParameters: List<String>) =
        parameter.get(REF)?.let { unwantedDefinedParameters.contains(it as String) } ?: false

    private fun toComponentsParameterRef(ref: String) = "$COMPONENTS_PARAMETER$ref"

    private fun dump(): String {
        val tempFile = Files.createTempFile(UUID.randomUUID().toString(), TEMP).toFile()
        yaml.dump(rootMap.map, tempFile.bufferedWriter())
        return tempFile.path
    }

    companion object {
        private const val NAME = "name"
        private const val REF = "\$ref"
        private const val TAGS = "tags"
        private const val TEMP = "temp"
        private const val PATHS = "paths"
        private const val COMPONENTS = "components"
        private const val PARAMETERS = "parameters"
        private const val COMPONENTS_PARAMETER = "#/components/parameters/"
        private val UNWANTED_HEADERS = listOf(
            "accept",
            "accept-encoding",
            "user-agent",
            "authorization",
            "content-type"
        )
        private val dumperOptions = DumperOptions()

        init {
            dumperOptions.indent = INDENTATION_LENGTH
            dumperOptions.indentWithIndicator = INDENT_WITH_INDICATOR
            dumperOptions.indicatorIndent = INDICATOR_INDENTATION_LENGTH
            dumperOptions.defaultFlowStyle = DumperOptions.FlowStyle.BLOCK
            dumperOptions.defaultScalarStyle = DumperOptions.ScalarStyle.PLAIN
        }

        private fun camelCase(string: String): String {
            return string.split(Constant.NON_ALPHANUMERIC_REGEX).joinToString("") { capitalize(it) }
        }

        private fun capitalize(string: String) = string.replaceFirstChar { it.uppercaseChar() }
    }
}
