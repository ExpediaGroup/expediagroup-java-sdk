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
    private lateinit var outputDir: String

    @Option(name = ["-m", "--max-test-combinations"])
    private var maxTestCombinations: Int = MAX_TEST_REQUEST_PER_SCENARIO

    @Option(name = ["-c", "--contract-tests-only"])
    private var generateContractTestsOnly = false

    @Option(name = ["-s", "--sdk-tests"])
    private var generateSdkTests = false

    private lateinit var sdkTestGenerator: SdkTestGenerator

    private lateinit var contractTestsGenerator: ContractTestsGenerator

    fun run() {
        if (listOf(generateSdkTests, generateContractTestsOnly).all { it == false }) {
            throw IllegalArgumentException("At least one of --contract-tests-only or --sdk-tests must be set to true")
        }

        contractTestsGenerator =
            ContractTestsGenerator(
                spec = spec,
                outputDir = File(outputDir),
                maxTestCombinations = maxTestCombinations
            )

        contractTestsGenerator.generate(writeMode = generateSdkTests).also { testCases ->
            if (generateSdkTests) {
                sdkTestGenerator =
                    SdkTestGenerator(
                        namespace = namespace,
                        spec = spec,
                        version = version,
                        testCases = testCases
                    )
                sdkTestGenerator.generate()
            }
        }
    }
}
