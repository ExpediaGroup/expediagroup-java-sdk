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

import com.expediagroup.sdk.test.contract.function.ExtractPathParamsFunc
import com.expediagroup.sdk.test.contract.function.ParamsBasedPathSanitizationFunc
import com.fasterxml.jackson.annotation.JsonProperty
import io.specmatic.core.HttpRequest
import io.specmatic.core.Scenario

class TestCaseHttpRequest(
    @JsonProperty val method: String? = "",
    @JsonProperty val path: String? = "",
    @JsonProperty val headers: Map<String, String>? = emptyMap(),
    @JsonProperty val body: String? = "",
    @JsonProperty val pathParams: Map<String, Any>? = emptyMap(),
    @JsonProperty val queryParams: Map<String, Any>? = emptyMap(),
    @JsonProperty val formFields: Map<String, String>? = emptyMap(),
    @JsonProperty val multiPartFormData: Map<String, String>? = emptyMap()
) {
    companion object {
        private val ignoreHeaders =
            listOf(
                "Authorization",
                "Content-Length",
                "Content-Type",
                "Accept",
                "Accept-Encoding"
            )

        fun from(
            request: HttpRequest,
            scenario: Scenario
        ): TestCaseHttpRequest {
            takeIf { listOf(request.path, request.method, request.headers, request.bodyString).any { it == null } }?.let {
                throw IllegalArgumentException("Request is missing required fields:\n $request")
            }

            val pathParams = ExtractPathParamsFunc.invoke(scenario, request)
            return TestCaseHttpRequest(
                method = request.method,
                path = ParamsBasedPathSanitizationFunc.invoke(request.path!!, pathParams),
                headers = request.headers.filterKeys { ignoreHeaders.contains(it).not() },
                body = request.bodyString,
                queryParams = request.queryParams.asMap()
            )
        }
    }
}