//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[DirectDebit](index.md)/[DirectDebit](-direct-debit.md)

# DirectDebit

[JVM]\

public [DirectDebit](index.md)[DirectDebit](-direct-debit.md)([Payment.Brand](../-payment/-brand/index.md)brand, [Name](../-name/index.md)billingName, [PaymentBillingAddress](../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)routingNumber, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)accountNumber, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [PaymentReason](../-payment-reason/index.md)reason, [Amount](../-amount/index.md)authorizedAmount, [Amount](../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../-operations/index.md)operations)

#### Parameters

JVM

| | |
|---|---|
| routingNumber | A code that identifies the financial institution for a specific bank account. |
| accountNumber | Cleartext (unencrypted) DirectDebit bank account number associated with the payment instrument. |
| telephones | Telephone(s) associated with direct debit payment provider. |
