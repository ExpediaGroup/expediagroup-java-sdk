//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[ThirdPartyAuthRequest](index.md)/[ThirdPartyAuthRequest](-third-party-auth-request.md)

# ThirdPartyAuthRequest

[JVM]\

public [ThirdPartyAuthRequest](index.md)[ThirdPartyAuthRequest](-third-party-auth-request.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cavv, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)eci, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)threeDsVersion, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)dsTransactionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paResStatus, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)veResStatus, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)xid, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cavvAlgorithm, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)ucafIndicator)

#### Parameters

JVM

| | |
|---|---|
| cavv | Cryptographic element used to indicate Authentication was successfully performed |
| eci | Electronic Commerce Indicator. The ECI is used in payer authentication to indicate the level of security used when the cardholder provided payment information to the merchant. Its value corresponds to the authentication result and the characteristics of the merchant checkout process. Each card network, e.g., Visa, MasterCard, JCB, has specific rules around the appropriate values and use of the ECI. |
| threeDsVersion | Indicates what version of 3DS was used to authenticate the user. |
| dsTransactionId | Directory Server Transaction Id. Returned during authentication and is used as an additional parameter to validate that transaction was authenticated. |
| paResStatus | set only if PAResStatus value is received in the authentication response |
| veResStatus | set this only if PAResStatus value is received in the authentication response if Authentication was Frictionless → AuthenticationResponse.PAResStatus, if Authentication was a successful challenge → \&quot;C\&quot; (This is the directory response for challenge) |
| xid | String used by both Visa and MasterCard which identifies a specific transaction on the Directory This string value should remain consistent throughout a transaction's history. |
| cavvAlgorithm | Used in some scenarios for 3DS 1.0. |
| ucafIndicator | Only received for Mastercard transactions, else can be null. 0 - Non-SecureCode transaction, bypassed by the Merchant 1 - Merchant-Only SecureCode transaction 2 - Fully authenticated SecureCode transaction |
