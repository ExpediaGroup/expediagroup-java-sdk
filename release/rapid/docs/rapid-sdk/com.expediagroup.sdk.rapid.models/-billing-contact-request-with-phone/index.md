//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[BillingContactRequestWithPhone](index.md)

# BillingContactRequestWithPhone

public final class [BillingContactRequestWithPhone](index.md)

#### Parameters

JVM

| | |
|---|---|
| givenName | First/given name of the payment type account holder. Max 60 characters. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| familyName | Last/family name of the payment type account holder. Max 60 characters. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| address |
| phone |

## Constructors

| | |
|---|---|
| [BillingContactRequestWithPhone](-billing-contact-request-with-phone.md) | [JVM]<br>public [BillingContactRequestWithPhone](index.md)[BillingContactRequestWithPhone](-billing-contact-request-with-phone.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)givenName, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)familyName, [BillingContactRequestAddress](../-billing-contact-request-address/index.md)address, [PhoneRequest](../-phone-request/index.md)phone) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [address](index.md#-16500335%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [BillingContactRequestAddress](../-billing-contact-request-address/index.md)[address](index.md#-16500335%2FProperties%2F700308213) |
| [familyName](index.md#-698724794%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[familyName](index.md#-698724794%2FProperties%2F700308213) |
| [givenName](index.md#248714845%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[givenName](index.md#248714845%2FProperties%2F700308213) |
| [phone](index.md#-607746217%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [PhoneRequest](../-phone-request/index.md)[phone](index.md#-607746217%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [BillingContactRequestWithPhone.Builder](-builder/index.md)[builder](builder.md)() |
| [getAddress](get-address.md) | [JVM]<br>public final [BillingContactRequestAddress](../-billing-contact-request-address/index.md)[getAddress](get-address.md)() |
| [getFamilyName](get-family-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getFamilyName](get-family-name.md)() |
| [getGivenName](get-given-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getGivenName](get-given-name.md)() |
| [getPhone](get-phone.md) | [JVM]<br>public final [PhoneRequest](../-phone-request/index.md)[getPhone](get-phone.md)() |
