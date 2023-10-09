//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Telephone](index.md)

# Telephone

public final class [Telephone](index.md)

Group of attributes intended to hold information about phone number associated with the transaction.  A user can have one to many phone numbers (home, work, mobile, etc.).

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

## Constructors

| | |
|---|---|
| [Telephone](-telephone.md) | [JVM]<br>public [Telephone](index.md)[Telephone](-telephone.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countryAccessCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)areaCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)phoneNumber, [TelephoneType](../-telephone-type/index.md)type, [TelephonePlatformType](../-telephone-platform-type/index.md)platformType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)extensionNumber, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)preferenceRank, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)lastVerifiedDateTime, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)verifiedFlag) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [areaCode](index.md#-1290011749%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[0-9]{1,20}$&quot;)<br>@Length(max = 20)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[areaCode](index.md#-1290011749%2FProperties%2F-173342751) |
| [countryAccessCode](index.md#475860030%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[0-9]{1,3}$&quot;)<br>@Length(max = 3)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[countryAccessCode](index.md#475860030%2FProperties%2F-173342751) |
| [extensionNumber](index.md#871933597%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[0-9]{1,20}$&quot;)<br>@Length(max = 20)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[extensionNumber](index.md#871933597%2FProperties%2F-173342751) |
| [lastVerifiedDateTime](index.md#-781490340%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[lastVerifiedDateTime](index.md#-781490340%2FProperties%2F-173342751) |
| [phoneNumber](index.md#1855488910%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[0-9]{1,50}$&quot;)<br>@Length(max = 50)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[phoneNumber](index.md#1855488910%2FProperties%2F-173342751) |
| [platformType](index.md#813373640%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [TelephonePlatformType](../-telephone-platform-type/index.md)[platformType](index.md#813373640%2FProperties%2F-173342751) |
| [preferenceRank](index.md#-1115781458%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[preferenceRank](index.md#-1115781458%2FProperties%2F-173342751) |
| [type](index.md#6369403%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [TelephoneType](../-telephone-type/index.md)[type](index.md#6369403%2FProperties%2F-173342751) |
| [verifiedFlag](index.md#-1868043615%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[verifiedFlag](index.md#-1868043615%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Telephone.Builder](-builder/index.md)[builder](builder.md)() |
| [getAreaCode](get-area-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAreaCode](get-area-code.md)() |
| [getCountryAccessCode](get-country-access-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCountryAccessCode](get-country-access-code.md)() |
| [getExtensionNumber](get-extension-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getExtensionNumber](get-extension-number.md)() |
| [getLastVerifiedDateTime](get-last-verified-date-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getLastVerifiedDateTime](get-last-verified-date-time.md)() |
| [getPhoneNumber](get-phone-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPhoneNumber](get-phone-number.md)() |
| [getPlatformType](get-platform-type.md) | [JVM]<br>public final [TelephonePlatformType](../-telephone-platform-type/index.md)[getPlatformType](get-platform-type.md)() |
| [getPreferenceRank](get-preference-rank.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getPreferenceRank](get-preference-rank.md)() |
| [getType](get-type.md) | [JVM]<br>public final [TelephoneType](../-telephone-type/index.md)[getType](get-type.md)() |
| [getVerifiedFlag](get-verified-flag.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getVerifiedFlag](get-verified-flag.md)() |
