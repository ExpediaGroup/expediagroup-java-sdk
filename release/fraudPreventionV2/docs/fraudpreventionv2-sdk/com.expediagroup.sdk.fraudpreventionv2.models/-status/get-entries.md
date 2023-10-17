//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Status](index.md)/[getEntries](get-entries.md)

# getEntries

[JVM]\

public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[Status](index.md)&gt;[getEntries](get-entries.md)()

Defines the current state of the Order. Generally, OrderPurchaseScreenRequest is followed by an OrderUpdate reflecting the change in current order status. From `IN_PROGRESS` to any of below possible values: * `COMPLETED` is used when the order has been processed fully. For example, inventory has been reserved, and the payment has been settled. * `CHANGE_COMPLETED` is like `COMPLETED` but on a changed order. * `CANCELLED` is used when the order is cancelled. This could be acustomer initiated cancel or based on Fraud recommendation. * `FAILED` is used when order failed due to any errors on Partner system. This could be followed by another OrderUpdate call with any `order_status` once the order is recovered, abandoned, or cancelled. * `CHANGE_FAILED` is like `FAILED` but on a changed order. * * `CHANGE_COMPLETED` or `CHANGE_FAILED` are applicable if OrderPurchaseScreen Fraud API was called via a change in order which is through `transaction.transaction_details.order_type` = `CHANGE` * `COMPLETED` or `CANCELLED` order status indicates the completion of lifecycle on an order. Values: COMPLETED,CHANGE_COMPLETED,CANCELLED,FAILED,CHANGE_FAILED
