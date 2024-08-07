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
package com.expediagroup.sdk.xap.operations

import com.expediagroup.sdk.core.model.OperationParams

/**
 * @property offerToken A Hotel Natural Key from the Lodging Search API -> Hotels -> RoomTypes -> OfferId. It is a concatenated string of multiple values that defines a hotel offer.
 * @property partnerTransactionId The `Partner-Transaction-ID` is a required API request header element that is <u>not</u> consumed by Expedia. It will be required in all XAP v3 API request headers and will be mirrored back to the partner in the corresponding API response header.  The `Partner-Transaction-ID` may be any alphanumeric string of the partner's choosing.
 * @property price The total price of the selected property.  This value will be used to determine if there is a price change between the details and booking request.  The `price` element will be automatically included in the ApiDetails HATEOAS link which is returned along with the Lodging Details API response.
 * @property currency Value should be a standard ISO 3 letter currency code.  The currency code that is associated to the `TotalPrice` element for the selected property's rate plan from the Lodging Listing API response.  The `currency` element will be automatically included in the ApiDetails HATEOAS link which is returned along with the Lodging Details response.
 * @property locale `locale` is composed of language identifier and region identifier, connected by \"_\" that specifies the language in which the response will be returned.  The `locale` value used in the Lodging Details API query should match the `locale` value that was used in the Lodging Search API query.
 * @property imageSizes Indicate what size of image will be returned.  The available image sizes are: - t : Thumbnail - s : Small - b : Big - y : 500x500v - z : 1000x1000v  Resolution from smallest to largest is t < s < b < y < z.  If no `imageSizes` is specified, the t size images will be returned.  If an image is missing in one size, we will try to fall back to the same image with lower resolution.  (If image \"_z\" is not available, we will try to return image \"_y\", and if it is also unavailable, we will return image \"_b\", and so on.)  Only one image size is allowed.
 * @property groupedAmenities Specifies whether to return the grouped amenities. If `groupedAmenities` is true, `DescriptiveAmenities` node will be returned in response, otherwise `Amenities` node will be returned.
 */
data class GetLodgingDetailsOperationParams(
    val offerToken: kotlin.String,
    val partnerTransactionId: kotlin.String,
    val price: kotlin.String? =
        null,
    val currency: kotlin.String? =
        null,
    val locale: kotlin.String? =
        null,
    val imageSizes: ImageSizes? =
        ImageSizes.T,
    val groupedAmenities: kotlin.Boolean? =
        null
) :
    OperationParams {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    enum class ImageSizes(val value: kotlin.String) {
        T("t"),
        S("s"),
        B("b"),
        Y("y"),
        Z("z")
    }

    class Builder(
        private var offerToken: kotlin.String? = null,
        private var partnerTransactionId: kotlin.String? = null,
        private var price: kotlin.String? = null,
        private var currency: kotlin.String? = null,
        private var locale: kotlin.String? = null,
        private var imageSizes: ImageSizes? = null,
        private var groupedAmenities: kotlin.Boolean? = null
    ) {
        /**
         * @param offerToken A Hotel Natural Key from the Lodging Search API -> Hotels -> RoomTypes -> OfferId. It is a concatenated string of multiple values that defines a hotel offer.
         */
        fun offerToken(offerToken: kotlin.String) = apply { this.offerToken = offerToken }

        /**
         * @param partnerTransactionId The `Partner-Transaction-ID` is a required API request header element that is <u>not</u> consumed by Expedia. It will be required in all XAP v3 API request headers and will be mirrored back to the partner in the corresponding API response header.  The `Partner-Transaction-ID` may be any alphanumeric string of the partner's choosing.
         */
        fun partnerTransactionId(partnerTransactionId: kotlin.String) = apply { this.partnerTransactionId = partnerTransactionId }

        /**
         * @param price The total price of the selected property.  This value will be used to determine if there is a price change between the details and booking request.  The `price` element will be automatically included in the ApiDetails HATEOAS link which is returned along with the Lodging Details API response.
         */
        fun price(price: kotlin.String) = apply { this.price = price }

        /**
         * @param currency Value should be a standard ISO 3 letter currency code.  The currency code that is associated to the `TotalPrice` element for the selected property's rate plan from the Lodging Listing API response.  The `currency` element will be automatically included in the ApiDetails HATEOAS link which is returned along with the Lodging Details response.
         */
        fun currency(currency: kotlin.String) = apply { this.currency = currency }

        /**
         * @param locale `locale` is composed of language identifier and region identifier, connected by \"_\" that specifies the language in which the response will be returned.  The `locale` value used in the Lodging Details API query should match the `locale` value that was used in the Lodging Search API query.
         */
        fun locale(locale: kotlin.String) = apply { this.locale = locale }

        /**
         * @param imageSizes Indicate what size of image will be returned.  The available image sizes are: - t : Thumbnail - s : Small - b : Big - y : 500x500v - z : 1000x1000v  Resolution from smallest to largest is t < s < b < y < z.  If no `imageSizes` is specified, the t size images will be returned.  If an image is missing in one size, we will try to fall back to the same image with lower resolution.  (If image \"_z\" is not available, we will try to return image \"_y\", and if it is also unavailable, we will return image \"_b\", and so on.)  Only one image size is allowed.
         */
        fun imageSizes(imageSizes: ImageSizes) = apply { this.imageSizes = imageSizes }

        /**
         * @param groupedAmenities Specifies whether to return the grouped amenities. If `groupedAmenities` is true, `DescriptiveAmenities` node will be returned in response, otherwise `Amenities` node will be returned.
         */
        fun groupedAmenities(groupedAmenities: kotlin.Boolean) = apply { this.groupedAmenities = groupedAmenities }

        fun build(): GetLodgingDetailsOperationParams {
            validateNullity()

            return GetLodgingDetailsOperationParams(
                offerToken = offerToken!!,
                partnerTransactionId = partnerTransactionId!!,
                price = price,
                currency = currency,
                locale = locale,
                imageSizes = imageSizes,
                groupedAmenities = groupedAmenities
            )
        }

        private fun validateNullity() {
            if (offerToken == null) {
                throw NullPointerException("Required parameter offerToken is missing")
            }
            if (partnerTransactionId == null) {
                throw NullPointerException("Required parameter partnerTransactionId is missing")
            }
        }
    }

    override fun getHeaders(): Map<String, String> {
        return buildMap {
            partnerTransactionId?.also {
                put("Partner-Transaction-Id", partnerTransactionId)
            }
            put("Accept", "application/vnd.exp-hotel.v3+json")
        }
    }

    override fun getQueryParams(): Map<String, Iterable<String>> {
        return buildMap {
            price?.also {
                put(
                    "price",
                    listOf(price)
                )
            }
            currency?.also {
                put(
                    "currency",
                    listOf(currency)
                )
            }
            locale?.also {
                put(
                    "locale",
                    listOf(locale)
                )
            }
            imageSizes?.also {
                put(
                    "imageSizes",
                    listOf(imageSizes.value)
                )
            }
            groupedAmenities?.also {
                put(
                    "groupedAmenities",
                    listOf(groupedAmenities.toString())
                )
            }
        }
    }

    override fun getPathParams(): Map<String, String> {
        return buildMap {
            offerToken?.also {
                put("offerToken", offerToken)
            }
        }
    }
}
