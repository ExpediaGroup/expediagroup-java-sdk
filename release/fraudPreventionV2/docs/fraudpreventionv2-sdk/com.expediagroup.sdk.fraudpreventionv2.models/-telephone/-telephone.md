//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Telephone](index.md)/[Telephone](-telephone.md)

# Telephone

[JVM]\

public [Telephone](index.md)[Telephone](-telephone.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countryAccessCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)areaCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)phoneNumber, [TelephoneType](../-telephone-type/index.md)type, [TelephonePlatformType](../-telephone-platform-type/index.md)platformType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)extensionNumber, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)preferenceRank, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)lastVerifiedDateTime, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)verifiedFlag)

#### Parameters

JVM

| | |
|---|---|
| countryAccessCode | Numeric digit between 1 to 3 characters used to represent the country code for international dialing.  Does not include symbols, spaces, or leading zeros. |
| areaCode | A number prefixed to an individual telephone number: used in making long-distance calls.  Does not include symbols, spaces, or leading zeros. |
| phoneNumber | A number that is dialed on a telephone, without the country or area codes, to reach a particular person, business, etc.  Does not include symbols, spaces, or leading zeros. |
| type |
| platformType |
| extensionNumber | The number used to reach an individual once a phone connection is established.  Does not include symbols, spaces, or leading zeros. |
| preferenceRank | Ranking of order of user preference for contact via text (if type is Mobile) or voice.  `0` means no preference.  `1` is the primary phone, `2` is the secondary phone, etc. |
| lastVerifiedDateTime | Local date and time user validated possession of their phone number via a text or voice multi factor authentication challenge, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| verifiedFlag | Flag indicating whether user passed validation of possession of their phone number via a text or voice multi factor authentication challenge. |
