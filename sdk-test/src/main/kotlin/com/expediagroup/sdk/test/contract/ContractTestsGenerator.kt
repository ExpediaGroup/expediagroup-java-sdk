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
import org.slf4j.LoggerFactory
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
        private val logger = LoggerFactory.getLogger(ContractTestsGenerator::class.java)
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

        logger.info(LogMessages.ARGS_VALIDATED_SUCCESSFULLY)
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
        logger.info(LogMessagesTemplates.SET_SYSTEM_PROPERTY.format("contractPaths", spec.absolutePath))

        // TODO: Log SpecmaticConfig attributes from feature.specmaticConfig
        feature = spec.toSpecmaticFeature()
        logger.info(LogMessagesTemplates.SPEC_LOADED.format(spec.absolutePath))

        outputDir.mkdirs()
        logger.info(LogMessagesTemplates.CREATED_DIRECTORY.format(outputDir.absolutePath))
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

    fun generate(writeMode: Boolean = true) {
        preGenerate()

        feature.scenarios.forEach { scenario: Scenario ->
            scenario.generateTestScenarios(feature.flagsBased).iterator().apply {
                 IntRange(1, maxTestCombinations).forEach CombinationsLimit@ { counter: Int ->
                    if (hasNext().not()) {
                        return@CombinationsLimit
                    }

                    next().ifValue { scenario ->
                        TestCaseApiCall.from(scenario).also { testCase ->
                            takeIf { writeMode }?.let {
                                logger.info(LogMessagesTemplates.GENERATED_TEST_CASE_FOR_STATUS_AND_OPERATION.format(testCase.response.status, "${testCase.request.method} ${testCase.request.path}"))
                                testCase.writeTo(
                                    outputDir = outputDir,
                                    mapper = mapper,
                                    filenameSuffix = "-$counter"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
