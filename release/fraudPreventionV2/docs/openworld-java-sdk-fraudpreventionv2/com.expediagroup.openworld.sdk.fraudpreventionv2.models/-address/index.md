//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[Address](index.md)

# Address

public final class [Address](index.md)

#### Parameters

JVM

| |
|---|
| addressType |
| addressLine1 | Address line 1 of the address provided. |
| addressLine2 | Address line 2 of the address provided. |
| city | City of the address provided. |
| state | The two-characters ISO code for the state or province of the address. |
| zipCode | Zip code of the address provided. |
| countryCode | ISO alpha-3 country code of the address provided. |

## Constructors

| | |
|---|---|
| [Address](-address.md) | [JVM]<br>public [Address](index.md)[Address](-address.md)([Address.AddressType](-address-type/index.md)addressType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)addressLine1, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)addressLine2, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)city, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)state, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)zipCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countryCode) |

## Types

| Name | Summary |
|---|---|
| [AddressType](-address-type/index.md) | [JVM]<br>public enum [AddressType](-address-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Address.AddressType](-address-type/index.md)&gt;<br>Values: HOME,WORK |
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [Address.Builder](-builder/index.md)[builder](builder.md)() |
| [getAddressLine1](get-address-line1.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAddressLine1](get-address-line1.md)() |
| [getAddressLine2](get-address-line2.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAddressLine2](get-address-line2.md)() |
| [getAddressType](get-address-type.md) | [JVM]<br>public final [Address.AddressType](-address-type/index.md)[getAddressType](get-address-type.md)() |
| [getCity](get-city.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCity](get-city.md)() |
| [getCountryCode](get-country-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCountryCode](get-country-code.md)() |
| [getState](get-state.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getState](get-state.md)() |
| [getZipCode](get-zip-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getZipCode](get-zip-code.md)() |

## Properties

| Name | Summary |
|---|---|
| [addressLine1](index.md#414579394%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[addressLine1](index.md#414579394%2FProperties%2F-1883119931) |
| [addressLine2](index.md#445599201%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[addressLine2](index.md#445599201%2FProperties%2F-1883119931) |
| [addressType](index.md#-319629727%2FProperties%2F-1883119931) | [JVM]<br>private final [Address.AddressType](-address-type/index.md)[addressType](index.md#-319629727%2FProperties%2F-1883119931) |
| [city](index.md#-1227188032%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[city](index.md#-1227188032%2FProperties%2F-1883119931) |
| [countryCode](index.md#1815107244%2FProperties%2F-1883119931) | [JVM]<br>@Pattern(regexp = &quot;^[A-Z]{3}$&quot;)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[countryCode](index.md#1815107244%2FProperties%2F-1883119931) |
| [state](index.md#991020542%2FProperties%2F-1883119931) | [JVM]<br>@Pattern(regexp = &quot;^[A-Z]{2}$&quot;)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[state](index.md#991020542%2FProperties%2F-1883119931) |
| [zipCode](index.md#1355370497%2FProperties%2F-1883119931) | [JVM]<br>@Length(max = 20)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[zipCode](index.md#1355370497%2FProperties%2F-1883119931) |
