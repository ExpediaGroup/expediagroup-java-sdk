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
package com.expediagroup.sdk.test.openapi

import com.expediagroup.sdk.generators.openapi.pascalCase
import com.expediagroup.sdk.product.Product
import com.expediagroup.sdk.product.ProductFamily
import com.expediagroup.sdk.product.ProgrammingLanguage
import com.expediagroup.sdk.test.contract.model.api.TestCaseApiCall
import com.expediagroup.sdk.test.openapi.mustache.helpers
import com.samskivert.mustache.Mustache
import org.openapitools.codegen.CodegenConstants
import org.openapitools.codegen.DefaultGenerator
import org.openapitools.codegen.SupportingFile
import org.openapitools.codegen.config.CodegenConfigurator
import org.openapitools.codegen.languages.KotlinClientCodegen
import org.openapitools.codegen.templating.MustacheEngineAdapter
import org.slf4j.LoggerFactory
import java.io.File

class SdkTestGenerator(
    private val namespace: String,
    private val spec: File,
    private val version: String = "1.0.0",
    private val testCases: List<TestCaseApiCall> = emptyList(),
    outputDir: File = File("target/sdk")
) {
    val product = Product(namespace, "rapid-java", "kotlin")

    val supportingFiles = mutableListOf(
        "${namespace.pascalCase()}ClientExecutor.kt",
        "${namespace.pascalCase()}OperationsMetadata.kt",
        "${namespace.pascalCase()}TestCases.kt",
        "Main.kt",
        "pom.xml",
    )

    val config =
        CodegenConfigurator().apply {
            setGeneratorName("kotlin")
            setTemplateDir("templates/expediagroup-sdk")
            setInputSpec(spec.absolutePath)
            setOutputDir(outputDir.absolutePath)
            setArtifactId(product.artifactId)
            setArtifactVersion(version)
            setGroupId(product.groupId)
            setPackageName(product.packageName)

            addGlobalProperty(CodegenConstants.APIS, "")
            addGlobalProperty(CodegenConstants.API_DOCS, "false")
            addGlobalProperty(CodegenConstants.MODELS, "false")
            addGlobalProperty(CodegenConstants.MODEL_DOCS, "false")
            addGlobalProperty(CodegenConstants.GENERATE_MODELS, "false")

            mutableMapOf<String, MutableList<TestCaseApiCall>>().withDefault { mutableListOf() }.apply {
                testCases.forEach {
                    putIfAbsent("${it.request.method} ${it.request.path}", mutableListOf())
                    this["${it.request.method} ${it.request.path}"]!!.add(it)
                }
                addAdditionalProperty("tests", entries)
            }


            addGlobalProperty(CodegenConstants.SUPPORTING_FILES, supportingFiles.joinToString(","))

            addAdditionalProperty(CodegenConstants.API_PACKAGE, product.apiPackage)
            addAdditionalProperty("clientClassname", "${namespace.pascalCase()}Client")
            addAdditionalProperty(CodegenConstants.ENUM_PROPERTY_NAMING, "UPPERCASE")
            addAdditionalProperty(CodegenConstants.LIBRARY, "jvm-ktor")
            addAdditionalProperty(CodegenConstants.SERIALIZATION_LIBRARY, "jackson")
            addAdditionalProperty(CodegenConstants.SORT_PARAMS_BY_REQUIRED_FLAG, true)

            // Template specific properties
            addAdditionalProperty("shadePrefix", product.shadePrefix)
            addAdditionalProperty("namespace", product.namespace)
            addAdditionalProperty("language", product.programmingLanguage.id)
            addAdditionalProperty("isKotlin", ProgrammingLanguage.isKotlin(product.programmingLanguage))
            addAdditionalProperty("isRapid", ProductFamily.isRapid(product.namespace))
            addAdditionalProperty("isExpediaGroup", ProductFamily.isExpediaGroup(product.namespace))

            // Mustache Helpers
            helpers.forEach { (name, func) ->
                addAdditionalProperty(name, func)
            }


        }

    private val packagePath = "${product.packagePath}/test"
    val clientOptInput = config.toClientOptInput().apply {


        userDefinedTemplates(buildList {
            add(SupportingFile(
                "main.mustache",
                packagePath,
                "Main.kt"
            ))
            add(SupportingFile(
                "executor.mustache",
                packagePath,
                "${namespace.pascalCase()}ClientExecutor.kt"
            ))
            add(SupportingFile(
                "metadata.mustache",
                packagePath,
                "${namespace.pascalCase()}OperationsMetadata.kt"
            ))
            add(SupportingFile(
                "testcases.mustache",
                packagePath,
                "${namespace.pascalCase()}TestCases.kt"
            ))
            add(SupportingFile(
                "pom.mustache",
                "pom.xml"
            ))
        })
    }

    private val generator = DefaultGenerator(false).opts(clientOptInput)

    fun generate() {
        generator.generate()
    }
}
