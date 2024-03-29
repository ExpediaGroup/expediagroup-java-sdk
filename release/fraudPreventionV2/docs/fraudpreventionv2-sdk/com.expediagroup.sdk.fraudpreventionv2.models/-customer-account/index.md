//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[CustomerAccount](index.md)

# CustomerAccount

public final class [CustomerAccount](index.md)

#### Parameters

JVM

| | |
|---|---|
| accountType | Identifies if the customer account is known to the client. Possible values are:  -`GUEST` - Applicable if the partner maintains record to distinguish whether the transaction was booked via a guest account.  -`STANDARD` - Default account type. |
| name |
| emailAddress | Email address for the account owner. |
| userId | Unique account identifier provided by the partner's Identity Provider/System assigned to the account owner by the partner. `user_id` is specific to the partner namespace. Used to track repeat purchases by the same user. |
| telephones |
| address |
| registeredTime | The local date and time that the customer first registered on the client site, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |

## Constructors

| | |
|---|---|
| [CustomerAccount](-customer-account.md) | [JVM]<br>public [CustomerAccount](index.md)[CustomerAccount](-customer-account.md)([CustomerAccount.AccountType](-account-type/index.md)accountType, [Name](../-name/index.md)name, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)emailAddress, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)userId, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [CustomerAccountAddress](../-customer-account-address/index.md)address, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)registeredTime) |

## Types

| Name | Summary |
|---|---|
| [AccountType](-account-type/index.md) | [JVM]<br>public enum [AccountType](-account-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[CustomerAccount.AccountType](-account-type/index.md)&gt;<br>Identifies if the customer account is known to the client. Possible values are:  -`GUEST` - Applicable if the partner maintains record to distinguish whether the transaction was booked via a guest account.  -`STANDARD` - Default account type. Values: GUEST,STANDARD |
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [accountType](index.md#-1185797741%2FProperties%2F-173342751) | [JVM]<br>private final [CustomerAccount.AccountType](-account-type/index.md)[accountType](index.md#-1185797741%2FProperties%2F-173342751) |
| [address](index.md#-702564410%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [CustomerAccountAddress](../-customer-account-address/index.md)[address](index.md#-702564410%2FProperties%2F-173342751) |
| [emailAddress](index.md#1919373992%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[emailAddress](index.md#1919373992%2FProperties%2F-173342751) |
| [name](index.md#1819062069%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Name](../-name/index.md)[name](index.md#1819062069%2FProperties%2F-173342751) |
| [registeredTime](index.md#-1002009071%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[registeredTime](index.md#-1002009071%2FProperties%2F-173342751) |
| [telephones](index.md#971935505%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[telephones](index.md#971935505%2FProperties%2F-173342751) |
| [userId](index.md#-1158039782%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[userId](index.md#-1158039782%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [CustomerAccount.Builder](-builder/index.md)[builder](builder.md)() |
| [getAccountType](get-account-type.md) | [JVM]<br>public final [CustomerAccount.AccountType](-account-type/index.md)[getAccountType](get-account-type.md)() |
| [getAddress](get-address.md) | [JVM]<br>public final [CustomerAccountAddress](../-customer-account-address/index.md)[getAddress](get-address.md)() |
| [getEmailAddress](get-email-address.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEmailAddress](get-email-address.md)() |
| [getName](get-name.md) | [JVM]<br>public final [Name](../-name/index.md)[getName](get-name.md)() |
| [getRegisteredTime](get-registered-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getRegisteredTime](get-registered-time.md)() |
| [getTelephones](get-telephones.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[getTelephones](get-telephones.md)() |
| [getUserId](get-user-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getUserId](get-user-id.md)() |
