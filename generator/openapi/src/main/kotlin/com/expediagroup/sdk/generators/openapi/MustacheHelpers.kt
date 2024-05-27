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
import com.samskivert.mustache.Template
import org.openapitools.codegen.CodegenModel
import org.openapitools.codegen.CodegenOperation
import org.openapitools.codegen.CodegenProperty
import org.openapitools.codegen.model.ApiInfoMap
import java.io.Writer

val fallbackBody = fun(dataType: String): String {
    return if (dataType.startsWith("kotlin.collections.List")) {
        "emptyList()"
    } else if (dataType.startsWith("kotlin.collections.Map")) {
        "emptyMap()"
    } else if (dataType.startsWith("kotlin.collections.Set")) {
        "emptySet()"
    } else {
        ""
    }
}

val mustacheHelpers = mapOf(
    "paginator" to {
        Mustache.Lambda { fragment, writer ->
            val operation = fragment.context() as CodegenOperation
            val paginationHeaders = listOf("Pagination-Total-Results", "Link")
            val availableHeaders = operation.responses.find { it.code == "200" }?.headers?.filter { it.baseName in paginationHeaders }
            if (availableHeaders?.size == paginationHeaders.size) {
                writer.write("@JvmOverloads")
                writer.write(System.lineSeparator())
                writer.write("fun getPaginator(operation: ${operation.operationIdCamelCase}Operation): ResponsePaginator<${operation.returnType}> {")
                writer.write(System.lineSeparator())
                writer.write("val response = execute(operation)")
                writer.write(System.lineSeparator())
                writer.write("return ResponsePaginator(this, response, ")
                writer.write(fallbackBody("${operation.returnType}"))
                writer.write(") { it.body<${operation.returnType}>() }")
                writer.write(System.lineSeparator())
                writer.write("}")
            }
        }
    },
    "removeLeadingSlash" to {
        Mustache.Lambda { fragment, writer -> writer.write(fragment.execute().replace("^/+".toRegex(), "")) }
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
                writer.write(
                    "class ExpediaGroupApi${dataType}Exception(code: Int, override val errorObject: $dataType, transactionId: String?) : " +
                        "ExpediaGroupApiException(code, errorObject, transactionId)\n"
                )
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
            dataTypes.forEachIndexed { index, dataType ->
                if (index > 0) stringBuilder.append(" ".repeat(8))
                stringBuilder.append("ExpediaGroupApi${dataType}Exception::class")
                if (index < dataTypes.size - 1) stringBuilder.append(",\n")
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
    }
)
