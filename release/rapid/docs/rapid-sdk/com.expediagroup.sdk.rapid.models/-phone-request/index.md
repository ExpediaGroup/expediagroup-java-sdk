//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PhoneRequest](index.md)

# PhoneRequest

public final class [PhoneRequest](index.md)

The entire phone number must be represented across the three fields in this object. The entire phone number should not exceed 25 characters.

#### Parameters

JVM

| | |
|---|---|
| countryCode | The numerical portion of the country code from the phone number. Do not include the leading '+' character. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| number | The remaining digits of the phone number. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| areaCode | The area code of the phone number. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |

## Constructors

| | |
|---|---|
| [PhoneRequest](-phone-request.md) | [JVM]<br>public [PhoneRequest](index.md)[PhoneRequest](-phone-request.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countryCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)number, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)areaCode) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [areaCode](index.md#-1027777122%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[areaCode](index.md#-1027777122%2FProperties%2F700308213) |
| [countryCode](index.md#-1010472993%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[countryCode](index.md#-1010472993%2FProperties%2F700308213) |
| [number](index.md#1995537423%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[number](index.md#1995537423%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PhoneRequest.Builder](-builder/index.md)[builder](builder.md)() |
| [getAreaCode](get-area-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAreaCode](get-area-code.md)() |
| [getCountryCode](get-country-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCountryCode](get-country-code.md)() |
| [getNumber](get-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getNumber](get-number.md)() |
