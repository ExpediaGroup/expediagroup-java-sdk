//[xap-sdk](../../../../index.md)/[com.expediagroup.sdk.xap.models](../../index.md)/[RatePlan](../index.md)/[PaymentMethod](index.md)

# PaymentMethod

[JVM]\
public enum [PaymentMethod](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[RatePlan.PaymentMethod](index.md)&gt;

Room payment information. The available options are: - Online: Pay at the time of booking - Hotel: Could either be paid at the hotel during the time of stay or paid at the time indicated by `PaymentTime` and `PaymentSchedule` Values: ONLINE,HOTEL

## Entries

| | |
|---|---|
| [ONLINE](-o-n-l-i-n-e/index.md) | [JVM]<br>[ONLINE](-o-n-l-i-n-e/index.md) |
| [HOTEL](-h-o-t-e-l/index.md) | [JVM]<br>[HOTEL](-h-o-t-e-l/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#1320991686%2FProperties%2F699445674) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[RatePlan.PaymentMethod](index.md)&gt;[entries](index.md#1320991686%2FProperties%2F699445674)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#-659419067%2FProperties%2F699445674) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#-659419067%2FProperties%2F699445674) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[RatePlan.PaymentMethod](index.md)&gt;[getEntries](get-entries.md)()<br>Room payment information. The available options are: - Online: Pay at the time of booking - Hotel: Could either be paid at the hotel during the time of stay or paid at the time indicated by `PaymentTime` and `PaymentSchedule` Values: ONLINE,HOTEL |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [RatePlan.PaymentMethod](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[RatePlan.PaymentMethod](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
