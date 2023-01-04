
# ChargebackDetail

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**chargebackReason** | [**inline**](#ChargebackReason) | Reason for chargeback which can be &#x60;Fraud&#x60; or &#x60;Non Fraud&#x60;. | 
**chargebackAmount** | **kotlin.Double** | Chargeback amount received by the partner. | 
**currencyCode** | **kotlin.String** | The 3-letter currency code defined in ISO 4217. https://www.currency-iso.org/dam/downloads/lists/list_one.xml. | 
**bankReasonCode** | **kotlin.String** | Unique code provided by the acquiring bank for the category of fraud. |  [optional]
**chargebackReportedTimestamp** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | Date and time when the chargeback was reported to the partner, in ISO-8061 date and time format &#x60;yyyy-MM-ddTHH:mm:ss.SSSZ&#x60;. |  [optional]


<a name="ChargebackReason"></a>
## Enum: chargeback_reason
Name | Value
---- | -----
chargebackReason | FRAUD, NON_FRAUD



