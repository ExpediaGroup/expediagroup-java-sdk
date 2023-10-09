//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[SettledRefundUpdateDetails](index.md)/[SettledRefundUpdateDetails](-settled-refund-update-details.md)

# SettledRefundUpdateDetails

[JVM]\

public [SettledRefundUpdateDetails](index.md)[SettledRefundUpdateDetails](-settled-refund-update-details.md)([OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)refundSettlementDateTime, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)refundDepositDateTime, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)acquirerReferenceNumber, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)settlementId, [Amount](../-amount/index.md)refundSettledAmount)

#### Parameters

JVM

| | |
|---|---|
| refundSettlementDateTime | Date and time when the 3rd party payment processor confirmed that a previously submitted payment refund has settled at the participating financial institutions. |
| refundDepositDateTime | Date and time when the refund was deposited to the original form of payment. |
| acquirerReferenceNumber | A unique number that tags a credit or debit card transaction when it goes from the merchant's bank through to the cardholder's bank. Typically, merchants can get this number from their payment processors. This number is used when dealing with disputes/chargebacks on original transactions. |
| settlementId | Unique settlement identifier specific to the payment processor for the settlement transaction generated for a previously submitted payment refund. |
| refundSettledAmount |
