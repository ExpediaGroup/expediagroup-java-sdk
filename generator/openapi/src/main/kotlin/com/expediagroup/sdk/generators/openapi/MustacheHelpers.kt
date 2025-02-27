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
import org.openapitools.codegen.CodegenOperation
import org.openapitools.codegen.CodegenProperty
import org.openapitools.codegen.CodegenResponse
import org.openapitools.codegen.model.ApiInfoMap

val mustacheHelpers =
    mapOf(
        "isPaginatable" to {
            Mustache.Lambda { fragment, writer ->
                val operation = fragment.context() as CodegenOperation
                if (operation.returnType == null) return@Lambda
                val paginationHeaders = listOf("Pagination-Total-Results", "Link")
                val availableHeaders = operation.responses.find { it.code == "200" }?.headers?.filter { it.baseName in paginationHeaders }
                if (availableHeaders?.size == paginationHeaders.size) {
                    val fallbackBody =
                        when {
                            operation.returnType.startsWith("kotlin.collections.List") -> "emptyList()"
                            operation.returnType.startsWith("kotlin.collections.Map") -> "emptyMap()"
                            operation.returnType.startsWith("kotlin.collections.Set") -> "emptySet()"
                            else -> ""
                        }

                    val context = mapOf("fallbackBody" to fallbackBody)
                    fragment.execute(context, writer)
                }
            }
        },
        "removeLeadingSlashes" to {
            Mustache.Lambda { fragment, writer -> writer.write(fragment.execute().replace("^/+".toRegex(), "/")) }
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
                val apisMap: ApiInfoMap = fragment.context() as ApiInfoMap
                apisMap.apis.forEach { operationsMap ->
                    operationsMap.operations.operation.forEach { operation ->
                        operation.responses.forEach { response ->
                            response.takeIf { !it.is2xx && !dataTypes.contains(it.dataType) }?.dataType?.also {
                                dataTypes.add(it)
                            }
                        }
                    }
                }

                dataTypes.forEach { dataType ->
                    val context = mapOf("dataType" to dataType)
                    fragment.execute(context, writer)
                }
            }
        },
        "exceptionDataTypes" to {
            Mustache.Lambda { fragment, writer ->
                val operation: CodegenOperation = fragment.context() as CodegenOperation
                val dataTypes: Set<String> = operation.responses.filter { !it.is2xx }.map { it.dataType }.toSet()
                val context = mapOf("dataTypes" to dataTypes)
                fragment.execute(context, writer)
            }
        },
        "hasNonBodyParams" to {
            Mustache.Lambda { fragment, writer ->
                val operation = fragment.context() as CodegenOperation
                if (operation.hasPathParams || operation.hasHeaderParams || operation.hasQueryParams) {
                    fragment.execute(writer)
                }
            }
        },
        "nonBodyParams" to {
            Mustache.Lambda { fragment, writer ->
                val operation = fragment.context() as CodegenOperation
                val params = operation.pathParams + operation.headerParams + operation.queryParams
                val context = mapOf("params" to params)
                fragment.execute(context, writer)
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
                    val context = mapOf("mediaTypes" to mediaTypes.joinToString(","))
                    fragment.execute(context, writer)
                }
            }
        },
        "customReturnType" to {
            Mustache.Lambda { fragment, writer ->
                val response: CodegenOperation = fragment.context() as CodegenOperation

                val context =
                    mapOf(
                        "returnType" to
                            when (response.returnType) {
                                "java.io.File" -> "java.io.InputStream"
                                else -> response.returnType
                            }
                    )

                if (context["returnType"] == null) {
                    return@Lambda
                }

                fragment.execute(context, writer)
            }
        }
    )
