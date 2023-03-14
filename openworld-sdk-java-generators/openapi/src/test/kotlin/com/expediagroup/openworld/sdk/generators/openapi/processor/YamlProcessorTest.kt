package com.expediagroup.openworld.sdk.generators.openapi.processor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.File

class YamlProcessorTest {
    @ParameterizedTest
    @ValueSource(strings = ["tags", "unwanted_headers", "unwanted_headers_with_tags", "unwanted_headers_referenced"])
    internal fun `process spec as expected`(specName: String) {
        val tag = "SomeTag"
        val path = getResourcePath("${specName}_spec.yaml")

        val yamlProcessor = YamlProcessor(path, tag)
        val processed = yamlProcessor.process()

        assertContentEqual(getResourcePath("${specName}_processed_spec.yaml"), processed)
    }

    private fun assertContentEqual(expectedFilePath: String, actualFilePath: String) {
        val expectedContent = File(expectedFilePath).readText()
        val actualContent = File(actualFilePath).readText()

        assertThat(actualContent).isEqualTo(expectedContent)
    }

    private fun getResourcePath(resourceName: String) = "src/test/resources/specs/$resourceName"
}
