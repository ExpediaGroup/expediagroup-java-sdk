//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Phone](index.md)

# Phone

public final class [Phone](index.md)

The entire phone number must be represented across the three fields in this object.

#### Parameters

JVM

| | |
|---|---|
| countryCode | The numerical portion of the country code from the phone number. Do not include the leading '+' character. |
| areaCode | The area code of the phone number. |
| number | The remaining digits of the phone number. |

## Constructors

| | |
|---|---|
| [Phone](-phone.md) | [JVM]<br>public [Phone](index.md)[Phone](-phone.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countryCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)areaCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)number) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [areaCode](index.md#389912217%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[areaCode](index.md#389912217%2FProperties%2F700308213) |
| [countryCode](index.md#959203588%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[countryCode](index.md#959203588%2FProperties%2F700308213) |
| [number](index.md#848410570%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[number](index.md#848410570%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Phone.Builder](-builder/index.md)[builder](builder.md)() |
| [getAreaCode](get-area-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAreaCode](get-area-code.md)() |
| [getCountryCode](get-country-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCountryCode](get-country-code.md)() |
| [getNumber](get-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getNumber](get-number.md)() |
