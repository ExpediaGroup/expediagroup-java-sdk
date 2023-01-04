
# Payment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**brand** | **kotlin.String** | Payment brand used for payment on this transaction. | 
**method** | [**PaymentMethod**](PaymentMethod.md) |  | 
**billingName** | [**Name**](Name.md) |  | 
**reason** | [**PaymentReason**](PaymentReason.md) |  |  [optional]
**billingAddress** | [**Address**](Address.md) |  |  [optional]
**billingEmailAddress** | **kotlin.String** | Email address associated with the payment. |  [optional]
**authorizedAmount** | [**Amount**](Amount.md) |  |  [optional]
**verifiedAmount** | [**Amount**](Amount.md) |  |  [optional]
**threeDigitsSecureCriteria** | [**PaymentThreeDSCriteria**](PaymentThreeDSCriteria.md) |  |  [optional]
**operations** | [**Operations**](Operations.md) |  |  [optional]
**totalRefundAmount** | **kotlin.Double** | Total amount refunded towards the transaction. |  [optional]



