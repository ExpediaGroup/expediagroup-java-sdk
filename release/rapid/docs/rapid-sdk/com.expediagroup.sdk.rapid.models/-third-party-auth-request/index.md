//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[ThirdPartyAuthRequest](index.md)

# ThirdPartyAuthRequest

public final class [ThirdPartyAuthRequest](index.md)

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

## Constructors

| | |
|---|---|
| [ThirdPartyAuthRequest](-third-party-auth-request.md) | [JVM]<br>public [ThirdPartyAuthRequest](index.md)[ThirdPartyAuthRequest](-third-party-auth-request.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cavv, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)eci, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)threeDsVersion, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)dsTransactionId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)paResStatus, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)veResStatus, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)xid, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)cavvAlgorithm, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)ucafIndicator) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [cavv](index.md#-1764405713%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cavv](index.md#-1764405713%2FProperties%2F700308213) |
| [cavvAlgorithm](index.md#-275649508%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[cavvAlgorithm](index.md#-275649508%2FProperties%2F700308213) |
| [dsTransactionId](index.md#-3800989%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[dsTransactionId](index.md#-3800989%2FProperties%2F700308213) |
| [eci](index.md#68770882%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[eci](index.md#68770882%2FProperties%2F700308213) |
| [paResStatus](index.md#-742076724%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[paResStatus](index.md#-742076724%2FProperties%2F700308213) |
| [threeDsVersion](index.md#93768994%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[threeDsVersion](index.md#93768994%2FProperties%2F700308213) |
| [ucafIndicator](index.md#209061073%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[ucafIndicator](index.md#209061073%2FProperties%2F700308213) |
| [veResStatus](index.md#681779210%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[veResStatus](index.md#681779210%2FProperties%2F700308213) |
| [xid](index.md#843361594%2FProperties%2F700308213) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[xid](index.md#843361594%2FProperties%2F700308213) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [ThirdPartyAuthRequest.Builder](-builder/index.md)[builder](builder.md)() |
| [getCavv](get-cavv.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCavv](get-cavv.md)() |
| [getCavvAlgorithm](get-cavv-algorithm.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getCavvAlgorithm](get-cavv-algorithm.md)() |
| [getDsTransactionId](get-ds-transaction-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getDsTransactionId](get-ds-transaction-id.md)() |
| [getEci](get-eci.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEci](get-eci.md)() |
| [getPaResStatus](get-pa-res-status.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getPaResStatus](get-pa-res-status.md)() |
| [getThreeDsVersion](get-three-ds-version.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getThreeDsVersion](get-three-ds-version.md)() |
| [getUcafIndicator](get-ucaf-indicator.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getUcafIndicator](get-ucaf-indicator.md)() |
| [getVeResStatus](get-ve-res-status.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getVeResStatus](get-ve-res-status.md)() |
| [getXid](get-xid.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getXid](get-xid.md)() |
