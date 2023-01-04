
# TransactionDetails

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**orderId** | **kotlin.String** | Unique identifier assigned to the order by the partner. &#x60;order_id&#x60; is specific to the partner namespace. | 
**currentOrderStatus** | [**inline**](#CurrentOrderStatus) | Status of the order. | 
**orderType** | [**inline**](#OrderType) | Type of order. Possible &#x60;order_types&#x60;.  &#x60;CREATE&#x60; - Initial type of a brand new order.  &#x60;CHANGE&#x60; - If a &#x60;OrderPurchaseScreenRequest&#x60; has already been submitted for the initial booking with &#x60;order_type &#x3D; CREATE&#x60;, but has now been modified and partner wishes to resubmit for Fraud screening then the &#x60;order_type &#x3D; CHANGE&#x60;. Examples of changes that are supported are changes made to &#x60;check-in/checkout dates&#x60; or &#x60;price of a TravelProduct&#x60;.  | 
**travelProducts** | [**kotlin.collections.List&lt;TravelProduct&gt;**](TravelProduct.md) |  | 
**travelers** | [**kotlin.collections.List&lt;Traveler&gt;**](Traveler.md) | Individuals who are part of the travel party for the order. At minimum there must be at least &#x60;1&#x60; traveler. | 
**payments** | [**kotlin.collections.List&lt;Payment&gt;**](Payment.md) | List of the form(s) of payment being used to purchase the order.  One or more forms of payment can be used within an order. Information gathered will be specific to the form of payment. | 
**creditCardAuthenticationFailureCount** | **kotlin.Int** | Total authentication failure count for given credit card. Authentication failures happen when a cardholder enters their card information incorrectly. |  [optional]


<a name="CurrentOrderStatus"></a>
## Enum: current_order_status
Name | Value
---- | -----
currentOrderStatus | IN_PROGRESS, COMPLETED


<a name="OrderType"></a>
## Enum: order_type
Name | Value
---- | -----
orderType | CREATE, CHANGE



