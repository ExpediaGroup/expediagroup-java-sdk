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
 * A map of links, including links to retrieve a booking, resume a held booking, or cancel a held booking.
 * @param retrieve
 * @param resume
 * @param cancel
 */
data class CompletePaymentSessionLinks(
    @JsonProperty("retrieve")
    @field:Valid
    val retrieve: Link? = null,
    @JsonProperty("resume")
    @field:Valid
    val resume: Link? = null,
    @JsonProperty("cancel")
    @field:Valid
    val cancel: Link? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var retrieve: Link? = null,
        private var resume: Link? = null,
        private var cancel: Link? = null
    ) {
        fun retrieve(retrieve: Link?) = apply { this.retrieve = retrieve }

        fun resume(resume: Link?) = apply { this.resume = resume }

        fun cancel(cancel: Link?) = apply { this.cancel = cancel }

        fun build(): CompletePaymentSessionLinks {
            return CompletePaymentSessionLinks(
                retrieve = retrieve,
                resume = resume,
                cancel = cancel
            )
        }
    }
}
