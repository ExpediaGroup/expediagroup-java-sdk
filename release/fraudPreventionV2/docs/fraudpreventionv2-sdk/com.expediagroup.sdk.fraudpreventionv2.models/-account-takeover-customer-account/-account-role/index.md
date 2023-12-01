//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[AccountTakeoverCustomerAccount](../index.md)/[AccountRole](index.md)

# AccountRole

[JVM]\
public enum [AccountRole](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AccountTakeoverCustomerAccount.AccountRole](index.md)&gt;

Identifies the account role and associated permissions of a user''s account. Possible values are: - `USER`: Basic account with no special privileges. - `MANAGER`: Account with additional privileges, such as the ability to make bookings for others. - `ADMIN`: Account with higher privileges than a manager, including the ability to grant manager access to other users. Values: USER,MANAGER,ADMIN

## Entries

| | |
|---|---|
| [USER](-u-s-e-r/index.md) | [JVM]<br>[USER](-u-s-e-r/index.md) |
| [MANAGER](-m-a-n-a-g-e-r/index.md) | [JVM]<br>[MANAGER](-m-a-n-a-g-e-r/index.md) |
| [ADMIN](-a-d-m-i-n/index.md) | [JVM]<br>[ADMIN](-a-d-m-i-n/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-1276193277%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[AccountTakeoverCustomerAccount.AccountRole](index.md)&gt;[entries](index.md#-1276193277%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#-416311870%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#-416311870%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[AccountTakeoverCustomerAccount.AccountRole](index.md)&gt;[getEntries](get-entries.md)()<br>Identifies the account role and associated permissions of a user''s account. Possible values are: - `USER`: Basic account with no special privileges. - `MANAGER`: Account with additional privileges, such as the ability to make bookings for others. - `ADMIN`: Account with higher privileges than a manager, including the ability to grant manager access to other users. Values: USER,MANAGER,ADMIN |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [AccountTakeoverCustomerAccount.AccountRole](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[AccountTakeoverCustomerAccount.AccountRole](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
