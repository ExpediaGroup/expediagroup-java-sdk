
# TravelProduct

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**price** | [**Amount**](Amount.md) |  | 
**type** | **kotlin.String** | Type of product advertised on the website. | 
**inventoryType** | **kotlin.String** | Type of inventory. | 
**inventorySource** | [**inline**](#InventorySource) | Identifies the business model through which the supply is being sold. Merchant/Agency. | 
**travelersReferences** | **kotlin.collections.List&lt;kotlin.String&gt;** | List of travelerGuids who are part of the traveling party on the order for the product. | 


<a name="InventorySource"></a>
## Enum: inventory_source
Name | Value
---- | -----
inventorySource | MERCHANT, AGENCY



