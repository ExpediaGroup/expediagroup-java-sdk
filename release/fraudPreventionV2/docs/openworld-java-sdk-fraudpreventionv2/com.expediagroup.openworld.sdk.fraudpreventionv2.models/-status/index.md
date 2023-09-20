//[openworld-java-sdk-fraudpreventionv2](../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../index.md)/[Status](index.md)

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

## Functions

| Name | Summary |
|---|---|
| [getName](index.md#-1219820757%2FFunctions%2F-1883119931) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#-1219820757%2FFunctions%2F-1883119931)() |
| [getOrdinal](index.md#-487550925%2FFunctions%2F-1883119931) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#-487550925%2FFunctions%2F-1883119931)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [Status](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Status](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) |
| [ordinal](../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) |
| [value](-c-h-a-n-g-e_-f-a-i-l-e-d/index.md#-1241231854%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-c-h-a-n-g-e_-f-a-i-l-e-d/index.md#-1241231854%2FProperties%2F-1883119931) |
