//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[GetInactivePropertiesOperationParams](index.md)

# GetInactivePropertiesOperationParams

[JVM]\
public final class [GetInactivePropertiesOperationParams](index.md) implements OperationParams

## Constructors

| | |
|---|---|
| [GetInactivePropertiesOperationParams](-get-inactive-properties-operation-params.md) | [JVM]<br>public [GetInactivePropertiesOperationParams](index.md)[GetInactivePropertiesOperationParams](-get-inactive-properties-operation-params.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)customerSessionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)since, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)token, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)platformName) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [billingTerms](index.md#1379050210%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[billingTerms](index.md#1379050210%2FProperties%2F700308213)<br>This parameter is to specify the terms of how a resulting booking should be billed. If this field is needed, the value for this will be provided to you separately. |
| [customerSessionId](index.md#-623720391%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[customerSessionId](index.md#-623720391%2FProperties%2F700308213)<br>Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session. |
| [partnerPointOfSale](index.md#645851304%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[partnerPointOfSale](index.md#645851304%2FProperties%2F700308213)<br>This parameter is to specify what point of sale is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [paymentTerms](index.md#1375415597%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[paymentTerms](index.md#1375415597%2FProperties%2F700308213)<br>This parameter is to specify what terms should be used when being paid for a resulting booking. If this field is needed, the value for this will be provided to you separately. |
| [platformName](index.md#2002819408%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[platformName](index.md#2002819408%2FProperties%2F700308213)<br>This parameter is to specify what platform is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [since](index.md#-898906766%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[since](index.md#-898906766%2FProperties%2F700308213)<br>Required on initial call, not accepted on subsequent paging links provided in response header.<br> The earliest date that a property became inactive to include in the results. ISO 8601 format (YYYY-MM-DD) |
| [token](index.md#1942668179%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[token](index.md#1942668179%2FProperties%2F700308213)<br>Only used for requesting additional pages of data. Provided by the `next` URL in the `Link` response header. |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [GetInactivePropertiesOperationParams.Builder](-builder/index.md)[builder](builder.md)() |
| [getBillingTerms](get-billing-terms.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBillingTerms](get-billing-terms.md)()<br>This parameter is to specify the terms of how a resulting booking should be billed. If this field is needed, the value for this will be provided to you separately. |
| [getCustomerSessionId](get-customer-session-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCustomerSessionId](get-customer-session-id.md)()<br>Insert your own unique value for each user session, beginning with the first API call. Continue to pass the same value for each subsequent API call during the user's session, using a new value for every new customer session.<br> Including this value greatly eases EPS's internal debugging process for issues with partner requests, as it explicitly links together request paths for individual user's session. |
| [getHeaders](get-headers.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getHeaders](get-headers.md)() |
| [getPartnerPointOfSale](get-partner-point-of-sale.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPartnerPointOfSale](get-partner-point-of-sale.md)()<br>This parameter is to specify what point of sale is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [getPathParams](get-path-params.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getPathParams](get-path-params.md)() |
| [getPaymentTerms](get-payment-terms.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPaymentTerms](get-payment-terms.md)()<br>This parameter is to specify what terms should be used when being paid for a resulting booking. If this field is needed, the value for this will be provided to you separately. |
| [getPlatformName](get-platform-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPlatformName](get-platform-name.md)()<br>This parameter is to specify what platform is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [getQueryParams](get-query-params.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Iterable](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getQueryParams](get-query-params.md)() |
| [getSince](get-since.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getSince](get-since.md)()<br>Required on initial call, not accepted on subsequent paging links provided in response header.<br> The earliest date that a property became inactive to include in the results. ISO 8601 format (YYYY-MM-DD) |
| [getToken](get-token.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getToken](get-token.md)()<br>Only used for requesting additional pages of data. Provided by the `next` URL in the `Link` response header. |
