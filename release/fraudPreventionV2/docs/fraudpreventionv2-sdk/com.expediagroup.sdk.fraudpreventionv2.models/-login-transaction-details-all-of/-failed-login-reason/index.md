//[fraudpreventionv2-sdk](../../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../../index.md)/[LoginTransactionDetailsAllOf](../index.md)/[FailedLoginReason](index.md)

# FailedLoginReason

[JVM]\
public enum [FailedLoginReason](index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[LoginTransactionDetailsAllOf.FailedLoginReason](index.md)&gt;

The reason for the failed login attempt in the Partner''s system, related to user failure or Partner''s system failure. - `INVALID_CREDENTIALS` - Applicable if the user provided invalid login credentials for this login attempt. - `ACCOUNT_NOT_FOUND` - Applicable if the user attempted to login to an account that doesn't exist. - `VERIFICATION_FAILED` - Applicable if the user failed the verification for this login, or any authentication exception occured in the Partner system for this login attempt. - `ACCOUNT_LOCKED` - Applicable if the user attempted to login to an account that is locked. Values: INVALID_CREDENTIALS,ACCOUNT_NOT_FOUND,VERIFICATION_FAILED,ACCOUNT_LOCKED

## Entries

| | |
|---|---|
| [INVALID_CREDENTIALS](-i-n-v-a-l-i-d_-c-r-e-d-e-n-t-i-a-l-s/index.md) | [JVM]<br>[INVALID_CREDENTIALS](-i-n-v-a-l-i-d_-c-r-e-d-e-n-t-i-a-l-s/index.md) |
| [ACCOUNT_NOT_FOUND](-a-c-c-o-u-n-t_-n-o-t_-f-o-u-n-d/index.md) | [JVM]<br>[ACCOUNT_NOT_FOUND](-a-c-c-o-u-n-t_-n-o-t_-f-o-u-n-d/index.md) |
| [VERIFICATION_FAILED](-v-e-r-i-f-i-c-a-t-i-o-n_-f-a-i-l-e-d/index.md) | [JVM]<br>[VERIFICATION_FAILED](-v-e-r-i-f-i-c-a-t-i-o-n_-f-a-i-l-e-d/index.md) |
| [ACCOUNT_LOCKED](-a-c-c-o-u-n-t_-l-o-c-k-e-d/index.md) | [JVM]<br>[ACCOUNT_LOCKED](-a-c-c-o-u-n-t_-l-o-c-k-e-d/index.md) |

## Properties

| Name | Summary |
|---|---|
| [entries](index.md#-563382862%2FProperties%2F-173342751) | [JVM]<br>private final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[LoginTransactionDetailsAllOf.FailedLoginReason](index.md)&gt;[entries](index.md#-563382862%2FProperties%2F-173342751)<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| [value](index.md#576607537%2FProperties%2F-173342751) | [JVM]<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[value](index.md#576607537%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [getEntries](get-entries.md) | [JVM]<br>public final [EnumEntries](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.enums/-enum-entries/index.html)&lt;[LoginTransactionDetailsAllOf.FailedLoginReason](index.md)&gt;[getEntries](get-entries.md)()<br>The reason for the failed login attempt in the Partner''s system, related to user failure or Partner''s system failure. - `INVALID_CREDENTIALS` - Applicable if the user provided invalid login credentials for this login attempt. - `ACCOUNT_NOT_FOUND` - Applicable if the user attempted to login to an account that doesn't exist. - `VERIFICATION_FAILED` - Applicable if the user failed the verification for this login, or any authentication exception occured in the Partner system for this login attempt. - `ACCOUNT_LOCKED` - Applicable if the user attempted to login to an account that is locked. Values: INVALID_CREDENTIALS,ACCOUNT_NOT_FOUND,VERIFICATION_FAILED,ACCOUNT_LOCKED |
| [getValue](get-value.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getValue](get-value.md)() |
| [valueOf](value-of.md) | [JVM]<br>public final [LoginTransactionDetailsAllOf.FailedLoginReason](index.md)[valueOf](value-of.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)value)<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| [values](values.md) | [JVM]<br>public final [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[LoginTransactionDetailsAllOf.FailedLoginReason](index.md)&gt;[values](values.md)()<br>Returns an array containing the constants of this enum type, in the order they're declared. |
