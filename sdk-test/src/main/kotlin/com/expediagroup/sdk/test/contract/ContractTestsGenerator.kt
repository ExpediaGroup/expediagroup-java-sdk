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
import com.expediagroup.sdk.test.util.toBoolean
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.rvesse.airline.SingleCommand
import io.specmatic.core.Feature
import io.specmatic.core.Scenario
import io.specmatic.test.SpecmaticContractTest
import java.io.File

/**
* ContractTestsGenerator is responsible for generating contract tests
* from a given specification file. It validates the arguments,
* configures the test environment, and generates test cases.
*
* @property spec The contract specification file to generate the tests from.
* @property outputDir The directory where the generated test files will be saved.
* @property maxTestCombinations The maximum number of test combinations to generate per scenario.
*
* Constructor initializes the generator with the provided specification file,
* output directory, and maximum test combinations per scenario.
*/
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

    /**
    * Function to validate the given arguments to ensure correctness before proceeding.
    * Checks whether the specification file exists, and if not, throws an IllegalArgumentException.
    */
    private fun validateArgs() {
        spec.takeUnless(::toBoolean)?.let {
            throw IllegalArgumentException("Invalid input spec file")
        }
    }

    /**
    * Function to configure the test generation environment.
    * Sets system properties based on the SPECMATIC_CONFIG values.
    * Sets the absolute path of the contract specification file.
    * Converts the specification file to a Specmatic feature.
    * Creates necessary directories in the output directory.
    */
    private fun configure() {
        SPECMATIC_CONFIG.forEach { (key, value) -> System.setProperty(key, value) }
        System.setProperty("contractPaths", spec.absolutePath)

        feature = spec.toSpecmaticFeature()

        outputDir.mkdirs()
    }

    /**
    * Pre-generates the necessary components and configurations.
    * It performs validation of the provided arguments and sets up
    * the test generation environment by configuring system properties
    * and preparing the output directory.
    */
    private fun preGenerate() {
        validateArgs()
        configure()
    }

    fun generate(writeMode: Boolean = true): List<TestCaseApiCall> {
        preGenerate()

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
