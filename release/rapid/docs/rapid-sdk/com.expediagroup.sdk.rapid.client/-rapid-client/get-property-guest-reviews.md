//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.client](../index.md)/[RapidClient](index.md)/[getPropertyGuestReviews](get-property-guest-reviews.md)

# getPropertyGuestReviews

[JVM]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [GuestReviews](../../com.expediagroup.sdk.rapid.models/-guest-reviews/index.md)[getPropertyGuestReviews](get-property-guest-reviews.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)language, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)platformName, [UUID](https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html)transactionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [GuestReviews](../../com.expediagroup.sdk.rapid.models/-guest-reviews/index.md)[getPropertyGuestReviews](get-property-guest-reviews.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)language, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)platformName)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [GuestReviews](../../com.expediagroup.sdk.rapid.models/-guest-reviews/index.md)[getPropertyGuestReviews](get-property-guest-reviews.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)language, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [GuestReviews](../../com.expediagroup.sdk.rapid.models/-guest-reviews/index.md)[getPropertyGuestReviews](get-property-guest-reviews.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)language, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [GuestReviews](../../com.expediagroup.sdk.rapid.models/-guest-reviews/index.md)[getPropertyGuestReviews](get-property-guest-reviews.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)language, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [GuestReviews](../../com.expediagroup.sdk.rapid.models/-guest-reviews/index.md)[getPropertyGuestReviews](get-property-guest-reviews.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)language, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId)

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

public final [GuestReviews](../../com.expediagroup.sdk.rapid.models/-guest-reviews/index.md)[getPropertyGuestReviews](get-property-guest-reviews.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)propertyId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)language)

Property Guest Reviews <i>Note: Property Guest Reviews are only available if your account is configured for access and all launch requirements have been followed. Please find the launch requirements here [https://support.expediapartnersolutions.com/hc/en-us/articles/360008646799](https://support.expediapartnersolutions.com/hc/en-us/articles/360008646799) and contact your Account Manager for more details.</i>  The response is an individual Guest Reviews object containing multiple guest reviews for the requested active property.  To ensure you always show the latest guest reviews, this call should be made whenever a customer looks at the details for a specific property.

#### Return

GuestReviews

#### Parameters

JVM

| | |
|---|---|
| language | Desired language for the response as a subset of BCP47 format that only uses hyphenated pairs of two-digit language and country codes. Use only ISO 639-1 alpha-2 language codes and ISO 3166-1 alpha-2 country codes. See [https://www.w3.org/International/articles/language-tags/](https://www.w3.org/International/articles/language-tags/)  Language Options: [https://developers.expediagroup.com/docs/rapid/resources/reference/language-options](https://developers.expediagroup.com/docs/rapid/resources/reference/language-options) |
| billingTerms | This parameter is to specify the terms of how a resulting booking should be billed. If this field is needed, the value for this will be provided to you separately.  (optional) |
| paymentTerms | This parameter is to specify what terms should be used when being paid for a resulting booking. If this field is needed, the value for this will be provided to you separately.  (optional) |
| partnerPointOfSale | This parameter is to specify what point of sale is being used to shop and book. If this field is needed, the value for this will be provided to you separately.  (optional) |
| platformName | This parameter is to specify what platform is being used to shop and book. If this field is needed, the value for this will be provided to you separately.  (optional) |

#### Throws

| |
|---|
| [ExpediaGroupApiErrorException](../../com.expediagroup.sdk.rapid.models.exception/-expedia-group-api-error-exception/index.md) |
