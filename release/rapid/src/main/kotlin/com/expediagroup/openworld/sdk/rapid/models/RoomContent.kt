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

package com.expediagroup.openworld.sdk.rapid.models

import com.expediagroup.openworld.sdk.rapid.models.Amenity
import com.expediagroup.openworld.sdk.rapid.models.Area
import com.expediagroup.openworld.sdk.rapid.models.BedGroup
import com.expediagroup.openworld.sdk.rapid.models.DescriptionsRoom
import com.expediagroup.openworld.sdk.rapid.models.Image
import com.expediagroup.openworld.sdk.rapid.models.Occupancy
import com.expediagroup.openworld.sdk.rapid.models.View

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
 * An individual room.
 * @param id Unique identifier for a room type.
 * @param name Room type name.
 * @param descriptions 
 * @param amenities Lists all of the amenities available in the room. See our [amenities reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known amenity ID and name values.
 * @param images The room's images. Contains all room images available.
 * @param bedGroups A map of the room's bed groups.
 * @param area 
 * @param views A map of the room views. See our [view reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known room view ID and name values.
 * @param occupancy 
 */
data class RoomContent(
    /* Unique identifier for a room type. */
@JsonProperty("id")

    
    
    
    
    @field:Valid
    val id: kotlin.String? = null,

    /* Room type name. */
@JsonProperty("name")

    
    
    
    
    @field:Valid
    val name: kotlin.String? = null,

    @JsonProperty("descriptions")

    
    
    
    
    @field:Valid
    val descriptions: DescriptionsRoom? = null,

    /* Lists all of the amenities available in the room. See our [amenities reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known amenity ID and name values. */
@JsonProperty("amenities")

    
    
    
    
    @field:Valid
    val amenities: kotlin.collections.Map<kotlin.String, Amenity>? = null,

    /* The room's images. Contains all room images available. */
@JsonProperty("images")

    
    
    
    
    @field:Valid
    val images: kotlin.collections.List<Image>? = null,

    /* A map of the room's bed groups. */
@JsonProperty("bed_groups")

    
    
    
    
    @field:Valid
    val bedGroups: kotlin.collections.Map<kotlin.String, BedGroup>? = null,

    @JsonProperty("area")

    
    
    
    
    @field:Valid
    val area: Area? = null,

    /* A map of the room views. See our [view reference](https://developers.expediagroup.com/docs/rapid/lodging/content/content-reference-lists) for current known room view ID and name values. */
@JsonProperty("views")

    
    
    
    
    @field:Valid
    val views: kotlin.collections.Map<kotlin.String, View>? = null,

    @JsonProperty("occupancy")

    
    
    
    
    @field:Valid
    val occupancy: Occupancy? = null
) {
    


    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    class Builder(
        private var id: kotlin.String? = null,
        private var name: kotlin.String? = null,
        private var descriptions: DescriptionsRoom? = null,
        private var amenities: kotlin.collections.Map<kotlin.String, Amenity>? = null,
        private var images: kotlin.collections.List<Image>? = null,
        private var bedGroups: kotlin.collections.Map<kotlin.String, BedGroup>? = null,
        private var area: Area? = null,
        private var views: kotlin.collections.Map<kotlin.String, View>? = null,
        private var occupancy: Occupancy? = null
    ) {
        fun id(id: kotlin.String) = apply { this.id = id }
        fun name(name: kotlin.String) = apply { this.name = name }
        fun descriptions(descriptions: DescriptionsRoom) = apply { this.descriptions = descriptions }
        fun amenities(amenities: kotlin.collections.Map<kotlin.String, Amenity>) = apply { this.amenities = amenities }
        fun images(images: kotlin.collections.List<Image>) = apply { this.images = images }
        fun bedGroups(bedGroups: kotlin.collections.Map<kotlin.String, BedGroup>) = apply { this.bedGroups = bedGroups }
        fun area(area: Area) = apply { this.area = area }
        fun views(views: kotlin.collections.Map<kotlin.String, View>) = apply { this.views = views }
        fun occupancy(occupancy: Occupancy) = apply { this.occupancy = occupancy }

        fun build(): RoomContent {
            return RoomContent(
                id = id,
                name = name,
                descriptions = descriptions,
                amenities = amenities,
                images = images,
                bedGroups = bedGroups,
                area = area,
                views = views,
                occupancy = occupancy
            )
        }

    }
}

