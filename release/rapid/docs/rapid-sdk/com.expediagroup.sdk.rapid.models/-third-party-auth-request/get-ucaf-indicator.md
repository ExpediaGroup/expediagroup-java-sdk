//[rapid-sdk](../../../index.md)/[com.expediagroup.sdk.rapid.models](../index.md)/[ThirdPartyAuthRequest](index.md)/[getUcafIndicator](get-ucaf-indicator.md)

# getUcafIndicator

[JVM]\

public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getUcafIndicator](get-ucaf-indicator.md)()

#### Parameters

JVM

| | |
|---|---|
| ucafIndicator | Only received for Mastercard transactions, else can be null. 0 - Non-SecureCode transaction, bypassed by the Merchant 1 - Merchant-Only SecureCode transaction 2 - Fully authenticated SecureCode transaction |
