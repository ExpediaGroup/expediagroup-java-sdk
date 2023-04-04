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
