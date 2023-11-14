//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[DirectDebit](index.md)/[DirectDebit](-direct-debit.md)

# DirectDebit

[JVM]\

public [DirectDebit](index.md)[DirectDebit](-direct-debit.md)([Payment.Brand](../-payment/-brand/index.md)brand, [Name](../-name/index.md)billingName, [PaymentBillingAddress](../-payment-billing-address/index.md)billingAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)billingEmailAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)accountNumber, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [PaymentReason](../-payment-reason/index.md)reason, [Amount](../-amount/index.md)authorizedAmount, [Amount](../-amount/index.md)verifiedAmount, [PaymentThreeDSCriteria](../-payment-three-d-s-criteria/index.md)threeDigitsSecureCriteria, [Operations](../-operations/index.md)operations, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)routingNumber, [DirectDebit.MandateType](-mandate-type/index.md)mandateType)

#### Parameters

JVM

| | |
|---|---|
| accountNumber | Cleartext (unencrypted) DirectDebit bank account number associated with the payment instrument. |
| telephones | Telephone(s) associated with direct debit payment provider. |
| routingNumber | A code that identifies the financial institution for a specific bank account. `routing_number` is required if given `INTER_COMPANY` or `ELV` as `brand`. |
| mandateType | The `mandate_type` is required if given `brand` as `SEPA_ELV` under `DirectDebit`.  It is used for the wire transfer or direct debit transaction whose `routing_number` could not be provided or not supported.   Allows values:  - `ONE_OFF`  - `RECURRING` |
