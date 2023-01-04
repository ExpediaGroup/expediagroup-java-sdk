
# Traveler

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**travelerName** | [**Name**](Name.md) |  | 
**emailAddress** | **kotlin.String** | Email address associated with the traveler as supplied by the partner system. | 
**telephones** | [**kotlin.collections.List&lt;Telephone&gt;**](Telephone.md) |  | 
**primary** | **kotlin.Boolean** | Indicator for one of the travelers who is the primary traveler. One traveler in each itinerary item must be listed as primary. By default, for a single traveler this should be set to &#x60;true&#x60;. | 
**age** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | Age of the traveler. |  [optional]
**birthDate** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Date of birth for traveler, in ISO-8061 date and time format &#x60;yyyy-MM-ddTHH:mm:ss.SSSZ&#x60;. |  [optional]
**citizenshipCountryCode** | **kotlin.String** | The alpha-3 ISO country code of the traveler&#39;s nationality. |  [optional]
**travelerId** | **kotlin.String** | A unique identifier for travelers in the transaction. |  [optional]



