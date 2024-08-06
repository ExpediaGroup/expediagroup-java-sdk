package com.expediagroup.sdk.test.contract.function

import io.specmatic.core.HttpRequest
import io.specmatic.core.Scenario

class ExtractPathParamsFunc : (Scenario, HttpRequest) -> Map<String, Any> {
    companion object {
        val invoke = ExtractPathParamsFunc()
        private val regex = """\(?([a-zA-Z0-9_-]+):(\w+)\)?""".toRegex()
    }

    override fun invoke(
        scenario: Scenario,
        request: HttpRequest
    ): Map<String, Any> =
        mutableMapOf<String, Any>().apply {
            val originalPath = scenario.path.split("/")
            val resolvedPath = request.path?.split("/") ?: emptyList()

            if (originalPath.size.equals(resolvedPath.size).not()) {
                return@apply
            }
//            omar/google/(company:string)
//            omar/google/aws
            originalPath.forEachIndexed { index, _ ->
                val originalPathSegment = originalPath[index]
                val resolvedPathSegment = resolvedPath[index]

                takeIf { originalPathSegment.matches(regex) }?.let {
                    regex.find(originalPathSegment)?.destructured?.component1()?.let {
                        put(it, resolvedPathSegment)
                    }
                }
            }
        }
}
