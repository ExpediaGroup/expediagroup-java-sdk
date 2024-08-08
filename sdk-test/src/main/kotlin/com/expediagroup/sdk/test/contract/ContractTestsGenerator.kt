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
package com.expediagroup.sdk.test.contract

import com.expediagroup.sdk.test.contract.extension.toSpecmaticFeature
import com.expediagroup.sdk.test.contract.model.api.TestCaseApiCall
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.rvesse.airline.SingleCommand
import io.specmatic.core.Feature
import io.specmatic.core.Scenario
import io.specmatic.test.SpecmaticContractTest
import java.io.File

class ContractTestsGenerator(
    private val spec: File,
    private val outputDir: File = File("output").absoluteFile,
    private val maxTestCombinations: Int = MAX_TEST_REQUEST_PER_SCENARIO
) : SpecmaticContractTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val generator = SingleCommand.singleCommand(ContractTestsGenerator::class.java).parse(*args)
            generator.generate()
        }

        private val mapper: ObjectMapper = ObjectMapper()
    }

    private lateinit var feature: Feature

    private fun validateArgs() {
        spec.takeUnless { it.exists() }?.let {
            throw IllegalArgumentException("Invalid input spec file")
        }
    }

    private fun configure() {
        SPECMATIC_CONFIG.forEach { (key, value) -> System.setProperty(key, value) }
        System.setProperty("contractPaths", spec.absolutePath)

        feature = spec.toSpecmaticFeature()

        outputDir.mkdirs()
    }

    fun generate(writeMode: Boolean = true): List<TestCaseApiCall> {
        validateArgs()
        configure()
        val testCases: MutableList<TestCaseApiCall> = mutableListOf()

        feature.scenarios.forEach { scenario: Scenario ->
            scenario.generateTestScenarios(feature.flagsBased).iterator().apply {
                IntRange(0, maxTestCombinations).forEach { counter: Int ->
                    if (hasNext().not()) {
                        return@forEach
                    }

                    next().ifValue { scenario ->
                        TestCaseApiCall.from(scenario).also { testCase ->
                            takeIf { writeMode }?.let {
                                testCase.writeTo(
                                    outputDir = outputDir,
                                    mapper = mapper,
                                    filenameSuffix = "-$counter"
                                )
                            } ?: run {
                                testCases.add(testCase)
                            }
                        }
                    }
                }
            }
        }
        return testCases
    }
}
