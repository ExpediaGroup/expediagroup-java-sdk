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
package com.expediagroup.sdk.test.contract.model.api

import com.expediagroup.sdk.test.contract.JSON
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.specmatic.core.Scenario
import java.io.File

class TestCaseApiCall(
    @JsonProperty val request: TestCaseHttpRequest,
    @JsonProperty val response: TestCaseHttpResponse
) {
    companion object {
        fun from(scenario: Scenario): TestCaseApiCall =
            TestCaseApiCall(
                request =
                    TestCaseHttpRequest.from(
                        request = scenario.generateHttpRequest(),
                        scenario = scenario
                    ),
                response = TestCaseHttpResponse.from(response = scenario.generateHttpResponse(emptyMap()))
            )
    }

    override fun toString(): String {
        return jacksonObjectMapper().writeValueAsString(mapOf(
            "request" to mapOf(
                "body" to request.getRequestBody(),
                "params" to request.getParams(),
            ),
            "response" to response
        ))
    }

    fun filename(filenameSuffix: String? = "", filenamePrefix: String? = "") =
        "${filenamePrefix ?: ""}${request.method}-${request.path?.removePrefix("/")?.replace("/", "-")}${filenameSuffix ?: ""}.$JSON"

    fun writeTo(
        outputDir: File,
        mapper: ObjectMapper,
        filenameSuffix: String? = "",
        filenamePrefix: String? = ""
    ) {
        val filename = filename(filenameSuffix, filenamePrefix)
        mapper.writeValue(
            File(outputDir, filename),
            mapOf(
                "request" to request,
                "response" to response
            )
        )
    }
}
