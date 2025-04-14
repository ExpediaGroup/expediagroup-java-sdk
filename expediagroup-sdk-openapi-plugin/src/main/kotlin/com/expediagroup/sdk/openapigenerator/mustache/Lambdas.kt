package com.expediagroup.sdk.openapigenerator.mustache

import com.samskivert.mustache.Mustache
import com.samskivert.mustache.Template
import org.openapitools.codegen.CodegenModel
import org.openapitools.codegen.CodegenOperation
import org.openapitools.codegen.CodegenProperty
import org.openapitools.codegen.CodegenResponse
import org.openapitools.codegen.model.ApiInfoMap
import org.slf4j.LoggerFactory
import java.io.Serializable
import java.io.Writer

private val LOGGER = LoggerFactory.getLogger(Mustache::class.java)

class RemoveLeadingSlashesLambda : Mustache.Lambda, Serializable {
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
        writer.write(fragment.execute().replace("^/+".toRegex(), "/"))
    }
}

class AssignDiscriminatorsLambda : Mustache.Lambda, Serializable {
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
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
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
        val discriminators: List<String> = getParentDiscriminator(fragment.context(1) as CodegenModel).map { it.originalName }
        val property = fragment.context() as CodegenProperty
        if (!discriminators.contains(property.baseName)) {
            writer.write(fragment.execute())
        }
    }
}

class DefineApiExceptionsLambda : Mustache.Lambda, Serializable {
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
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
}

class ExceptionDataTypesLambda : Mustache.Lambda, Serializable {
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
        val operation: CodegenOperation = fragment.context() as CodegenOperation
        val dataTypes: Set<String> = operation.responses.filter { !it.is2xx }.map { it.dataType }.toSet()
        val context = mapOf("dataTypes" to dataTypes)
        fragment.execute(context, writer)
    }
}

class HasNonBodyParamsLambda : Mustache.Lambda, Serializable {
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
        val operation = fragment.context() as CodegenOperation
        if (operation.hasPathParams || operation.hasHeaderParams || operation.hasQueryParams) {
            fragment.execute(writer)
        }
    }
}

class NonBodyParamsLambda : Mustache.Lambda, Serializable {
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
        val operation = fragment.context() as CodegenOperation
        val params = operation.pathParams + operation.headerParams + operation.queryParams
        val context = mapOf("params" to params)
        fragment.execute(context, writer)
    }
}

class RemoveDoubleQuotesLambda : Mustache.Lambda, Serializable {
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
        val data: String = fragment.context() as String
        writer.write("\"${data.replace(Regex("^\"+|\"$"), "")}\"")
    }
}

class HttpAcceptHeaderLambda : Mustache.Lambda, Serializable {
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
        val response: CodegenResponse = fragment.context() as CodegenResponse
        if (response.code == "200") {
            val mediaTypes: MutableSet<String> = response.content.keys
            val context = mapOf("mediaTypes" to mediaTypes.joinToString(","))
            fragment.execute(context, writer)
        }
    }
}

class CustomReturnTypeLambda : Mustache.Lambda, Serializable {
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
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

class ProcessOperation(
    private val processors: List<(CodegenOperation) -> CodegenOperation>
) : Mustache.Lambda, Serializable {
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
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
    override fun execute(
        fragment: Template.Fragment,
        writer: Writer
    ) {
        var model: CodegenModel = fragment.context() as CodegenModel

        processors.forEach { process ->
            LOGGER.info("Processing model ${model.name} using ${process::class.simpleName} processor")
            model = process(model)
        }

        fragment.execute(model, writer)
    }
}
