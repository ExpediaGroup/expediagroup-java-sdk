//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[TransactionDetails](index.md)/[TransactionDetails](-transaction-details.md)

# TransactionDetails

[JVM]\

public [TransactionDetails](index.md)[TransactionDetails](-transaction-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)orderId, [TransactionDetails.CurrentOrderStatus](-current-order-status/index.md)currentOrderStatus, [TransactionDetails.OrderType](-order-type/index.md)orderType, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[TravelProduct](../-travel-product/index.md)&gt;travelProducts, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Traveler](../-traveler/index.md)&gt;travelers, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Payment](../-payment/index.md)&gt;payments)

#### Parameters

JVM

| | |
|---|---|
| orderId | Unique identifier assigned to the order by the partner. `order_id` is specific to the partner namespace. |
| currentOrderStatus | Status of the order: * `IN_PROGRESS` is used when order has not processed fully. For example, inventory has not yet been reserved, or payment has not yet been settled. * `COMPLETED` is used when an order has been processed fully. For example, inventory has been reserved, and the payment has been settled. |
| orderType | Type of order. Possible `order_types`.  `CREATE` - Initial type of a brand new order.  `CHANGE` - If a `OrderPurchaseScreenRequest` has already been submitted for the initial booking with `order_type = CREATE`, but has now been modified and partner wishes to resubmit for Fraud screening then the `order_type = CHANGE`. Examples of changes that are supported are changes made to `check-in/checkout dates` or `price of a TravelProduct`. |
| travelProducts |
| travelers | Individuals who are part of the travel party for the order. At minimum there must be at least `1` traveler. |
| payments | List of the form(s) of payment being used to purchase the order.  One or more forms of payment can be used within an order. Information gathered will be specific to the form of payment. |
