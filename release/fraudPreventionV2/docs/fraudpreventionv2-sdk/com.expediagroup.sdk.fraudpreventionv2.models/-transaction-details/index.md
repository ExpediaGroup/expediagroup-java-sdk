//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[TransactionDetails](index.md)

# TransactionDetails

public final class [TransactionDetails](index.md)

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

## Constructors

| | |
|---|---|
| [TransactionDetails](-transaction-details.md) | [JVM]<br>public [TransactionDetails](index.md)[TransactionDetails](-transaction-details.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)orderId, [TransactionDetails.CurrentOrderStatus](-current-order-status/index.md)currentOrderStatus, [TransactionDetails.OrderType](-order-type/index.md)orderType, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[TravelProduct](../-travel-product/index.md)&gt;travelProducts, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Traveler](../-traveler/index.md)&gt;travelers, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Payment](../-payment/index.md)&gt;payments) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |
| [CurrentOrderStatus](-current-order-status/index.md) | [JVM]<br>public enum [CurrentOrderStatus](-current-order-status/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[TransactionDetails.CurrentOrderStatus](-current-order-status/index.md)&gt;<br>Status of the order: * `IN_PROGRESS` is used when order has not processed fully. For example, inventory has not yet been reserved, or payment has not yet been settled. * `COMPLETED` is used when an order has been processed fully. For example, inventory has been reserved, and the payment has been settled. Values: IN_PROGRESS,COMPLETED |
| [OrderType](-order-type/index.md) | [JVM]<br>public enum [OrderType](-order-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[TransactionDetails.OrderType](-order-type/index.md)&gt;<br>Type of order. Possible `order_types`.  `CREATE` - Initial type of a brand new order.  `CHANGE` - If a `OrderPurchaseScreenRequest` has already been submitted for the initial booking with `order_type = CREATE`, but has now been modified and partner wishes to resubmit for Fraud screening then the `order_type = CHANGE`. Examples of changes that are supported are changes made to `check-in/checkout dates` or `price of a TravelProduct`. Values: CREATE,CHANGE |

## Properties

| Name | Summary |
|---|---|
| [currentOrderStatus](index.md#-1185732344%2FProperties%2F-173342751) | [JVM]<br>private final [TransactionDetails.CurrentOrderStatus](-current-order-status/index.md)[currentOrderStatus](index.md#-1185732344%2FProperties%2F-173342751) |
| [orderId](index.md#-1823244030%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 50)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[orderId](index.md#-1823244030%2FProperties%2F-173342751) |
| [orderType](index.md#2040188867%2FProperties%2F-173342751) | [JVM]<br>private final [TransactionDetails.OrderType](-order-type/index.md)[orderType](index.md#2040188867%2FProperties%2F-173342751) |
| [payments](index.md#-1378774846%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 30)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Payment](../-payment/index.md)&gt;[payments](index.md#-1378774846%2FProperties%2F-173342751) |
| [travelers](index.md#151453663%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 30)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Traveler](../-traveler/index.md)&gt;[travelers](index.md#151453663%2FProperties%2F-173342751) |
| [travelProducts](index.md#-2068233999%2FProperties%2F-173342751) | [JVM]<br>@Size(min = 1, max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[TravelProduct](../-travel-product/index.md)&gt;[travelProducts](index.md#-2068233999%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [TransactionDetails.Builder](-builder/index.md)[builder](builder.md)() |
| [getCurrentOrderStatus](get-current-order-status.md) | [JVM]<br>public final [TransactionDetails.CurrentOrderStatus](-current-order-status/index.md)[getCurrentOrderStatus](get-current-order-status.md)() |
| [getOrderId](get-order-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getOrderId](get-order-id.md)() |
| [getOrderType](get-order-type.md) | [JVM]<br>public final [TransactionDetails.OrderType](-order-type/index.md)[getOrderType](get-order-type.md)() |
| [getPayments](get-payments.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Payment](../-payment/index.md)&gt;[getPayments](get-payments.md)() |
| [getTravelers](get-travelers.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Traveler](../-traveler/index.md)&gt;[getTravelers](get-travelers.md)() |
| [getTravelProducts](get-travel-products.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[TravelProduct](../-travel-product/index.md)&gt;[getTravelProducts](get-travel-products.md)() |
