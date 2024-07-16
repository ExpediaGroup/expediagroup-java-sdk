//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.operations](../index.md)/[RequestUndeliveredNotificationsOperationParams](index.md)

# RequestUndeliveredNotificationsOperationParams

[JVM]\
public final class [RequestUndeliveredNotificationsOperationParams](index.md) implements OperationParams

## Constructors

| | |
|---|---|
| [RequestUndeliveredNotificationsOperationParams](-request-undelivered-notifications-operation-params.md) | [JVM]<br>public [RequestUndeliveredNotificationsOperationParams](index.md)[RequestUndeliveredNotificationsOperationParams](-request-undelivered-notifications-operation-params.md)([Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)undeliverable, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)partnerPointOfSale, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paymentTerms, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)platformName) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [billingTerms](index.md#149921994%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[billingTerms](index.md#149921994%2FProperties%2F700308213)<br>This parameter is to specify the terms of how a resulting booking should be billed. If this field is needed, the value for this will be provided to you separately. |
| [partnerPointOfSale](index.md#1500502160%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[partnerPointOfSale](index.md#1500502160%2FProperties%2F700308213)<br>This parameter is to specify what point of sale is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [paymentTerms](index.md#146287381%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[paymentTerms](index.md#146287381%2FProperties%2F700308213)<br>This parameter is to specify what terms should be used when being paid for a resulting booking. If this field is needed, the value for this will be provided to you separately. |
| [platformName](index.md#773691192%2FProperties%2F700308213) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[platformName](index.md#773691192%2FProperties%2F700308213)<br>This parameter is to specify what platform is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [undeliverable](index.md#-2102115714%2FProperties%2F700308213) | [JVM]<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[undeliverable](index.md#-2102115714%2FProperties%2F700308213)<br>Undeliverable notifications are returned when this parameter is set to `true`. |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [RequestUndeliveredNotificationsOperationParams.Builder](-builder/index.md)[builder](builder.md)() |
| [getBillingTerms](get-billing-terms.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBillingTerms](get-billing-terms.md)()<br>This parameter is to specify the terms of how a resulting booking should be billed. If this field is needed, the value for this will be provided to you separately. |
| [getHeaders](get-headers.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getHeaders](get-headers.md)() |
| [getPartnerPointOfSale](get-partner-point-of-sale.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPartnerPointOfSale](get-partner-point-of-sale.md)()<br>This parameter is to specify what point of sale is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [getPathParams](get-path-params.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;[getPathParams](get-path-params.md)() |
| [getPaymentTerms](get-payment-terms.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPaymentTerms](get-payment-terms.md)()<br>This parameter is to specify what terms should be used when being paid for a resulting booking. If this field is needed, the value for this will be provided to you separately. |
| [getPlatformName](get-platform-name.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPlatformName](get-platform-name.md)()<br>This parameter is to specify what platform is being used to shop and book. If this field is needed, the value for this will be provided to you separately. |
| [getQueryParams](get-query-params.md) | [JVM]<br>public [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html), [Iterable](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)&lt;[String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)&gt;&gt;[getQueryParams](get-query-params.md)() |
| [getUndeliverable](get-undeliverable.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getUndeliverable](get-undeliverable.md)()<br>Undeliverable notifications are returned when this parameter is set to `true`. |
