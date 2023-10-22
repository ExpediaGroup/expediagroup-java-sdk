//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[PaymentBillingAddress](index.md)

# PaymentBillingAddress

public final class [PaymentBillingAddress](index.md)

#### Parameters

JVM

| | |
|---|---|
| addressLine1 | Address line 1 of the address provided. |
| city | City of the address provided. |
| zipCode | Zip code of the address provided. |
| countryCode | ISO alpha-3 country code of the address provided. |
| addressType |
| addressLine2 | Address line 2 of the address provided. |
| state | The two-characters ISO code for the state or province of the address. |

## Constructors

| | |
|---|---|
| [PaymentBillingAddress](-payment-billing-address.md) | [JVM]<br>public [PaymentBillingAddress](index.md)[PaymentBillingAddress](-payment-billing-address.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)addressLine1, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)city, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)zipCode, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)countryCode, [PaymentBillingAddress.AddressType](-address-type/index.md)addressType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)addressLine2, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)state) |

## Types

| Name | Summary |
|---|---|
| [AddressType](-address-type/index.md) | [JVM]<br>public enum [AddressType](-address-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[PaymentBillingAddress.AddressType](-address-type/index.md)&gt;<br>Values: HOME,WORK |
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [addressLine1](index.md#1020139335%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[addressLine1](index.md#1020139335%2FProperties%2F-173342751) |
| [addressLine2](index.md#1051159142%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[addressLine2](index.md#1051159142%2FProperties%2F-173342751) |
| [addressType](index.md#-992832196%2FProperties%2F-173342751) | [JVM]<br>private final [PaymentBillingAddress.AddressType](-address-type/index.md)[addressType](index.md#-992832196%2FProperties%2F-173342751) |
| [city](index.md#1499859525%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[city](index.md#1499859525%2FProperties%2F-173342751) |
| [countryCode](index.md#1141904775%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[A-Z]{3}$&quot;)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[countryCode](index.md#1141904775%2FProperties%2F-173342751) |
| [state](index.md#-369851111%2FProperties%2F-173342751) | [JVM]<br>@Pattern(regexp = &quot;^[A-Z]{2}$&quot;)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[state](index.md#-369851111%2FProperties%2F-173342751) |
| [zipCode](index.md#-772230052%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 20)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[zipCode](index.md#-772230052%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentBillingAddress.Builder](-builder/index.md)[builder](builder.md)() |
| [getAddressLine1](get-address-line1.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAddressLine1](get-address-line1.md)() |
| [getAddressLine2](get-address-line2.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAddressLine2](get-address-line2.md)() |
| [getAddressType](get-address-type.md) | [JVM]<br>public final [PaymentBillingAddress.AddressType](-address-type/index.md)[getAddressType](get-address-type.md)() |
| [getCity](get-city.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCity](get-city.md)() |
| [getCountryCode](get-country-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCountryCode](get-country-code.md)() |
| [getState](get-state.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getState](get-state.md)() |
| [getZipCode](get-zip-code.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getZipCode](get-zip-code.md)() |
