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
import com.expediagroup.sdk.xap.models.Room

/**
 * @property partnerTransactionId The `Partner-Transaction-ID` is a required API request header element that is <u>not</u> consumed by Expedia. It will be required in all XAP v3 API request headers and will be mirrored back to the partner in the corresponding API response header.  The `Partner-Transaction-ID` may be any alphanumeric string of the partner's choosing.
 * @property ecomHotelIds Comma-separated list of Expedia hotel IDs. There can be no spaces between parameters.
 * @property hcomHotelIds Comma-separated list of Hotels.com hotel IDs. There can be no spaces between parameters.
 * @property geoLocation The latitude and longitude values identifying the center point of a search radius (circle).  North latitude will be represented by a positive value. South latitude by a negative value.  East longitude will be represented by a positive value. West longitude by a negative value.  The latitude and longitude values are joined together with a comma (,) character. There can be no spaces between parameters.  This parameter should be used in combination with the radius and unit parameters below.
 * @property radius The size of the search radius around a specified point when searching by `geoLocation`, `locationKeyword`, or `regionids`.  `radius` is optional and the default value is 25 km for `geoLocation` and `locationKeyword` if not specified. `radius` must be less than 200 km or 124 mi.  This parameter should be used in combination with the `unit` and `geoLocation`, `locationKeyword`, or `regionids` parameters.\"
 * @property unit The unit of measure for searches performed via `geoLocation`, `locationKeyword`, or `regionids`.  Valid units are `km` and `mi`.  This parameter should be used in combination with the `radius` and `geoLocation`, `locationKeyword`, or `regionids`.
 * @property locationKeyword A keyword search for a location. The keyword can be a city, address, airport or a landmark.  This parameter should be used in combination with the `radius` and `unit` parameters above to define a circle around the landmark.  The default radius value is 25 if not specified.  Combined search is not supported, if more than one search method is included in the request, an error will be returned.
 * @property regionIds Comma-separated list of Expedia Region IDs. There can be no spaces between parameters. Search returns set of all hotels in the combined regions.  You may search using a string of 1 - 10 Region ID's. More than 10 Region ID's are not supported and will generate and error.  You can get the complete list of Expedia Region IDs from [Static Data Platform ALL_REGIONS file](https://developers.expediagroup.com/xap/products/xap/static-data-platform/download-url-api/download-url-api-v1).  This parameter could be used in combination with the `radius` and `unit` parameters above to define a circle around the `regionIds`. The default radius value is 0 if not specified.
 * @property checkIn Check-in date for hotel stay in an ISO 8601 Date format [YYYY-MM-DD].  This parameter should be used in combination with the `checkOut` parameter.  If `checkIn` and `checkOut` are not included, a dateless search will be conducted which returns a `Featured Offer` for each of the hotels found.  If one of `checkIn` and `checkOut` is not included, an error will be returned.  The maximum advanced search window is 500 days in the future, and the maximum length of stay is 28.
 * @property checkOut Checkout date for hotel stay in an ISO 8601 Date format [YYYY-MM-DD].  This parameter should be used in combination with the `checkIn` parameter.  If `checkIn` and `checkOut` are not included, a dateless search will be conducted which returns a `Featured Offer` for each of the hotels found.  If one of `checkIn` and `checkOut` is not included, an error will be returned.  The maximum advanced search window is 500 days in the future, and the maximum length of stay is 28.
 * @property locale `locale` is composed of language identifier and region identifier, connected by \"_\" that specifies the language in which the response will be returned.  You can find a link to the complete list of `locales` along with the Point of Sale List in [Supported Points of Sale](https://developers.expediagroup.com/xap/products/xap/lodging/references/supported-points-of-sale). Note that even though the Listings API supports localization for all `locales` listed in the list, all `locales` are not valid for all Points of Sale.  For example, Ecom US POS supports `en_US`, `es_MX` and `zh_CN`. For Ecom US POS, the Listings API will respond with content in Spanish for requests with either `locale=es_MX` or `es_US`. However, only the deeplinks for `locale=es_MX` should work properly and switch the website to Spanish, while the ones for locale=es_US will be fallen back to English.  If not specified in the query, the native language for that POS will be returned. And if more than one language is supported, the response will be returned in the first language depending on the language setting of the POS.
 * @property currency Value should be a standard ISO 3 letter currency code.
 * @property source Indicate the source where the request is coming from.
 * @property travelWithPets Indicates if the search should include pet-friendly properties.  If set to \"True\" only properties that allow pets are returned. Pet fees, if available, are included in TaxesAndFees.  The parameter is only applicable to the Vrbo brand.
 * @property contentDetails This parameter is optional and can be specified as the following values. - lowest - low (default) - medium - high  ### *lowest* Returns the absolute minimum response for up to 1,000 hotels: - Count(Count of hotels that are actually returned) - TotalHotelCount(Count of hotels that are requested) - TransactionId - StayDates - LengthOfStay - NumberOfRooms - Occupants - ***Hotels***   - Id   - Status   - Links   - ***RoomTypes***     - RoomKey [Deprecated]     - OfferId     - RatePlanType     - ***RatePlans***       - RoomTypeId       - RatePlanId       - RateRuleId       - InventorySourceId       - RemainingCount       - Price       - MemberOnlyDeal       - Promotions       - PaymentMethod       - FullDepositUponBooking       - PaymentSchedule       - CancellationPolicy     - Price       - BaseRate       - TaxesAndFees       - TotalPrice       - TotalStrikeOutPrice       - AvgNightlyRate       - AvgNightlyStrikeOutRate       - AvgNightlyRateWithFees       - AvgNightlyStrikeOutRateWithFees       - HotelMandatoryFees       - TotalPriceWithHotelFees       - NightlyRates       - TaxesAndFeesDetails       - RefundableDamageDeposit  This minimal response is the best for partners that store static hotel location data locally, and who would like to have the smallest and fastest API response.  ### *low* Returns basic hotel information in response for up to 1,000 hotels.  Includes all elements returned when `contentDetails=lowest` plus: - ***Hotels***   - Name   - PropertyType   - PropertyDetails   - LocalCurrencyCode   - Location   - Distance   - Description(may not be localized)   - ChainAndBrandInfo   - ThumbnailUrl   - StarRating   - GuestRating   - GuestReviewCount   - PetFriendly   - LgbtqiaFriendly   - ImportantNotices   - ***RoomTypes***     - Description     - ***RatePlans***       - InventorySourceCode       - PaymentTime       - ReserveWithDeposit       - FreeInternet       - FreeWiFi       - FreeParking       - FreeBreakfast  ### *medium* Returns more complete hotel information in response for up to 200 hotels.  Includes all elements returned when `contentDetails=low` plus: - ***Hotels***   - HotelAmenities   - RoomAmenities   - ***RoomTypes***     - ***RatePlans***       - FreeInternetDetails       - FreeBreakfastDetails       - Amenities     - Amenities  **Note**: Setting the `contentDetails` to `medium` will automatically limit your response size to 200 hotels.  ### *high* Returns extended hotel information in response for up to 5 hotels.  Includes all elements returned when `contentDetails=medium` plus: - ***Hotels***   - RenovationsAndClosures   - Policies   - OptionalExtras   - Media   - Accessibility   - ***RoomTypes***     - SmokingOption     - BedTypeOptions     - RoomOccupancyPolicy     - Media  **Note**: Setting the `contentDetails` to `high` will automatically limit your response size to 5 hotels.
 * @property allRoomTypes Returns all available rate plans for the selected hotels.  This parameter requires that a `checkIn` date and `checkOut` date be supplied, as the API cannot return additional room rates on a dateless search.  Including `allRoomTypes=true` in your query will automatically limit your response size to no more than 200 hotels.  Including `allRoomTypes=true` and `contentDetails=high` will limit your response size to no more than 5 hotels.
 * @property links  Comma-separated list to specify the types of deep links. - WD (link to Web Details site) - WS (link to Web Search Result page) - AD (link for Details API) - RC (link for RateCalendar API) - WEB (include all website links) - API (links for Details and RateCalendar API)  There are two level of links returned in the API response: Property-level deeplinks and room-level deeplinks.  When requesting API deeplinks you will receive both a RateCalendar API link at the property level, and Details API links at the room level, since the Lodging Details API only displays information on rate plan offers.  When requesting AD deeplinks, you will <u>only</u> receive Details API links at the room level. `Links` node in property-level will be omitted.  If you are looking for more complete details on a single property via the API, you should do another search in the Lodging API for the single Hotel ID, with `contentDetails=high` to get all details back in return (note that you can only get back a maximum of 5 hotels when `contentDetails` is set to `high`).  **NOTE**: dateless searches will not return Details API links, since the Lodging Details API will only return details on a specific room offer for specific dates.
 * @property minStarRating The minimum star rating for hotels returned in the response.
 * @property maxStarRating The maximum star rating for hotels returned in the response.
 * @property limit The maximum number of hotels returned in the response. Must be an integer greater than 0.  If the value is greater than 1000, only the first 1000 hotels are returned.  Settings on `contentDetails` and `allRoomTypes` parameters may cause this value to be overridden and a lower number of hotels to be returned.  The `limit` parameter is intended to be used to control the response size, but partners should be careful about combining it with other filter parameters, as each parameter that you add will shrink the response, even to the point where you may even get a \"no hotel found\" error if none of the hotels in the base response meet the combined filter requirements.  Filters are cumulative in effect, and results must meet all filter requirements to be displayed.
 * @property queryText Query text is used for a full text search of hotel data.  Text search based on hotel name, description, address, promotion description, amenities description.
 * @property availOnly Specifies whether to return only available hotels in the search results.  If the value of this parameter is true, the search results will only return hotels that have availability during the requested dates.  If there are no hotels with availability in your search then an empty record set will be returned.  This parameter is ignored for dateless searches.
 * @property smokingPreference Specifies smoking preference.
 * @property rateType Indicate which type of `paymentMethod` for each room will be returned.
 * @property imageSizes Indicates what size images will be displayed for `hotelPhotos` and `roomPhotos` are returned when `contentDetails=high`.  The available image sizes are: - t : Thumbnail - s : Small - b : Big - y : 500x500v - z : 1000x1000v  Resolution from smallest to largest is t < s < b < y < z.  If no `imageSizes` is specified, the t size images will be returned.  If an image is missing in one size, we will try to fall back to the same image with lower resolution.  (If image \"_z\" is not available, we will try to return image \"_y\", and if it is also unavailable, we will return image \"_b\", and so on.)  Only one image size is allowed.
 * @property thumbnailImageSize Indicate what size of image will be used for the single `thumbnail` image that is returned when `contentDetails` is set to `low`, `medium` or `high`.  The available thumbnail image sizes are: - t : Thumbnail - s : Small - b : Big - y : 500x500v - z : 1000x1000v  Resolution from smallest to largest is t < s < b < y < z.  If no `thumbnailImageSize` is specified, the t size images will be returned.  if no thumbnail image found, it would not return thumbnail image.  Only one thumbnail image size is allowed.
 * @property includedPropertyTypeIds Only return hotels where the `PropertyType` ID is one of the IDs in the `includedPropertyTypeIds` field.  If the API query includes the parameter `contentDetail=lowest` the `PropertyType` parameter will not be returned in the response. Even in this case, the filtering is still being applied, even though there is no `PropertyType` parameter in the response with which to validate.  `includedPropertyTypeIds` and `excludedPropertyTypeIds` fields are mutually exclusive - which means that each query may contain **one** of the parameters, or **neither** of the parameters, but the query may not contain **both** of the parameters.  A complete list of supported Expedia Property Types can be found in [Lodging Property Types](https://developers.expediagroup.com/xap/products/xap/lodging/references/property-types).
 * @property excludedPropertyTypeIds Return all hotels **except** those whose `PropertyType` ID is in the `excludedPropertyTypeIds` field.  If the API query includes the parameter `contentDetail=lowest` the `PropertyType` parameter will not be returned in the response. Even in this case, the filtering is still being applied, even though there is no `PropertyType` parameter in the response with which to validate.  `includedPropertyTypeIds` and `excludedPropertyTypeIds` fields are mutually exclusive - which means that each query may contain **one** of the parameters, or **neither** of the parameters, but the query may not contain **both** of the parameters.  A complete list of supported Expedia Property Types can be found in [Lodging Property Types](https://developers.expediagroup.com/xap/products/xap/lodging/references/property-types).
 * @property includedInventorySourceIds Querying with no `includedInventorySourceIds` parameter will return listings from all available inventory sources.  Query with the `includedInventorySourceIds` parameter included will only return listings from the requested inventory sources. All others will be left out.  `includedInventorySourceId=24` will return only Expedia lodging inventory.  `includedInventorySourceId=83` will return only Vrbo lodging inventory.  `includedInventorySourceId=24,83` will return both Expedia and Vrbo lodging inventory.
 * @property freeCancellation Specifies whether to return only free cancelable room rates in the search results.  If the value of this parameter is true, the search results will only return hotels that have free cancelable room rates during the requested dates.  If there are no hotels with free cancelable room rates in your search then an empty record set will be returned.  Default value is false, if query without this parameter or the value of this parameter is false, all available room rates will be returned.  This parameter is ignored for dateless searches.
 * @property groupedAmenities Specifies whether to return the grouped amenities. If `groupedAmenities` is true, `DescriptiveAmenities` node will be returned in response, otherwise `Amenities` node will be returned.
 * @property blockFullDepositRateplan Specifies whether to return `rateplan` with `FullDepositUponBooking` as true.  If `blockFullDepositRateplans` is true, the search results will not return `rateplan` with `FullDepositUponBooking` as true.  The default value is false, if query without this parameter or the value of this parameter is false, all available rateplan will be returned.  This parameter is ignored for dateless search.
 * @property ratePlanType **Note**: This parameter is visible to partners only by configuration. Please contact your Expedia Account Manager if you need this parameter.  To specify the desired rate plan types. The options are: - standalone : Ask for standalone rates - package : Ask for package rates, but standalone rate also may be returned if available.  Otherwise only standalone rate plans will be returned.  `WebSearchResult` and `WebDetails` links won't be returned for package rate.
 * @property sortType Specifies the field that the search results will be ordered by.  To be used in conjunction with sortOrder parameter below.  **CMA Compliance Note (UK)**: partners doing business in the UK should be sorting their search results using the `totalpricewithfees` parameter in their query string so that the sorting complies with CMA regulations.
 * @property sortOrder Specifies the sort order of search results.  If no sort order is specified, the default is `asc`. But for deals sorting, it only supports `desc`.  To be used in conjunction with the `sortType` parameter above.
 */
data class GetLodgingListingsOperationParams(
    val partnerTransactionId: kotlin.String,
    val ecomHotelIds: kotlin.String? =
        null,
    val hcomHotelIds: kotlin.String? =
        null,
    val geoLocation: kotlin.String? =
        null,
    val radius: kotlin.Long? =
        25L,
    val unit: Unit? =
        Unit.KM,
    val locationKeyword: kotlin.String? =
        null,
    val regionIds: kotlin.String? =
        null,
    val checkIn: java.time.LocalDate? =
        null,
    val checkOut: java.time.LocalDate? =
        null,
    val locale: kotlin.String? =
        null,
    val currency: kotlin.String? =
        null,
    val source: Source? =
        Source.BROWSER,
    val travelWithPets: kotlin.Boolean? =
        false,
    val contentDetails: ContentDetails? =
        ContentDetails.LOW,
    val allRoomTypes: kotlin.Boolean? =
        false,
    val links: Links? =
        Links.WD,
    val minStarRating: MinStarRating? =
        null,
    val maxStarRating: MaxStarRating? =
        null,
    val limit: kotlin.Long? =
        null,
    val queryText: kotlin.String? =
        null,
    val availOnly: kotlin.Boolean? =
        null,
    val smokingPreference: SmokingPreference? =
        null,
    val rateType: RateType? =
        null,
    val imageSizes: ImageSizes? =
        null,
    val thumbnailImageSize: ThumbnailImageSize? =
        null,
    val includedPropertyTypeIds: kotlin.String? =
        null,
    val excludedPropertyTypeIds: kotlin.String? =
        null,
    val includedInventorySourceIds: kotlin.String? =
        null,
    val freeCancellation: kotlin.Boolean? =
        null,
    val groupedAmenities: kotlin.Boolean? =
        null,
    val blockFullDepositRateplan: kotlin.Boolean? =
        false,
    val ratePlanType: RatePlanType? =
        null,
    val sortType: SortType? =
        null,
    val sortOrder: SortOrder? =
        SortOrder.ASC,
    private val room1Adults: kotlin.Long? =
        null,
    private val room1ChildAges: kotlin.String? =
        null,
    private val room2Adults: kotlin.Long? =
        null,
    private val room2ChildAges: kotlin.String? =
        null,
    private val room3Adults: kotlin.Long? =
        null,
    private val room3ChildAges: kotlin.String? =
        null,
    private val room4Adults: kotlin.Long? =
        null,
    private val room4ChildAges: kotlin.String? =
        null,
    private val room5Adults: kotlin.Long? =
        null,
    private val room5ChildAges: kotlin.String? =
        null,
    private val room6Adults: kotlin.Long? =
        null,
    private val room6ChildAges: kotlin.String? =
        null,
    private val room7Adults: kotlin.Long? =
        null,
    private val room7ChildAges: kotlin.String? =
        null,
    private val room8Adults: kotlin.Long? =
        null,
    private val room8ChildAges: kotlin.String? =
        null
) :
    OperationParams {
    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

    enum class Unit(val value: kotlin.String) {
        KM("km"),
        MI("mi")
    }

    enum class Source(val value: kotlin.String) {
        BROWSER("browser"),
        MOBILEAPP("mobileapp")
    }

    enum class ContentDetails(val value: kotlin.String) {
        LOWEST("lowest"),
        LOW("low"),
        MEDIUM("medium"),
        HIGH("high")
    }

    enum class Links(val value: kotlin.String) {
        WD("WD"),
        WS("WS"),
        AD("AD"),
        RC("RC"),
        WEB("WEB"),
        API("API")
    }

    enum class MinStarRating(val value: kotlin.String) {
        _1_PERIOD0("1.0"),
        _1_PERIOD5("1.5"),
        _2_PERIOD0("2.0"),
        _2_PERIOD5("2.5"),
        _3_PERIOD0("3.0"),
        _3_PERIOD5("3.5"),
        _4_PERIOD0("4.0"),
        _4_PERIOD5("4.5"),
        _5_PERIOD0("5.0")
    }

    enum class MaxStarRating(val value: kotlin.String) {
        _1_PERIOD0("1.0"),
        _1_PERIOD5("1.5"),
        _2_PERIOD0("2.0"),
        _2_PERIOD5("2.5"),
        _3_PERIOD0("3.0"),
        _3_PERIOD5("3.5"),
        _4_PERIOD0("4.0"),
        _4_PERIOD5("4.5"),
        _5_PERIOD0("5.0")
    }

    enum class SmokingPreference(val value: kotlin.String) {
        SMOKING("smoking"),
        NONSMOKING("nonsmoking"),
        BOTH("both")
    }

    enum class RateType(val value: kotlin.String) {
        PAYONLINE("payonline"),
        PAYHOTEL("payhotel"),
        ALL("all")
    }

    enum class ImageSizes(val value: kotlin.String) {
        T("t"),
        S("s"),
        B("b"),
        Y("y"),
        Z("z")
    }

    enum class ThumbnailImageSize(val value: kotlin.String) {
        T("t"),
        S("s"),
        B("b"),
        Y("y"),
        Z("z")
    }

    enum class RatePlanType(val value: kotlin.String) {
        STANDALONE("standalone"),
        PACKAGE("package")
    }

    enum class SortType(val value: kotlin.String) {
        PRICE("price"),
        STARRATING("starrating"),
        AVGRATE("avgrate"),
        DEALS("deals"),
        GUESTRATING("guestrating"),
        HOTELNAME("hotelname"),
        DISTANCE("distance"),
        TOTALPRICEWITHFEES("totalpricewithfees")
    }

    enum class SortOrder(val value: kotlin.String) {
        ASC("asc"),
        DESC("desc")
    }

    class Builder(
        private var partnerTransactionId: kotlin.String? = null,
        private var ecomHotelIds: kotlin.String? = null,
        private var hcomHotelIds: kotlin.String? = null,
        private var geoLocation: kotlin.String? = null,
        private var radius: kotlin.Long? = null,
        private var unit: Unit? = null,
        private var locationKeyword: kotlin.String? = null,
        private var regionIds: kotlin.String? = null,
        private var checkIn: java.time.LocalDate? = null,
        private var checkOut: java.time.LocalDate? = null,
        private var locale: kotlin.String? = null,
        private var currency: kotlin.String? = null,
        private var source: Source? = null,
        private var travelWithPets: kotlin.Boolean? = null,
        private var contentDetails: ContentDetails? = null,
        private var allRoomTypes: kotlin.Boolean? = null,
        private var links: Links? = null,
        private var minStarRating: MinStarRating? = null,
        private var maxStarRating: MaxStarRating? = null,
        private var limit: kotlin.Long? = null,
        private var queryText: kotlin.String? = null,
        private var availOnly: kotlin.Boolean? = null,
        private var smokingPreference: SmokingPreference? = null,
        private var rateType: RateType? = null,
        private var imageSizes: ImageSizes? = null,
        private var thumbnailImageSize: ThumbnailImageSize? = null,
        private var includedPropertyTypeIds: kotlin.String? = null,
        private var excludedPropertyTypeIds: kotlin.String? = null,
        private var includedInventorySourceIds: kotlin.String? = null,
        private var freeCancellation: kotlin.Boolean? = null,
        private var groupedAmenities: kotlin.Boolean? = null,
        private var blockFullDepositRateplan: kotlin.Boolean? = null,
        private var ratePlanType: RatePlanType? = null,
        private var sortType: SortType? = null,
        private var sortOrder: SortOrder? = null,
        private var room1Adults: kotlin.Long? = null,
        private var room1ChildAges: kotlin.String? = null,
        private var room2Adults: kotlin.Long? = null,
        private var room2ChildAges: kotlin.String? = null,
        private var room3Adults: kotlin.Long? = null,
        private var room3ChildAges: kotlin.String? = null,
        private var room4Adults: kotlin.Long? = null,
        private var room4ChildAges: kotlin.String? = null,
        private var room5Adults: kotlin.Long? = null,
        private var room5ChildAges: kotlin.String? = null,
        private var room6Adults: kotlin.Long? = null,
        private var room6ChildAges: kotlin.String? = null,
        private var room7Adults: kotlin.Long? = null,
        private var room7ChildAges: kotlin.String? = null,
        private var room8Adults: kotlin.Long? = null,
        private var room8ChildAges: kotlin.String? = null
    ) {
        /**
         * @param partnerTransactionId The `Partner-Transaction-ID` is a required API request header element that is <u>not</u> consumed by Expedia. It will be required in all XAP v3 API request headers and will be mirrored back to the partner in the corresponding API response header.  The `Partner-Transaction-ID` may be any alphanumeric string of the partner's choosing.
         */
        fun partnerTransactionId(partnerTransactionId: kotlin.String) = apply { this.partnerTransactionId = partnerTransactionId }

        /**
         * @param ecomHotelIds Comma-separated list of Expedia hotel IDs. There can be no spaces between parameters.
         */
        fun ecomHotelIds(ecomHotelIds: kotlin.String) = apply { this.ecomHotelIds = ecomHotelIds }

        /**
         * @param hcomHotelIds Comma-separated list of Hotels.com hotel IDs. There can be no spaces between parameters.
         */
        fun hcomHotelIds(hcomHotelIds: kotlin.String) = apply { this.hcomHotelIds = hcomHotelIds }

        /**
         * @param geoLocation The latitude and longitude values identifying the center point of a search radius (circle).  North latitude will be represented by a positive value. South latitude by a negative value.  East longitude will be represented by a positive value. West longitude by a negative value.  The latitude and longitude values are joined together with a comma (,) character. There can be no spaces between parameters.  This parameter should be used in combination with the radius and unit parameters below.
         */
        fun geoLocation(geoLocation: kotlin.String) = apply { this.geoLocation = geoLocation }

        /**
         * @param radius The size of the search radius around a specified point when searching by `geoLocation`, `locationKeyword`, or `regionids`.  `radius` is optional and the default value is 25 km for `geoLocation` and `locationKeyword` if not specified. `radius` must be less than 200 km or 124 mi.  This parameter should be used in combination with the `unit` and `geoLocation`, `locationKeyword`, or `regionids` parameters.\"
         */
        fun radius(radius: kotlin.Long) = apply { this.radius = radius }

        /**
         * @param unit The unit of measure for searches performed via `geoLocation`, `locationKeyword`, or `regionids`.  Valid units are `km` and `mi`.  This parameter should be used in combination with the `radius` and `geoLocation`, `locationKeyword`, or `regionids`.
         */
        fun unit(unit: Unit) = apply { this.unit = unit }

        /**
         * @param locationKeyword A keyword search for a location. The keyword can be a city, address, airport or a landmark.  This parameter should be used in combination with the `radius` and `unit` parameters above to define a circle around the landmark.  The default radius value is 25 if not specified.  Combined search is not supported, if more than one search method is included in the request, an error will be returned.
         */
        fun locationKeyword(locationKeyword: kotlin.String) = apply { this.locationKeyword = locationKeyword }

        /**
         * @param regionIds Comma-separated list of Expedia Region IDs. There can be no spaces between parameters. Search returns set of all hotels in the combined regions.  You may search using a string of 1 - 10 Region ID's. More than 10 Region ID's are not supported and will generate and error.  You can get the complete list of Expedia Region IDs from [Static Data Platform ALL_REGIONS file](https://developers.expediagroup.com/xap/products/xap/static-data-platform/download-url-api/download-url-api-v1).  This parameter could be used in combination with the `radius` and `unit` parameters above to define a circle around the `regionIds`. The default radius value is 0 if not specified.
         */
        fun regionIds(regionIds: kotlin.String) = apply { this.regionIds = regionIds }

        /**
         * @param checkIn Check-in date for hotel stay in an ISO 8601 Date format [YYYY-MM-DD].  This parameter should be used in combination with the `checkOut` parameter.  If `checkIn` and `checkOut` are not included, a dateless search will be conducted which returns a `Featured Offer` for each of the hotels found.  If one of `checkIn` and `checkOut` is not included, an error will be returned.  The maximum advanced search window is 500 days in the future, and the maximum length of stay is 28.
         */
        fun checkIn(checkIn: java.time.LocalDate) = apply { this.checkIn = checkIn }

        /**
         * @param checkOut Checkout date for hotel stay in an ISO 8601 Date format [YYYY-MM-DD].  This parameter should be used in combination with the `checkIn` parameter.  If `checkIn` and `checkOut` are not included, a dateless search will be conducted which returns a `Featured Offer` for each of the hotels found.  If one of `checkIn` and `checkOut` is not included, an error will be returned.  The maximum advanced search window is 500 days in the future, and the maximum length of stay is 28.
         */
        fun checkOut(checkOut: java.time.LocalDate) = apply { this.checkOut = checkOut }

        /**
         * @param locale `locale` is composed of language identifier and region identifier, connected by \"_\" that specifies the language in which the response will be returned.  You can find a link to the complete list of `locales` along with the Point of Sale List in [Supported Points of Sale](https://developers.expediagroup.com/xap/products/xap/lodging/references/supported-points-of-sale). Note that even though the Listings API supports localization for all `locales` listed in the list, all `locales` are not valid for all Points of Sale.  For example, Ecom US POS supports `en_US`, `es_MX` and `zh_CN`. For Ecom US POS, the Listings API will respond with content in Spanish for requests with either `locale=es_MX` or `es_US`. However, only the deeplinks for `locale=es_MX` should work properly and switch the website to Spanish, while the ones for locale=es_US will be fallen back to English.  If not specified in the query, the native language for that POS will be returned. And if more than one language is supported, the response will be returned in the first language depending on the language setting of the POS.
         */
        fun locale(locale: kotlin.String) = apply { this.locale = locale }

        /**
         * @param currency Value should be a standard ISO 3 letter currency code.
         */
        fun currency(currency: kotlin.String) = apply { this.currency = currency }

        /**
         * @param source Indicate the source where the request is coming from.
         */
        fun source(source: Source) = apply { this.source = source }

        /**
         * @param travelWithPets Indicates if the search should include pet-friendly properties.  If set to \"True\" only properties that allow pets are returned. Pet fees, if available, are included in TaxesAndFees.  The parameter is only applicable to the Vrbo brand.
         */
        fun travelWithPets(travelWithPets: kotlin.Boolean) = apply { this.travelWithPets = travelWithPets }

        /**
         * @param contentDetails This parameter is optional and can be specified as the following values. - lowest - low (default) - medium - high  ### *lowest* Returns the absolute minimum response for up to 1,000 hotels: - Count(Count of hotels that are actually returned) - TotalHotelCount(Count of hotels that are requested) - TransactionId - StayDates - LengthOfStay - NumberOfRooms - Occupants - ***Hotels***   - Id   - Status   - Links   - ***RoomTypes***     - RoomKey [Deprecated]     - OfferId     - RatePlanType     - ***RatePlans***       - RoomTypeId       - RatePlanId       - RateRuleId       - InventorySourceId       - RemainingCount       - Price       - MemberOnlyDeal       - Promotions       - PaymentMethod       - FullDepositUponBooking       - PaymentSchedule       - CancellationPolicy     - Price       - BaseRate       - TaxesAndFees       - TotalPrice       - TotalStrikeOutPrice       - AvgNightlyRate       - AvgNightlyStrikeOutRate       - AvgNightlyRateWithFees       - AvgNightlyStrikeOutRateWithFees       - HotelMandatoryFees       - TotalPriceWithHotelFees       - NightlyRates       - TaxesAndFeesDetails       - RefundableDamageDeposit  This minimal response is the best for partners that store static hotel location data locally, and who would like to have the smallest and fastest API response.  ### *low* Returns basic hotel information in response for up to 1,000 hotels.  Includes all elements returned when `contentDetails=lowest` plus: - ***Hotels***   - Name   - PropertyType   - PropertyDetails   - LocalCurrencyCode   - Location   - Distance   - Description(may not be localized)   - ChainAndBrandInfo   - ThumbnailUrl   - StarRating   - GuestRating   - GuestReviewCount   - PetFriendly   - LgbtqiaFriendly   - ImportantNotices   - ***RoomTypes***     - Description     - ***RatePlans***       - InventorySourceCode       - PaymentTime       - ReserveWithDeposit       - FreeInternet       - FreeWiFi       - FreeParking       - FreeBreakfast  ### *medium* Returns more complete hotel information in response for up to 200 hotels.  Includes all elements returned when `contentDetails=low` plus: - ***Hotels***   - HotelAmenities   - RoomAmenities   - ***RoomTypes***     - ***RatePlans***       - FreeInternetDetails       - FreeBreakfastDetails       - Amenities     - Amenities  **Note**: Setting the `contentDetails` to `medium` will automatically limit your response size to 200 hotels.  ### *high* Returns extended hotel information in response for up to 5 hotels.  Includes all elements returned when `contentDetails=medium` plus: - ***Hotels***   - RenovationsAndClosures   - Policies   - OptionalExtras   - Media   - Accessibility   - ***RoomTypes***     - SmokingOption     - BedTypeOptions     - RoomOccupancyPolicy     - Media  **Note**: Setting the `contentDetails` to `high` will automatically limit your response size to 5 hotels.
         */
        fun contentDetails(contentDetails: ContentDetails) = apply { this.contentDetails = contentDetails }

        /**
         * @param allRoomTypes Returns all available rate plans for the selected hotels.  This parameter requires that a `checkIn` date and `checkOut` date be supplied, as the API cannot return additional room rates on a dateless search.  Including `allRoomTypes=true` in your query will automatically limit your response size to no more than 200 hotels.  Including `allRoomTypes=true` and `contentDetails=high` will limit your response size to no more than 5 hotels.
         */
        fun allRoomTypes(allRoomTypes: kotlin.Boolean) = apply { this.allRoomTypes = allRoomTypes }

        /**
         * @param links  Comma-separated list to specify the types of deep links. - WD (link to Web Details site) - WS (link to Web Search Result page) - AD (link for Details API) - RC (link for RateCalendar API) - WEB (include all website links) - API (links for Details and RateCalendar API)  There are two level of links returned in the API response: Property-level deeplinks and room-level deeplinks.  When requesting API deeplinks you will receive both a RateCalendar API link at the property level, and Details API links at the room level, since the Lodging Details API only displays information on rate plan offers.  When requesting AD deeplinks, you will <u>only</u> receive Details API links at the room level. `Links` node in property-level will be omitted.  If you are looking for more complete details on a single property via the API, you should do another search in the Lodging API for the single Hotel ID, with `contentDetails=high` to get all details back in return (note that you can only get back a maximum of 5 hotels when `contentDetails` is set to `high`).  **NOTE**: dateless searches will not return Details API links, since the Lodging Details API will only return details on a specific room offer for specific dates.
         */
        fun links(links: Links) = apply { this.links = links }

        /**
         * @param minStarRating The minimum star rating for hotels returned in the response.
         */
        fun minStarRating(minStarRating: MinStarRating) = apply { this.minStarRating = minStarRating }

        /**
         * @param maxStarRating The maximum star rating for hotels returned in the response.
         */
        fun maxStarRating(maxStarRating: MaxStarRating) = apply { this.maxStarRating = maxStarRating }

        /**
         * @param limit The maximum number of hotels returned in the response. Must be an integer greater than 0.  If the value is greater than 1000, only the first 1000 hotels are returned.  Settings on `contentDetails` and `allRoomTypes` parameters may cause this value to be overridden and a lower number of hotels to be returned.  The `limit` parameter is intended to be used to control the response size, but partners should be careful about combining it with other filter parameters, as each parameter that you add will shrink the response, even to the point where you may even get a \"no hotel found\" error if none of the hotels in the base response meet the combined filter requirements.  Filters are cumulative in effect, and results must meet all filter requirements to be displayed.
         */
        fun limit(limit: kotlin.Long) = apply { this.limit = limit }

        /**
         * @param queryText Query text is used for a full text search of hotel data.  Text search based on hotel name, description, address, promotion description, amenities description.
         */
        fun queryText(queryText: kotlin.String) = apply { this.queryText = queryText }

        /**
         * @param availOnly Specifies whether to return only available hotels in the search results.  If the value of this parameter is true, the search results will only return hotels that have availability during the requested dates.  If there are no hotels with availability in your search then an empty record set will be returned.  This parameter is ignored for dateless searches.
         */
        fun availOnly(availOnly: kotlin.Boolean) = apply { this.availOnly = availOnly }

        /**
         * @param smokingPreference Specifies smoking preference.
         */
        fun smokingPreference(smokingPreference: SmokingPreference) = apply { this.smokingPreference = smokingPreference }

        /**
         * @param rateType Indicate which type of `paymentMethod` for each room will be returned.
         */
        fun rateType(rateType: RateType) = apply { this.rateType = rateType }

        /**
         * @param imageSizes Indicates what size images will be displayed for `hotelPhotos` and `roomPhotos` are returned when `contentDetails=high`.  The available image sizes are: - t : Thumbnail - s : Small - b : Big - y : 500x500v - z : 1000x1000v  Resolution from smallest to largest is t < s < b < y < z.  If no `imageSizes` is specified, the t size images will be returned.  If an image is missing in one size, we will try to fall back to the same image with lower resolution.  (If image \"_z\" is not available, we will try to return image \"_y\", and if it is also unavailable, we will return image \"_b\", and so on.)  Only one image size is allowed.
         */
        fun imageSizes(imageSizes: ImageSizes) = apply { this.imageSizes = imageSizes }

        /**
         * @param thumbnailImageSize Indicate what size of image will be used for the single `thumbnail` image that is returned when `contentDetails` is set to `low`, `medium` or `high`.  The available thumbnail image sizes are: - t : Thumbnail - s : Small - b : Big - y : 500x500v - z : 1000x1000v  Resolution from smallest to largest is t < s < b < y < z.  If no `thumbnailImageSize` is specified, the t size images will be returned.  if no thumbnail image found, it would not return thumbnail image.  Only one thumbnail image size is allowed.
         */
        fun thumbnailImageSize(thumbnailImageSize: ThumbnailImageSize) = apply { this.thumbnailImageSize = thumbnailImageSize }

        /**
         * @param includedPropertyTypeIds Only return hotels where the `PropertyType` ID is one of the IDs in the `includedPropertyTypeIds` field.  If the API query includes the parameter `contentDetail=lowest` the `PropertyType` parameter will not be returned in the response. Even in this case, the filtering is still being applied, even though there is no `PropertyType` parameter in the response with which to validate.  `includedPropertyTypeIds` and `excludedPropertyTypeIds` fields are mutually exclusive - which means that each query may contain **one** of the parameters, or **neither** of the parameters, but the query may not contain **both** of the parameters.  A complete list of supported Expedia Property Types can be found in [Lodging Property Types](https://developers.expediagroup.com/xap/products/xap/lodging/references/property-types).
         */
        fun includedPropertyTypeIds(includedPropertyTypeIds: kotlin.String) = apply { this.includedPropertyTypeIds = includedPropertyTypeIds }

        /**
         * @param excludedPropertyTypeIds Return all hotels **except** those whose `PropertyType` ID is in the `excludedPropertyTypeIds` field.  If the API query includes the parameter `contentDetail=lowest` the `PropertyType` parameter will not be returned in the response. Even in this case, the filtering is still being applied, even though there is no `PropertyType` parameter in the response with which to validate.  `includedPropertyTypeIds` and `excludedPropertyTypeIds` fields are mutually exclusive - which means that each query may contain **one** of the parameters, or **neither** of the parameters, but the query may not contain **both** of the parameters.  A complete list of supported Expedia Property Types can be found in [Lodging Property Types](https://developers.expediagroup.com/xap/products/xap/lodging/references/property-types).
         */
        fun excludedPropertyTypeIds(excludedPropertyTypeIds: kotlin.String) = apply { this.excludedPropertyTypeIds = excludedPropertyTypeIds }

        /**
         * @param includedInventorySourceIds Querying with no `includedInventorySourceIds` parameter will return listings from all available inventory sources.  Query with the `includedInventorySourceIds` parameter included will only return listings from the requested inventory sources. All others will be left out.  `includedInventorySourceId=24` will return only Expedia lodging inventory.  `includedInventorySourceId=83` will return only Vrbo lodging inventory.  `includedInventorySourceId=24,83` will return both Expedia and Vrbo lodging inventory.
         */
        fun includedInventorySourceIds(includedInventorySourceIds: kotlin.String) = apply { this.includedInventorySourceIds = includedInventorySourceIds }

        /**
         * @param freeCancellation Specifies whether to return only free cancelable room rates in the search results.  If the value of this parameter is true, the search results will only return hotels that have free cancelable room rates during the requested dates.  If there are no hotels with free cancelable room rates in your search then an empty record set will be returned.  Default value is false, if query without this parameter or the value of this parameter is false, all available room rates will be returned.  This parameter is ignored for dateless searches.
         */
        fun freeCancellation(freeCancellation: kotlin.Boolean) = apply { this.freeCancellation = freeCancellation }

        /**
         * @param groupedAmenities Specifies whether to return the grouped amenities. If `groupedAmenities` is true, `DescriptiveAmenities` node will be returned in response, otherwise `Amenities` node will be returned.
         */
        fun groupedAmenities(groupedAmenities: kotlin.Boolean) = apply { this.groupedAmenities = groupedAmenities }

        /**
         * @param blockFullDepositRateplan Specifies whether to return `rateplan` with `FullDepositUponBooking` as true.  If `blockFullDepositRateplans` is true, the search results will not return `rateplan` with `FullDepositUponBooking` as true.  The default value is false, if query without this parameter or the value of this parameter is false, all available rateplan will be returned.  This parameter is ignored for dateless search.
         */
        fun blockFullDepositRateplan(blockFullDepositRateplan: kotlin.Boolean) = apply { this.blockFullDepositRateplan = blockFullDepositRateplan }

        /**
         * @param ratePlanType **Note**: This parameter is visible to partners only by configuration. Please contact your Expedia Account Manager if you need this parameter.  To specify the desired rate plan types. The options are: - standalone : Ask for standalone rates - package : Ask for package rates, but standalone rate also may be returned if available.  Otherwise only standalone rate plans will be returned.  `WebSearchResult` and `WebDetails` links won't be returned for package rate.
         */
        fun ratePlanType(ratePlanType: RatePlanType) = apply { this.ratePlanType = ratePlanType }

        /**
         * @param sortType Specifies the field that the search results will be ordered by.  To be used in conjunction with sortOrder parameter below.  **CMA Compliance Note (UK)**: partners doing business in the UK should be sorting their search results using the `totalpricewithfees` parameter in their query string so that the sorting complies with CMA regulations.
         */
        fun sortType(sortType: SortType) = apply { this.sortType = sortType }

        /**
         * @param sortOrder Specifies the sort order of search results.  If no sort order is specified, the default is `asc`. But for deals sorting, it only supports `desc`.  To be used in conjunction with the `sortType` parameter above.
         */
        fun sortOrder(sortOrder: SortOrder) = apply { this.sortOrder = sortOrder }

        fun rooms(rooms: List<Room>) =
            apply {
                rooms.elementAtOrNull(0)?.let {
                    this.room1Adults = it.adults
                    this.room1ChildAges = it.children?.joinToString(",")
                }

                rooms.elementAtOrNull(1)?.let {
                    this.room2Adults = it.adults
                    this.room2ChildAges = it.children?.joinToString(",")
                }

                rooms.elementAtOrNull(2)?.let {
                    this.room3Adults = it.adults
                    this.room3ChildAges = it.children?.joinToString(",")
                }

                rooms.elementAtOrNull(3)?.let {
                    this.room4Adults = it.adults
                    this.room4ChildAges = it.children?.joinToString(",")
                }

                rooms.elementAtOrNull(4)?.let {
                    this.room5Adults = it.adults
                    this.room5ChildAges = it.children?.joinToString(",")
                }

                rooms.elementAtOrNull(5)?.let {
                    this.room6Adults = it.adults
                    this.room6ChildAges = it.children?.joinToString(",")
                }

                rooms.elementAtOrNull(6)?.let {
                    this.room7Adults = it.adults
                    this.room7ChildAges = it.children?.joinToString(",")
                }

                rooms.elementAtOrNull(7)?.let {
                    this.room8Adults = it.adults
                    this.room8ChildAges = it.children?.joinToString(",")
                }
            }

        fun build(): GetLodgingListingsOperationParams {
            validateNullity()

            return GetLodgingListingsOperationParams(
                partnerTransactionId = partnerTransactionId!!,
                ecomHotelIds = ecomHotelIds,
                hcomHotelIds = hcomHotelIds,
                geoLocation = geoLocation,
                radius = radius,
                unit = unit,
                locationKeyword = locationKeyword,
                regionIds = regionIds,
                checkIn = checkIn,
                checkOut = checkOut,
                locale = locale,
                currency = currency,
                source = source,
                travelWithPets = travelWithPets,
                contentDetails = contentDetails,
                allRoomTypes = allRoomTypes,
                links = links,
                minStarRating = minStarRating,
                maxStarRating = maxStarRating,
                limit = limit,
                queryText = queryText,
                availOnly = availOnly,
                smokingPreference = smokingPreference,
                rateType = rateType,
                imageSizes = imageSizes,
                thumbnailImageSize = thumbnailImageSize,
                includedPropertyTypeIds = includedPropertyTypeIds,
                excludedPropertyTypeIds = excludedPropertyTypeIds,
                includedInventorySourceIds = includedInventorySourceIds,
                freeCancellation = freeCancellation,
                groupedAmenities = groupedAmenities,
                blockFullDepositRateplan = blockFullDepositRateplan,
                ratePlanType = ratePlanType,
                sortType = sortType,
                sortOrder = sortOrder,
                room1Adults = room1Adults,
                room1ChildAges = room1ChildAges,
                room2Adults = room2Adults,
                room2ChildAges = room2ChildAges,
                room3Adults = room3Adults,
                room3ChildAges = room3ChildAges,
                room4Adults = room4Adults,
                room4ChildAges = room4ChildAges,
                room5Adults = room5Adults,
                room5ChildAges = room5ChildAges,
                room6Adults = room6Adults,
                room6ChildAges = room6ChildAges,
                room7Adults = room7Adults,
                room7ChildAges = room7ChildAges,
                room8Adults = room8Adults,
                room8ChildAges = room8ChildAges
            )
        }

        private fun validateNullity() {
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
            ecomHotelIds?.also {
                put(
                    "ecomHotelIds",
                    listOf(ecomHotelIds)
                )
            }
            hcomHotelIds?.also {
                put(
                    "hcomHotelIds",
                    listOf(hcomHotelIds)
                )
            }
            geoLocation?.also {
                put(
                    "geoLocation",
                    listOf(geoLocation)
                )
            }
            radius?.also {
                put(
                    "radius",
                    listOf(radius.toString())
                )
            }
            unit?.also {
                put(
                    "unit",
                    listOf(unit.value)
                )
            }
            locationKeyword?.also {
                put(
                    "locationKeyword",
                    listOf(locationKeyword)
                )
            }
            regionIds?.also {
                put(
                    "regionIds",
                    listOf(regionIds)
                )
            }
            checkIn?.also {
                put(
                    "checkIn",
                    listOf(checkIn.toString())
                )
            }
            checkOut?.also {
                put(
                    "checkOut",
                    listOf(checkOut.toString())
                )
            }
            locale?.also {
                put(
                    "locale",
                    listOf(locale)
                )
            }
            currency?.also {
                put(
                    "currency",
                    listOf(currency)
                )
            }
            source?.also {
                put(
                    "source",
                    listOf(source.value)
                )
            }
            travelWithPets?.also {
                put(
                    "travelWithPets",
                    listOf(travelWithPets.toString())
                )
            }
            contentDetails?.also {
                put(
                    "contentDetails",
                    listOf(contentDetails.value)
                )
            }
            allRoomTypes?.also {
                put(
                    "allRoomTypes",
                    listOf(allRoomTypes.toString())
                )
            }
            links?.also {
                put(
                    "links",
                    listOf(links.value)
                )
            }
            minStarRating?.also {
                put(
                    "minStarRating",
                    listOf(minStarRating.value)
                )
            }
            maxStarRating?.also {
                put(
                    "maxStarRating",
                    listOf(maxStarRating.value)
                )
            }
            limit?.also {
                put(
                    "limit",
                    listOf(limit.toString())
                )
            }
            queryText?.also {
                put(
                    "queryText",
                    listOf(queryText)
                )
            }
            availOnly?.also {
                put(
                    "availOnly",
                    listOf(availOnly.toString())
                )
            }
            smokingPreference?.also {
                put(
                    "smokingPreference",
                    listOf(smokingPreference.value)
                )
            }
            rateType?.also {
                put(
                    "rateType",
                    listOf(rateType.value)
                )
            }
            imageSizes?.also {
                put(
                    "imageSizes",
                    listOf(imageSizes.value)
                )
            }
            thumbnailImageSize?.also {
                put(
                    "thumbnailImageSize",
                    listOf(thumbnailImageSize.value)
                )
            }
            includedPropertyTypeIds?.also {
                put(
                    "includedPropertyTypeIds",
                    listOf(includedPropertyTypeIds)
                )
            }
            excludedPropertyTypeIds?.also {
                put(
                    "excludedPropertyTypeIds",
                    listOf(excludedPropertyTypeIds)
                )
            }
            includedInventorySourceIds?.also {
                put(
                    "includedInventorySourceIds",
                    listOf(includedInventorySourceIds)
                )
            }
            freeCancellation?.also {
                put(
                    "freeCancellation",
                    listOf(freeCancellation.toString())
                )
            }
            groupedAmenities?.also {
                put(
                    "groupedAmenities",
                    listOf(groupedAmenities.toString())
                )
            }
            blockFullDepositRateplan?.also {
                put(
                    "blockFullDepositRateplan",
                    listOf(blockFullDepositRateplan.toString())
                )
            }
            ratePlanType?.also {
                put(
                    "ratePlanType",
                    listOf(ratePlanType.value)
                )
            }
            sortType?.also {
                put(
                    "sortType",
                    listOf(sortType.value)
                )
            }
            sortOrder?.also {
                put(
                    "sortOrder",
                    listOf(sortOrder.value)
                )
            }
            room1Adults?.also {
                put(
                    "room1.adults",
                    listOf(room1Adults.toString())
                )
            }
            room1ChildAges?.also {
                put(
                    "room1.childAges",
                    listOf(room1ChildAges)
                )
            }
            room2Adults?.also {
                put(
                    "room2.adults",
                    listOf(room2Adults.toString())
                )
            }
            room2ChildAges?.also {
                put(
                    "room2.childAges",
                    listOf(room2ChildAges)
                )
            }
            room3Adults?.also {
                put(
                    "room3.adults",
                    listOf(room3Adults.toString())
                )
            }
            room3ChildAges?.also {
                put(
                    "room3.childAges",
                    listOf(room3ChildAges)
                )
            }
            room4Adults?.also {
                put(
                    "room4.adults",
                    listOf(room4Adults.toString())
                )
            }
            room4ChildAges?.also {
                put(
                    "room4.childAges",
                    listOf(room4ChildAges)
                )
            }
            room5Adults?.also {
                put(
                    "room5.adults",
                    listOf(room5Adults.toString())
                )
            }
            room5ChildAges?.also {
                put(
                    "room5.childAges",
                    listOf(room5ChildAges)
                )
            }
            room6Adults?.also {
                put(
                    "room6.adults",
                    listOf(room6Adults.toString())
                )
            }
            room6ChildAges?.also {
                put(
                    "room6.childAges",
                    listOf(room6ChildAges)
                )
            }
            room7Adults?.also {
                put(
                    "room7.adults",
                    listOf(room7Adults.toString())
                )
            }
            room7ChildAges?.also {
                put(
                    "room7.childAges",
                    listOf(room7ChildAges)
                )
            }
            room8Adults?.also {
                put(
                    "room8.adults",
                    listOf(room8Adults.toString())
                )
            }
            room8ChildAges?.also {
                put(
                    "room8.childAges",
                    listOf(room8ChildAges)
                )
            }
        }
    }

    override fun getPathParams(): Map<String, String> {
        return buildMap {
        }
    }
}
