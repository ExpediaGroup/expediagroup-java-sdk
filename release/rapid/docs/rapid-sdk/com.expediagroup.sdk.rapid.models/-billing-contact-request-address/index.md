//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[BillingContactRequestAddress](index.md)

# BillingContactRequestAddress

public final class [BillingContactRequestAddress](index.md)

#### Parameters

JVM

| | |
|---|---|
| countryCode | Customer's country code, in two-letter ISO 3166-1 alpha-2 format. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. Only ISO-8859-1 compliant characters are allowed. |
| line1 | First line of customer's street address. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. Only ISO-8859-1 compliant characters are allowed. |
| line2 | Second line of customer's street address. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. Only ISO-8859-1 compliant characters are allowed. |
| line3 | Third line of customer's street address. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. Only ISO-8859-1 compliant characters are allowed. |
| city | Customer's city. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. Only ISO-8859-1 compliant characters are allowed. |
| stateProvinceCode | Customer's state or province code. Mandatory for AU, CA and US. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. Only ISO-8859-1 compliant characters are allowed. |
| postalCode | Customer's postal code. Mandatory for CA, GB, and US. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. Only ISO-8859-1 compliant characters are allowed. |

## Constructors

| | |
|---|---|
| [BillingContactRequestAddress](-billing-contact-request-address.md) | [JVM]<br>public [BillingContactRequestAddress](index.md)[BillingContactRequestAddress](-billing-contact-request-address.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countryCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)line1, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)line2, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)line3, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)city, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)stateProvinceCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)postalCode) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [city](index.md#1791940822%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[city](index.md#1791940822%2FProperties%2F700308213) |
| [countryCode](index.md#1447948758%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[countryCode](index.md#1447948758%2FProperties%2F700308213) |
| [line1](index.md#-1187608580%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[line1](index.md#-1187608580%2FProperties%2F700308213) |
| [line2](index.md#-1156588773%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[line2](index.md#-1156588773%2FProperties%2F700308213) |
| [line3](index.md#-1125568966%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[line3](index.md#-1125568966%2FProperties%2F700308213) |
| [postalCode](index.md#2034621065%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[postalCode](index.md#2034621065%2FProperties%2F700308213) |
| [stateProvinceCode](index.md#-524334741%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[stateProvinceCode](index.md#-524334741%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [BillingContactRequestAddress.Builder](-builder/index.md)[builder](builder.md)() |
| [getCity](get-city.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCity](get-city.md)() |
| [getCountryCode](get-country-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCountryCode](get-country-code.md)() |
| [getLine1](get-line1.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLine1](get-line1.md)() |
| [getLine2](get-line2.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLine2](get-line2.md)() |
| [getLine3](get-line3.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLine3](get-line3.md)() |
| [getPostalCode](get-postal-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPostalCode](get-postal-code.md)() |
| [getStateProvinceCode](get-state-province-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getStateProvinceCode](get-state-province-code.md)() |
