package com.expediagroup.sdk.test.contract.function

class ParamsBasedPathSanitizationFunc : (String, Map<String, Any>) -> String {
    companion object {
        val invoke = ParamsBasedPathSanitizationFunc()
    }

    override fun invoke(
        path: String,
        params: Map<String, Any>
    ): String =
        path.split("/").joinToString("/") { segment ->
            params.entries.find { it.value == segment }.let {
                when (it) {
                    null -> segment
                    else -> segment.replace(segment, "{${it.key}}")
                }
            }
        }
}
