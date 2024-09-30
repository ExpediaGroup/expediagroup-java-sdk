package com.expediagroup.sdk.test.openapi

import com.expediagroup.sdk.product.ProgrammingLanguage

val NON_ALPHANUMERIC_REGEX = Regex("[^a-zA-Z0-9]")

/**
 * Class representing a test product with various properties generated based on the provided namespace and repository name.
 * The class supports different programming languages and formats properties accordingly.
 *
 * @property repoName The name of the repository.
 * @property programmingLanguage The programming language used, defaulted to JAVA.
 * @constructor Creates an instance of ProductTest with the specified parameters.
 * @param inputNamespace The input namespace for the test.
 * @param repoName The name of the repository.
 * @param programmingLanguage The programming language used, defaulted to "java".
 *
 * @property namespace The sanitized and lowercase representation of the input namespace.
 * @property artifactId The artifact ID generated based on the namespace.
 * @property apiPackage The API package path based on the namespace.
 * @property packagePath The package path where the test files are located.
 * @property packageName The package name for the test.
 * @property groupId The group ID for the project.
 */
class ProductTest(
    inputNamespace: String,
    val repoName: String,
    val programmingLanguage: ProgrammingLanguage = ProgrammingLanguage.JAVA
) {
    constructor(inputNamespace: String, repoName: String, programmingLanguage: String = "java") : this(
        inputNamespace,
        repoName,
        ProgrammingLanguage.from(programmingLanguage)
    )

    val namespace: String = inputNamespace.replace(NON_ALPHANUMERIC_REGEX, "").lowercase()

    val artifactId: String
        get() = "$namespace-sdk-test"

    val apiPackage: String
        get() = "com.expediagroup.sdk.$namespace.operations"

    val packagePath: String
        get() = "src/main/kotlin/com/expediagroup/sdk/$namespace/test"

    val packageName: String
        get() = "com.expediagroup.sdk.$namespace.test"

    val groupId: String
        get() = "com.expediagroup"
}
