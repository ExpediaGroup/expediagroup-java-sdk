//[openworld-java-sdk-fraudpreventionv2](../../../../index.md)/[com.expediagroup.openworld.sdk.fraudpreventionv2.models](../../index.md)/[TransactionDetails](../index.md)/[OrderType](index.md)

# OrderType

[JVM]\
public enum [OrderType](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[TransactionDetails.OrderType](index.md)&gt;

Type of order. Possible `order_types`.  `CREATE` - Initial type of a brand new order.  `CHANGE` - If a `OrderPurchaseScreenRequest` has already been submitted for the initial booking with `order_type = CREATE`, but has now been modified and partner wishes to resubmit for Fraud screening then the `order_type = CHANGE`. Examples of changes that are supported are changes made to `check-in/checkout dates` or `price of a TravelProduct`. Values: CREATE,CHANGE

## Entries

| | |
|---|---|
| [CREATE](-c-r-e-a-t-e/index.md) | [JVM]<br>[CREATE](-c-r-e-a-t-e/index.md) |
| [CHANGE](-c-h-a-n-g-e/index.md) | [JVM]<br>[CHANGE](-c-h-a-n-g-e/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getName](index.md#-1412449409%2FFunctions%2F-1883119931) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getName](index.md#-1412449409%2FFunctions%2F-1883119931)() |
| [getOrdinal](index.md#-1011415201%2FFunctions%2F-1883119931) | [JVM]<br>public final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[getOrdinal](index.md#-1011415201%2FFunctions%2F-1883119931)() |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [TransactionDetails.OrderType](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[TransactionDetails.OrderType](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |

## Properties

| Name | Summary |
|---|---|
| [name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[name](../../-verification-type/_3_-d-s/index.md#-372974862%2FProperties%2F-1883119931) |
| [ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) | [JVM]<br>private final [Integer](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html)[ordinal](../../-verification-type/_3_-d-s/index.md#-739389684%2FProperties%2F-1883119931) |
| [value](-c-h-a-n-g-e/index.md#628371494%2FProperties%2F-1883119931) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](-c-h-a-n-g-e/index.md#628371494%2FProperties%2F-1883119931) |
