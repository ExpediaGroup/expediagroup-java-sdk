
# RefundUpdate

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**acquirerReferenceNumber** | **kotlin.String** | A unique number that tags a credit or debit card transaction when it goes from the merchant&#39;s bank through to the cardholder&#39;s bank. | 
**refundDepositTimestamp** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Date and time when the refund was deposited to the original form of payment. | 
**refundSettlementTimestamp** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Date and time when the 3rd party payment processor confirmed that a previously submitted payment refund has settled at the participating financial institutions. | 
**settlementId** | **kotlin.String** | Unique settlement identifier generated for a previously submitted payment refund. | 
**refundAmount** | [**Amount**](Amount.md) |  | 



