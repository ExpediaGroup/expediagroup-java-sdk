package com.expediagroup.sdk.test.generator

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.rvesse.airline.SingleCommand
import com.github.rvesse.airline.annotations.Command
import com.github.rvesse.airline.annotations.Option
import io.specmatic.core.Feature
import io.specmatic.core.Scenario
import io.specmatic.test.SpecmaticContractTest
import java.io.File

@Command(name = "generate")
class ContractTestsGenerator : SpecmaticContractTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val generator = SingleCommand.singleCommand(ContractTestsGenerator::class.java).parse(*args)
            generator.run()
        }

        private val mapper: ObjectMapper = ObjectMapper()
    }

    @Option(name = ["-i", "--input-spec"])
    lateinit var spec: File

    @Option(name = ["-o", "--output-dir"])
    var outputDir: File = File("output").absoluteFile

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

    fun run() {
        validateArgs()
        configure()
        feature.scenarios.forEach { scenario: Scenario ->
            scenario.generateTestScenarios(feature.flagsBased).iterator().apply {
                IntRange(0, MAX_TEST_REQUEST_PER_SCENARIO).forEach { counter: Int ->
                    if (!hasNext()) {
                        return@forEach
                    }
                    next().ifValue { scenario ->
                        scenario.writeTo(
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
