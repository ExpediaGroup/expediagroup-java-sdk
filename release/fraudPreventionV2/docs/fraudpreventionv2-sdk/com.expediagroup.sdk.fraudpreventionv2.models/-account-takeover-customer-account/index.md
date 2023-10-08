//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[AccountTakeoverCustomerAccount](index.md)

# AccountTakeoverCustomerAccount

public final class [AccountTakeoverCustomerAccount](index.md)

Information about a user's account.

#### Parameters

JVM

| | |
|---|---|
| userId | Unique account identifier provided by the Partner's Identity Provider/System assigned to the account owner by the partner. `user_id` is specific to the Partner's namespace. Used to track repeat account activity by the same user. |
| accountType | Identifies the account type of a user''s account. Possible values are: - `INDIVIDUAL` - Applicable if this account is for an individual traveler. - `BUSINESS` - Applicable if this account is for a business or organization account used by suppliers or Partners. |
| username | Username of the account. |
| emailAddress | Email address for the account owner. |
| registeredTime | The local date and time that the customer first registered on the Partner's site, in ISO-8601 date and time format `yyyy-MM-ddTHH:mm:ss.SSSZ`. |
| activeFlag | Indicator for if this account is an active account or not. |
| accountRole | Identifies the account role and associated permissions of a user''s account. Possible values are: - `USER`: Basic account with no special privileges. - `MANAGER`: Account with additional privileges, such as the ability to make bookings for others. - `ADMIN`: Account with higher privileges than a manager, including the ability to grant manager access to other users. |
| name |
| telephones |
| address |
| loyaltyMemberId | Unique loyalty identifier for a user. |

## Constructors

| | |
|---|---|
| [AccountTakeoverCustomerAccount](-account-takeover-customer-account.md) | [JVM]<br>public [AccountTakeoverCustomerAccount](index.md)[AccountTakeoverCustomerAccount](-account-takeover-customer-account.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)userId, [AccountTakeoverCustomerAccount.AccountType](-account-type/index.md)accountType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)username, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)emailAddress, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)registeredTime, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)activeFlag, [AccountTakeoverCustomerAccount.AccountRole](-account-role/index.md)accountRole, [AccountTakeoverName](../-account-takeover-name/index.md)name, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [CustomerAccountAddress](../-customer-account-address/index.md)address, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)loyaltyMemberId) |

## Types

| Name | Summary |
|---|---|
| [AccountRole](-account-role/index.md) | [JVM]<br>public enum [AccountRole](-account-role/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AccountTakeoverCustomerAccount.AccountRole](-account-role/index.md)&gt;<br>Identifies the account role and associated permissions of a user''s account. Possible values are: - `USER`: Basic account with no special privileges. - `MANAGER`: Account with additional privileges, such as the ability to make bookings for others. - `ADMIN`: Account with higher privileges than a manager, including the ability to grant manager access to other users. Values: USER,MANAGER,ADMIN |
| [AccountType](-account-type/index.md) | [JVM]<br>public enum [AccountType](-account-type/index.md) extends [Enum](https://docs.oracle.com/javase/8/docs/api/java/lang/Enum.html)&lt;[AccountTakeoverCustomerAccount.AccountType](-account-type/index.md)&gt;<br>Identifies the account type of a user''s account. Possible values are: - `INDIVIDUAL` - Applicable if this account is for an individual traveler. - `BUSINESS` - Applicable if this account is for a business or organization account used by suppliers or Partners. Values: INDIVIDUAL,BUSINESS |
| [Builder](-builder/index.md) | [JVM]<br>public final class [Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [accountRole](index.md#-1468265787%2FProperties%2F-173342751) | [JVM]<br>private final [AccountTakeoverCustomerAccount.AccountRole](-account-role/index.md)[accountRole](index.md#-1468265787%2FProperties%2F-173342751) |
| [accountType](index.md#1217028225%2FProperties%2F-173342751) | [JVM]<br>private final [AccountTakeoverCustomerAccount.AccountType](-account-type/index.md)[accountType](index.md#1217028225%2FProperties%2F-173342751) |
| [activeFlag](index.md#-265110240%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[activeFlag](index.md#-265110240%2FProperties%2F-173342751) |
| [address](index.md#938775988%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [CustomerAccountAddress](../-customer-account-address/index.md)[address](index.md#938775988%2FProperties%2F-173342751) |
| [emailAddress](index.md#-902432390%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[emailAddress](index.md#-902432390%2FProperties%2F-173342751) |
| [loyaltyMemberId](index.md#1099087053%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[loyaltyMemberId](index.md#1099087053%2FProperties%2F-173342751) |
| [name](index.md#-181385209%2FProperties%2F-173342751) | [JVM]<br>@Valid()<br>private final [AccountTakeoverName](../-account-takeover-name/index.md)[name](index.md#-181385209%2FProperties%2F-173342751) |
| [registeredTime](index.md#1661388899%2FProperties%2F-173342751) | [JVM]<br>private final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[registeredTime](index.md#1661388899%2FProperties%2F-173342751) |
| [telephones](index.md#-58932637%2FProperties%2F-173342751) | [JVM]<br>@Size(max = 20)<br>@Valid()<br>private final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[telephones](index.md#-58932637%2FProperties%2F-173342751) |
| [userId](index.md#557474668%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[userId](index.md#557474668%2FProperties%2F-173342751) |
| [username](index.md#467931548%2FProperties%2F-173342751) | [JVM]<br>@Length(max = 200)<br>@Valid()<br>private final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[username](index.md#467931548%2FProperties%2F-173342751) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [JVM]<br>public final static [AccountTakeoverCustomerAccount.Builder](-builder/index.md)[builder](builder.md)() |
| [getAccountRole](get-account-role.md) | [JVM]<br>public final [AccountTakeoverCustomerAccount.AccountRole](-account-role/index.md)[getAccountRole](get-account-role.md)() |
| [getAccountType](get-account-type.md) | [JVM]<br>public final [AccountTakeoverCustomerAccount.AccountType](-account-type/index.md)[getAccountType](get-account-type.md)() |
| [getActiveFlag](get-active-flag.md) | [JVM]<br>public final [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)[getActiveFlag](get-active-flag.md)() |
| [getAddress](get-address.md) | [JVM]<br>public final [CustomerAccountAddress](../-customer-account-address/index.md)[getAddress](get-address.md)() |
| [getEmailAddress](get-email-address.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getEmailAddress](get-email-address.md)() |
| [getLoyaltyMemberId](get-loyalty-member-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getLoyaltyMemberId](get-loyalty-member-id.md)() |
| [getName](get-name.md) | [JVM]<br>public final [AccountTakeoverName](../-account-takeover-name/index.md)[getName](get-name.md)() |
| [getRegisteredTime](get-registered-time.md) | [JVM]<br>public final [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)[getRegisteredTime](get-registered-time.md)() |
| [getTelephones](get-telephones.md) | [JVM]<br>public final [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;[getTelephones](get-telephones.md)() |
| [getUserId](get-user-id.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getUserId](get-user-id.md)() |
| [getUsername](get-username.md) | [JVM]<br>public final [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)[getUsername](get-username.md)() |
