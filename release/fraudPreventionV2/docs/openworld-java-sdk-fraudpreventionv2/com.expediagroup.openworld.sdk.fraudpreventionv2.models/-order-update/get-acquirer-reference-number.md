//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[OrderUpdate](index.md)/[getAcquirerReferenceNumber](get-acquirer-reference-number.md)

# getAcquirerReferenceNumber

[JVM]\

public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getAcquirerReferenceNumber](get-acquirer-reference-number.md)()

#### Parameters

JVM

| | |
|---|---|
| acquirerReferenceNumber | A unique number that tags a credit or debit card transaction when it goes from the merchant's bank through to the cardholder's bank. `acquirer_reference_number` is a required field only if `order_status` = `COMPLETED` Typically, merchants can get this number from their payment processors. This number is used when dealing with disputes/chargebacks on original transactions. |
