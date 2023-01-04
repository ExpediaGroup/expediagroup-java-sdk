
# CustomerAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountType** | [**inline**](#AccountType) | Identifies if the customer account is known to the client. Possible values are:  -&#x60;GUEST&#x60; - Applicable if the partner maintains record to distinguish whether the transaction was booked via a guest account.  -&#x60;STANDARD&#x60; - Default account type.  | 
**name** | [**Name**](Name.md) |  | 
**emailAddress** | **kotlin.String** | Email address for the account owner. | 
**userId** | **kotlin.String** | Unique identifier assigned to the account owner by the partner. &#x60;user_id&#x60; is specific to the partner namespace |  [optional]
**telephones** | [**kotlin.collections.List&lt;Telephone&gt;**](Telephone.md) |  |  [optional]
**address** | [**Address**](Address.md) |  |  [optional]
**registeredTime** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) | The local date and time that the customer first registered on the client site, in ISO-8061 date and time format &#x60;yyyy-MM-ddTHH:mm:ss.SSSZ&#x60;. |  [optional]


<a name="AccountType"></a>
## Enum: account_type
Name | Value
---- | -----
accountType | GUEST, STANDARD



