//[fraudpreventionv2-sdk](../../../index.md)/[com.expediagroup.sdk.fraudpreventionv2.models](../index.md)/[AccountTakeoverCustomerAccount](index.md)/[AccountTakeoverCustomerAccount](-account-takeover-customer-account.md)

# AccountTakeoverCustomerAccount

[JVM]\

public [AccountTakeoverCustomerAccount](index.md)[AccountTakeoverCustomerAccount](-account-takeover-customer-account.md)([String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)userId, [AccountTakeoverCustomerAccount.AccountType](-account-type/index.md)accountType, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)username, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)emailAddress, [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)registeredTime, [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)activeFlag, [AccountTakeoverCustomerAccount.AccountRole](-account-role/index.md)accountRole, [AccountTakeoverName](../-account-takeover-name/index.md)name, [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)&lt;[Telephone](../-telephone/index.md)&gt;telephones, [CustomerAccountAddress](../-customer-account-address/index.md)address, [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)loyaltyMemberId)

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
