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
/* You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.sdk.test

import com.expediagroup.sdk.test.contract.ContractTestsGenerator
import com.expediagroup.sdk.test.contract.MAX_TEST_REQUEST_PER_SCENARIO
import com.expediagroup.sdk.test.openapi.SdkTestGenerator
import com.expediagroup.sdk.test.util.toBoolean
import com.github.rvesse.airline.SingleCommand
import com.github.rvesse.airline.annotations.Command
import com.github.rvesse.airline.annotations.Option
import java.io.File

@Command(name = "cli", description = "Command Line Interface for SDK Test")
class CLI {
    @Option(name = ["-n", "--namespace"])
    private lateinit var namespace: String

    @Option(name = ["-v", "--version"])
    private lateinit var version: String

    @Option(name = ["-i", "--input-spec"])
    private lateinit var spec: File

    @Option(name = ["-o", "--output-dir"])
    private var outputDir: String = "target/sdk/src/main/resources"

    @Option(name = ["-m", "--max-test-combinations"])
    private var maxTestCombinations: Int = MAX_TEST_REQUEST_PER_SCENARIO

    @Option(name = ["-c", "--generate-contract-tests"])
    private var generateContractTests = false

    @Option(name = ["-s", "--generate-sdk-tests"])
    private var generateSdkTests = false

    @Option(name = ["-t", "--templates-dir"])
    private var templatesDir: File = File("src/main/resources/templates/expediagroup-sdk")

    private lateinit var sdkTestGenerator: SdkTestGenerator

    private lateinit var contractTestsGenerator: ContractTestsGenerator

    companion object {
        /**
         * Main Entry Point
         *
         * Parses command line arguments and then generates an EG Travel SDK
         */
        @JvmStatic
        fun main(args: Array<String>) {


            val generator = SingleCommand.singleCommand(CLI::class.java).parse(*args)
            generator.run()
        }
    }

    fun run() {
        if (!listOf(generateSdkTests, generateContractTests).any(::toBoolean)) {
            throw IllegalArgumentException("At least one of --generate-contract-tests or --generate-sdk-tests must be set to true")
        }

        contractTestsGenerator = ContractTestsGenerator(
            spec = spec,
            outputDir = File(outputDir),
            maxTestCombinations = maxTestCombinations
        )

        contractTestsGenerator.generate(writeMode = generateContractTests).let { testCases ->
            if (!generateSdkTests) {
                return
            }

            sdkTestGenerator = SdkTestGenerator(
                namespace = namespace,
                spec = spec,
                version = version,
                testCases = testCases,
                templatesDir = templatesDir,
            ).also { it.generate() }
        }
    }
}
