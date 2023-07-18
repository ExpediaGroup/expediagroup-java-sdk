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

import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Activity
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Coordinates
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.OperatingCompany
import com.expediagroup.openworld.sdk.fraudpreventionv2.models.Ticket

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.Length;

/**
 * 
 * @param activity 
 * @param operatingCompany 
 * @param startTime The field represents the start time of a activity, using the ISO-8061 date and time format yyyy-MM-ddTHH:mm:ss.SSSZ.
 * @param endTime The field represents the end time of a activity, using the ISO-8061 date and time format yyyy-MM-ddTHH:mm:ss.SSSZ.
 * @param ticket This field provides information about the tickets available for the activity.
 * @param isCouponRequired A coupon is typically a document or electronic code that confirms your reservation or purchase for the activity. It serves as proof of payment and allows you to participate in the activity. This field indicates whether a coupon is necessary for this activity. | For example, let's consider two scenarios: | Activity: Adventure Park | is_coupon_required: false | In this case, the attribute is set to 'false,' indicating that no coupon is necessary. However, you might still need to purchase a ticket to gain entry to the adventure park. The ticket serves as proof of payment and grants you access to the park's activities and attractions. | Activity: Spa Package | is_coupon_required: true | Here, the attribute is set to 'true,' indicating that a coupon is required. To participate in the spa package, you would need to present the designated coupon at the spa. The coupon confirms your reservation, serves as proof of payment, and may entitle you to specific spa treatments or discounts.
 * @param locationCoordinates 
 */
data class ActivitiesAllOf(
    @JsonProperty("activity")

    
    
    
    
    @field:Valid
    val activity: Activity,

    @JsonProperty("operating_company")

    
    
    
    
    @field:Valid
    val operatingCompany: OperatingCompany,

    /* The field represents the start time of a activity, using the ISO-8061 date and time format yyyy-MM-ddTHH:mm:ss.SSSZ. */
@JsonProperty("start_time")

    val startTime: java.time.OffsetDateTime,

    /* The field represents the end time of a activity, using the ISO-8061 date and time format yyyy-MM-ddTHH:mm:ss.SSSZ. */
@JsonProperty("end_time")

    val endTime: java.time.OffsetDateTime,

    /* This field provides information about the tickets available for the activity. */
@JsonProperty("ticket")

    
    @field:Size(min = 1, max = 40)
    
    
    @field:Valid
    val ticket: kotlin.collections.List<Ticket>,

    /* A coupon is typically a document or electronic code that confirms your reservation or purchase for the activity. It serves as proof of payment and allows you to participate in the activity. This field indicates whether a coupon is necessary for this activity. | For example, let's consider two scenarios: | Activity: Adventure Park | is_coupon_required: false | In this case, the attribute is set to 'false,' indicating that no coupon is necessary. However, you might still need to purchase a ticket to gain entry to the adventure park. The ticket serves as proof of payment and grants you access to the park's activities and attractions. | Activity: Spa Package | is_coupon_required: true | Here, the attribute is set to 'true,' indicating that a coupon is required. To participate in the spa package, you would need to present the designated coupon at the spa. The coupon confirms your reservation, serves as proof of payment, and may entitle you to specific spa treatments or discounts. */
@JsonProperty("is_coupon_required")

    
    
    
    
    @field:Valid
    val isCouponRequired: kotlin.Boolean? = null,

    @JsonProperty("location_coordinates")

    
    
    
    
    @field:Valid
    val locationCoordinates: Coordinates? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var activity: Activity? = null,
        private var operatingCompany: OperatingCompany? = null,
        private var startTime: java.time.OffsetDateTime? = null,
        private var endTime: java.time.OffsetDateTime? = null,
        private var ticket: kotlin.collections.List<Ticket>? = null,
        private var isCouponRequired: kotlin.Boolean? = null,
        private var locationCoordinates: Coordinates? = null
    ) {
        fun activity(activity: Activity) = apply { this.activity = activity }
        fun operatingCompany(operatingCompany: OperatingCompany) = apply { this.operatingCompany = operatingCompany }
        fun startTime(startTime: java.time.OffsetDateTime) = apply { this.startTime = startTime }
        fun endTime(endTime: java.time.OffsetDateTime) = apply { this.endTime = endTime }
        fun ticket(ticket: kotlin.collections.List<Ticket>) = apply { this.ticket = ticket }
        fun isCouponRequired(isCouponRequired: kotlin.Boolean) = apply { this.isCouponRequired = isCouponRequired }
        fun locationCoordinates(locationCoordinates: Coordinates) = apply { this.locationCoordinates = locationCoordinates }

        fun build(): ActivitiesAllOf {
            // Check required params
            validateNullity()
            return ActivitiesAllOf(
                activity = activity!!,
                operatingCompany = operatingCompany!!,
                startTime = startTime!!,
                endTime = endTime!!,
                ticket = ticket!!,
                isCouponRequired = isCouponRequired,
                locationCoordinates = locationCoordinates
            )
        }

        private fun validateNullity() {
            if (activity == null) {
                throw NullPointerException("Required parameter activity is missing")
            }
            if (operatingCompany == null) {
                throw NullPointerException("Required parameter operatingCompany is missing")
            }
            if (startTime == null) {
                throw NullPointerException("Required parameter startTime is missing")
            }
            if (endTime == null) {
                throw NullPointerException("Required parameter endTime is missing")
            }
            if (ticket == null) {
                throw NullPointerException("Required parameter ticket is missing")
            }
        }
    }
}

