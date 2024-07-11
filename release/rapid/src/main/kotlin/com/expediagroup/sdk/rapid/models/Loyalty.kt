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

package com.expediagroup.sdk.rapid.models

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

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.Valid

/**
 * A loyalty object for a loyalty program.
 * @param memberId The identifier for the individual associated with a loyalty program.
 * @param programId The identifier for the loyalty program.
 */
data class Loyalty(
    // The identifier for the individual associated with a loyalty program.
    @JsonProperty("member_id")
    @field:Valid
    val memberId: kotlin.String? = null,
    // The identifier for the loyalty program.
    @JsonProperty("program_id")
    @field:Valid
    val programId: kotlin.String? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var memberId: kotlin.String? = null,
        private var programId: kotlin.String? = null
    ) {
        fun memberId(memberId: kotlin.String?) = apply { this.memberId = memberId }

        fun programId(programId: kotlin.String?) = apply { this.programId = programId }

        fun build(): Loyalty {
            return Loyalty(
                memberId = memberId,
                programId = programId
            )
        }
    }
}
