//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[PaymentReason](index.md)

# PaymentReason

[JVM]\
public enum [PaymentReason](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[PaymentReason](index.md)&gt;

The reason of payment. Possible values: - `FULL` - If the amount is paid i full for the order - `DEPOSIT` - The initial payment. Amount to be paid up front. - `SCHEDULED` - The amount to be payment based on a schedule for the remaining portion of the booking amount. - `SUBSEQUENT` - An additional amount paid that was not originally scheduled. - `DEFERRED` Values: FULL,DEPOSIT,SCHEDULED,SUBSEQUENT,DEFERRED

## Entries

| | |
|---|---|
| [FULL](-f-u-l-l/index.md) | [JVM]<br>[FULL](-f-u-l-l/index.md) |
| [DEPOSIT](-d-e-p-o-s-i-t/index.md) | [JVM]<br>[DEPOSIT](-d-e-p-o-s-i-t/index.md) |
| [SCHEDULED](-s-c-h-e-d-u-l-e-d/index.md) | [JVM]<br>[SCHEDULED](-s-c-h-e-d-u-l-e-d/index.md) |
| [SUBSEQUENT](-s-u-b-s-e-q-u-e-n-t/index.md) | [JVM]<br>[SUBSEQUENT](-s-u-b-s-e-q-u-e-n-t/index.md) |
| [DEFERRED](-d-e-f-e-r-r-e-d/index.md) | [JVM]<br>[DEFERRED](-d-e-f-e-r-r-e-d/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-1326580273%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[PaymentReason](index.md)&gt;[entries](index.md#-1326580273%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#1764638862%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#1764638862%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[PaymentReason](index.md)&gt;[getEntries](get-entries.md)()<br>The reason of payment. Possible values: - `FULL` - If the amount is paid i full for the order - `DEPOSIT` - The initial payment. Amount to be paid up front. - `SCHEDULED` - The amount to be payment based on a schedule for the remaining portion of the booking amount. - `SUBSEQUENT` - An additional amount paid that was not originally scheduled. - `DEFERRED` Values: FULL,DEPOSIT,SCHEDULED,SUBSEQUENT,DEFERRED |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [PaymentReason](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[PaymentReason](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
