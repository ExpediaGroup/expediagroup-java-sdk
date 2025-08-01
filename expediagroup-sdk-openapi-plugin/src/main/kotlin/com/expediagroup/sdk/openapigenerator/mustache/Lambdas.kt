/*
 * Copyright (C) 2025 Expedia, Inc.
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

package com.expediagroup.sdk.openapigenerator.mustache

import com.samskivert.mustache.Mustache
import com.samskivert.mustache.Template
import org.openapitools.codegen.CodegenModel
import org.openapitools.codegen.CodegenOperation
import org.openapitools.codegen.CodegenProperty
import org.openapitools.codegen.CodegenResponse
import org.slf4j.LoggerFactory
import java.io.Serializable
import java.io.Writer

private val LOGGER = LoggerFactory.getLogger(Mustache::class.java)

class AssignDiscriminatorsLambda : Mustache.Lambda, Serializable {
    override fun execute(fragment: Template.Fragment, writer: Writer) {
        val model = fragment.context() as CodegenModel
        getParentDiscriminator(model).forEach {
            val type: String = (if (it.isEnum) "${it.parentName}." else "") + it.type
            val value: String = if (it.isString && !it.isEnum) "\"${it.value}\"" else "$type.${it.value}"
            writer.write("@JsonProperty(\"${it.originalName}\")\n")
            writer.write("override val ${it.name} : $type = $value\n")
        }
    }
}

class EliminateDiscriminatorsLambda : Mustache.Lambda, Serializable {
    override fun execute(fragment: Template.Fragment, writer: Writer) {
        val discriminators: List<String> = getParentDiscriminator(fragment.context(1) as CodegenModel).map {
            it.originalName
        }
        val property = fragment.context() as CodegenProperty
        if (!discriminators.contains(property.baseName)) {
            writer.write(fragment.execute())
        }
    }
}

class OperationErrorTypesLambda : Mustache.Lambda, Serializable {
    override fun execute(fragment: Template.Fragment, writer: Writer) {
        val operation = fragment.context() as CodegenOperation
        val seen = linkedSetOf<String>()

        operation.responses.filter { !it.is2xx && it.dataType != null }.forEach { seen += it.dataType }

        seen.forEach { schema ->
            fragment.execute(mapOf("dataType" to schema), writer)
        }
    }
}

class OperationExceptionsLambda : Mustache.Lambda, Serializable {
    override fun execute(fragment: Template.Fragment, writer: Writer) {
        val operation: CodegenOperation = fragment.context() as CodegenOperation

        operation.responses.filter { !it.is2xx }.map {
            Triple(it.dataType ?: "String", it.code, "${operation.baseName}${it.code}Exception")
        }.forEach {
            fragment.execute(
                mapOf(
                    "errorModel" to it.first,
                    "statusCode" to it.second,
                    "exceptionClassName" to it.third
                ),
                writer
            )
        }
    }
}

class HasNonBodyParamsLambda : Mustache.Lambda, Serializable {
    override fun execute(fragment: Template.Fragment, writer: Writer) {
        val operation = fragment.context() as CodegenOperation
        if (operation.hasPathParams || operation.hasHeaderParams || operation.hasQueryParams) {
            fragment.execute(writer)
        }
    }
}

class NonBodyParamsLambda : Mustache.Lambda, Serializable {
    override fun execute(fragment: Template.Fragment, writer: Writer) {
        val operation = fragment.context() as CodegenOperation
        val params = operation.pathParams + operation.headerParams + operation.queryParams
        val context = mapOf("params" to params)
        fragment.execute(context, writer)
    }
}

class HttpAcceptHeaderLambda : Mustache.Lambda, Serializable {
    override fun execute(fragment: Template.Fragment, writer: Writer) {
        val response: CodegenResponse = fragment.context() as CodegenResponse
        if (response.code == "200") {
            val mediaTypes: MutableSet<String> = response.content.keys
            val context = mapOf("mediaTypes" to mediaTypes.joinToString(","))
            fragment.execute(context, writer)
        }
    }
}

class CustomReturnTypeLambda : Mustache.Lambda, Serializable {
    override fun execute(fragment: Template.Fragment, writer: Writer) {
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
            return
        }
        fragment.execute(context, writer)
    }
}

class RemoveDoubleQuotesLambda : Mustache.Lambda, Serializable {
    override fun execute(fragment: Template.Fragment, writer: Writer) {
        val data: String = fragment.context() as String
        writer.write("\"${data.replace(Regex("^\"+|\"$"), "")}\"")
    }
}

class ProcessOperation(
    private val processors: List<(CodegenOperation) -> CodegenOperation>
) : Mustache.Lambda, Serializable {
    override fun execute(fragment: Template.Fragment, writer: Writer) {
        var operation: CodegenOperation = fragment.context() as CodegenOperation

        processors.forEach { process ->
            LOGGER.info("Processing operation ${operation.operationId} using ${process::class.simpleName} processor")
            operation = process(operation)
        }

        fragment.execute(operation, writer)
    }
}

class ProcessModel(
    private val processors: List<(CodegenModel) -> CodegenModel>
) : Mustache.Lambda, Serializable {
    override fun execute(fragment: Template.Fragment, writer: Writer) {
        var model: CodegenModel = fragment.context() as CodegenModel

        processors.forEach { process ->
            LOGGER.info("Processing model ${model.name} using ${process::class.simpleName} processor")
            model = process(model)
        }

        fragment.execute(model, writer)
    }
}
