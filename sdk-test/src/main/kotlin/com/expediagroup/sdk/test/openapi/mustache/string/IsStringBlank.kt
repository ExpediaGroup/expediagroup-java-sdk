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
package com.expediagroup.sdk.test.openapi.mustache.string

import com.samskivert.mustache.Mustache
import com.samskivert.mustache.Template
import java.io.Writer

val isStringBlank =
    object : Mustache.InvertibleLambda {
        override fun execute(
            fragment: Template.Fragment,
            writer: Writer
        ) {
            val string = fragment.context().toString()
            if (string.isBlank()) {
                fragment.execute(writer)
            }
        }

        override fun executeInverse(
            fragment: Template.Fragment,
            writer: Writer
        ) {
            val string = fragment.context().toString()
            if (string.isBlank().not()) {
                fragment.execute(writer)
            }
        }
    }
