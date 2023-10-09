//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[TransactionDetails](index.md)/[getOrderType](get-order-type.md)

# getOrderType

[JVM]\

public final [TransactionDetails.OrderType](-order-type/index.md)[getOrderType](get-order-type.md)()

#### Parameters

JVM

| | |
|---|---|
| orderType | Type of order. Possible `order_types`.  `CREATE` - Initial type of a brand new order.  `CHANGE` - If a `OrderPurchaseScreenRequest` has already been submitted for the initial booking with `order_type = CREATE`, but has now been modified and partner wishes to resubmit for Fraud screening then the `order_type = CHANGE`. Examples of changes that are supported are changes made to `check-in/checkout dates` or `price of a TravelProduct`. |
