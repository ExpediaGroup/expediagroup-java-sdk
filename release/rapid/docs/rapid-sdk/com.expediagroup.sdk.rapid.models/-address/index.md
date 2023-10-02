//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[Address](index.md)

# Address

public final class [Address](index.md)

Container for the property's address information.

#### Parameters

JVM

| | |
|---|---|
| line1 | Address line 1. |
| line2 | Address line 2. |
| city | City. |
| stateProvinceCode | 2-letter or 3-letter state/province code for Australia, Canada and the USA. |
| stateProvinceName | Text name of the State/Province - more common for additional countries. |
| postalCode | Postal/zip code. |
| countryCode | 2-letter country code, in ISO 3166-1 alpha-2 format. |
| obfuscationRequired | Flag to indicate whether a property address requires obfuscation before the property has been booked. If true, only the city, province, and country of the address can be shown to the customer. |
| localized |

## Constructors

| | |
|---|---|
| [Address](-address.md) | [JVM]<br>public [Address](index.md)[Address](-address.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)line1, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)line2, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)city, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)stateProvinceCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)stateProvinceName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)postalCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countryCode, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)obfuscationRequired, [Localized](../-localized/index.md)localized) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [city](index.md#-1956790354%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[city](index.md#-1956790354%2FProperties%2F700308213) |
| [countryCode](index.md#240003070%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[countryCode](index.md#240003070%2FProperties%2F700308213) |
| [line1](index.md#-1434158044%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[line1](index.md#-1434158044%2FProperties%2F700308213) |
| [line2](index.md#-1403138237%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[line2](index.md#-1403138237%2FProperties%2F700308213) |
| [localized](index.md#1449809702%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Localized](../-localized/index.md)[localized](index.md#1449809702%2FProperties%2F700308213) |
| [obfuscationRequired](index.md#-2066793409%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[obfuscationRequired](index.md#-2066793409%2FProperties%2F700308213) |
| [postalCode](index.md#-221102239%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[postalCode](index.md#-221102239%2FProperties%2F700308213) |
| [stateProvinceCode](index.md#1832403347%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[stateProvinceCode](index.md#1832403347%2FProperties%2F700308213) |
| [stateProvinceName](index.md#202523317%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[stateProvinceName](index.md#202523317%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Address.Builder](-builder/index.md)[builder](builder.md)() |
| [getCity](get-city.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCity](get-city.md)() |
| [getCountryCode](get-country-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCountryCode](get-country-code.md)() |
| [getLine1](get-line1.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLine1](get-line1.md)() |
| [getLine2](get-line2.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLine2](get-line2.md)() |
| [getLocalized](get-localized.md) | [JVM]<br>public final [Localized](../-localized/index.md)[getLocalized](get-localized.md)() |
| [getObfuscationRequired](get-obfuscation-required.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getObfuscationRequired](get-obfuscation-required.md)() |
| [getPostalCode](get-postal-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPostalCode](get-postal-code.md)() |
| [getStateProvinceCode](get-state-province-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getStateProvinceCode](get-state-province-code.md)() |
| [getStateProvinceName](get-state-province-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getStateProvinceName](get-state-province-name.md)() |
