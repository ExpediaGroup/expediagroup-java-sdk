//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[PaymentSessionsRequest](index.md)/[PaymentSessionsRequest](-payment-sessions-request.md)

# PaymentSessionsRequest

[JVM]\

public [PaymentSessionsRequest](index.md)[PaymentSessionsRequest](-payment-sessions-request.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)version, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)browserAcceptHeader, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)encodedBrowserMetadata, [PaymentSessionsRequest.PreferredChallengeWindowSize](-preferred-challenge-window-size/index.md)preferredChallengeWindowSize, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)merchantUrl, [PaymentSessionsRequestCustomerAccountDetails](../-payment-sessions-request-customer-account-details/index.md)customerAccountDetails, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[PaymentRequest](../-payment-request/index.md)&gt;payments)

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
