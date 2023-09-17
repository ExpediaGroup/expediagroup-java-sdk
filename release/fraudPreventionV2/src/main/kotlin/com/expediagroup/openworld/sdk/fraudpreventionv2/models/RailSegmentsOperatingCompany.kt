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

package com.expediagroup.openworld.sdk.fraudpreventionv2.models

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
import jakarta.validation.Valid
import org.hibernate.validator.constraints.Length

/**
 * This attribute captures the name or identifier of the company responsible for operating the Rail product. It represents the specific operating entity, such as Amtrak, British Railways, or a bus company.
 * @param marketingName The name used by the transportation carrier for marketing purposes in the travel segment. Example: ARX, AMTRAC, ARRIVA
 */
data class RailSegmentsOperatingCompany(
    /* The name used by the transportation carrier for marketing purposes in the travel segment. Example: ARX, AMTRAC, ARRIVA */
    @JsonProperty("marketing_name")
    @field:Length(max = 200)
    @field:Valid
    val marketingName: kotlin.String? = null
) {

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var marketingName: kotlin.String? = null
    ) {
        fun marketingName(marketingName: kotlin.String) = apply { this.marketingName = marketingName }

        fun build(): RailSegmentsOperatingCompany {
            return RailSegmentsOperatingCompany(
                marketingName = marketingName
            )
        }
    }
}
