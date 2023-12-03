//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[Status](index.md)

# Status

[JVM]\
public enum [Status](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[Status](index.md)&gt;

Defines the current state of the Order. Generally, OrderPurchaseScreenRequest is followed by an OrderUpdate reflecting the change in current order status. From `IN_PROGRESS` to any of below possible values: * `COMPLETED` is used when the order has been processed fully. For example, inventory has been reserved, and the payment has been settled. * `CHANGE_COMPLETED` is like `COMPLETED` but on a changed order. * `CANCELLED` is used when the order is cancelled. This could be acustomer initiated cancel or based on Fraud recommendation. * `FAILED` is used when order failed due to any errors on Partner system. This could be followed by another OrderUpdate call with any `order_status` once the order is recovered, abandoned, or cancelled. * `CHANGE_FAILED` is like `FAILED` but on a changed order. * * `CHANGE_COMPLETED` or `CHANGE_FAILED` are applicable if OrderPurchaseScreen Fraud API was called via a change in order which is through `transaction.transaction_details.order_type` = `CHANGE` * `COMPLETED` or `CANCELLED` order status indicates the completion of lifecycle on an order. Values: COMPLETED,CHANGE_COMPLETED,CANCELLED,FAILED,CHANGE_FAILED

## Entries

| | |
|---|---|
| [COMPLETED](-c-o-m-p-l-e-t-e-d/index.md) | [JVM]<br>[COMPLETED](-c-o-m-p-l-e-t-e-d/index.md) |
| [CHANGE_COMPLETED](-c-h-a-n-g-e_-c-o-m-p-l-e-t-e-d/index.md) | [JVM]<br>[CHANGE_COMPLETED](-c-h-a-n-g-e_-c-o-m-p-l-e-t-e-d/index.md) |
| [CANCELLED](-c-a-n-c-e-l-l-e-d/index.md) | [JVM]<br>[CANCELLED](-c-a-n-c-e-l-l-e-d/index.md) |
| [FAILED](-f-a-i-l-e-d/index.md) | [JVM]<br>[FAILED](-f-a-i-l-e-d/index.md) |
| [CHANGE_FAILED](-c-h-a-n-g-e_-f-a-i-l-e-d/index.md) | [JVM]<br>[CHANGE_FAILED](-c-h-a-n-g-e_-f-a-i-l-e-d/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#1948085037%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[Status](index.md)&gt;[entries](index.md#1948085037%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#561343852%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#561343852%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[Status](index.md)&gt;[getEntries](get-entries.md)()<br>Defines the current state of the Order. Generally, OrderPurchaseScreenRequest is followed by an OrderUpdate reflecting the change in current order status. From `IN_PROGRESS` to any of below possible values: * `COMPLETED` is used when the order has been processed fully. For example, inventory has been reserved, and the payment has been settled. * `CHANGE_COMPLETED` is like `COMPLETED` but on a changed order. * `CANCELLED` is used when the order is cancelled. This could be acustomer initiated cancel or based on Fraud recommendation. * `FAILED` is used when order failed due to any errors on Partner system. This could be followed by another OrderUpdate call with any `order_status` once the order is recovered, abandoned, or cancelled. * `CHANGE_FAILED` is like `FAILED` but on a changed order. * * `CHANGE_COMPLETED` or `CHANGE_FAILED` are applicable if OrderPurchaseScreen Fraud API was called via a change in order which is through `transaction.transaction_details.order_type` = `CHANGE` * `COMPLETED` or `CANCELLED` order status indicates the completion of lifecycle on an order. Values: COMPLETED,CHANGE_COMPLETED,CANCELLED,FAILED,CHANGE_FAILED |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [Status](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Status](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
