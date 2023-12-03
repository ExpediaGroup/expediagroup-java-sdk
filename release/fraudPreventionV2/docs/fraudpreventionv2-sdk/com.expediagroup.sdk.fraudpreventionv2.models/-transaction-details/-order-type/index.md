//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[TransactionDetails](../index.md)/[OrderType](index.md)

# OrderType

[JVM]\
public enum [OrderType](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[TransactionDetails.OrderType](index.md)&gt;

Type of order. Possible `order_types`.  `CREATE` - Initial type of a brand new order.  `CHANGE` - If a `OrderPurchaseScreenRequest` has already been submitted for the initial booking with `order_type = CREATE`, but has now been modified and partner wishes to resubmit for Fraud screening then the `order_type = CHANGE`. Examples of changes that are supported are changes made to `check-in/checkout dates` or `price of a TravelProduct`. Values: CREATE,CHANGE

## Entries

| | |
|---|---|
| [CREATE](-c-r-e-a-t-e/index.md) | [JVM]<br>[CREATE](-c-r-e-a-t-e/index.md) |
| [CHANGE](-c-h-a-n-g-e/index.md) | [JVM]<br>[CHANGE](-c-h-a-n-g-e/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#775264449%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[TransactionDetails.OrderType](index.md)&gt;[entries](index.md#775264449%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#220459008%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#220459008%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[TransactionDetails.OrderType](index.md)&gt;[getEntries](get-entries.md)()<br>Type of order. Possible `order_types`.  `CREATE` - Initial type of a brand new order.  `CHANGE` - If a `OrderPurchaseScreenRequest` has already been submitted for the initial booking with `order_type = CREATE`, but has now been modified and partner wishes to resubmit for Fraud screening then the `order_type = CHANGE`. Examples of changes that are supported are changes made to `check-in/checkout dates` or `price of a TravelProduct`. Values: CREATE,CHANGE |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [TransactionDetails.OrderType](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[TransactionDetails.OrderType](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
