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

package com.expediagroup.sdk.fraudpreventionv2.models

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
 * The current user session prior to this transaction, which contains details related to any challenge initiated by the Partner''s system to a user before calling Expedia''s Fraud Prevention Service. An example is if the Partner''s system sent a Captcha challenge to the user before calling Expedia''s Fraud Prevention Service.
 * @param sessionId Unique identifier for a user's session on their device
 * @param startDateTime The local date and time a user's session started, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
 * @param challengeDetail
 */
data class CurrentUserSession(
    // Unique identifier for a user's session on their device
    @JsonProperty("session_id")
    @field:Length(max = 200)
    @field:Valid
    val sessionId: kotlin.String? = null,
    // The local date and time a user's session started, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`.
    @JsonProperty("start_date_time")
    val startDateTime: java.time.OffsetDateTime? = null,
    @JsonProperty("challenge_detail")
    @field:Valid
    val challengeDetail: ChallengeDetail? = null
) {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var sessionId: kotlin.String? = null,
        private var startDateTime: java.time.OffsetDateTime? = null,
        private var challengeDetail: ChallengeDetail? = null
    ) {
        fun sessionId(sessionId: kotlin.String) = apply { this.sessionId = sessionId }

        fun startDateTime(startDateTime: java.time.OffsetDateTime) = apply { this.startDateTime = startDateTime }

        fun challengeDetail(challengeDetail: ChallengeDetail) = apply { this.challengeDetail = challengeDetail }

        fun build(): CurrentUserSession {
            return CurrentUserSession(
                sessionId = sessionId,
                startDateTime = startDateTime,
                challengeDetail = challengeDetail
            )
        }
    }
}
