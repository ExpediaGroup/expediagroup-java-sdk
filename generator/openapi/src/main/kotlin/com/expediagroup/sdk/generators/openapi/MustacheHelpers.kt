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
package com.expediagroup.sdk.generators.openapi

import com.samskivert.mustache.Mustache
import org.openapitools.codegen.CodegenModel
import org.openapitools.codegen.CodegenProperty
import org.openapitools.codegen.CodegenResponse
import org.openapitools.codegen.model.OperationsMap

val mustacheHelpers = mapOf(
    "removeLeadingSlash" to {
        Mustache.Lambda { fragment, writer -> writer.write(fragment.execute().removePrefix("/")) }
    },
    "assignDiscriminators" to {
        Mustache.Lambda { fragment, writer ->
            val model = fragment.context() as CodegenModel
            getParentDiscriminator(model).forEach {
                val type: String = (if (it.isEnum) "${it.parentName}." else "") + it.type
                val value: String = if (it.isString && !it.isEnum) "\"${it.value}\"" else "$type.${it.value}"
                writer.write("@JsonProperty(\"${it.originalName}\")\n")
                writer.write("override val ${it.name} : $type = $value\n")
            }
        }
    },
    "eliminateDiscriminators" to {
        Mustache.Lambda { fragment, writer ->
            val discriminators: List<String> = getParentDiscriminator(fragment.context(1) as CodegenModel).map { it.originalName }
            val property = fragment.context() as CodegenProperty
            if (!discriminators.contains(property.baseName)) {
                writer.write(fragment.execute())
            }
        }
    },
    "defineApiExceptions" to {
        Mustache.Lambda { fragment, writer ->
            val dataTypes: MutableSet<String> = mutableSetOf()
            val operationsMap: OperationsMap = fragment.context() as OperationsMap
            operationsMap.operations.operation.forEach { operation ->
                operation.responses.forEach { response ->
                    response.takeIf { !it.is2xx && !dataTypes.contains(it.dataType) }?.dataType?.also {
                        writer.write(
                            "class ExpediaGroupApi${it}Exception(code: Int, override val errorObject: $it, transactionId: String?) : " +
                                "ExpediaGroupApiException(code, errorObject, transactionId)\n"
                        )
                        dataTypes.add(it)
                    }
                }
            }
        }
    },
    "throwsExceptions" to {
        Mustache.Lambda { fragment, writer ->
            val dataTypes: Set<String> = collectDataTypes(fragment)
            val stringBuilder = StringBuilder()
            dataTypes.forEachIndexed { index, dataType ->
                if (index > 0) stringBuilder.append(" ".repeat(5))
                stringBuilder.append("* @throws ExpediaGroupApi${dataType}Exception")
                if (index < dataTypes.size - 1) stringBuilder.append("\n")
            }
            writer.write(stringBuilder.toString())
        }
    },
    "throwsExceptionsClasses" to {
        Mustache.Lambda { fragment, writer ->
            val dataTypes: Set<String> = collectDataTypes(fragment)
            val stringBuilder = StringBuilder()
            val notNullDataTypes = dataTypes.filterNotNull()
            notNullDataTypes.forEachIndexed { index, dataType ->
                if (index > 0) stringBuilder.append(" ".repeat(8))
                stringBuilder.append("ExpediaGroupApi${dataType}Exception::class")
                if (index < notNullDataTypes.size - 1) stringBuilder.append(",\n")
            }
            writer.write(stringBuilder.toString())
        }
    },
    "fallbackBody" to {
        Mustache.Lambda { fragment, writer ->
            val dataType: String = fragment.context() as String
            if (dataType.startsWith("kotlin.collections.List")) {
                writer.write("emptyList()")
            } else if (dataType.startsWith("kotlin.collections.Map")) {
                writer.write("emptyMap()")
            } else if (dataType.startsWith("kotlin.collections.Set")) {
                writer.write("emptySet()")
            }
        }
    },
    "removeDoubleQuotes" to {
        Mustache.Lambda { fragment, writer ->
            val data: String = fragment.context() as String
            writer.write("\"${data.replace(Regex("^\"+|\"$"), "")}\"")
        }
    },
    "httpAcceptHeader" to {
        Mustache.Lambda { fragment, writer ->
            val response: CodegenResponse = fragment.context() as CodegenResponse
            if (response.code == "200") {
                val mediaTypes: MutableSet<String> = response.content.keys
                writer.write("headers.append(\"Accept\", \"${mediaTypes.joinToString(",")}\")\n")
            }
        }
    }
)
