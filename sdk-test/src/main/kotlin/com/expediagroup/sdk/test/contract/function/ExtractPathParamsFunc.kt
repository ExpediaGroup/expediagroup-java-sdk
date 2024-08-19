package com.expediagroup.sdk.test.contract.function


import io.specmatic.core.HttpRequest
import io.specmatic.core.Scenario

/**
 * ExtractPathParamsFunc is a function type that extracts path parameters from an HTTP request
 * based on the path defined in a scenario. It takes a Scenario object and an HttpRequest
 * object as parameters and returns a map containing the extracted parameters.
 *
 * The companion object contains a regex pattern for identifying path parameters and a static
 * instance of ExtractPathParamsFunc.
 *
 * The invoke function overrides the function type operator to perform the extraction. It splits
 * the scenario path and request path into segments and compares them. If a segment in the
 * scenario path matches the regex pattern, the corresponding segment in the request path is
 * extracted and stored in the resulting map.
 *
 * This implementation is useful for mapping dynamic URL segments to variables that can be
 * utilized further in the HTTP request processing.
 */
class ExtractPathParamsFunc : (Scenario, HttpRequest) -> Map<String, Any> {
    companion object {
        val invoke = ExtractPathParamsFunc()
        /**
         * Regex pattern used to identify path parameters in the scenario path.
         * The pattern matches a segment of the format (paramName:type) and captures
         * the parameter name and the type separately.
         */
        private val regex = """\(?([a-zA-Z0-9_-]+):(\w+)\)?""".toRegex()
    }

    /**
     * Invokes the function to extract path parameters from an HTTP request based on the path
     * defined in a scenario. It splits the scenario path and request path into segments and
     * compares them. If a segment in the scenario path matches the regex pattern, the
     * corresponding segment in the request path is extracted and stored in the resulting map.
     *
     * @param scenario The Scenario object containing the defined path.
     * @param request The HttpRequest object for which the parameters need to be extracted.
     * @return A map containing the extracted path parameters.
     *
     * Example:
     * ```
     * val scenario = Scenario("GET", "/users/(userId:id)/orders/(orderId:id)")
     * val request = HttpRequest("GET", "/users/123/orders/456")
     * val result = ExtractPathParamsFunc.invoke(scenario, request)
     * println(result) // Output: {userId=123, orderId=456}
     * ```
     *
     * Example:
     * ```
     * val scenario = Scenario("GET", "/books/(bookId:id)/(chapter:chapterId)")
     * val request = HttpRequest("GET", "/books/789/1")
     * val result = ExtractPathParamsFunc.invoke(scenario, request)
     * println(result) // Output: {bookId=789, chapter=1}
     * ```
     */
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
