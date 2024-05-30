//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[GetPropertyCatalogFileOperationParams](index.md)

# GetPropertyCatalogFileOperationParams

[JVM]\
public final class [GetPropertyCatalogFileOperationParams](index.md) implements OperationParams

## Constructors

| | |
|---|---|
| [GetPropertyCatalogFileOperationParams](-get-property-catalog-file-operation-params.md) | [JVM]<br>public [GetPropertyCatalogFileOperationParams](index.md)[GetPropertyCatalogFileOperationParams](-get-property-catalog-file-operation-params.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)language, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)supplySource, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)platformName) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [billingTerms](index.md#1380269822%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[billingTerms](index.md#1380269822%2FProperties%2F700308213)<br>This parameter is to specify the terms of how a resulting booking should be billed. If this field is needed, the value for this will be provided to you separately. |
| [customerSessionId](index.md#2043239837%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[customerSessionId](index.md#2043239837%2FProperties%2F700308213)<br>Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session. |
| [language](index.md#118184818%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[language](index.md#118184818%2FProperties%2F700308213)<br>Desired language for the response as a subset of BCP47 format that only uses hyphenated pairs of two-digit language and country codes. Use only ISO 639-1 alpha-2 language codes and ISO 3166-1 alpha-2 country codes. See [https://www.w3.org/International/articles/language-tags/](https://www.w3.org/International/articles/language-tags/)  Language Options: [https://developers.expediagroup.com/docs/rapid/resources/reference/language-options](https://developers.expediagroup.com/docs/rapid/resources/reference/language-options) |
| [partnerPointOfSale](index.md#1717239748%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[partnerPointOfSale](index.md#1717239748%2FProperties%2F700308213)<br>This parameter is to specify what point of sale is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [paymentTerms](index.md#1376635209%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[paymentTerms](index.md#1376635209%2FProperties%2F700308213)<br>This parameter is to specify what terms should be used when being paid for a resulting booking. If this field is needed, the value for this will be provided to you separately. |
| [platformName](index.md#2004039020%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[platformName](index.md#2004039020%2FProperties%2F700308213)<br>This parameter is to specify what platform is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [supplySource](index.md#-1529578848%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[supplySource](index.md#-1529578848%2FProperties%2F700308213)<br>Options for which supply source you would like returned in the content response. This parameter may only be supplied once and will return all properties that match the requested supply source. An error is thrown if the parameter is provided multiple times.   * `expedia` - Standard Expedia supply.   * `vrbo` - VRBO supply - This option is restricted to partners who have VRBO supply enabled for their profile. See [Vacation Rentals](https://developers.expediagroup.com/docs/rapid/lodging/vacation-rentals) for more information. |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [GetPropertyCatalogFileOperationParams.Builder](-builder/index.md)[builder](builder.md)() |
| [getBillingTerms](get-billing-terms.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBillingTerms](get-billing-terms.md)()<br>This parameter is to specify the terms of how a resulting booking should be billed. If this field is needed, the value for this will be provided to you separately. |
| [getCustomerSessionId](get-customer-session-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCustomerSessionId](get-customer-session-id.md)()<br>Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session. |
| [getHeaders](get-headers.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getHeaders](get-headers.md)() |
| [getLanguage](get-language.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLanguage](get-language.md)()<br>Desired language for the response as a subset of BCP47 format that only uses hyphenated pairs of two-digit language and country codes. Use only ISO 639-1 alpha-2 language codes and ISO 3166-1 alpha-2 country codes. See [https://www.w3.org/International/articles/language-tags/](https://www.w3.org/International/articles/language-tags/)  Language Options: [https://developers.expediagroup.com/docs/rapid/resources/reference/language-options](https://developers.expediagroup.com/docs/rapid/resources/reference/language-options) |
| [getPartnerPointOfSale](get-partner-point-of-sale.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPartnerPointOfSale](get-partner-point-of-sale.md)()<br>This parameter is to specify what point of sale is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [getPaymentTerms](get-payment-terms.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPaymentTerms](get-payment-terms.md)()<br>This parameter is to specify what terms should be used when being paid for a resulting booking. If this field is needed, the value for this will be provided to you separately. |
| [getPlatformName](get-platform-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPlatformName](get-platform-name.md)()<br>This parameter is to specify what platform is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [getQueryParams](get-query-params.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Iterable](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getQueryParams](get-query-params.md)() |
| [getSupplySource](get-supply-source.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSupplySource](get-supply-source.md)()<br>Options for which supply source you would like returned in the content response. This parameter may only be supplied once and will return all properties that match the requested supply source. An error is thrown if the parameter is provided multiple times.   * `expedia` - Standard Expedia supply.   * `vrbo` - VRBO supply - This option is restricted to partners who have VRBO supply enabled for their profile. See [Vacation Rentals](https://developers.expediagroup.com/docs/rapid/lodging/vacation-rentals) for more information. |