
# Telephone

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**countryAccessCode** | **kotlin.String** | Numeric digit between 1 to 3 characters used to represent the country code for international dialing.  Does not include symbols, spaces, or leading zeros. | 
**areaCode** | **kotlin.String** | A number prefixed to an individual telephone number: used in making long-distance calls.  Does not include symbols, spaces, or leading zeros. | 
**phoneNumber** | **kotlin.String** | A number that is dialed on a telephone, without the country or area codes, to reach a particular person, business, etc.  Does not include symbols, spaces, or leading zeros. | 
**type** | [**TelephoneType**](TelephoneType.md) |  |  [optional]
**platformType** | [**TelephonePlatformType**](TelephonePlatformType.md) |  |  [optional]
**fullPhoneNumber** | **kotlin.String** | The concatenated countryAccessCode, areaCode, and phoneNumber with leading zeros from the original fields and symbols  (-,.+) removed.  It does not include a phone extension. |  [optional]
**extensionNumber** | **kotlin.String** | The number used to reach an individual once a phone connection is established.  Does not include symbols, spaces, or leading zeros. |  [optional]
**preferenceRank** | [**java.math.BigDecimal**](java.math.BigDecimal.md) | Ranking of order of user preference for contact via text (if type is Mobile) or voice.  &#x60;0&#x60; means no preference.  &#x60;1&#x60; is the primary phone, &#x60;2&#x60; is the secondary phone, etc. |  [optional]
**lastVerifiedTimestamp** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Local date and time user validated possession of their phone number via a text or voice multi factor authentication challenge, in ISO-8061 date and time format &#x60;yyyy-MM-ddTHH:mm:ss.SSSZ&#x60;. |  [optional]
**verifiedFlag** | **kotlin.Boolean** | Flag indicating whether user passed validation of possession of their phone number via a text or voice multi factor authentication challenge. |  [optional]



