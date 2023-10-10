//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Traveler](index.md)/[Traveler](-traveler.md)

# Traveler

[JVM]\

public [Traveler](index.md)[Traveler](-traveler.md)([Name](../-name/index.md)travelerName, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)primary, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)emailAddress, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)age, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)birthDate, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)citizenshipCountryCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)travelerId)

#### Parameters

JVM

| |
|---|
| travelerName |
| primary | Indicator for one of the travelers who is the primary traveler. One traveler in each itinerary item must be listed as primary. By default, for a single traveler this should be set to `true`. |
| emailAddress | Email address associated with the traveler as supplied by the partner system. |
| telephones |
| age | Age of the traveler. |
| birthDate | Date of birth for traveler, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| citizenshipCountryCode | The alpha-3 ISO country code of the traveler's nationality. |
| travelerId | A unique identifier for travelers in the transaction. |
