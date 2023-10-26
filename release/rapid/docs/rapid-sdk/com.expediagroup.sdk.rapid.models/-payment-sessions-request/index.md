//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PaymentSessionsRequest](index.md)

# PaymentSessionsRequest

public final class [PaymentSessionsRequest](index.md)

#### Parameters

JVM

| | |
|---|---|
| version | The version of the EgPayments.js library. |
| browserAcceptHeader | The customer's browser accept header that was used in the booking request. |
| encodedBrowserMetadata | Encoded browser metadata, provided by the EgPayments.js library. |
| preferredChallengeWindowSize | The preferred window size that needs to be displayed to the customer. Following are the possible values of this field:   * `extra_small`: 250 x 400   * `small`: 390 x 400   * `medium`: 600 x 400   * `large`: 500 x 600   * `full_screen`: Full screen |
| merchantUrl | Fully qualified URL of merchant website or customer care site. |
| customerAccountDetails |
| payments |

## Constructors

| | |
|---|---|
| [PaymentSessionsRequest](-payment-sessions-request.md) | [JVM]<br>public [PaymentSessionsRequest](index.md)[PaymentSessionsRequest](-payment-sessions-request.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)version, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)browserAcceptHeader, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)encodedBrowserMetadata, [PaymentSessionsRequest.PreferredChallengeWindowSize](-preferred-challenge-window-size/index.md)preferredChallengeWindowSize, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantUrl, [PaymentSessionsRequestCustomerAccountDetails](../-payment-sessions-request-customer-account-details/index.md)customerAccountDetails, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentRequest](../-payment-request/index.md)&gt;payments) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [PreferredChallengeWindowSize](-preferred-challenge-window-size/index.md) | [JVM]<br>public enum [PreferredChallengeWindowSize](-preferred-challenge-window-size/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[PaymentSessionsRequest.PreferredChallengeWindowSize](-preferred-challenge-window-size/index.md)&gt;<br>The preferred window size that needs to be displayed to the customer. Following are the possible values of this field:   * `extra_small`: 250 x 400   * `small`: 390 x 400   * `medium`: 600 x 400   * `large`: 500 x 600   * `full_screen`: Full screen Values: EXTRA_SMALL,SMALL,MEDIUM,LARGE,FULL_SCREEN |

## Properties

| Name | Summary |
|---|---|
| [browserAcceptHeader](index.md#-754566182%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[browserAcceptHeader](index.md#-754566182%2FProperties%2F700308213) |
| [customerAccountDetails](index.md#-1195395184%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [PaymentSessionsRequestCustomerAccountDetails](../-payment-sessions-request-customer-account-details/index.md)[customerAccountDetails](index.md#-1195395184%2FProperties%2F700308213) |
| [encodedBrowserMetadata](index.md#964627354%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[encodedBrowserMetadata](index.md#964627354%2FProperties%2F700308213) |
| [merchantUrl](index.md#-1355704432%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[merchantUrl](index.md#-1355704432%2FProperties%2F700308213) |
| [payments](index.md#1240254198%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentRequest](../-payment-request/index.md)&gt;[payments](index.md#1240254198%2FProperties%2F700308213) |
| [preferredChallengeWindowSize](index.md#1529889616%2FProperties%2F700308213) | [JVM]<br>private final [PaymentSessionsRequest.PreferredChallengeWindowSize](-preferred-challenge-window-size/index.md)[preferredChallengeWindowSize](index.md#1529889616%2FProperties%2F700308213) |
| [version](index.md#-1290099873%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[version](index.md#-1290099873%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [PaymentSessionsRequest.Builder](-builder/index.md)[builder](builder.md)() |
| [getBrowserAcceptHeader](get-browser-accept-header.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getBrowserAcceptHeader](get-browser-accept-header.md)() |
| [getCustomerAccountDetails](get-customer-account-details.md) | [JVM]<br>public final [PaymentSessionsRequestCustomerAccountDetails](../-payment-sessions-request-customer-account-details/index.md)[getCustomerAccountDetails](get-customer-account-details.md)() |
| [getEncodedBrowserMetadata](get-encoded-browser-metadata.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEncodedBrowserMetadata](get-encoded-browser-metadata.md)() |
| [getMerchantUrl](get-merchant-url.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getMerchantUrl](get-merchant-url.md)() |
| [getPayments](get-payments.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentRequest](../-payment-request/index.md)&gt;[getPayments](get-payments.md)() |
| [getPreferredChallengeWindowSize](get-preferred-challenge-window-size.md) | [JVM]<br>public final [PaymentSessionsRequest.PreferredChallengeWindowSize](-preferred-challenge-window-size/index.md)[getPreferredChallengeWindowSize](get-preferred-challenge-window-size.md)() |
| [getVersion](get-version.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getVersion](get-version.md)() |
