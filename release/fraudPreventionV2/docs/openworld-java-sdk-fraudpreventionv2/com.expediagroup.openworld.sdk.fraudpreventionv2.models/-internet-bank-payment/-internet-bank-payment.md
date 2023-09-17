//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[InternetBankPayment](index.md)/[InternetBankPayment](-internet-bank-payment.md)

# InternetBankPayment

[JVM]\

public [InternetBankPayment](index.md)[InternetBankPayment](-internet-bank-payment.md)([Payment.Brand](../-payment/-brand/index.md)brand, [Name](../-name/index.md)billingName, [PaymentBillingAddress](../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bankId, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)bankBranchCode, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [PaymentReason](../-payment-reason/index.md)reason, [Amount](../-amount/index.md)authorizedAmount, [Amount](../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../-operations/index.md)operations)

#### Parameters

JVM

| | |
|---|---|
| bankId | The bank_id provided by the internet bank payment(IBP) provider (DRWP aka NetGiro) for the bank used for processing the payment. |
| bankBranchCode | A code that identifies the bank branch for internet bank payment(IBP). |
| telephones | Telephone(s) associated with internet bank payment(IBP) provider. |
