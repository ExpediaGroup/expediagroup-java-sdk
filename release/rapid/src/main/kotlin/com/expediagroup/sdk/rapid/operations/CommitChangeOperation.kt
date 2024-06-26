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

package com.expediagroup.sdk.rapid.operations

import com.expediagroup.sdk.core.model.Operation
import com.expediagroup.sdk.rapid.models.CommitChangeRoomRequestBody

/**
 * Commit a change of itinerary that may require additional payment or refund.
 * @property requestBody [CommitChangeRoomRequestBody]
 * @property params [CommitChangeOperationParams]
 */
class CommitChangeOperation(
    requestBody: CommitChangeRoomRequestBody?,
    params: CommitChangeOperationParams
) : Operation<
        CommitChangeRoomRequestBody
    >(
        "/v3/itineraries/{itinerary_id}/rooms/{room_id}/pricing".replace("{" + "itinerary_id" + "}", "${params.itineraryId}").replace("{" + "room_id" + "}", "${params.roomId}"),
        "PUT",
        "commitChange",
        requestBody,
        params
    )
