package com.expediagroup.sdk.test.generator

val SPECMATIC_CONFIG =
    mapOf(
        "host" to "localhost",
        "port" to "8080",
        "SPECMATIC_GENERATIVE_TESTS" to "true",
        "MAX_TEST_REQUEST_COMBINATIONS" to "1"
    )

const val MAX_TEST_REQUEST_PER_SCENARIO: Int = 1000

const val JSON = "json"
