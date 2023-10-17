//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[CreateItineraryRequest](index.md)

# CreateItineraryRequest

public final class [CreateItineraryRequest](index.md)

#### Parameters

JVM

| | |
|---|---|
| email | Email address for the customer. Must adhere to standard RFC 822 email format. Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| phone |
| rooms |
| affiliateReferenceId | Your unique reference value. This field supports from 3 to a maximum of 28 characters and is required to be unique (if provided). Entering special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) in this field will result in the request being rejected. |
| hold | Flag for placing a booking on hold. The booking will be released if the resume link is not followed within the hold period. Please refer to our Hold and Resume documentation. |
| payments | Required if payment information prior to booking was not submitted. If register payments was called prior to this call, do not submit payment information again. |
| affiliateMetadata | Field that stores up to 256 characters of additional metadata with the itinerary. Will be returned on all retrieve responses for this itinerary. The data must be in the format 'key1:value|key2:value|key3:value'. Other Special characters (\&quot;<\&quot;, \&quot;>\&quot;, \&quot;(\&quot;, \&quot;)\&quot;, and \&quot;&\&quot;) entered in this field will be re-encoded. |
| taxRegistrationNumber | The customer's taxpayer identification number that is provided by the government to nationals or resident aliens. This number should be collected from individuals that pay taxes or participate in activities that provide revenue for one or more tax types. Note: This value is only needed from Brazilian and Indian customers. |
| travelerHandlingInstructions | Custom traveler handling instructions for the hotel. Do not include PCI sensitive data, such as credit card numbers, in this field. |

## Constructors

| | |
|---|---|
| [CreateItineraryRequest](-create-itinerary-request.md) | [JVM]<br>public [CreateItineraryRequest](index.md)[CreateItineraryRequest](-create-itinerary-request.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)email, [PhoneRequest](../-phone-request/index.md)phone, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CreateItineraryRequestRoom](../-create-itinerary-request-room/index.md)&gt;rooms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateReferenceId, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)hold, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentRequest](../-payment-request/index.md)&gt;payments, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)affiliateMetadata, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)taxRegistrationNumber, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)travelerHandlingInstructions) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [affiliateMetadata](index.md#-997264313%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[affiliateMetadata](index.md#-997264313%2FProperties%2F700308213) |
| [affiliateReferenceId](index.md#563079486%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[affiliateReferenceId](index.md#563079486%2FProperties%2F700308213) |
| [email](index.md#-1431684793%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[email](index.md#-1431684793%2FProperties%2F700308213) |
| [hold](index.md#-2090496648%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[hold](index.md#-2090496648%2FProperties%2F700308213) |
| [payments](index.md#-129692214%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentRequest](../-payment-request/index.md)&gt;[payments](index.md#-129692214%2FProperties%2F700308213) |
| [phone](index.md#546871221%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [PhoneRequest](../-phone-request/index.md)[phone](index.md#546871221%2FProperties%2F700308213) |
| [rooms](index.md#598911339%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CreateItineraryRequestRoom](../-create-itinerary-request-room/index.md)&gt;[rooms](index.md#598911339%2FProperties%2F700308213) |
| [taxRegistrationNumber](index.md#-1661907562%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[taxRegistrationNumber](index.md#-1661907562%2FProperties%2F700308213) |
| [travelerHandlingInstructions](index.md#439210342%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[travelerHandlingInstructions](index.md#439210342%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CreateItineraryRequest.Builder](-builder/index.md)[builder](builder.md)() |
| [getAffiliateMetadata](get-affiliate-metadata.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAffiliateMetadata](get-affiliate-metadata.md)() |
| [getAffiliateReferenceId](get-affiliate-reference-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAffiliateReferenceId](get-affiliate-reference-id.md)() |
| [getEmail](get-email.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEmail](get-email.md)() |
| [getHold](get-hold.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getHold](get-hold.md)() |
| [getPayments](get-payments.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentRequest](../-payment-request/index.md)&gt;[getPayments](get-payments.md)() |
| [getPhone](get-phone.md) | [JVM]<br>public final [PhoneRequest](../-phone-request/index.md)[getPhone](get-phone.md)() |
| [getRooms](get-rooms.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[CreateItineraryRequestRoom](../-create-itinerary-request-room/index.md)&gt;[getRooms](get-rooms.md)() |
| [getTaxRegistrationNumber](get-tax-registration-number.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTaxRegistrationNumber](get-tax-registration-number.md)() |
| [getTravelerHandlingInstructions](get-traveler-handling-instructions.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTravelerHandlingInstructions](get-traveler-handling-instructions.md)() |
