//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Traveler](index.md)

# Traveler

public final class [Traveler](index.md)

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

## Constructors

| | |
|---|---|
| [Traveler](-traveler.md) | [JVM]<br>public [Traveler](index.md)[Traveler](-traveler.md)([Name](../-name/index.md)travelerName, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)primary, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)emailAddress, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)age, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)birthDate, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)citizenshipCountryCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)travelerId) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [age](index.md#158567337%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[age](index.md#158567337%2FProperties%2F-173342751) |
| [birthDate](index.md#-72238309%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[birthDate](index.md#-72238309%2FProperties%2F-173342751) |
| [citizenshipCountryCode](index.md#-1221687213%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[A-Z]{3}$&quot;)<br>@Length(min = 3, max = 3)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[citizenshipCountryCode](index.md#-1221687213%2FProperties%2F-173342751) |
| [emailAddress](index.md#635325018%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[emailAddress](index.md#635325018%2FProperties%2F-173342751) |
| [primary](index.md#-1481207162%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[primary](index.md#-1481207162%2FProperties%2F-173342751) |
| [telephones](index.md#-1916548285%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 250)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[telephones](index.md#-1916548285%2FProperties%2F-173342751) |
| [travelerId](index.md#764246736%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 100)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[travelerId](index.md#764246736%2FProperties%2F-173342751) |
| [travelerName](index.md#902975456%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Name](../-name/index.md)[travelerName](index.md#902975456%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Traveler.Builder](-builder/index.md)[builder](builder.md)() |
| [getAge](get-age.md) | [JVM]<br>public final [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)[getAge](get-age.md)() |
| [getBirthDate](get-birth-date.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getBirthDate](get-birth-date.md)() |
| [getCitizenshipCountryCode](get-citizenship-country-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCitizenshipCountryCode](get-citizenship-country-code.md)() |
| [getEmailAddress](get-email-address.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEmailAddress](get-email-address.md)() |
| [getPrimary](get-primary.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getPrimary](get-primary.md)() |
| [getTelephones](get-telephones.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[getTelephones](get-telephones.md)() |
| [getTravelerId](get-traveler-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTravelerId](get-traveler-id.md)() |
| [getTravelerName](get-traveler-name.md) | [JVM]<br>public final [Name](../-name/index.md)[getTravelerName](get-traveler-name.md)() |
