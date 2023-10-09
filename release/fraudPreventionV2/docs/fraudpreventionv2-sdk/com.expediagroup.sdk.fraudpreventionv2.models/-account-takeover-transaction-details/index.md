//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[AccountTakeoverTransactionDetails](index.md)

# AccountTakeoverTransactionDetails

public interface [AccountTakeoverTransactionDetails](index.md)

The `transaction_type` field value is used as a discriminator, with the following mapping: * `LOGIN`: `LoginTransactionDetails`

#### Parameters

JVM

| | |
|---|---|
| type | The categorized type of account event related to a user's action. |
| transactionDateTime | The local date and time the transaction occured in the Partner's system, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| transactionId | Unique identifier to identify a transaction attempt in the Partner's system. |
| currentUserSession |

#### Inheritors

| |
|---|
| [LoginTransactionDetails](../-login-transaction-details/index.md) |

## Types

| Name | Summary |
|---|---|
| [Type](-type/index.md) | [JVM]<br>public enum [Type](-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AccountTakeoverTransactionDetails.Type](-type/index.md)&gt;<br>The categorized type of account event related to a user's action. Values: LOGIN |

## Functions

| Name | Summary |
|---|---|
| [getCurrentUserSession](get-current-user-session.md) | [JVM]<br>public abstract [CurrentUserSession](../-current-user-session/index.md)[getCurrentUserSession](get-current-user-session.md)() |
| [getTransactionDateTime](get-transaction-date-time.md) | [JVM]<br>public abstract [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getTransactionDateTime](get-transaction-date-time.md)() |
| [getTransactionId](get-transaction-id.md) | [JVM]<br>public abstract [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getTransactionId](get-transaction-id.md)() |
| [getType](get-type.md) | [JVM]<br>public abstract [AccountTakeoverTransactionDetails.Type](-type/index.md)[getType](get-type.md)() |
